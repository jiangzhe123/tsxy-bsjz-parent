package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/4/11--10:32  视图科室统计
 */
public class DepartCountDto implements Serializable{

    //科室名称
    private String name;

    //此科室医生的数量
    private Integer dNum;

    //此科室患者的数量
    private Integer pNum;

    //此科室病床的数量
    private Integer sNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getdNum() {
        return dNum;
    }

    public void setdNum(Integer dNum) {
        this.dNum = dNum;
    }

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {
        this.pNum = pNum;
    }

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }
}
