package com.appdynamics.msf.message.application;

import com.appdynamics.msf.message.domain.MsfMessage;
import com.appdynamics.msf.message.domain.MsfMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageApplicationService {

    private final MsfMessageRepository msfMessageRepository;

    @Autowired
    public MessageApplicationService(MsfMessageRepository msfMessageRepository) {
        this.msfMessageRepository = msfMessageRepository;
    }

    public MsfMessage createMessage(CreateMessageCommand createMessageCommand) {
        // TODO: implement this
        throw new UnsupportedOperationException("implement me");
    }

    // TODO: implement this - feel free to change signature if necessary
    public MsfMessage retrieveMessage(String id) {
        throw new UnsupportedOperationException("implement me");
    }
}
