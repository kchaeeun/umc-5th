package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.domain.mapping.ReviewMember;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewMemberConverter {

    public static ReviewMember toReviewMember(Member member) {
        return ReviewMember.builder()
                .member(member)
                .build();
    }
//    public static List<ReviewMember> toReviewMemberList(List<Member> memberList){
//
//        return memberList.stream()
//                .map(member ->
//                       ReviewMember.builder()
//                                .member(member)
//                                .build()
//                ).collect(Collectors.toList());
//    }

}
