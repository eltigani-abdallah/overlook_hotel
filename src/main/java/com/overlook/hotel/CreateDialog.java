package com.overlook.hotel;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class CreateDialog extends Dialog {

    public CreateDialog() {
        setModal(true);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(false);

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please create an account");

        // Champs du formulaire
        TextField username = new TextField("Username");
        EmailField email = new EmailField("Email");
        email.setErrorMessage("Entrez un email valide");
        PasswordField password = new PasswordField("Password");
        PasswordField confirm = new PasswordField("Confirm Password");

        Button create = new Button("Create account", e -> {
            if (!password.getValue().equals(confirm.getValue())) {
                Notification.show("Passwords do not match !");
                return;
            }
            // Ici tu peux appeler ton service Spring pour enregistrer l’utilisateur
            Notification.show("Account created for " + username.getValue());
            close();
            UI.getCurrent().navigate("reservation"); // ex : retour sur réservation
        });
        create.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        VerticalLayout form = new VerticalLayout(username, email, password, confirm, create);
        form.setWidth("400px");

        add(new VerticalLayout(title, desc, form));
    }
}
