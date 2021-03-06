package com.sparta.studywebpage.security;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        // Token 생성
        final String token = JwtTokenUtils.generateJwtToken(userDetails);
        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        ResponseDto responseDto = new ResponseDto(true, "로그인 성공");
        String result = mapper.writeValueAsString(responseDto);
        response.getWriter().write(result);
    }

}
