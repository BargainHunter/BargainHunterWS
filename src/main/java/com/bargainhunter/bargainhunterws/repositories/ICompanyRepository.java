package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
