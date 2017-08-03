package com.anonymint.simpleapi;

import com.anonymint.simpleapi.SimpleApiApplication.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SimpleApiApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void call_root() {
    String body = this.restTemplate.getForObject("/", String.class);
    assertThat(body).isEqualTo("Try /hello/something");
  }

  @Test
  public void call_hello_url() {
    String name = "world";
    Person p = this.restTemplate.getForObject("/hello/" + name, Person.class);
    assertThat(p).isNotNull();
    assertThat(p.getMessage()).isEqualTo(String.format("Hello %s!", name));
    assertThat(p.getName()).isEqualTo(name);
  }

  @Test
  public void call_error_url() {
    String name = "world";
    ResponseEntity<String> p = this.restTemplate.getForEntity("/hello2" + name, String.class);
    assertThat(p.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

}
