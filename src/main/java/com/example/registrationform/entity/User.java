package com.example.registrationform.entity;

import com.example.registrationform.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnError;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "username")
    @NotEmpty(message = "username cannot be empty")
//    @Size(min = 4, max = 20)
    private String username;

    @Column(name = "password", columnDefinition = "text")
    @NotEmpty(message = "password cannot be empty")
//    @Size(min = 4, max = 20)
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    public User(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RoleEnum> roles = new ArrayList<>();
        roles.add(role);
        return roles;
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
}
