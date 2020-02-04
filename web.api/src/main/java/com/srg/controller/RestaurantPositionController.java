package com.srg.controller;

import com.srg.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantPosition")
public class RestaurantPositionController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRestaurantPosition() {
        return "add Complete";
    }

}
