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

/**
 * @author Allan
 *
 */
public class MainActivity extends Activity {

	private TableLayout tableau;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//layout.activity_main.xml d�finit l'interface graphique
		
		tableau = (TableLayout) findViewById(R.id.tableau);//r�cup�ration du tableau d�finit dans le xml

		creerSousTitre(R.raw.cocktails);//R.raw.cocktails r�f�rence une image qui est contenu dans le dossier res/raw
		
		creerElement( R.raw.genkidama, "Genkidama", false);
		creerElement( R.raw.mojo, "Mojo", false);
		creerElement(R.raw.pinkmojo, "Pink Mojo", false);
		creerElement( R.raw.solari, "Solaris", true);
		creerElement(R.raw.subzero, "Sub Z�ro", false);
		creerElement(R.raw.kerrigan, "Kerrigan", false);
		creerElement( R.raw.kirby, "Kirby", false);
		creerElement(R.raw.age, "5eme age", false);
		creerElement( R.raw.altair, "Altair", true);
		creerElement(R.raw.glados, "Glados", false);
		creerElement(R.raw.zelda, "Princesse Z�lda", false);
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

	/**Permet d'ajouter une nouvelle ligne 
	 * @param r_raw L'image de la boisson. Cette image doit �tre dans le dossier res/raw, et est r�f�renc� grace � R.raw.nomImage
	 * @param nom Le nom de la boisson qui sera affich�
	 * @param coche true si la boisson a d�ja �t� test�
	 */
	private void creerElement(int r_raw, String nom, boolean coche){
		
		//cr�ation d'une imageView
		ImageView image = new ImageView(this);
		image.setImageResource(r_raw);//d�finition de l'image source
		image.setLayoutParams(new TableRow.LayoutParams(
				TableRow.LayoutParams.WRAP_CONTENT,
				100));//l'image occupera autant de place que besoin horizontalement, et 100dp verticalement
		
		//cr�ation d'un textView
		TextView texte = new TextView(this);
		texte.setLayoutParams(new TableRow.LayoutParams(
				265,
				TableRow.LayoutParams.WRAP_CONTENT));//il occupera 265dp de large et autant de place qu'il en a besoin verticalement(permet les retours � la ligne)
		texte.setText(nom);//attribution du texte � �crire
		texte.setTextColor(Color.WHITE);//d�finition de la couleur du texte
		texte.setTextSize(30);//d�finition de la taille du texte
		
		//cr�ation d'une checkBox
		CheckBox box = new CheckBox(this);
		box.setLayoutParams(new TableRow.LayoutParams(
				TableRow.LayoutParams.WRAP_CONTENT,
				TableRow.LayoutParams.WRAP_CONTENT));//la checkBox  occupe la place dont elle a besoin
		box.setChecked(coche);//attribution de son �t� initial
		
		//cr�ation d'une nouvelle ligne dans le tableau
		TableRow ligne = new TableRow(this);
		ligne.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
		ligne.setGravity(Gravity.CENTER);//Les objets seront centr�s � l'int�rieur
		ligne.setPadding(0, 10, 0, 10);
		
		//ajout de l'image, du texte et le la checkbox � la ligne
		ligne.addView(image);
		ligne.addView(texte);
		ligne.addView(box);
		
		//ajout de la ligne au tableau
		tableau.addView(ligne);
	}
	
	
	/**Ajoute un image qui occupe la largeur de l'�cran
	 * @param r_raw L'image du sous-titre. Cette image doit �tre dans le dossier res/raw, et est r�f�renc� grace � R.raw.nomImage
	 */
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
	/* (non-Javadoc)
	 * D�finit le menu qui apparaitra quand l'utilisateur utilisera la touche menu(valeur par default)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
