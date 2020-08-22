package com.tgt.igniteplus.profileservice.dao;

import com.tgt.igniteplus.profileservice.model.Address;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends CassandraRepository<Address,String> {
    //fetch list of addresses associated with an email
    List<Address> findByUserid(String userId);

}
