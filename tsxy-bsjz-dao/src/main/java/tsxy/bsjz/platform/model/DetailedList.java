package tsxy.bsjz.platform.model;

import tsxy.bsjz.platform.utils.StringUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DetailedList {
    private Integer id;

    private Integer patientId;

    private BigDecimal totalPrice;

    private Date detailedDate;

    private String detailedDateStr;

    //患者  一对一
    private Patient patient;

    //此清单对应的药品们 一对多
    private List<DetailedMedicine> detailedMedicineList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDetailedDate() {
        return detailedDate;
    }

    public void setDetailedDate(Date detailedDate) {
        this.detailedDate = detailedDate;
    }

    public String getDetailedDateStr() {
        if(detailedDate != null){
            return StringUtil.dateToString(detailedDate);
        }
        return "";
    }

    public List<DetailedMedicine> getDetailedMedicineList() {
        return detailedMedicineList;
    }

    public void setDetailedMedicineList(List<DetailedMedicine> detailedMedicineList) {
        this.detailedMedicineList = detailedMedicineList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}