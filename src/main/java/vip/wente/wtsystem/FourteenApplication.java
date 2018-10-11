package vip.wente.wtsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("vip.wente.wtsystem.dao")
public class FourteenApplication {

    public static void main(String[] args) {
        SpringApplication.run(FourteenApplication.class, args);
    }
}
