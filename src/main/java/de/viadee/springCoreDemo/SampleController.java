package de.viadee.springCoreDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A basic controller listening on the base path. Please note that while the controller annotation may be found by the
 * spring component scan automatically, the bean is created in the configuration class explicitly, in order to keep a
 * consistent style of constructor based dependency injection.
 * 
 * @see http://olivergierke.de/2013/11/why-field-injection-is-evil/
 * 
 */
@Controller
public class SampleController {

    private final String greeting;

    /**
     * @param greeting
     */
    public SampleController(final String greeting) {
        this.greeting = greeting;
    }

    /**
     * @return Returns the configured greeting to calls on http://localhost:8080/ (assuming port 8080 is not occupied).
     */
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return greeting;
    }

}