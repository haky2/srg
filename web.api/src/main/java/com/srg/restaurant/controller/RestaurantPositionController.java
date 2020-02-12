package com.srg.restaurant.controller;

import com.srg.restaurant.entity.RestaurantPosition;
import com.srg.restaurant.service.RestaurantPositionService;
import com.srg.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantPosition")
public class RestaurantPositionController {

    @Autowired
    private RestaurantPositionService restaurantPositionService;

    @RequestMapping(value = "/restaurantPosition", method = RequestMethod.POST)
    public String addRestaurantPosition(RestaurantPosition addRestaurantPosition) {
        restaurantPositionService.save(addRestaurantPosition);
        return "add Complete";
    }

    @RequestMapping(value = "/restaurantPosition/{id}", method = RequestMethod.GET)
    public RestaurantPosition getRestaurantPosition(@PathVariable("id") long rstNo) {
        RestaurantPosition ReturnRestaurantPosition = new RestaurantPosition();
        ReturnRestaurantPosition = restaurantPositionService.findById(rstNo);
        return ReturnRestaurantPosition;
    }

    @RequestMapping(value = "/restaurantPosition/{id}", method = RequestMethod.DELETE)
    public void deleteRestaurantPosition(@PathVariable("id") long rstNo) {
        restaurantPositionService.deleteById(rstNo);
    }

    @RequestMapping(value = "/restaurantPosition/{id}", method = RequestMethod.PUT)
    public String modifyRestaurantPosition(@PathVariable("id") long rstNo, RestaurantPosition updateRestaurantPosition) {
        restaurantPositionService.updateById(rstNo,updateRestaurantPosition);
        return "modify Complete";
    }

}
