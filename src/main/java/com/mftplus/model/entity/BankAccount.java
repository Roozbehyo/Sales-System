package com.mftplus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.model.enums.BankName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "bank_accounts")
@AssociationOverrides({})
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bank_users"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Owner")
    private User user;

    @Column(name = "card_number", columnDefinition = "nvarchar2(16)", nullable = false, unique = true)
    @JsonProperty("CardNumber")
    private String cardNumber;

    @Column(name = "balance", columnDefinition = "number(12)", nullable = false)
    @JsonProperty("Balance")
    private int balance;

    @Column(name = "bank_name", columnDefinition = "nvarchar2(30)", nullable = false)
    @JsonProperty("BankName")
    private BankName bankName;

    @Column(name = "is_deleted", columnDefinition = "number(1)", nullable = false)
    @JsonIgnore
    private boolean isDeleted;

    //TODO--add bank account type like Qarzolhasaneh , one months,etc...
}
