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

### Console Application(Non Web) ###
To create a non-web application, implements CommandLineRunner and override the run method. We used lambda expression

Update Application.java

```java
@Bean
public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    };
}
```

### Dependency management ###

Spring Boot manages dependencies and configuration automatically. You don't need to specify version for any of that starter dependencies. 
```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.0.0.BUILD-SNAPSHOT</version>
</parent>
```
only need to specify the Spring Boot version number above parent setting. If you import additional starters, you need not include the version number.

Changing java version

```xml
<properties>
	<java.version>1.8</java.version>
</properties>

```

Add below maven plugin for create executable jar/war

```xml
<build>
    <plugins>
        <!-- Package as an executable jar/war -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

### Application Properties ###
Properties are used to set values like: server-port number, database connection configuration etc. it reside at /resources/application.properties

<table class="alt">
    <tbody><tr>
        <th>Property</th>
        <th>Default value</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>banner.charset</td>
        <td>UTF-8</td>
        <td>It is used to set banner file encoding.</td>
    </tr>
    <tr>
        <td>banner.location</td>
        <td>classpath:banner.txt</td>
        <td>It is used to set banner file location.</td>
    </tr>
    <tr>
        <td>logging.file</td>
        <td></td>
        <td>It is used to set log file name. For example data.log.</td>
    </tr>
    <tr>
        <td>spring.application.index</td>
        <td></td>
        <td>It is used to set application index.</td>
    </tr>
    <tr>
        <td>spring.application.name</td>
        <td></td>
        <td>It is used to set application name.</td>
    </tr>
    <tr>
        <td>spring.application.admin.enabled</td>
        <td>false</td>
        <td>It is used to enable admin features for the application.</td>
    </tr>
    <tr>
        <td>spring.config.location</td>
        <td></td>
        <td>It is used to config file locations.</td>
    </tr>
    <tr>
        <td>spring.config.name</td>
        <td>application</td>
        <td>It is used to set config file name.</td>
    </tr>
    <tr>
        <td>spring.mail.default-encoding</td>
        <td>UTF-8</td>
        <td>It is used to set default MimeMessage encoding.</td>
    </tr>
    <tr>
        <td>spring.mail.host</td>
        <td></td>
        <td>It is used to set SMTP server host. For example smtp.example.com.</td>
    </tr>
    <tr>
        <td>spring.mail.password</td>
        <td></td>
        <td>It is used to set login password of the SMTP server.</td>
    </tr>
    <tr>
        <td>spring.mail.port</td>
        <td></td>
        <td>It is used to set SMTP server port.</td>
    </tr>
    <tr>
        <td>spring.mail.test-connection</td>
        <td>false</td>
        <td>It is used to test that the mail server is available on startup.</td>
    </tr>
    <tr>
        <td>spring.mail.username</td>
        <td></td>
        <td>It is used to set login user of the SMTP server.</td>
    </tr>
    <tr>
        <td>spring.main.sources</td>
        <td></td>
        <td>It is used to set sources for the application.</td>
    </tr>
    <tr>
        <td>server.address</td>
        <td></td>
        <td>It is used to set network address to which the server should bind to.</td>
    </tr>
    <tr>
        <td>server.connection-timeout</td>
        <td></td>
        <td>It is used to set time in milliseconds that connectors will wait for another HTTP request before closing the connection.</td>
    </tr>
    <tr>
        <td>server.context-path</td>
        <td></td>
        <td>It is used to set context path of the application.</td>
    </tr>
    <tr>
        <td>server.port</td>
        <td>8080</td>
        <td>It is used to set HTTP port.</td>
    </tr>
    <tr>
        <td>server.server-header</td>
        <td></td>
        <td>It is used for the Server response header (no header is sent if empty)</td>
    </tr>
    <tr>
        <td>server.servlet-path</td>
        <td>/</td>
        <td>It is used to set path of the main dispatcher servlet</td>
    </tr>
    <tr>
        <td>server.ssl.enabled</td>
        <td></td>
        <td>It is used to enable SSL support.</td>
    </tr>
    <tr>
        <td>spring.http.multipart.enabled</td>
        <td>True</td>
        <td>It is used to enable support of multi-part uploads.</td>
    </tr>
    <tr>
        <td>spring.http.multipart.max-file-size</td>
        <td>1MB</td>
        <td>It is used to set max file size.</td>
    </tr>
    <tr>
        <td>spring.mvc.async.request-timeout</td>
        <td></td>
        <td>It is used to set time in milliseconds.</td>
    </tr>
    <tr>
        <td>spring.mvc.date-format</td>
        <td></td>
        <td>It is used to set date format. For example dd/MM/yyyy.</td>
    </tr>
    <tr>
        <td>spring.mvc.locale</td>
        <td></td>
        <td>It is used to set locale for the application.</td>
    </tr>
    <tr>
        <td>spring.social.facebook.app-id</td>
        <td></td>
        <td>It is used to set application's Facebook App ID.</td>
    </tr>
    <tr>
        <td>spring.social.linkedin.app-id</td>
        <td></td>
        <td>It is used to set application's LinkedIn App ID.</td>
    </tr>
    <tr>
        <td>spring.social.twitter.app-id</td>
        <td></td>
        <td>It is used to set application's Twitter App ID.</td>
    </tr>
    <tr>
        <td>security.basic.authorize-mode</td>
        <td>role</td>
        <td>It is used to set security authorize mode to apply.</td>
    </tr>
    <tr>
        <td>security.basic.enabled</td>
        <td>true</td>
        <td>It is used to enable basic authentication.</td>
    </tr>
</tbody></table>

Update Application.properties

```properties
spring.application.name=Spring Boot App
server.context-path = /myapp
server.port = 2017

```

Browse App now

http://localhost:2017/myapp/hello

### @ConfigurationProperties ###
[See details](http://www.mkyong.com/spring-boot/spring-boot-configurationproperties-example/)
### Spring Boot Starters ###

Spring Boot provides built-in starters which makes development easier and rapid.Starter should follow a naming pattern like: `spring-boot-starter-*`, where * is a particular type of application.

<table class="alt">
    <tbody><tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>spring-boot-starter-thymeleaf</td>
        <td>It is used to build MVC web applications using Thymeleaf views.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-couchbase</td>
        <td>This is used for Couchbase document-oriented database and Spring Data Couchbase.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-artemis</td>
        <td>It is used for JMS messaging using Apache Artemis.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-web-services</td>
        <td>It is used for Spring Web Services.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-mail</td>
        <td>It is used to support Java Mail and Spring Framework's email sending.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-redis</td>
        <td>It is used for Redis key-value data store with Spring Data Redis and the Jedis client.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-web</td>
        <td>It is used for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-gemfire</td>
        <td>It is used to GemFire distributed data store and Spring Data GemFire.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-activemq</td>
        <td>It is used to JMS messaging using Apache ActiveMQ.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-elasticsearch</td>
        <td>It is used to Elasticsearch search and analytics engine and Spring Data Elasticsearch.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-integration</td>
        <td>It is used for Spring Integration.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-test</td>
        <td>It is used to test Spring Boot applications with libraries including JUnit, Hamcrest and Mockito.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-jdbc</td>
        <td>It is used for JDBC with the Tomcat JDBC connection pool.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-mobile</td>
        <td>It is used for building web applications using Spring Mobile.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-validation</td>
        <td>It is used for Java Bean Validation with Hibernate Validator.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-hateoas</td>
        <td>It is used to build hypermedia-based RESTful web application with Spring MVC and Spring HATEOAS.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-jersey</td>
        <td>It is used to build RESTful web applications using JAX-RS and Jersey. An alternative to spring-boot-starter-web.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-neo4j</td>
        <td>It is used for Neo4j graph database and Spring Data Neo4j.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-ldap</td>
        <td>It is used for Spring Data LDAP.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-websocket</td>
        <td>It is used for building WebSocket. applications using Spring Framework?s WebSocket support.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-aop</td>
        <td>It is used for aspect-oriented programming with Spring AOP and AspectJ.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-amqp</td>
        <td>It is used for Spring AMQP and Rabbit MQ.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-cassandra</td>
        <td>It is used for Cassandra distributed database and Spring Data Cassandra.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-social-facebook</td>
        <td>It is used for Spring Social Facebook.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-jta-atomikos</td>
        <td>It is used for JTA transactions using Atomikos.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-security</td>
        <td>It is used for Spring Security.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-mustache</td>
        <td>It is used for building MVC web applications using Mustache views.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-jpa</td>
        <td>It is used for Spring Data JPA with Hibernate.</td>
    </tr>
    <tr>
        <td>spring-boot-starter</td>
        <td>It is used for core starter, including auto-configuration support, logging and YAML.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-groovy-templates</td>
        <td>It is used for building MVC web applications using Groovy Templates views.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-freemarker</td>
        <td>It is used for building MVC web applications using FreeMarker views.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-batch</td>
        <td>It is used for Spring Batch.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-social-linkedin</td>
        <td>It is used for Spring Social LinkedIn.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-cache</td>
        <td>It is used for Spring Framework?s caching support.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-solr</td>
        <td>It is used for the Apache Solr search platform with Spring Data Solr.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-mongodb</td>
        <td>It is used for MongoDB document-oriented database and Spring Data MongoDB.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-jooq</td>
        <td>It is used for jOOQ to access SQL databases. An alternative to spring-boot-starter-data-jpa or spring-boot-starter-jdbc.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-jta-narayana</td>
        <td>It is used for Spring Boot Narayana JTA Starter.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-cloud-connectors</td>
        <td>It is used for Spring Cloud Connectors which simplifies connecting to services in cloud platforms like Cloud Foundry and Heroku.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-jta-bitronix</td>
        <td>It is used for JTA transactions using Bitronix.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-social-twitter</td>
        <td>It is used for Spring Social Twitter.</td>
    </tr>
    <tr>
        <td>spring-boot-starter-data-rest</td>
        <td>It is used for exposing Spring Data repositories over REST using Spring Data REST.</td>
    </tr>
</tbody></table>





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


