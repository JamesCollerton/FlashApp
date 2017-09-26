package com.flashapp.jamescollerton.flashapp.interfaces;

/**
 * Created by JamesCollerton on 26/09/2017.
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
