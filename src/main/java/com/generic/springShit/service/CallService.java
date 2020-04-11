package com.generic.springShit.service;

import com.generic.springShit.entity.Call;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CallService {
      List<Call>  getAllCalls();

      Call findById(Long id);

      Call save(Call call);

      void deleteCallById(Long id);
}
