package com.example.mastext;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mastext.activity.AboutActivity;
import com.example.mastext.activity.SettingActivity;
import com.example.mastext.activity.WebViewActivity;
import com.example.mastext.fragment.DynamicFragment;
import com.example.mastext.fragment.FragmentAdapter;
import com.example.mastext.fragment.InformationFragment;
import com.example.mastext.fragment.LinkmanFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private LinearLayout mLl;
    private NavigationView mNv;
    private Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mNv = (NavigationView) findViewById(R.id.nv);
        mTv = findViewById(R.id.tv);

        mToolbar.setTitle("");

        setSupportActionBar(mToolbar);

        mNv.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();


        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                menuItem.setChecked(true);
                mDrawer.closeDrawer(Gravity.LEFT);

                switch (itemId) {
                    case R.id.github_menu:
                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.csdn_menu:
                        Intent intent1 = new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.jianshu_menu:
                        Intent intent2 = new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.github_io_menu:
                        Intent intent3 = new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.setting_menu:
                        Intent intent4 = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.about_menu:
                        Intent intent5 = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent5);
                        break;
                    case R.id.clear_menu:

                        break;
                }
                return false;
            }
        });


        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InformationFragment());
        fragments.add(new LinkmanFragment());
        fragments.add(new DynamicFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("消息").setIcon(R.drawable.a);
        mTab.getTabAt(1).setText("联系人").setIcon(R.drawable.b);
        mTab.getTabAt(2).setText("动态").setIcon(R.drawable.c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "创建群组");
        menu.add(2, 2, 2, "添加好友/群");
        return super.onCreateOptionsMenu(menu);
    }
}
