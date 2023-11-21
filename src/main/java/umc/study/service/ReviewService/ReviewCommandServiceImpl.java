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
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
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

    @Override
    @Transactional
    public Review review(ReviewRequestDTO.ReviewDto request) {

        // Review 엔티티 생성
        Review newReview = ReviewConverter.toReview(request);
        List<Member> memberList = request.getMemberId().stream()
                .map(member -> {
                    return memberRepository.findById(member).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
                }).collect(Collectors.toList());

        List<ReviewMember> reviewMemberList = ReviewMemberConverter.toReviewMemberList(memberList);
        reviewMemberList.forEach(reviewMember -> {reviewMember.setReview(newReview);});

        List<Store> storeList = request.getStoreId().stream()
                .map(store -> {
                    return storeRepository.findById(store).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
                }).collect(Collectors.toList());

        List<ReviewStore> reviewStoreList = ReviewStoreConverter.toReviewStoreList(storeList);
        reviewStoreList.forEach(reviewStore -> {reviewStore.setReview(newReview);});

        return reviewRepository.save(newReview);
    }
}
