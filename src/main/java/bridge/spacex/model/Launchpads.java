package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Launchpads {
    private String id;
    private String name;
    private String full_name;
    private Object status;
    private String locality;
    private String region;
    private String timezone;
    private Float latitude;
    private Float longitude;
    private Integer launch_attempts;
    private Integer launch_successes;
    private String rockets[];
    private String launches[];
}
