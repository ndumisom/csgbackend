package za.com.csg.service;

import za.com.csg.entity.StudentEntity;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.ClassRegisterModel;
import za.com.csg.model.ClassRegisterModelSearch;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ClassRegisterService {

    ActionStatusType createClassRegister(ClassRegisterModel classRegisterModel);

    ClassModel getClassRegister(Integer paramInteger);

    List<ClassRegisterModel> getClassRegisters();

    List<ClassRegisterModel> findByCreateDateTimebetweenAndStudentEntity(Date startDate, Date endDate, StudentEntity studentEntity);

    ActionStatusType delete(Integer paramInteger);

    public List<ClassRegisterModel> findByCreateDateTimebetweenAndStudent(ClassRegisterModelSearch classRegisterModel);
}
