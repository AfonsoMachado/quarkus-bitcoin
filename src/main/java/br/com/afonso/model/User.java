package br.com.afonso.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@UserDefinition
@Table(name = "user")
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Username
    @Column(name = "username")
    private String username;

    @Password
    @Column(name = "password")
    private String password;

    @Roles
    @Column(name = "role")
    private String role;

    public static void add(User user) {
        user.password = BcryptUtil.bcryptHash(user.password);
        user.role = validateUsername(user.username);
        user.persist();
    }

    private static String validateUsername(String username) {
        return username.equals("afonso") ? "admin" : "user";
    }
}
