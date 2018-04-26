package com.tytarenko.estiloshop.controller;

import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.service.interfaces.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/image")
public class TestController {

    @Autowired
    private GoodService goodService;

    @GetMapping("/im")
    public void showImage(@RequestParam("id") Integer goodId,
                          HttpServletResponse response,
                          HttpServletRequest request) throws IOException {
        Good item = goodService.getGoodById(goodId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getImage());
        response.getOutputStream().close();
    }

    @GetMapping("/s")
    public ModelAndView test() {
        Map<String, Object> model = new HashMap<>();
        model.put("good", goodService.getGoodById(1));
        return new ModelAndView("test", model);
    }
}
