package cn.echisan.springbootjwtdemo.controller;

import cn.echisan.springbootjwtdemo.entity.User;
import cn.echisan.springbootjwtdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 注册的控制器
 * Created by echisan on 2018/6/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUsername(registerUser.get("username"));
        // 记得注册的时候把密码加密一下
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        User save = userRepository.save(user);
        return save.toString();
    }
}
