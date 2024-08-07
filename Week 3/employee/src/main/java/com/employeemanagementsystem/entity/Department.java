package com.employeemanagementsystem.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(
        name="Department.findByName",
        query="SELECT d FROM Department d WHERE d.name=:name"
    )
})
public class Department {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
