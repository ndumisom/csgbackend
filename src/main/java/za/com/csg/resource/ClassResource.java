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
import za.com.csg.model.*;
import za.com.csg.model.exception.ExceptionResponseType;
import za.com.csg.service.ClassService;
import za.com.csg.service.StudentService;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping({"/v1"})
public class ClassResource {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;
    @RequestMapping(value = {"/class"}, method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "Create class", response = ActionStatusType.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Successful creation of Student", response = ActionStatusType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ActionStatusType addUser(@ApiParam(name = "classModel", value = "classEntity payload", required = true) @Valid @RequestBody ClassModel classModel) throws IOException, MessagingException {
        return this.classService.createClass(classModel);
    }

    @RequestMapping(value = {"/classes"}, method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get Students", response = ClassModel.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful reminder search", response = ClassModel.class, responseContainer = "List"), @ApiResponse(code = 404, message = "Reminder does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public List<ClassModel> getStudents() throws Exception {
        return this.classService.getClasses();
    }

}
