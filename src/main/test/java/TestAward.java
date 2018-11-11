import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fortune.entity.AwardInfo;
import com.fortune.entity.Awardee;
import com.fortune.entity.UserInfo;
import com.fortune.pojo.FortuneWheelPojo;
import com.fortune.service.AwardInfoService;
import com.fortune.service.AwardeeService;
import com.fortune.service.UserInfoService;
//import com.fortune.util.FortuneWheelUtil;
import com.fortune.service.WheelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "classpath:mybatis-config.xml" })
//@Transactional
public class TestAward {

    private static final Logger LOGGER = Logger.getLogger(TestAward.class);

    @Autowired
    AwardInfoService awardInfoService;
    @Autowired
    AwardeeService awardeeService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    WheelService wheelService;

    @Test
//    @Rollback(false)
    public void TestUserInfo() {
        UserInfo userInfo = new UserInfo();

//        for(int i=0; i<10; i++) {
//            userInfo.setUsername("user" + i);
//            userInfo.setPhonenumber("1881070878" + i);
//            userInfo.setOpportunity(3);
////            userInfoService.insert(userInfo);
////            UserInfo userInfo1 = userInfoService.selectUserByPhone(userInfo.getPhonenumber());
//            UserInfo userInfo1 = wheelService.insertAndSelect(userInfo, userInfo.getPhonenumber());
//            System.out.println(userInfo1);
//        }
        userInfo.setUsername("user");
        userInfo.setPhonenumber("188107087800");
        userInfo.setOpportunity(3);
        int userId = userInfoService.insert(userInfo);
        userInfo = userInfoService.selectByUserNamePhone("user4", "10101010101");
        System.out.println(userId);
//        userInfoService.deleteUsers();
    }

    @Test
    public void testAwardee() {
        Awardee awardee = new Awardee();

//        for(int i=0; i<3; i++) {
//            awardee.setAwardname("100yuan");
//            awardee.setPhonenumber("18810708785");
//            awardee.setTime(new Date());
//            awardee.setUserid(1);
//            awardeeService.insert(awardee);
//        }

        // selectAll
//        List<Awardee> awardees = awardeeService.selectAll();
//        System.out.println(awardees);
//
        // selectByUserId
        List<Awardee> awardees = awardeeService.selectByUserId(1);
        System.out.println(awardees);

        awardee.setPhonenumber("38383838383");
        awardee.setId(5);
        awardeeService.updateByUserId(awardee);
//        awardeeService.deleteAll();

    }

    @Test
    public void testAwardInfo() {
        AwardInfo awardInfo = new AwardInfo();

        //insert
//        for(int i=0; i<8; i++) {
//            awardInfo.setAwardname(i + "00元");
//            awardInfo.setAwarddes("马尔代夫");
//            awardInfo.setAwardid(i+1);
//            awardInfo.setAwardnum(10-i);
//            awardInfo.setAwardprob(.2);
//            awardInfo.setAwardimg("hhhh" + i);
//            awardInfo.setWeek(2);
//
//            awardInfoService.insert(awardInfo);
//        }

        awardInfo.setAwardname(8 + "00元");
        awardInfo.setAwardid(1);
        awardInfo.setAwardnum(10);
        awardInfo.setAwardprob(.2);
        awardInfo.setAwardimg("hhhh");
        awardInfo.setWeek(2);
//        awardInfo.setWeek(3);
        awardInfoService.insert(awardInfo);

        //selectAll
//        List<AwardInfo> awardInfos = awardInfoService.selectAwards();
//        System.out.println(awardInfos);

        //update
        awardInfo.setAwardname("谢谢您参与");
        awardInfo.setAwardid(100);
        awardInfo.setAwarddes("这个并没有中奖");
        awardInfoService.updateByAwardId(awardInfo);

        //delete
//        awardInfoService.deleteAwardInfoByIdweek(2,1);

//       select
//        awardInfo = awardInfoService.selectAwardByIdWeek(3, 1);
//        List<AwardInfo> awardInfos = awardInfoService.selectAllByWeek(2);
//        System.out.println(awardInfos);
    }
}
