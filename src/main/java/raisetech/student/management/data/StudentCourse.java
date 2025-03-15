package raisetech.student.management.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "受講生コース情報")
@Getter
@Setter
public class StudentCourse {

  @Schema(description = "受講生コースID。自動連番で付与", example = "2")
  @Min(1)
  private int id;

  @Schema(description = "受講生ID(外部キー)", example = "1")
  @Min(1)
  private int studentId;

  @Schema(description = "受講コース名", example = "Javaフルコース")
  @NotBlank
  private String courseName;

  @Schema(description = "受講開始日", example = "2025-01-30 00:00:00")
  private LocalDateTime courseStartAt;

  @Schema(description = "受講修了予定日", example = "2026-01-29 00:00:00")
  private LocalDateTime courseEndAt;
}
