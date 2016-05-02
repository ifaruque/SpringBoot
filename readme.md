<b>Spring Boot Features : </b><br/>
1.Create stand-alone Spring applications <br/>
2.Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files) wow!! <br/>

<b>How to start : </b><br/>
You can start Spring Boot Application in the following ways: <br/>
1.Spring Boot CLI<(recommemded 	way)  : 
installation guide: [a link] http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-installing-the-cli <br/>
2.Spring Boot Web Interface<br/>(http://start.spring.io)  : <br/>
3. Use IDEs/IDE Plugin like STS,Netbeans,IntelljIdea<br/>
4.Use Thirdparty Tool like cURL,HTTPie

<b>Spring Boot Application:</b> <br/>
To see some info of creating spring boot app run <br>
spring help<br/>
then spring help init <br>
You see how to create app <br>
command for creating web app <br>
spring init -d=web SpringBoot <br>

<b>Run Boot Application following way:</b> <br/>
1.mvn spring-boot:run <br/>
2. by creating executable jar <br/>
mvn package <br/>
java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar
