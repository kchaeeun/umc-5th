package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberMissionRequestDTO {
    @NotNull
    private Long memberId;

    @NotNull
    private Long missionStoreId;

}
