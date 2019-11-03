package com.sradev.pokemonlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import data.*;
import ui.PokemonAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        setupList();
    }

    private LayoutManager createLayoutManager() {
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    private static List<Pokemon> createData() {
        // Creates data to populate the list

        // Create three pokemons
        Pokemon p1 = new Pokemon("Shiggy", Type.WATER);
        Pokemon p2 = new Pokemon("Rettan", Type.POISON);
        Pokemon p3 = new Pokemon("Giurak", Type.FIRE);

        // Create two trainers
        Trainer t1 = new Trainer("Alisa", "Traurig");
        Trainer t2 = new Trainer("Peter", "Lustig");

        t1.addPokemon(p1);
        t1.addPokemon(p2);
        t2.addPokemon(p3);

        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(p1);
        pokemons.add(p2);
        pokemons.add(p3);

        return pokemons;

    }

    private void setupList() {
        final List<Pokemon> data = createData();
        final PokemonAdapter adapter = new PokemonAdapter(this, data);
        final LayoutManager manager = createLayoutManager();

        list.setLayoutManager(manager);
        list.setAdapter(adapter);
    }
}
