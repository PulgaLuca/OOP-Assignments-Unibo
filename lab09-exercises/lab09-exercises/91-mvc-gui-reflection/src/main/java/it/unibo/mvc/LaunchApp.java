package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
import java.util.*;
import java.lang.reflect.*;
/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws
    ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
    IllegalAccessException, IllegalArgumentException, InstantiationException
    {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        // app.addView(new DrawNumberSwingView()); SUPPORTS ONLY A SINGLE VIEW
        List<String> views = List.of("Swing", "StdOut");
        // TO SUPPORT MULTIPLE VIEWS
        for(final var newView : views){
            final var clazz = Class.forName("it.unibo.mvc.view.DrawNumber" + newView + "View");
            for (int i = 0; i < views.size(); i++){
                final var view = clazz.getConstructor().newInstance();
                if(DrawNumberView.class.isAssignableFrom(view.getClass())){
                    app.addView((DrawNumberView)view);
                }
                else{
                    throw new IllegalStateException(view.getClass() + " is not present into " + DrawNumberView.class);
                }
            }
        }
    }
}
