package com.example.demo;

import com.example.demo.vo.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return "topop";
    }

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ResponseEntity defaultErrorHandler(HttpServletRequest req, GlobalException e) throws Exception {
        return ResponseEntity.ok("ok");
    }


}
