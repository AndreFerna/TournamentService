package co.com.pragma.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "plataforma")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlatformEntity {
    @Id
    private Long id;
    @Column(name = "nombre")
    private String name;
}
