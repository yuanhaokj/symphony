package org.b3log.symphony.spring.open.api;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("api/file")
public class FileController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 文件上传
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "fileupload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "C:\\file\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }




    /**

     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile

     * @param request

     * @return

     */
    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(HttpServletRequest request){
        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream =
                            new BufferedOutputStream(new FileOutputStream(new File("C:\\file\\" + file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream =  null;
                    return "You failed to upload " + i + " =>" + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " becausethe file was empty.";
            }
        }
        return "upload successful";

    }





}
