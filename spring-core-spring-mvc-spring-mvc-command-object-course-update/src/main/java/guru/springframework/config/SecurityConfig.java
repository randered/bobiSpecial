package guru.springframework.config;



import org.jasypt.spring.security3.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
//        http.authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated())
//                .httpBasic(withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoderImpl passwordEncoder(StrongPasswordEncryptor passwordEncryptor){
        PasswordEncoderImpl passwordEncoder = new PasswordEncoderImpl();
        passwordEncoder.setPasswordEncryptor(passwordEncryptor);
        return passwordEncoder;
    }


}
