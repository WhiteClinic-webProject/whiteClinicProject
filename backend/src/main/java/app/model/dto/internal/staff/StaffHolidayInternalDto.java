package app.model.dto.internal.staff;


import app.model.entity.staff.StaffHolidayEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffHolidayInternalDto {

    private int staffholidayno;
    private LocalDate holidaydate;
    private StaffInternalDto staffno;

    public StaffHolidayEntity toEntity() {
        return StaffHolidayEntity.builder()
                .staffholidayno(staffholidayno)
                .holidaydate(holidaydate)
                .staffno(staffno.toEntity())
                .build();
    }
}

