package com.wtys.jobs.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wtys.jobs.persistance.entity.DocumentJob;

@Repository
public interface DocumentJobRepository extends MongoRepository<DocumentJob, String> {
}
