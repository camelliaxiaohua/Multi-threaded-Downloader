package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 日志工具类
 * @Datetime: 2024/6/28下午11:59
 * @author: Camellia.xioahua
 */
public class LogUtils {

    public static void info(String msg, Object... args){
        printLog(msg,"-INFO-",args);
    }

    public static void error(String msg, Object... args){
        printLog(msg,"-ERROR-",args);
    }

    private static void printLog(String msg, String level,Object... args){
        if (args.length > 0){
            msg = String.format(msg.replace("[]", "%s"), args);
        }
        String name = Thread.currentThread().getName();
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " " + name + " " + level + " " + msg);
    }
}
