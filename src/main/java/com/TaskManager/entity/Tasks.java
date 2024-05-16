package com.TaskManager.entity;

import java.io.Serializable;
import java.util.Date;

import com.TaskManager.entity.Enums.TaskStatusList;
import com.TaskManager.entity.Enums.TaskType;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Tasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;

    @NotBlank
    private String title;
    private String detail;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @ManyToOne()
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_id"), name = "id_user")
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Users idUser;

    @Enumerated(EnumType.ORDINAL)
    private TaskType taskType;

    /*@OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "task_status_id",
            referencedColumnName = "taskStatusId",
            foreignKey = @ForeignKey(name = "fk_task_status_id")
    )
    private TaskStatus taskStatus;*/
    
    /*@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_type_id"), name = "id_task_type")
    private TaskTypes id_task_type;*/

    @PrePersist
    protected void onCreate(){
        startDate = new Date();
    }

}
