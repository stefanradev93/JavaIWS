package de.uhd.ifi.pokemonmanager.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.Arrays;
import java.util.List;

import android.os.Bundle;

import de.uhd.ifi.pokemonmanager.R;
import de.uhd.ifi.pokemonmanager.adapter.SimpleStringAdapter;

import de.uhd.ifi.pokemonmanager.data.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        setupList();
    }


    private static List<String> createSampleData() {
        Pokemon p = new Pokemon("Schiggy", Type.WATER);
        Trainer t = new Trainer("Alisa", "Traurig");
        t.addPokemon(p);
        final String sample = p.getName() + p.getType() + "#" + p.getNumber() +
                p.getTrainer() + "Swaps: " + p.getSwaps().size() + "Competitions: " + p.getCompetitions().size();
        final String[] words = sample.split(" ");
        return Arrays.asList(words);
    }

    private RecyclerView.LayoutManager createLayoutManager() {
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    private void setupList() {
        final List<String> data = createSampleData();
        final SimpleStringAdapter adapter = new SimpleStringAdapter(this, data);
        final LayoutManager manager = createLayoutManager();

        list.setLayoutManager(manager);
        list.setAdapter(adapter);
    }

}