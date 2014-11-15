package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Achilleas Naoumidis on 11/15/14.
 */
public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
