package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.ApparatusSearchDto;
import tsxy.bsjz.platform.model.Apparatus;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--9:54
 */
public interface ApparatusService {
    //增
    void insertIntoApparatus(Apparatus apparatus) throws BusinessException;

    //删（批量删除）
    void deleteApparatusByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateApparatus(Apparatus apparatus) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Apparatus> selectAllApparatus(ApparatusSearchDto apparatusSearchDto) throws BusinessException;
}
