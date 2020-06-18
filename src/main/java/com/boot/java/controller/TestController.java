package com.boot.java.controller;


import com.alibaba.fastjson.JSONObject;
import com.boot.java.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("quertObject")
    @ResponseBody
    public  Result  quertObject(@RequestParam("readStartTime") String readStartTime,
                              @RequestParam("readEndTime") String readEndTime,
                              @RequestParam("isColse") String isColse){
        Result result = new Result();
        try {
            JSONObject jsonObject = new JSONObject();
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            logger.info(sdf1.format(new Date())+"  | "+"进入方法"+" | readStartTime=="+readStartTime +"  |  readEndTime=="+readEndTime+"  |  isColse=="+isColse);

            jsonObject.put("readStartTime",readStartTime);
            jsonObject.put("readEndTime",readEndTime);
            jsonObject.put("isColse",isColse);
            result.setData(jsonObject);
            result.setMagess("调用接口成功！");
            result.setStatus(1);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMagess("调用接口报错！");
            result.setStatus(0);
        }
        return result;
    }
}
