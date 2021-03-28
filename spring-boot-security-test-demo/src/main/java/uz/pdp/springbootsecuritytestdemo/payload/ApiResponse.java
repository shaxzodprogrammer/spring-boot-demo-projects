package uz.pdp.springbootsecuritytestdemo.payload;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private boolean success;
    private Long totalElements;
    private Integer totalPages;
    private Object object;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public ApiResponse() {
    }

    public ApiResponse(String message, boolean success, Long totalElements, Integer totalPages, Object object) {
        this.message = message;
        this.success = success;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.object = object;
    }
}
