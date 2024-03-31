package com.postbox.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoinService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional(readOnly = false)
    public void save(JoinForm joinForm) {
        boolean isUser = userRepository.existsByUsername(joinForm.getUsername());
        if (isUser) {
            return;
        }

        User user = new User();
        user.setUsername(joinForm.getUsername());
        user.setPassword(passwordEncoder.encode(joinForm.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}
