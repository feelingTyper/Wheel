package com.fortune.util;

import com.fortune.entity.AwardInfo;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by lichang on 2017/8/14.
 */
public class FortuneWheelUtil {

    public static final String CODE_SUCCESS = "200";                 //成功返回代码
    public static final String CODE_ERROR = "805";                   //数据库查询错误返回代码
    public static final String CODE_USERNAME_EXIST_ERROR = "201"; //用户名已存在返回代码
    public static final String CODE_USERPHONE_EXIST_ERROR = "202";//号码已存在返回代码
    public static final String CODE_UPLOAD_FAIL = "203";            //上传失败代码
    public static final String CODE_UPLOAD_TYPE_ERROR = "204";     //上传格式错误代码

    public static final String MSG_SUCCESS = "成功";                 //成功返回信息
    public static final String MSG_ERROR = "失败";                   //失败返回信息

    public static final String MSG_USERNAME_EXIST_ERROR = "用户名已存在";
    public static final String MSG_USERPHONE_EXIST_ERROR = "该号码已存在";
    public static final String MSG_NUMBER_ERROR = "抽奖次数为空";

    public static final int AWARD_OPPORTUNITY = 3;
    public static final String PHONE_CONVERT = "****";
    public static final String UPLOAD_FAIL = "文件上传失败！";
    public static final String UPLOAD_SUCCESS = "文件上传成功！";
    public static final String UPLOAD_TYPE_ERROR = "上传格式有误！";

    /**
     * 生成奖项
     * @return
     */
    public static AwardInfo generateAward(List<AwardInfo> awardList) {
        long number = randomnum(1, 100);
        double line = 0;
        double temp = 0;
        AwardInfo result = new AwardInfo();
        int index = 0;
        for (int i = 0; i < awardList.size(); i++) {
            AwardInfo awardInfo = awardList.get(i);
            double weight = awardInfo.getAwardprob() * 100;
            temp = temp + weight;
            line = 100 - temp;
            if (weight != 0) {
                if (number > line && number <= (line + weight)) {
                    result = awardInfo;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 生成随机数
     * @param smin 最小值
     * @param smax 最大值
     * @return 随机数
     */
    private static long randomnum(int smin, int smax){
        int range = smax - smin;
        double rand = Math.random();
        return (smin + Math.round(rand * range));
    }

    /**
     * 生成奖项
     * @param filepath 数据库路径数组
     * @return 文件路径数组
     */
    public static String[] getArray(String filepath){
        filepath = filepath.replace("[","");
        filepath = filepath.replace("]","");
        filepath = filepath.replace(" ","");
        String[] filepathArray = filepath.split(",");
        return filepathArray;
    }
}
