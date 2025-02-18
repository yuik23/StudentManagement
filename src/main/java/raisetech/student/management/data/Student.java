package raisetech.student.management.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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

  @Email
  private String email;

  private String area;

  private int age;

  private String sex;

  private String remark;

  private boolean isDeleted;

}
