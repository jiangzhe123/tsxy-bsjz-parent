package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineClassify;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:05  MedicineClassify  medicineClassify
 */
public interface MedicineClassifyDao {

    //增
    void insertIntoClassify(MedicineClassify medicineClassify) throws Exception;

    //删（批量删除）
    void deleteClassifyByIds(List<Integer> ids) throws Exception;

    //修改
    void updateClassify(MedicineClassify medicineClassify) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(MedicinePublicDto medicinePublicDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<MedicineClassify> selectAllClassify(MedicinePublicDto medicinePublicDto) throws Exception;

    //查询---全部  拼成下拉选框
    List<MedicineClassify> selectAllClassifyList() throws Exception;
}
