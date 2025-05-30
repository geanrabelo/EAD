package com.br.EAD.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_classroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tittle;

    private String description;

    @Column(name = "link_video")
    private String linkVideo;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
