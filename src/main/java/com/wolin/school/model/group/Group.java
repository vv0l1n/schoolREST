package com.wolin.school.model.group;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Group {
    
    @Id
    @SequenceGenerator(
        name = "group_id_sequence",
        sequenceName = "group_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "group_id_sequence"
    )
    private Long gid;
    private String name;

    public Group(String name) {
        this.name = name;
    }
    
}
