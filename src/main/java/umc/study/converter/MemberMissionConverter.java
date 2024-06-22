package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO toResponseDTO(MemberMission memberMission) {
        MemberMissionResponseDTO dto = new MemberMissionResponseDTO();
        dto.setId(memberMission.getId());
        dto.setMemberId(memberMission.getMember().getId());
        dto.setMissionStoreId(memberMission.getMissionStore().getId());
        return dto;
    }
}
