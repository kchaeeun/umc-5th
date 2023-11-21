package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")                                                 // @Valid 떄문에 @ExistCategories 예외가 바로 전달X
    public ApiResponse<MissionResponseDTO.MissionResultDTO> mission(@RequestBody @Valid MissionRequestDTO.MissionDto request){
        Mission mission = missionCommandService.mission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }

    @PutMapping("/{missionId}/status")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> updateMissionStatus(
            @PathVariable Long missionId,
            @RequestBody @Valid MissionRequestDTO.MissionStatusDto request) {
        Mission mission = missionCommandService.updateMissionStatus(missionId, request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }
}