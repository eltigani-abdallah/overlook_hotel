package com.overlook.hotel;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@PageTitle("Login")
@Route("login")
@AnonymousAllowed
public class LoginView extends Dialog {

    private final LoginForm form = new LoginForm();

    public LoginView() {
        // --- Dialog config
        setModal(true);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);
        setDraggable(true);
        setResizable(false);

        // --- Titre & sous-titre
        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please sign in");

        // --- LoginForm -> POST vers /login (Spring Security)
        form.setAction("login");                 // IMPORTANT
        form.setForgotPasswordButtonVisible(false); // on va le recréer nous-mêmes
        //form.setWidthFull();                     // si ton IDE râle, remplace par: form.setWidth("100%");

        // --- Boutons actions sous le formulaire
        Button forgot = new Button("Forgot password");
        forgot.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        // Par ex. : forgot.addClickListener(e -> UI.getCurrent().navigate("forgot-password"));
        forgot.getStyle()
                .set("color", "var(--lumo-secondary-color)")
                .set("padding-bottom", "32px");

        Button create = new Button("Create account", e -> UI.getCurrent().navigate("signup"));
        create.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        create.getStyle()
                .set("color", "var(--lumo-secondary-color)");

        VerticalLayout actions = new VerticalLayout(forgot, create);
        actions.setWidthFull();
        actions.setAlignItems(FlexComponent.Alignment.CENTER);
        actions.setPadding(false);
        actions.setSpacing(false);

        // --- Contenu du dialog
        VerticalLayout content = new VerticalLayout(title, desc, form, actions);
        content.setAlignItems(FlexComponent.Alignment.STRETCH);
        content.setSpacing(true);
        content.setPadding(true);
        content.setWidth("420px");               // largeur du popup

        add(content);

        // Fermer => retour à l'accueil (adapte si besoin)
        addOpenedChangeListener(e -> {
            if (!e.isOpened()) {
                UI.getCurrent().navigate("");
            }
        });

        open(); // ouvre le popup à l'arrivée sur /login
    }
}
