package com.sp.fc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true) //prePostEnabled로 권한체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //사용자 추가 가능 - 오버라이딩


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(User.builder()
                        .username("user2")
                        .password(passwordEncoder().encode("2222"))
                        .roles("USER"))
                .withUser(User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("3333"))
                        .roles("ADMIN"));

    }
    //패스워드 인코딩 해주어야함
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 보완이 필요 없는 페이지 설정 ex) 메인
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests)->
                //antMatchers 인증이 없어도 접속가능한 페이지 설정 
                requests.antMatchers("/").permitAll()
                        //외 페이지 인증 필요
                        .anyRequest().authenticated()
        );
        http.formLogin();
        http.httpBasic();
    }
}
