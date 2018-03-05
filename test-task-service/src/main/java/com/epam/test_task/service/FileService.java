package com.epam.test_task.service;

import com.epam.test_task.service.exception.ServiceException;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface FileService {
    HashMap<File, String> showAllFiles();

    HashMap<File, String> showFolderContent(String fileName);

    void delete(String fileName) throws ServiceException;

    boolean create(String fileName, String type) throws ServiceException;

    /*boolean createFile(String fileName) throws ServiceException;

    boolean createFolder(String folderName) throws ServiceException;*/
}
