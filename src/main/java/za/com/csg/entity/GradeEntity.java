package za.com.csg.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grade")
public class GradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id")
    Integer gradeId;
    @Column(name = "grade_name")
    Integer gradeName;

    @CreationTimestamp
    private Date createDateTime;

    @UpdateTimestamp
    private Date updateDateTime;


    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getGradeName() {
        return gradeName;
    }

    public void setGradeName(Integer gradeName) {
        this.gradeName = gradeName;
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
