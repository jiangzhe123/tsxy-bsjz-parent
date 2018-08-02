package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.ApparatusDao;
import tsxy.bsjz.platform.dao.vo.ApparatusSearchDto;
import tsxy.bsjz.platform.model.Apparatus;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.ApparatusService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--9:55
 */
@Service
@Transactional
public class ApparatusServiceImpl implements ApparatusService {
    @Autowired
    private ApparatusDao apparatusDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Override
    public void insertIntoApparatus(Apparatus apparatus) throws BusinessException {
        try {
            if(apparatus.getId() != null){
                apparatusDao.updateApparatus(apparatus);
            }else{
                apparatusDao.insertIntoApparatus(apparatus);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.APPTUS_ADD+apparatus.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加仪器失败",e.getMessage());
        }
    }

    @Override
    public void deleteApparatusByIds(List<Integer> ids) throws BusinessException {
        try {
            apparatusDao.deleteApparatusByIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.APPTUS_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除仪器失败",e.getMessage());
        }
    }

    @Override
    public void updateApparatus(Apparatus apparatus) throws BusinessException {
        try {
            apparatusDao.updateApparatus(apparatus);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.APPTUS_UPDATE+apparatus.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改仪器失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Apparatus> selectAllApparatus(ApparatusSearchDto apparatusSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(apparatusSearchDto.getPageNum(), apparatusSearchDto.getPageSize());
            List<Apparatus> apparatusList = apparatusDao.selectAllApparatus(apparatusSearchDto);//集合
            Integer countNums = apparatusDao.selectCountByExample(apparatusSearchDto);//总数
            PageBean<Apparatus> pageData = new PageBean<>(apparatusSearchDto.getPageNum(), apparatusSearchDto.getPageSize(), countNums);
            pageData.setItems(apparatusList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部仪器失败",e.getMessage());
        }
    }
}
