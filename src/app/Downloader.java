package app;

import constant.Constant;
import util.HttpUtils;
import util.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * 下载器
 * @Datetime: 2024/6/28下午11:12
 * @author: Camellia.xioahua
 */
public class Downloader {

    HttpURLConnection httpURLConnection = null;

    public void download(String url) {
        //获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        //文件存储地址
        httpFileName = Constant.DOWNLOADPATH+"\\"+httpFileName;
        try {
            //获取连接对象
             httpURLConnection = HttpUtils.getConnection(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //下载文件
        try( BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(httpFileName))){
            byte[] buffer = new byte[1024];
            int readCunt = 0;
            while ((readCunt = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0,readCunt);
            }
            //刷新
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            LogUtils.error("下载的文件不存在[]",url);
        } catch (IOException e) {
            System.out.println();
            LogUtils.error("下载失败");
        }finally {
            //关闭连接对象
            if(httpURLConnection != null) {httpURLConnection.disconnect();}
        }

    }

}
