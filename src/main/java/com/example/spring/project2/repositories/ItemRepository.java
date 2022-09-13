package com.example.spring.project2.repositories;

import com.example.spring.project2.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM items where amount > ? ORDER BY price ASC ")
    List<Item> findAllXXX(Integer amount);


//    List<Item> findAllByAmountGreaterThanAndOOrderByPriceAsc(Integer amount);
}
