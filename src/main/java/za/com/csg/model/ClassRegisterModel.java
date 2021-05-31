package za.com.csg.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class ClassRegisterModel {
    private ClassModel classModel;
    private StudentModel studentModel;
    private boolean isPresent;
    private Date createDateTime;
    private Date updateDateTime;

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
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
