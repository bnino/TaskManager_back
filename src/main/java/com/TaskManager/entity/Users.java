package com.TaskManager.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String password;

    @NotBlank(message = "Please, add an email")
    private String email;

    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_rol_id"), name = "id_rol")
    private UsersRol rol;
    
    @PrePersist
    protected void onCreate(){
        creation_date = new Date();
    }
}
