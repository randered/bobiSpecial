package guru.springframework.services.security;

import guru.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.User;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserSecurityServiceImpl implements UserDetailsService {

    private final UserService userService;
    @Autowired
    private Converter<User, Object > userToUserDetailsConverter;

    @Autowired
    public UserSecurityServiceImpl(UserService userService, Converter<User, UserDetailsImpl > userToUserDetailsConverter) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "userToUserDetails")
    public void setUserToUserDetailsConverter(Converter<User,Object > userToUserDetailsConverter){
        this.userToUserDetailsConverter = userToUserDetailsConverter;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;

    }
}
