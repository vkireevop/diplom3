package com.example.diplom3.dto;

import com.example.diplom3.model.TaskSet;
import lombok.Data;
import lombok.ToString;

@ToString(exclude = "taskSet")
@Data
public class TaskDto {
    private Long taskId;
    private String question;
    private String answer;
    private TaskSet taskSet;
}
