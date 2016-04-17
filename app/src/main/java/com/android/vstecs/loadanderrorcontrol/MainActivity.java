package com.android.vstecs.loadanderrorcontrol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.android.vstecs.loadlib.VaryViewHelperController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_load,btn_error,btn_show;
    private TextView tv_show;
    private View layout_content;

    private VaryViewHelperController mVaryViewHelperController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_load = (Button) findViewById(R.id.btn_load);
        btn_error = (Button) findViewById(R.id.btn_error);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_load.setOnClickListener(this);
        btn_error.setOnClickListener(this);
        btn_show.setOnClickListener(this);

        tv_show = (TextView) findViewById(R.id.tv_show);
        layout_content = findViewById(R.id.layout_content);
        mVaryViewHelperController = new VaryViewHelperController(layout_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_load:
                toggleShowLoading(true,"");
                break;
            case R.id.btn_error:
                toggleNetworkError(true,null);
                break;
            case R.id.btn_show:
                toggleShowLoading(false,"");
                tv_show.setText("这些是数据@!@@");
                break;
        }
    }

    /**
     * toggle show common_over_loading
     *
     * @param toggle
     */
    protected void toggleShowLoading(boolean toggle, String msg) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for common_over_loading");
        }

        if (toggle) {
            mVaryViewHelperController.showLoading(msg);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show empty
     *
     * @param toggle
     */
    protected void toggleShowEmpty(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for common_over_loading");
        }

        if (toggle) {
            mVaryViewHelperController.showEmpty(msg, onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show error
     *
     * @param toggle
     */
    protected void toggleShowError(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for common_over_loading");
        }

        if (toggle) {
            mVaryViewHelperController.showError(msg, onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show network error
     *
     * @param toggle
     */
    protected void toggleNetworkError(boolean toggle, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for common_over_loading");
        }

        if (toggle) {
            mVaryViewHelperController.showNetworkError(onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }
}
