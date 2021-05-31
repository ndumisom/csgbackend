package za.com.csg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.com.csg.entity.ClassEntity;
@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {
}
