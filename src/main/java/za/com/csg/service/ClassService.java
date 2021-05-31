package za.com.csg.service;

import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.StudentModel;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface ClassService {

    ActionStatusType createClass(ClassModel classModel) throws IOException, MessagingException;

    ClassModel getClass(Integer paramInteger);

    List<ClassModel> getClasses();

    ActionStatusType delete(Integer paramInteger);

}
