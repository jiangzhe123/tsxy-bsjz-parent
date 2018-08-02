package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.DetailedCountDto;
import tsxy.bsjz.platform.dao.vo.DetailedListSearchDto;
import tsxy.bsjz.platform.model.DetailedList;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/31--23:20
 */
public interface DetailedListDao {

    //增
    void insertIntoDetailedList(DetailedList detailedList) throws Exception;

    //删（批量删除）
    void deleteDetailedListByIds(List<Integer> ids) throws Exception;

    //修改
    void updateDetailedList(DetailedList detailedList) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(DetailedListSearchDto detailedListSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<DetailedList> selectAllDetailedList(DetailedListSearchDto detailedListSearchDto) throws Exception;

    //查询视图清单统计之昨日和今日总金额
    DetailedCountDto selectDetailedCountDto() throws Exception;

    //当患者被删除的时候  清空已经和这些患者建立关系的 清单列表中字段
    void updatePatient4Null(List<Integer> ids) throws Exception;
}
