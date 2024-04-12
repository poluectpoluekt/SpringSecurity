package com.education.springsecurity.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "person")
@Entity
public class Person implements UserDetails {

    @Id
    private long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Event> events;

    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;
    @Column(name = "is_enabled")
    private boolean isEnabled;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //return List.of(new SimpleGrantedAuthority("user"));
        return Collections.EMPTY_SET; //TODO; List.of(new SimpleGrantedAutority("user"))
    }

    @Override
    public String getUsername() { //можно ли заменить на email
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
