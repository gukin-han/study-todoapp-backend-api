package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class UserEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String username; // 아이디로 사용할 username. 이메일일 수도 그냥 문자열일 수도 있다.

    private String password; // 패스워드.

    private String role; // 사용자의 롤, 예: 어드민, 일반사용자

    private String authProvider; // 이후 OAuth에서 사용할 유저 정보 제공자: github
}
