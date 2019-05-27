package org.b3log.symphony.spring.controller.websocket;



import org.b3log.symphony.spring.service.python.ExecPythonCodeService;
import org.b3log.symphony.spring.util.RedisUtil;
import org.python.core.PyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/web/socket/")
public class WebSocketController {


    private static Logger LOG = LoggerFactory.getLogger(WebSocketController.class);


    @RequestMapping(value = "python/code", method = RequestMethod.GET)
    public Map<String,Object> execPythonCode(
            @RequestParam(value = "code", defaultValue = "import sys") String code,
            HttpServletRequest request,
            Model model,
            HttpServletResponse response)
            throws Exception {

        RedisUtil redisUtil = new RedisUtil();
        redisUtil.set("haha","124");
        redisUtil.hset("abc","aaa","this is hget value");
        redisUtil.hset("abc","bbb","this is bbb hget value");
        System.out.println(redisUtil.get("haha"));
        System.out.println(redisUtil.hget("abc","aaa"));

        Map<String,Object> result =new HashMap<>();
        ExecPythonCodeService service = new ExecPythonCodeService();
        String[] codes = code.split("\n");
        for (String tempCode : codes){
            try {
                if (Pattern.matches("$ ",tempCode))
                    tempCode = tempCode.replaceFirst("$ *","");
                String execResult = service.execPythonCodeForLine(tempCode);
                result.put("success", true);
                result.put("execResult", execResult);
                WebSocketServer.sendInfo(execResult);
            }catch (IOException | PyException e) {
                result.put("success", false);
                result.put("execResult", e.getMessage());
                WebSocketServer.sendInfo(e.getMessage());
            }
        }
        return result;
    }


}
