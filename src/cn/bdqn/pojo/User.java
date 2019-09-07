package cn.bdqn.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author: 赵林
 * @Date: 2019/9/4 8:39
 * @Description:
 */
public class User {
    private int id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private int createdBy;
    @JSONField(format = "yyyy-MM-dd")
    private String creationDate;
    private Date modifyDate;
    private int modifyBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProContact() {
        return proContact;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProFax() {
        return proFax;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String createionDate) {
        this.creationDate = createionDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public User() {
    }

    public User(String proCode, String proName, String proContact, String proPhone, String proAddress, String creationDate) {
        this.proCode = proCode;
        this.proName = proName;
        this.proContact = proContact;
        this.proPhone = proPhone;
        this.proAddress = proAddress;
        this.creationDate = creationDate;
    }

    public User(int id, String proCode, String proName, String proContact, String proPhone, String proAddress, String creationDate) {
        this.id = id;
        this.proCode = proCode;
        this.proName = proName;
        this.proContact = proContact;
        this.proPhone = proPhone;
        this.proAddress = proAddress;
        this.creationDate = creationDate;
    }
}
