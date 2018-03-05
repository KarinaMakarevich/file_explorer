package com.epam.test_task.controller;

import com.epam.test_task.service.FileService;
import com.epam.test_task.service.exception.ServiceException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import static com.epam.test_task.controller.util.PageConstant.MAIN_PAGE;

@Controller
public class FileController {
    private static final String SHOW_ALL_FILES = "/showAllFiles";
    private static final String FILE_ACTION = "/fileAction";
    @Autowired
    FileService fileService;

    @RequestMapping(value = SHOW_ALL_FILES, method = RequestMethod.GET)
    public ModelAndView showAllFiles(ModelAndView modelAndView) {
        HashMap<File, String> files = fileService.showAllFiles();
        modelAndView.addObject("allFiles", files);
        modelAndView.setViewName(MAIN_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = FILE_ACTION, method = RequestMethod.GET, params = "fileButton")
    public ModelAndView showFolderContent(ModelAndView modelAndView, @RequestParam("fileButton") String fileName) {
        HashMap<File, String> files = fileService.showFolderContent(fileName);
        modelAndView.addObject("allFiles", files);
        modelAndView.setViewName(MAIN_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
    public @ResponseBody
    String deleteFile(@RequestParam("deleteButton") String fileName) throws ServiceException {
        //fileService.deleteFileFolder(fileName);
        Gson gson = new GsonBuilder().create();
        return gson.toJson("success");
    }

    @RequestMapping(value = "/createFile", method = RequestMethod.GET)
//TODO create file in service with check for folder and file
    public @ResponseBody
    String createFile(@RequestParam("createButton") String fileName, @RequestParam("type") String type) throws ServiceException {
        System.out.println(fileName);
        System.out.println(type);
        boolean answer = fileService.create(fileName, type);
        Gson gson = new GsonBuilder().create();
        String json;
        if (!answer) {
            json = gson.toJson("error");
        } else {
            json = gson.toJson("success");
        }
        return json;
    }

}
