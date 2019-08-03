package ru.itis.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "\"user\"", schema = "public")
@ToString(exclude = {"ownGalleries", "comments", "followings", "followers", "galleries"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String login;
    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "owner")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Gallery> ownGalleries;

    @OneToMany(mappedBy = "author")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    @ManyToMany(mappedBy = "followers")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> followings;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name="subscriptions",
            joinColumns = @JoinColumn(name="subscriptor_id"),
            inverseJoinColumns = @JoinColumn(name="subscriber_id")
    )
    private List<User> followers;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "userId")
    private List<Gallery> galleries;
}
