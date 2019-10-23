package org.zgc.aac.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;

import org.apache.commons.lang3.StringUtils;
import org.zgc.aac.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author:Nick
 * Time2018/7/2 11:29
 * Description
 */
public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    private ImmersionBar mImmersionBar;

    protected B binding;

    protected Toolbar mToolbar;

    public final static String PARAM_TITLE = "param_title";

//    private CompositeSubscription mCompositeSubscription;

    private CompositeDisposable mCompositeDisposable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏

        super.onCreate(savedInstanceState);
//        setContentView(provideContentViewId());

        binding = DataBindingUtil.setContentView(this, provideContentViewId());

        mToolbar = findViewById(R.id.toolbar);
        if (StringUtils.isNotEmpty(getIntent().getStringExtra(PARAM_TITLE)) && mToolbar != null) {
            mToolbar.setTitle(getIntent().getStringExtra(PARAM_TITLE));
        }

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.transparentStatusBar()
                .fitsSystemWindows(false)
                .statusBarColor(provideStatusBarColor())
                .statusBarDarkFont(provideStatusBarTextStyle())
                .init();   //所有子类都将继承这些相同的属性


        initView();
        initData();
    }

    /**
     * 提供状态栏颜色
     *
     * @return
     */
    protected int provideStatusBarColor() {
        return android.R.color.white;
    }

    /**
     * 状态栏字体是深色，不写默认为亮色
     *
     * @return
     */
    protected boolean provideStatusBarTextStyle() {
        return true;
    }

    /**
     * 提供布局xml
     *
     * @return
     */
    protected abstract int provideContentViewId();

    /**
     * 初始化UI
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    public void addDisposable(Disposable disposableObserver) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(disposableObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
        if (mImmersionBar != null) {
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
    }

    protected void gotoActivity(Class<? extends Activity> activity) {
        gotoActivity(activity, null);
    }

    protected void gotoActivity(Context context, Class<? extends Activity> activity) {
        gotoActivity(context, activity, null);
    }

    protected void gotoActivity(Class<? extends Activity> activity, Bundle bundle) {
        gotoActivity(this, activity, bundle);
    }

    protected void gotoActivity(Context context, Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    protected void gotoActivityForRequest(int requestCode, Class<? extends Activity> activity) {
        gotoActivityForRequest(requestCode, activity, null);
    }

    protected void gotoActivityForRequest(int requestCode, Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    protected void replaceFragment(int layout, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(layout, fragment);
        transaction.commit();
    }

}
