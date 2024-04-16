package com.azure.demosql.repo;

import com.azure.demosql.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Credentials,String> {
}
