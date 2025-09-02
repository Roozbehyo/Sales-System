package com.mftplus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.model.enums.Sex;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
@AssociationOverrides({})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "first_name", columnDefinition = "nvarchar2(20)", nullable = false)
    @JsonProperty("FirstName")
    private String firstName;

    @Column(name = "family_name", columnDefinition = "nvarchar2(30)", nullable = false)
    @JsonProperty("LastName")
    private String familyName;

    @Column(name = "national_id", columnDefinition = "nvarchar2(10)", nullable = false, unique = true)
    @JsonProperty("NationalId")
    private String nationalId;

    @Column(name = "phone", columnDefinition = "nvarchar2(11)", nullable = false, unique = true)
    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @Column(name = "sex", columnDefinition = "nvarchar2(6)", nullable = false)
    @JsonProperty("Sex")
    private Sex sex;
}
