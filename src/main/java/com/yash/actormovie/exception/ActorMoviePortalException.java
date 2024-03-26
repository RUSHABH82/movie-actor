package com.yash.actormovie.exception;

import org.springframework.http.HttpStatus;

public class ActorMoviePortalException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String message;
    private final HttpStatus httpStatus;


    /**
     * @param message
     */
    public ActorMoviePortalException(String message) {
        super(message);
        this.message = message;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ActorMoviePortalException(String messg, HttpStatus httpStatus) {
        super(messg);
        this.httpStatus = httpStatus;
        this.message = messg;
    }

    public ActorMoviePortalException(String msg, Throwable cause) {
        super(msg, cause);
        this.message = msg;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    }

    public ActorMoviePortalException(Throwable cause) {
        super(cause);
        this.message = "";
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
