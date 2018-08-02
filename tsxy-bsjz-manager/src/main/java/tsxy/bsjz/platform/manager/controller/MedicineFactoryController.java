package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineFactory;
import tsxy.bsjz.platform.service.MedicineFactoryService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--13:31 MedicineFactory  medicineFactory  药品厂家
 */
@RestController
@RequestMapping("medicineFactory")
public class MedicineFactoryController {
    @Autowired
    private MedicineFactoryService medicineFactoryService;

    //增加药品厂家信息
    @RequestMapping("/insertIntoFactory")
    public HashMap<String, Object> insertIntoFactory(MedicineFactory medicineFactory) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineFactoryService.insertIntoFactory(medicineFactory);
        return result;
    }

    //批量删除药品厂家信息
    @RequestMapping("/deleteFactoryByIds")
    public HashMap<String, Object> deleteFactoryByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineFactoryService.deleteFactoryByIds(Arrays.asList(ids));
        return result;
    }

    //修改药品厂家信息
    @RequestMapping("/updateFactory")
    public HashMap<String, Object> updateFactory(MedicineFactory medicineFactory) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineFactoryService.updateFactory(medicineFactory);
        return result;
    }

    //分页查询全部药品厂家信息
    @RequestMapping("/selectAllFactory")
    public HashMap<String, Object> selectAllFactory(MedicinePublicDto medicinePublicDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<MedicineFactory> pageData =  medicineFactoryService.selectAllFactory(medicinePublicDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<MedicineFactory> factoryList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("factoryList", factoryList);
        return result;
    }
}
