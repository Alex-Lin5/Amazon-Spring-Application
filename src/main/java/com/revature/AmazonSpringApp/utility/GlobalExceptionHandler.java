package com.revature.AmazonSpringApp.utility;

import com.revature.AmazonSpringApp.exceptions.AuthenticationException;
import com.revature.AmazonSpringApp.exceptions.ProfileException;
import org.apache.catalina.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(Globals.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest req){
        logger.error("Exception occurred: {}, Request details: {}.", e.getMessage(), req.getDescription(false), e);
        return new ResponseEntity<>("Exception occurred, ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ae, WebRequest req){
        logger.error("Authentication exception: {}, Request details: {}.", ae.getMessage(), req.getDescription(false), ae);
        return new ResponseEntity<>("Unauthorized operation, ", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ProfileException.class)
    public ResponseEntity<Object> handleProfileException(ProfileException pe, WebRequest req){
        logger.error("Profile exception: {}, Request details: {}.", pe.getMessage(), req.getDescription(false), pe);
        return new ResponseEntity<>("Profile operation fails, ", HttpStatus.BAD_REQUEST);
    }

}
