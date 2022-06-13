package com.sparta.studywebpage.security.filter;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


public class FormLoginFilter extends UsernamePasswordAuthenticationFilter {
    final private ObjectMapper objectMapper;
    final private UserRepository userRepository;

//    @Autowired
//    public FormLoginFilter(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    public FormLoginFilter(final AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.userRepository = userRepository;
        super.setAuthenticationManager(authenticationManager);
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;
        try {
            JsonNode requestBody = objectMapper.readTree(request.getInputStream());
            String username = requestBody.get("username").asText();
            String password = requestBody.get("password").asText();
            Optional<User> user= userRepository.findByUsername(username);
            if(!user.isPresent()){
                throw new IllegalArgumentException("존재하지 않는 아이디 입니다.");
            }
            System.out.println(user.get().getUsername());



            if(!userRepository.existsByUsername(username)){
                throw new CustomException(ErrorCode.NOT_EXISTS_USERNAME);
                
            }
            if(!userRepository.existsByPassword(password)){
                throw new CustomException(ErrorCode.NOT_EXISTS_PASSWORD);

            }

            authRequest = new UsernamePasswordAuthenticationToken(username, password);

        } catch (Exception e) {

            throw new RuntimeException("username, password 입력이 필요합니다. (JSON)");
        }

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
