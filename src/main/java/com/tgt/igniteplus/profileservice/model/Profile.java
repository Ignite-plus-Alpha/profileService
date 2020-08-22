package com.tgt.igniteplus.profileservice.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Table("profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Profile {

    @PrimaryKey
    @Column(name="email",length=30,nullable=false)
    @NonNull
    private String email;

    @Column(name="user_id",nullable=false,unique=true)
    private String userId= UUID.randomUUID().toString();;

    @Column(name="first_name",length=50)
    private String firstName;

    @Column(name="last_name",length=50)
    private String lastName;

    @Column(name="mobile",length=10)
    private String mobile;

    @Column(name="password",length=30)
    private String password;

    @Column(name="default_address",length=30)
    private String defaultAddress;
    @Column(name="default_card",length=30)
    private String defaultCard;
}