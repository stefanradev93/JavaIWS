package ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.sradev.pokemonlist.R;

import java.util.List;

import data.Pokemon;

public class PokemonAdapter extends Adapter<PokemonHolder> {
    private LayoutInflater inflater;
    private List<Pokemon> originalData;

    public PokemonAdapter(final Context context, final List<Pokemon> originalData) {
        this.inflater = LayoutInflater.from(context);
        this.originalData = originalData;
    }

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonHolder(inflater.inflate(R.layout.listitem_pokemon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonHolder holder, int position) {
        holder.setText(originalData.get(position));
    }

    @Override
    public int getItemCount() {
        return originalData.size();
    }
}
