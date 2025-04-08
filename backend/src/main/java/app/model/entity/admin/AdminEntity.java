package app.model.entity.admin;

import app.model.dto.request.admin.AdminDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder@ToString
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminno; // 관리자번호
    @Column(columnDefinition = "varchar(255)" , nullable = false)
    private String adminname; // 관리자아이디
    @Column(columnDefinition = "varchar(255)" , nullable = false)
    private String adminpassword; // 관리자비밀번호
    @Column(columnDefinition = "varchar(255)" , nullable = false)
    private String role; // 시큐리티를 위한 역할

    // 빌더
    public AdminDto toADto(){
        return AdminDto.builder()
                .adminno(this.adminno)
                .adminname(this.adminname)
                .role(this.role)
                .build();
    }
}
