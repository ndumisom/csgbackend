package za.com.csg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.com.csg.entity.ClassEntity;
import za.com.csg.entity.GradeEntity;
import za.com.csg.entity.StudentEntity;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.GradeModel;
import za.com.csg.model.StudentModel;
import za.com.csg.repository.StudentRepository;

import javax.mail.MessagingException;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ActionStatusType createStudent(StudentModel studentModel) {

             if(studentModel.getStudentName() == null || studentModel.getStudentName().isEmpty()||
                studentModel.getStudentSurname() == null || studentModel.getStudentSurname().isEmpty()||
                studentModel.getClassModel().getClassId() == 0 || studentModel.getGradeModel().getGradeId() == 0

        ){
            return new ActionStatusType(Boolean.valueOf(true), "mandatory.fields.cannot.be.empty");
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setStudentName(studentModel.getStudentName());
        studentEntity.setStudentSurname(studentModel.getStudentSurname());

        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassId(studentModel.getClassModel().getClassId());
        studentEntity.setClassEntity(classEntity);

        GradeEntity gradeEntity = new GradeEntity();

        gradeEntity.setGradeId(studentModel.getGradeModel().getGradeId());
        studentEntity.setGradeEntity(gradeEntity);

        studentRepository.save(studentEntity);
        return new ActionStatusType(Boolean.valueOf(true), "student.created.successful");
    }

    @Override
    public StudentModel getStudent(Integer paramInteger) {
        StudentModel studentModel = new StudentModel();
        StudentEntity studentEntity = studentRepository.getOne(paramInteger);

        if(studentEntity.getStudentName()!=null && !studentEntity.getStudentName().isEmpty()) {
            studentModel.setStudentName(studentEntity.getStudentName());
        }

        if(studentEntity.getStudentSurname()!=null && !studentEntity.getStudentSurname().isEmpty()) {
            studentModel.setStudentSurname(studentEntity.getStudentSurname());
        }

        ClassModel classModel = new ClassModel();

        if(studentEntity.getClassEntity().getClassName()!=null && !studentEntity.getClassEntity().getClassName().isEmpty()) {
            classModel.setClassName(studentEntity.getClassEntity().getClassName());
        }
        if(studentEntity.getClassEntity().getClassId()!=0) {
            classModel.setClassId(studentEntity.getClassEntity().getClassId());
        }
        GradeModel gradeModel = new GradeModel();
        if(studentEntity.getGradeEntity().getGradeName()!=0) {
            gradeModel.setGradeName(studentEntity.getGradeEntity().getGradeName());
        }

        if(studentEntity.getGradeEntity().getGradeId()!=0) {
            gradeModel.setGradeId(studentEntity.getGradeEntity().getGradeId());
        }
        studentModel.setClassModel(classModel);
        studentModel.setGradeModel(gradeModel);

        return studentModel;
    }

    @Override
    public List<StudentModel> getStudents() {

        List<StudentModel> studentModels = new ArrayList<>();
        List<StudentEntity> studentEntities = studentRepository.findAll();

        for(StudentEntity studentEntity : studentEntities){

            StudentModel studentModel = new StudentModel();

            studentModel.setStudentId(studentEntity.getStudentId());
            studentModel.setStudentName(studentEntity.getStudentName());
            studentModel.setStudentSurname(studentEntity.getStudentSurname());
            GradeModel gradeModel = new GradeModel();
            gradeModel.setGradeId(studentEntity.getGradeEntity().getGradeId());
            gradeModel.setGradeName(studentEntity.getGradeEntity().getGradeName());
            gradeModel.setCreateDateTime(studentEntity.getCreateDateTime());

            ClassModel classModel = new ClassModel();

            classModel.setClassId(studentEntity.getClassEntity().getClassId());
            classModel.setClassName(studentEntity.getClassEntity().getClassName());

            studentModel.setGradeModel(gradeModel);
            studentModel.setClassModel(classModel);

            studentModels.add(studentModel);
        }
        return studentModels;
    }

    @Override
    public ActionStatusType delete(Integer paramInteger) {
        StudentEntity studentEntity = studentRepository.getOne(paramInteger);

        if(studentEntity.getStudentId()!=0 || studentEntity.getStudentName()!=null || !studentEntity.getStudentName().isEmpty()) {
            studentRepository.delete(studentEntity);
            return new ActionStatusType(Boolean.valueOf(true), "student.deleted.successful");
        }
        return new ActionStatusType(Boolean.valueOf(false), "student.does.not.exists");
    }

}
