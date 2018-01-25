package com.example.android.android_me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by aviator on 25/01/18.
 */

public class BodyPartFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // Set the image to the first in our list of head images
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        // Return the rootView
        return rootView;
    }
}
