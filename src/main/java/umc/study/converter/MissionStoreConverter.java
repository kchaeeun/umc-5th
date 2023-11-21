package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MissionStore;
import umc.study.domain.mapping.ReviewMember;

import java.util.List;
import java.util.stream.Collectors;

public class MissionStoreConverter {

    public static List<MissionStore> toMissionStoreList(List<Store> storeList){

        return storeList.stream()
                .map(store ->
                        MissionStore.builder()
                                .store(store)
                                .build()
                ).collect(Collectors.toList());
    }
}
