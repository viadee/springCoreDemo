/**
 * 
 */
package de.viadee.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Configure the dependencies of the applications components.
 */
@SpringBootApplication
public class MyConfiguration {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(MyConfiguration.class, args);
    }

    @Bean
    public String greeting() {
        return "foo";
    }

    @Bean
    public SampleController sampleController() {
        return new SampleController(greeting());
    }
}
