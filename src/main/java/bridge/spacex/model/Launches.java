package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@Data
@AllArgsConstructor

public class Launches {
    @Id
    private String id;
    private Integer flight_number;
    private String name;
    private String date_utc;
    private Integer date_unix;
    private String date_local;
    private String date_precision;
    private String static_fire_date_utc;
    private Integer static_fire_date_unix;
    private Boolean tdb;
    private Boolean net;
    private Integer window;
    private String rocket;
    private Boolean success;
    private Object failures;
    private Boolean upcoming;
    private String details;
    private Object fairings;
    private String crew[];
    private String ships[];
    private String capsules[];
    private String payloads[];
    private String launchpad;
    private Object cores;
    private Object links;
    private String presskit;
    private String webcast;
    private String youtube_id;
    private String article;
    private String wikipedia;
    private Boolean auto_update;


    public Launches() {

    }


}
