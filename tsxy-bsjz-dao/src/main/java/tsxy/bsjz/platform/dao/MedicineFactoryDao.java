package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineFactory;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:06 MedicineFactory  medicineFactory
 */
public interface MedicineFactoryDao {
    //增
    void insertIntoFactory(MedicineFactory medicineFactory) throws Exception;

    //删（批量删除）
    void deleteFactoryByIds(List<Integer> ids) throws Exception;

    //修改
    void updateFactory(MedicineFactory medicineFactory) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(MedicinePublicDto medicinePublicDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<MedicineFactory> selectAllFactory(MedicinePublicDto medicinePublicDto) throws Exception;

    //查询---全部  拼成下拉选框
    List<MedicineFactory> selectAllFactoryList() throws Exception;
}
