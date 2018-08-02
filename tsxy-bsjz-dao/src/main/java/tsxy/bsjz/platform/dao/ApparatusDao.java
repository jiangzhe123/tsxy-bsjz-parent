package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.ApparatusSearchDto;
import tsxy.bsjz.platform.model.Apparatus;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--9:23  Apparatus  apparatus
 */
public interface ApparatusDao {

    //增
    void insertIntoApparatus(Apparatus apparatus) throws Exception;

    //删（批量删除）
    void deleteApparatusByIds(List<Integer> ids) throws Exception;

    //修改
    void updateApparatus(Apparatus apparatus) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(ApparatusSearchDto apparatusSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Apparatus> selectAllApparatus(ApparatusSearchDto apparatusSearchDto) throws Exception;

    //当仪器分类被删除的时候  清空已经和这些分类建立关系的 仪器中字段
    void updateClassifyNull(List<Integer> ids) throws Exception;
}
