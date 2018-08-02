package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/2/28--9:49
 */
public class RouteSearchDto extends PageHelpDto implements Serializable{

    private String orderByClause;

    private String name;

    private String title;

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
