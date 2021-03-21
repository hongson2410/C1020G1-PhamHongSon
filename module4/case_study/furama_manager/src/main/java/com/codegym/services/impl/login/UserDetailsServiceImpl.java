package com.codegym.services.impl.login;

import com.codegym.models.employee.FuramaRoleUser;
import com.codegym.models.employee.FuramaUser;
import com.codegym.repositories.login.FuramaRoleUserRepository;
import com.codegym.repositories.login.FuramaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    FuramaUserRepository furamaUserRepository;
    @Autowired
    FuramaRoleUserRepository furamaRoleUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FuramaUser furamaUser = this.furamaUserRepository.findFuramaUserByUserName(username);

        if (furamaUser == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + furamaUser);

        // [ROLE_EMPLOYEE, ROLE_MANAGER,..]
        List<FuramaRoleUser> userRoles = this.furamaRoleUserRepository.findByFuramaUser(furamaUser);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (FuramaRoleUser userRole : userRoles) {
                // ROLE_EMPLOYEE, ROLE_MANAGER,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getFuramaRole().getRoleName());
                grantList.add(authority);
            }
        }
        //tạo principle
        UserDetails userDetails = (UserDetails) new User(furamaUser.getUserName(),
                furamaUser.getPassword(), grantList);

        return userDetails;
    }
}
