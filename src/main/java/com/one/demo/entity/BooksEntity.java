package com.one.demo.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "BOOKS", schema = "PUBLIC", catalog = "SMALLBOOKS")
public class BooksEntity {
    private Long id;
    private String name;
    private String code;
    private String barCode;
    private String author;
    private BigInteger status;
    private String createDate;
    private Long lastVersion;
    private String remark;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="book_gen")
    @TableGenerator(name = "book_gen",
            table="bk_seq",
            pkColumnName="seq_name",
            valueColumnName="value",
            pkColumnValue="seq_book",
            allocationSize=1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CODE", nullable = true, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "BAR_CODE", nullable = true, length = 30)
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Basic
    @Column(name = "AUTHOR", nullable = true, length = 50)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CREATE_DATE", nullable = false, length = 25)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "LAST_VERSION", nullable = false, precision = 32767)
    public Long getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(Long lastVersion) {
        this.lastVersion = lastVersion;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, length = 400)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (barCode != null ? !barCode.equals(that.barCode) : that.barCode != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (lastVersion != null ? !lastVersion.equals(that.lastVersion) : that.lastVersion != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastVersion != null ? lastVersion.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
