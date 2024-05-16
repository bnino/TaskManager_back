package com.TaskManager.entity;

import com.TaskManager.entity.Enums.TaskStatusList;
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
    private TaskStatusList status = TaskStatusList.RECIBIDO;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id_task",
            referencedColumnName = "idTask",
            foreignKey = @ForeignKey(name = "fk_task_id")
    )
    private Tasks idTask;

    @PrePersist
    protected void onCreate(){
        updateDate = new Date();
    }

}
