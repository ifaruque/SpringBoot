### Spring Boot Benefits : ###

1. Create stand-alone Spring applications 
2. Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files) wow!! 
3. Groovy support, allowing you to build Spring MVC web apps with as little as a single file.
4. no need single line of XML even No web.xml file either. This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or infrastructure.
5. Spring Boot manages dependencies and configuration automatically. You don't need to specify version for any of that dependencies.Spring Boot upgrades all dependencies automatically when you upgrade Spring Boot.

### Environment setup : ###

You can start Spring Boot Application in the following ways: <br/>

1. Spring Boot CLI<(recommemded 	way)  : 
installation guide: [a link] http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-installing-the-cli <br/>
2. Spring Boot Web Interface<br/>(http://start.spring.io)  : <br/>
3. Use IDEs/IDE Plugin like STS,Netbeans,IntelljIdea<br/>
4. Use Thirdparty Tool like cURL,HTTPie

### Create Spring Boot App ###

See some help <br>
<b>spring help</b><br/>
<b>spring help init</b> <br>

Give following command

`spring init -n=spring-boot -g=com.javaaround --package-name=com.javaaround.boot -d=web --build=maven springbootapp`

	1. -n = application name
	2. -g = groupId
	3. -d = dependency specify by comma
	4. --build = specify build system gradle or maven.default maven
	springbootapp == project root name

Create HelloController.java at src/main/java/com/javaaround/springboot/controller

```java
package com.javaaround.springboot.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String home() {
		return "Hello World!";
	}
	
}
 
```

Explanation : 

1. @RestController : meaning it’s ready for use by Spring MVC to handle web requests.
2. @RequestMapping : maps '/'' to the 'index()' method by browser


Create Application.java at src/main/java/com/javaaround/springboot/controller

```java
package com.javaaround.springboot;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application  {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
	}

}
```

Explanation : 

1. @SpringBootApplication : adds all of the following setting
	1. @Configuration : marks the class as a source of bean definitions for the application context.
	2. @EnableAutoConfiguration : tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
	3. @EnableWebMvc : marks  the application as a web application and activates key behaviors such as setting up a DispatcherServlet. Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath
	4. @ComponentScan : tells Spring to look for other components, configurations, and services in the com.javaaround.springboot package, allowing it to find the controllers.


### How to run app two way ###
1. Maven
	1. mvn spring-boot:run
	2. mvn package && java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar
2. Gradle
	1. gradle bootRun
	2. gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar

### Browse App ###
http://localhost:8080/hello
	
### Testing Application ###

You can start Spring Application Test in the two ways: <br/>
1 . MockMvc  <br/>
2 . RestTemplate <br/>

<b>Run Boot Application Test:</b> <br/>
1.<b>mvn spring-boot:run </b><br/>
1.<b>mvn test </b><br/>

<b>Spring Boot Built in (Production ready) Starter project</b> <br/>
1.spring-boot-starter-actuator : <br>
It is for add management services(errors, environment, health, beans, info, metrics, trace, configprops, and dump.) </br>
here is complete list of starter project </br>
http://docs.spring.io/spring-boot/docs/1.3.4.RELEASE/reference/htmlsingle/#using-boot-starter-poms

<b>spring-boot-starter-data-jpa</b> <br/>


