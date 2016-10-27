<b>Spring Boot Features : </b><br/>
1.Create stand-alone Spring applications <br/>
2.Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files) wow!! <br/>
2.Groovy support, allowing you to build Spring MVC web apps with as little as a single file.<br/>

<b>How to start : </b><br/>
You can start Spring Boot Application in the following ways: <br/>
1.Spring Boot CLI<(recommemded 	way)  : 
installation guide: [a link] http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-installing-the-cli <br/>
2.Spring Boot Web Interface<br/>(http://start.spring.io)  : <br/>
3. Use IDEs/IDE Plugin like STS,Netbeans,IntelljIdea<br/>
4.Use Thirdparty Tool like cURL,HTTPie

<b>Spring Boot Application:</b> <br/>
To see some info of creating spring boot app run <br>
<b>spring help</b><br/>
<b>spring help init</b> <br>
You see how to create app <br>
command for creating web app <br>
<b>spring init -n=spring-boot -g=com.javaaround --package-name=com.javaaround.boot -d=web springbootapp</b> <br>

<b>Run Boot Application following way:</b> <br/>
1.<b>mvn spring-boot:run </b><br/>
2. by creating executable jar <br/>
<b>mvn package <br/>
java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar </b>
<b>Testing Application</b> <br/>
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


