package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.DetailedCountDto;
import tsxy.bsjz.platform.dao.vo.DetailedListSearchDto;
import tsxy.bsjz.platform.model.DetailedList;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/1--14:14
 */
public interface DetailedListService {
    //增
    void insertIntoDetailedList(DetailedList detailedList) throws BusinessException;

    //删（批量删除）
    void deleteDetailedListByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateDetailedList(DetailedList detailedList) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<DetailedList> selectAllDetailedList(DetailedListSearchDto detailedListSearchDto) throws BusinessException;

    //查询视图清单统计之昨日和今日总金额
    DetailedCountDto selectDetailedCountDto() throws BusinessException;
}
