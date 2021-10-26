package net.dsrl.lab1.controller.handlers;

import net.dsrl.lab1.controller.handlers.exception.ResourceNotFoundException;
import net.dsrl.lab1.controller.handlers.model.ExceptionHandlerResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * It will catch all exceptions of type Resource not found
   *
   * @param ex
   * @param request
   * @return
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({ResourceNotFoundException.class})
  public ResponseEntity<ErrorResponse> handleNotFoundRequest(Exception ex, WebRequest request) {

    return buildErrorResponse(ex, HttpStatus.NOT_FOUND, request.getDescription(false));
  }

  @ExceptionHandler(value = {ConstraintViolationException.class})
  public ResponseEntity<Object> handleConstraintViolationException(
      ConstraintViolationException e, WebRequest request) {
    HttpStatus status = HttpStatus.CONFLICT;
    Set<ConstraintViolation<?>> details = e.getConstraintViolations();
    ExceptionHandlerResponseDTO errorInformation =
        new ExceptionHandlerResponseDTO(
            e.getMessage(),
            status.getReasonPhrase(),
            status.value(),
            e.getMessage(),
            details,
            request.getDescription(false));
    return handleExceptionInternal(e, errorInformation, new HttpHeaders(), status, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    List<ObjectError> errs = ex.getBindingResult().getAllErrors();
    List<String> details = new ArrayList<>();
    for (ObjectError err : errs) {
      String fieldName = ((FieldError) err).getField();
      String errorMessage = err.getDefaultMessage();
      details.add(fieldName + ":" + errorMessage);
    }
    ExceptionHandlerResponseDTO errorInformation =
        new ExceptionHandlerResponseDTO(
            ex.getParameter().getParameterName(),
            status.getReasonPhrase(),
            status.value(),
            MethodArgumentNotValidException.class.getSimpleName(),
            details,
            request.getDescription(false));
    return handleExceptionInternal(ex, errorInformation, new HttpHeaders(), status, request);
  }
  /**
   * Creates error response payload and returns a response entity instance containing it
   *
   * @param exception
   * @param status
   * @param details
   * @return
   */
  private ResponseEntity<ErrorResponse> buildErrorResponse(
      Exception exception, HttpStatus status, String details) {
    ErrorResponse errorResponse =
        new ErrorResponse(status, LocalDateTime.now(), details, List.of(exception.getMessage()));
    return new ResponseEntity<>(errorResponse, new HttpHeaders(), status);
  }
}
