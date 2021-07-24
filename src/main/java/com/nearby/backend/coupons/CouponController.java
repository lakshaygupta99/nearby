package com.nearby.backend.coupons;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(path = "api/coupons")
public class CouponController {

	private final CouponService couponService;

	@Autowired
	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}

	@GetMapping(value = "/all-coupons")
	public List<Coupon> getAllCoupons() {
		return couponService.getAllCoupons();
	}

	@PostMapping("/create-coupon")
	public Coupon createCoupon(@Validated @RequestBody Coupon coupon) {
		return couponService.save(coupon);
	}

	@GetMapping("/coupon/{id}")
	public ResponseEntity<Coupon> getEmployeeById(@PathVariable(value = "id") Long id)  throws ResourceNotFoundException {
		Coupon coupon = couponService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + id));

		return ResponseEntity.ok().body(coupon);
	}

	@GetMapping("/coupon/city/{city}")
	public List<Coupon> getCouponsBasedOnCity(@PathVariable(value = "city") String city) {
		return couponService.getCouponsBasedOnCity(city);
	}

	@GetMapping("/coupon/area/{city}/{area}")
	public List<Coupon> getCouponsBasedOnArea(@PathVariable(value = "city") String city,
			@PathVariable(value = "area") String area) {
		return couponService.getCouponsBasedOnArea(city, area);
	}

	@PutMapping("/coupon/{id}")
	public ResponseEntity<Coupon> updateCoupon(@PathVariable(value = "id") Long id,
			@Validated @RequestBody Coupon coupon) throws ResourceNotFoundException {

		Coupon c = couponService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + id));

		c.setName(coupon.getName());
		c.setArea(coupon.getArea());
		c.setCity(coupon.getCity());
		c.setCode(coupon.getCode());
		c.setCount(coupon.getCount());
		c.setDescription(coupon.getDescription());
		c.setImage(coupon.getImage());
		c.setShopName(coupon.getShopName());
		
		
		final Coupon updatedCoupon = couponService.save(c);
		return ResponseEntity.ok(updatedCoupon);
	}
	
	
    @DeleteMapping("/coupon/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Coupon coupon = couponService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        couponService.delete(coupon);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
