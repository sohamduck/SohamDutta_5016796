package com.app.bookstoreapi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    @JsonIgnore
    private Long number;
    @JsonProperty("number")
    public String getFormattedNumber(){
        return String.format("%d",number);
    }
    @JsonProperty("number")
    public void setFormattedNumber(String number){
        this.number=Long.parseLong(number.replace(",", ""));
    }
}
