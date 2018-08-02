package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.ApparatusClassifyDao;
import tsxy.bsjz.platform.dao.ApparatusDao;
import tsxy.bsjz.platform.dao.vo.ApparatusClassifySearchDto;
import tsxy.bsjz.platform.model.ApparatusClassify;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.ApparatusClassifyService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--10:01
 */
@Service
@Transactional
public class ApparatusClassifyServiceImpl implements ApparatusClassifyService {
    @Autowired
    private ApparatusClassifyDao apparatusClassifyDao;
    @Autowired
    private ApparatusDao apparatusDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Override
    public void insertIntoApparatusClassify(ApparatusClassify apparatusClassify) throws BusinessException {
        try {
            if(apparatusClassify.getId() != null){
                apparatusClassifyDao.updateApparatusClassify(apparatusClassify);
            }else{
                apparatusClassifyDao.insertIntoApparatusClassify(apparatusClassify);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.APPTUSCLASSIFY_ADD+apparatusClassify.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加仪器分类失败",e.getMessage());
        }
    }

    @Override
    public void deleteApparatusClassifyByIds(List<Integer> ids) throws BusinessException {
        try {
            apparatusClassifyDao.deleteApparatusClassifyByIds(ids);
            //当仪器分类被删除的时候  清空已经和这些分类建立关系的 仪器中字段
            apparatusDao.updateClassifyNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.APPTUSCLASSIFY_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除仪器分类失败",e.getMessage());
        }
    }

    @Override
    public void updateApparatusClassify(ApparatusClassify apparatusClassify) throws BusinessException {
        try {
            apparatusClassifyDao.updateApparatusClassify(apparatusClassify);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.APPTUSCLASSIFY_UPDATE+apparatusClassify.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改仪器分类失败",e.getMessage());
        }
    }

    @Override
    public PageBean<ApparatusClassify> selectAllApparatusClassify(ApparatusClassifySearchDto apparatusClassifySearchDto) throws BusinessException {
        try {
            PageHelper.startPage(apparatusClassifySearchDto.getPageNum(), apparatusClassifySearchDto.getPageSize());
            List<ApparatusClassify> apparatusClassifyList = apparatusClassifyDao.selectAllApparatusClassify(apparatusClassifySearchDto);
            Integer countNums = apparatusClassifyDao.selectCountByExample(apparatusClassifySearchDto);
            PageBean<ApparatusClassify> pageData = new PageBean<>(apparatusClassifySearchDto.getPageNum(), apparatusClassifySearchDto.getPageSize(), countNums);
            pageData.setItems(apparatusClassifyList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部仪器分类失败",e.getMessage());
        }
    }

    @Override
    public List<ApparatusClassify> selectAllApparatusClassifyList() throws BusinessException {
        try {
            return apparatusClassifyDao.selectAllApparatusClassifyList();
        }catch (Exception e){
            throw new BusinessException("查询全部仪器分类失败",e.getMessage());
        }
    }
}
