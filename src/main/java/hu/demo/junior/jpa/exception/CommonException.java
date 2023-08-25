package hu.demo.junior.jpa.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonException extends RuntimeException {

    public CommonException (String message, boolean toLog){
        super(message);
        if(toLog){
            log.error(message);
    }
        }
    }
