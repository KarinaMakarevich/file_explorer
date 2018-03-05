package com.epam.test_task.controller;

import com.epam.test_task.dao.UserDAO;
import com.epam.test_task.model.User;
import com.epam.test_task.model.util.Role;
import com.epam.test_task.service.UserService;
import com.epam.test_task.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.epam.test_task.controller.util.PageConstant.*;

@Controller
public class CommonController {
    private static final Logger LOGGER = LogManager.getLogger(CommonController.class);
    private static final String OPEN_MAIN_PAGE = "/openMainPage";
    private static final String OPEN_LOGIN_PAGE = "/openLoginPage";
    private static final String OPEN_ERROR_PAGE = "/openErrorPage";
    private static final String OPEN_REGISTRATION_PAGE = "/openRegistrationPage";

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping(value = OPEN_MAIN_PAGE, method = RequestMethod.GET)
    public String openMainPage() throws ServiceException {
        LOGGER.log(Level.INFO, "Main page is opening");
        return MAIN_PAGE;
    }

    @RequestMapping(value = OPEN_LOGIN_PAGE, method = RequestMethod.GET)
    public String openLoginPage() throws ServiceException {
        LOGGER.log(Level.INFO, "Login page is opening");
        return LOGIN_PAGE;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        LOGGER.log(Level.INFO, "Index page is opening");
        return VIEW_INDEX;
    }

    @RequestMapping(value = OPEN_ERROR_PAGE, method = RequestMethod.GET)
    public String openErrorPage() {
        LOGGER.log(Level.INFO, "Error page is opening");
        return ERROR_PAGE;
    }

    @RequestMapping(value = OPEN_REGISTRATION_PAGE, method = RequestMethod.GET)
    public String openRegistration() {
        LOGGER.log(Level.INFO, "Register page is opening");
        return REGISTRATION_PAGE;
    }
}
