package co.com.pragma.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "usuario")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "correo")
    private String mail;
    @Column(name = "clave")
    private String password;
    @Column(name = "rol_id")
    private int roleId;

}
