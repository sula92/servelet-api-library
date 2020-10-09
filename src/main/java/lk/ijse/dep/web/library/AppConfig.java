package lk.ijse.dep.web.library;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("lk.ijse.dep.web.library")
@Import(JPAConfig.class)
public class AppConfig {
}
