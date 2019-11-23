import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: lbj
 * @create: 2019-11-23 12:59
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.lbj"})
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
