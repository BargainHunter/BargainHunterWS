package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Long> {
}
