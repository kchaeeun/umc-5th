package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.enums.MissionStatus;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class MissionDto{
        Integer reward;
        LocalDate deadline;
        String missionSpec;
        List<Long> storeId;

    }

    // POST와 분리해서 사용
    @Getter
    public static class MissionStatusDto {
        MissionStatus status;
    }
}
