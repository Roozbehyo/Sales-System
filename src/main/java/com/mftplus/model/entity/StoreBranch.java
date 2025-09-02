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
@Table(name = "store_branches")
@AssociationOverrides({})
public class StoreBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "branch_name", columnDefinition = "nvarchar2(30)", nullable = false)
    @JsonProperty("BranchName")
    private String name;

    @Column(name = "branch_address", columnDefinition = "nvarchar2(200)", nullable = false)
    @JsonProperty("BranchAddress")
    private String address;

    @Column(name = "is_deleted", columnDefinition = "number(1)")
    @JsonIgnore
    private boolean isDeleted;

}
