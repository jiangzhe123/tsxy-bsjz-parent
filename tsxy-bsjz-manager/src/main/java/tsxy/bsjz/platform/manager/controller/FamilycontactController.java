package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.model.Familycontact;
import tsxy.bsjz.platform.service.FamilycontactService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--13:51  患者家庭联系人关系 Familycontact  familycontact
 */
@RestController
@RequestMapping("familycontact")
public class FamilycontactController {

    @Autowired
    private FamilycontactService familycontactService;

    //增加患者家庭联系人信息
    @RequestMapping("/insertIntoFamilycontact")
    public HashMap<String, Object> insertIntoFamilycontact(Familycontact familycontact) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        familycontactService.insertIntoFamilycontact(familycontact);
        return result;
    }

    //批量删除患者家庭联系人信息
    @RequestMapping("/deleteFamilycontactByIds")
    public HashMap<String, Object> deleteFamilycontactByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        familycontactService.deleteFamilycontactByIds(Arrays.asList(ids));
        return result;
    }

    //修改患者家庭联系人信息
    @RequestMapping("/updateFamilycontact")
    public HashMap<String, Object> updateFamilycontact(Familycontact familycontact) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        familycontactService.updateFamilycontact(familycontact);
        return result;
    }

    //查询全部患者家庭联系人信息
    @RequestMapping("/selectAllFamilycontact")
    public HashMap<String, Object> selectAllFamilycontact() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Familycontact> familycontactList = familycontactService.selectAllFamilycontact();
        result.put("familycontactList",familycontactList);
        return result;
    }

}
