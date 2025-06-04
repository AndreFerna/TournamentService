package co.com.pragma.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "vista")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @Column(name = "fecha")
    private LocalDateTime date;
    @Column(name = "torneo_id")
    private Long tournamentId;
    @Column(name = "gratuito")
    private boolean free;
    private Long aforo;
    @Column(name = "identificador")
    private String identifier;
    @Column(name = "precio")
    private BigDecimal ticketPrice;

}
