package com.one.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES", schema = "PUBLIC", catalog = "SMALLBOOKS")
public class MessagesEntity {
    private Long id;
    private String username;
    private String msg;
    private String createDate;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="message_gen")
    @TableGenerator(name = "message_gen",
            table="bk_seq",
            pkColumnName="seq_name",
            valueColumnName="value",
            pkColumnValue="seq_message",
            allocationSize=1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "MSG", nullable = true, length = 100)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "CREATE_DATE", nullable = true, length = 25)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagesEntity that = (MessagesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
