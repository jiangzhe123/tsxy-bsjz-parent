package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.QualificationSearchDto;
import tsxy.bsjz.platform.model.Qualification;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--20:16
 */
public interface QualificationDao {
    //增
    void insertIntoQualification(Qualification qualification) throws Exception;

    //删（批量删除）
    void deleteQualificationByIds(List<Integer> ids) throws Exception;

    //修改
    void updateQualification(Qualification qualification) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(QualificationSearchDto qualificationSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Qualification> selectAllQualification(QualificationSearchDto qualificationSearchDto) throws Exception;

    //查询---全部
    List<Qualification> selectAllQualificationList() throws Exception;
}
