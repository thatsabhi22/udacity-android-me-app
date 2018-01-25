package com.example.android.android_me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aviator on 25/01/18.
 */

public class BodyPartFragment extends Fragment {

    // Final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    // Tag for logging
    private static final String TAG = "BodyPartFragment";

    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Load the saved state (the list of images and list index) if there is one
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        if(mImageIds != null){
            // Set the image resource to the list item at the stored index
            imageView.setImageResource(mImageIds.get(mListIndex));

            // Set a click listener on the image view
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Increment position as long as the index remains <= the size of the image ids list
                    if(mListIndex < mImageIds.size()-1) {
                        mListIndex++;
                    } else {
                        // The end of list has been reached, so return to beginning index
                        mListIndex = 0;
                    }
                    // Set the image resource to the new list item
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        // Return the rootView
        return rootView;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    /**
     * Save the current state of this fragment
     */
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
