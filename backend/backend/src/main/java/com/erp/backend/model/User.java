package com.erp.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Getter //generates getX()
@Setter // generates setX()
@NoArgsConstructor //required by JPA
@AllArgsConstructor // convenience
@Builder // clean object creation
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false,unique = true,length = 100)
    private String username;
    @Email
    @NotBlank
    @Column(nullable = false,unique = true,length = 150)
    private String email;
    @NotBlank
    @Size(min = 6)
    @Column(nullable = false,length = 255)
    private String password;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(name="created_at", updatable = false) //prevents accidental updates
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


}
