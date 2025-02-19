package raisetech.student.management.data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
