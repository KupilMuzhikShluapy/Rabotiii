package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    //Get запрос главной страницы
    @GetMapping("/")
    public String HomePageGetMap() {

        return "HomePage";
    }

    //Get запрос страницы калькулятора
    //Возвращает полученный результат вычислений из Post запроса
    @GetMapping("/Calc")
    public String CalcPageGetMap(
            @RequestParam(
                    name="first",
                    required=false,
                    defaultValue = "0"
            ) float first,
            @RequestParam(
                    name="second",
                    required=false,
                    defaultValue = "0"
            ) float second,
            @RequestParam(
                    name="act",
                    required=false,
                    defaultValue = "+"
            ) String act,
            @RequestParam(
                    name="historyString",
                    required=false,
                    defaultValue = ""
            ) String historyString,
            @RequestParam(
                    name="resfir",
                    required=false,
                    defaultValue = "false"
            ) boolean resfir,
            @RequestParam(
                    name="resethis",
                    required=false,
                    defaultValue = "false"
            ) boolean resethis,
            @RequestParam(
                    name="result",
                    required=false,
                    defaultValue = " не было вычислений"
            ) String result,
            Model model
    ){
        //Инициализация объекта результата
        float Result = 0;

        try{
            Result = Float.valueOf(result);
        }catch (Exception ex){

        }

        //Получение результата вычислений
        Result+=getResult(first, second, act);

        //При нажатии чекбокса "Сброса истроии"
        if (resethis){
            historyString = "";
        }else historyString += (first + " " + act + " " + second + " = " + Result + ", ");

        //Передача массива истории вычислений
        model.addAttribute("historys", historyString.split(", "));

        //При нажатии чекбокса "Первое число = результат"
        if (resfir){
            model.addAttribute("first", Result);
        }else{
            model.addAttribute("first", first);
        }

        model.addAttribute("resfir", resfir);
        model.addAttribute("second", second);
        model.addAttribute("historyString", historyString);
        model.addAttribute("result", Result);


        return "CalcPage";
    }


    //Post запрос страницы калькулятора
    //Передаёт данные из пост запроса на страницу
    @PostMapping("/Calc")
    public String CalcPagePostMap(
            @RequestParam(
                    name="first",
                    required=false
            ) float first,
            @RequestParam(
                    name="second",
                    required=false
            ) float second,
            @RequestParam(
                    name="act",
                    required=false
            ) String act,
            @RequestParam(
                    name="historyString",
                    required=false
            ) String historyString,
            @RequestParam(
                    name="resfir",
                    required=false
            ) boolean resfir,
            @RequestParam(
                    name="resethis",
                    required=false
            ) boolean resethis,
            Model model
    ){

        float Result = getResult(first, second, act);

        //При нажатии чекбокса "Сброса истроии"
        if (resethis){
            historyString = "";
        }else historyString += (first + " " + act + " " + second + " = " + Result + ", ");

        //Передача массива истории вычислений
        model.addAttribute("historys", historyString.split(", "));

        //При нажатии чекбокса "Первое число = результат"
        if (resfir){
            model.addAttribute("first", Result);
        }else{
            model.addAttribute("first", first);
        }

        model.addAttribute("resfir", resfir);
        model.addAttribute("second", second);
        model.addAttribute("historyString", historyString);
        model.addAttribute("result", Result);

        return "CalcPage";
    }

    private float getResult(float first, float second, String act){
        //Инициализация объекта результата
        float Result = 0;

        //Получение результата вычислений
        switch (act) {
            case "+": Result += first + second;
                break;

            case "-": Result += (first - second);
                break;

            case "*": Result += (first * second);
                break;

            case "/": Result += (first / second);
                break;
        }

        return Result;
    }

}
