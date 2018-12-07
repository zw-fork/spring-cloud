package com.fangjia.common.util;

import java.util.Random;

/**
 * 端口工具类
 *
 * @author yinjihuan
 * @create 2017-11-21 15:41
 **/
public class ServerPortUtils {
    /**
     * 获取可用端口，范围2000-65535
     * @return
     */
    public static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random random = new Random();
        int port = random.nextInt(max)%(max-min+1) + min;
        boolean using = NetUtils.isLoclePortUsing(port);
		// 如果端口正在使用，则递归继续查找，可用端口。
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }

}
