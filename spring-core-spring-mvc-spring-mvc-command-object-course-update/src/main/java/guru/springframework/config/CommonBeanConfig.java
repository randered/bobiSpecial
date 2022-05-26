package guru.springframework.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by jt on 12/14/15.
 */
@Configuration
@EnableJpaRepositories("guru.springframework.repositories")
public class CommonBeanConfig {

    @Bean
    public StrongPasswordEncryptor strongEncryptor(){
        return new StrongPasswordEncryptor();
    }
}
