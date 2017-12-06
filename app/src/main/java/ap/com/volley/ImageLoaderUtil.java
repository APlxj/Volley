package ap.com.volley;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class ImageLoaderUtil {
    /*
    * 通过ImageRequest来显示网络图片
    * */
    public static void setImageRequest(String url, final ImageView imageView) {
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                imageView.setBackgroundResource(R.mipmap.ic_launcher);
            }
        });
        BaseApplication.getQueue().add(imageRequest);
    }

    /*
    * 通过ImageLoader来显示网络图片
    * */
    public static void setImageLoader(String url, ImageView imageView, int defaultImageResId, int errorImageResId) {
        ImageLoader loader = new ImageLoader(BaseApplication.getQueue(), new BitmapCache());
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, defaultImageResId, errorImageResId);
        loader.get(url, imageListener);
    }

    /*
    * 通过Volley的NetWorkImageView来显示网络图片
    * */
    public static void setNetWorkImageView(String url, NetworkImageView netWorkImageView, int defaultImageResId, int errorImageResId) {
        ImageLoader loader = new ImageLoader(BaseApplication.getQueue(), new BitmapCache());

        netWorkImageView.setDefaultImageResId(defaultImageResId);
        netWorkImageView.setErrorImageResId(errorImageResId);
        netWorkImageView.setImageUrl(url, loader);
    }
}
