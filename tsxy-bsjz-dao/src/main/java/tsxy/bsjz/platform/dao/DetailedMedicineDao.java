package tsxy.bsjz.platform.dao;
import tsxy.bsjz.platform.model.DetailedMedicine;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/31--23:49
 */
public interface DetailedMedicineDao {

    //增
    void insertIntoDetailedMedicine(DetailedMedicine detailedMedicine) throws Exception;

    //删（批量删除） 通过主键IDs
    void deleteDetailedMedicineByIds(List<Integer> ids) throws Exception;

    //删（批量删除） 通过清单的ids
    void deleteMedicineByDetailedIds(List<Integer> detailedIds) throws Exception;

    //修改
    void updateDetailedMedicine(DetailedMedicine detailedMedicine) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<DetailedMedicine> selectAllDetailedMedicine(Integer detailedId) throws Exception;

    //当药品被删除的时候  清空已经和这些药品建立关系的 清单列表--药品中字段
    void updateMedicineNull(List<Integer> ids) throws Exception;
}
