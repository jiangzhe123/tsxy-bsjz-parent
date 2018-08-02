package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.DepartmentDao;
import tsxy.bsjz.platform.dao.mapper.DepartmentMapper;
import tsxy.bsjz.platform.dao.vo.DepartCountDto;
import tsxy.bsjz.platform.dao.vo.DepartmentSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.model.DepartmentExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--19:45
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void insertIntoDepartment(Department department) throws Exception {
        departmentMapper.insertSelective(department);
    }

    @Override
    public void deleteDepartmentByIds(List<Integer> ids) throws Exception {
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        departmentMapper.deleteByExample(example);
    }

    @Override
    public void updateDepartment(Department department) throws Exception {
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public Integer selectCountByExample(DepartmentSearchDto departmentSearchDto) throws Exception {
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        if(departmentSearchDto.getName() != null && !departmentSearchDto.getName().equals("")){
            criteria.andNameLike("%"+departmentSearchDto.getName()+"%");
        }
        return (int)departmentMapper.countByExample(example);
    }

    @Override
    public List<Department> selectAllDepartment(DepartmentSearchDto departmentSearchDto) throws Exception {
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        if(departmentSearchDto.getName() != null && !departmentSearchDto.getName().equals("")){
            criteria.andNameLike("%"+departmentSearchDto.getName()+"%");
        }
        return departmentMapper.selectByExample(example);
    }

    @Override
    public List<Department> selectAllDepartmentList() throws Exception {
        DepartmentExample example = new DepartmentExample();
        return departmentMapper.selectByExample(example);
    }

    @Override
    public List<DepartCountDto> selectAllDepartCountDto() throws Exception {
        return departmentMapper.selectAllDepartCountDto();
    }
}
