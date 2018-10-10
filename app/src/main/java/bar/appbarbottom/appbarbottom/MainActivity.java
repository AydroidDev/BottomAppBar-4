package bar.appbarbottom.appbarbottom;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
