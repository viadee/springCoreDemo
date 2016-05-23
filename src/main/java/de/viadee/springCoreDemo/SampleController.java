package de.viadee.springCoreDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    private final String greeting;

    /**
     * @param greeting
     */
    public SampleController(final String greeting) {
        this.greeting = greeting;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return greeting;
    }

}