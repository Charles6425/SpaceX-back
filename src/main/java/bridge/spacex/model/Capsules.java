package bridge.spacex.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Capsules {
    private String id;
    private String serial;
    private String status;
    private String type;
    private String dragon;
    private String reuse_count;
    private String water_landings;
    private String land_landings;
    private String last_update;
    private String launches[];


}
