package com.youchuang.project.controller;

import com.youchuang.project.dto.LoginDTO;
import com.youchuang.project.service.AccountService;
import com.youchuang.project.service.ResourceService;
import com.youchuang.project.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: mohuijing
 */
@Controller
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, HttpSession session,
                        RedirectAttributes attributes, Model model) {
        LoginDTO loginDTO = accountService.login(username, password);
        String error = loginDTO.getError();
        if (error == null) {
            session.setAttribute("account", loginDTO.getAccount());
            List<ResourceVO> resourceVOS = resourceService.listResourceByRoleId(loginDTO.getAccount().getRoleId());
            model.addAttribute("resources", resourceVOS);
        } else {
            attributes.addFlashAttribute("error", error);
        }
        return loginDTO.getPath();
    }

    /**
     * 退出登录方法
     *
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

