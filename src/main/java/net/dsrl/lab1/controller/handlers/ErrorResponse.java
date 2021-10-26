package net.dsrl.lab1.controller.handlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String details;
    private List<String> errors;

    ErrorResponse() {
        this.setTime();
    }

    public ErrorResponse(
            HttpStatus status, LocalDateTime timestamp, String details, List<String> errors) {
        this.status = status;
        this.timestamp = timestamp;
        this.details = details;
        this.errors = errors;
    }

    public ErrorResponse(List<String> errors) {
        this.errors = errors;
    }

    private void setTime() {
        this.timestamp = LocalDateTime.now();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
