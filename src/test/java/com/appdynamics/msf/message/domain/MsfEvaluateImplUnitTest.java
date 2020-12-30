package com.appdynamics.msf.message.domain;

import com.appdynamics.msf.message.application.CreateMessageCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MsfEvaluateImplUnitTest {

    private MsfEvaluate msfEvaluate;

    private MsfMessageRepository msfMessageRepository;

    @BeforeEach
    public void setup() {
        msfMessageRepository = mock(MsfMessageRepository.class);
        msfEvaluate = new MsfEvaluateImpl(msfMessageRepository);
    }

    @Test
    public void testCreateMessage() {
        CreateMessageCommand createMessageCommand = new CreateMessageCommand();
        createMessageCommand.setMessage("foo");
        createMessageCommand.setTtl(10);

        MsfMessage msfMessage = msfEvaluate.createMessage(createMessageCommand);
        Assertions.assertNotNull(msfMessage);
        Assertions.assertNotNull(msfMessage.getMessage());
        Assertions.assertEquals("foo", msfMessage.getMessage());
        Date currDate = new Date();
        Assertions.assertTrue(msfMessage.getExpiryDate().after(currDate));
        Assertions.assertFalse(msfMessage.getOpened());

        verify(msfMessageRepository, times(1)).save(any());
    }
}
