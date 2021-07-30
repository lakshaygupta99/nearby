package com.nearby.backend.MyOffers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nearby.backend.coupons.Coupon;

@Repository
public interface MyOfferRepository extends JpaRepository<MyOffers, String> {

	@Query(value = "select * from myOffers" +  " where email = :email", nativeQuery = true)
	MyOffers getOffersOfUserByEmail(@Param("email") String email);

	@Query(value = "select * from myOffers" +  " where userId = :userId", nativeQuery = true)
	MyOffers getOffersOfUserById(@Param("userId") long userId);
}
