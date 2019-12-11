package com.lishuang.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 多文件的上传
     * @param files
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    @CrossOrigin
    public String upload(@RequestParam(value = "files", required=false) MultipartFile files,HttpServletRequest request){
//        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
//        MultipartFile file = multipartRequest.getFile("files");
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        File f = new File(realPath);
        System.out.println(files);
//        for(MultipartFile file: files){
//            得到文件名
            String originalFilename = files.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
//            获取后缀名
            String suffix = originalFilename.substring(i);

            UUID uuid = UUID.randomUUID();
            long currentTimeMillis = System.currentTimeMillis();
//            拼接新的文件名
            String newFileName = currentTimeMillis+"."+suffix;
            System.out.println(newFileName);

            if(!f.isDirectory()){
                try {
                    files.transferTo(new File(f ,newFileName));
                } catch (IOException e) {
                    e.printStackTrace();
                    return "404";
                }
            }

//        }
        return "200";
    }
}
    /**
     * 上传图片接口
//     * */
//    @PostMapping("/upload")
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   HttpServletRequest request) {
//        try {
//            byte[] bytes = file.getBytes();
//            String imageFileName = file.getOriginalFilename();
//            String fileName = UpPhotoNameUtils.getPhotoName("img",imageFileName);
//            Path path = Paths.get(UPLOAD_PATH + fileName);
//            Files.write(path, bytes);
//            System.out.println(fileName+"\n");
//            return fileName;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }
/**
 * 处理图片名的工具类
 * */
//public class UpPhotoNameUtils {
//    public static String getPhotoName(String name,String imageFileName){
//        String fileName = name;
//        Calendar cal=Calendar.getInstance();
//        //如果年的目录不存在，创建年的目录
//        int year=cal.get(Calendar.YEAR);
//        fileName=fileName + "_" + year;
//        //如果月份不存在，创建月份的目录
//        int month=cal.get(Calendar.MONTH)+1;
//        fileName=fileName+"_";
//        if(month<10)
//        {
//            fileName=fileName+"0";
//        }
//        fileName=fileName+month;
//        //生成文件名的日部分
//        int day=cal.get(Calendar.DAY_OF_MONTH);
//        fileName=fileName+"_";
//        if(day<10)
//        {
//            fileName=fileName+"0";
//        }
//        fileName=fileName+day;
//        //生成文件名的小时部分
//        int hour=cal.get(Calendar.HOUR_OF_DAY);
//        if(hour<10)
//        {
//            fileName=fileName+"0";
//        }
//        fileName=fileName+hour;
//        //生成文件名的分钟部分
//        int minute=cal.get(Calendar.MINUTE);
//        if(minute<10)
//        {
//            fileName=fileName+"0";
//        }
//        fileName=fileName+minute;
//        //生成文件名的秒部分
//        int second=cal.get(Calendar.SECOND);
//        if(second<10)
//        {
//            fileName=fileName+"0";
//        }
//        fileName=fileName+second;
//        //生成文件名的毫秒部分
//        int millisecond=cal.get(Calendar.MILLISECOND);
//        if(millisecond<10)
//        {
//            fileName=fileName+"0";
//        }
//        if(millisecond<100)
//        {
//            fileName=fileName+"0";
//        }
//        fileName=fileName+millisecond;
//        //生成文件的扩展名部分,只截取最后单位
//        String endName = imageFileName.substring(imageFileName.lastIndexOf("."));//截取之后的值
//        fileName=fileName+ endName;
//        return fileName;
//    }
//}
