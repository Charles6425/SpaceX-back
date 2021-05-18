package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Landpads {
    private String id;
    private String name;
    private String status;
    private String type;
    private String locality;
    private String region;
    private Float latitude;
    private Float longitude;
    private Float landing_attempts;
    private Float landing_successes;
    private String wikipedia;
    private String details;
    private String launches[];
}
