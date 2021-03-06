package sactio.reminderapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "activity_runtime")
public class ActivityRuntimeEntity {

    @Id
    @Column(name = "activity_id", nullable = false)
    private Integer activityId;
    @Column(name = "start_time", nullable = false)
    private String startTime;
    @Column(name = "end_time", nullable = false)
    private String endTime;
}
