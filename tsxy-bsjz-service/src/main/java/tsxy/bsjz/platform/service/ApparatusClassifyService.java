package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.ApparatusClassifySearchDto;
import tsxy.bsjz.platform.model.ApparatusClassify;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--10:00
 */
public interface ApparatusClassifyService {

    //增
    void insertIntoApparatusClassify(ApparatusClassify apparatusClassify) throws BusinessException;

    //删（批量删除）
    void deleteApparatusClassifyByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateApparatusClassify(ApparatusClassify apparatusClassify) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<ApparatusClassify> selectAllApparatusClassify(ApparatusClassifySearchDto apparatusClassifySearchDto) throws BusinessException;

    //查询---全部
    List<ApparatusClassify> selectAllApparatusClassifyList() throws BusinessException;
}
