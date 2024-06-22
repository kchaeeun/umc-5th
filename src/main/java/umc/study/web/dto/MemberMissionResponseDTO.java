package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberMissionResponseDTO {
    private Long id;
    private Long memberId;
    private Long missionStoreId;
}
