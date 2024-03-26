package com.yash.actormovie.exception;

import com.yash.actormovie.domain.ResultStatus;
import com.yash.actormovie.domain.ResultStatusResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class ExceptionControllerAdvice.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    public ExceptionControllerAdvice() {
        super();
    }

    /**
     * Handle exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ResultStatus status = new ResultStatus();
        status.setStatus("FAILED");
        status.setErrorCode("Technical Difficulty!");
        status.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(new ResultStatusResponse(status), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle rest exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ActorMoviePortalException.class)
    public ResponseEntity<Object> handleRestException(ActorMoviePortalException ex) {
        ResultStatus status = new ResultStatus();
        status.setStatus("FAILED");
        status.setErrorCode(Integer.toString(ex.getHttpStatus().value()));
        status.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(new ResultStatusResponse(status), ex.getHttpStatus());
    }

}
