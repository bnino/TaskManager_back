package com.TaskManager.entity;

import com.TaskManager.entity.Enums.TaskStatusList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(
        name = "task_status"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskStatus {

    @Id
    @SequenceGenerator(
            name = "task_status_sequence",
            sequenceName = "task_status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "task_status_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long taskStatusId;

    @Enumerated(EnumType.ORDINAL)
    private TaskStatusList status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "id_task",
            referencedColumnName = "idTask",
            foreignKey = @ForeignKey(name = "fk_task_id")
    )
    @JsonIgnore
    private Tasks idTask;

    @PrePersist
    protected void onCreate(){
        updateDate = new Date();
    }

}
