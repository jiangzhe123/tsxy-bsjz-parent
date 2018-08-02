package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.dao.vo.SickbedCountDto;
import tsxy.bsjz.platform.model.Sickbed;
import tsxy.bsjz.platform.model.SickbedExample;

public interface SickbedMapper {
    long countByExample(SickbedExample example);

    int deleteByExample(SickbedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sickbed record);

    int insertSelective(Sickbed record);

    List<Sickbed> selectByExample(SickbedExample example);

    Sickbed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sickbed record, @Param("example") SickbedExample example);

    int updateByExample(@Param("record") Sickbed record, @Param("example") SickbedExample example);

    int updateByPrimaryKeySelective(Sickbed record);

    int updateByPrimaryKey(Sickbed record);

    //清床 根据床的ID
    void updatePatientNull(Integer id);

    //查询视图 病床之空不空 统计
    SickbedCountDto selectSickbedCountDto();

    //当科室被删除的时候  清空已经和这些科室建立关系的 病床中字段
    void updateDepartment2Null(List<Integer> ids);

    //当患者被删除的时候  清空已经和这些患者建立关系的 病床中字段
    void updatePatient3Null(List<Integer> ids);
}