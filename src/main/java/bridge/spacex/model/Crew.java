package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Crew {
    private String id;
    private String name;
    private String status;
    private String agency;
    private String image;
    private String wikpedia;
    private String launches[];


}
