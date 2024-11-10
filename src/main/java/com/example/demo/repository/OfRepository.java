package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OfEntity;
@Repository
public interface OfRepository extends JpaRepository<OfEntity, Long> {

	OfEntity findByLoadingPortAndUnloadingPort(int loading, String unloadingPort);


}
