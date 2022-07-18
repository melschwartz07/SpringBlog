package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {


    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String sum(@PathVariable int num1, @PathVariable int num2) {
        return "The sum of " + num1 + " and " + num2 + " equals: " + (num1 + num2);

    }

    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String difference(@PathVariable int num1, @PathVariable int num2) {
        return "The difference of " + num2 + " and " + num1 + " equals: " + (num2 - num1);

    }

    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String product(@PathVariable int num1, @PathVariable int num2) {
        return "The product of " + num1 + " and " + num2 + " equals: " + (num1 * num2);

    }

    @RequestMapping(path = "/divide/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String division(@PathVariable int num1, @PathVariable int num2) {
        return "If you divide " + num1 + " and " + num2 + " it equals: " + (num1 / num2);

    }


}