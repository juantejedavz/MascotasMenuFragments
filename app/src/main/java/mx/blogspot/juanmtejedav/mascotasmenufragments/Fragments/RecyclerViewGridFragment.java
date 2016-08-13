package mx.blogspot.juanmtejedav.mascotasmenufragments.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragments.Adaptadores.MascotaAdaptadorGrid;
import mx.blogspot.juanmtejedav.mascotasmenufragments.POJO.Mascota;
import mx.blogspot.juanmtejedav.mascotasmenufragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewGridFragment extends Fragment {

    public static MascotaAdaptadorGrid mascotaAdaptador;
    private ArrayList<Mascota> mascotasGrid;
    private RecyclerView rvGridMascotas;
    private ImageView imgSnowball;
    private LinearLayoutManager llm;

    public RecyclerViewGridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view_grid, container, false);

        rvGridMascotas = (RecyclerView) v.findViewById(R.id.rvGridMascotas);

        layoutSetting();

        inicializarDatos();

        inicializarAdaptador();

        return v;
    }

    public void inicializarDatos() {
        mascotasGrid = new ArrayList<Mascota>();
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s, 3));
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s2, 9));
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s3, 4));
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s4, 22));
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s5, 20));
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s6, 30));
        mascotasGrid.add(new Mascota("Snowball", R.drawable.s7, 12));
    }

    private void inicializarAdaptador() {
        mascotaAdaptador = new MascotaAdaptadorGrid(mascotasGrid);
        rvGridMascotas.setAdapter(mascotaAdaptador);
    }

    public void layoutSetting() {
        llm = new GridLayoutManager(getActivity(), 3);
        rvGridMascotas.setLayoutManager(llm);
    }

}
