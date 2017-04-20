package com.example;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017-04-20.
 */
@Entity
@Table(name = "timestamps", schema = "public", catalog = "dct2r6gnlhqdhu")
public class TimestampsEntity {
    private int id;
    private Timestamp startdate;
    private Timestamp enddate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "startdate", nullable = false)
    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate", nullable = true)
    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimestampsEntity that = (TimestampsEntity) o;

        if (id != that.id) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        return result;
    }
}
