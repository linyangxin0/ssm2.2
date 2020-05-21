package cn.itcast.controller;


import cn.itcast.domain.SysLog;
import cn.itcast.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysController {

    @Autowired
    private ISysLogService iSysLogService;

    @RequestMapping("/findAll.do")
    public @ResponseBody List<SysLog> findAll(){
        return iSysLogService.findAll();
    }
}
