package mx.blogspot.juanmtejedav.mascotasmenufragments.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragments.POJO.Mascota;
import mx.blogspot.juanmtejedav.mascotasmenufragments.R;

/**
 * Created by juantejeda1 on 12/08/16.
 */
public class MascotaAdaptadorGrid extends RecyclerView.Adapter<MascotaAdaptadorGrid.MascotaVHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdaptadorGrid(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_mascota_grid, parent, false);
        return new MascotaVHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaVHolder mascotaVHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaVHolder.fotoPet.setImageResource(mascota.getFoto());
        mascotaVHolder.likesPet.setText("" + mascota.getLikes());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaVHolder extends RecyclerView.ViewHolder {
        ImageView fotoPet;
        TextView likesPet;

        public MascotaVHolder(View itemView) {
            super(itemView);
            fotoPet = (ImageView) itemView.findViewById(R.id.ivGridFotoPet);
            likesPet = (TextView) itemView.findViewById(R.id.tvGridLikesPet);
        }
    }
}
