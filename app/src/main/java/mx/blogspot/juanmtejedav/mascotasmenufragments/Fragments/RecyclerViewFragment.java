package mx.blogspot.juanmtejedav.mascotasmenufragments.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragments.Adaptadores.MascotaAdaptador;
import mx.blogspot.juanmtejedav.mascotasmenufragments.POJO.Mascota;
import mx.blogspot.juanmtejedav.mascotasmenufragments.R;

public class RecyclerViewFragment extends Fragment {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public MascotaAdaptador mascotaAdaptador;
    private LinearLayoutManager llm;

    public RecyclerViewFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        layoutSetting();

        inicializarDatos();

        inicializarAdaptador();

        return v;
    }

    public void inicializarDatos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(getResources().getString(R.string.duke), R.drawable.duke, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.max), R.drawable.max, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.mel), R.drawable.mel, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.sal), R.drawable.salchicha, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.snow), R.drawable.snowball, 0));}

    private void inicializarAdaptador(){
        mascotaAdaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(mascotaAdaptador);
    }

    public void layoutSetting(){
        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }
}
