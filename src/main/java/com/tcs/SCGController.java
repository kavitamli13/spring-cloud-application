package com.tcs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SCGController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/call_google")
    public String callGoogleViaGateway() {

        String gatewayUrl =
                "http://scg:8080/external/google/search?q=test";

        String response = restTemplate.getForObject(
                gatewayUrl,
                String.class
        );

        return "Response length from Google via SCG: " + response.length();
    }
}
