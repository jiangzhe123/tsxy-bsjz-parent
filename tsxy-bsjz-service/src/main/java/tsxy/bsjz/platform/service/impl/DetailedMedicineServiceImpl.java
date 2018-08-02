package tsxy.bsjz.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DetailedMedicineDao;
import tsxy.bsjz.platform.model.DetailedMedicine;
import tsxy.bsjz.platform.service.DetailedMedicineService;
import tsxy.bsjz.platform.utils.BusinessException;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/1--14:51
 */
@Service
@Transactional
public class DetailedMedicineServiceImpl implements DetailedMedicineService {
    @Autowired
    private DetailedMedicineDao detailedMedicineDao;
    @Override
    public void insertIntoDetailedMedicine(DetailedMedicine detailedMedicine) throws BusinessException {
        try {
            if(detailedMedicine.getId() != null){
                detailedMedicineDao.updateDetailedMedicine(detailedMedicine);
            }else{
                detailedMedicineDao.insertIntoDetailedMedicine(detailedMedicine);
            }
        }catch (Exception e){
            throw new BusinessException("添加消费清单之药品失败",e.getMessage());
        }
    }

    @Override
    public void deleteDetailedMedicineByIds(List<Integer> ids) throws BusinessException {
        try {
            detailedMedicineDao.deleteDetailedMedicineByIds(ids);
        }catch (Exception e){
            throw new BusinessException("批量删除消费清单之药品失败",e.getMessage());
        }
    }

    @Override
    public void updateDetailedMedicine(DetailedMedicine detailedMedicine) throws BusinessException {
        try {
            detailedMedicineDao.updateDetailedMedicine(detailedMedicine);
        }catch (Exception e){
            throw new BusinessException("修改消费清单之药品失败",e.getMessage());
        }
    }
}
