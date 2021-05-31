package za.com.csg.service;

import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.ClassRegisterModel;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface ClassRegisterService {

    ActionStatusType createClassRegister(ClassRegisterModel classRegisterModel);

    ClassModel getClassRegister(Integer paramInteger);

    List<ClassRegisterModel> getClassRegisters();

    ActionStatusType delete(Integer paramInteger);
}
