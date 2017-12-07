package ap.com.volley;

import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.utils.ImageUtil;
import com.android.volley.utils.PostUploadRequest;
import com.android.volley.utils.RequestUtil;
import com.android.volley.utils.VolleyListenerInterface;

import java.util.Map;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class VolleyUtil {

    /**
     * 获取GET请求内容
     * 参数：
     *
     * @param url：请求的url地址；
     * @param tag：当前请求的标签；
     * @param volleyListenerInterface：VolleyListenerInterface接口；
     * @param timeOutDefaultFlg：是否使用Volley默认连接超时；
     */
    public static void get(String url, String tag,
                           VolleyListenerInterface volleyListenerInterface,
                           boolean timeOutDefaultFlg, Class<?> aClass) {
        RequestUtil.get(BaseApplication.getQueue(), url, tag,
                volleyListenerInterface, timeOutDefaultFlg, aClass);
    }

    public static void get(String url, VolleyListenerInterface volleyListenerInterface, boolean timeOutDefaultFlg, Class<?> aClass) {
        get(url, "tag", volleyListenerInterface, timeOutDefaultFlg, aClass);
    }

    public static void get(String url, VolleyListenerInterface volleyListenerInterface, Class<?> aClass) {
        get(url, "tag", volleyListenerInterface, true, aClass);
    }

    public static void get(String url, VolleyListenerInterface volleyListenerInterface) {
        get(url, "tag", volleyListenerInterface, true, null);
    }


    /**
     * 获取POST请求内容（请求的代码为Map）
     * 参数：
     *
     * @param url：请求的url地址；
     * @param tag：当前请求的标签；
     * @param params：POST请求内容；
     * @param volleyListenerInterface：VolleyListenerInterface接口；
     * @param timeOutDefaultFlg：是否使用Volley默认连接超时；
     */
    public static void post(String url, String tag, final Map<String, String> params,
                            VolleyListenerInterface volleyListenerInterface,
                            boolean timeOutDefaultFlg, Class<?> aClass) {
        RequestUtil.post(BaseApplication.getQueue(), url, tag,
                params, volleyListenerInterface, timeOutDefaultFlg, aClass);
    }

    public static void post(String url, Map<String, String> params, VolleyListenerInterface volleyListenerInterface, boolean timeOutDefaultFlg, Class<?> aClass) {
        post(url, "tag", params, volleyListenerInterface, timeOutDefaultFlg, aClass);
    }

    public static void post(String url, Map<String, String> params, VolleyListenerInterface volleyListenerInterface, Class<?> aClass) {
        post(url, "tag", params, volleyListenerInterface, true, aClass);
    }

    public static void post(String url, Map<String, String> params, VolleyListenerInterface volleyListenerInterface) {
        post(url, "tag", params, volleyListenerInterface, true, null);
    }


    /*
    * 通过ImageRequest来显示网络图片
    * */
    public static void setImageRequest(String url, final ImageView imageView, final int errorImageResId) {
        ImageUtil.setImageRequest(BaseApplication.getQueue(), url, imageView, errorImageResId);
    }

    /*
    * 通过ImageLoader来显示网络图片
    * */
    public static void setImageLoader(String url, ImageView imageView, int defaultImageResId, int errorImageResId) {
        ImageUtil.setImageLoader(BaseApplication.getQueue(), url, imageView, defaultImageResId, errorImageResId);
    }

    /*
    * 通过Volley的NetWorkImageView来显示网络图片
    * */
    public static void setNetWorkImageView(String url, NetworkImageView netWorkImageView, int defaultImageResId, int errorImageResId) {
        ImageUtil.setNetWorkImageView(BaseApplication.getQueue(), url, netWorkImageView, defaultImageResId, errorImageResId);
    }


    /*
     * 上传文件
     */
    public static void upFile(String url, Map<String, String[]> params, VolleyListenerInterface volleyListenerInterface) {
        BaseApplication.getQueue().add(new PostUploadRequest(url, params, volleyListenerInterface));
    }
}