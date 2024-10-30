package com.folau.springboot.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public Object handleError(HttpServletRequest request, WebRequest webRequest, Model model) {
        String uri = request.getRequestURI().toString();
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String originalUri = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);

        log.info("ErrorController: uri={}, statusCode={}, originalUri:{}", uri, statusCode, originalUri);

        if (originalUri != null && originalUri.contains("/api")) {
            // Return a JSON response for API calls
            return new ResponseEntity<>(
                    new ErrorResponse("Resource not found", 200),
                    HttpStatus.OK);
        } else {
            // Redirect to the index.html for non-API URLs
            //return "redirect:/index.html";  // Ensure your index.html is in /static or /templates
            return "forward:/index.html";
        }
    }

    // Custom error response class for JSON response
    public static class ErrorResponse {
        private String message;
        private int statusCode;

        public ErrorResponse(String message, int statusCode) {
            this.message = message;
            this.statusCode = statusCode;
        }

        // Getters and setters...
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }
}

