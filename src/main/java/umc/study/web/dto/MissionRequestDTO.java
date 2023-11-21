package umc.study.web.dto;

import lombok.Getter;

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
}
