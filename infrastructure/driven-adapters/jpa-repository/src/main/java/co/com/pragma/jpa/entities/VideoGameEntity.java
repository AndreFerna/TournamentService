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
@Table(name = "video_juego")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VideoGameEntity {
    @Id
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "tipo_id")
    private Long typeId;
}
