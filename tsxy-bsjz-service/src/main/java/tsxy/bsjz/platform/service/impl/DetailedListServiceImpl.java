package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DetailedListDao;
import tsxy.bsjz.platform.dao.DetailedMedicineDao;
import tsxy.bsjz.platform.dao.vo.DetailedCountDto;
import tsxy.bsjz.platform.dao.vo.DetailedListSearchDto;
import tsxy.bsjz.platform.model.DetailedList;
import tsxy.bsjz.platform.model.DetailedMedicine;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.DetailedListService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/1--14:15
 */
@Service
@Transactional
public class DetailedListServiceImpl implements DetailedListService {
    @Autowired
    private DetailedListDao detailedListDao;
    @Autowired
    private DetailedMedicineDao detailedMedicineDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Override
    public void insertIntoDetailedList(DetailedList detailedList) throws BusinessException {
        try {
            if(detailedList.getId() != null){
                detailedListDao.updateDetailedList(detailedList);
            }else{
                detailedListDao.insertIntoDetailedList(detailedList);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.DETAILEDLIST_ADD+detailedList.getPatient().getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加消费清单失败",e.getMessage());
        }
    }

    @Override
    public void deleteDetailedListByIds(List<Integer> ids) throws BusinessException {
        try {
            detailedListDao.deleteDetailedListByIds(ids);
            detailedMedicineDao.deleteMedicineByDetailedIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.DETAILEDLIST_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除消费清单和清单下的药品失败",e.getMessage());
        }
    }

    @Override
    public void updateDetailedList(DetailedList detailedList) throws BusinessException {
        try {
            detailedListDao.updateDetailedList(detailedList);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.DETAILEDLIST_UPDATE+detailedList.getPatient().getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改消费清单失败",e.getMessage());
        }
    }

    @Override
    public PageBean<DetailedList> selectAllDetailedList(DetailedListSearchDto detailedListSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(detailedListSearchDto.getPageNum(), detailedListSearchDto.getPageSize());
            List<DetailedList> detailedListS = detailedListDao.selectAllDetailedList(detailedListSearchDto);//集合
            for(DetailedList detailedList:detailedListS){
                if(detailedList.getDetailedMedicineList().size()>0){
                    BigDecimal totalPrice = new BigDecimal(String.valueOf(0.0));
                    List<DetailedMedicine> detailedMedicines = new ArrayList<>();
                    for(DetailedMedicine detailedMedicine:detailedList.getDetailedMedicineList()){
                        BigDecimal medicineNum = new BigDecimal(detailedMedicine.getMedicineNum());
                        BigDecimal salePrice = new BigDecimal(String.valueOf(0.0));
                        if(detailedMedicine.getMedicine() != null){
                            salePrice = new BigDecimal(String.valueOf(detailedMedicine.getMedicine().getSalePrice()));
                        }
                        //清单列表下的药品表的每个药品的总价 medicinePrice = medicineNum * salePrice
                        BigDecimal medicinePrice = medicineNum.multiply(salePrice);
                        detailedMedicine.setMedicinePrice(medicinePrice);
                        detailedMedicines.add(detailedMedicine);
                        //清单列表 总价 totalPrice += medicinePrice
                        totalPrice = totalPrice.add(medicinePrice);
                    }
                    detailedList.setTotalPrice(totalPrice);
                    detailedList.setDetailedMedicineList(detailedMedicines);
                }
            }
            Integer countNums = detailedListDao.selectCountByExample(detailedListSearchDto);//总数
            PageBean<DetailedList> pageData = new PageBean<>(detailedListSearchDto.getPageNum(), detailedListSearchDto.getPageSize(), countNums);
            pageData.setItems(detailedListS);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部清单失败",e.getMessage());
        }
    }

    @Override
    public DetailedCountDto selectDetailedCountDto() throws BusinessException {
        try {
            return detailedListDao.selectDetailedCountDto();
        }catch (Exception e){
            throw new BusinessException("查询视图清单统计之昨日和今日总金额失败",e.getMessage());
        }
    }
}
