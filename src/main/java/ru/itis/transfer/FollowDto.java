package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowDto {
    private Long userToFollowId;

    public static FollowDto from(User userToFollow) {
        return FollowDto.builder()
                .userToFollowId(userToFollow.getId())
                .build();
    }
}
