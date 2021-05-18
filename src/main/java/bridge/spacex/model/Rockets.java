package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rockets {
    private String id;
    private String name;
    private String type;
    private Number stages;
    private Number boosters;
    private Number cost_per_launch;
    private Number success_rate_pct;
    private String first_flight;
    private String country;
    private String company;
    private Object height;
    private Object diameter;
    private Object mass;
    private Object payload_weights;
    private Object first_stage;
    private Object thrust_vacuum;
    private Object second_stage;
    private Object payloads;
    private Object engines;
    private Object landing_legs;
    private String flickr_images[];
    private String wikipedia;
    private String description;

}
