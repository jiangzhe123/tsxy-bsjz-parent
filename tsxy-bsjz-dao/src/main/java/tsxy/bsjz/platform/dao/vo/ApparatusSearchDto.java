package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/4/3--9:25
 */
public class ApparatusSearchDto extends PageHelpDto implements Serializable{

    private String name;

    private String orderByClause;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
