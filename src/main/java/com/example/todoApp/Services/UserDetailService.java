package com.example.todoApp.Services;

import com.example.todoApp.Model.User;
import com.example.todoApp.Model.UserPrincipal;
import com.example.todoApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
//        if(user != null ){
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getUsername())
//                    .password(user.getPassword())
//    //                .roles(user.getRoles().toArray(new String[0]))
//                    .build();
//        }
        if(user == null)
            throw new UsernameNotFoundException("User not found: "+ username);
        return new UserPrincipal(user);
    }
}
