package raisetech.student.management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.exception.MemberNotFoundException;
import raisetech.student.management.service.StudentService;

/**
 * 受講生の検索や登録、更新などを行うREST APIとして実行されるControllerです
 */
@Validated
@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  /**
   * 受講生詳細一覧検索 全件検索を行うので、条件指定は行いません
   *
   * @return 受講生一覧(全件)
   */
  @Operation(
      summary = "受講生詳細一覧検索",
      description = "受講生詳細の一覧を検索します。全件検索を行うので、条件指定は行いません。",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "受講生詳細を全件取得",
              content = @Content(mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = StudentDetail.class))
              )
          )
      }
  )
  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    return service.searchStudentList();
  }

  /**
   * 受講生詳細検索 IDに紐づく任意の受講生の情報を取得します
   *
   * @param id 受講生ID
   * @return 受講生
   */
  @Operation(
      summary = "受講生詳細検索",
      description = "IDに紐づく任意の受講生の情報を検索します。",
      responses = {
          @ApiResponse(
              responseCode = "200", description = "ok",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = StudentDetail.class)
              )
          ),
          @ApiResponse(
              responseCode = "400", description = "バリデーションエラー",
              content = @Content(
                  mediaType = "application/json",
                  examples = {
                      @ExampleObject(value = "{"
                          + "\"message\": \"validation error , getStudent.id: 1 以上の値にしてください\","
                          + "\"timestamp\": \"2025-03-13T04:50:43.191465600+09:00[GMT+09:00]\","
                          + "\"error\": \"Bad Request\","
                          + "\"path\": \"/student/0\","
                          + "\"status\": \"400\""
                          + "}")}
              )
          ),
          @ApiResponse(
              responseCode = "404", description = "IDが存在しない場合のエラー",
              content = @Content(
                  mediaType = "application/json",
                  examples = {
                      @ExampleObject(value = "{"
                          + "\"message\": \"member not found\","
                          + "\"timestamp\": \"2025-03-15T17:03:39.375104800+09:00[GMT+09:00]\","
                          + "\"error\": \"Not Found\","
                          + "\"path\": \"/student/105\","
                          + "\"status\": \"404\""
                          + "}")}
              )
          )
      }
  )
  @GetMapping("/student/{id}")
  public StudentDetail getStudent(
      @PathVariable @Min(value = 1) int id) throws MemberNotFoundException {
    return service.searchStudent(id);
  }

  /**
   * 受講生詳細登録
   *
   * @param studentDetail 受講生詳細
   * @return 実行結果
   */
  @Operation(summary = "受講生詳細登録", description = "受講生を登録します。")
  @PostMapping("/registerStudent")
  public ResponseEntity<StudentDetail> registerStudent(
      @RequestBody @Valid StudentDetail studentDetail) {
    StudentDetail responseStudentDetail = service.registerStudent(studentDetail);
    return ResponseEntity.ok(responseStudentDetail);
  }

  /**
   * 受講生詳細更新 キャンセルフラグの更新もここで行います（論理削除）
   *
   * @param studentDetail 受講生詳細
   * @return 実行結果
   */
  @Operation(
      summary = "受講生詳細更新",
      description = "受講生詳細を更新します。",
      responses = {
          @ApiResponse(
              responseCode = "200", description = "ok",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = StudentDetail.class),
                  examples = {
                      @ExampleObject(value = "更新処理が成功しました。"
                      )
                  }
              )
          )
      }
  )
  @PutMapping("/updateStudent")
  public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentDetail studentDetail) {
    service.updateStudent(studentDetail);
    return ResponseEntity.ok("更新処理が成功しました。");
  }
}
