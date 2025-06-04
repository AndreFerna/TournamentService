package co.com.pragma.model.tournament;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Tournament{

    private Long idTournament;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String organizer;
    private String category;
    private String uniqueCode;
    private boolean isFree;
    private String platformName;
    private String videGameName;

}
