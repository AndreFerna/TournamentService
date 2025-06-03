package co.com.pragma.model.config;

import lombok.Getter;

@Getter
public enum ErrorCode {
    B401000("B401-000", "Unauthorized", 401),
    B400001("B400-001", "Bad Request-fields bad format", 400),
    B409000("B409-000", "No Organizer Found", 409),
    B409001("B409-001", "No Category Found", 409),
    B409003("B409-003", "You have already created two free tournaments", 409),
    B409004("B409-004", "You have already created a free view.", 409),
    B409005("B409-005", "The tournament was not created", 409),
    B409006("B409-006", "No Tournament Found", 409),
    B409007("B409-007", "No User Found", 409),
    B409008("B409-008", "No View Found", 409),
    B409009("B409-009", "Unsaved tournament", 409),
    B409010("B409-010", "platform does not exist", 409),
    B409011("B409-011", "Video game does not exist", 409),
    ;

    private final String code;
    private final String log;
    private final int status;

    ErrorCode(String code, String log, int status) {
        this.code = code;
        this.log = log;
        this.status = status;
    }
}
