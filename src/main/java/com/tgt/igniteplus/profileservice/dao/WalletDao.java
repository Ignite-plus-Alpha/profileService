package com.tgt.igniteplus.profileservice.dao;

import com.tgt.igniteplus.profileservice.model.Address;
import com.tgt.igniteplus.profileservice.model.Wallet;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletDao extends CassandraRepository<Wallet,String> {

    List<Wallet> findByUserid(String userId);

}
