package com.postbox.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(JoinForm joinForm) {
        User user = new User();
        userRepository.save(user);
    }


//    public List<User> findUserById(User);






}
