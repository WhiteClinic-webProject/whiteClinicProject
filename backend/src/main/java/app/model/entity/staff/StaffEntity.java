package app.model.entity.staff;

import app.model.dto.internal.staff.StaffInternalDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staff")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffno; //넘버

    @Column(nullable = false, length = 30)
    private String staffname; //이름

    @Column(nullable = false, length = 20, unique = true)
    private String staffphone; //폰넘버

    @Column(nullable = false, length = 10)
    private String staffaddress;

    @Column(nullable = false, length = 255)
    private String staffprofile; //프로필사진

    @Column(nullable = false)
    private int staffsalary; //급여

    @Column(nullable = false, length = 20)
    private String staffsalarydate; //급여지급일

    @Column(nullable = false, length = 20)
    private String stafffixedholiday; //정기휴무일

    //연가는 다른 테이블로 뻄

    public StaffInternalDto toDto(){
        return StaffInternalDto.builder()
                .staffno(staffno)
                .staffname(staffname)
                .staffphone(staffphone)
                .staffaddress(staffaddress)
                .staffprofile(staffprofile)
                .staffsalary(staffsalary)
                .staffsalarydate(staffsalarydate)
                .stafffixedholiday(stafffixedholiday)
                .build();
    }
}
