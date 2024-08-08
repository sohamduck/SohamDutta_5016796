package com.employeemanagementsystem.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.dto.EmployeeDTO;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.projection.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    // Method Names Keywords
    Page<Employee> findByDepartmentId(Long departmentID,Pageable pageable);
    // Custom Query Methods
    @Query("SELECT e FROM Employee e WHERE e.email=:email")
    List<Employee> findByEmail(@Param("email") String email);
    @Query("SELECT e FROM Employee e WHERE e.name=:name")
    List<Employee> findByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> findEmployeeProjections();
    @Query("SELECT new com.employeemanagementsystem.dto.EmployeeDTO(e.name,e.email,e.department.name) FROM Employee e")
    List<EmployeeDTO> findEmployeeDTOs();
}
