package za.com.csg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.com.csg.entity.ClassRegisterEntity;

@Repository
public interface ClassRegisterRepository  extends JpaRepository<ClassRegisterEntity, Integer> {
}
