package com.nearby.backend.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nearby.backend.coupons.Coupon;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "select * from cart" +  " where user_id = :id", nativeQuery = true)
	Cart getCartOfUser(@Param("id") Long id);

}