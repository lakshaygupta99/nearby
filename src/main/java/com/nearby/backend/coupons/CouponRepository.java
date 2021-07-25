package com.nearby.backend.coupons;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	List<Coupon> findByCityContainingIgnoreCase(String city);

	List<Coupon> findByCityContainingIgnoreCaseAndAreaContainingIgnoreCase(String city, String area);

}