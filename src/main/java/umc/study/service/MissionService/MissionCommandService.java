package umc.study.service.MissionService;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission mission(MissionRequestDTO.MissionDto request);

    // PUT - missionId 사용
    Mission updateMissionStatus(Long missionId, MissionRequestDTO.MissionStatusDto request);
}
