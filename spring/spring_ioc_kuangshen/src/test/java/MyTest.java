import com.klgentle.dao.UserDaoOracleImpl;
import com.klgentle.service.UserService;
import com.klgentle.service.UserServiceImpl;

public class MyTest {
    public static void main (String[] args) {
        UserService service = new UserServiceImpl();
        ((UserServiceImpl)service).setUserDao(new UserDaoOracleImpl());
        service.getUser();
    }
}
