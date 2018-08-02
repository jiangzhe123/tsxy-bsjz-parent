package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.HandleRecordSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/15--15:06  管理员操作记录
 */
public interface HandleRecordDao {

    //增
    void insertIntoHandleRecord(HandleRecord handleRecord) throws Exception;

    //批量删除之修改 删除状态（0为已经删除  1为未删除）
    void updateHandleRecord(List<Integer> ids) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(HandleRecordSearchDto handleRecordSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<HandleRecord> selectAllHandleRecord(HandleRecordSearchDto handleRecordSearchDto) throws Exception;

    //删除15天之前的数据
    void deleteDataBefore15() throws Exception;

    //回滚数据
    void updateDataByState() throws Exception;
}
