package co.com.pragma.model.config;

import lombok.Getter;

@Getter
public class PragmaException extends RuntimeException {

    private final ErrorCode error;

    public PragmaException(ErrorCode errorCode) {
        super(errorCode.getLog());
        this.error = errorCode;
    }

}
