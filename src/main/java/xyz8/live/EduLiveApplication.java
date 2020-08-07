package xyz8.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// 扫描cn.hutool.extra.spring包下所有类并注册之
@ComponentScan(basePackages={"xyz8.live.*","cn.hutool.extra.spring"})
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class EduLiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduLiveApplication.class, args);
	}

}
