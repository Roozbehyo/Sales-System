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
@Table(name = "invoices")
@AssociationOverrides({})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_invoice_user"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Seller")
    private User user;

    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_invoice_customer"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Customer")
    private Customer customer;

    @JoinColumn(name = "branch_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_invoice_branch"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Branch")
    private StoreBranch storeBranch;

    @Column(name = "order_date", columnDefinition = "date", nullable = false)
    @JsonProperty("OrderDate")
    private LocalDate orderDate;

    @Column(name = "invoice_total_price", columnDefinition = "number(*)", nullable = false)
    @JsonProperty("InvoiceTotalPrice")
    private int invoiceTotalPrice;
}
