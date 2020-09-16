package com.appdynamics.msf.message.infrastructure;

import com.appdynamics.msf.message.domain.MsfMessage;
import com.appdynamics.msf.message.domain.MsfMessageRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MsfMessageRepositoryInMemoryImpl implements MsfMessageRepository {

    private Map<String, MsfMessage> msfMessageRepo = new HashMap<>();

    @Override
    public String getNextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void save(MsfMessage originalMsg) {
        MsfMessage msfMessage = new MsfMessage(originalMsg.getId(),
                originalMsg.getMessage());

        msfMessageRepo.put(msfMessage.getId(), msfMessage);
    }

    @Override
    public Optional<MsfMessage> findById(String id) {
        return Optional.ofNullable(msfMessageRepo.get(id))
                .map(originalMsg -> new MsfMessage(originalMsg.getId(),
                        originalMsg.getMessage()));
    }
}
