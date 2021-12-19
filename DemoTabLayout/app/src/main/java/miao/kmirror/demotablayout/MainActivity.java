package miao.kmirror.demotablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import miao.kmirror.demotablayout.adapter.FragmentAdapter;
import miao.kmirror.demotablayout.fragment.ListFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = findViewById(R.id.viewpager);
        initViewPager();
        initNavigationView();
    }

    private void initNavigationView() {
        // 设置菜单按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = findViewById(R.id.dl_main_drawer);
        NavigationView navigationView = findViewById(R.id.nv_main_navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(item -> {
                // 设置点击后表示为选中状态
                item.setChecked(true);
                String title = item.getTitle().toString();
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                // 关闭导航菜单
                mDrawerLayout.closeDrawers();
                return true;
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {
        mTabLayout = findViewById(R.id.tabs);
        List<String> titles = new ArrayList<>();
        titles.add("Amirror");
        titles.add("Bmirror");
        titles.add("Cmirror");
        titles.add("Dmirror");
        titles.add("Emirror");
        titles.add("Fmirror");
        titles.add("Gmirror");
        titles.add("Hmirror");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListFragment());
        }
        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        // 给 ViewPager 设置适配器
        mViewPager.setAdapter(mFragmentAdapter);
        // 将 TabLayout 和 ViewPager 关联起来
        mTabLayout.setupWithViewPager(mViewPager);
        // 给 TabLayout 设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
    }
}