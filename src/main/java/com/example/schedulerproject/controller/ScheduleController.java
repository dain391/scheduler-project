package com.example.schedulerproject.controller;

import com.example.schedulerproject.dto.ScheduleRequestDto;
import com.example.schedulerproject.dto.ScheduleResponseDto;
import com.example.schedulerproject.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules") // 모든 메서드는 /schedules -> 기본경로
@RequiredArgsConstructor
class ScheduleController {
    private final ScheduleService scheduleService; // 컨트롤러가 사용할 서비스 객체
    // 생성자 자동 생성됨

    @PostMapping
    // 클라이언트로부터 ScheduleDto 받아서 처리
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto createdSchedule = scheduleService.createSchedule(scheduleDto); // 일정을 생성하고, 결과 저장
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED); // 일정 정보를 상태코드와 함께 클라이언트에 응답 반환
    }
}
