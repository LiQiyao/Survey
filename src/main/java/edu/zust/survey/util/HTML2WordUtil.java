package edu.zust.survey.util;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lee on 2017/11/18.
 */
public class HTML2WordUtil {

    private static Logger logger = Logger.getLogger(HTML2WordUtil.class);

    private HTML2WordUtil() {
    }

    public static boolean generatorWordFile(String path, String fileName, String HTMLUrl) {
        boolean w = false;
        ByteArrayInputStream bais = null;
        POIFSFileSystem poifs = null;
        FileOutputStream fos = null;
        try {
            if (!"".equals(path)) {
                // 检查目录是否存在
                File fileDir = new File(path);
                if (!fileDir.exists()){
                    logger.info("mkdirs: " + fileDir);
                    fileDir.mkdirs();
                }
                if (fileDir.exists()) {
                    logger.info("HTMLUrl: " + HTMLUrl);
                    // 生成临时文件名称
                    String content = getHTMLCode(HTMLUrl);
                    byte b[] = content.getBytes("GBK");
                    bais = new ByteArrayInputStream(b);
                    poifs = new POIFSFileSystem();
                    DirectoryEntry directory = poifs.getRoot();

                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
                    fos = new FileOutputStream(path + fileName);
                    poifs.writeFilesystem(fos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bais != null){
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (poifs != null){
                try {
                    poifs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return w;
    }
    private static String getHTMLCode(String url){
        String str = "";
        InputStream raw = null;
        BufferedInputStream buffer = null;
        Reader r = null;
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            raw = uc.getInputStream();
            buffer = new BufferedInputStream(raw);
            //
            r = new InputStreamReader(buffer);
            int c;
            while ((c = r.read()) != -1) {
                str += (char)c;
            } // end while
        }// end try
        catch (IOException e) {
            System.err.println(e);
        } finally {
            if (r != null){
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.print(str);
        return str;
    }
}
