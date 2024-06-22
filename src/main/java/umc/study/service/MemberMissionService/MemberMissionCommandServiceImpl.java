package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStore;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionStoreRepository;
import umc.study.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionStoreRepository missionStoreRepository;

    @Override
    @Transactional
    public MemberMission createMemberMission(MemberMissionRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        MissionStore missionStore = missionStoreRepository.findById(request.getMissionStoreId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = new MemberMission(member, missionStore);

        return memberMissionRepository.save(memberMission);
    }
}
