package com.srg.controller;

import com.srg.service.RestaurantService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public void get(@PathVariable(value="id") String id, HttpServletResponse response) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("restaurant id", id);
        data.put("name", "얌샘김밥");
        data.put("address", "Seoul");
        JSONObject result = new JSONObject();
        result.put("response", data);
        try {
            response.getWriter().println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public void save() {
        service.add();
    }
}
