package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fairings {
    private String id;
    private String serial;
    private String version;
    private String status;
    private Number reuse_count;
    private Number net_landing_attempts;
    private Number net_landing;
    private Number water_landing_attempts;
    private Number water_landing;
    private String last_update;
    private String launches[];

}
