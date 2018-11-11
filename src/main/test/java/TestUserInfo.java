//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//
///**
// *
// * @author admin
// * @version 2.2
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml",
//        "classpath:mybatis-config.xml" })
//
//public class TestUserInfo {
//
//    private static final Logger LOGGER = Logger
//            .getLogger(TestUserInfo.class);
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testQueryById1() {
//        UserInfo userInfo = userService.getUserInfo(1);
//        System.out.println("Test UserInfo:::" + userInfo.toString());
//        LOGGER.info(JSON.toJSON(userInfo));
//    }
//
//    @Test
//    public void testQueryAll() {
//        List<UserInfo> userInfos = userService.userInfos();
//        LOGGER.info(JSON.toJSON(userInfos));
//    }
//
//    @Test
//    public void testInsert() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setName("xiaoming");
//        int result = userService.insert(userInfo);
//        System.out.println(result);
//    }
//}