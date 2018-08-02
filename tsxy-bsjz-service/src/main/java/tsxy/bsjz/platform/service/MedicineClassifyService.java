package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineClassify;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:01
 */
public interface MedicineClassifyService {

    //增
    void insertIntoClassify(MedicineClassify medicineClassify) throws BusinessException;

    //删（批量删除）
    void deleteClassifyByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateClassify(MedicineClassify medicineClassify) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<MedicineClassify> selectAllClassify(MedicinePublicDto medicinePublicDto) throws BusinessException;

    //查询---全部  拼成下拉选框
    List<MedicineClassify> selectAllClassifyList() throws BusinessException;
}
