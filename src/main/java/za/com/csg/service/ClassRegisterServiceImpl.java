package za.com.csg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.com.csg.entity.ClassEntity;
import za.com.csg.entity.ClassRegisterEntity;
import za.com.csg.entity.GradeEntity;
import za.com.csg.entity.StudentEntity;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.ClassRegisterModel;
import za.com.csg.model.StudentModel;
import za.com.csg.repository.ClassRegisterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRegisterServiceImpl implements ClassRegisterService{
    @Autowired
    ClassRegisterRepository classRegisterRepository;
    @Override
    public ActionStatusType createClassRegister(ClassRegisterModel classRegisterModel) {

        ClassRegisterEntity classRegisterEntity = new ClassRegisterEntity();

        ClassEntity classEntity = new ClassEntity();

        classEntity.setClassId(classRegisterModel.getClassModel().getClassId());

        classRegisterEntity.setClassEntity(classEntity);

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setStudentId(classRegisterModel.getStudentModel().getStudentId());

        classRegisterEntity.setStudentEntity(studentEntity);

        classRegisterEntity.setPresent(classRegisterModel.isPresent());

        classRegisterRepository.save(classRegisterEntity);
        return null;
    }

    @Override
    public ClassModel getClassRegister(Integer paramInteger) {
        return null;
    }

    @Override
    public List<ClassRegisterModel> getClassRegisters() {

        List<ClassRegisterEntity> classRegisterEntities = classRegisterRepository.findAll();

        List<ClassRegisterModel> classRegisterModels = new ArrayList<>();

        for(ClassRegisterEntity classRegisterEntity : classRegisterEntities){

            ClassRegisterModel classRegisterModel = new ClassRegisterModel();
            ClassModel classModel = new ClassModel();
            classModel.setClassName(classRegisterEntity.getClassEntity().getClassName());
            classModel.setClassId(classRegisterEntity.getClassEntity().getClassId());

            StudentModel studentModel = new StudentModel();
            studentModel.setStudentSurname(classRegisterEntity.getStudentEntity().getStudentSurname());
            studentModel.setStudentName(classRegisterEntity.getStudentEntity().getStudentName());
            studentModel.setStudentId(classRegisterEntity.getStudentEntity().getStudentId());

            classRegisterModel.setStudentModel(studentModel);
            classRegisterModel.setCreateDateTime(classRegisterEntity.getCreateDateTime());
            classRegisterModel.setPresent(classRegisterEntity.isPresent());

            classRegisterModel.setClassModel(classModel);

            classRegisterModels.add(classRegisterModel);
        }

        return classRegisterModels;
    }

    @Override
    public ActionStatusType delete(Integer paramInteger) {
        return null;
    }
}
