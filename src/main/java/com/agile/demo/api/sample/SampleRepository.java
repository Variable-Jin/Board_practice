package com.agile.demo.api.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
}

/**
 * JPA(Spring Data) - JpaRepository를 기반으로 쉽게 DB를 사용할 수 있는 아키텍처 제공
 * Spring Boot로 JpaRepository를 상속하는 interface를 생성
 * → 기존의 다양한 메서드를 쉽게 활용 가능
 */