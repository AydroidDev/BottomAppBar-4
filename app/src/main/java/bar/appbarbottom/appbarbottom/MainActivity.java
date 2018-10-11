package bar.appbarbottom.appbarbottom;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
        }

        BottomAppBar bar = (BottomAppBar) findViewById(R.id.app_bar);
        setSupportActionBar(bar);

//        bar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle the navigation click by showing a BottomDrawer etc.
//            }
//        });
    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.fab:
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new OneFragment()).commit();
        break;


//    MainActivity.fragmentManager.beginTransaction()
//            .replace(R.id.fragment_container,  weekClosed)
//            .addToBackStack(null)
//            .commit();
}
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.app_bar_fav:
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new OneFragment()).commit();
                return true;
            case R.id.app_bar_search:

                return true;
            case R.id.app_bar_settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottomappbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
