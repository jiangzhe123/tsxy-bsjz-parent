package tsxy.bsjz.platform.model;

import tsxy.bsjz.platform.utils.StringUtil;

import java.util.Date;

public class HandleRecord {
    private Integer id;

    private String handleName;

    private String handleRole;

    private String handleContent;

    private Date handleDate;

    private Integer deleteState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName == null ? null : handleName.trim();
    }

    public String getHandleRole() {
        return handleRole;
    }

    public void setHandleRole(String handleRole) {
        this.handleRole = handleRole == null ? null : handleRole.trim();
    }

    public String getHandleContent() {
        return handleContent;
    }

    public void setHandleContent(String handleContent) {
        this.handleContent = handleContent == null ? null : handleContent.trim();
    }

    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }

    public String getHandleDateStr() {
        if(handleDate != null){
            return StringUtil.dateToString(handleDate);
        }
        return "";
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
    }
}