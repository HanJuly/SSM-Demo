package com.han.mybatisdemo.controller;

import com.han.mybatisdemo.pojo.User;
import com.han.mybatisdemo.service.UserService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @RequestMapping("/test/requestbody")
    public String getUser(@RequestBody User user) {
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping("/test/post")
    public String postUser( User user) {
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile file) {
        try {
            String path =  request.getSession().getServletContext().getRealPath("/upload");
            File temp = new File(path);
            if(!temp.exists()){
                temp.mkdirs();
            }

            String newName = String.format("%s-%s",UUID.randomUUID().toString(),file.getOriginalFilename());
            file.transferTo(new File(String.format("%s%s%s",path,File.separator,newName)));
        } catch (IOException e) {
            LOGGER.error("Upload failed.............");
            e.printStackTrace();
        }
//        int i = 1 / 0;
//        try {
//            String remotePath = "http://127.0.0.1:8500/abc/file/";
//            Client client = Client.create();
//            String fIleName = remotePath + file.getOriginalFilename();
//            WebResource webResource = client.resource(fIleName);
//            webResource.put(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        return "index";
    }
}
