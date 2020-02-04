package com.srg.controller;

import com.srg.entity.Restaurant;
import com.srg.service.RestaurantService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public void get(@PathVariable(value="id") int id, HttpServletResponse response) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("id", service.get(id).getRstNo());
        data.put("name", service.get(id).getRstName());
        data.put("menu", service.get(id).getRstMenu());
        data.put("tag", service.get(id).getRstTag());
        data.put("regDate", service.get(id).getRegYmdt());
        JSONObject result = new JSONObject();
        result.put("response", data);
        try {
            response.getWriter().println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public void add(Restaurant restaurant) {
        service.add(restaurant);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save/{id}")
    public void modify(@PathVariable(value="id") int id) {
        service.modify(id);
    }
}
