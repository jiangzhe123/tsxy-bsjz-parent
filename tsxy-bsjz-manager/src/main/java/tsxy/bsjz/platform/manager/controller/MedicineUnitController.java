package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.model.MedicineUnit;
import tsxy.bsjz.platform.service.MedicineUnitService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--13:36  MedicineUnit  medicineUnit  药品单位
 */
@RestController
@RequestMapping("medicineUnit")
public class MedicineUnitController {
    @Autowired
    private MedicineUnitService medicineUnitService;

    //增加药品单位信息
    @RequestMapping("/insertIntoUnit")
    public HashMap<String, Object> insertIntoUnit(MedicineUnit medicineUnit) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineUnitService.insertIntoUnit(medicineUnit);
        return result;
    }

    //批量删除药品单位信息
    @RequestMapping("/deleteUnitByIds")
    public HashMap<String, Object> deleteUnitByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineUnitService.deleteUnitByIds(Arrays.asList(ids));
        return result;
    }

    //修改药品单位信息
    @RequestMapping("/updateUnit")
    public HashMap<String, Object> updateUnit(MedicineUnit medicineUnit) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineUnitService.updateUnit(medicineUnit);
        return result;
    }

    //分页查询全部药品单位信息
    @RequestMapping("/selectAllUnit")
    public HashMap<String, Object> selectAllUnit() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<MedicineUnit> unitList =  medicineUnitService.selectAllUnit();
        result.put("unitList", unitList);
        return result;
    }
}
