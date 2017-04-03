package cn.wan.sdutoa.util;

import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.JsjUser;
import cn.wan.sdutoa.vo.VoUser;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * Created by 万洪基 on 2017/3/7.
 */
public class PageUtil {


    public static HttpSession getCurrentSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static VoUser getUser(){
//        ContextLoader.getCurrentWebApplicationContext().getServletContext()
        VoUser user = (VoUser) getCurrentSession().getAttribute(ContantKey.GLOBLE_USER_INFO);
        return user;
    }

    public static String uploadAnnex(HttpServletRequest request, CommonsMultipartFile file, String schoolYear, String achievement, String model) {
        String path =request.getRealPath("/upload/"+model+"/"+schoolYear+"/");
        String fileName = achievement+".jpeg";
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path+fileName));

        }catch (Exception e){
            e.printStackTrace();
        }
        return path+fileName;
    }

    public static String setVoAnnexByUUID(String uuid){
       return  "<a href = \"#\" onclick=\"showTePaper('"+uuid+"')\">查看</a>";
    }

    public static void showImg(String filePath, HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        OutputStream outputStream = response.getOutputStream();
        int len ;
        byte[] bytes = new byte[1024*8];
        while ((len = fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        fileInputStream.close();
        outputStream.close();
    }

    public static void showImg(InputStream inputStream, HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        OutputStream outputStream = response.getOutputStream();
        int len ;
        byte[] bytes = new byte[1024*8];
        while ((len = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }

    public static boolean deleteFile(String filePath) throws IOException{
        File file = new File(filePath);
        return file.delete();
    }

    public static String setVoNoticeActionByUUID(String uuid){
        return  "<a href = \"#\" onclick=\"showNotice('"+uuid+"')\">查看</a>";
    }

    public static String setRoleByRid(String rid){
        if (rid.equals("1")){
            return "管理员";
        }else {
            return "教师";
        }
    }

    public static String setSchholYearBySYId(int syId){
        List<FrontQuery> list = (List<FrontQuery>) getCurrentSession().getAttribute("schoolyears");
        String schoolYear = null;
        for (FrontQuery frontQuery:
                list){
            if (syId == frontQuery.getSyid()){
                schoolYear= frontQuery.getSchoolyear();
                break;
            }
        }
        return schoolYear;
    }

    public static String setCompetitionBycId(int cId){
        List<FrontQuery> list = (List<FrontQuery>) getCurrentSession().getAttribute("competitions");
        String competition = null;
        for (FrontQuery frontQuery:
                list){
            if (cId == frontQuery.getCompetitionid()){
                competition= frontQuery.getCompetition();
                break;
            }
        }
        return competition;
    }

    public static String setGradeBygId(int gId){
        List<FrontQuery> list = (List<FrontQuery>) getCurrentSession().getAttribute("grades");
        String grade = null;
        for (FrontQuery frontQuery:
                list){
            if (gId == frontQuery.getGradeid()){
                grade = frontQuery.getGrade();
                break;
            }
        }
        return grade;
    }

    public static String setAwardLevelBylId(int lId){
        List<FrontQuery> list = (List<FrontQuery>) getCurrentSession().getAttribute("awardLevels");
        String awardLevel = null;
        for (FrontQuery frontQuery:
                list){
            if (lId == frontQuery.getAwardlevelid()){
                awardLevel = frontQuery.getAwardlevel();
                break;
            }
        }
        return awardLevel;
    }

    public static String setAwardStateByasId(int asId){
        switch (asId){
            case 0: return "初始录入";
            case 1: return "审核中";
            case 2: return "同意";
            case 3: return "不同意";
            default: return null;
        }
    }

//    public static String setAwardActionByeId(String aId){
//        return  "<a href = \"#\" onclick=\"applyAwardBegin('"+aId+"')\">开始申请</a>";
//    }

    public static String setVoProcessAction(String deploymentId,String resourceName){
        return  "<a href = \"#\" onclick=\"showProPng('"+deploymentId+"','"+resourceName+"')\">查看</a>";
    }
}
