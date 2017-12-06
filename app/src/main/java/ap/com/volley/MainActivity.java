package ap.com.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.utils.BaseEntry;
import com.android.volley.utils.VolleyListenerInterface;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        VolleyRequestUtil.get("http://www.yingqianpos.com/yunpos/vol/sync/operator/ValidateOper.form?" +
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

                }, BaseEntry.class);
    }
}
