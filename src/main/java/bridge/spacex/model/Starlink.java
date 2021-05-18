package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Starlink {
    private String id;
    private String version;
    private Object launch;
    private Number longitude;
    private Number latitude;
    private Number height_km;
    private Number velocity_kms;
    private Object spaceTrack;
}
