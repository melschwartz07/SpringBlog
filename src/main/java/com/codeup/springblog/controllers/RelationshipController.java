package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RelationshipController {

    private final AdRepository adsDao;

    public RelationshipController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }


    @GetMapping("/rel/ads")
    @ResponseBody
    public List<Ad> returnAllAds() {
        List<Ad> ads = adsDao.findAll();

        return adsDao.findAll();
    }

    @GetMapping("/rel/ads/view")
    public String returnAdsView(Model model) {
        model.addAttribute("ads", adsDao.findAll());
        return "rel/ads";
    }





}