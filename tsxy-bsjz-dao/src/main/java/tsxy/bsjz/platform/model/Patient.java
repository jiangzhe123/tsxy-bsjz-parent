package tsxy.bsjz.platform.model;

import tsxy.bsjz.platform.utils.StringUtil;

import java.util.Date;

public class Patient {
    private Integer id;

    private String name;

    private String phone;

    private Integer sex;

    private Date birthday;

    private String birthdayStr;

    private String identity;

    private String familyPhone;

    private Integer familyContactId;

    private Integer departmentId;

    private Integer doctorId;

    private String allergy;

    private Integer patientState;

    private Date createDate;

    private String createDateStr;

    //患者家庭联系人 一对一
    private Familycontact familyContact;

    //患者所属科室 一对一
    private Department department;

    //患者私人医生 一对一
    private Doctor doctor;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone == null ? null : familyPhone.trim();
    }

    public Integer getFamilyContactId() {
        return familyContactId;
    }

    public void setFamilyContactId(Integer familyContactId) {
        this.familyContactId = familyContactId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy == null ? null : allergy.trim();
    }

    public Integer getPatientState() {
        return patientState;
    }

    public void setPatientState(Integer patientState) {
        this.patientState = patientState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateStr() {
        if(createDate != null){
            return StringUtil.dateToString(createDate);
        }
        return "";
    }

    public Familycontact getFamilycontact() {
        return familyContact;
    }

    public void setFamilycontact(Familycontact familyContact) {
        this.familyContact = familyContact;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getBirthdayStr() {
        if(birthday != null){
            return StringUtil.dateToString(birthday);
        }
        return "";
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthday = StringUtil.stringToDate(birthdayStr);
    }

}