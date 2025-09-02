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
@Table(name = "users_branches")
@AssociationOverrides({})
public class UserBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_user_id"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("Seller")
    private User user;

    @JoinColumn(name = "store_branch_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_store_branch_id"))
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty("StoreBranch")
    private StoreBranch storeBranch;
}
