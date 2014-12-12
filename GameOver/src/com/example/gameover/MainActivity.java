package com.example.gameover;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.TextureView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TableLayout tableau;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tableau = (TableLayout) findViewById(R.id.tableau);

		creerSousTitre(R.raw.cocktails);
		
		creerElement( R.raw.genkidama, "Genkidama", false);
		creerElement( R.raw.mojo, "Mojo", false);
		creerElement(R.raw.pinkmojo, "Pink Mojo", false);
		creerElement( R.raw.solari, "Solaris", true);
		creerElement(R.raw.subzero, "Sub Zéro", false);
		creerElement(R.raw.kerrigan, "Kerrigan", false);
		creerElement( R.raw.kirby, "Kirby", false);
		creerElement(R.raw.age, "5eme age", false);
		creerElement( R.raw.altair, "Altair", true);
		creerElement(R.raw.glados, "Glados", false);
		creerElement(R.raw.zelda, "Princesse Zélda", false);
		creerElement(R.raw.morphling, "Morphing", false);
		creerElement(R.raw.valentine, "Vincent Valentine", false);
		
		creerSousTitre(R.raw.shooters);
		
		creerElement(R.raw.bomberman, "Bomber Man", false);
		creerElement(R.raw.gameover, "Game over", false);
		creerElement(R.raw.bloodybrain, "Bloody brain", false);
		creerElement(R.raw.random, "Random Pick", false);
		creerElement(R.raw.baneling, "Baneling", false);
		creerElement(R.raw.rainbow, "Rainbow Dash", false);
		
	}

	private void creerElement(int r_raw, String nom, boolean coche){
		
		ImageView image = new ImageView(this);
		image.setImageResource(r_raw);
		image.setLayoutParams(new TableRow.LayoutParams(
				TableRow.LayoutParams.WRAP_CONTENT,
				100));
		
		TextView texte = new TextView(this);
		texte.setLayoutParams(new TableRow.LayoutParams(
				265,
				TableRow.LayoutParams.WRAP_CONTENT));
		texte.setText(nom);
		texte.setTextColor(Color.WHITE);
		texte.setTextSize(30);
		
		CheckBox box = new CheckBox(this);
		box.setLayoutParams(new TableRow.LayoutParams(
				TableRow.LayoutParams.WRAP_CONTENT,
				TableRow.LayoutParams.WRAP_CONTENT));
		box.setChecked(coche);
		
		TableRow ligne = new TableRow(this);
		ligne.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
		ligne.setGravity(Gravity.CENTER);
		ligne.setPadding(0, 10, 0, 10);
		
		ligne.addView(image);
		ligne.addView(texte);
		ligne.addView(box);
		
		tableau.addView(ligne);
	}
	
	private void creerSousTitre(int r_raw){
		
		TableRow.LayoutParams params = new TableRow.LayoutParams(
				TableRow.LayoutParams.MATCH_PARENT,
				TableRow.LayoutParams.WRAP_CONTENT);
		params.span = 3;
		
		ImageView image = new ImageView(this);
		image.setImageResource(r_raw);
		image.setLayoutParams(params);
		
		
		TableRow ligne = new TableRow(this);
		ligne.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
		ligne.setGravity(Gravity.CENTER);
		ligne.setPadding(0, 50, 0, 10);
		
		ligne.addView(image);
		tableau.addView(ligne);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
