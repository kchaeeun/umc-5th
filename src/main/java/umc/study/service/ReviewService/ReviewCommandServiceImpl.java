package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.*;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.domain.mapping.ReviewMember;
import umc.study.domain.mapping.ReviewStore;
import umc.study.repository.*;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional          // 반드시 public 메서드에서 적용, 해당 클래스에 속하는 메서드에 공통적으로 적용된다.
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewStoreRepository reviewStoreRepository;
    private final ReviewMemberRepository reviewMemberRepository;

    @Override
    @Transactional
    public Review review(ReviewRequestDTO.ReviewDto request) {
        // Review 엔티티 생성
        Review newReview = ReviewConverter.toReview(request);

        // Member 조회
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newReview.setMember(member);

        // Store 조회
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        newReview.setStore(store);

        // ReviewMember 생성 및 연결
        ReviewMember reviewMember = ReviewMemberConverter.toReviewMember(member);
        reviewMember.setReview(newReview);

        // ReviewStore 생성 및 연결
        ReviewStore reviewStore = ReviewStoreConverter.toReviewStore(store);
        reviewStore.setReview(newReview);

        Review savedReview = reviewRepository.save(newReview);

        reviewMemberRepository.save(reviewMember);
        reviewStoreRepository.save(reviewStore);

        return savedReview;
    }

}
