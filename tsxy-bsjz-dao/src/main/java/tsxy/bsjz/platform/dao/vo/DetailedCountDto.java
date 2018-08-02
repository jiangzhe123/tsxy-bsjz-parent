package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/4/11--10:36 视图清单统计  昨日和今日总金额
 */
public class DetailedCountDto implements Serializable{

    //昨天的清单总金额
    private Double ySum;

    //今日的清单总金额
    private Double tSum;

    public Double getySum() {
        return ySum;
    }

    public void setySum(Double ySum) {
        this.ySum = ySum;
    }

    public Double gettSum() {
        return tSum;
    }

    public void settSum(Double tSum) {
        this.tSum = tSum;
    }
}
