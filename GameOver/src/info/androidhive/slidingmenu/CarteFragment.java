package info.androidhive.slidingmenu;

import java.util.ArrayList;

import ressource.carte.Cocktail;
import ressource.carte.CocktailAdapter;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;

public class CarteFragment extends Fragment {
	
	private TableLayout tableau;
	private ListView list;
	private CocktailAdapter adapter;
	public static float hauteurEcran;
	public static float largeurEcran;
	
	public CarteFragment(){}
	
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
        
        
        
        return rootView;
    }
}
