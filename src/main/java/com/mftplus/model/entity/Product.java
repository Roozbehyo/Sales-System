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
@Table(name = "products")
@AssociationOverrides({})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "name", columnDefinition = "nvarchar2(50)", nullable = false)
    @JsonProperty("Product")
    private String name;

    @Column(name = "price", columnDefinition = "number(*)", nullable = false)
    @JsonProperty("Price")
    private int price;

    @Column(name = "is_deleted", columnDefinition = "number(1)", nullable = false)
    @JsonIgnore
    private boolean isDeleted;
}
