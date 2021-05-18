package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dragons {
    private String id;
    private String name;
    private String type;
    private Boolean actyve;
    private Integer crew_capacity;
    private Float sidewall_angle_deg;
    private Integer orbit_duration_yr;
    private Float dry_mass_kg;
    private Float dry_mass_lb;
    private String first_flight;
    private Object heat_shield;
    private Object thrusters;
    private Object launch_payload_mass;
    private Object launch_payload_vol;
    private Object return_payload_mass;
    private Object pressurized_capsule;
    private Object trunk;
    private Object diameter;
    private String flickr_images[];
    private String wikipedia;
    private String description;




}
