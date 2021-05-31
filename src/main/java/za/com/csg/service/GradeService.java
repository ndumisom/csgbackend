package za.com.csg.service;

import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.GradeModel;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface GradeService {

    ActionStatusType createGrade(GradeModel gradeModel) throws IOException, MessagingException;

    GradeModel getClass(Integer paramInteger);

    List<GradeModel> getGrades();

    ActionStatusType delete(Integer paramInteger);
}
