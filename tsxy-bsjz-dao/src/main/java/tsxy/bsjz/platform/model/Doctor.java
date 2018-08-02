package tsxy.bsjz.platform.model;

import tsxy.bsjz.platform.utils.StringUtil;

import java.util.Date;
/**
 * 医师列表
 **/
public class Doctor {
    private Integer id;

    private String name;

    private String phone;

    private String email;

    private Integer sex;

    private Date birthday;

    private String qualificationNum;

    private Integer departmentId;

    private Integer qualificationId;

    private Integer majorId;

    private String college;

    private String education;

    private String goodAt;

    private Date createDate;

    private String birthdayStr;

    private String createDateStr;

    //科室一对一
    private Department department;
    //医师资格管理 一对一
    private Qualification qualification;
    //医师专业 一对一
    private DoctorMajor doctorMajor;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getQualificationNum() {
        return qualificationNum;
    }

    public void setQualificationNum(String qualificationNum) {
        this.qualificationNum = qualificationNum == null ? null : qualificationNum.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt == null ? null : goodAt.trim();
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

    public String getBirthdayStr() {
        if(birthday != null){
            return StringUtil.dateToString(birthday);
        }
        return "";
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthday = StringUtil.stringToDate(birthdayStr);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public DoctorMajor getDoctorMajor() {
        return doctorMajor;
    }

    public void setDoctorMajor(DoctorMajor doctorMajor) {
        this.doctorMajor = doctorMajor;
    }
}