package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.activiti;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Process;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
@Controller
@RequestMapping("/process/")
public class ProcessController {

    @Autowired
    private IProcessService iProcessService;

    @RequestMapping(value = "draw.do")
    public void draw(HttpServletResponse response){
        List<String> strings = new ArrayList<>();
        strings.add("节点1");
        strings.add("节点2");
        strings.add("节点3");
        iProcessService.draw(strings,response);
    }

    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addProcess(Process process){
        return iProcessService.addProcess(process);
    }

    @RequestMapping(value = "delete.do",method =RequestMethod.POST)
    @ResponseBody
    public ServerResponse delProcess(int id){
        return iProcessService.delProcess(id);
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateProcess(Process process){
        return iProcessService.updateProcess(process);
    }

    @RequestMapping(value = "select.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse selectProcess(@RequestParam(value = "name",defaultValue = "") String name,
                                        @RequestParam(value = "founderId",defaultValue = "0")int founderId){
        return iProcessService.select(name,founderId);
    }
}
