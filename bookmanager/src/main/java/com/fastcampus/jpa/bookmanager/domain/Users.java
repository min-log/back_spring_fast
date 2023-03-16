package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity // pk가 반드시 필요.
public class Users {

    @Id //pk
    @GeneratedValue //자동으로 증가
    private Long id;

    @NonNull //필수 값이 된다.
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
