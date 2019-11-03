package de.uhd.ifi.pokemonmanager.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.uhd.ifi.pokemonmanager.R;
import de.uhd.ifi.pokemonmanager.data.Pokemon;

public class SimpleStringHolder extends RecyclerView.ViewHolder {

    private final TextView textViewName;
    private final TextView textViewType;
    private final TextView textViewNumber;
    private final TextView textViewTrainer;
    private final TextView textViewSwaps;
    private final TextView textViewCompetitions;


    public SimpleStringHolder(@NonNull final View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewType = itemView.findViewById(R.id.textViewType);
        textViewNumber = itemView.findViewById(R.id.textViewNumber);
        textViewTrainer = itemView.findViewById(R.id.textViewTrainer);
        textViewSwaps = itemView.findViewById(R.id.textViewSwaps);
        textViewCompetitions = itemView.findViewById(R.id.textViewCompetitions);
        itemView.setTag(this);
    }

    public void setText(final Pokemon p) {

        this.textViewName.setText(p.getName());
        this.textViewType.setText(p.getType().toString());
        this.textViewNumber.setText("#"+p.getNumber());
        this.textViewTrainer.setText(p.getTrainer().toString());
        this.textViewSwaps.setText("Swaps: " + p.getSwaps().size());
        this.textViewCompetitions.setText("Competitions: " + p.getCompetitions().size());
    }
}