package com.overlook.hotel;

import com.overlook.hotel.dto.userDto.UserDto;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
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
    private Binder<UserDto> binder = new Binder<>(UserDto.class);

    public AuthDialog() {
        setModal(true);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(false);

        // Config CSS rules
        root.setWidth("420px");
        root.setPadding(true);
        root.setSpacing(true);
        root.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        root.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

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

        Button closeButton = new Button(new Icon(VaadinIcon.CLOSE), e -> close());
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getStyle()
                .set("position", "absolute")
                .set("top", "32px")
                .set("right", "32px")
                .set("color", "var(--lumo-secondary-color)");

        root.add(title, desc, form, toForgotPassword, toSignup, closeButton);
    }

    private void showSignup() {
        root.removeAll();

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please create an account");

        TextField firstName = new TextField("First name");
        binder.bind(firstName, UserDto::getFirstName, UserDto::setFirstName);

        TextField lastName = new TextField("Last name");
        binder.bind(lastName, UserDto::getLastName, UserDto::setLastName);

        IntegerField age = new IntegerField("Age");
        binder.bind(age, UserDto::getAge, UserDto::setAge);

        TextField gender = new TextField("Gender");
        binder.bind(gender, UserDto::getGender, UserDto::setGender);

        TextField address = new TextField("Address");
        binder.bind(address, UserDto::getAddress, UserDto::setAddress);

        TextField phoneNumber = new TextField("Phone number");
        binder.bind(phoneNumber, UserDto::getPhoneNumber, UserDto::setPhoneNumber);

        EmailField email = new EmailField("Email");
        binder.bind(email, UserDto::getEmail, UserDto::setEmail);

        PasswordField password = new PasswordField("Password");
        binder.bind(password, UserDto::getPassword, UserDto::setPassword);


        PasswordField confirm  = new PasswordField("Confirm Password");
        //confirm that the two passwords match ↓
        binder.forField(confirm)
                .asRequired("Confirm Password")
                .withValidator(p ->p.equals(password.getValue()), "passwords do not match")
                .bind(dto->null, (dto,value) ->{});
        // confirm that the two passwords match ↑

        Button create = new Button("Create account", e -> {
            // TODO: créer l’utilisateur puis close();
            close();
        });
        create.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        create.setWidth("190px");
        create.getStyle().set("margin", "24px");

        Button back = new Button("Back to login", e -> showLogin());
        back.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        back.getStyle()
                .set("color", "var(--lumo-secondary-color)")
                .set("padding-bottom", "16px");

        Button closeButton = new Button(new Icon(VaadinIcon.CLOSE), e -> close());
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getStyle()
                .set("position", "absolute")
                .set("top", "32px")
                .set("right", "32px")
                .set("color", "var(--lumo-secondary-color)");

        VerticalLayout form = new VerticalLayout(firstName, lastName, age, gender, address, phoneNumber, email, password, confirm, create, back, closeButton);
        form.setPadding(false);
        form.setSpacing(true);
        form.setWidthFull();
        form.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        root.add(title, desc, form);
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
        send.setWidth("190px");
        send.getStyle()
                .set("padding-right", "4px")
                .set("padding-left", "4px")
                .set("margin", "24px");

        Button back = new Button("Back to login", e -> showLogin());
        back.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        back.getStyle()
                .set("color", "var(--lumo-secondary-color)")
                .set("padding-bottom", "16px");

        Button closeButton = new Button(new Icon(VaadinIcon.CLOSE), e -> close());
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getStyle()
                .set("position", "absolute")
                .set("top", "32px")
                .set("right", "32px")
                .set("color", "var(--lumo-secondary-color)");

        VerticalLayout form = new VerticalLayout(email, send, back, closeButton);
        form.setPadding(false);
        form.setSpacing(true);
        form.setWidthFull();
        form.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        root.add(title, desc, form);
    }
}
