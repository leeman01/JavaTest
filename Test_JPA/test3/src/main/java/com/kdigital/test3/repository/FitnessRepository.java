package com.kdigital.test3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.test3.entity.FitnessEntity;

public interface FitnessRepository extends JpaRepository<FitnessEntity, Integer> { // PrimaryKey타입이 Integer <= 반드시 객체이어야함

}
