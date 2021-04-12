package main.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import main.exceptions.DuplicateEntryException;
import main.exceptions.SceneNotFoundException;

import java.util.HashMap;

public class PageController {
    private HashMap<String, Pane> pageMap;
    private static PageController instance;
    private Scene main;

    private PageController() {
        pageMap = new HashMap<>();
    }

    public boolean setScene(Scene main) {
        if(this.main != null) {
            return false;
        } else {
            this.main = main;
            return true;
        }
    }

    public void addPage(String name, Pane pane) throws DuplicateEntryException {
        if(pageMap.containsKey(name)) {
            throw new DuplicateEntryException(String.format("Page with key of [%s] has already been added!", name));
        }
        pageMap.put(name, pane);
    }

    public void removePage(String name) {
        pageMap.remove(name);
    }

    public boolean hasPage(String name) {
        return pageMap.containsKey(name);
    }

    public void activate(String name) throws SceneNotFoundException {
        if(main == null) {
            throw new SceneNotFoundException("Scene has not been set in PageController");
        } else  {
            main.setRoot(pageMap.get(name));
        }
    }

    /**
     * Gets instance of PageController class. If no one has requested an instance yet,
     * then a new instance will be created. If an instance already exists that instance
     * will be returned
     * @return The current instance of the PageController Class
     */
    public static PageController instance() {
        if(instance == null) {
            return new PageController();
        } else {
            return instance;
        }
    }
}
