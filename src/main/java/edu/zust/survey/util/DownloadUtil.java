package edu.zust.survey.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by Lee on 2017/11/19.
 * 用户下载压缩好的文档
 */
public class DownloadUtil {

    private static Logger logger = Logger.getLogger(DownloadUtil.class);

    private DownloadUtil() {
    }

    public static void download(String filePath, String fileName , HttpServletResponse response){
        logger.info("下载文件：" + filePath + "/" + fileName);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{

            //设置输出格式
            response.reset();
            //
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));

            byte[] b = new byte[1024];
            int len;
            inputStream = new FileInputStream(filePath + "/" + fileName);
            outputStream = response.getOutputStream();
            while ((len = inputStream.read(b)) > 0){
                outputStream.write(b, 0, len);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
