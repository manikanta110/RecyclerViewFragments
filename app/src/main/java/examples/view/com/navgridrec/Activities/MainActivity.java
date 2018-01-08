package examples.view.com.navgridrec.Activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import examples.view.com.navgridrec.Fragments.BlankFragment;
import examples.view.com.navgridrec.Fragments.BlankFragment1;
import examples.view.com.navgridrec.Fragments.BlankFragment2;
import examples.view.com.navgridrec.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager =(ViewPager)findViewById(R.id.viewpager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),MainActivity.this) ;
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_container);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i <tabLayout.getTabCount() ; i++) {
            TabLayout.Tab tab= tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    class  PagerAdapter extends FragmentPagerAdapter {

        String tabtitles[] = new String[]{"TOP","POP","UPC"};
        Context context;


        public PagerAdapter(FragmentManager fm, Context context) {

            super(fm);
            this.context = context;

        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return  new BlankFragment();
                case 1:
                    return  new BlankFragment1();
                case 2:
                    return new BlankFragment2();

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabtitles[position];
        }

        @Override
        public int getCount() {
            return tabtitles.length;

        }
        public View getTabView(int position){
            View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab,null);
            TextView textView =(TextView)view.findViewById(R.id.tab_text);
            textView.setText(tabtitles[position]);
            return view;
        }



    }
}
