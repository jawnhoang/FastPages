package edu.sjsu.project.user;

import javassist.Loader;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * this class handles data validation
 */
public class CustomUserDetails implements UserDetails {

    private static User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> auth = new ArrayList<>();

        if(roles.isEmpty()) {
            user.addRole(new Role("USER", 1));
        }

        for(Role r:roles){
            auth.add(new SimpleGrantedAuthority(r.getName()));
        }
        return auth;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }


    public static User getUser(){
        return user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName(){
        return user.getFirstName()+" "+ user.getLastName();
    }

    public String getEmail(){ return user.getEmail(); }

    public Integer getRoleID(){ return user.getRoles().iterator().next().getId();}

    public long getUserID(){ return user.getId();}

}
