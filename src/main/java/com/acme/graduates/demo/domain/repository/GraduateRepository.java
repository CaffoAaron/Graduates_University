package com.acme.graduates.demo.domain.repository;

import com.acme.graduates.demo.domain.model.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Long> {
}
