package org.zgc.aac.activity;

import android.view.View;

import org.zgc.aac.R;
import org.zgc.aac.activity.base.BaseActivity;
import org.zgc.aac.bean.entity.User;
import org.zgc.aac.databinding.ActivityViewModelBinding;

import androidx.databinding.ObservableField;

/**
 * Author: ZGC
 * Time: 2019/10/21 9:28
 * Description:
 */
public class ViewModelActivity extends BaseActivity<ActivityViewModelBinding> {
    private User user = null;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_view_model;
    }

    @Override
    protected void initView() {
        user = new User();
        user.setName(new ObservableField<>("ZGC"));
        user.setIntro(new ObservableField<>("这个人很懒，什么也没写!"));
        binding.setUser(user);

        ViewModelActivity.Action viewModelAction = new ViewModelActivity.Action();
        binding.setAction(viewModelAction);
    }

    @Override
    public void initData() {

    }

    public class Action {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_click:
                    user.getName().set(user.getName().get() + "靓仔");
                    break;
            }
        }
    }
}
