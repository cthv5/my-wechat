package org.cth.wx.controller.cth;

import org.cth.wx.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring mvc 返回静态页面，不能使用restController，页面默认在static下
 * @author cth
 * @date 2019/06/15
 */
@Controller
@RequestMapping("/")
public class HtmlController extends BaseController {

    @GetMapping("/")
    public String homePage() {
        log.info(">>>homePage");
        return "/page/home.html";
    }
}
