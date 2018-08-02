package tsxy.bsjz.platform.model;

import java.math.BigDecimal;

public class Medicine {
    private Integer id;

    private String name;

    private BigDecimal salePrice;

    private Integer inventory;

    private Integer inventoryWarn;

    private String remark;

    private String description;

    //药品分类ID
    private Integer classifyId;

    //药品单位ID
    private Integer unitId;

    //药品厂家ID
    private Integer factoryId;

    //药品分类 一对一
    private MedicineClassify medicineClassify;

    //药品单位 一对一
    private MedicineUnit medicineUnit;

    //药品厂家 一对一
    private MedicineFactory medicineFactory;

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

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getInventoryWarn() {
        return inventoryWarn;
    }

    public void setInventoryWarn(Integer inventoryWarn) {
        this.inventoryWarn = inventoryWarn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public MedicineClassify getMedicineClassify() {
        return medicineClassify;
    }

    public void setMedicineClassify(MedicineClassify medicineClassify) {
        this.medicineClassify = medicineClassify;
    }

    public MedicineUnit getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(MedicineUnit medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    public MedicineFactory getMedicineFactory() {
        return medicineFactory;
    }

    public void setMedicineFactory(MedicineFactory medicineFactory) {
        this.medicineFactory = medicineFactory;
    }
}