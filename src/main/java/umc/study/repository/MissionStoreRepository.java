package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MissionStore;

public interface MissionStoreRepository extends JpaRepository<MissionStore, Long> {
}
