package com.example.gameover;


import info.androidhive.slidingmenu.R;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Allan
 *
 */
public class MainActivity extends Activity {

	private TableLayout tableau;
	private ListView list;
	private CocktailAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//layout.activity_main.xml définit l'interface graphique
		
		list = (ListView) findViewById(R.id.list);
		
		ArrayList<Cocktail> liste = new ArrayList<Cocktail>();
		
		liste.add(new Cocktail(R.raw.genkidama, "Genkidama", "Redbull\nTequila\nCuraçao bleu", false));
		liste.add(new Cocktail(R.raw.mojo, "Mojo", "Rhum ambré - Perrier\nCitron vert - feuilles de menthe\nSucre roux - sirop de citron vert", false));
		liste.add(new Cocktail(R.raw.pinkmojo, "Pink Mojo", "Porto rosé\nSucre roux - Citron vert\nFeuilles de menthe - Perrier", false));
		liste.add(new Cocktail(R.raw.solari, "Solari", "Vodka - Liqueur de litchi\nSirop de sucre de canne - Sirop de grenadine\nSirop de citron vert\nJus d'orange", false));
		liste.add(new Cocktail(R.raw.subzero, "Sub Zéro", "Rhum blanc - Curaçao bleu\nJus d'ananas - Lait de coco", false));
		liste.add(new Cocktail(R.raw.kerrigan, "Kerrigan", "Rhum ambré - Sucre roux\nCrème de mûre - Citron vert\nLiqueur de violette\nFeuilles de menthe", false));
		liste.add(new Cocktail(R.raw.age, "Cocktail du 5ème âge", "Rhum blanc - Citron vert\nSirop de grenadine\nLiqueur de cerise", false));
		liste.add(new Cocktail(R.raw.morphling, "Morphling", "Lait de coco - Martini blanc\nCuraçao bleu - Jus d'ananas", false));
		liste.add(new Cocktail(R.raw.glados, "Glados", "Rhum ambré - Rhum blanc\nJus d'ananas - Lait de coco", false));
		liste.add(new Cocktail(R.raw.zelda, "Princesse Zelda", "Gin\nSchweppes tonic\nLiqueur de violette", false));
		liste.add(new Cocktail(R.raw.valentine, "Vincent Valentine", "Crème de pêche - Vodka\nJus d'orange - Liqueur de fraise", false));
		liste.add(new Cocktail(R.raw.altair, "Altair", "Lait\nVodka\nLiqueur de café", false));
		
		adapter = new CocktailAdapter(this, android.R.layout.simple_list_item_1, liste, this);
	    list.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
