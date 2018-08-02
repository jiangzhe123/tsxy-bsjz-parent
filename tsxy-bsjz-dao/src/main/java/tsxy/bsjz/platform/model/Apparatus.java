package tsxy.bsjz.platform.model;

import java.math.BigDecimal;

public class Apparatus {
    private Integer id;

    private String name;

    private BigDecimal appPrice;

    private String appPosition;

    private Integer classifyId;

    private Integer appState;

    //仪器分类 一对一
    private ApparatusClassify apparatusClassify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(BigDecimal appPrice) {
        this.appPrice = appPrice;
    }

    public String getAppPosition() {
        return appPosition;
    }

    public void setAppPosition(String appPosition) {
        this.appPosition = appPosition == null ? null : appPosition.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getAppState() {
        return appState;
    }

    public void setAppState(Integer appState) {
        this.appState = appState;
    }

    public ApparatusClassify getApparatusClassify() {
        return apparatusClassify;
    }

    public void setApparatusClassify(ApparatusClassify apparatusClassify) {
        this.apparatusClassify = apparatusClassify;
    }
}