package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.activiti;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.AdministratorMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.ProcessMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Process;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.ProcessVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti.IProcessService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
@Service("iProcessService")
public class ProcessServiceImpl implements IProcessService {

    @Autowired
    private ProcessMapper processMapper;
    @Autowired
    private AdministratorMapper administratorMapper;


    @Override
    public void draw(List list,HttpServletResponse response) {
        response.setContentType("image/png");//声明文件格式
        //绘制宽=480，长=640的图板
        int width=800,hight=480;
        BufferedImage image = new BufferedImage(width,hight,BufferedImage.TYPE_INT_RGB);
        //获取图形上下文,graphics想象成一个画笔
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        //消除线条锯齿
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.white);    //GREEN:绿色；  红色：RED;   灰色：GRAY
        graphics.fillRect(0, 0, 800, 480);

        Font fsib30 = new Font("宋体", Font.BOLD+Font.ITALIC, 18);
        graphics.setFont(fsib30);

        graphics.setColor(Color.yellow);
        graphics.fillOval(50,190,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(50,190,100,100);
        graphics.drawString("开始",75,240);

        int j = list.size();
        for(int i=0;i<j;i++){
            graphics.setColor(Color.CYAN);
            graphics.fillOval(200+i*150,190,100,100);
            graphics.setColor(Color.BLACK);
            graphics.drawOval(200+i*150,190,100,100);
            graphics.drawString(list.get(i).toString(),225+i*150,240);
            graphics.drawLine(150+i*150,240,200+i*150,240);
            int[] xPoints2 = {200+i*150,190+i*150,190+i*150};
            int[] yPoints2 = {240,237,243};
            graphics.drawPolygon(xPoints2,yPoints2,3);

        }
        graphics.setColor(Color.pink);
        graphics.fillOval(200+j*150,190,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(200+j*150,190,100,100);
        graphics.drawString("结束",225+j*150,240);
        graphics.drawLine(150+j*150,240,200+j*150,240);
        int[] xPoints2 = {200+j*150,190+j*150,190+j*150};
        int[] yPoints2 = {240,237,243};
        graphics.drawPolygon(xPoints2,yPoints2,3);


        graphics.dispose();//释放此图形的上下文并释放它所使用的所有系统资源
        try {
        ImageIO.write(image,"png",response.getOutputStream());
        PrintWriter out =  response.getWriter();
        out.flush();
        out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServerResponse<String> addProcess(Process process) {
        int count = processMapper.insert(process);
        if(count>0)
            return ServerResponse.createBySuccessMessage("添加成功");
        return ServerResponse.createByErrorMessage("创建失败");
    }

    @Override
    public ServerResponse<String> delProcess(Integer id) {
        int count = processMapper.deleteByPrimaryKey(id);
        if(count>0)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<String> updateProcess(Process process) {
        int count = processMapper.updateByPrimaryKey(process);
        if(count>0)
            return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<PageHelperUtil> select(Integer pageSize,Integer pageNumber,String name, Integer founderId) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Process> processes = processMapper.selectByNameFounder(name,founderId);
        List<ProcessVO> processVOS = new ArrayList<>();
        for(Process process:processes){
            ProcessVO processVO = new ProcessVO();
            processVO.setId(process.getId());
            processVO.setName(process.getName());
            processVO.setDescribe(process.getDescribe());
            processVO.setFounderId(process.getFounderId());
            processVO.setFounder(administratorMapper.selectName(process.getFounderId()));
            processVO.setCreatTime(process.getCreatTime());
            processVO.setParties(process.getParty());
            processVO.setDetails(process.getDetails());
            processVOS.add(processVO);
        }
        PageInfo pageResult = new PageInfo(processes);
        pageResult.setList(processVOS);
        return ServerResponse.createBySuccess("查询成功", PageHelperUtil.toPageHeper(pageResult));
    }
}
