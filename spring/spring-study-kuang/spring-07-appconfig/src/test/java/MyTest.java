import com.klgentle.config.MyConfig;
import com.klgentle.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 如果完全通过配置类来做，只能使用 AnnotationConfig 上下文获取容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }

}
