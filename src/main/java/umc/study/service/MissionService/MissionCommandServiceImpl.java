package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreferConverter;
import umc.study.converter.MissionConverter;
import umc.study.converter.MissionStoreConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.domain.mapping.MissionStore;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MissionRequestDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional          // 반드시 public 메서드에서 적용, 해당 클래스에 속하는 메서드에 공통적으로 적용된다.
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;    // 음식 카테고리

    @Override
    @Transactional
    public Mission mission(MissionRequestDTO.MissionDto request) {

        Mission newMission = MissionConverter.toMission(request);
        List<Store> storeList = request.getStoreId().stream()
                .map(store -> {
                    return storeRepository.findById(store).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MissionStore> missionStoreList = MissionStoreConverter.toMissionStoreList(storeList);

        missionStoreList.forEach(missionStore -> {missionStore.setMission(newMission);});

        return missionRepository.save(newMission);
    }

    @Override
    public Mission updateMissionStatus(Long missionId, MissionRequestDTO.MissionStatusDto request) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // converter에서 하는 걸 바로 실행함
        mission.setStatus(request.getStatus());

        // 미션 상태에 따른 추가 로직이 있다면 여기에 추가할 수 있습니다.
        return missionRepository.save(mission);
    }
}
