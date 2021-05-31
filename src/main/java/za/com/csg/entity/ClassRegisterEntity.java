package za.com.csg.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "class_register")
public class ClassRegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_register_id")
    private Integer classRegisterId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @Column(name = "is_present")
    private boolean isPresent;

    @CreationTimestamp
    private Date createDateTime;

    @UpdateTimestamp
    private Date updateDateTime;

    public Integer getClassRegisterId() {
        return classRegisterId;
    }

    public void setClassRegisterId(Integer classRegisterId) {
        this.classRegisterId = classRegisterId;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
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

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
