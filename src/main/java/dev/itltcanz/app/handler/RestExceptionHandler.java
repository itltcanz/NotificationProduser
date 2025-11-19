package dev.itltcanz.app.handler;

import static dev.itltcanz.app.constant.ErrorMessageConstant.BAD_REQUEST;
import static dev.itltcanz.app.constant.ErrorMessageConstant.INTERNAL_SERVER_ERROR;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import dev.itltcanz.app.exception.ParsingException;
import dev.itltcanz.app.model.response.HttpErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

  @ExceptionHandler({
      JsonProcessingException.class,
      JsonMappingException.class,
      HttpMessageNotReadableException.class,
      MethodArgumentNotValidException.class,
      ParsingException.class,
      ConstraintViolationException.class
  })
  public ResponseEntity<HttpErrorResponse> handleParsingExceptions(Exception e) {
    log.error(e.getMessage());
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new HttpErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            BAD_REQUEST
        ));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<HttpErrorResponse> handleException(Exception e) {
    log.error(e.getMessage());
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new HttpErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            INTERNAL_SERVER_ERROR
        ));
  }

}
