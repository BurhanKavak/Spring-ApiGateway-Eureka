package com.example.noteservice.client;

import com.example.noteservice.dto.UserIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserFeignClient {

    @GetMapping("user/getUserById/{userId}")
    UserIdResponse getUserById(@PathVariable Long userId);
}


