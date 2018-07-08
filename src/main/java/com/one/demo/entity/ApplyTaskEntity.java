package com.one.demo.entity;

import com.one.demo.utils.DateUtil;
import com.one.demo.utils.DefaultConfigure;

import javax.persistence.*;

@Entity
@Table(name = "APPLY_TASK", schema = "PUBLIC", catalog = "SMALLBOOKS")
public class ApplyTaskEntity {
    private Long id;
    private Long applyId;
    private String applyDate;
    private String applyUsername;
    private String applyReason;
    private String useDate;
    private String useUsername;
    private Integer useCycle;
    private String checkUsername;
    private String checkDate;
    private Integer type;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="apply_task_gen")
    @TableGenerator(name = "apply_task_gen",
            table="bk_seq",
            pkColumnName="seq_name",
            valueColumnName="value",
            pkColumnValue="seq_apply_task",
            allocationSize=1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPLY_ID", nullable = true, precision = 32767)
    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
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
    public Integer getUseCycle() {
        return useCycle;
    }

    public void setUseCycle(Integer useCycle) {
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
    @Column(name = "CHECK_DATE", nullable = true, length = 25)
    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, precision = 32767)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 32767)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean borrowCheckStatus(){
        return this.type == DefaultConfigure.TASK_TYPE_APPLY &&
                    this.status == DefaultConfigure.TASK_STATUS_CHECK;
    }
    public void checkSuccess(String checkUsername){
        this.status =DefaultConfigure.TASK_STATUS_SUCCESS;
        this.checkUsername = checkUsername;
        this.checkDate = DateUtil.getNow();
        this.useCycle = DefaultConfigure.APPLY_CYCLE;
    }
    public void checkFault(String checkUsername, String reason){
        this.status =DefaultConfigure.TASK_STATUS_BACK;
        this.checkUsername = checkUsername;
        this.checkDate = DateUtil.getNow();
        this.applyReason = reason;
    }
    public void checkCancel(String checkUsername, String reason){
        this.status =DefaultConfigure.TASK_STATUS_CANCEL;
        this.checkUsername = checkUsername;
        this.checkDate = DateUtil.getNow();
        this.applyReason = reason;
    }
    public boolean borrowPullStatus(){
        return this.type == DefaultConfigure.TASK_TYPE_APPLY &&
                this.status == DefaultConfigure.TASK_STATUS_SUCCESS;
    }
    public void borrowPull(){
        this.status =DefaultConfigure.TASK_STATUS_PULL_SUCCESS;
        this.useDate = DateUtil.getNow();
    }

    public boolean lazyCheckStatus(){
        return this.type == DefaultConfigure.TASK_TYPE_LAZY &&
                this.status == DefaultConfigure.TASK_STATUS_CHECK;
    }

    public boolean backCheckStatus(){
        return this.type == DefaultConfigure.TASK_TYPE_BACK &&
                this.status == DefaultConfigure.TASK_STATUS_CHECK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyTaskEntity that = (ApplyTaskEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (applyId != null ? !applyId.equals(that.applyId) : that.applyId != null) return false;
        if (applyDate != null ? !applyDate.equals(that.applyDate) : that.applyDate != null) return false;
        if (applyUsername != null ? !applyUsername.equals(that.applyUsername) : that.applyUsername != null)
            return false;
        if (applyReason != null ? !applyReason.equals(that.applyReason) : that.applyReason != null) return false;
        if (useDate != null ? !useDate.equals(that.useDate) : that.useDate != null) return false;
        if (useUsername != null ? !useUsername.equals(that.useUsername) : that.useUsername != null) return false;
        if (useCycle != null ? !useCycle.equals(that.useCycle) : that.useCycle != null) return false;
        if (checkUsername != null ? !checkUsername.equals(that.checkUsername) : that.checkUsername != null)
            return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applyId != null ? applyId.hashCode() : 0);
        result = 31 * result + (applyDate != null ? applyDate.hashCode() : 0);
        result = 31 * result + (applyUsername != null ? applyUsername.hashCode() : 0);
        result = 31 * result + (applyReason != null ? applyReason.hashCode() : 0);
        result = 31 * result + (useDate != null ? useDate.hashCode() : 0);
        result = 31 * result + (useUsername != null ? useUsername.hashCode() : 0);
        result = 31 * result + (useCycle != null ? useCycle.hashCode() : 0);
        result = 31 * result + (checkUsername != null ? checkUsername.hashCode() : 0);
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
