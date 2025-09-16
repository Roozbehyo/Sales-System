package com.mftplus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "inventory")
@AssociationOverrides({})
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @OneToMany(mappedBy = "inventory")
    @JsonProperty("Product")
    private List<Product> product;


    @OneToMany(mappedBy = "inventory")
    @JsonProperty("StoreBranch")
    private List<StoreBranch> storeBranches;

    @Column(name = "balance", columnDefinition = "number(*)", nullable = false)
    @JsonProperty("Balance")
    private int balance;
}
