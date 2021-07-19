package dyd.usizo.service;

import dyd.usizo.models.Role;
import dyd.usizo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userService.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getNom(), user.getPassword(),
                getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        Role role = Optional.ofNullable(user.getRole()).orElse(new Role());
        return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
    }
}
