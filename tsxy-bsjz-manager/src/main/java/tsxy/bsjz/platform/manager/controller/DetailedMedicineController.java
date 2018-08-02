package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.model.DetailedMedicine;
import tsxy.bsjz.platform.service.DetailedMedicineService;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by 姜哲 on 2018/4/1--15:01  DetailedMedicine  detailedMedicine  清单具体药品
 */
@RestController
@RequestMapping("detailedMedicine")
public class DetailedMedicineController {
    @Autowired
    private DetailedMedicineService detailedMedicineService;

    //增加消费清单信息
    @RequestMapping("/insertIntoDetailedMedicine")
    public HashMap<String, Object> insertIntoDetailedMedicine(DetailedMedicine detailedMedicine) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        detailedMedicineService.insertIntoDetailedMedicine(detailedMedicine);
        return result;
    }

    //批量删除消费清单信息
    @RequestMapping("/deleteDetailedMedicineByIds")
    public HashMap<String, Object> deleteDetailedMedicineByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        detailedMedicineService.deleteDetailedMedicineByIds(Arrays.asList(ids));
        return result;
    }

    //修改消费清单信息
    @RequestMapping("/updateDetailedMedicine")
    public HashMap<String, Object> updateDetailedMedicine(DetailedMedicine detailedMedicine) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        detailedMedicineService.updateDetailedMedicine(detailedMedicine);
        return result;
    }
}
