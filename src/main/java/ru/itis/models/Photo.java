package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString(exclude = "gallery")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String photoPath;
    private String description;
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "galleryId")
    private Gallery gallery;

    @OneToMany(mappedBy = "photo")
    private List<Comment> comments;
}
