package com.mdbytes.bbc.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "system_updates", schema = "bargain_buy_club", catalog = "")
public class SystemUpdate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "update_id")
    private int updateId;
    @Basic
    @Column(name = "update_date")
    private Date updateDate;
    @Basic
    @Column(name = "update_description")
    private String updateDescription;

    public SystemUpdate() {
    }

    public SystemUpdate(Date updateDate, String updateDescription) {
        this.updateDate = updateDate;
        this.updateDescription = updateDescription;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemUpdate that = (SystemUpdate) o;
        return updateId == that.updateId && Objects.equals(updateDate, that.updateDate) && Objects.equals(updateDescription, that.updateDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateId, updateDate, updateDescription);
    }

    @Override
    public String toString() {
        return "SystemUpdate{" +
                "updateDate=" + updateDate +
                ", updateDescription='" + updateDescription + '\'' +
                '}';
    }
}
