package za.com.csg.service;

import za.com.csg.model.ActionStatusType;
import za.com.csg.model.StudentModel;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface StudentService {
    ActionStatusType createStudent(StudentModel studentModel) throws IOException, MessagingException;

    StudentModel getStudent(Integer paramInteger);

    List<StudentModel> getStudents();

    ActionStatusType delete(Integer paramInteger);

}
