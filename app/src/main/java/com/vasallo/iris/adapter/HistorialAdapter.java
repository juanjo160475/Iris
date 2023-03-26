package com.vasallo.iris.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vasallo.iris.R;
import com.vasallo.iris.modelo.Historial;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.ViewHolderDatos> {
ArrayList <Historial>lista ;

    public HistorialAdapter(ArrayList<Historial> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historial_list,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(lista.get(position), position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
      TextView itemVista, fechaVista, descripocionVista;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            itemVista= itemView.findViewById(R.id.item);
            fechaVista= itemView.findViewById(R.id.fecha);
            descripocionVista= itemView.findViewById(R.id.diagnostico);

        }

        public void asignarDatos(Historial list, int index) {
            itemVista.setText(""+(index+1));
            fechaVista.setText(list.getFecha());
            descripocionVista.setText(list.getDiagnostico());
        }
    }
}
