package za.com.csg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.com.csg.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
