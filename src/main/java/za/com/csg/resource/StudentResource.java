package za.com.csg.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.StudentModel;
import za.com.csg.model.exception.ExceptionResponseType;
import za.com.csg.service.StudentService;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping({"/v1"})
public class StudentResource {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = {"/student"}, method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "Create Student", response = ActionStatusType.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Successful creation of Student", response = ActionStatusType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ActionStatusType addStudent(@ApiParam(name = "studentModel", value = "studentEntity payload", required = true) @Valid @RequestBody StudentModel studentModel) throws IOException, MessagingException {
        return this.studentService.createStudent(studentModel);
    }

    @RequestMapping(value = {"/student/{studentId}"}, method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiResponses({@ApiResponse(code = 200, message = "Successful User search", response = StudentModel.class), @ApiResponse(code = 404, message = "User does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public StudentModel getUser(@ApiParam(name = "studentId", value = "studentId", required = true) @PathVariable Integer studentId) {
        return this.studentService.getStudent(studentId);
    }

    @RequestMapping(value = {"/student/{studentId}"}, method = {RequestMethod.DELETE}, produces = {"application/json"})
    @ApiOperation(value = "Delete Student", response = ActionStatusType.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Successful deletion of student", response = ActionStatusType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ActionStatusType deleteStudent(@ApiParam(name = "studentId", value = "studentId", required = true) @PathVariable Integer studentId) {
        return this.studentService.delete(studentId);
    }

    @RequestMapping(value = {"/students"}, method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get Students", response = StudentModel.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful reminder search", response = StudentModel.class, responseContainer = "List"), @ApiResponse(code = 404, message = "Reminder does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public List<StudentModel> getStudents() throws Exception {
        return this.studentService.getStudents();
    }
}
