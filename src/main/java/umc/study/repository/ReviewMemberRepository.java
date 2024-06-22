package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.ReviewMember;

public interface ReviewMemberRepository extends JpaRepository<ReviewMember, Long> {
}
