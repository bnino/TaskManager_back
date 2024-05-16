package com.TaskManager.controller.models;

import com.TaskManager.entity.Enums.TaskStatusList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskStatusRequest {
    public TaskStatusList taskStatus;
}
