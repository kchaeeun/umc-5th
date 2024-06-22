package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStore;
import umc.study.domain.mapping.ReviewMember;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.MissionStoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionStoreConverter {

    public static MissionStoreResponseDTO toResponseDTO(MissionStore missionStore) {
        MissionStoreResponseDTO dto = new MissionStoreResponseDTO();
        dto.setId(missionStore.getId());
        dto.setMissionId(missionStore.getMission().getId());
        dto.setStoreId(missionStore.getStore().getId());
        return dto;
    }

    public static List<MissionStore> toMissionStoreList(List<Store> storeList){

        return storeList.stream()
                .map(store ->
                        MissionStore.builder()
                                .store(store)
                                .build()
                ).collect(Collectors.toList());
    }
}
