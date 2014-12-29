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
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TableLayout;

public class CarteFragment extends Fragment {
	
	public final static int TYPE_ALL = 0;
	public final static int TYPE_COCKTAILS = 1;
	public final static int TYPE_SHOOTERS = 2;
	
	private ListView list;
	private CocktailAdapter adapter;
	public static ArrayList<Cocktail> listeCocktails;
	public static ArrayList<Cocktail> listeShooters;
	private ArrayList<Cocktail> listeAAfficher;
	private static View rootView;
	
	public CarteFragment(int typeBoisson){
		
		initListes();
		
		
		switch (typeBoisson) {

		case CarteFragment.TYPE_COCKTAILS :
			listeAAfficher = listeCocktails;
			break;
		
		case CarteFragment.TYPE_SHOOTERS :
			listeAAfficher = listeShooters;
			break;

		default:
			listeAAfficher = listeCocktails;
			listeAAfficher.addAll(listeShooters);
			break;
		}
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.fragment_carte, container, false);
        
        list = (ListView) rootView.findViewById(R.id.list);

		adapter = new CocktailAdapter(R.layout.cocktail_list, listeAAfficher, rootView.getContext());
	    list.setAdapter(adapter);
        
        return rootView;
    }
	
	public void initListes(){
		
		listeCocktails = new ArrayList<Cocktail>();
		listeCocktails.add(new Cocktail(R.raw.genkidama, "Genkidama", "Redbull\nTequila\nCuraçao bleu", false));
		listeCocktails.add(new Cocktail(R.raw.mojo, "Mojo", "Rhum ambré\nPerrier\nCitron vert\nfeuilles de menthe\nSucre roux\nsirop de citron vert", false));
		listeCocktails.add(new Cocktail(R.raw.pinkmojo, "Pink Mojo", "Porto rosé\nSucre roux\nCitron vert\nFeuilles de menthe\nPerrier", false));
		listeCocktails.add(new Cocktail(R.raw.solari, "Solari", "Vodka\nLiqueur de litchi\nSirop de sucre de canne\nSirop de grenadine\nSirop de citron vert\nJus d'orange", false));
		listeCocktails.add(new Cocktail(R.raw.subzero, "Sub Zéro", "Rhum blanc\nCuraçao bleu\nJus d'ananas\nLait de coco", false));
		listeCocktails.add(new Cocktail(R.raw.kerrigan, "Kerrigan", "Rhum ambré\nSucre roux\nCrème de mûre\nCitron vert\nLiqueur de violette\nFeuilles de menthe", false));
		listeCocktails.add(new Cocktail(R.raw.age, "Cocktail du 5ème âge", "Rhum blanc\nCitron vert\nSirop de grenadine\nLiqueur de cerise", false));
		listeCocktails.add(new Cocktail(R.raw.morphling, "Morphling", "Lait de coco\nMartini blanc\nCuraçao bleu\nJus d'ananas", false));
		listeCocktails.add(new Cocktail(R.raw.glados, "Glados", "Rhum ambré\nRhum blanc\nJus d'ananas\nLait de coco", false));
		listeCocktails.add(new Cocktail(R.raw.zelda, "Princesse Zelda", "Gin\nSchweppes tonic\nLiqueur de violette", false));
		listeCocktails.add(new Cocktail(R.raw.valentine, "Vincent Valentine", "Crème de pêche\nVodka\nJus d'orange\nLiqueur de fraise", false));
		listeCocktails.add(new Cocktail(R.raw.altair, "Altair", "Lait\nVodka\nLiqueur de café", false));
		
		listeShooters = new ArrayList<Cocktail>();
		listeShooters.add(new Cocktail(R.raw.bomberman, "Bomber man", "Redbull\nJagermeister", false));
		listeShooters.add(new Cocktail(R.raw.bloodybrain, "Bloody brain", "Vodka\nCrème de whisky\nSirop de Grenadine", false));
		listeShooters.add(new Cocktail(R.raw.baneling, "Baneling", "Get 27\nTequila\nCrème de whisky", false));
		listeShooters.add(new Cocktail(R.raw.gameover, "Game over", "Tabasco\nVodka\nTequila\nSirop de grenadine", false));
		listeShooters.add(new Cocktail(R.raw.random, "Rambom pick", "1 Sirop\n1 Liqueur\n1 Alcool fort", false));
		listeShooters.add(new Cocktail(R.raw.rainbow, "Rainbow dash", "Vodka\nJus d'orange\nCuraçao bleu\nSirop de grenadine", false));
		
	}
	
}
