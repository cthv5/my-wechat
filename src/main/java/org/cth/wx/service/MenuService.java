package org.cth.wx.service;

import com.soecode.wxtools.bean.WxMenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {
    public WxMenu createMenu() {
        WxMenu menu = new WxMenu();
        List<WxMenu.WxMenuButton> btnList = new ArrayList<>();

        WxMenu.WxMenuButton btn1 = new WxMenu.WxMenuButton();
        btn1.setName("分类");
        List<WxMenu.WxMenuButton> subList = new ArrayList<>();
        WxMenu.WxMenuButton btn1_1 = new WxMenu.WxMenuButton();
        btn1_1.setType("click");
        btn1_1.setKey("wx_hot_song");
        btn1_1.setName("飙升榜");
        WxMenu.WxMenuButton btn1_2 = new WxMenu.WxMenuButton();
        btn1_2.setType("click");
        btn1_2.setKey("wx_top_song");
        btn1_2.setName("TOP500");
        WxMenu.WxMenuButton btn1_3 = new WxMenu.WxMenuButton();
        btn1_3.setType("click");
        btn1_3.setKey("wx_wh_song");
        btn1_3.setName("网络红歌");
        WxMenu.WxMenuButton btn1_4 = new WxMenu.WxMenuButton();
        btn1_4.setType("click");
        btn1_4.setKey("wx_hy_song");
        btn1_4.setName("华语新歌");
        WxMenu.WxMenuButton btn1_5 = new WxMenu.WxMenuButton();
        btn1_5.setType("click");
        btn1_5.setKey("wx_xn_song");
        btn1_5.setName("洗脑神曲");

        WxMenu.WxMenuButton btn2 = new WxMenu.WxMenuButton();
        btn2.setType("click");
        btn2.setKey("wx_change_news");
        btn2.setName("换一组");

        WxMenu.WxMenuButton btn3 = new WxMenu.WxMenuButton();
        btn3.setType("click");
        btn3.setKey("wx_help");
        btn3.setName("帮助");

        subList.addAll(Arrays.asList(new WxMenu.WxMenuButton[] { btn1_1, btn1_2, btn1_3, btn1_4, btn1_5 }));
        btn1.setSub_button(subList);

        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);

        menu.setButton(btnList);
        return menu;
    }
}
