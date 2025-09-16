package com.mftplus.model.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@AssociationOverrides({})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name="first_name",columnDefinition = "nvarchar2(20)", nullable = false)
    @JsonProperty("FirstName")
    private String firstName;

    @Column(name="family_name",columnDefinition = "nvarchar2(30)", nullable = false)
    @JsonProperty("LastName")
    private String familyName;

    @OneToMany(mappedBy = "user")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "user")
    private List<UserBranch> userBranches;
}
