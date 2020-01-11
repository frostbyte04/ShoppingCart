package com.adminportal.controller;

import com.adminportal.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ResourceController {

    @Autowired
    private GuitarService guitarService;

    @RequestMapping(value="/guitar/removeList", method= RequestMethod.POST)
    public String removeList(
            @RequestBody ArrayList<String> guitarIdList, Model model
            ){

        for (String id : guitarIdList) {
            String guitarId =id.substring(8);
            guitarService.removeOne(Long.parseLong(guitarId));
        }

        return "delete success";
    }
}
