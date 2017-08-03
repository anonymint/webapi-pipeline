package com.anonymint.simpleapi;

import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SimpleApiApplication {

  @RequestMapping(value = "/hello/{who}", method = RequestMethod.GET)
  public @ResponseBody
  Person hello(@PathVariable(value = "who") Optional<String> who) {
    return new Person(who.get());
  }

  @RequestMapping(value = "/")
  @ResponseBody
  public String app() {
    return "Try /hello/something";
  }

  public static void main(String[] args) {
    SpringApplication.run(SimpleApiApplication.class, args);
  }

  public static class Person {
    private String name;
    private String message;

    public Person() {
    }

    public Person(String name) {
      this.name = name;
      this.message = String.format("Hello %s!", name);
    }

    public String getName() {
      return name;
    }

    public String getMessage() {
      return message;
    }
  }

}
