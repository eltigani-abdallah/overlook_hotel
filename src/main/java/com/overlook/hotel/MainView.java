package com.overlook.hotel;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("") // maps this view to http://localhost:8080/
public class MainView extends VerticalLayout {

    public MainView() {
        add(new H1("Welcome to the Overlook Hotel!"));
    }
}

