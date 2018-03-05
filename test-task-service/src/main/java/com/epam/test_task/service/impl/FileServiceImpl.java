package com.epam.test_task.service.impl;

import com.epam.test_task.service.FileService;
import com.epam.test_task.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.ws.Service;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileServiceImpl implements FileService {
    private static final Logger LOGGER = LogManager.getLogger(FileServiceImpl.class);
    private static final String FILE = "file";
    private static final String FOLDER = "folder";

    public HashMap<File, String> showFolderContent(String fileName) {
        File folder = new File(fileName);
        HashMap<File, String> files = null;
        if (folder.exists()) {
            if (folder.listFiles() != null) {
                files = new HashMap<>();
                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    if (file.listFiles() != null) {
                        files.put(file, FOLDER);
                    } else {
                        files.put(file, FILE);
                    }
                }
            }
        }
        return files;
    }

    public HashMap<File, String> showAllFiles() {
        HashMap<File, String> files = null;
        if (File.listRoots() != null) {
            files = new HashMap<>();
            for (File file : File.listRoots()) {
                if (file.listFiles() != null) {
                    files.put(file, FOLDER);
                } else {
                    files.put(file, FILE);
                }
            }
        }
        return files;
    }

    @Override
    public void delete(String fileName) throws ServiceException {
        File file = new File(fileName);
        if (file.exists()) {
            if (!file.delete()) {
                throw new ServiceException("File can't be deleted");
            }
        }
    }

    @Override
    public boolean create(String fileName, String type) throws ServiceException {
        boolean isCreated = false;
        if (FOLDER.equals(type)) {
            isCreated = createFolder(fileName);
        } else if (FILE.equals(type)) {
            isCreated = createFile(fileName);
        }
        return isCreated;
    }


    private boolean createFile(String fileName) throws ServiceException {
        boolean isSuccessfullyCreated = false;
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                LOGGER.log(Level.INFO, "File is created!");
                isSuccessfullyCreated = true;
            } else {
                LOGGER.log(Level.ERROR, "File already exists.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return isSuccessfullyCreated;
    }

    private boolean createFolder(String folderName) throws ServiceException {
        boolean isSuccessfullyCreated = false;
        File files = new File(folderName);
        if (!files.exists()) {
            if (files.mkdirs()) {
                LOGGER.log(Level.INFO, "Directory created successfully");
                isSuccessfullyCreated = true;
            } else {
                LOGGER.log(Level.ERROR, "Failed to create directory");
                throw new ServiceException("Failed to create directory");
            }
        }
        return isSuccessfullyCreated;
    }
}
