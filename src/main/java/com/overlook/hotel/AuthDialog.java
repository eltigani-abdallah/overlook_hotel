package com.overlook.hotel;

import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;


public class AuthDialog extends Dialog {
    private final VerticalLayout root = new VerticalLayout();

    public AuthDialog() {
        setModal(true);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(false);
        add(root);
        showLogin();
    }

    private void showLogin() {
        root.removeAll();

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please sign in");

        LoginForm form = new LoginForm();
        form.setAction("login");
        form.setForgotPasswordButtonVisible(false);

        Button toForgotPassword = new Button("Forgot password", e -> showForgotPassword());
        toForgotPassword.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        toForgotPassword.getStyle()
                .set("color", "var(--lumo-secondary-color)")
                .set("padding-bottom", "16px");


        Button toSignup = new Button("Create account", e -> showSignup());
        toSignup.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        toSignup.getStyle()
                .set("color", "var(--lumo-secondary-color)")
                .set("padding-bottom", "16px");


        root.add(title, desc, form, toForgotPassword, toSignup);
        root.setAlignItems(FlexComponent.Alignment.CENTER);
        root.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        root.setWidth("420px");
        root.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);
    }

    private void showSignup() {
        root.removeAll();

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please create an account");

        TextField username = new TextField("Username");
        EmailField email = new EmailField("Email");
        PasswordField password = new PasswordField("Password");
        PasswordField confirm  = new PasswordField("Confirm Password");

        Button create = new Button("Create account", e -> {
            // TODO: créer l’utilisateur puis close();
            close();
        });
        create.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button back = new Button("Back to login", e -> showLogin());
        back.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        root.add(title, desc,
                new VerticalLayout(username, email, password, confirm, create, back));
        root.setAlignItems(FlexComponent.Alignment.CENTER);
        root.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        root.setWidth("420px");
        root.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);
    }

    private void showForgotPassword() {
        root.removeAll();

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please enter your email address");

        EmailField email = new EmailField("Email");

        Button send = new Button("Send", e -> {
            // TODO: envoyer un mail puis close();
            close();
        });
        send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button back = new Button("Back to login", e -> showLogin());
        back.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        root.add(title, desc,
                new VerticalLayout(email, send, back));
        root.setAlignItems(FlexComponent.Alignment.CENTER);
        root.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        root.setWidth("420px");
        root.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);
    }
}
