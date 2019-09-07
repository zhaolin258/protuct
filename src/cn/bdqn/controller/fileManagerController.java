package cn.bdqn.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author: 赵林
 * @Date: 2019/9/6 8:49
 * @Description:
 */
@Controller
@RequestMapping("/f")
public class fileManagerController {
    private Logger logger=Logger.getLogger(fileManagerController.class);
    @RequestMapping(value = "/upload.do",method = RequestMethod.GET)
    public String toFile(){
        return "fileUpload";
    }

    /**
     *单文件上传
     * @return
     */
    @RequestMapping(value = "/one.html",method = RequestMethod.POST)
    public String fileupload(HttpServletRequest request, @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        //判断是否有上传的文件
        if (!file.isEmpty()) {
            //输出文件的名字
            logger.debug("文件的名称:==============="+file.getOriginalFilename());
            logger.debug("文件的大小:==============="+file.getSize()/1024+"k");
            logger.debug("文件的后缀:==============="+FilenameUtils.getExtension(file.getOriginalFilename()));
            //设置文件上传的目录(完整名+文件名)
            String uploadPath=request.getServletContext().getRealPath("/downloads/")+File.separator +System.currentTimeMillis()+file.getOriginalFilename();
            logger.debug("文件上传的目录================>"+uploadPath);
            //目标文件
            File fileptah=new File(uploadPath);
            //上传文件
            FileUtils.copyInputStreamToFile(file.getInputStream(),fileptah);
        }
        return "上传成功!";
    }


    /**
     *单文件上传
     * @return
     */
    @RequestMapping(value = "/two.html",method = RequestMethod.POST)
    public String fileupload2(HttpServletRequest request, @RequestParam MultipartFile[] files) throws IOException {
        //判断是否有上传的文件
        if (files.length!=0) {
            for (MultipartFile file : files) {
                //输出文件的名字
                logger.debug("文件的名称:==============="+file.getOriginalFilename());
                logger.debug("文件的大小:==============="+file.getSize()/1024+"k");
                logger.debug("文件的后缀:==============="+FilenameUtils.getExtension(file.getOriginalFilename()));
                //设置文件上传的目录(完整名+文件名)
                String uploadPath=request.getServletContext().getRealPath("/downloads/")+File.separator +System.currentTimeMillis()+file.getOriginalFilename();
                logger.debug("文件上传的目录================>"+uploadPath);
                //目标文件
                File fileptah=new File(uploadPath);
                //上传文件
                FileUtils.copyInputStreamToFile(file.getInputStream(),fileptah);
            }
        }
        return "上传成功!";
    }
    @RequestMapping(value = "/down.html")
    public String toDown(){
        return "download";
    }
    @RequestMapping(value = "/download.html")
    public ResponseEntity<byte[]> download(@RequestParam String fileName,HttpServletRequest request) throws IOException {
        //获取文件在服务器上的目录
        String realPath = request.getServletContext().getRealPath("/WEB-INF/jsp/img/");
        //最终生成全路径名
        File file=new File(realPath+File.separator+fileName);
        //定义请求头
        HttpHeaders httpHeaders=new HttpHeaders();
        //下载完成后显示文件名（中文乱码）
        String downloadFileName=new String(
                fileName.getBytes("UTF-8"),
                "ISO-8859-1");
        //通知浏览器以附件形式下载文件
        httpHeaders.setContentDispositionFormData("attachment",downloadFileName);
        //定义以二进制流形式下载返回文件数据
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //下载：返回ResponseEntity对象
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders,HttpStatus.CREATED);
    }
}
