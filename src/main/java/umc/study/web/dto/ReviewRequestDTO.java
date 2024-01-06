package umc.study.web.dto;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto{
        String title;
        Float score;
        String body;
        Long memberId;
        Long storeId;
    }
}
