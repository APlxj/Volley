package ap.com.volley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class BaseApplication extends Application {

    public static BaseApplication mInstance;
    // 建立请求队列
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static BaseApplication getContext() {
        if (null == mInstance) {
            synchronized (BaseApplication.class) {
                if (null == mInstance) {
                    mInstance = new BaseApplication();
                }
            }
        }
        return mInstance;
    }

    public static RequestQueue getQueue() {
        if (null == queue) {
            synchronized (BaseApplication.class) {
                if (null == queue) {
                    queue = Volley.newRequestQueue(getContext());
                }
            }
        }
        return queue;
    }
}
