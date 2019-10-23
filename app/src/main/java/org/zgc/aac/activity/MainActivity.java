package org.zgc.aac.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.zgc.aac.R;
import org.zgc.aac.activity.base.BaseActivity;
import org.zgc.aac.adapter.MenuAdapter;
import org.zgc.aac.adapter.decoration.CustomItemDecoration;
import org.zgc.aac.bean.entity.Menu;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMenu;

    private List<Menu> mMenuList = null;
    private MenuAdapter mMenuAdapter = null;

    private Bundle mBundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        rvMenu = findViewById(R.id.rv_menu);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));

        String[] titles = getResources().getStringArray(R.array.menu);
        mMenuList = new ArrayList<>();
        for (String s : titles) {
//            mMenuList.add(new Menu(new ObservableField(s)));
            mMenuList.add(new Menu(s));
        }
        mMenuAdapter = new MenuAdapter(this,mMenuList);
        mMenuAdapter.setOnItemClickListener((adapter, view, position) -> {
            mBundle.clear();
            mBundle.putString(BaseActivity.PARAM_TITLE, mMenuList.get(position).getName());
            switch (position) {
                case 0:
                    gotoActivity(ViewModelActivity.class, mBundle);
                    break;
            }
        });


        rvMenu.addItemDecoration(new CustomItemDecoration());
        rvMenu.setAdapter(mMenuAdapter);
    }

    protected void gotoActivity( Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}
