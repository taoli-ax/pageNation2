package com.coh.controller;

import com.alibaba.fastjson.JSON;
import com.coh.pojo.Cup;
import com.coh.pojo.Page;
import com.coh.service.CupService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cup")
public class CupServlet extends HttpServlet {
    CupService cupService;
    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app4.xml");
        cupService=(CupService) applicationContext.getBean("cupServiceImpl");
        System.out.println("init");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        switch (method) {
            case "list":
                System.out.println("list");
                list(req,resp);
            case "findByPageNum":
                findPageByNum(req,resp);
                System.out.println("进入 findByPageNum");
            case "queryByPageNum":
                System.out.println("进入queryByPageNum");
                queryPageByNum(req,resp);
        }
    }

    public void list(HttpServletRequest request,HttpServletResponse response) throws IOException {

        List<Cup> cupList=cupService.findAll();
        System.out.println(cupList);
        String string=JSON.toJSONString(cupList);
        PrintWriter writer =response.getWriter();
        writer.println(string);
        writer.flush();
        writer.close();

    }
    public void findPageByNum(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String pageNumber=request.getParameter("pageNum");
        int pageNum=1;
        if(pageNumber!=null&& !"".equals(pageNumber)) {
            pageNum=Integer.parseInt(pageNumber);
        }
        Page page=new Page();
        page.setPageNum(pageNum);
        List<Cup> cupList=cupService.FindByPage(page);

        System.out.println(page);
        Map<String,Object>map=new HashMap<>();
        map.put("page",page);
        map.put("cups",cupList);
        String string=JSON.toJSONString(map);

        PrintWriter writer =response.getWriter();
        writer.println(string);
        writer.flush();
        writer.close();
    }
    public void queryPageByNum(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String CupName=request.getParameter("CupName");
        String pageNumber=request.getParameter("PageNum");
        String CupBrand=request.getParameter("CupBrand");
        System.out.println("接收到前端参数："+CupBrand+" "+CupBrand+" "+pageNumber);
        int pageNum=1;
        if(pageNumber!=null&& !"".equals(pageNumber)) {
            pageNum=Integer.parseInt(pageNumber);
        }
        Page page=new Page();
        page.setPageNum(pageNum);

        List<Cup> cups=cupService.QueryByPage(page,CupBrand,CupName);
        Map<String,Object>map=new HashMap<>();
        map.put("page",page);
        map.put("cups",cups);
        System.out.println("查询到符合条件的数据："+cups);
        String string=JSON.toJSONString(map);

        PrintWriter writer =response.getWriter();
        writer.println(string);
        writer.flush();
        writer.close();
    }
}
