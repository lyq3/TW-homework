package com.lyq3.galaxy.controller;

import com.lyq3.galaxy.common.BussinessException;
import com.lyq3.galaxy.common.ExceptionEnum;
import com.lyq3.galaxy.common.Result;
import com.lyq3.galaxy.service.RomanService;
import com.lyq3.galaxy.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 控制器
 * @author 卡卢比
 * @date 2018/5/20
 */
@RestController
public class RomanController {
    @Autowired
    private RomanService romanService;

    /**
     *文本框提交转换并输出结果
     * @return
     */
    @PostMapping("/conver")
    public Result<String> converter (String in){
        if (in == null || "".equals(in)) {
            throw new BussinessException(ExceptionEnum.NOT_NULL);
        }
        String result = romanService.converter(in);
        return new Result<String>().setData(result);
    }

    /**
     * 文件提交
     * @param file
     * @return
     */
    @PostMapping("/file")
    public Result<String> file(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType =fileName .substring(fileName.lastIndexOf(".")+1);
        if (!"txt".equals(fileType)){
            throw new BussinessException(ExceptionEnum.FILE_FORMAT_ERROR);
        }
        //读取文件
        String lines = FileUtils.convertStreamToString(file.getInputStream());
        String result = romanService.converter(lines);
        return new Result<String>().setData(result);
    }
}
