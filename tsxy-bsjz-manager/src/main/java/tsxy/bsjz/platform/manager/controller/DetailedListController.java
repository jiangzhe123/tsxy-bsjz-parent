package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.DetailedListSearchDto;
import tsxy.bsjz.platform.model.DetailedList;
import tsxy.bsjz.platform.service.DetailedListService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/1--14:54 DetailedList  detailedList  消费清单
 */
@RestController
@RequestMapping("detailedList")
public class DetailedListController {
    @Autowired
    private DetailedListService detailedListService;

    //增加消费清单信息
    @RequestMapping("/insertIntoDetailedList")
    public HashMap<String, Object> insertIntoDetailedList(DetailedList detailedList) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        detailedListService.insertIntoDetailedList(detailedList);
        return result;
    }

    //批量删除消费清单信息
    @RequestMapping("/deleteDetailedListByIds")
    public HashMap<String, Object> deleteDetailedListByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        detailedListService.deleteDetailedListByIds(Arrays.asList(ids));
        return result;
    }

    //修改消费清单信息
    @RequestMapping("/updateDetailedList")
    public HashMap<String, Object> updateDetailedList(DetailedList detailedList) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        detailedListService.updateDetailedList(detailedList);
        return result;
    }

    //分页查询全部消费清单信息
    @RequestMapping("/selectAllDetailedList")
    public HashMap<String, Object> selectAllDetailedList(DetailedListSearchDto detailedListSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<DetailedList> pageData =  detailedListService.selectAllDetailedList(detailedListSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<DetailedList> detailedList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("detailedList", detailedList);
        return result;
    }
}
