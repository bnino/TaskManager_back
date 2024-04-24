package com.TaskManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_id"), name = "id_task")
    private Tasks id_task;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_id"), name = "id_user_assigned")
    private Users id_user_assigned;
}
