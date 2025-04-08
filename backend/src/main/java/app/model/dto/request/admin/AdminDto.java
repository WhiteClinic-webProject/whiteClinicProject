package app.model.dto.request.admin;

import app.model.entity.admin.AdminEntity;
import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder@ToString
public class AdminDto {
    private int adminno; // 관리자번호
    private String adminname; // 관리자아이디
    private String adminpassword; // 관리자비밀번호
    private String role; // 시큐리티를 위한 역할

    public AdminEntity toAEntity(){
        return AdminEntity.builder()
                .adminno(this.adminno)
                .adminname(this.adminname)
                .role(this.role)
                .build();
    }
}
