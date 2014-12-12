package com.example.gameover;

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
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CocktailAdapter extends ArrayAdapter<Cocktail> {
	
	private LayoutInflater mInflater = null;
	private Activity main;
	private SharedPreferences settings;
	
	public CocktailAdapter(Context context, int textViewResourceId, List<Cocktail> objects, Activity main) {
	    super(context, textViewResourceId, objects);
	    mInflater = LayoutInflater.from(context);
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
	    
     	CheckBox checkbox = (CheckBox) vue.findViewById(R.id.checkbox) ;
     	checkbox.setChecked(settings.getBoolean("isChecked_" + item.getImageId(), false));
     	
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
