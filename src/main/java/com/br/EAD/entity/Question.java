package com.br.EAD.entity;

import com.br.EAD.dto.request.Options;
import com.br.EAD.enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_question")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String statement;

    private Type type;

    private List<Options> options;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

}
