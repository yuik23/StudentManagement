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

  @Min(1)
  private int id;

  @Min(1)
  private int studentId;

  @NotBlank
  private String courseName;

  private LocalDateTime courseStartAt;

  private LocalDateTime courseEndAt;
}
