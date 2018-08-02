package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.HandleRecordSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/15--15:28
 */
public interface HandleRecordService {

    //增
    void insertIntoHandleRecord(HandleRecord handleRecord) throws BusinessException;

    //批量删除之修改 删除状态（0为已经删除  1为未删除）
    void updateHandleRecord(List<Integer> ids) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<HandleRecord> selectAllHandleRecord(HandleRecordSearchDto handleRecordSearchDto) throws BusinessException;

    //删除15天之前的数据
    void deleteDataBefore15() throws BusinessException;

    //回滚数据
    void updateDataByState() throws BusinessException;
}
