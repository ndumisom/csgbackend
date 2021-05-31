package za.com.csg.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "class_name")
    private String className;


    @CreationTimestamp
    private Date createDateTime;

    @UpdateTimestamp
    private Date updateDateTime;


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
