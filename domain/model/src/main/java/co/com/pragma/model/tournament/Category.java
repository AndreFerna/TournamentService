package co.com.pragma.model.tournament;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Category {

    private Long categoryId;
    private String description;
    private String alias;

}
