package com.mftplus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice_items")
@AssociationOverrides({})
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JoinColumn(name = "invoice_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_items_invoice"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Invoice")
    private Invoice invoice;

    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_items_product"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Product")
    private Product product;

    @Column(name = "quantity", columnDefinition = "number(*)", nullable = false)
    @JsonProperty("Quantity")
    private int quantity;

    @Column(name = "total_price", columnDefinition = "number(*)", nullable = false)
    @JsonProperty("TotalPrice")
    private int totalPrice;
}
