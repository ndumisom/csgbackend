package za.com.csg.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class StudentModel {

    private Integer studentId;
    private String studentName;
    private String studentSurname;
    private ClassModel classModel;
    private GradeModel gradeModel;

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

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }

    public GradeModel getGradeModel() {
        return gradeModel;
    }

    public void setGradeModel(GradeModel gradeModel) {
        this.gradeModel = gradeModel;
    }
}
