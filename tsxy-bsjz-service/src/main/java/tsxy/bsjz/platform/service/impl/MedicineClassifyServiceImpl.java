package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.MedicineClassifyDao;
import tsxy.bsjz.platform.dao.MedicineDao;
import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.MedicineClassify;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.MedicineClassifyService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:07
 */
@Service
@Transactional
public class MedicineClassifyServiceImpl implements MedicineClassifyService {
    @Autowired
    private MedicineClassifyDao medicineClassifyDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private MedicineDao medicineDao;
    @Override
    public void insertIntoClassify(MedicineClassify medicineClassify) throws BusinessException {
        try {
            if(medicineClassify.getId() != null){
                medicineClassifyDao.updateClassify(medicineClassify);
            }else{
                medicineClassifyDao.insertIntoClassify(medicineClassify);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.CLASSIFY_ADD+medicineClassify.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加药品分类失败",e.getMessage());
        }
    }

    @Override
    public void deleteClassifyByIds(List<Integer> ids) throws BusinessException {
        try {
            medicineClassifyDao.deleteClassifyByIds(ids);
            //当药品分类被删除的时候  清空已经和这些药品分类建立关系的 药品中字段
            medicineDao.updateMedicineClassifyNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.CLASSIFY_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除药品分类失败",e.getMessage());
        }
    }

    @Override
    public void updateClassify(MedicineClassify medicineClassify) throws BusinessException {
        try {
            medicineClassifyDao.updateClassify(medicineClassify);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.CLASSIFY_UPDATE+medicineClassify.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改药品分类失败",e.getMessage());
        }
    }

    @Override
    public PageBean<MedicineClassify> selectAllClassify(MedicinePublicDto medicinePublicDto) throws BusinessException {
        try {
            PageHelper.startPage(medicinePublicDto.getPageNum(), medicinePublicDto.getPageSize());
            List<MedicineClassify> classifyList = medicineClassifyDao.selectAllClassify(medicinePublicDto);//全部
            Integer countNums = medicineClassifyDao.selectCountByExample(medicinePublicDto);//总数
            PageBean<MedicineClassify> pageData = new PageBean<>(medicinePublicDto.getPageNum(), medicinePublicDto.getPageSize(), countNums);
            pageData.setItems(classifyList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询药品分类失败",e.getMessage());
        }
    }

    @Override
    public List<MedicineClassify> selectAllClassifyList() throws BusinessException {
        try {
            return medicineClassifyDao.selectAllClassifyList();
        }catch (Exception e){
            throw new BusinessException("查询全部药品分类失败",e.getMessage());
        }
    }
}
