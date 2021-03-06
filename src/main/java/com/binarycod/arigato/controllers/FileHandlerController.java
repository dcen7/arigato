package com.binarycod.arigato.controllers;

import com.binarycod.arigato.domain.Image;
import com.binarycod.arigato.services.AwsS3Service;
import com.binarycod.arigato.services.FileStorageService;
import com.binarycod.arigato.services.FileStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/files")
public class FileHandlerController {


    @Autowired
    AwsS3Service awsS3Service;

    @GetMapping
    public String showFilesAndUpload(Model model) {

        model.addAttribute("files", awsS3Service.listAllImages());
        return "file_list_upload";
    }

    @PostMapping
    public String uploadFiles(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model){
        //  System.out.println("content type "+file.getContentType());
        if (file.getContentType().contains("image")){
            awsS3Service.upload(file);
            redirectAttributes.addFlashAttribute("message", "Uploaded successfully");
        } else {
            redirectAttributes.addFlashAttribute("error","I accept only Images");
        }

        return "redirect:/admin/files";
    }

    @GetMapping("/delete")
    public String deleteImage(@RequestParam String key, RedirectAttributes redirectAttributes){
        awsS3Service.delete(key);
        redirectAttributes.addFlashAttribute("message", key+" is deleted successfully");

        return "redirect:/admin/files";
    }

}
