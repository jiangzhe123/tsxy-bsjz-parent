package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.HandleRecordExample;

public interface HandleRecordMapper {
    long countByExample(HandleRecordExample example);

    int deleteByExample(HandleRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HandleRecord record);

    int insertSelective(HandleRecord record);

    List<HandleRecord> selectByExample(HandleRecordExample example);

    HandleRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HandleRecord record, @Param("example") HandleRecordExample example);

    int updateByExample(@Param("record") HandleRecord record, @Param("example") HandleRecordExample example);

    int updateByPrimaryKeySelective(HandleRecord record);

    int updateByPrimaryKey(HandleRecord record);

    //删除15天之前的数据
    void deleteDataBefore15(Integer days);

    //回滚数据
    void updateDataByState();
}