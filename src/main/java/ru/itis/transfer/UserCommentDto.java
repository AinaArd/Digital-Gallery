package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Comment;
import ru.itis.models.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentDto {
    private Long id;
    private String author;
    private String commentText;

    public static UserCommentDto from(User user, Comment comment) {
        return UserCommentDto.builder()
                .id(user.getId())
                .author(user.getName())
                .commentText(comment.getContent())
                .build();
    }
}
