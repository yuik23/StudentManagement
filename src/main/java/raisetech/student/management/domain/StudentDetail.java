package raisetech.student.management.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

@Setter
@Getter
public class StudentDetail {

  private Student student;
  private List<StudentsCourses> studentsCourses;
}
