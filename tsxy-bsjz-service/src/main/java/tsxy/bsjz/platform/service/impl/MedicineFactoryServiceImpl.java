package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.MedicineDao;
import tsxy.bsjz.platform.dao.MedicineFactoryDao;
import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.MedicineFactory;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.MedicineFactoryService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:09
 */
@Service
@Transactional
public class MedicineFactoryServiceImpl implements MedicineFactoryService {
    @Autowired
    private MedicineFactoryDao medicineFactoryDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private MedicineDao medicineDao;
    @Override
    public void insertIntoFactory(MedicineFactory medicineFactory) throws BusinessException {
        try {
            if(medicineFactory.getId() != null){
                medicineFactoryDao.updateFactory(medicineFactory);
            }else{
                medicineFactoryDao.insertIntoFactory(medicineFactory);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.FACTORY_ADD+medicineFactory.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加药品厂家失败",e.getMessage());
        }
    }

    @Override
    public void deleteFactoryByIds(List<Integer> ids) throws BusinessException {
        try {
            medicineFactoryDao.deleteFactoryByIds(ids);
            //当厂家名称被删除的时候  清空已经和这些厂家名称建立关系的 药品中字段
            medicineDao.updateMedicineFactoryNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.FACTORY_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除药品厂家失败",e.getMessage());
        }
    }

    @Override
    public void updateFactory(MedicineFactory medicineFactory) throws BusinessException {
        try {
            medicineFactoryDao.updateFactory(medicineFactory);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.FACTORY_UPDATE+medicineFactory.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改药品厂家失败",e.getMessage());
        }
    }

    @Override
    public PageBean<MedicineFactory> selectAllFactory(MedicinePublicDto medicinePublicDto) throws BusinessException {
        try {
            PageHelper.startPage(medicinePublicDto.getPageNum(), medicinePublicDto.getPageSize());
            List<MedicineFactory> factoryList = medicineFactoryDao.selectAllFactory(medicinePublicDto);//全部
            Integer countNums = medicineFactoryDao.selectCountByExample(medicinePublicDto);//总数
            PageBean<MedicineFactory> pageData = new PageBean<>(medicinePublicDto.getPageNum(), medicinePublicDto.getPageSize(), countNums);
            pageData.setItems(factoryList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询药品厂家失败",e.getMessage());
        }
    }

    @Override
    public List<MedicineFactory> selectAllFactoryList() throws BusinessException {
        try {
            return medicineFactoryDao.selectAllFactoryList();
        }catch (Exception e){
            throw new BusinessException("查询全部药品厂家失败",e.getMessage());
        }
    }
}
