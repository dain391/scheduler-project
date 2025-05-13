package com.example.schedulerproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 일정을 생성할 때 받는 요청 정보
@Getter
@NoArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String userName;
    private String password;
}