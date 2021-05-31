package za.com.csg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.com.csg.entity.GradeEntity;

public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
}
