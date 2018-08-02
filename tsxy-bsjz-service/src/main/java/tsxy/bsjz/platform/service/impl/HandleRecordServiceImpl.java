package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.HandleRecordDao;
import tsxy.bsjz.platform.dao.vo.HandleRecordSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/15--15:30
 */
@Service
@Transactional
public class HandleRecordServiceImpl implements HandleRecordService {
    @Autowired
    private HandleRecordDao handleRecordDao;
    @Override
    public void insertIntoHandleRecord(HandleRecord handleRecord) throws BusinessException {
        try {
            handleRecordDao.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("增加管理员操作记录失败",e.getMessage());
        }
    }

    @Override
    public void updateHandleRecord(List<Integer> ids) throws BusinessException {
        try {
            handleRecordDao.updateHandleRecord(ids);
        }catch (Exception e){
            throw new BusinessException("批量删除之修改 删除状态（0为已经删除  1为未删除）失败",e.getMessage());
        }
    }

    @Override
    public PageBean<HandleRecord> selectAllHandleRecord(HandleRecordSearchDto handleRecordSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(handleRecordSearchDto.getPageNum(), handleRecordSearchDto.getPageSize());
            List<HandleRecord> handleRecordList = handleRecordDao.selectAllHandleRecord(handleRecordSearchDto);//全部医生
            Integer countNums = handleRecordDao.selectCountByExample(handleRecordSearchDto);//总数
            PageBean<HandleRecord> pageData = new PageBean<>(handleRecordSearchDto.getPageNum(), handleRecordSearchDto.getPageSize(), countNums);
            pageData.setItems(handleRecordList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询管理员操作记录失败",e.getMessage());
        }
    }

    @Override
    public void deleteDataBefore15() throws BusinessException {
        try {
            handleRecordDao.deleteDataBefore15();
        }catch (Exception e){
            throw new BusinessException("删除15天之前的数据失败",e.getMessage());
        }
    }

    @Override
    public void updateDataByState() throws BusinessException {
        try {
            handleRecordDao.updateDataByState();
        }catch (Exception e){
            throw new BusinessException("回滚数据失败",e.getMessage());
        }
    }
}
