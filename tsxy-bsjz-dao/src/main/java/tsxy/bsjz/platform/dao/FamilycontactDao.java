package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.model.Familycontact;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--10:48
 */
public interface FamilycontactDao {
    //增
    void insertIntoFamilycontact(Familycontact familycontact) throws Exception;

    //删（批量删除）
    void deleteFamilycontactByIds(List<Integer> ids) throws Exception;

    //修改
    void updateFamilycontact(Familycontact familycontact) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Familycontact> selectAllFamilycontact() throws Exception;
}
