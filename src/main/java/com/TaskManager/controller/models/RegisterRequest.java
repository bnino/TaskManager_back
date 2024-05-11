package com.TaskManager.controller.models;

import com.TaskManager.entity.Enums.UsersRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String document;

    private String firstname;

    private String lastname;

    @NotBlank(message = "Please, add an username")
    private String username;

    @NotBlank(message = "Please, add a password")
    @Length(min = 6)
    private String password;

    @NotBlank(message = "Please, add an email")
    private String email;

    private String phone;

    @Enumerated(EnumType.ORDINAL)
    private UsersRole role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;

    @PrePersist
    protected void onCreate(){
        creation_date = new Date();
    }
}
