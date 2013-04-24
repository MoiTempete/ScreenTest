
package com.kuyun.test.screentest;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

    private Button btn_test, btn_width, btn_height;

    private TextView tv_height, tv_width, tv_value;

    private RelativeLayout test_view;

    private int width = 0, height = 0;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_test = (Button) findViewById(R.id.btn_test);
        btn_height = (Button) findViewById(R.id.btn_draw_height);
        btn_width = (Button) findViewById(R.id.btn_draw_width);
        tv_height = (TextView) findViewById(R.id.tv_height);
        tv_width = (TextView) findViewById(R.id.tv_width);
        tv_value = (TextView) findViewById(R.id.tv_value);
        test_view = (RelativeLayout) findViewById(R.id.test_view);
        mToast = new Toast(this);

        btn_test.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                height = getDisplayHeight(MainActivity.this);
                width = getDisplayWidth(MainActivity.this);
                tv_height.setText("getDisplayHeight: " + height);
                tv_width.setText("getDisplayWidth: " + width);
            }
        });

        btn_height.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawWithValue(false);
            }
        });

        btn_width.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawWithValue(true);
            }
        });
    }

    private void drawWithValue(boolean isWidth) {
        int drawWidth = 100;
        int drawHeight = 100;
        String editValue = tv_value.getText().toString();
        int value = Integer.parseInt(editValue);
        if (isWidth) {
            drawWidth = value;
        } else {
            drawHeight = value;
        }
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(drawWidth, drawHeight);
        test_view.setLayoutParams(lp);
    }

    /**
     * 获取手机分辨率的高度
     * 
     * @param activity
     * @return
     */
    public static int getDisplayHeight(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        return display.getHeight();
    }

    /**
     * 获取手机分辨率的宽度
     * 
     * @param activity
     * @return
     */
    public static int getDisplayWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        return display.getWidth();
    }
}
