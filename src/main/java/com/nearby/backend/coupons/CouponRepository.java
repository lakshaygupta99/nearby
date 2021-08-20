package com.nearby.backend.coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	List<Coupon> findByCityStartsWithIgnoreCase(String city);

	List<Coupon> findByCityStartsWithIgnoreCaseAndAreaStartsWithIgnoreCase(String city, String area);


	@Query(value = "select * from coupons" + " where id in :id and count > 0", nativeQuery = true)
	ArrayList<Coupon> getCoupons( ArrayList<Long> id);

	@Query(value = "update coupons" + " set count = count - :quantity" + " where id = :id", nativeQuery = true)
	Object reduceCount(Long id, Long quantity);
}