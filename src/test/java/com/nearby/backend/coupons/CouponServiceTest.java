package com.nearby.backend.coupons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class CouponServiceTest {

	@MockBean
	private CouponRepository repository;
	@InjectMocks
	private CouponService undertest;
	

	@Test
	void testGetAllCoupons() {
		List<Coupon> list = new ArrayList<>();
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
									price);
		long price3 = 950;
		Coupon coupon3 = new Coupon("testCoupon3",
									"testing coupon",
									"imageURL",
									15,
									"shopNAme2",
									"delhi",
									"hauzkhas2",
									"800016",
									price);
		list.add(coupon3);
		list.add(coupon2);
		list.add(coupon1);
		Mockito.when(repository.findAll()).thenReturn(list);
		List<Coupon> response = undertest.getAllCoupons();
		assertEquals(response, list);
	}

	@Test
	void testSave() {
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
		Mockito.when(repository.save(coupon1)).thenReturn(coupon1);
		Coupon response = undertest.save(coupon1);
		assertEquals(response, coupon1);
	}

	@Test
	void testFindById() {
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
		coupon1.setId(3L);
		Optional<Coupon> op = Optional.of(coupon1);
		Mockito.when(repository.save(coupon1)).thenReturn(coupon1);
		
		Mockito.when(repository.findById(3L)).thenReturn(op);
		Optional<Coupon> response = undertest.findById(3L);
		assertEquals(response, op);
	}

	@Test
	void testGetCouponsBasedOnCity() {
		List<Coupon> list = new ArrayList<>();
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
									price);
		list.add(coupon2);
		list.add(coupon1);
		Mockito.when(repository.findByCityStartsWithIgnoreCase("delhi")).thenReturn(list);
		List<Coupon> response = undertest.getCouponsBasedOnCity("delhi");
		assertEquals(response, list);
	}

	@Test
	void testGetCouponsBasedOnArea() {
		List<Coupon> list = new ArrayList<>();
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
									price);
		list.add(coupon2);
		list.add(coupon1);
		Mockito.when(repository.findByCityStartsWithIgnoreCaseAndAreaStartsWithIgnoreCase("delhi","hauzkhas")).thenReturn(list);
		List<Coupon> response = undertest.getCouponsBasedOnArea("delhi","hauzkhas");
		assertEquals(response, list);
	}


	@Test
	void testGetCoupons() {
		ArrayList<Coupon> list = new ArrayList<>();
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
									price);
		long price3 = 950;
		Coupon coupon3 = new Coupon("testCoupon3",
									"testing coupon",
									"imageURL",
									15,
									"shopNAme2",
									"delhi",
									"hauzkhas2",
									"800016",
									price);
		coupon1.setId(54L);
		coupon2.setId(55L);
		coupon3.setId(56L);
		list.add(coupon3);
		list.add(coupon2);
		list.add(coupon1);
		ArrayList<Long> a = new ArrayList<>();
		a.add(54L);
		a.add(55L);
		a.add(56L);
		Mockito.when(repository.getCoupons(a)).thenReturn(list);
		ArrayList<Coupon> response = undertest.getCoupons(a);
		assertEquals(response, list);
	}

	@Test
	void testReduceCount() {
		long price = 984;
		Coupon coupon1 = new Coupon("testCoupon1",
									"testing coupon",
									"imageURL",
									100,
									"shopNAme1",
									"delhi",
									"hauzkhas1",
									"800016",
									price);
		coupon1.setId(1L);
		Object o = (Object) coupon1;
		Mockito.when(repository.reduceCount(1L, 10L)).thenReturn(coupon1);
		Map<String, Long> map = new HashMap<>();
		map.put("1L", 10L);
		Object response = undertest.reduceCount(map);
		assertEquals(response, o);
	}

}
