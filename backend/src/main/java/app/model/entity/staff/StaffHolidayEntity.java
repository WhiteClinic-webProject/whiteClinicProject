package app.model.entity.staff;

import app.model.dto.internal.staff.StaffHolidayInternalDto;
import app.model.dto.internal.staff.StaffInternalDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "StaffHoliday")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffHolidayEntity {
    @Id
    @GeneratedValue
    private int staffholidayno; //연가 번호

    @Column(nullable = false)
    private LocalDate holidaydate; //연가 날짜

    @ManyToOne
    @JoinColumn(name = "staffno")
    private StaffEntity staffno; //기사 번호

    public StaffHolidayInternalDto toDto() {
        return StaffHolidayInternalDto.builder()
                .staffholidayno(staffholidayno)
                .holidaydate(holidaydate)
                .staffno(staffno.toDto())
                .build();
    }
}
