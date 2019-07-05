package org.cth.wx.controller.cth;


import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import org.cth.wx.controller.BaseController;
import org.cth.wx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {
    private IService iService = new WxService();

    @Autowired
    private MenuService menuService;

    @GetMapping
    public String check(String signature, String timestamp, String nonce, String echostr) {
        log.info(">>>check wx");
        if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
            log.info(">>>checkSignature ok");
            return echostr;
        }
        return null;
    }

    @PostMapping
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // 微信服务器推送过来的是XML格式
            WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
            log.info(">>>接受到的消息：\n " + wx.toString());
            this.iService.createMenu(this.menuService.createMenu(), false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
