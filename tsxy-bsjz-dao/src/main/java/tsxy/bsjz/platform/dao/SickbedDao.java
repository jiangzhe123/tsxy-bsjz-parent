package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.SickbedCountDto;
import tsxy.bsjz.platform.dao.vo.SickbedSearchDto;
import tsxy.bsjz.platform.model.Sickbed;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/2--9:56
 */
public interface SickbedDao {

    //增
    void insertIntoSickbed(Sickbed sickbed) throws Exception;

    //删（批量删除）
    void deleteSickbedByIds(List<Integer> ids) throws Exception;

    //修改
    void updateSickbed(Sickbed sickbed) throws Exception;

    //清床 根据床的ID
    void updatePatientNull(Integer id) throws Exception;

    //查询 非空病床 总共多少满足条件 的实体类个数
    Integer selectCountByExample(SickbedSearchDto sickbedSearchDto) throws Exception;

    //查询---非空病床+模糊查询+前端页面上分页+排序
    List<Sickbed> selectAllSickbed(SickbedSearchDto sickbedSearchDto) throws Exception;

    //查询 空病床 总共多少满足条件 的实体类个数
    Integer selectCountNullByExample(SickbedSearchDto sickbedSearchDto) throws Exception;

    //查询---空病床+模糊查询+前端页面上分页+排序
    List<Sickbed> selectAllNullSickbed(SickbedSearchDto sickbedSearchDto) throws Exception;

    //查询视图 病床之空不空 统计
    SickbedCountDto selectSickbedCountDto() throws Exception;

    //当科室被删除的时候  清空已经和这些科室建立关系的 病床中字段
    void updateDepartment2Null(List<Integer> ids) throws Exception;

    //当患者被删除的时候  清空已经和这些患者建立关系的 病床中字段
    void updatePatient3Null(List<Integer> ids) throws Exception;
}
