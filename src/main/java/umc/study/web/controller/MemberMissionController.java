package umc.study.web.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping
    public ApiResponse<MemberMissionResponseDTO> missionPlus(@RequestBody MemberMissionRequestDTO request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toResponseDTO(memberMission));
    }
}
