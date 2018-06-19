package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SampleController {
   
   
    @Autowired
    ObjectMapper mapper;

    @Autowired
	public CallStreams callStreams;
    
    @GetMapping(value="api/v1/send")
    ResponseEntity<?> sendSampleText() {
    	 send("Hello!");
         return new ResponseEntity<>("Message Sent",HttpStatus.OK);
		
    }
    
    public  void send(String callText) {
		 callStreams.outboundCalls().send(MessageBuilder
	                .withPayload(callText)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
	                .build());
	    }
	 
    @StreamListener(CallStreams.INPUT)
    public void submitForTranscription(@Payload String callText) {
    	
     	System.out.println("Message Received - "+ callText);
         
    }
   
    
}
