package ap.com.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    NetworkImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        iv = (NetworkImageView) findViewById(R.id.iv);
        /*VolleyRequestUtil.get("http://www.yingqianpos.com/yunpos/vol/sync/operator/ValidateOper.form?" +
                        "OperPw=f6634250652bcb4f" +
                        "&HashCode=bed1b1ff9e7d50948941316116a825c3d9f6f9de109feb78bc0fe2c84becf4077fa4e3c08b6295ee" +
                        "&OperId=18300070007" +
                        "&LoginIP=10.0.4.15" +
                        "&VersionCode=R1.4.3"
                , new VolleyListenerInterface() {

                    @Override
                    public void onSuccess(Object result) {
                        BaseEntry entry = (BaseEntry) result;
                        tv.setText(entry.toString());
                    }

                    @Override
                    public void onError(Exception error) {

                    }

                }, BaseEntry.class);*/

        /*Map<String, String> map = new HashMap<>();
        map.put("OperPw", "f6634250652bcb4f");
        map.put("HashCode", "bed1b1ff9e7d50948941316116a825c3d9f6f9de109feb78bc0fe2c84becf4077fa4e3c08b6295ee");
        map.put("LoginIP", "10.0.4.15");
        map.put("OperId", "18300070007");
        map.put("VersionCode", "R1.4.3");
        VolleyRequestUtil.post("http://www.yingqianpos.com/yunpos/vol/sync/operator/ValidateOper.form?"
                , map, new VolleyListenerInterface() {
                    @Override
                    public void onSuccess(Object result) {
                        BaseEntry entry = (BaseEntry) result;
                        tv.setText(entry.toString());
                    }

                    @Override
                    public void onError(Exception error) {

                    }
                }, BaseEntry.class);*/

        //ImageLoaderUtil.setImageRequest("http://a.hiphotos.baidu.com/image/pic/item/21a4462309f7905298e546f405f3d7ca7acbd505.jpg", iv);

        VolleyUtil.setNetWorkImageView("http://a.hiphotos.baidu.com/image/pic/item/21a4462309f7905298e546f405f3d7ca7acbd505.jpg"
                , iv, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
    }
}
