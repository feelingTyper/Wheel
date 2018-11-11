package com.fortune.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fortune.entity.AwardInfo;
import com.fortune.entity.Awardee;
import com.fortune.entity.UserInfo;
import com.fortune.pojo.AwardInfoPojo;
import com.fortune.pojo.AwardeePojo;
import com.fortune.pojo.request.*;
import com.fortune.pojo.response.*;
import com.fortune.service.AwardInfoService;
import com.fortune.service.AwardeeService;
import com.fortune.service.UserInfoService;
import com.fortune.util.FortuneWheelUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by lichang on 2017/8/14.
 */
@Controller
public class FortuneWheelController {

    @Autowired
    AwardeeService awardeeService;
    @Autowired
    AwardInfoService awardInfoService;
    @Autowired
    UserInfoService userInfoService;

    /**
     * 抽奖
     * @param fortuneWheelReq 转盘请求实体
     * @return
     */
    @RequestMapping(value = "/fortuneWheel", method = RequestMethod.POST)
    @ResponseBody
    public FortuneWheelRsp fortuneWheel(@ModelAttribute FortuneWheelReq fortuneWheelReq) {
        FortuneWheelRsp rsp = new FortuneWheelRsp();
        int userId = fortuneWheelReq.getUserId();
        int drawNum = fortuneWheelReq.getAwardNum();
        //判断该用户是否能抽奖
        if (drawNum <= 0 || drawNum > 3){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_NUMBER_ERROR);
            return rsp;
        }
        drawNum -= 1;
        //生成中奖金额对象
        List<AwardInfo> awardList = awardInfoService.selectAllByWeek(1);
        //开始抽奖
        AwardInfo awardInfo = FortuneWheelUtil.generateAward(awardList);
        if (StringUtils.isEmpty(awardInfo.getId())) {
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
            return rsp;
        }
        //判断当前用户是否登录
        if (userId != 0){
            rsp.setUserId(userId);
            //写入中奖信息
            InsertAwardeeReq insertAwardeeReq = new InsertAwardeeReq();
            insertAwardeeReq.setUserId(userId);
            insertAwardeeReq.setAwardName(awardInfo.getAwardname());
            insertAwardee(insertAwardeeReq);
            //既定方案为前台传抽奖次数，若改动为后台修改，请执行此函数
/*            UserInfo userInfo = userInfoService.selectUserByUserId(userId);
            userInfo.setOpportunity(drawNum);
            userInfoService.update*/
        }
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        rsp.setData(awardInfo);
        rsp.setDrawNum(drawNum);
        return rsp;
    }

    /**
     * 查询所有获奖人信息
     * @param getAllAwardeeReq 获取获奖人信息请求实体
     * @return
     */
    @RequestMapping(value = "/allAwardee", method = RequestMethod.GET)
    @ResponseBody
    public GetAllAwardeeRsp allAwardee(GetAllAwardeeReq getAllAwardeeReq){
        GetAllAwardeeRsp rsp = new GetAllAwardeeRsp();
        List<Awardee> awardeeList = awardeeService.selectAll();
        List<AwardeePojo> resultList = new ArrayList<AwardeePojo>();
        Iterator<Awardee> iter = awardeeList.iterator();
        while (iter.hasNext()){
            Awardee awardee = iter.next();
            String phoneNumber = awardee.getPhonenumber();
            String awardName = awardee.getAwardname();
            Date time = awardee.getTime();
            if (phoneNumber.length() == 11){
                String regex = phoneNumber.substring(3,7);
                String newPhoneNumber = phoneNumber.replaceAll(regex,FortuneWheelUtil.PHONE_CONVERT);
                AwardeePojo awardeePojo = new AwardeePojo();
                awardeePojo.setUserPhone(newPhoneNumber);
                awardeePojo.setAwardName(awardName);
                awardeePojo.setDate(time);
                resultList.add(awardeePojo);
            }
        }
        rsp.setAwardeePojoList(resultList);
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 删除所有获奖人信息
     * @param deleteAllAwardeeReq 获取获奖人信息请求实体
     * @return
     */
    @RequestMapping(value = "/deleteAllAwardee", method = RequestMethod.POST)
    @ResponseBody
    public DeleteAllAwardeeRsp allAwardee(DeleteAllAwardeeReq deleteAllAwardeeReq){
        DeleteAllAwardeeRsp rsp = new DeleteAllAwardeeRsp();
        int result = awardeeService.deleteAll();
        if (result == -1){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
        }else {
            rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
            rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        }
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 新增获奖人信息
     * @param insertAwardeeReq 新增获奖人请求实体
     * @return
     */
    @RequestMapping(value = "/insertAwardee", method = RequestMethod.POST)
    @ResponseBody
    public InsertAwardeeRsp insertAwardee(@ModelAttribute InsertAwardeeReq insertAwardeeReq){
        InsertAwardeeRsp rsp = new InsertAwardeeRsp();
        Awardee awardee = new Awardee();
        awardee.setAwardname(insertAwardeeReq.getAwardName());
        awardee.setUserid(insertAwardeeReq.getUserId());
        awardee.setPhonenumber(insertAwardeeReq.getPhoneNum());
        awardee.setTime(new Date());
        int result = awardeeService.insert(awardee);
        if (result == -1){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
        }else {
            rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
            rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        }
        return rsp;
    }

    /**
     * 获取获奖人信息
     * @param getAwardeeReq 获取获奖人信息请求实体
     * @return
     */
    @RequestMapping(value = "/awardee", method = RequestMethod.GET)
    @ResponseBody
    public GetAwardeeRsp awardee(GetAwardeeReq getAwardeeReq){
        GetAwardeeRsp rsp = new GetAwardeeRsp();
        int userId = getAwardeeReq.getUserId();
        List<Awardee> awardeeList = awardeeService.selectByUserId(userId);
        rsp.setAwardeeList(awardeeList);
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 获取某一项奖品说明
     * @param getOneAwardInfoReq 获取奖品信息请求实体
     * @return
     */
    @RequestMapping(value = "/oneAwardInfo", method = RequestMethod.GET)
    @ResponseBody
    public GetOneAwardInfoRsp oneAwardInfo(GetOneAwardInfoReq getOneAwardInfoReq){
        GetOneAwardInfoRsp rsp = new GetOneAwardInfoRsp();
        AwardInfo awardInfo = awardInfoService.selectAwardByIdWeek(getOneAwardInfoReq.getAwardId(), getOneAwardInfoReq.getWeek());
        AwardInfoPojo awardInfoPojo = new AwardInfoPojo();
        awardInfoPojo.setAwardid(awardInfo.getAwardid());
        awardInfoPojo.setAwardname(awardInfo.getAwardname());
        awardInfoPojo.setAwarddes(awardInfo.getAwarddes());
        awardInfoPojo.setAwardnum(awardInfo.getAwardnum());
        awardInfoPojo.setAwardprob(awardInfo.getAwardprob());
        String[] imgFilePath = FortuneWheelUtil.getArray(awardInfo.getAwardimg());
        awardInfoPojo.setAwardimg(imgFilePath);
        rsp.setAwardInfoPojo(awardInfoPojo);
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 获取每日奖品说明
     * @param getAwardInfoReq 获取奖品信息请求实体
     * @return
     */
    @RequestMapping(value = "/awardInfo", method = RequestMethod.GET)
    @ResponseBody
    public GetAwardInfoRsp awardInfo(GetAwardInfoReq getAwardInfoReq){
        GetAwardInfoRsp rsp = new GetAwardInfoRsp();
        List<AwardInfo> awardInfoList = awardInfoService.selectAllByWeek(getAwardInfoReq.getWeek());
        List<AwardInfoPojo> awardInfoPojoList = new ArrayList<AwardInfoPojo>();
        Iterator<AwardInfo> iter = awardInfoList.iterator();
        while (iter.hasNext()){
            AwardInfo awardInfo = iter.next();
            AwardInfoPojo awardInfoPojo = new AwardInfoPojo();
            awardInfoPojo.setAwardid(awardInfo.getAwardid());
            awardInfoPojo.setAwardname(awardInfo.getAwardname());
            awardInfoPojo.setAwarddes(awardInfo.getAwarddes());
            awardInfoPojo.setAwardnum(awardInfo.getAwardnum());
            awardInfoPojo.setAwardprob(awardInfo.getAwardprob());
            String[] imgFilePath = FortuneWheelUtil.getArray(awardInfo.getAwardimg());
            awardInfoPojo.setAwardimg(imgFilePath);
            awardInfoPojoList.add(awardInfoPojo);
        }
        rsp.setAwardInfoPojo(awardInfoPojoList);
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 奖品信息表单处理
     * @param request
     * @return
     */
    public AwardFormConfigRsp FormHandleRequest(HttpServletRequest request){
        AwardFormConfigRsp rsp = new AwardFormConfigRsp();
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = System.getProperty("catalina.home")+"/webapps/upload";//TODO
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        //消息提示
        String message = "";
        String awardName = null;
        int awardId = 0;
        String awardDes = null;
        int awardNum = 0;
        double awardProb = 0;
        int awardWeek = 0;
        String filepath = null;
        List<String> filepathList = new ArrayList<String>();
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return rsp;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    if (name.equals("awardName")){
                        awardName = value;
                    }else if (name.equals("awardId")){
                        awardId = Integer.parseInt(value);
                    }else if (name.equals("awardDes")){
                        awardDes = value;
                    }else if (name.equals("awardNum")){
                        awardNum = Integer.parseInt(value);
                    }else if (name.equals("awardProb")){
                        awardProb = Double.parseDouble(value);
                    }else if (name.equals("awardWeek")){
                        awardWeek = Integer.parseInt(value);
                    }
                }else{//如果fileitem中封装的是上传文件
                    //得到上传的文件名称
                    String filepathTemp = item.getName();
                    if(filepathTemp==null || filepathTemp.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    String filenameTemp = filepathTemp.substring(filepathTemp.lastIndexOf("\\")+1);
                    String suffix = filenameTemp.substring(0,filenameTemp.lastIndexOf("."));
                    String prefix=filenameTemp.substring(filenameTemp.lastIndexOf(".")+1);
                    if (!prefix.toLowerCase().equals("jpg") && !prefix.toLowerCase().equals("png") && !prefix.toLowerCase().equals("gif")){
                        rsp.setCode(FortuneWheelUtil.CODE_UPLOAD_TYPE_ERROR);
                        rsp.setMsg(FortuneWheelUtil.UPLOAD_TYPE_ERROR);
                        return rsp;
                    }
                    String uuid = UUID.randomUUID().toString();
                    String filename = suffix + uuid + "." + prefix;
                    filepath = savePath + "\\" + filename;
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(filepath);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message = FortuneWheelUtil.UPLOAD_SUCCESS;
                    filepathList.add(filepath);
                }
            }
            //存入数据库
            rsp.setAwardId(awardId);
            rsp.setAwardName(awardName);
            rsp.setAwardDes(awardDes);
            rsp.setAwardNum(awardNum);
            rsp.setAwardProb(awardProb);
            rsp.setWeek(awardWeek);
            rsp.setAwardImg(filepathList);
            rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        }catch (Exception e) {
            message= FortuneWheelUtil.UPLOAD_FAIL;
            rsp.setMsg(message);
            rsp.setCode(FortuneWheelUtil.CODE_UPLOAD_FAIL);
            e.printStackTrace();
        }
        return rsp;
    }

    /**
     * 新增奖品信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertAwardConfig", method = RequestMethod.POST)
    @ResponseBody
    public InsertAwardConfigRsp insertAwardConfig (HttpServletRequest request){
        InsertAwardConfigRsp rsp = new InsertAwardConfigRsp();
        AwardFormConfigRsp awardFormConfigRsp = FormHandleRequest(request);
        if (awardFormConfigRsp.getCode() != FortuneWheelUtil.CODE_SUCCESS){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
            return rsp;
        }
        AwardInfo awardInfo = new AwardInfo();
        int week = awardFormConfigRsp.getWeek();
        int awardId = awardFormConfigRsp.getAwardId();
        double awardProb = awardFormConfigRsp.getAwardProb();
        if (!((week >= 1 && week <= 7) && (awardId >= 1 && awardId <=8) && (awardProb >= 0 && awardProb <=1))){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
            return rsp;
        }
        awardInfo.setAwardid(awardFormConfigRsp.getAwardId());
        awardInfo.setAwarddes(awardFormConfigRsp.getAwardDes());
        awardInfo.setAwardname(awardFormConfigRsp.getAwardName());
        awardInfo.setAwardnum(awardFormConfigRsp.getAwardNum());
        awardInfo.setWeek(awardFormConfigRsp.getWeek());
        awardInfo.setAwardprob(awardFormConfigRsp.getAwardProb());
        awardInfo.setAwardimg(awardFormConfigRsp.getAwardImg().toString());
        int result = awardInfoService.insert(awardInfo);
        if (result == -1){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
        }else {
            rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
            rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        }
        return rsp;
    }

    /**
     * 配置更新奖品信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/awardConfig", method = RequestMethod.POST)
    @ResponseBody
    public AwardConfigRsp awardConfig(HttpServletRequest request){
        AwardConfigRsp rsp = new AwardConfigRsp();

        AwardFormConfigRsp awardFormConfigRsp = FormHandleRequest(request);
        if (awardFormConfigRsp.getCode() != FortuneWheelUtil.CODE_SUCCESS){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
            return rsp;
        }
        AwardInfo awardInfo = new AwardInfo();
        int week = awardFormConfigRsp.getWeek();
        int awardId = awardFormConfigRsp.getAwardId();
        double awardProb = awardFormConfigRsp.getAwardProb();
        if (!((week >= 1 && week <= 7) && (awardId >= 1 && awardId <=8) && (awardProb >= 0 && awardProb <=1))){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
            return rsp;
        }
        awardInfo.setAwardid(awardFormConfigRsp.getAwardId());
        awardInfo.setAwarddes(awardFormConfigRsp.getAwardDes());
        awardInfo.setAwardname(awardFormConfigRsp.getAwardName());
        awardInfo.setAwardnum(awardFormConfigRsp.getAwardNum());
        awardInfo.setWeek(awardFormConfigRsp.getWeek());
        awardInfo.setAwardprob(awardFormConfigRsp.getAwardProb());
        awardInfo.setAwardimg(awardFormConfigRsp.getAwardImg().toString());
        awardInfoService.updateByAwardId(awardInfo);
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 删除奖品信息
     * @param deleteAwardConfigReq 删除奖品请求实体
     * @return
     */
    @RequestMapping(value = "/deleteAwardConfig", method = RequestMethod.POST)
    @ResponseBody
    public DeleteAwardConfigRsp deleteAwardConfig(DeleteAwardConfigReq deleteAwardConfigReq){
        DeleteAwardConfigRsp rsp = new DeleteAwardConfigRsp();
        int awardId = deleteAwardConfigReq.getAwardId();
        int week = deleteAwardConfigReq.getWeek();
        AwardInfo awardInfo = awardInfoService.selectAwardByIdWeek(awardId, week);
        String filepath = awardInfo.getAwardimg();
        String[] filepathArray = FortuneWheelUtil.getArray(filepath);
        for (String temp:filepathArray) {
            File file = new File(temp);
            if(file.isFile() && file.exists()){
                file.delete();
            }
        }
        int result = awardInfoService.deleteAwardInfoByIdweek(awardId, week);
        if (result == -1){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
        }else {
            rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
            rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        }
        return rsp;
    }

}
