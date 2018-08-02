package tsxy.bsjz.platform.dao;


import tsxy.bsjz.platform.dao.vo.DoctorMajorSearchDto;
import tsxy.bsjz.platform.model.DoctorMajor;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--20:09
 */
public interface DoctorMajorDao {

    //增
    void insertIntoDoctorMajor(DoctorMajor doctorMajor) throws Exception;

    //删（批量删除）
    void deleteDoctorMajorByIds(List<Integer> ids) throws Exception;

    //修改
    void updateDoctorMajor(DoctorMajor doctorMajor) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(DoctorMajorSearchDto doctorMajorSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<DoctorMajor> selectAllDoctorMajor(DoctorMajorSearchDto doctorMajorSearchDto) throws Exception;

    //查询---全部
    List<DoctorMajor> selectAllDoctorMajorList() throws Exception;
}
