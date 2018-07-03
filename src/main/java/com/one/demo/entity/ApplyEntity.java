package com.one.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "APPLY", schema = "PUBLIC", catalog = "SMALLBOOKS")
public class ApplyEntity {
    private BigDecimal id;
    private String applyDate;
    private String applyUsername;
    private String applyReason;
    private BigDecimal bookId;
    private String useDate;
    private String useUsername;
    private BigDecimal useCycle;
    private String checkUsername;
    private BigDecimal status;

    @Id
    @Column(name = "ID", nullable = false, precision = 32767)
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPLY_DATE", nullable = true, length = 25)
    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    @Basic
    @Column(name = "APPLY_USERNAME", nullable = true, length = 100)
    public String getApplyUsername() {
        return applyUsername;
    }

    public void setApplyUsername(String applyUsername) {
        this.applyUsername = applyUsername;
    }

    @Basic
    @Column(name = "APPLY_REASON", nullable = true, length = 200)
    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    @Basic
    @Column(name = "BOOK_ID", nullable = true, precision = 32767)
    public BigDecimal getBookId() {
        return bookId;
    }

    public void setBookId(BigDecimal bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "USE_DATE", nullable = true, length = 25)
    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    @Basic
    @Column(name = "USE_USERNAME", nullable = true, length = 100)
    public String getUseUsername() {
        return useUsername;
    }

    public void setUseUsername(String useUsername) {
        this.useUsername = useUsername;
    }

    @Basic
    @Column(name = "USE_CYCLE", nullable = true, precision = 32767)
    public BigDecimal getUseCycle() {
        return useCycle;
    }

    public void setUseCycle(BigDecimal useCycle) {
        this.useCycle = useCycle;
    }

    @Basic
    @Column(name = "CHECK_USERNAME", nullable = true, length = 100)
    public String getCheckUsername() {
        return checkUsername;
    }

    public void setCheckUsername(String checkUsername) {
        this.checkUsername = checkUsername;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 32767)
    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyEntity that = (ApplyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (applyDate != null ? !applyDate.equals(that.applyDate) : that.applyDate != null) return false;
        if (applyUsername != null ? !applyUsername.equals(that.applyUsername) : that.applyUsername != null)
            return false;
        if (applyReason != null ? !applyReason.equals(that.applyReason) : that.applyReason != null) return false;
        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (useDate != null ? !useDate.equals(that.useDate) : that.useDate != null) return false;
        if (useUsername != null ? !useUsername.equals(that.useUsername) : that.useUsername != null) return false;
        if (useCycle != null ? !useCycle.equals(that.useCycle) : that.useCycle != null) return false;
        if (checkUsername != null ? !checkUsername.equals(that.checkUsername) : that.checkUsername != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applyDate != null ? applyDate.hashCode() : 0);
        result = 31 * result + (applyUsername != null ? applyUsername.hashCode() : 0);
        result = 31 * result + (applyReason != null ? applyReason.hashCode() : 0);
        result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
        result = 31 * result + (useDate != null ? useDate.hashCode() : 0);
        result = 31 * result + (useUsername != null ? useUsername.hashCode() : 0);
        result = 31 * result + (useCycle != null ? useCycle.hashCode() : 0);
        result = 31 * result + (checkUsername != null ? checkUsername.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
