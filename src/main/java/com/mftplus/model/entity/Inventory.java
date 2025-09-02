package com.mftplus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

    @JoinColumn(name = "product_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_inventory_product"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Product")
    private Product product;

    @JoinColumn(name = "branch_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_inventory_branch"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("StoreBranch")
    private StoreBranch storeBranch;

    @Column(name = "balance", columnDefinition = "number(*)", nullable = false)
    @JsonProperty("Balance")
    private int balance;
}
