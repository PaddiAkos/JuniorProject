package hu.demo.junior.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

        ErrorMessage errorMessage = ErrorMessage.builder()
                .errorMassage(ex.getMessage())
                .errorDate(Instant.now())
                .httpStatus(HTTP_STATUS.getReasonPhrase())
                .contextPath(request.getContextPath())
                .build();


        return ResponseEntity.status(HTTP_STATUS).body(errorMessage);
    }

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ErrorMessage> handleCommonException(EntityNotFoundException ex, WebRequest request) {
        final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorMessage errorMessage = ErrorMessage.builder()
                .errorMassage(ex.getMessage())
                .errorDate(Instant.now())
                .httpStatus(HTTP_STATUS.getReasonPhrase())
                .contextPath(request.getContextPath())
                .build();


        return ResponseEntity.status(HTTP_STATUS).body(errorMessage);
    }

}
