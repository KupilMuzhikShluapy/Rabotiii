package com.example.demo.controllers;

import com.example.demo.models.HeadphoneModel;
import com.example.demo.models.MickModel;
import com.example.demo.repo.HeadphoneModelRep;
import com.example.demo.repo.MickModelRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/Audio/HeadphoneAdd")
    public String AudioHeadGetAddMap(){

        return "AudioPages/HeadAdd";
    }

    @GetMapping("/Audio/MickAdd")
    public String AudioMickGetAddMap(){

        return "AudioPages/MickAdd";
    }

    @PostMapping("/Audio/MickAdd")
    public String AudioMickPostAddMap(
            @RequestParam(
                    name = "title"
            )String title,
            @RequestParam(
                    name = "type"
            )String type,
            @RequestParam(
                    name = "model"
            )String model,
            @RequestParam(
                    name = "soundsLike"
            )String soundsLike,
            @RequestParam(
                    name = "country"
            )String country,
            @RequestParam(
                    name = "hzstart"
            )int hzstart,
            @RequestParam(
                    name = "hzend"
            )int hzend,
            @RequestParam(
                    name = "price"
            )int price
    ){
        MickModel NewMick = new MickModel(title, type, model, soundsLike, country, hzstart, hzend, price);

        mickModelRep.save(NewMick);

        return "redirect:/Audio";
    }

    @PostMapping("/Audio/HeadAdd")
    public String AudioHeadPostAddMap(
            @RequestParam(
                    name = "title"
            )String title,
            @RequestParam(
                    name = "type"
            )String type,
            @RequestParam(
                    name = "model"
            )String model,
            @RequestParam(
                    name = "hzstart"
            )int hzstart,
            @RequestParam(
                    name = "hzend"
            )int hzend,
            @RequestParam(
                    name = "price"
            )int price
    ){
        HeadphoneModel NewMick = new HeadphoneModel(title, type, model, hzstart, hzend, price);

        headphoneModelRep.save(NewMick);

        return "redirect:/Audio";
    }

    @GetMapping("/Audio/HeadFilter")
    public String HeadFilterGetMap(Model model){

        return "AudioPages/HeadFilter";
    }

    @PostMapping("/Audio/HeadFilter/result")
    public String HeadResult(@RequestParam String title, @RequestParam String act, Model model)
    {
        if (act.equals("Find")){
            List<HeadphoneModel> result = headphoneModelRep.findByTitle(title);
            model.addAttribute("result", result);
        }else{
            List<HeadphoneModel> result = headphoneModelRep.findByTitleContains(title);
            model.addAttribute("result", result);
        }
        return "AudioPages/HeadFilter";
    }

    @GetMapping("/Audio/MickFilter")
    public String MickFilterGetMap(Model model){

        return "AudioPages/MickFilter";
    }

    @PostMapping("/Audio/MickFilter/result")
    public String MickResult(@RequestParam String title, @RequestParam String act, Model model)
    {
        if (act.equals("Find")){
            List<MickModel> result = mickModelRep.findByTitle(title);
            model.addAttribute("result", result);
        }else{
            List<MickModel> result = mickModelRep.findByTitleContains(title);
            model.addAttribute("result", result);
        }
        return "AudioPages/MickFilter";
    }

}
