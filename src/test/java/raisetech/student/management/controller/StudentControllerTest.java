package raisetech.student.management.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMVC;
import raisetech.student.management.service.StudentService;

@WebMvcTest(StudentController.class) //このタイミングでインスタンス生成される→@MockBean
class StudentControllerTest {

  @Autowired
  private MockMVC mockMvc;

  @MockitoBean
  private StudentService service;

  @Test
  void 受講生詳細の一覧検索が実行できて空のリストが返ってくること() {

  }
}
