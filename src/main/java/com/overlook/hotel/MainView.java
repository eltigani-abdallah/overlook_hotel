package com.overlook.hotel;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import jakarta.annotation.security.PermitAll;


@PermitAll
//@Route("") // http://localhost:8080/
public class MainView extends AppLayout {
  public MainView() {
    DrawerToggle toggle = new DrawerToggle();
    
    Image logo = new Image("path/to/logo.svg", "Logo");
    logo.getStyle().set("margin", "0 auto");

    Button phoneButton = new Button("Phone Number");
    phoneButton.getStyle().set("padding", "16px").set("border", "1px solid");

    Button reservationButton = new Button("Reservation");
    reservationButton.getStyle().set("padding", "16px").set("background-color", "lightblue");

    HorizontalLayout buttonsLayout = new HorizontalLayout(phoneButton, reservationButton);
    buttonsLayout.setSpacing(true);

    addToNavbar(toggle, logo, buttonsLayout);
  }
}
