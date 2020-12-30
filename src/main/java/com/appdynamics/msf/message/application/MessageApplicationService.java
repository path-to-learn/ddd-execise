package com.appdynamics.msf.message.application;

import com.appdynamics.msf.message.domain.MsfEvaluate;
import com.appdynamics.msf.message.domain.MsfMessage;
import com.appdynamics.msf.message.domain.MsfMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageApplicationService {

    private final MsfMessageRepository msfMessageRepository;

    private final MsfEvaluate msfEvaluate;

    private final String messageBaseAccessLink;

    @Autowired
    public MessageApplicationService(@Value("${message.baseAccessLink}") String messageBaseAccessLink,
                                     MsfMessageRepository msfMessageRepository, MsfEvaluate msfEvaluate) {
        this.msfMessageRepository = msfMessageRepository;
        this.msfEvaluate = msfEvaluate;
        this.messageBaseAccessLink = messageBaseAccessLink;
    }

//    public MsfMessage createMessage(CreateMessageCommand createMessageCommand) {
//        // TODO: implement this
//        throw new UnsupportedOperationException("implement me");
//    }
//
    public CreateMessageResponseDto createMessage(CreateMessageCommand createMessageCommand) {
        // TODO: implement this
        MsfMessage msfMessage = msfEvaluate.createMessage(createMessageCommand);
        CreateMessageResponseDto createMessageResponseDto = new CreateMessageResponseDto(messageBaseAccessLink + "/api/v1/message/"+ msfMessage.getId() , msfMessage.getExpiryDate());
        //throw new UnsupportedOperationException("implement me");
        return createMessageResponseDto;
    }

    // TODO: implement this - feel free to change signature if necessary
    public MsfMessage retrieveMessage(String id) {
        throw new UnsupportedOperationException("implement me");
    }
}
