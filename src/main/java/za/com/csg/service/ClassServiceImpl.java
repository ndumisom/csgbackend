package za.com.csg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.com.csg.entity.ClassEntity;
import za.com.csg.entity.ClassRegisterEntity;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.ClassRegisterModel;
import za.com.csg.model.StudentModel;
import za.com.csg.repository.ClassRepository;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{
   @Autowired
    ClassRepository classRepository;
    @Override
    public ActionStatusType createClass(ClassModel classModel) throws IOException, MessagingException {

        ClassEntity classEntity = new ClassEntity();

        if(classModel.getClassName()!=null && !classModel.getClassName().isEmpty()) {
            classEntity.setClassName(classModel.getClassName());
            classRepository.save(classEntity);
            return new ActionStatusType(Boolean.valueOf(true), "class.created.successful");
        }
        return new ActionStatusType(Boolean.valueOf(true), "mandatory.fields.cannot.be.empty");
    }

    @Override
    public ClassModel getClass(Integer paramInteger) {
        return null;
    }

    @Override
    public List<ClassModel> getClasses() {
        List<ClassEntity> classEntities = classRepository.findAll();

        List<ClassModel> classModels = new ArrayList<>();

        for(ClassEntity classEntity : classEntities){

            ClassModel classModel = new ClassModel();
            classModel.setClassName(classEntity.getClassName());
            classModel.setClassId(classEntity.getClassId());


            classModels.add(classModel);
        }
        return classModels;
    }

    @Override
    public ActionStatusType delete(Integer paramInteger) {
        return null;
    }
}
