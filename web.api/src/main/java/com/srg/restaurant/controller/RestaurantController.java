package com.srg.restaurant.controller;

import com.srg.restaurant.entity.Restaurant;
import com.srg.restaurant.enums.RestaurantCategory;
import com.srg.restaurant.model.request.RestaurantRegister;
import com.srg.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping("test")
    public ResponseEntity<String> testSave(@RequestParam Map<Integer, String> fields) {
        System.out.println(fields);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list", produces="application/json;charset=UTF-8")
    public ResponseEntity<List<Restaurant>> getList() {
        List<Restaurant> data = service.getList();
        return ResponseEntity.ok(data);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces="application/json;charset=UTF-8")
    public ResponseEntity<Optional<Restaurant>> get(@PathVariable(value="id") Long id) {
        Optional<Restaurant> data = service.get(id);
        return ResponseEntity.ok(data);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<String> add(@Valid RestaurantRegister restaurant, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            if (allErrors.size() > 0) {
                String message = allErrors.get(0).getDefaultMessage();
                ResponseEntity<String> entity = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
                return entity;
            }
        }
        restaurant.setLocationNo(0L);
        service.save(restaurant);
        ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/save")
    public ResponseEntity<String> modify(@PathVariable(value="id") Long id, @Valid RestaurantRegister restaurant, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            if (allErrors.size() > 0) {
                String message = allErrors.get(0).getDefaultMessage();
                ResponseEntity<String> entity = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
                return entity;
            }
        }

        if (!service.get(id).isPresent()) {
            ResponseEntity<String> entity = new ResponseEntity<String>("데이터가 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
            return entity;
        }

        restaurant.setRstNo(id);
        service.save(restaurant);
        ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories", produces="application/json;charset=UTF-8")
    public ResponseEntity<Map<String, String>> categoryList() {
        Map<String, String> data = new HashMap<>();
        for ( RestaurantCategory category : RestaurantCategory.values() ) {
            data.put(category.toString(), category.getValue());
        }
        return ResponseEntity.ok(data);
    }
}
