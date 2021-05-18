package bridge.spacex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.UUID;


@Data
@AllArgsConstructor
public class Cores {
    private String id;
    private String serial;
    private Integer block;
    private String status;
    private Integer reuse_count;
    private Integer rtls_attempts;
    private Integer asds_attempts;
    private Integer asds_landings;
    private String last_update;
    private String launches[];



}
