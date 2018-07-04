package com.one.demo.entity;

import com.one.demo.utils.DateUtil;
import com.one.demo.utils.DefaultConfigure;

import javax.persistence.*;

@Entity
@Table(name = "APPLY", schema = "PUBLIC", catalog = "SMALLBOOKS")
public class ApplyEntity {
    private Long id;
    private String applyCode;
    private String createDate;
    private String applyUsername;
    private String applyReason;
    private Long bookId;
    private Integer borrowCycle;
    private String startDate;
    private String backDate;
    private Integer lazyNum;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="apply_gen")
    @TableGenerator(name = "apply_gen",
            table="bk_seq",
            pkColumnName="seq_name",
            valueColumnName="value",
            pkColumnValue="seq_apply",
            allocationSize=1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPLY_CODE", nullable = true, length = 30)
    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    @Basic
    @Column(name = "CREATE_DATE", nullable = true, length = 25)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "BORROW_CYCLE", nullable = true, precision = 32767)
    public Integer getBorrowCycle() {
        return borrowCycle;
    }

    public void setBorrowCycle(Integer borrowCycle) {
        this.borrowCycle = borrowCycle;
    }

    @Basic
    @Column(name = "START_DATE", nullable = true, length = 25)
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "BACK_DATE", nullable = true, length = 25)
    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    @Basic
    @Column(name = "LAZY_NUM", nullable = true, precision = 32767)
    public Integer getLazyNum() {
        return lazyNum;
    }

    public void setLazyNum(Integer lazyNum) {
        this.lazyNum = lazyNum;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 32767)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 借阅申请
     */
    public void borrowInit(){
        this.createDate = DateUtil.getNow();
        this.lazyNum = 0;
        this.borrowCycle = 0 ;
        this.status = DefaultConfigure.APPLY_STATUS_BORROW_APPLY;
    }
    public void borrowStayPull(){
        this.startDate = DateUtil.getNow();
        this.borrowCycle = DefaultConfigure.APPLY_CYCLE;
        this.status=DefaultConfigure.APPLY_STATUS_BORROW_STAY_PULL;
    }
    public void borrowFinishPull(){
        this.status= DefaultConfigure.APPLY_STATUS_BORROW_FINISH_PULL;
    }
    public void borrowCancel(){
        this.applyReason = "取消申请";
        this.status = DefaultConfigure.APPLY_STATUS_BORROW_CANCEL_APPLY;
    }
    public boolean finishPull(){
        return this.status == DefaultConfigure.APPLY_STATUS_BORROW_FINISH_PULL;
    }

    public boolean finishPullOrLazyOrCancel(){
        return this.status == DefaultConfigure.APPLY_STATUS_BORROW_FINISH_PULL ||
                    this.status == DefaultConfigure.APPLY_STATUS_LAZY_FINISH ||
                    this.status == DefaultConfigure.APPLY_STATUS_LAZY_CANCEL;
    }

    public void lazyInit(){
        this.status = DefaultConfigure.APPLY_STATUS_LAZY_APPLY;
    }
    public void lazyFinish(){
        this.status = DefaultConfigure.APPLY_STATUS_LAZY_FINISH;
        this.lazyNum = this.lazyNum++;
        this.borrowCycle += DefaultConfigure.APPLY_CYCLE;
    }
    public void lazyCancel(){
        this.status =DefaultConfigure.APPLY_STATUS_LAZY_CANCEL;
    }
    public void backInit(){
        this.status = DefaultConfigure.APPLY_STATUS_BACK_APPLY;
    }
    public void backFinish(){
        this.status = DefaultConfigure.APPLY_STATUS_BACK_FINISH;
        this.backDate = DateUtil.getNow();
    }
    public void backCancel(){
        this.status = DefaultConfigure.APPLY_STATUS_BACK_CANCEL;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyEntity that = (ApplyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (applyCode != null ? !applyCode.equals(that.applyCode) : that.applyCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (applyUsername != null ? !applyUsername.equals(that.applyUsername) : that.applyUsername != null)
            return false;
        if (applyReason != null ? !applyReason.equals(that.applyReason) : that.applyReason != null) return false;
        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (borrowCycle != null ? !borrowCycle.equals(that.borrowCycle) : that.borrowCycle != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (backDate != null ? !backDate.equals(that.backDate) : that.backDate != null) return false;
        if (lazyNum != null ? !lazyNum.equals(that.lazyNum) : that.lazyNum != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applyCode != null ? applyCode.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (applyUsername != null ? applyUsername.hashCode() : 0);
        result = 31 * result + (applyReason != null ? applyReason.hashCode() : 0);
        result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
        result = 31 * result + (borrowCycle != null ? borrowCycle.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (backDate != null ? backDate.hashCode() : 0);
        result = 31 * result + (lazyNum != null ? lazyNum.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
