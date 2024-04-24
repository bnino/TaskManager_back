package com.TaskManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task_type;

    @NotBlank
    @Column(length = 50)
    private String description;
}
