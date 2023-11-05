package com.example.myProject.services;
import com.example.myProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}

// package com.example.myProject.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.example.myProject.domain.user.User;
// import com.example.myProject.exceptions.UserNotFoundException;
// import com.example.myProject.repositories.UserRepository;

// @Service
// public class AuthorizationService implements UserDetailsService {

//     @Autowired
//     UserRepository repository;


//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         // TODO Auto-generated method stub
//         return repository.findByEmail(username);
//         // throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
//     }

// // public interface AuthService {

//     // @Autowired
//     // private UsersRepository userRepository;

//     // public void saveUser(User user);
//     // public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException;

//     // @Override
//     // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
//     //     // It is clearly wrong. Moment 22:30 of the video.
//     // }
    
// }
