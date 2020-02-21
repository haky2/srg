package com.srg.restaurant.controller;

import com.srg.restaurant.entity.Restaurant;
import com.srg.restaurant.enums.RestaurantCategory;
import com.srg.restaurant.service.RestaurantService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @RequestMapping(method = RequestMethod.GET, value = "/categoryList", produces="application/json;charset=UTF-8")
    public ResponseEntity<String> categoryList() {
        JSONObject data = new JSONObject();
        for ( RestaurantCategory category : RestaurantCategory.values() ) {
            data.put(category.toString(), category.getValue());
        }
        return ResponseEntity.ok(data.toString());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces="application/json;charset=UTF-8")
    public ResponseEntity<Optional<Restaurant>> get(@PathVariable(value="id") Long id) {
        Optional<Restaurant> data = service.get(id);
        return ResponseEntity.ok(data);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<String> add(Restaurant restaurant) {
        try {
            if (restaurant.getRstName().isEmpty()) {
                throw new Exception("가게 이름을 입력해주세요.");
            }
            if (restaurant.getStoreHour().isEmpty()) {
                throw new Exception("영업 시간을 입력해주세요.");
            }
            if (restaurant.getRstTag().isEmpty()) {
                throw new Exception("검색 태그를 입력해주세요.");
            }
            service.add(restaurant);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/{id}")
    public ResponseEntity<String> modify(@PathVariable(value="id") Long id, Restaurant restaurant) {
        try {
            Long rstNo = restaurant.getRstNo();
            if (rstNo.equals(id) == false) {
                throw new Exception("번호가 일치하지 않습니다.");
            }
            service.modify(restaurant);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.ok("fail");
        }
    }
}
