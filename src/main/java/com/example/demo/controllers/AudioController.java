package com.example.demo.controllers;

import com.example.demo.models.HeadphoneModel;
import com.example.demo.models.MickModel;
import com.example.demo.repo.HeadphoneModelRep;
import com.example.demo.repo.MickModelRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/Audio/")
public class AudioController {

    @Autowired
    HeadphoneModelRep headphoneModelRep;

    @Autowired
    MickModelRep mickModelRep;

    @GetMapping("/")
    public String AudioMainGetMap(Model model){
        Iterable<HeadphoneModel> HeadphoneList = headphoneModelRep.findAll();
        Iterable<MickModel> MickList = mickModelRep.findAll();

        model.addAttribute("HeadphoneList",HeadphoneList);
        model.addAttribute("MickList",MickList);

        return "AudioPages/AudioMainPage";
    }

    @GetMapping("/MickAdd")
    public String AudioMickGetAddMap(){

        return "AudioPages/MickAdd";
    }

    @PostMapping("/MickAdd")
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

    @GetMapping("/HeadphoneAdd")
    public String AudioHeadGetAddMap(Model model){

        model.addAttribute("action", 0);
        model.addAttribute("button", "Добавить новые наушники");

        return "AudioPages/HeadAdd";
    }

    @PostMapping("/HeadAdd")
    public String AudioHeadPostAddMap(
            @RequestParam(
                    name = "title"
            )String title,
            @RequestParam(
                    name = "action"
            )Long action,
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

        HeadphoneModel Head;
        if (action == 0){
            Head = new HeadphoneModel(title, type, model, hzstart, hzend, price);

        }else{
            Head = headphoneModelRep.findById(action).orElseThrow();

            Head.setHzend(hzend);
            Head.setHzstart(hzstart);
            Head.setModel(model);
            Head.setPrice(price);
            Head.setType(type);
            Head.setTitle(title);
        }

        headphoneModelRep.save(Head);

        return "redirect:/Audio/";
    }

    @GetMapping("/HeadFilter")
    public String HeadFilterGetMap(Model model){

        return "AudioPages/HeadFilter";
    }

    @PostMapping("/HeadFilter/result")
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

    @GetMapping("/MickFilter")
    public String MickFilterGetMap(Model model){

        return "AudioPages/MickFilter";
    }

    @PostMapping("/MickFilter/result")
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

    @GetMapping("/Head/{id}")
    public String ViewHead(@PathVariable("id")Long id, Model model){
        Optional<HeadphoneModel> ItemHeadphone = headphoneModelRep.findById(id);

        ArrayList<HeadphoneModel> result = new ArrayList<>();
        ItemHeadphone.ifPresent(result::add);

        model.addAttribute("HeadPhoneList",result);

        return "AudioPages/HeadDesc";
    }

    @PostMapping("/Head/{id}/Delete")
    public String HeadDelete(@PathVariable("id")Long id, Model model){
        HeadphoneModel car = headphoneModelRep.findById(id).orElseThrow();
        headphoneModelRep.delete(car);
        return "redirect:/Audio/";
    }

    @PostMapping("/Head/{id}/Edit")
    public String HeadEdit(@PathVariable("id")Long id, Model model){
        HeadphoneModel Head = headphoneModelRep.findById(id).orElseThrow();

        model.addAttribute("title", Head.getTitle());
        model.addAttribute("type", Head.getType());
        model.addAttribute("model", Head.getModel());
        model.addAttribute("hzstart", Head.getHzstart());
        model.addAttribute("hzend", Head.getHzend());
        model.addAttribute("price", Head.getPrice());

        model.addAttribute("action", id);
        model.addAttribute("button", "Изменить наушники");

        return "AudioPages/HeadAdd";
    }

}
