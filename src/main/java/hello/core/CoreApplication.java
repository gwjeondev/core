package hello.core;

import hello.core.member.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {


        SpringApplication.run(CoreApplication.class, args);

    }

}
