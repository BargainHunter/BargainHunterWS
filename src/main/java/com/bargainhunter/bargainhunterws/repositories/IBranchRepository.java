package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranchRepository extends JpaRepository<Branch, Long> {
}
