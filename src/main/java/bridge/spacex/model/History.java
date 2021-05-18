package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class History {
    private String id;
    private String title;
    private String event_date_utc;
    private Number event_date_unix;
    private String details;
    private Object links;

}
