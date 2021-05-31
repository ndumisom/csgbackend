package za.com.csg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.com.csg.entity.ClassEntity;
import za.com.csg.entity.GradeEntity;
import za.com.csg.model.ActionStatusType;
import za.com.csg.model.ClassModel;
import za.com.csg.model.GradeModel;
import za.com.csg.repository.GradeRepository;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{

    @Autowired
    GradeRepository gradeRepository;
    @Override
    public ActionStatusType createGrade(GradeModel gradeModel) {
        GradeEntity gradeEntity = new GradeEntity();

        if(gradeModel.getGradeName()!=0) {
            gradeEntity.setGradeName(gradeModel.getGradeName());
            gradeRepository.save(gradeEntity);
            return new ActionStatusType(Boolean.valueOf(true), "grade.created.successful");
        }

           return new ActionStatusType(Boolean.valueOf(true), "mandatory.fields.cannot.be.empty");
    }

    @Override
    public GradeModel getClass(Integer paramInteger) {
        return null;
    }

    @Override
    public List<GradeModel> getGrades() {

        List<GradeEntity> gradeEntities = gradeRepository.findAll();

        List<GradeModel> gradeModels  = new ArrayList<>();

        for(GradeEntity gradeEntity : gradeEntities){

            GradeModel gradeModel = new GradeModel();
            gradeModel.setGradeName(gradeEntity.getGradeName());
            gradeModel.setGradeId(gradeEntity.getGradeId());


            gradeModels.add(gradeModel);
        }
        return gradeModels;
    }

    @Override
    public ActionStatusType delete(Integer paramInteger) {
        return null;
    }
}
