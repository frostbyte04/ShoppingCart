package com.gs.controller;

import com.gs.domain.Guitar;
import com.gs.domain.User;
import com.gs.service.GuitarService;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private GuitarService guitarService;

    @Autowired
    private UserService userService;

    @RequestMapping("/searchByCategory")
    public String searchByCategory(
            @RequestParam("category") String category,
            Model model, Principal principal
            ){
        if(principal!= null){
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }

        String classActiveCategory = "active"+category;
        classActiveCategory = classActiveCategory.replaceAll("\\s", "");
        classActiveCategory = classActiveCategory.replaceAll("&", "");
        model.addAttribute(classActiveCategory, true);

        List<Guitar> guitarList = guitarService.findByCategory(category);
        if(guitarList.isEmpty()){
            model.addAttribute("emptyList", true);
            return "guitarshelf";
        }

        model.addAttribute("guitarList",guitarList);
        return "guitarshelf";

    }

    @RequestMapping("/searchGuitar")
    public String searchGuitar (
            @ModelAttribute("keyword") String keyword,
            Principal principal, Model model
        ) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }

        List<Guitar> guitarList = guitarService.blurrySearch(keyword);

        if (guitarList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "guitarshelf";
        }

        model.addAttribute("guitarList", guitarList);

        return "guitarshelf";
        }
    }
