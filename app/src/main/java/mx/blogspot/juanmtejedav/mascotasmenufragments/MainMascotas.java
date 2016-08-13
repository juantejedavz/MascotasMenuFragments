package mx.blogspot.juanmtejedav.mascotasmenufragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragments.Adaptadores.PageAdaptador;
import mx.blogspot.juanmtejedav.mascotasmenufragments.ExtraActivities.AcercaDeActivity;
import mx.blogspot.juanmtejedav.mascotasmenufragments.ExtraActivities.ContactoActivity;
import mx.blogspot.juanmtejedav.mascotasmenufragments.Fragments.RecyclerViewFragment;
import mx.blogspot.juanmtejedav.mascotasmenufragments.Fragments.RecyclerViewGridFragment;

public class MainMascotas extends AppCompatActivity {

    ArrayList<Fragment> fragments;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mascotas);

        initViewIds();

        setUpViewPager();

        fragments = agregarFragments();
        //  fragments.get(0).getActivity().findViewById(R.id.)

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    private void initViewIds() {
        toolbar = (Toolbar) findViewById(R.id.toolB1);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewGridFragment());
        return fragments;
    }

    public void setUpViewPager() {
        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //Añade iconos a tu tab layout para cada fragment
        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menAcerca:
                Intent i1 = new Intent(MainMascotas.this, AcercaDeActivity.class);
                startActivity(i1);
                break;
            case R.id.menContacto:
                Intent i2 = new Intent(MainMascotas.this, ContactoActivity.class);
                startActivity(i2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


        public void clickEstrella(View v){
            Intent i = new Intent(MainMascotas.this, MascotasFav.class);
            startActivity(i);
        }

}
