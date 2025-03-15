package raisetech.student.management.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import java.util.Map;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Schema(description = "エラーメッセージ")
public class ErrorResponse {

  @Schema(description = "ステータスコード")
  private String status;

  @Schema(description = "エラー")
  private String error;

  @Schema(description = "メッセージ")
  private String message;

  @Schema(description = "エンドポイントのパス")
  private String path;

  @Schema(description = "送信日時")
  private String timeStamp;

  public ErrorResponse(String status, String error, String message, String path) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
    this.timeStamp = ZonedDateTime.now().toString();
  }

  public ResponseEntity<Object> returnResponse(HttpStatus status) {
    Map<String, String> body = Map.of(
        "timestamp", getTimeStamp(),
        "status", getStatus(),
        "error", getError(),
        "message", getMessage(),
        "path", getPath());

    return ResponseEntity.status(status).body(body);
  }
}
