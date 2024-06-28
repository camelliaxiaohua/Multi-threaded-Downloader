import app.Downloader;
import util.LogUtils;

import java.util.Scanner;

/**
 * @Datetime: 2024/6/28下午10:38
 * @author: Camellia.xioahua
 */
public class AppMain {
    public static void main(String[] args) {
        //创建下载对象
        Downloader downloader = new Downloader();
        //下载地址
        String url = null;
        if(args == null || args.length == 0) {
            while (true){
                LogUtils.info("请输入下载地址");
                System.out.println("请输入下载地址: ");
                Scanner sc = new Scanner(System.in);
                url = sc.nextLine();
                if(url != null){
                    break;
                }
            }
        }else {
            url = args[0];
            System.out.println(url);
        }
        downloader.download(url);
    }
}
