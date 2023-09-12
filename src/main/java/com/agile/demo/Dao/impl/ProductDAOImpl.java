package com.agile.demo.Dao.impl;

import com.agile.demo.Dao.ProductDAO;
import com.agile.demo.Entity.Product;
import com.agile.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

// ProductDAO 인터페이스 구현체 클래스
@Component //or @Service
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    /**
     * Constructor Based DI ( 생성자 기반 DI )
     * 순환 참조 방지
     * 테스트 용이
     *  final 선언 가능 = 불변성 보장 ( 클래스 내 다른 값 할당 x )
     */

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /**
     * 의존성(@Autowired) 사용 → 외부에서  ProductRepository 객체 주입 받아 사용
     */


    /** Product Entity DB에 저장
     * JPA에서 기본 method 제공 → interface에서 따로 method 구현 x
     * save method 활용

     * @param product
     * @return
    */
     @Override
    public Product insertProduct(Product product) {
         // 상품 정보를 데이터베이스에 저장
         // ( 메서드를 호출하면 입력된 상품 정보가 DB에 새로 저장 )
        Product savedProduct = productRepository.save(product);
        // product 객체를 ProductRepository를 통해 DB에 저장 - savedProduct 변수에 할당

        return savedProduct;
    }
    /**
     * @Override - ProductDAO 인터페이스에서 상속받은 메서드 재정의
     * public ~ insert~ - Product 객체를 입력으로 받아
       해당 객체를 DB에 삽입하는 메서드 정의
     */

    /**
     * selectProduct() method 사용한 repository method
      = getById()
     * Repository에선 단건 조회 위한 기본 메서드 2가지
      = getById() , findById() method
      getById() - 내부적 EntityManager의 getReference() method 호출
        → 프락시 객체 return
      findById() - 내부적 EntityManager의 find() method 호출
        영속성 컨텍스트 ( 엔티티를 영구 저장하는 환경 ) 캐시에서 값을 조회한 후
        컨텍스트 안에 값이 없다면 실제 DB에서 데이터 조회
     → return 값 Optional 객체 전달

     * @param number
     * @return
     */
    @Override
    public Product selectProduct(Long number) {
        // 상품 번호에 해당하는 상품을 조회
        Product selectProduct = productRepository.getById(number);
        // productRepository에서 주어진 ID에 해당하는 상품을 조회

        return selectProduct;
    }
    /**
     * → 메서드 반환 타입 = Product
     */


    /**
     * JPA 값 갱신 시 update 키워드 사용 x
        → 영속성 컨텍스트 활용해 값 갱신
     * find() method - DB 값 가져오면 가져온 객체가 영속성 컨텍스트에 추가 왜?
     * 영속성 컨텍스트가 유지되는 상황 → 객체 값 변경 후 다시 save() 실행 시
        → 더티 체크( Dirty Check : Transaction 안에서 엔티티 변경 시,
          변경 내용을 자동으로 DB에 반영하는 JPA 특징 ) 수행

     * @param number
     * @param name
     * @return
     * @throws Exception
     */

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        // productRepository에서 해당 번호에 해당하는 상품 조회 메서드 정의
        Optional<Product> selectProduct = productRepository.findById(number);
        //

        Product updatedProduct;
        if (selectProduct.isPresent()) {
            // 조회한 상품이 존재할 시
            Product product = selectProduct.get();

            // 상품 이름 새로운 이름으로 update
            product.setName(name);
            // 상품 update 시간을 현재 시간으로 설정
            product.setUpdatedAT(LocalDateTime.now());

            // update한 상품 정보를 productRepository(DB)에 저장하고
            updatedProduct = productRepository.save(product);
        } else {
            // 조회한 상품이 없는 경우 예외 발생
            throw new Exception();
        }

        // update한 상품 정보 return
        return updatedProduct;
    }
    /**
     * public ~ Exception - 메서드 반환 타입 = Product
     * Optional<T> isPresent() / ifPresent()
      - Optional<T> : null이 올 수 있는 값을 감싸는 Wrapper class
     * isPresent() - Optional 객체가 값을 가지고 있으면 true, 아니면 false return
      = selectProduct에 상품정보가 존재하는지 확인 (Optional ~ isPresent)
     */

    /**
     * DB 레코드 삭제하려면 삭제하고자 하는 레코드와
       매핑된 영속 객체 영속성 텍스트로 가져와야 함
     * deleteProduct() method는 findById() method를 통해 해당 객체 삭제하게끔 요청

     * @param number
     * @throws Exception
     */
    @Override
    public void deleteProduct(Long number) throws Exception {
        // productRepository에서 주어진 번호에 해당하는 상품 삭제
        Optional<Product> selectdProduct = productRepository.findById(number);

        if (selectdProduct.isPresent()) {
            Product product = selectdProduct.get();
            // selectdProduct에 있는 상품 정보를 변수 product에 저장

            productRepository.delete(product);
            // productRepository를 통해 상품 삭제
        } else {
            throw new Exception();
        }

    }

}

