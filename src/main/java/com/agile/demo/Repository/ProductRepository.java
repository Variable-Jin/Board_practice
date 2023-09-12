package com.agile.demo.Repository;

import com.agile.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

/**
 * 접근하려는 Table과 매핑되는 Entity에 대한 interface를 생성
 * ↑ 형식처럼 JpaRepository 상속
 */

/**
 * ProductRepository가 JpaRepository 상속 받을 시 대상 엔티티와 기본값 타입을 지정
 * 대상 엔티티 = Product
 * 해당 엔티티의 @Id 필드 타입인 Long 설정
 */