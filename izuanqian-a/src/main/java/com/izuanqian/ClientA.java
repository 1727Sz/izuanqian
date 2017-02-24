/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sanlion
 */
@RestController
public class ClientA {

    @Autowired private DiscoveryClient discoveryClient;

    @GetMapping("/now")
    public String getCurrentTime() {
        System.out.println(discoveryClient.getLocalServiceInstance().getHost());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @PostMapping("/upload")
    public List<String> upload(@RequestParam("file") List<MultipartFile> files) {
        for (MultipartFile file : files) {
            if (file != null) {
                save(file);
            }
        }
        return Collections.emptyList();
    }

    @Value("${root}") String root;

    private void save(MultipartFile file) {
        try {
            String[] paths = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).split("-");
            Path directory = Paths.get(root, paths[0], paths[1], paths[2]);
            if (Files.notExists(directory)) {
                Files.createDirectories(directory);
            }
            Files.copy(file.getInputStream(), Paths.get(directory.toString(), file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ClientA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
