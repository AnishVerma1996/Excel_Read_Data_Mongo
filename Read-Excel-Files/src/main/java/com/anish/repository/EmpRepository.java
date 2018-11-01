package com.anish.repository;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.anish.entity.Employee;
@Repository
public interface EmpRepository extends MongoRepository<Employee,Integer>
{
	@Query(value="{name:?0}")
	List<Profile> findByName(String name);
	
	
	@Query(value="{id:?0}")
	Profile findById(String id);

}
