package com.postbox.api;

import com.postbox.domain.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ApiController {

    private final UserRepository userRepository;


    @GetMapping("/test")
    public String testDto() {
        return "test Dto";
    }

//    @GetMapping("/api/user")
//    public String userServiceApi() {
//        userRepository.findById()
//    }
    @Data
    static class UserDto{
        private String username;
        private String email;
    }
}
