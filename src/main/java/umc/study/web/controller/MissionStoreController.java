package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionStoreConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStore;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MissionStoreService.MissionStoreCommandService;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.MissionStoreRequestDTO;
import umc.study.web.dto.MissionStoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission-store")
public class MissionStoreController {
    private final MissionStoreCommandService missionStoreCommandService;

    @PostMapping
    public ApiResponse<MissionStoreResponseDTO> missionToStore(@RequestBody MissionStoreRequestDTO request) {
        MissionStore missionStore = missionStoreCommandService.createMissionStore(request);
        return ApiResponse.onSuccess(MissionStoreConverter.toResponseDTO(missionStore));
    }
}
