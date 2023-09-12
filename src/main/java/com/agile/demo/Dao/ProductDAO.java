package com.agile.demo.Dao;

import com.agile.demo.Entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}

/**
 * 일반적 DAO 클래스 →  인터페이스 - 구현체
 * DAO vs Repository ( 역할 비슷 ) 나는 모르겠음,,
 * 규모가 작은 서비스 - 주로 서비스 레이어 → DB 접근
 * 이 실습에선 DAO를 서비스 레이어와 레포지토리의 중간 계층을 구성하는 역할로 사용
 * Service 객체(object) → Business logic 포함
 */