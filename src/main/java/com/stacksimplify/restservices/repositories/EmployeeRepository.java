package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.entities.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	User findByName(String name);
}
