package umc.study.service.MissionStoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MissionStore;
import umc.study.repository.MissionRepository;
import umc.study.repository.MissionStoreRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionStoreRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionStoreCommandServiceImpl implements MissionStoreCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    private final MissionStoreRepository missionStoreRepository;

    @Transactional
    public MissionStore createMissionStore(MissionStoreRequestDTO request) {
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        MissionStore missionStore = new MissionStore(mission, store);

        return missionStoreRepository.save(missionStore);
    }
}
