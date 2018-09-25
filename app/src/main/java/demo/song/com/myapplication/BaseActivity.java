package demo.song.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {
    protected final String TAG = this.getClass().getSimpleName();
    private LinearLayout contentLayout;
    private TextView title;
    private Button backButton;
    private Button moreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(R.layout.activity_base);
        contentLayout = findViewById(R.id.content_layout);
        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBack();
            }
        });
        title = findViewById(R.id.title);
        moreButton = findViewById(R.id.more);
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMore();
            }
        });
        initView();
        initData();
    }

    /**
     * 更多
     */
    protected void onMore() {
    }

    /**
     * 返回键
     */
    protected void onBack() {
    }

    @Override
    public void setContentView(View view) {
        contentLayout.addView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = View.inflate(this, layoutResID, null);
        setContentView(view);
    }

    /**
     * 是否全屏显示
     * @param isVisible
     */
    public void showWindowsTitle(boolean isVisible) {
        if (!isVisible) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

    /**
     * 设置标题
     * @param text
     */
    public void setTitle(CharSequence text) {
        title.setText(text);
    }

    /**
     * 设置标题
     * @param resid
     */
    public void setTitle(int resid) {
        title.setText(resid);
    }

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 界面跳转
     * @param packageContext
     * @param cls
     * @param extras
     */
    public void startActivity(Context packageContext, Class<?> cls, Bundle extras) {
        Intent intent = new Intent(packageContext, cls);
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
    }

}
