package com.better.entity;

public class ValidateBean {
    private Integer validateId;

    private Integer oid;

    private String validateCode;

    private Integer status;

    public Integer getValidateId() {
        return validateId;
    }

    public void setValidateId(Integer validateId) {
        this.validateId = validateId;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode == null ? null : validateCode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}