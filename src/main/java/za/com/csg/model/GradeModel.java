package za.com.csg.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class GradeModel {

    Integer gradeId;
    Integer gradeName;

    private Date createDateTime;

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
