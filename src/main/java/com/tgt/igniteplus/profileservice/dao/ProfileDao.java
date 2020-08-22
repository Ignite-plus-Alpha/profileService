package com.tgt.igniteplus.profileservice.dao;

import com.tgt.igniteplus.profileservice.model.Profile;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDao extends CassandraRepository<Profile,String> {

}