package za.com.csg.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.GradeModel;
import za.com.csg.model.exception.ExceptionResponseType;
import za.com.csg.service.GradeService;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping({"/v1"})
public class GradeResource {

    @Autowired
    GradeService gradeService;
    @RequestMapping(value = {"/grade"}, method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "Create class", response = ActionStatusType.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Successful creation of Grade", response = ActionStatusType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ActionStatusType addUser(@ApiParam(name = "gradeModel", value = "gradeEntity payload", required = true) @Valid @RequestBody GradeModel gradeModel) throws IOException, MessagingException {
        return this.gradeService.createGrade(gradeModel);
    }


    @RequestMapping(value = {"/grades"}, method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get Students", response = GradeModel.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful reminder search", response = GradeModel.class, responseContainer = "List"), @ApiResponse(code = 404, message = "Reminder does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public List<GradeModel> getStudents() throws Exception {
        return this.gradeService.getGrades();
    }
}
