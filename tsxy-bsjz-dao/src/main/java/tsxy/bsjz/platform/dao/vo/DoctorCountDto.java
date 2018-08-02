package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/4/11--10:40 视图医师职位下的医生的数量
 */
public class DoctorCountDto implements Serializable{

    //医师职位名称
    private String name;

    //此职位下的医生的数量
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
