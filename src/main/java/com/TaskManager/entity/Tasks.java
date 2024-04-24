package com.TaskManager.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_type_id"), name = "id_task_type")
    private TaskTypes id_task_type;

    @PrePersist
    protected void onCreate(){
        start_date = new Date();
        update_date = new Date();
    }

}
