package gameOver.ecrans;


import java.util.ArrayList;
import java.util.HashSet;

import ressource.carte.Cocktail;
import ressource.carte.CocktailAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TableLayout;

public class RechercheFragment extends Fragment implements OnClickListener {
	
	private ListView list;
	private CocktailAdapter adapter;
	public static float hauteurEcran;
	public static float largeurEcran;
	private Activity activity;
	private View rootView;
	private MultiAutoCompleteTextView barreRecherche;
	
	public RechercheFragment(Activity aa){
		this.activity = aa;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		rootView = inflater.inflate(R.layout.fragment_recherche, container, false);
        
		//Ajout listener sur le bouton
		ImageButton bouton = (ImageButton) rootView.findViewById(R.id.chercher);
		bouton.setOnClickListener(this);

	    //Récupération de tous les nom des cocktails et de leurs composants 
	    HashSet<String> listeBoissons = new HashSet<String>();
	    for(Cocktail cc : CarteFragment.listeCocktails){
	    	for(String boisson : cc.getDesc().split("\n")){
	    		//Ajout des noms dans une hasset pour éviter les doublons ;)
	    		listeBoissons.add(boisson);
	    	}
	    	listeBoissons.add(cc.getName());
	    }
	    
	    //Transformation de la hashset en tableau de String
	    int i = 0;
	    String[] mots = new String[listeBoissons.size()];
	    for(String boisson : listeBoissons){
	    	mots[i] = boisson.toLowerCase();
	    	i++;
	    }
	    
	    barreRecherche = (MultiAutoCompleteTextView) rootView.findViewById(R.id.barreRecherche);

	    //Le tableau définit les mots qui seront proposés dans la barre de recherche
        //Voir si on peut intégrer les image à l'aide d'une redéfinition de la classe arrayAdapteur
        ArrayAdapter<String> adatpteurRecherche = new ArrayAdapter<String>(activity,android.R.layout.simple_dropdown_item_1line, mots);
        barreRecherche.setAdapter(adatpteurRecherche);
        barreRecherche.setThreshold(1);
        barreRecherche.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer() );
        
        return rootView;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		list = (ListView) rootView.findViewById(R.id.listRecherche);
		
		String[] mots = barreRecherche.getText().toString().split(",");
		ArrayList<Cocktail> listeCocktails = new ArrayList<Cocktail>();		
		
		boolean afficher = true;
		//Création de la liste de tous les cocktails qui on l'un des mots recherchés dans la barre dans leur description ou leur nom
		for(Cocktail cc : CarteFragment.listeCocktails){
			afficher = true;
			for(String mot : mots){
				mot = mot.trim();
				mot = mot.toLowerCase();
				
				if(!mot.equals("")){
					if(cc.getName().toLowerCase().contains(mot)){
						//listeCocktails.add(cc);
						afficher = afficher && true;
					}else{
						if(cc.getDesc().toLowerCase().contains(mot)){
							afficher = afficher && true;
						}else{
							afficher = false;
						}
					}
				}else{
					afficher = true && afficher;
				}
				
			}
			
			if(afficher){
				listeCocktails.add(cc);
			}
			
		}
		
		adapter = new CocktailAdapter(R.layout.cocktail_list, listeCocktails, rootView.getContext());
	    list.setAdapter(adapter);
	}
	
}
