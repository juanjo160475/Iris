package com.vasallo.iris.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vasallo.iris.R;
import com.vasallo.iris.modelo.Historial;
import com.vasallo.iris.modelo.Prestadores;

import java.util.ArrayList;

public class PrestadoresAdapter extends RecyclerView.Adapter<PrestadoresAdapter.ViewHolder>{

    ArrayList<Prestadores> lista ;

    public PrestadoresAdapter(ArrayList<Prestadores> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PrestadoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_prestadores,null,false);
        return new PrestadoresAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrestadoresAdapter.ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position), position);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  especialidadVista ,centroVista, emailVista,telefonoVista;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           // itemVista= itemView.findViewById(R.id.item);
            especialidadVista= itemView.findViewById(R.id.especialidad);
            centroVista= itemView.findViewById(R.id.centroSalud);
            emailVista= itemView.findViewById(R.id.email);
            telefonoVista= itemView.findViewById(R.id.telefono);

        }

        public void asignarDatos(Prestadores prestadores, int position) {
            //itemVista.setText(""+(position+1));
            especialidadVista.setText(prestadores.getEspecialidad());
            centroVista.setText(prestadores.getCentroSalud());
            emailVista.setText(prestadores.getEmai());
            telefonoVista.setText(prestadores.getTelefono());
        }
    }
}
