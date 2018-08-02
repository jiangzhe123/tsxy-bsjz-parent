package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.HandleRecordSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/15--15:41  HandleRecord  handleRecord  管理员操作记录
 */
@RestController
@RequestMapping("handleRecord")
public class HandleRecordController {

    @Autowired
    private HandleRecordService handleRecordService;

    //批量删除之 修改 删除状态（0为已经删除  1为未删除）
    @RequestMapping("/updateHandleRecord")
    public HashMap<String, Object> updateHandleRecord(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        handleRecordService.updateHandleRecord(Arrays.asList(ids));
        return result;
    }

    //查询全部管理员操作记录信息
    @RequestMapping("/selectAllHandleRecord")
    public HashMap<String, Object> selectAllHandleRecord(HandleRecordSearchDto handleRecordSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<HandleRecord> pageData = handleRecordService.selectAllHandleRecord(handleRecordSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<HandleRecord> handleRecordList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("handleRecordList", handleRecordList);
        return result;
    }

    //删除15天之前的数据
    @RequestMapping("/deleteDataBefore15")
    public HashMap<String, Object> deleteDataBefore15() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        handleRecordService.deleteDataBefore15();
        return result;
    }

    //回滚数据
    @RequestMapping("/updateDataByState")
    public HashMap<String, Object> updateDataByState() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        handleRecordService.updateDataByState();
        return result;
    }

}
