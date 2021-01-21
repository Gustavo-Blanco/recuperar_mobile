package pe.edu.tecsup.superheroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.superheroes.R;
import pe.edu.tecsup.superheroes.model.Heroe;

public class HeroeAdapter extends RecyclerView.Adapter<HeroeAdapter.HeroeViewHolder>{

    private OnHeroeClickListener heroeClickListener;
    private List<Heroe> listaHeroes;

    public interface OnHeroeClickListener {
        void onClick(int posicion);
    }

    public HeroeAdapter(List<Heroe> listaHeroes, OnHeroeClickListener heroeClickListener) {
        this.listaHeroes = listaHeroes;
        this.heroeClickListener = heroeClickListener;
    }

    //Clase estática

    static class HeroeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHeroe;
        private TextView txtHeroe, txtNombre, txtEmpresa;

        public HeroeViewHolder(@NonNull View itemView, final OnHeroeClickListener heroeClickListenner) {
            super(itemView);
            this.imgHeroe = itemView.findViewById(R.id.imgHeroe);
            this.txtHeroe = itemView.findViewById(R.id.txtHeroe);
            this.txtNombre = itemView.findViewById(R.id.txtNombre);
            this.txtEmpresa = itemView.findViewById(R.id.txtEmpresa);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (heroeClickListenner != null){
                        int posicion = getAdapterPosition();
                        if(posicion != RecyclerView.NO_POSITION){
                            heroeClickListenner.onClick(posicion);
                        }
                    }
                }
            });
        }

        public void bindHeroe(Heroe heroe){
            imgHeroe.setImageResource(heroe.getIdImagen());
            txtHeroe.setText(heroe.getHeroe());
            txtNombre.setText(heroe.getNombre());
            txtEmpresa.setText(heroe.getEmpresa());
        }
    }

    @NonNull
    @Override
    public HeroeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemHeroe = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroe, parent, false);
        //parent => el recyclerView
        return new HeroeViewHolder(itemHeroe, heroeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroeViewHolder holder, int position) {
        holder.bindHeroe(listaHeroes.get(position));
    }

    @Override
    public int getItemCount() {
        return listaHeroes.size();
    }

    public List<Heroe> getListaHeroes() {
        return listaHeroes;
    }
}
