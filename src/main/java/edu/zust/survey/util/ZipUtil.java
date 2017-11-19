package edu.zust.survey.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Lee on 2017/11/19.
 * 把所有生成的文档压缩成ZIP格式
 */
public class ZipUtil {

    private static Logger logger = Logger.getLogger(ZipUtil.class);

    private ZipUtil() {
    }

    /**
     * html导出的word文档打包
     * @param inputUrl 文档所在路径
     * @param outputUrl 压缩包生成路径
     * @param zipFileName 压缩包名
     * @param fileNameList word文档列表
     */
    public static void compressToZip(String inputUrl, String outputUrl, String zipFileName, List<String> fileNameList){
        logger.info("打包文件:" + inputUrl);
        logger.info("生成解压包:" + outputUrl);
        logger.info("包名:" + zipFileName);
        logger.info("打包文件名:" + fileNameList);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        File zipFileDir = new File(outputUrl);
        if (!zipFileDir.exists()){
            logger.info("mkdirs: " + zipFileDir.getName());
            zipFileDir.mkdirs();
        }
        File zipFile = new File(outputUrl + "/" + zipFileName);
        File[] sourceFiles = new File[fileNameList.size()];
        for (int i = 0; i < sourceFiles.length; i++){
            sourceFiles[i] = new File(inputUrl + "/" + fileNameList.get(i));
        }
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);
            System.out.println(2);
            byte[] buffer = new byte[1024];
            ZipEntry zipEntry = null;
            for (int i = 0; i < sourceFiles.length; i++){
                zipEntry = new ZipEntry(sourceFiles[i].getName());
                zos.putNextEntry(zipEntry);
                fis = new FileInputStream(sourceFiles[i]);
                bis = new BufferedInputStream(fis, 1024);
                int n = 0;
                while ((n = bis.read(buffer, 0, 1024)) != -1){
                    zos.write(buffer, 0, n);
                }
                bis.close();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
            logger.trace(zipFile.getName() + "未找到", e);
        } catch (IOException e){
            e.printStackTrace();
            logger.trace("IO异常", e);
        } finally {
            try {
                if (bis != null){
                    bis.close();
                }
                if (zos != null){
                    zos.close();
                }
            } catch (IOException e){
                e.printStackTrace();
                logger.trace("关闭输入输出流异常", e);
            }

        }

    }
}
