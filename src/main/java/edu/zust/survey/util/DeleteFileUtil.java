package edu.zust.survey.util;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by Lee on 2017/11/18.
 */
public class DeleteFileUtil {

    private static Logger logger = Logger.getLogger(DeleteFileUtil.class);

    private DeleteFileUtil() {
    }

    public static boolean deleteFile(File dir){
        if (dir.isDirectory()){
            String[] child = dir.list();
            if (child != null){
                for (int i = 0; i < child.length; i++){
                    boolean success = deleteFile(new File(dir, child[i]));
                    logger.info("删除" + child + "结果:" + success);
                    if (!success){
                        return false;
                    }
                }
            }
        }
        return dir.delete();
    }
}
