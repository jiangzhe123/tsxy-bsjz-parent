package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.ApparatusClassifySearchDto;
import tsxy.bsjz.platform.model.ApparatusClassify;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--9:36 ApparatusClassify  apparatusClassify
 */
public interface ApparatusClassifyDao {

    //增
    void insertIntoApparatusClassify(ApparatusClassify apparatusClassify) throws Exception;

    //删（批量删除）
    void deleteApparatusClassifyByIds(List<Integer> ids) throws Exception;

    //修改
    void updateApparatusClassify(ApparatusClassify apparatusClassify) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(ApparatusClassifySearchDto apparatusClassifySearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<ApparatusClassify> selectAllApparatusClassify(ApparatusClassifySearchDto apparatusClassifySearchDto) throws Exception;

    //查询---全部
    List<ApparatusClassify> selectAllApparatusClassifyList() throws Exception;
}
