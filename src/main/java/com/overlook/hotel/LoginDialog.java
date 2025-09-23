// com.overlook.hotel.ui.LoginDialog
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

public class LoginDialog extends Dialog {

    public LoginDialog() {
        setModal(true);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(false);
        setDraggable(true);

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please sign in");

        LoginForm form = new LoginForm();
        form.setAction("login");                  // POST -> /login (Spring Security)
        form.setForgotPasswordButtonVisible(false);

        Button forgot = new Button("Forgot password");
        forgot.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        forgot.addClickListener(e -> UI.getCurrent().navigate("forgot-password"));

        Button create = new Button("Create account");
        create.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        create.addClickListener(e -> new com.overlook.hotel.CreateDialog().open());

        VerticalLayout actions = new VerticalLayout(forgot, create);
        actions.setWidthFull();
        actions.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        VerticalLayout content = new VerticalLayout(title, desc, form, actions);
        content.setAlignItems(FlexComponent.Alignment.STRETCH);
        content.setWidth("420px");

        add(content);

        // Si on ferme le popup, on reste sur la page en cours
    }
}
