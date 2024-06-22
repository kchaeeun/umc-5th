package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.ReviewStore;

public interface ReviewStoreRepository extends JpaRepository<ReviewStore, Long> {
}
