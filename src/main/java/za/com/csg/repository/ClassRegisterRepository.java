package za.com.csg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.com.csg.entity.ClassRegisterEntity;
import za.com.csg.entity.StudentEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface ClassRegisterRepository  extends JpaRepository<ClassRegisterEntity, Integer> {

    List<ClassRegisterEntity> findByCreateDateTimeBetweenAndStudentEntity(Date startDate, Date endDate, StudentEntity studentEntity);

}
