package com.wolin.school.model.grade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeRequest {
    private float value;
    private int wage;
}
