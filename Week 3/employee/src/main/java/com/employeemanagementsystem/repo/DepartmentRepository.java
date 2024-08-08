package com.employeemanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.dto.DepartmentDTO;
import com.employeemanagementsystem.entity.Department;
import com.employeemanagementsystem.projection.DepartmentProjection;

import java.util.List;



@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    // Named Queries
    List<Department> findByName(@Param("name") String name);

    @Query("SELECT d FROM Department d")
    List<DepartmentProjection> findDepartmentProjections();
    @Query("SELECT new com.employeemanagementsystem.dto.DepartmentDTO(d.name,size(d.employees)) FROM Department d")
    List<DepartmentDTO> findDepartmentDTOs();
}
