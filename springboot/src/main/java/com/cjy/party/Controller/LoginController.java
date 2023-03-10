package com.cjy.party.Controller;

import com.alibaba.fastjson.JSONObject;
import com.cjy.party.domain.Login;
import com.cjy.party.domain.User;
import com.cjy.party.server.impl.LoginServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@Controller

public class LoginController {
    @Autowired
    LoginServerImpl loginServer;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public Object verifylogin(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSONObject.parseObject(s);
        Login login = new Login();
        login.setId(jsonObject.get("username").toString());
        login.setPass(jsonObject.get("password").toString());
        login.setType(jsonObject.getInteger("type"));
        User res = loginServer.verifyAccount(login);
        if (res.getType() == 1) {
            jsonObject.put("code", 1);
            jsonObject.put("id", res.getId());
            jsonObject.put("name", res.getName());
        } else if (res.getType() == 3) {
            jsonObject.put("code", 3);
            jsonObject.put("id", res.getId());
            jsonObject.put("name", res.getName());
        } else if (res.getType() == 2) {
            jsonObject.put("code", 2);
            jsonObject.put("id", res.getId());
            jsonObject.put("name", res.getName());
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
        }
        return jsonObject;
    }
}
