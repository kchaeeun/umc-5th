package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MissionStoreRequestDTO {
    @NotNull
    private Long missionId;
    @NotNull
    private Long storeId;
}
