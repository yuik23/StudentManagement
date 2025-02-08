package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(int id);

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCoursesList();

  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentsCourses> searchStudentsCourses(int studentId);

  @Insert(
      "INSERT INTO students(name, kana_name, nickname, email, area, age, sex, remark, is_deleted)"
          + "VALUES(#{name}, #{kanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert(
      "INSERT INTO students_courses(student_id, course_name, course_start_at, course_end_at)"
          + "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentCourses(StudentsCourses studentsCourses);

  @Update(
      "UPDATE students SET name=#{name}, kana_name=#{kanaName}, nickname=#{nickname},"
          + "email=#{email}, area=#{area}, age=#{age}, sex=#{sex}, remark=#{remark}, is_deleted=#{isDeleted} WHERE id=#{id}")
  void updateStudent(Student student);

  @Update(
      "UPDATE students_courses SET course_name=#{courseName} WHERE id = #{id}")
  void updateStudentCourses(StudentsCourses studentsCourses);
}
