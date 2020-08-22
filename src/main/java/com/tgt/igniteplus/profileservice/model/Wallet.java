package com.tgt.igniteplus.profileservice.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Column;
import java.util.UUID;

@Table("wallet")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Wallet {

    //in categoryId - out list of items in a particular category
    @PrimaryKeyColumn(name = "userid",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String userid;
    @PrimaryKeyColumn(name = "walletId",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String walletId= UUID.randomUUID().toString();

    @Column(name="cardholder_name",length=50,nullable=false,unique=true)
    private String cardholderName;

    @Column(name="card_number",length=16,nullable=false,unique=true)
    private Long cardNumber;

    @Column(name="expiry_date",nullable=false)
    private String expiryDate;

    @Column(name="upi_id",length=50,nullable=false,unique=true)
    private String upiId;

}
