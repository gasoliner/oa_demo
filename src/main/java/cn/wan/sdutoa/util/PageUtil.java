package cn.wan.sdutoa.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOExceptionWithCause;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by 万洪基 on 2017/3/7.
 */
public class PageUtil {

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

    public static boolean deleteFile(String filePath) throws IOException{
        File file = new File(filePath);
        return file.delete();
    }
}
