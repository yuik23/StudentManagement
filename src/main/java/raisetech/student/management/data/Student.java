package raisetech.student.management.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "受講生情報")
@Getter
@Setter
public class Student {

  @Min(1)
  private int id;

  @NotBlank
  private String name;

  @NotBlank
  private String kanaName;

  private String nickname;

  @NotBlank
  @Email
  private String email;

  private String area;

  private int age;

  private String sex;

  private String remark;

  private boolean isDeleted;

}
