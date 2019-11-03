package de.uhd.ifi.pokemonmanager.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import de.uhd.ifi.pokemonmanager.R;
import de.uhd.ifi.pokemonmanager.adapter.*;

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


    private RecyclerView.LayoutManager createLayoutManager() {
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    private void setupList() {
        final List<Pokemon> data = createSampleData();
        final SimpleStringAdapter adapter = new SimpleStringAdapter(this, data);
        final LayoutManager manager = createLayoutManager();

        list.setLayoutManager(manager);
        list.setAdapter(adapter);
    }

    private static List<Pokemon> createSampleData() {
        List<Pokemon> data = new ArrayList<>();
        Pokemon p0 = new Pokemon("Bisasam", Type.POISON);
        Pokemon p1 = new Pokemon("Glumanda", Type.FIRE);
        Pokemon p2 = new Pokemon("Schiggy", Type.WATER);
        Pokemon p3 = new Pokemon("Raupy", Type.POISON);

        Trainer t1 = new Trainer("Marvin", "Schmitt");
        Trainer t2 = new Trainer("Stefan", "Radev");

        t1.addPokemon(p0);
        t1.addPokemon(p1);
        t2.addPokemon(p2);
        t2.addPokemon(p3);

        // Do some swap and competition
        p0.setSwapAllow(true);
        p2.setSwapAllow(true);
        Swap s1 = new Swap();
        s1.execute(p0,p2);

        Competition c1 = new Competition();
        c1.execute(p1, p3);

        data.add(p0);
        data.add(p1);
        data.add(p2);
        data.add(p3);

        return data;
    }

}