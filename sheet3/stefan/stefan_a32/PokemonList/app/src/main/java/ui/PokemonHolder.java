package ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.sradev.pokemonlist.R;

import data.Pokemon;

class PokemonHolder extends ViewHolder {

    private final TextView firstStringView;
    private final TextView secondStringView;
    private final TextView thirdStringView;

    public PokemonHolder(@NonNull final View itemView) {
        super(itemView);
        firstStringView = itemView.findViewById(R.id.firstString);
        secondStringView = itemView.findViewById(R.id.secondString);
        thirdStringView = itemView.findViewById(R.id.thirdString);
        itemView.setTag(this);
    }

    public void setText(final Pokemon p) {

        // Very ugly
        firstStringView.setText(p.getName() + "\n" + p.getTrainerName());
        secondStringView.setText(p.getType().name() + "\n# Swaps: " + p.getNumSwaps());
        thirdStringView.setText("#" + p.getNumber() + "\n# Competitions: " + p.getNumCompetitions());
    }
}
