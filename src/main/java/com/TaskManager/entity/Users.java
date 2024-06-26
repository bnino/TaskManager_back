package com.TaskManager.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.TaskManager.entity.Enums.UsersRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "username_unique",
            columnNames = "username"
        ),
        @UniqueConstraint(
            name = "email_unique",
            columnNames = "email"
        )
    }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users implements UserDetails, Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id_user;

    @Column(length = 25)
    private String document;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @NotBlank(message = "Please, add an username")
    @Column(length = 50)
    private String username;

    @NotBlank(message = "Please, add a password")
    @Length(min = 6)
    @JsonIgnore
    private String password;

    @NotBlank(message = "Please, add an email")
    private String email;

    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;
    
    /*
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_rol_id"), name = "id_rol")
    private UsersRol rol;
    */
    @Enumerated(EnumType.ORDINAL)
    private UsersRole role;

    @PrePersist
    protected void onCreate(){
        creation_date = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
