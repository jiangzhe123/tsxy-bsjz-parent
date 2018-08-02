package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineFactory;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:02
 */
public interface MedicineFactoryService {
    //增
    void insertIntoFactory(MedicineFactory medicineFactory) throws BusinessException;

    //删（批量删除）
    void deleteFactoryByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateFactory(MedicineFactory medicineFactory) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<MedicineFactory> selectAllFactory(MedicinePublicDto medicinePublicDto) throws BusinessException;

    //查询---全部  拼成下拉选框
    List<MedicineFactory> selectAllFactoryList() throws BusinessException;
}
