package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.model.Familycontact;
import tsxy.bsjz.platform.utils.BusinessException;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--11:37
 */
public interface FamilycontactService {

    //增
    void insertIntoFamilycontact(Familycontact familycontact) throws BusinessException;

    //删（批量删除）
    void deleteFamilycontactByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateFamilycontact(Familycontact familycontact) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Familycontact> selectAllFamilycontact() throws BusinessException;
}
