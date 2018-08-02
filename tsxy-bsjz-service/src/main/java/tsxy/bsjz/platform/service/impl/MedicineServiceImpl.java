package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DetailedMedicineDao;
import tsxy.bsjz.platform.dao.MedicineDao;
import tsxy.bsjz.platform.dao.vo.MedicineSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Medicine;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.MedicineService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:04
 */
@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineDao medicineDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private DetailedMedicineDao detailedMedicineDao;
    @Override
    public void insertIntoMedicine(Medicine medicine) throws BusinessException {
        try {
            if(medicine.getId() != null){
                medicineDao.updateMedicine(medicine);
            }else{
                medicineDao.insertIntoMedicine(medicine);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.MEDICINE_ADD+medicine.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加药品失败",e.getMessage());
        }
    }

    @Override
    public void insertIntoMedicineList(List<Medicine> medicineList) throws BusinessException {
        try {
            medicineDao.insertIntoMedicineList(medicineList);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MEDICINE_IMPORT);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量增加  导入Excel数据库 到药品表失败",e.getMessage());
        }
    }

    @Override
    public void deleteMedicineByIds(List<Integer> ids) throws BusinessException {
        try {
            medicineDao.deleteMedicineByIds(ids);
            //当药品被删除的时候  清空已经和这些药品建立关系的 清单列表--药品中字段
            detailedMedicineDao.updateMedicineNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MEDICINE_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除药品失败",e.getMessage());
        }
    }

    @Override
    public void updateMedicine(Medicine medicine) throws BusinessException {
        try {
            medicineDao.updateMedicine(medicine);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MEDICINE_UPDATE+medicine.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改药品失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Medicine> selectAllMedicine(MedicineSearchDto medicineSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(medicineSearchDto.getPageNum(), medicineSearchDto.getPageSize());
            List<Medicine> medicineList = medicineDao.selectAllMedicine(medicineSearchDto);//全部
            Integer countNums = medicineDao.selectCountByExample(medicineSearchDto);//总数
            PageBean<Medicine> pageData = new PageBean<>(medicineSearchDto.getPageNum(), medicineSearchDto.getPageSize(), countNums);
            pageData.setItems(medicineList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询药品失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Medicine> selectAllLessMedicine(MedicineSearchDto medicineSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(medicineSearchDto.getPageNum(), medicineSearchDto.getPageSize());
            List<Medicine> medicineList = medicineDao.selectAllLessMedicine(medicineSearchDto);//全部
            Integer countNums = medicineDao.countByInventory(medicineSearchDto);//总数
            PageBean<Medicine> pageData = new PageBean<>(medicineSearchDto.getPageNum(), medicineSearchDto.getPageSize(), countNums);
            pageData.setItems(medicineList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页库存低于预警库存的查询药品失败",e.getMessage());
        }
    }

    @Override
    public List<Medicine> selectAllMedicineToExcel() throws BusinessException {
        try {
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MEDICINE_EXPORT);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
            return medicineDao.selectAllMedicineToExcel();
        }catch (Exception e){
            throw new BusinessException("查询---全部药品 导出EXCEL失败",e.getMessage());
        }
    }
}
