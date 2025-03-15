package raisetech.student.management.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Schema(description = "IDが存在しない場合のエラー処理")
@RestControllerAdvice
public class MemberNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

  @Schema(description = "エラーメッセージ")
  @ExceptionHandler
  public ResponseEntity<Object> MemberNotFoundException(
      MemberNotFoundException ex, HttpServletRequest request) {
    
    HttpStatus status = HttpStatus.NOT_FOUND;
    String error = HttpStatus.NOT_FOUND.getReasonPhrase();
    String message = "member not found";
    String pass = request.getRequestURI();

    ErrorResponse errorResponse = new ErrorResponse(String.valueOf(status.value()), error, message,
        pass);
    return errorResponse.returnResponse(status);
  }
}
