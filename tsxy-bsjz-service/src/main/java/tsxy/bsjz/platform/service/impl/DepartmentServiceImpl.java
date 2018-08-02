package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DepartmentDao;
import tsxy.bsjz.platform.dao.DoctorDao;
import tsxy.bsjz.platform.dao.PatientDao;
import tsxy.bsjz.platform.dao.SickbedDao;
import tsxy.bsjz.platform.dao.vo.DepartCountDto;
import tsxy.bsjz.platform.dao.vo.DepartmentSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.DepartmentService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--20:34
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private SickbedDao sickbedDao;

    @Override
    public void insertIntoDepartment(Department department) throws BusinessException {
        try {
            if(department.getId() != null){
                departmentDao.updateDepartment(department);
            }else{
                departmentDao.insertIntoDepartment(department);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.DEPARTMENT_ADD+department.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加科室失败",e.getMessage());
        }
    }

    @Override
    public void deleteDepartmentByIds(List<Integer> ids) throws BusinessException {
        try {
            departmentDao.deleteDepartmentByIds(ids);
            //当科室被删除的时候  清空已经和这些医师建立关系的 科室中字段
            doctorDao.updateDepartmentNull(ids);
            //当科室被删除的时候  清空已经和这些患者建立关系的 科室中字段
            patientDao.updateDepartmentNull(ids);
            //当科室被删除的时候  清空已经和这些科室建立关系的 病床中字段
            sickbedDao.updateDepartment2Null(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.DEPARTMENT_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除科室失败",e.getMessage());
        }
    }

    @Override
    public void updateDepartment(Department department) throws BusinessException {
        try {
            departmentDao.updateDepartment(department);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.DEPARTMENT_UPDATE+department.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改科室失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Department> selectAllDepartment(DepartmentSearchDto departmentSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(departmentSearchDto.getPageNum(), departmentSearchDto.getPageSize());
            List<Department> departmentList = departmentDao.selectAllDepartment(departmentSearchDto);//科室集合
            Integer countNums = departmentDao.selectCountByExample(departmentSearchDto);//总数
            PageBean<Department> pageData = new PageBean<>(departmentSearchDto.getPageNum(), departmentSearchDto.getPageSize(), countNums);
            pageData.setItems(departmentList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部科室失败",e.getMessage());
        }

    }

    @Override
    public List<Department> selectAllDepartmentList() throws BusinessException {
        try {
            return departmentDao.selectAllDepartmentList();
        }catch (Exception e){
            throw new BusinessException("查询全部科室失败",e.getMessage());
        }
    }

    @Override
    public List<DepartCountDto> selectAllDepartCountDto() throws BusinessException {
        try {
            return departmentDao.selectAllDepartCountDto();
        }catch (Exception e){
            throw new BusinessException("查询视图科室之统计柱状图失败",e.getMessage());
        }
    }
}
