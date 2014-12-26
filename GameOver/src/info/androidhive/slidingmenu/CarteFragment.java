package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.HashSet;

import ressource.carte.Cocktail;
import ressource.carte.CocktailAdapter;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TableLayout;

public class CarteFragment extends Fragment {
	
	private TableLayout tableau;
	private ListView list;
	private CocktailAdapter adapter;
	public static float hauteurEcran;
	public static float largeurEcran;
	private Context context;
	
	public CarteFragment(Context cc){
		context = cc;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
        list = (ListView) rootView.findViewById(R.id.list);
		
		ArrayList<Cocktail> liste = new ArrayList<Cocktail>();
		
		liste.add(new Cocktail(R.raw.genkidama, "Genkidama", "Redbull\nTequila\nCura�ao bleu", false));
		liste.add(new Cocktail(R.raw.mojo, "Mojo", "Rhum ambr�\nPerrier\nCitron vert\nfeuilles de menthe\nSucre roux\nsirop de citron vert", false));
		liste.add(new Cocktail(R.raw.pinkmojo, "Pink Mojo", "Porto ros�\nSucre roux\nCitron vert\nFeuilles de menthe\nPerrier", false));
		liste.add(new Cocktail(R.raw.solari, "Solari", "Vodka\nLiqueur de litchi\nSirop de sucre de canne\nSirop de grenadine\nSirop de citron vert\nJus d'orange", false));
		liste.add(new Cocktail(R.raw.subzero, "Sub Z�ro", "Rhum blanc\nCura�ao bleu\nJus d'ananas\nLait de coco", false));
		liste.add(new Cocktail(R.raw.kerrigan, "Kerrigan", "Rhum ambr�\nSucre roux\nCr�me de m�re\nCitron vert\nLiqueur de violette\nFeuilles de menthe", false));
		liste.add(new Cocktail(R.raw.age, "Cocktail du 5�me �ge", "Rhum blanc\nCitron vert\nSirop de grenadine\nLiqueur de cerise", false));
		liste.add(new Cocktail(R.raw.morphling, "Morphling", "Lait de coco\nMartini blanc\nCura�ao bleu\nJus d'ananas", false));
		liste.add(new Cocktail(R.raw.glados, "Glados", "Rhum ambr�\nRhum blanc\nJus d'ananas\nLait de coco", false));
		liste.add(new Cocktail(R.raw.zelda, "Princesse Zelda", "Gin\nSchweppes tonic\nLiqueur de violette", false));
		liste.add(new Cocktail(R.raw.valentine, "Vincent Valentine", "Cr�me de p�che\nVodka\nJus d'orange\nLiqueur de fraise", false));
		liste.add(new Cocktail(R.raw.altair, "Altair", "Lait\nVodka\nLiqueur de caf�", false));
		
		adapter = new CocktailAdapter(android.R.layout.simple_list_item_1, liste, rootView.getContext());
	    list.setAdapter(adapter);
        
	    HashSet<String> listeBoissons = new HashSet<String>();
	    for(Cocktail cc : liste){
	    	for(String boisson : cc.getDesc().split("\n")){
	    		listeBoissons.add(boisson);
	    	}
	    	listeBoissons.add(cc.getName());
	    }
	    
	    int i = 0;
	    String[] mots = new String[listeBoissons.size()];
	    for(String boisson : listeBoissons){
	    	mots[i] = boisson;
	    	i++;
	    }
	    
	    MultiAutoCompleteTextView barreRecherche = (MultiAutoCompleteTextView) rootView.findViewById(R.id.barreRecherche);

        //Voir si on peut int�grer les image � l'aide d'une red�finition de la classe arrayAdapteur
        ArrayAdapter<String> adatpteurRecherche = new ArrayAdapter<String>(context,android.R.layout.simple_dropdown_item_1line, mots);
        barreRecherche.setAdapter(adatpteurRecherche);
        barreRecherche.setThreshold(1);
        barreRecherche.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer() );
        
        return rootView;
    }
}
