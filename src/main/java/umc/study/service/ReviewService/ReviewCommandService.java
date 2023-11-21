package umc.study.service.ReviewService;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review review(ReviewRequestDTO.ReviewDto request);
}
