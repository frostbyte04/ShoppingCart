package com.adminportal.controller;

import com.adminportal.domain.Guitar;
import com.adminportal.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/guitar")
public class GuitarController {

    @Autowired
    private GuitarService guitarService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGuitar(Model model) {
        Guitar guitar = new Guitar();
        model.addAttribute("guitar", guitar);
        return "addGuitar";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGuitarPost(@ModelAttribute("guitar") Guitar guitar, HttpServletRequest request) {
        guitarService.save(guitar);

        MultipartFile guitarImage = guitar.getGuitarImage();
        try {
            byte[] bytes = guitarImage.getBytes();
            String name = guitar.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/guitar/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:guitarList";
    }

    @RequestMapping("/guitarList")
    public String guitarList(Model model) {
        List<Guitar> guitarList = guitarService.findAll();
        model.addAttribute("guitarList", guitarList);
        return "guitarList";
    }

    @RequestMapping("/guitarInfo")
    public String guitarInfo(@RequestParam("id") Long id, Model model) {
        Optional<Guitar> guitar = guitarService.findById(id);
        if(guitar.isPresent()){
            Guitar guitar1 = guitar.get();
            model.addAttribute("guitar", guitar1);
            return "guitarInfo";
        }else {
            return null;
        }
    }

    @RequestMapping("/updateGuitar")
    public String updateGuitar(@RequestParam("id") Long id, Model model) {
        Optional<Guitar> guitar = guitarService.findById(id);
        if(guitar.isPresent()){
            Guitar guitar1 = guitar.get();
            model.addAttribute("guitar", guitar1);
            return "updateGuitar";
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/updateGuitar", method = RequestMethod.POST)
    public String updateGuitarPost(@ModelAttribute("guitar") Guitar guitar, HttpServletRequest request) {
        guitarService.save(guitar);

        MultipartFile guitarImage = guitar.getGuitarImage();

        if (!guitarImage.isEmpty()) {
            try {
                byte[] bytes = guitarImage.getBytes();
                String name = guitar.getId() + ".png";
                if(Files.exists(Paths.get("src/main/resource/static/image/guitar/" + name))){
                    Files.delete(Paths.get("src/main/resource/static/image/guitar/" + name));
                }


                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/guitar/" + name)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/guitar/guitarInfo?id=" + guitar.getId();
    }
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public String remove(
            @ModelAttribute("id") String id, Model model
    ) {
        guitarService.removeOne(Long.parseLong(id.substring(10)));
        List<Guitar> guitarList = guitarService.findAll();
        model.addAttribute("guitarList", guitarList);

        return "redirect:/guitar/guitarList";
    }
}
