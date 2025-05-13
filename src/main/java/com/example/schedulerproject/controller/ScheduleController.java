package com.example.schedulerproject.controller;

import com.example.schedulerproject.dto.ScheduleRequestDto;
import com.example.schedulerproject.dto.ScheduleResponseDto;
import com.example.schedulerproject.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules") // 모든 메서드는 /schedules -> 기본경로
@RequiredArgsConstructor
class ScheduleController {
    private final ScheduleService scheduleService; // 컨트롤러가 사용할 서비스 객체
    // 생성자 자동 생성됨

    @PostMapping
    // 일정 생성
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto createdSchedule = scheduleService.createSchedule(requestDto); // 일정을 생성하고, 결과 저장
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED); // 일정 정보를 상태코드와 함께 클라이언트에 응답 반환
    }

    // 전체 일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    // 단건 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }
}
