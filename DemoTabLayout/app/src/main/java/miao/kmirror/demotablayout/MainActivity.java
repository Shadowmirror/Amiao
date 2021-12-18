package miao.kmirror.demotablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

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