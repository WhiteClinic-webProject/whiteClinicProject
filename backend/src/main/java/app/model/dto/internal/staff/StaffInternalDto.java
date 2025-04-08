package app.model.dto.internal.staff;

import app.model.entity.staff.StaffEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffInternalDto {
    private int staffno; //넘버
    private String staffname; //이름
    private String staffphone; //폰넘버
    private String staffaddress; //주소
    private String staffprofile; //프로필사진
    private int staffsalary; //급여
    private String staffsalarydate; //급여지급일
    private String stafffixedholiday; //정기휴무일

    public StaffEntity toEntity() {
        return StaffEntity.builder()
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
