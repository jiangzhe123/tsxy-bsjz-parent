package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/4/11--10:48 视图 病床之空不空 统计
 */
public class SickbedCountDto implements Serializable{

    //非空病床数量
    private Integer notNullNum;

    //空病床数量
    private Integer nullNum;

    public Integer getNotNullNum() {
        return notNullNum;
    }

    public void setNotNullNum(Integer notNullNum) {
        this.notNullNum = notNullNum;
    }

    public Integer getNullNum() {
        return nullNum;
    }

    public void setNullNum(Integer nullNum) {
        this.nullNum = nullNum;
    }
}
