package util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * http相关工具类
 * @Datetime: 2024/6/28下午10:49
 * @author: Camellia.xioahua
 */
public class HttpUtils {

    /**
     * 获取HttpURLConnection链接对象
     * @param url
     * @return
     * @throws IOException
     */
    public static HttpURLConnection getConnection(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        //向文件所在的服务器发送标识信息，模拟浏览器。
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
        return httpURLConnection;
    }

    /**
     * 获取下载文件的名称，包含后缀。
     * @param url
     * @return 文件名
     */
    public static String getHttpFileName(String url) {
        String downloadName = url.substring(url.lastIndexOf("/") + 1);
        return downloadName;
    }
}
