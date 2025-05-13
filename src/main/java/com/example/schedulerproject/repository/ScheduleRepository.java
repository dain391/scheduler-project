package com.example.schedulerproject.repository;

import com.example.schedulerproject.entity.Schedule;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder; // 추가
import org.springframework.jdbc.support.KeyHolder;         // 추가
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 저장
    public Long save(Schedule schedule) {
        String sql = "INSERT INTO schedule (title, user_name, password, created_at, modified_at) " +
                "VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, schedule.getTitle());
            ps.setString(2, schedule.getUserName());
            ps.setString(3, schedule.getPassword());
            ps.setObject(4, schedule.getCreatedAt());
            ps.setObject(5, schedule.getModifiedAt());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            return key.longValue();
        } else {
            throw new RuntimeException("ID 생성 실패");
        }
    }

    // 전체 일정 조회
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedule ORDER BY modified_at DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class));
    }

    // 단건 조회
    public Optional<Schedule> findById(Long id) {
        String sql = "SELECT * FROM schedule WHERE id = ?";
        List<Schedule> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class), id);
        return result.stream().findFirst();
    }
}