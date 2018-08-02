package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.SickbedDao;
import tsxy.bsjz.platform.dao.vo.SickbedCountDto;
import tsxy.bsjz.platform.dao.vo.SickbedSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Sickbed;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.SickbedService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/2--10:17
 */
@Service
@Transactional
public class SickbedServiceImpl implements SickbedService {
    @Autowired
    private SickbedDao sickbedDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Override
    public void insertIntoSickbed(Sickbed sickbed) throws BusinessException {
        try {
            if(sickbed.getId() != null){
                sickbedDao.updateSickbed(sickbed);
            }else{
                sickbedDao.insertIntoSickbed(sickbed);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.SICKBED_ADD+sickbed.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加病床失败",e.getMessage());
        }
    }

    @Override
    public void deleteSickbedByIds(List<Integer> ids) throws BusinessException {
        try {
            sickbedDao.deleteSickbedByIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.SICKBED_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除病床失败",e.getMessage());
        }
    }

    @Override
    public void updateSickbed(Sickbed sickbed) throws BusinessException {
        try {
            sickbedDao.updateSickbed(sickbed);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.SICKBED_UPDATE+sickbed.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改病床失败",e.getMessage());
        }
    }

    @Override
    public void updatePatientNull(Integer id) throws BusinessException {
        try {
            sickbedDao.updatePatientNull(id);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.SICKBED_UPDATENULL);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("清空病床失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Sickbed> selectAllSickbed(SickbedSearchDto sickbedSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(sickbedSearchDto.getPageNum(), sickbedSearchDto.getPageSize());
            List<Sickbed> sickbedList = sickbedDao.selectAllSickbed(sickbedSearchDto);//集合
            Integer countNums = sickbedDao.selectCountByExample(sickbedSearchDto);//总数
            PageBean<Sickbed> pageData = new PageBean<>(sickbedSearchDto.getPageNum(), sickbedSearchDto.getPageSize(), countNums);
            pageData.setItems(sickbedList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部非空病床失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Sickbed> selectAllNullSickbed(SickbedSearchDto sickbedSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(sickbedSearchDto.getPageNum(), sickbedSearchDto.getPageSize());
            List<Sickbed> sickbedList = sickbedDao.selectAllNullSickbed(sickbedSearchDto);//集合
            Integer countNums = sickbedDao.selectCountNullByExample(sickbedSearchDto);//总数
            PageBean<Sickbed> pageData = new PageBean<>(sickbedSearchDto.getPageNum(), sickbedSearchDto.getPageSize(), countNums);
            pageData.setItems(sickbedList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部空病床失败",e.getMessage());
        }
    }

    @Override
    public SickbedCountDto selectSickbedCountDto() throws BusinessException {
        try {
            return sickbedDao.selectSickbedCountDto();
        }catch (Exception e){
            throw new BusinessException("查询视图病床之空不空 统计失败",e.getMessage());
        }
    }
}
