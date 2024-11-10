package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/chatbot")
public class ChatbotController {
    @Value("${pyapi.server}")
    String url;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/getUserInfo")
    public Map<String, Object> getUserInfo(
        @RequestParam(name="userId") String userId
    ){
        Map<String, Object> userInfoDict = new HashMap<>();
        userInfoDict.put("userId","0");
        return userInfoDict;
    }

    @GetMapping("/getChatbotResponse")
    public Map<String,String> getChatbotResponse(
        @RequestParam(name="prompt") String prompt
    ){
        String pyurl;
        Map<String,String> chatbotPrompt = new HashMap<>();
        chatbotPrompt.put("prompt", prompt);

        Map<String,String> respData = new HashMap<>(); // 정상용
        Map<String,String> errorData = new HashMap<>(); // 에러용
        
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            pyurl = url+"/getChatbotResponse";
            ResponseEntity<Map> response = restTemplate.postForEntity(pyurl,chatbotPrompt, Map.class);
            System.out.println(response);
            respData = response.getBody();
            return respData;
        } catch(Exception e){
            errorData.put("error", "챗봇호출 에러");
            return errorData;
        }
    }

}