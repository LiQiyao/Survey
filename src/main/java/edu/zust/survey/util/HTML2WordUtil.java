package edu.zust.survey.util;

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
    public static boolean generatorWordFile(String path, String fileName, String HTMLUrl) {
        boolean w = false;
        try {
            if (!"".equals(path)) {
                // 检查目录是否存在
                File fileDir = new File(path);
                if (fileDir.exists()) {
                    // 生成临时文件名称
                    String content = getHTMLCode(HTMLUrl);
                    byte b[] = content.getBytes();
                    ByteArrayInputStream bais = new ByteArrayInputStream(b);
                    POIFSFileSystem poifs = new POIFSFileSystem();
                    DirectoryEntry directory = poifs.getRoot();
                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
                    FileOutputStream ostream = new FileOutputStream(path + fileName);
                    poifs.writeFilesystem(ostream);
                    bais.close();
                    ostream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return w;
    }
    private static String getHTMLCode(String url){
        String str = "";
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            InputStream raw = uc.getInputStream();
            InputStream buffer = new BufferedInputStream(raw);
            //
            Reader r = new InputStreamReader(buffer);
            int c;
            while ((c = r.read()) != -1) {
                str += (char)c;
            } // end while
        }// end try
        catch (IOException e) {
            System.err.println(e);
        }// end catch

        //System.out.print(str);
        return str;
    }
}
