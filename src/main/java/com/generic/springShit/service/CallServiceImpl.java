package com.generic.springShit.service;

import com.generic.springShit.entity.Call;
import com.generic.springShit.entity.SMS;
import com.generic.springShit.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;
import java.util.Optional;

@Service
public class CallServiceImpl implements CallService {
    @Autowired
    CallRepository callRepository;

    @Override
    public List<Call> getAllCalls() {
        return callRepository.findAll();
    }

    @Override
    public Call findById(Long id) {
        Optional<Call> call = callRepository.findById(id);
        return call.orElse(new Call());
    }

    @Override
    public Call save(Call call) {
        return callRepository.save(call);
    }

    @Override
    public void deleteCallById(Long id) {
        deleteCallById(id);
    }

}
