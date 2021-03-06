package com.example.billing;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class Client {

    private final RestOperations restTemplate;
    // private final String serviceEndpoint;

     //       public Client(String serviceEndpoint) {
     //           this.restTemplate = new RestTemplate();
     //           this.serviceEndpoint = serviceEndpoint;
     //       }

     //       public void billUser(String userId, int amount) {
     //           restTemplate.postForEntity(serviceEndpoint + "/reocurringPayment", amount, String.class);
     //       }

            public Client(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
            }

            @HystrixCommand(fallbackMethod = "billUserFallback")

            public void billUser(String userId, int amount) {
                restTemplate.postForEntity("billing"+ "/reocurringPayment", amount, String.class);
            }


            public void billUserFallback(String userId, int amount) {
                System.out.println("Executing fallback method for the user: " + userId + " and amount: " + amount);
            }



}