package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Familycontact;
import tsxy.bsjz.platform.model.FamilycontactExample;

public interface FamilycontactMapper {
    long countByExample(FamilycontactExample example);

    int deleteByExample(FamilycontactExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Familycontact record);

    int insertSelective(Familycontact record);

    List<Familycontact> selectByExample(FamilycontactExample example);

    Familycontact selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Familycontact record, @Param("example") FamilycontactExample example);

    int updateByExample(@Param("record") Familycontact record, @Param("example") FamilycontactExample example);

    int updateByPrimaryKeySelective(Familycontact record);

    int updateByPrimaryKey(Familycontact record);
}