package com.example.schedulerproject.dto;

import com.example.schedulerproject.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

// 일정 응답 시 사용하는 정보
@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.userName = schedule.getUserName();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}