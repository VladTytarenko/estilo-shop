package com.tytarenko.estiloshop.controller;

import com.tytarenko.estiloshop.entity.*;
import com.tytarenko.estiloshop.service.interfaces.AdminService;
import com.tytarenko.estiloshop.service.interfaces.GoodService;
import com.tytarenko.estiloshop.service.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private GoodService goodService;

    @GetMapping("/{id}")
    public ModelAndView getAdmin(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", adminService.getAdminById(id));
        model.put("purchase-list", purchaseService.getAllPurchase());
        return new ModelAndView("admin", model);
    }

    @GetMapping("/{id}/add_admin")
    public ModelAndView addAdmin(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", adminService.getAdminById(id));
        return new ModelAndView("add-admin", model);
    }

    @PostMapping("/{id}/add_admin")
    public ModelAndView addAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.addAdmin(admin);
        return new ModelAndView("redirect:/admin/{id}");
    }

    @GetMapping("/{id}/goods")
    public ModelAndView getGoods(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("good-list", goodService.getAll());
        return new ModelAndView("admin-good-list", model);
    }

    @GetMapping("/{id}/goods/{goodId}")
    public ModelAndView getGoodById(@PathVariable("id") long id,
                                    @PathVariable("goodId") long goodId) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", adminService.getAdminById(id));
        model.put("good", goodService.getGoodById(goodId));
        return new ModelAndView("admin-good", model);
    }

    @GetMapping("/{id}/goods/add_good")
    public ModelAndView addGood(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin-id", id);
        return new ModelAndView("add-good", model);
    }

    @PostMapping("/{id}/goods/add_good")
    public ModelAndView addGood(@PathVariable("id") long id,
                                @ModelAttribute("good") Good good) {
        goodService.addGood(good);
        return new ModelAndView("redirect:/admin/" + id + "/goods");
    }

    @GetMapping("/{id}/goods/{goodId}/update")
    public ModelAndView updateGood(@PathVariable("id") long id,
                                   @PathVariable("goodId") long goodId) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", adminService.getAdminById(id));
        model.put("good", goodService.getGoodById(goodId));
        return new ModelAndView("good-update", model);
    }

    @PostMapping("/{id}/goods/{goodId}/update")
    public ModelAndView updateGood(@PathVariable("id") long id,
                                   @ModelAttribute("good") Good good) {
        goodService.updateGood(good);
        return new ModelAndView("redirect:/admin/" + id + "/goods/" + good.getGoodId());
    }

    @DeleteMapping("/{id}/goods/{goodId}/delete")
    public ModelAndView deleteGood(@PathVariable("id") long id,
                                   @PathVariable("goodId") long goodId) {
        goodService.deleteGood(goodId);
        return new ModelAndView("redirect:/admin/" + id + "/goods");
    }

}
