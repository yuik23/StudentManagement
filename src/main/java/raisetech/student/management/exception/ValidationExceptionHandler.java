package raisetech.student.management.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Schema(description = "バリデーションエラー処理")
@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<Object> handleConstraintViolationException(
      ConstraintViolationException ex, HttpServletRequest request) {

    HttpStatus status = HttpStatus.BAD_REQUEST;
    String error = HttpStatus.BAD_REQUEST.getReasonPhrase();
    String message = "validation error , " + ex.getMessage();
    String pass = request.getRequestURI();

    ErrorResponse errorResponse = new ErrorResponse(String.valueOf(status.value()), error, message,
        pass);
    return errorResponse.returnResponse(status);
  }
}
