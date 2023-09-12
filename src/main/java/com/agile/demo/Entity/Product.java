package com.agile.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@Getter
@Setter

/**
 *  @Table 어노테이션 명시x -> 테이블 이름과 클래스 이름 동일
 *  대체로 JAVA 명명법과 DB가 사용하는 명명법 차이가 있어 자주 사용
 */
public class Product {

    @Id
    /**
     * @Id 어노테이션 선언 필드 => 테이블의 기본값 역할로 사용 ,
     * 모든 엔티티는 @Id 어노테이션 필수
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * @Id 어노테이션과 함께 사용
     * 해당 필드 값을 어떤 방식으로 생성할지 결정할 때 사용
     * 1) @GeneratedValue 사용 x → 직접 할당
     * 2) AUTO -> @GeneratedValue의 기본 설정값 => 자동 생성
     * 3) IDENTITY -> AUTO_INCREMENT 사용해 기본값 생성 → DB에 위임
     * < cf) AUTO_INCREMENT : MY-SQL에서 데이터가 삽입 될 때마다 1씩 증가해주는 역할 >
     * 4) SEQUENCE, 5) TABLE
     */

    /**
     *      상품 테이블
     * 상품 번호  - int
     * 상품 이름  - varchar
     * 상품 가격  - int
     * 상품 재고  - int
     * 상품 생성 일자  - DateTime
     * 상품 정보 변경 일자  - DateTime
     */
    private Long number;

    @Column(nullable = false)
    /**
     * nullable : 레코드(엔티티가 테이블로 저장된 것)를 생성할 때 컬럼 값에 null 처리가 가능한지를 명시하는 속성
     * 기본값 = true
     * 해당 필드는 DDL 생성 시 not null 이라는 조건이 붙은 채로 생성
     */
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAT;

    private LocalDateTime updatedAT;
/**
     * @Column 어노테이션에서 많이 사용하는 요소
     * - name : DB에 컬럼명을 설정하는 속성 - 명시 x → 필드명으로 지정
     * - length : DB에 저장하는 데이터의 최대 길이
     * - unique : 해당 컬럼을 유니크로 지정
     * - nullable
     */
}
