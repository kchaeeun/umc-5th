package umc.study.service.MissionStoreService;

import umc.study.domain.mapping.MissionStore;
import umc.study.web.dto.MissionStoreRequestDTO;

public interface MissionStoreCommandService {

    MissionStore createMissionStore(MissionStoreRequestDTO request);
}
