package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.HandleRecordDao;
import tsxy.bsjz.platform.dao.mapper.HandleRecordMapper;
import tsxy.bsjz.platform.dao.vo.HandleRecordSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.HandleRecordExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/15--15:13
 */
@Repository
public class HandleRecordDaoImpl implements HandleRecordDao {
    @Autowired
    private HandleRecordMapper handleRecordMapper;

    @Override
    public void insertIntoHandleRecord(HandleRecord handleRecord) throws Exception {
        handleRecordMapper.insertSelective(handleRecord);
    }

    @Override
    public void updateHandleRecord(List<Integer> ids) throws Exception {
        HandleRecordExample example = new HandleRecordExample();
        HandleRecordExample.Criteria criteria = example.createCriteria();
        HandleRecord handleRecord = new HandleRecord();
        handleRecord.setDeleteState(0);
        criteria.andIdIn(ids);
        handleRecordMapper.updateByExampleSelective(handleRecord,example);
    }

    @Override
    public Integer selectCountByExample(HandleRecordSearchDto handleRecordSearchDto) throws Exception {
        HandleRecordExample example = new HandleRecordExample();
        HandleRecordExample.Criteria criteria = example.createCriteria();
        if(handleRecordSearchDto.getHandleName() != null && !handleRecordSearchDto.getHandleName().equals("")){
            criteria.andHandleNameLike("%"+handleRecordSearchDto.getHandleName()+"%");
        }
        return (int)handleRecordMapper.countByExample(example);
    }

    @Override
    public List<HandleRecord> selectAllHandleRecord(HandleRecordSearchDto handleRecordSearchDto) throws Exception {
        HandleRecordExample example = new HandleRecordExample();
        HandleRecordExample.Criteria criteria = example.createCriteria();
        if(handleRecordSearchDto.getHandleName() != null && !handleRecordSearchDto.getHandleName().equals("")){
            criteria.andHandleNameLike("%"+handleRecordSearchDto.getHandleName()+"%");
        }
        criteria.andDeleteStateEqualTo(1);
        example.setOrderByClause(handleRecordSearchDto.getOrderByClause());
        return handleRecordMapper.selectByExample(example);
    }

    @Override
    public void deleteDataBefore15() throws Exception {
        //删除15天之前的数据
        final Integer DAYS=15;
        handleRecordMapper.deleteDataBefore15(DAYS);
    }

    @Override
    public void updateDataByState() throws Exception {
        handleRecordMapper.updateDataByState();
    }
}
