package com.appdynamics.msf.message.domain;

import com.appdynamics.msf.message.application.CreateMessageCommand;
import com.appdynamics.msf.message.application.CreateMessageResponseDto;

public interface MsfEvaluate {

        public MsfMessage createMessage(CreateMessageCommand createMessageCommand);

}
