package com.example.schedulerproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// 일정 정보를 담는 엔티티 클래스
@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long id;           // 기본 키
    private String title;      // 할 일
    private String userName;   // 작성자 이름
    private String password;   // 비밀번호
    private LocalDateTime createdAt;  // 생성자
    private LocalDateTime modifiedAt; // 수정일
}



