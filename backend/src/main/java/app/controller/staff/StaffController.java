package app.controller.staff;

import app.model.dto.internal.staff.StaffInternalDto;
import app.model.entity.staff.StaffEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    @Operation(summary = "기사 등록", description = "새로운 기사를 등록합니다 (Internal DTO 테스트용)")
    @PostMapping
    public ResponseEntity<String> registerStaff() {
        StaffEntity dummy = StaffEntity.builder()
                .staffno(1)
                .staffname("김청소")
                .staffphone("010-1234-5678")
                .staffaddress("서울특별시")
                .staffprofile("kim.jpg")
                .staffsalary(70)
                .staffsalarydate("월요일")
                .stafffixedholiday("수요일")
                .build();

        StaffInternalDto dto = dummy.toDto();
        System.out.println("✅ [등록] DTO 변환 결과: " + dto.getStaffname() + " / " + dto.getStaffphone());

        return ResponseEntity.ok("등록 테스트 완료");
    }

    @Operation(summary = "기사 전체 조회", description = "모든 기사를 조회합니다")
    @GetMapping
    public ResponseEntity<String> getAllStaff() {
        System.out.println("✅ [전체 조회] 호출됨");
        return ResponseEntity.ok("전체 조회 테스트 완료");
    }

    @Operation(summary = "기사 상세 조회", description = "특정 기사의 정보를 조회합니다")
    @GetMapping("/{staffno}")
    public ResponseEntity<String> getStaff(
            @Parameter(description = "기사 번호") @PathVariable int staffno) {

        StaffEntity dummy = StaffEntity.builder()
                .staffno(staffno)
                .staffname("박청소")
                .staffphone("010-9876-5432")
                .staffaddress("인천광역시")
                .staffprofile("park.png")
                .staffsalary(60)
                .staffsalarydate("금요일")
                .stafffixedholiday("화요일")
                .build();

        StaffInternalDto dto = dummy.toDto();
        System.out.println("✅ [상세 조회] " + staffno + "번 기사 → " + dto.getStaffname());

        return ResponseEntity.ok("상세 조회 테스트 완료");
    }

    @Operation(summary = "기사 수정", description = "기사 정보를 수정합니다")
    @PutMapping("/{staffno}")
    public ResponseEntity<String> updateStaff(@PathVariable int staffno) {
        System.out.println("✅ [수정] staffno = " + staffno);
        return ResponseEntity.ok("수정 테스트 완료");
    }

    @Operation(summary = "기사 삭제", description = "기사를 삭제합니다")
    @DeleteMapping("/{staffno}")
    public ResponseEntity<String> deleteStaff(@PathVariable int staffno) {
        System.out.println("✅ [삭제] staffno = " + staffno);
        return ResponseEntity.ok("삭제 테스트 완료");
    }
}
