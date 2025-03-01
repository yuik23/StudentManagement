package raisetech.student.management.repository;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourse;

/**
 * 受講生テーブルと受講生コース情報テーブルとが紐づくRepositoryです
 */
@Mapper
public interface StudentRepository {

  /**
   * 受講生の全件検索
   *
   * @return 受講生一覧(全件)
   */
  List<Student> search();

  /**
   * 受講生検索
   *
   * @param id 受講生ID
   * @return 受講生
   */
  Optional<Student> searchStudent(int id);

  /**
   * 受講生のコース情報の全件検索
   *
   * @return 受講生のコース情報(全件)
   */
  List<StudentCourse> searchStudentCourseList();

  /**
   * 受講生IDに紐づく受講生コース情報を検索
   *
   * @param studentId 受講生ID
   * @return 受講生IDに紐づく受講生コース情報
   */
  List<StudentCourse> searchStudentCourse(int studentId);

  /**
   * 受講生新規登録 IDに関しては自動採番を行う
   *
   * @param student 受講生
   */
  void registerStudent(Student student);

  /**
   * 受講生コース情報新規登録 IDに関しては自動採番を行う
   *
   * @param studentCourse 受講生コース情報
   */
  void registerStudentCourse(StudentCourse studentCourse);

  /**
   * 受講生更新
   *
   * @param student 受講生
   */
  void updateStudent(Student student);

  /**
   * 受講生コース情報のコース名更新
   *
   * @param studentCourse 受講生コース情報
   */
  void updateStudentCourse(StudentCourse studentCourse);
}
