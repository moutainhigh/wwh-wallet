package com.wwh.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.ResultMsg;
import com.wwh.util.ReturnConstant;

@Controller
public class VerifyCodeController extends HttpServlet{
	
	private static final long serialVersionUID = -3056739242508456346L;
    private int width = 60;         
    private int height = 20;         
    private int codeCount = 4;         
    private int x = 0;         
    private int fontHeight;         
    private int codeY;         
    char[] codeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };         
    /**       
     * 初始化验证图片属性       
     */        
    public void initxuan() throws ServletException {         
        String strWidth ="80";         
        String strHeight ="30";         
        String strCodeCount = "4";         
        try {         
            if (strWidth != null && strWidth.length() != 0) {         
                width = Integer.parseInt(strWidth);         
            }         
            if (strHeight != null && strHeight.length() != 0) {         
                height = Integer.parseInt(strHeight);         
            }         
            if (strCodeCount != null && strCodeCount.length() != 0) {         
                codeCount = Integer.parseInt(strCodeCount);         
            }         
        } catch (NumberFormatException e) {         
        }         
        x = 13;//width / (codeCount + 1);         
        fontHeight = height - 2;         
        codeY = height - 4;         
    }
    
    /**
     * 创建
     */
    @RequestMapping(value="/createCode",method=RequestMethod.GET)
    public void service(HttpServletRequest req, HttpServletResponse resp)         
            throws ServletException, java.io.IOException { 
        initxuan();
        BufferedImage buffImg = new BufferedImage(width, height,         
                BufferedImage.TYPE_INT_RGB);         
        Graphics2D g = buffImg.createGraphics();         
        Random random = new Random();         
        g.setColor(Color.WHITE);         
        g.fillRect(0, 0, width, height);         
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);         
        g.setFont(font);         
        g.setColor(Color.BLACK);         
        g.drawRect(0, 0, width - 1, height - 1);         
        g.setColor(Color.BLACK);         
        for (int i = 0; i < 10; i++) {         
            int x = random.nextInt(width);         
            int y = random.nextInt(height);         
            int xl = random.nextInt(12);         
            int yl = random.nextInt(12);         
            g.drawLine(x, y, x + xl, y + yl);         
        }         
        StringBuffer randomCode = new StringBuffer();         
        int red = 0, green = 0, blue = 0;         
        for (int i = 0; i < codeCount; i++) {         
            String strRand = String.valueOf(codeSequence[random.nextInt(10)]);         
            red = random.nextInt(255);         
            green = random.nextInt(255);         
            blue = random.nextInt(255);         
            g.setColor(new Color(red, green, blue));         
            g.drawString(strRand, (i + 1) * x, codeY);         
            randomCode.append(strRand);         
        }         
        HttpSession session = req.getSession();         
        session.setAttribute("validateCode", randomCode.toString());         
        resp.setHeader("Pragma", "no-cache");         
        resp.setHeader("Cache-Control", "no-cache");         
        resp.setDateHeader("Expires", 0);         
        resp.setContentType("image/jpeg");         
        ServletOutputStream sos = resp.getOutputStream();         
        ImageIO.write(buffImg, "jpeg", sos);         
        sos.close();         
    }
    
    @RequestMapping(value="/validateCode",method=RequestMethod.POST)
    @ResponseBody
    public ResultMsg<Object> validateCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
        response.setContentType("text/html;charset=utf-8"); 
        ResultMsg<Object> rs = new ResultMsg<Object>();
        String validate = (String) request.getSession().getAttribute("validateCode");         
        String veryCode = request.getParameter("veryCode");         
        if(veryCode==null||"".equals(veryCode)){         
        	return ResultMsg.returnMsg400();        
        }else{         
            if(validate.equalsIgnoreCase(veryCode)){         
                rs.setReturnMsg("验证码正确");
                rs.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
            }else{         
                rs.setReturnMsg("验证码错误");
                rs.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
            }         
        }
        return rs;
    }  
}
