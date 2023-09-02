package com.mtattab.emailservice.repository;

import com.mtattab.emailservice.entity.EmailTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(exported = false)
@Repository
public interface EmailRepository extends JpaRepository<EmailTableEntity, Long> {
    @Query("SELECT u.email FROM EmailTableEntity u")
    List<String> getAllEmailsFromTable();

    @Query("SELECT u.password FROM EmailTableEntity u WHERE LOWER(u.email) = LOWER(:email)")
    String getPasswordForEmail(@Param("email") String email);
}
