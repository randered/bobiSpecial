package guru.springframework.config;

import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {
    StrongPasswordEncryptor strongPasswordEncryptor;
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

    public void setPasswordEncryptor(StrongPasswordEncryptor passwordEncryptor) {
        this.strongPasswordEncryptor = passwordEncryptor;

    }
}
