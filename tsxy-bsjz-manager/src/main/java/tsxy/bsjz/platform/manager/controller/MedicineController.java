package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tsxy.bsjz.platform.dao.vo.MedicineSearchDto;
import tsxy.bsjz.platform.model.Medicine;
import tsxy.bsjz.platform.model.MedicineClassify;
import tsxy.bsjz.platform.model.MedicineFactory;
import tsxy.bsjz.platform.model.MedicineUnit;
import tsxy.bsjz.platform.service.MedicineClassifyService;
import tsxy.bsjz.platform.service.MedicineFactoryService;
import tsxy.bsjz.platform.service.MedicineService;
import tsxy.bsjz.platform.service.MedicineUnitService;
import tsxy.bsjz.platform.utils.PageBean;
import tsxy.bsjz.platform.utils.PoiUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--13:32 Medicine medicine  药品
 */
@RestController
@RequestMapping("medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private MedicineClassifyService medicineClassifyService;
    @Autowired
    private MedicineFactoryService medicineFactoryService;
    @Autowired
    private MedicineUnitService medicineUnitService;

    //增加药品信息
    @RequestMapping("/insertIntoMedicine")
    public HashMap<String, Object> insertIntoMedicine(Medicine medicine) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineService.insertIntoMedicine(medicine);
        return result;
    }

    //批量删除药品信息
    @RequestMapping("/deleteMedicineByIds")
    public HashMap<String, Object> deleteMedicineByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineService.deleteMedicineByIds(Arrays.asList(ids));
        return result;
    }

    //修改药品信息
    @RequestMapping("/updateMedicine")
    public HashMap<String, Object> updateMedicine(Medicine medicine) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineService.updateMedicine(medicine);
        return result;
    }

    //分页查询全部药品信息
    @RequestMapping("/selectAllMedicine")
    public HashMap<String, Object> selectAllMedicine(MedicineSearchDto medicineSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Medicine> pageData =  medicineService.selectAllMedicine(medicineSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Medicine> medicineList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("medicineList", medicineList);
        return result;
    }

    //查询 药品信息中 下拉选框部分之 分类、厂家、单位
    @RequestMapping("/selectMedicineOption")
    public HashMap<String, Object> selectMedicineOption() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<MedicineClassify> classifyList = medicineClassifyService.selectAllClassifyList();
        List<MedicineFactory> factoryList = medicineFactoryService.selectAllFactoryList();
        List<MedicineUnit> unitList = medicineUnitService.selectAllUnit();
        result.put("classifyList",classifyList);
        result.put("factoryList",factoryList);
        result.put("unitList",unitList);
        return result;
    }

    //分页查询库存低于预警库存的查询药品
    @RequestMapping("/selectAllLessMedicine")
    public HashMap<String, Object> selectAllLessMedicine(MedicineSearchDto medicineSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Medicine> pageData =  medicineService.selectAllLessMedicine(medicineSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Medicine> medicineList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("medicineList", medicineList);
        return result;
    }

    //导出Excel 全部药品
    @RequestMapping("/exportMedicine")
    public ResponseEntity<byte[]> exportMedicine() {
        return PoiUtils.exportMedicine2Excel(medicineService.selectAllMedicineToExcel());
    }

    //导入Excel数据库 到药品表
    @RequestMapping("/importMedicineList")
    public HashMap<String, Object> importMedicineList(MultipartFile file) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Medicine> medicineList = PoiUtils.importMedicine2List(file);
        medicineService.insertIntoMedicineList(medicineList);
        return result;
    }
}
