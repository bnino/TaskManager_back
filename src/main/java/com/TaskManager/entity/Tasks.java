package com.TaskManager.entity;

import java.util.Date;

import com.TaskManager.entity.Enums.TaskType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task;

    @NotBlank
    private String title;
    private String detail;

    @Column(length = 30)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date update_date;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_id"), name = "id_user")
    private Users id_user;

    @Enumerated(EnumType.ORDINAL)
    private TaskType taskType;
    
    /*@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_type_id"), name = "id_task_type")
    private TaskTypes id_task_type;*/

    @PrePersist
    protected void onCreate(){
        start_date = new Date();
        update_date = new Date();
    }

}
