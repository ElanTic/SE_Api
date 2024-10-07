package com.uaz.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.uaz.apirest.gestor.transformers.CSVTransformer;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyController {
    @Autowired
    CSVTransformer transformer;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Inicio");
        return "index";
    }

    @GetMapping("/partial")
    public String partialContent(Model model) {
        return "fragments :: contentFragment";
    }

    @PostMapping("/csv")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Convert MultipartFile to a temporary file or InputStream for Spark processing
            transformer.runEtlPipeline(file);
            return "File uploaded and processed successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload and process the file.";
        }
    }
    
}