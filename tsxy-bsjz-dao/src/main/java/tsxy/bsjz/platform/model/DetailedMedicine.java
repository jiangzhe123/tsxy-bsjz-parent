package tsxy.bsjz.platform.model;

import java.math.BigDecimal;

public class DetailedMedicine {
    private Integer id;

    private Integer detailedId;

    private Integer medicineId;

    private Integer medicineNum;

    private BigDecimal medicinePrice;

    //药品 一对一
    private Medicine medicine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDetailedId() {
        return detailedId;
    }

    public void setDetailedId(Integer detailedId) {
        this.detailedId = detailedId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getMedicineNum() {
        return medicineNum;
    }

    public void setMedicineNum(Integer medicineNum) {
        this.medicineNum = medicineNum;
    }

    public BigDecimal getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(BigDecimal medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}