package com.nearby.backend.coupons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class CouponRepositoryTest {

	@Autowired
	private CouponRepository undertest;
	
	@Test
	void testFindByCityStartsWithIgnoreCase() {
		long price = 984;
		Coupon coupon1 = new Coupon("testCoupon1",
									"testing coupon",
									"imageURL",
									10,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price);
		long price2 = 300;
		Coupon coupon2 = new Coupon("testCoupon2",
									"testing coupon",
									"imageURL",
									14,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price2);
		undertest.save(coupon1);
		undertest.save(coupon2);
		List<Coupon> listOfCouponsFound = undertest.findByCityStartsWithIgnoreCase("delhi");
		for(Coupon c:listOfCouponsFound) {
//			System.out.println(c.getCity());
			assertEquals("delhi", c.getCity());
		}
	}

	@Test
	void testFindByCityStartsWithIgnoreCaseAndAreaStartsWithIgnoreCase() {
		long price = 984;
		Coupon coupon1 = new Coupon("testCoupon1",
									"testing coupon",
									"imageURL",
									10,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price);
		long price2 = 300;
		Coupon coupon2 = new Coupon("testCoupon2",
									"testing coupon",
									"imageURL",
									14,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price2);
		undertest.save(coupon1);
		undertest.save(coupon2);
		List<Coupon> listOfCouponsFound = undertest
										.findByCityStartsWithIgnoreCaseAndAreaStartsWithIgnoreCase("delhi", "hauzkhas1");
		for(Coupon c:listOfCouponsFound) {
//			System.out.println(c.getCity() + "  " + c.getArea());
			assertEquals("hauzkhas1", c.getArea());
		}
	}

	@Test
	void testGetCoupons() {
		long price = 984;
		Coupon coupon1 = new Coupon("testCoupon1",
									"testing coupon",
									"imageURL3",
									12,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price);
		long price2 = 300;
		Coupon coupon2 = new Coupon("testCoupon2",
									"testing coupon",
									"imageURL4",
									19,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price2);
		coupon1.setId(1L);
		coupon2.setId(2L);
		undertest.save(coupon1);
		undertest.save(coupon2);
		ArrayList<Coupon> coupons = new ArrayList<>();
		coupons.add(coupon2);
		coupons.add(coupon1);
		ArrayList<Long> ids = new ArrayList<>();
		ids.add(2L);
		ids.add(1L);
		ArrayList<Coupon> list = undertest.getCoupons(ids);
		assertEquals(list, coupons);
		
	}

	@Test
	void testReduceCount() {
		long price2 = 300;
		Coupon coupon9 = new Coupon("testCoupon2",
									"testing coupon",
									"imageURL",
									14,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price2);
//		coupon9.setId(4L);
		Object o = (Object) coupon9;
		undertest.save(coupon9);
//		Coupon x = undertest.getById(4L);
//		System.out.println(x.getDescription() + "hthtt");
		Object returned = undertest.reduceCount(4L, 3L);
		assertEquals(o, returned);
	}

}

