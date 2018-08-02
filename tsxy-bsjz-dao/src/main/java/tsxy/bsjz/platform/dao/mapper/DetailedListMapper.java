package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.dao.vo.DetailedCountDto;
import tsxy.bsjz.platform.dao.vo.DetailedListSearchDto;
import tsxy.bsjz.platform.model.DetailedList;
import tsxy.bsjz.platform.model.DetailedListExample;

public interface DetailedListMapper {
    long countByExample(DetailedListExample example);

    int deleteByExample(DetailedListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DetailedList record);

    int insertSelective(DetailedList record);

    List<DetailedList> selectByExample(DetailedListExample example);

    DetailedList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DetailedList record, @Param("example") DetailedListExample example);

    int updateByExample(@Param("record") DetailedList record, @Param("example") DetailedListExample example);

    int updateByPrimaryKeySelective(DetailedList record);

    int updateByPrimaryKey(DetailedList record);

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(@Param("detailedListSearchDto") DetailedListSearchDto detailedListSearchDto);

    //查询---全部+模糊查询+前端页面上分页+排序
    List<DetailedList> selectAllDetailedList(@Param("detailedListSearchDto") DetailedListSearchDto detailedListSearchDto);

    //查询视图清单统计之昨日和今日总金额
    DetailedCountDto selectDetailedCountDto();

    //当患者被删除的时候  清空已经和这些患者建立关系的 清单列表中字段
    void updatePatient4Null(List<Integer> ids);
}