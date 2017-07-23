### Spring Boot Benefits : ###

1. Create stand-alone Spring applications 
2. Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files) wow!! 
3. Groovy support, allowing you to build Spring MVC web apps with as little as a single file.
4. no need single line of XML even No web.xml file either. This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or infrastructure.

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

### How to run app two way ###
1. Maven
	1. mvn spring-boot:run
	2. mvn package && java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar
2. Gradle
	1. gradle bootRun
	2. gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar
 
	
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


