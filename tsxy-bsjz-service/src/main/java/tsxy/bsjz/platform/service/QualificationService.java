package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.QualificationSearchDto;
import tsxy.bsjz.platform.model.Qualification;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--20:46
 */
public interface QualificationService {

    //增
    void insertIntoQualification(Qualification qualification) throws BusinessException;

    //删（批量删除）
    void deleteQualificationByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateQualification(Qualification qualification) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Qualification> selectAllQualification(QualificationSearchDto qualificationSearchDto) throws BusinessException;

    //查询---全部
    List<Qualification> selectAllQualificationList() throws BusinessException;
}
