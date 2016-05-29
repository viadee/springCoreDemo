package de.viadee.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.viadee.springCoreDemo.lazyness.LazyClass;

/**
 * Configure the dependencies of the applications components.
 */
@SpringBootApplication
public class MyConfiguration {

    public static void main(final String[] args) {
        SpringApplication.run(MyConfiguration.class, args);
    }

    /**
     * @return A simple greeting as an example for the most simple bean (in singleton scope).
     */
    @Bean(name = "personalGreetingMessage")
    public String greeting() {
        return "foo";
    }

    /**
     * @return A sample service to provide greetings for http users (in singleton scope).
     */
    @Bean
    public SampleController sampleController() {
        return new SampleController(greeting());
    }

    /**
     * @return A configurable greeting service that can respond to user requests individually (in singleton scope).
     */
    @Bean
    public GreetingController greetingController() {
        return new GreetingController("Hello, %s!");
    }

    /**
     * @return A class that is not required up front.
     */
    @Bean
    public LazyClass lazyClass() {
        return new LazyClass();
    }
}
