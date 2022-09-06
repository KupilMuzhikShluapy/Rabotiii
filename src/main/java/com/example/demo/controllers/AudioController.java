package com.example.demo.controllers;

import com.example.demo.models.HeadphoneModel;
import com.example.demo.models.MickModel;
import com.example.demo.repo.HeadphoneModelRep;
import com.example.demo.repo.MickModelRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AudioController {

    @Autowired
    HeadphoneModelRep headphoneModelRep;

    @Autowired
    MickModelRep mickModelRep;

    @GetMapping("/Audio")
    public String AudioMainGetMap(Model model){

        Iterable<HeadphoneModel> HeadphoneList = headphoneModelRep.findAll();
        Iterable<MickModel> MickList = mickModelRep.findAll();

        model.addAttribute("HeadphoneList",HeadphoneList);
        model.addAttribute("MickList",MickList);

        return "AudioPages/AudioMainPage";
    }

}
