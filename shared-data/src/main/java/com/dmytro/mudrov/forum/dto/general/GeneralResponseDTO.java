package com.dmytro.mudrov.forum.dto.general;

public class GeneralResponseDTO extends BaseResponseDTO {

    private boolean success;
    private String error;

    public GeneralResponseDTO() {
    }

    public GeneralResponseDTO(boolean success) {
        this.success = success;
    }

    public GeneralResponseDTO(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "GeneralResponseDTO{" +
               "success=" + success +
               ", error='" + error + '\'' +
               '}';
    }
}
