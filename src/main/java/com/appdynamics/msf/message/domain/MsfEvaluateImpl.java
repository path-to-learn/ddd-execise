package com.appdynamics.msf.message.domain;

import com.appdynamics.msf.message.application.CreateMessageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.Date;
import java.util.UUID;

@Service
public class MsfEvaluateImpl implements MsfEvaluate{

    private MsfMessageRepository msfMessageRepository;

    @Autowired
    public MsfEvaluateImpl(MsfMessageRepository msfMessageRepository) {
        this.msfMessageRepository = msfMessageRepository;
    }

    @Override
    public MsfMessage createMessage(CreateMessageCommand createMessageCommand) {
        MsfMessage msfMessage = new MsfMessage(UUID.randomUUID().toString(), createMessageCommand.getMessage(),
                getExpiry(createMessageCommand.getTtl())
                );
        msfMessageRepository.save(msfMessage);
        return msfMessage;
    }


    private Date getExpiry(Integer ttl) {
        Date date = new Date();
        long expiryNum = date.toInstant().plusSeconds(ttl * 60).toEpochMilli();
        return new Date(expiryNum);
    }
}
