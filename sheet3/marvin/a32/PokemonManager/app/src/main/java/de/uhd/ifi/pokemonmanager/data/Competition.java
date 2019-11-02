package de.uhd.ifi.pokemonmanager.data;


import java.util.Date;

public class Competition extends Swap {

    private Trainer winnerTrainer;

    @Override
    public void execute(Pokemon sourcePokemon, Pokemon targetPokemon){
        if (sourcePokemon.getTrainer() != targetPokemon.getTrainer()) {
            // swapping is allowed
            // store Pokemons and Trainers in the competition
            this.sourcePokemon = sourcePokemon;
            this.targetPokemon = targetPokemon;
            this.sourceTrainer = sourcePokemon.getTrainer();
            this.targetTrainer = targetPokemon.getTrainer();
            this.date = new Date();
            this.id = "" + System.currentTimeMillis();
            // remove the Pokemons from the Trainers
            this.sourceTrainer.getPokemons().remove(sourcePokemon);
            this.targetTrainer.getPokemons().remove(targetPokemon);

            // Determine the winner
            double sourceScore = java.lang.Math.random() + sourcePokemon.getType().toScore();
            double targetScore = java.lang.Math.random() + targetPokemon.getType().toScore();

            System.out.println(sourceTrainer + " with " + sourcePokemon.getName() + ": " + sourceScore);
            System.out.println(targetTrainer + " with " + targetPokemon.getName() + ": " + targetScore);

            this.winnerTrainer = (sourceScore > targetScore ? sourceTrainer : targetTrainer);

            System.out.println("Winner is " + winnerTrainer);

            // reassign the Pokemons to the winning trainer
            this.winnerTrainer.addPokemon(targetPokemon);
            this.winnerTrainer.addPokemon(sourcePokemon);
            // store the Swap in Pokemons Swap history
            sourcePokemon.addCompetition(this);
            targetPokemon.addCompetition(this);

        }
        else {
            System.err.printf("No Competition: Trainers '%s' == '%s' are identical!%n", sourcePokemon.getTrainer(),
                    targetPokemon.getTrainer());
        }

    }


}
