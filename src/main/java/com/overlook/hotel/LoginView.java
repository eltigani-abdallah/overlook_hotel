package com.overlook.hotel;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Login")
@Route("login")
@AnonymousAllowed // allow unauthenticated access to this view
public class LoginView extends LoginOverlay {

  public LoginView() {
    setTitle("Overlook Hotel");
    setDescription("Please sign in");
    setOpened(true);
    setAction("/login"); // Spring Security handles POST to /login
  }
}
