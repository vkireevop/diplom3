package com.example.diplom3.dto;

import com.example.diplom3.model.TaskSet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

@ToString(exclude = "taskSet")
@Data
public class TaskDto {
    private Long taskId;
    private String question;
    private String answer;
    @JsonIgnore
    private TaskSet taskSet;
}
