package ressource.carte;


import info.androidhive.slidingmenu.MainActivity;
import info.androidhive.slidingmenu.R;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CocktailAdapter extends ArrayAdapter<Cocktail> {
	
	private LayoutInflater mInflater = null;
	private Context main;
	private SharedPreferences settings;
	
	public CocktailAdapter(int textViewResourceId, List<Cocktail> objects, Context main) {
	    super(main, textViewResourceId, objects);
	    mInflater = LayoutInflater.from(main);
	    this.main = main;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {	
		settings = PreferenceManager.getDefaultSharedPreferences(main);
		
	    View vue = null;
				
	    if(convertView != null)
	      vue = convertView;
	    else
	      vue = mInflater.inflate(R.layout.cocktail_list, null);
	    
	    final Cocktail item = getItem(position);
	    
	    ImageView icon = (ImageView) vue.findViewById(R.id.icon);
	    icon.setImageResource(item.getImageId());
    	
    	TextView name = (TextView) vue.findViewById(R.id.name);
    	name.setText(item.getName());
     	
     	TextView desc = (TextView) vue.findViewById(R.id.desc);
     	desc.setText(item.getDesc());
     	desc.setLayoutParams(new LayoutParams((int)(MainActivity.largeurEcran * 0.55),LayoutParams.WRAP_CONTENT));
	    
     	CheckBox checkbox = (CheckBox) vue.findViewById(R.id.checkbox) ;
     	checkbox.setChecked(settings.getBoolean("isChecked_" + item.getImageId(), false));
     	//android.widget.RelativeLayout.LayoutParams lp = new android.widget.RelativeLayout.LayoutParams(60,60);
     	//checkbox.setLayoutParams(lp);
     	checkbox.setScaleX(1.5f);
     	checkbox.setScaleY(1.5f);
     	
     	checkbox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Editor editor = settings.edit();
				editor.putBoolean("isChecked_" + item.getImageId(), ((CheckBox) v).isChecked());
				editor.commit();
			}
		});
     	
	    return vue;
	  }

}
