package mx.blogspot.juanmtejedav.mascotasmenufragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragments.Adaptadores.MascotaAdaptador;
import mx.blogspot.juanmtejedav.mascotasmenufragments.Fragments.RecyclerViewFragment;
import mx.blogspot.juanmtejedav.mascotasmenufragments.POJO.Mascota;

/**
 * Created by juantejeda1 on 06/08/16.
 */
public class MascotasFav extends AppCompatActivity {

    ArrayList<Mascota> mascotasFav;
    Toolbar miActionBar;
    private RecyclerView listaMascotasFav;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_fav);

       toolbar(miActionBar);

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);

        layoutSetting();

        inicializarVistasFav();

        inicializarAdaptador();
    }

    public void layoutSetting(){
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    public void inicializarVistasFav(){
        mascotasFav=new ArrayList<Mascota>();
        for (Mascota mascota: RecyclerViewFragment.mascotas){
            if(mascota.getLikes()>0){
                mascotasFav.add(mascota);
            }
        }
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotasFav);
        listaMascotasFav.setAdapter(adapter);
    }


    public void toolbar(Toolbar miActionBar) {
        miActionBar = (Toolbar) findViewById(R.id.toolB2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}

