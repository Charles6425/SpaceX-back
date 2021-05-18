package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Ships {
    private String id;
    private String name;
    private String legacy_id;
    private String model;
    private String type;
    private String roles[];
    private Boolean active;
    private Number imo;
    private Number mmsi;
    private Number abs;
    private Number classe;
    private Number mass_kg;
    private Number mass_lbs;
    private Number year_built;
    private String home_port;
    private String status;
    private BigDecimal speed_kn;
    private Number course_deg;
    private Number latitude;
    private Number longitude;
    private String last_ais_update;
    private String link;
    private String image;
    private String launches[];

}
