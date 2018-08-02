package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.DoctorMajorSearchDto;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--20:40
 */
public interface DoctorMajorService {

    //增
    void insertIntoDoctorMajor(DoctorMajor doctorMajor) throws BusinessException;

    //删（批量删除）
    void deleteDoctorMajorByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateDoctorMajor(DoctorMajor doctorMajor) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<DoctorMajor> selectAllDoctorMajor(DoctorMajorSearchDto doctorMajorSearchDto) throws BusinessException;

    //查询---全部
    List<DoctorMajor> selectAllDoctorMajorList() throws BusinessException;
}
