package com.appdynamics.msf.message.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final String messageBaseAccessLink;
    private final MessageApplicationService messageApplicationService;

    @Autowired
    public MessageController(@Value("${message.baseAccessLink}") String messageBaseAccessLink,
                             MessageApplicationService messageApplicationService) {
        this.messageBaseAccessLink = messageBaseAccessLink;
        this.messageApplicationService = messageApplicationService;
    }

    @PostMapping("/message")
    ResponseEntity<?> createMessage(@RequestBody CreateMessageCommand createMessageCommand) {
        //TODO: implement this to create the message
        if (createMessageCommand.getTtl() == null)
                createMessageCommand.setTtl(30);

        //CreateMessageResponseDto responseDto = new CreateMessageResponseDto(messageBaseAccessLink + "/api/v1/message/blah", new Date());

        CreateMessageResponseDto responseDto = messageApplicationService.createMessage(createMessageCommand);

        return ResponseEntity.created(UriComponentsBuilder.fromHttpUrl(responseDto.getAccessLink()).build().toUri())
                .body(responseDto);
    }

    // 200 - ok response with message
    // 404 - not found
    // 410 - error with expired message
    // 410 - error with message already retrieved
    @GetMapping("/message/{id}")
    ResponseEntity<?> retrieveMessage(@PathVariable String id) {
        // TODO: implement this to retrieve the message

        return ResponseEntity.ok(new RetrieveMessageResponseDto("this is a sample message - you need to implement the business logic for this endpoint"));
    }

}
