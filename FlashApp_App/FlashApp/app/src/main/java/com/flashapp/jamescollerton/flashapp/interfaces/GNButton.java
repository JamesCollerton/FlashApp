package com.flashapp.jamescollerton.flashapp.interfaces;

/**
 * This is used so buttons can be declared separately to fields. Buttons will always need a view
 * but may not need methods like set or get.
 */
public interface GNButton<ViewType> {

    /**
     * This needs to be overriden to return the main view in the
     * fragment. So this will be the EditText or similar.
     *
     * @return Main fragment view.
     */
    public ViewType getFragmentView();
}
