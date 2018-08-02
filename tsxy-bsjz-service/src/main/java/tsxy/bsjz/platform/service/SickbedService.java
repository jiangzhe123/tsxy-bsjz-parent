package tsxy.bsjz.platform.service;


import tsxy.bsjz.platform.dao.vo.SickbedCountDto;
import tsxy.bsjz.platform.dao.vo.SickbedSearchDto;
import tsxy.bsjz.platform.model.Sickbed;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/2--10:15
 */
public interface SickbedService {

    //增
    void insertIntoSickbed(Sickbed sickbed) throws BusinessException;

    //删（批量删除）
    void deleteSickbedByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateSickbed(Sickbed sickbed) throws BusinessException;

    //清床 根据床的ID
    void updatePatientNull(Integer id) throws BusinessException;

    //查询---非空病床+模糊查询+前端页面上分页+排序
    PageBean<Sickbed> selectAllSickbed(SickbedSearchDto sickbedSearchDto) throws BusinessException;

    //查询---空病床+模糊查询+前端页面上分页+排序
    PageBean<Sickbed> selectAllNullSickbed(SickbedSearchDto sickbedSearchDto) throws BusinessException;

    //查询视图 病床之空不空 统计
    SickbedCountDto selectSickbedCountDto() throws BusinessException;
}
