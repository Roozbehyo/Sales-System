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
@Table(name = "banks_branches")
@AssociationOverrides({})
public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JoinColumn(name = "bank_account_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_bank_account"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("BankAccount")
    private BankAccount bankAccount;

    @JoinColumn(name = "store_branch_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_store_branch"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("StoreBranch")
    private StoreBranch storeBranch;
}
