package com.burakcanaksoy.layer1.user;

import com.burakcanaksoy.layer1.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phone;
    private int age;
    private boolean active;
}
