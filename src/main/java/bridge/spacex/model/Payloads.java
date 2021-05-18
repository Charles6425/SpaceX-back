package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payloads {
    private String id;
    private String name;
    private String type;
    private Boolean reused;
    private String launch;
    private String customers[];
    private Integer norad_ids[];
    private String nationalities[];
    private String manufacturers[];
    private Number mass_kg;
    private Number mass_lbs;
    private String orbit;
    private String reference_system;
    private String regime;
    private Number longitude;
    private Number semi_major_axis_km;
    private Number eccentricity;
    private Number periapsis_km;
    private Number apoapsis_km;
    private Number inclination_deg;
    private Number period_min;
    private Number lifespan_years;
    private String epoch;
    private Number mean_motion;
    private Number raan;
    private Number arg_of_pericenter;
    private Number mean_anomaly;
    private Object dragon;
    private Number mass_returned_kg;
    private Number mass_returned_lbs;
    private Number flight_time_sec;
    private String manifest;
    private Boolean water_landing;
    private Boolean land_landing;
}
