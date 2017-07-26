package com.javaaround.springboot.controller

import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global.properties")
public class GlobalProperties {

    @Value("${thread-pool}")
    private int threadPool;

    @Value("${email}")
    private String email;

    public void setThreadPool(int threadPool){
    	this.threadPool = threadPool;
    }
    public String getThreadPool(){
    	return threadPool;
    }

    public void setEmail(String email){
    	this.email = email;
    }
    public String getEmail(){
    	return email;
    }
    public String toString(){
    	return email + threadPool;
    }

}