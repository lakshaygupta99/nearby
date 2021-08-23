package com.nearby.backend.coupons;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nearby.backend.cart.Cart;

@RestController
@RequestMapping(path = "api/coupons")
public class CouponController {

	private final CouponService couponService;

	@Autowired
	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}

	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}

	@GetMapping(value = "/all-coupons")
	public List<Coupon> getAllCoupons() {
		return couponService.getAllCoupons();
	}

	@PostMapping("/create-coupon")
	public ResponseEntity<Object> createCoupon(@Validated @RequestBody Coupon coupon) {
		try {
			ArrayList<Long> userIds = new ArrayList<Long>();
			coupon.setLikedBy(userIds);
			return ResponseEntity.ok(couponService.save(coupon));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@GetMapping("/coupon/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		try {
			Coupon coupon = couponService.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + id));

			return ResponseEntity.ok().body(coupon);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@GetMapping("/coupon/city/{city}")
	public ResponseEntity<Object> getCouponsBasedOnCity(@PathVariable(value = "city") String city) {
		try {
			return ResponseEntity.ok(couponService.getCouponsBasedOnCity(city));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@GetMapping("/coupon/area/{city}/{area}")
	public ResponseEntity<Object> getCouponsBasedOnArea(@PathVariable(value = "city") String city,
			@PathVariable(value = "area") String area) {
		try {
			return ResponseEntity.ok(couponService.getCouponsBasedOnArea(city, area));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@PutMapping("/coupon/{id}")
	public ResponseEntity<Object> updateCoupon(@PathVariable(value = "id") Long id,
			@Validated @RequestBody Coupon coupon) throws ResourceNotFoundException {
		try {
			Coupon c = couponService.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id: " + id));

			c.setName(coupon.getName());
			c.setArea(coupon.getArea());
			c.setCity(coupon.getCity());
			c.setCode(coupon.getCode());
			c.setCount(coupon.getCount());
			c.setDescription(coupon.getDescription());
			c.setImage(coupon.getImage());
			c.setShopName(coupon.getShopName());
			c.setPrice(coupon.getPrice());

			final Coupon updatedCoupon = couponService.save(c);
			return ResponseEntity.ok(updatedCoupon);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}
	}

	@DeleteMapping("/coupon/{id}")
	public ResponseEntity<Object> deleteCoupon(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		try {
			Coupon coupon = couponService.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id: " + id));

			couponService.delete(coupon);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@PostMapping("/get-coupons-in-cart")
	public ResponseEntity<Object> getCoupons(@Validated @RequestBody Map<String, ArrayList<Long>> id) {
		try {
			return ResponseEntity.ok((ArrayList<Coupon>) couponService.getCoupons(id.get("coupon_ids")));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@PutMapping("/reduce-coupon-count")
	public ResponseEntity<Object> reduceCouponCount(@Validated @RequestBody ArrayList<Map<String, Long>> coupons) {

		try {
			coupons.forEach((c) -> couponService.reduceCount(c));

			Map<String, String> m = new HashMap<String, String>();
			m.put("status", "success");
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}
	
	
	@PutMapping("/update-coupon/{couponId}/{userId}")
	public ResponseEntity<Object> updateLikedCoupon(@PathVariable(value = "couponId") Long couponId,
			@PathVariable(value = "userId") Long userId
			) throws ResourceNotFoundException {

		try {
			Coupon c = couponService.findById(couponId)
					.orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id: " + couponId));

			ArrayList<Long>userIds = c.getLikedBy();
			if(userIds.contains(userId)) {
				userIds.remove(userId);
			}else {
				userIds.add(userId);
			}
			c.setLikedBy(userIds);

			final Coupon updatedCCoupon = couponService.save(c);
			return ResponseEntity.ok(updatedCCoupon);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);		}

	}

}
