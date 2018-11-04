package com.ltmicro.service.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServerAApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class, args);
    }

    @GetMapping(value="/test")
    public String test()
    {
        return "成功调用服务A！";
    }
}
