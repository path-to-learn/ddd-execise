package com.appdynamics.msf.message.domain;

import java.util.Optional;

public interface MsfMessageRepository {

    String getNextId();

    void save(MsfMessage msfMessage);

    Optional<MsfMessage> findById(String id);
}
