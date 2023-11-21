package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {

    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission){
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionDto request){

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .missionStoreList(new ArrayList<>())
                .build();
    }
}
