package za.com.csg.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "name")
    String studentName;

    @Column(name = "student_surname")
    String studentSurname;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private GradeEntity gradeEntity;

    @CreationTimestamp
    private Date createDateTime;

    @UpdateTimestamp
    private Date updateDateTime;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
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

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public GradeEntity getGradeEntity() {
        return gradeEntity;
    }

    public void setGradeEntity(GradeEntity gradeEntity) {
        this.gradeEntity = gradeEntity;
    }
}
