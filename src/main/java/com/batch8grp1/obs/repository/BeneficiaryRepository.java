package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.batch8grp1.obs.entity.Beneficiary;

@EnableJpaRepositories
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary,String>{
	
	List<Beneficiary> findAll();

}
