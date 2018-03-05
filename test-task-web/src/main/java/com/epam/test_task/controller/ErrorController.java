package com.epam.test_task.controller;

import com.epam.test_task.service.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static com.epam.test_task.controller.util.PageConstant.ERROR_PAGE;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(ServiceException.class)
    public ModelAndView error() {
        return new ModelAndView(ERROR_PAGE);
    }
}