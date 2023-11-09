package in.payilagam.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.payilagam.StudentManagement.entity.StudentEntity;

public interface StudentRepo extends 
	JpaRepository<StudentEntity, Long>{

	Object st = null;

}
