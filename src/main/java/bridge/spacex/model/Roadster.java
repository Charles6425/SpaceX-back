package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Roadster {
    private String id;
    private String name;
    private String launch_date_utc;
    private Number launch_date_unix;
    private Number launch_mass_kg;
    private Number launch_mass_lbs;
    private Number norad_id;
    private Number epoch_jd;
    private String orbit_type;
    private Number apoapsis_au;
    private Number periapsis_au;
    private Number semi_major_axis_au;
    private Number eccentricity;
    private Number inclination;
    private Number longitude;
    private Number periapsis_arg;
    private Number period_days;
    private Number speed_kph;
    private Number speed_mph;
    private BigDecimal earth_distance_km;
    private BigDecimal earth_distance_mi;
    private BigDecimal mars_distance_km;
    private BigDecimal mars_distance_mi;
    private String flickr_images[];
    private String wikipedia;
    private String video;
    private String details;
}
