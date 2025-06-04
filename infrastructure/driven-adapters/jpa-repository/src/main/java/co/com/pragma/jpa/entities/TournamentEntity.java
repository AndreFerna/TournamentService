package co.com.pragma.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "torneo")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "fecha_inicio")
    private LocalDateTime startDate;
    @Column(name = "fecha_fin")
    private LocalDateTime endDate;
    @Column(name = "organizador_id")
    private String organizerId;
    @Column(name = "categoria_id")
    private Long idCategory;
    @Column(name = "codigo_unico")
    private String uniqueCode;
    @Column(name = "gratuito")
    private Boolean free;
    @Column(name = "plataforma_id")
    private Long platformId;
    @Column(name = "video_juego_id")
    private Long videoGameId;
}
