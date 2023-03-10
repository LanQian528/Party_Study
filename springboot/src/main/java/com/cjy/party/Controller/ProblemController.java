package com.cjy.party.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjy.party.domain.ObjectProblem;
import com.cjy.party.server.impl.ObjectProblemServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@Controller
public class ProblemController {
    @Autowired
    ObjectProblemServerImpl objectProblemServer;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/getAllObjPro", method = RequestMethod.GET)
    public Object getAllObjPro() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<ObjectProblem> allobj = objectProblemServer.getAllObjProblem();
        jsonArray.addAll(allobj);
        jsonObject.put("objectproblems", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/updateObjProblem", method = RequestMethod.POST)
    public Object updateObjProblem(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSON.parseObject(s);
        ObjectProblem objectProblem = new ObjectProblem();
        objectProblem.setObjectpro_id(Integer.parseInt(jsonObject.get("objectpro_id").toString()));
        objectProblem.setObjectpro_A(jsonObject.get("objectpro_A").toString());
        objectProblem.setObjectpro_com(jsonObject.get("objectpro_com").toString());
        objectProblem.setObjectpro_B(jsonObject.get("objectpro_B").toString());
        objectProblem.setObjectpro_C(jsonObject.get("objectpro_C").toString());
        objectProblem.setObjectpro_D(jsonObject.get("objectpro_D").toString());
        objectProblem.setObjectpro_ans(jsonObject.get("objectpro_ans").toString());
        int i = objectProblemServer.updateObjProblem(objectProblem);
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) {
            jsonObject1.put("code", 200);
        } else {
            jsonObject1.put("code", 400);
        }
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/deleteProblem", method = RequestMethod.POST)
    public Object deleteProblem(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSON.parseObject(s);
        int i = objectProblemServer.deleteProblem(Integer.parseInt(jsonObject.get("objectpro_id").toString()));
        if (i > 0) jsonObject.put("code", 200);
        else jsonObject.put("code", 400);
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/insertProblem", method = RequestMethod.POST)
    public Object insertProblem(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSON.parseObject(s);
        ObjectProblem objectProblem = new ObjectProblem();
        objectProblem.setObjectpro_A(jsonObject.get("a").toString());
        objectProblem.setObjectpro_com(jsonObject.get("com").toString());
        objectProblem.setObjectpro_B(jsonObject.get("b").toString());
        objectProblem.setObjectpro_C(jsonObject.get("c").toString());
        objectProblem.setObjectpro_D(jsonObject.get("d").toString());
        objectProblem.setObjectpro_ans(jsonObject.get("ans").toString());
        int i = objectProblemServer.insertProblem(objectProblem);
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) {
            jsonObject1.put("code", 200);
        } else {
            jsonObject1.put("code", 400);
        }
        return jsonObject1;
    }
}
