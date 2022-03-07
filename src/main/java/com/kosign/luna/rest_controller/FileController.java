package com.kosign.luna.rest_controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.UploadFileResponse;
import com.kosign.luna.service.FileStorageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(tags = "File", value = "file controller", description = "manage files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    private String serverUrl;
    // private String clientUrl;

    // @Value("${file.upload.client.path}")
    // public void setClientUrl(String clientUrl) {
    // this.clientUrl = clientUrl;
    // }
    @Value("${file.upload.server.path}")
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(fileName).toUriString();
        String viewFile = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, viewFile, file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/delete/{name}")
    public BaseApiResponse delete(@PathVariable String name) {
        BaseApiResponse response = new BaseApiResponse();
        response.setCode("9999");
        response.setMessage("File not found");
        try (Stream<Path> walk = Files.walk(Paths.get(serverUrl))) {
            List<String> result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
            for (String file : result) {
                File file2 = new File(file);
                if (file2.getName().equals(name)) {
                    file2.delete();
                    response.setCode("0000");
                    response.setMessage("File has been deleted.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @GetMapping("/clear")
    public BaseApiResponse clearAllImage() {
        BaseApiResponse response = new BaseApiResponse();
        response.setCode("0000");
        response.setMessage("Images are clear.");
        try (Stream<Path> walk = Files.walk(Paths.get(serverUrl))) {
            List<String> result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
            for (String file : result) {
                File file2 = new File(file);
                file2.delete();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @GetMapping("/listAllFile")
    public BaseApiResponse ListAllFile() {
        BaseApiResponse response = new BaseApiResponse();
        try (Stream<Path> walk = Files.walk(Paths.get(serverUrl))) {
            List<String> result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
            response.setCode("0000");
            response.setMessage("Fetch images succuess.");
            List<String> reList = new ArrayList<String>();
            for (String filePath : result) {

                String viewFile = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                        .path(filePath.split("files/")[1]).toUriString();
                reList.add(viewFile);
            }
            response.setData(reList);
        } catch (IOException e) {
            response.setCode("9999");
            response.setMessage("Something went wrong.");
            e.printStackTrace();
        }

        return response;
    }

}