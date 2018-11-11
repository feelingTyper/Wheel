//import com.fortune.controller.FortuneWheelController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by admin on 2017/8/14.
 */
public class AwardWheelTest {
    @Autowired
//    FortuneWheelController fortuneWheelController;
    public static void main(String[] args) throws Exception {
        try {
//            fortuneWheelController.fortuneWheel("testuser");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            System.out.println("SUCCESS");
        }
    }
}
