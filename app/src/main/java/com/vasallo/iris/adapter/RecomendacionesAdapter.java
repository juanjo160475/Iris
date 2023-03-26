package com.vasallo.iris.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vasallo.iris.R;
import com.vasallo.iris.modelo.Recomendaciones;

import java.util.ArrayList;

public class RecomendacionesAdapter extends RecyclerView.Adapter<RecomendacionesAdapter.ViewHolder> {


    ArrayList<Recomendaciones> lista ;

    public RecomendacionesAdapter(ArrayList<Recomendaciones> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecomendacionesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recomendaciones,null,false);
        return new RecomendacionesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecomendacionesAdapter.ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
ImageView imageView ;
TextView nombreView,telefonoView,diagnosticoView,recomendacionView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.card_fotoDoc);
            nombreView=itemView.findViewById(R.id.cardApellido);
            telefonoView=itemView.findViewById(R.id.cardTelefono);
            diagnosticoView=itemView.findViewById(R.id.card_diag);
            recomendacionView=itemView.findViewById(R.id.card_recomendacion);
        }

        public void asignarDatos(Recomendaciones recomendaciones) {
            imageView.setImageResource(recomendaciones.getDoc());
            nombreView.setText(recomendaciones.getContacto());
            telefonoView.setText(recomendaciones.getTelefono());
            diagnosticoView.setText(recomendaciones.getDiagnostico());
            recomendacionView.setText(recomendaciones.getRecomendacion());

        }
    }
}
