package com.example.miwok;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;


//    /**
//     * Create a new {@link WordAdapter} object.
//     *
//     * @param context is the current context (i.e. Activity) that the adapter is being created in.
//     * @param words is the list of {@link Word}s to be displayed.
//     */
//
//    public WordAdapter(Activity context, ArrayList<Word> words) {
//        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
//        // the second argument is used when the ArrayAdapter is populating a single TextView.
//        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
//        // going to use this second argument, so it can be any value. Here, we used 0.
//        super(context, 0, words);
//        //can pass in 0 ourselves because we are inflating the layout ourselves in the getView method
//    }


    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }



    /**The word adapter is responsible for  loading the right information from the word object
     *   into the list item layout. This includes loading the right image into the image view.
     *
     * The purpose of the the getView method is to return a list item view and return it to the ListView
     *
     * This method gets called when the list view is trying to display a list of items
     * at a given position.
     *
     * @param position trying to display a list of items at a given position
     * @param convertView list view will pass in a potential view that could be reused
     * @param parent refers to the parent viewgroup of all list items
     *               i.e. the ListView itself
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        //helps us inflate the view
        //inflating the list item view means that we create a new list item layout
        //from R.layout.simple_list_item_1_mod xml layout
        //this is stored in the listItemView variable
        //R.layout.simple_list_item_1_mod references the Linear Layout at the root of the layout
        //therefore we can find the child views from the root of the layout
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.simple_list_item_1_mod2, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        //get the word object at the given position of the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        //find the child textview with the Id
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        //set the miwok translation of the word onto this textview
        nameTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

//        ImageView icon = (ImageView) listItemView.findViewById(R.id.image);
//        icon.setImageDrawable(currentWord.getImageResourceId());

        /**
         * Searching through the listItemView layout to find the view with ID
         * image
         * When we find that view we cast it to an ImageView and store it in a variable
         * called imageView
         *Then we call the setImageResaource method on that ImageView
         * and into this method we pass it an input of the image resource id
         * from the Word object
         * SO these two lines of code set the correct image on the list item
         */

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());
            //Make sure the view is visible because views get reused
            imageView.setVisibility(View.VISIBLE);
        }else{
            //Otherwise hide the ImageView (set visibilty to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
