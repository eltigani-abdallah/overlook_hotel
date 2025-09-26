package com.overlook.hotel;

import com.overlook.hotel.dto.userDto.ClientDto;
import com.overlook.hotel.dto.userDto.UserDto;
import com.overlook.hotel.service.databseDtoService.DtoToDatabaseService;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
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


@SpringComponent
@UIScope
public class AuthDialog extends Dialog {
    private final VerticalLayout root = new VerticalLayout();
    private Binder<ClientDto> binder = new Binder<>(ClientDto.class);
    private final DtoToDatabaseService dtoToDatabaseService;
    private ClientDto clientDto= new ClientDto();

    public AuthDialog(DtoToDatabaseService dtoToDatabaseService) {
        this.dtoToDatabaseService=dtoToDatabaseService;
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

        ClientDto clientDto = ClientDto.builder()
                .id(null)
                .age(18)
                .gender("")
                .firstName("")
                .lastName("")
                .password("")
                .email("")
                .address("")
                .phoneNumber("")
                .loyaltyPoints(0)
                .build();

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please create an account");

        TextField firstName = new TextField("First name");
        binder.forField(firstName).asRequired("Required")
                .bind(UserDto::getFirstName, UserDto::setFirstName);

        TextField lastName = new TextField("Last name");
        binder.forField(lastName).asRequired("Required")
                .bind(UserDto::getLastName, UserDto::setLastName);

        IntegerField age = new IntegerField("Age");
        age.setMin(0);
        binder.forField(age).asRequired("Required")
                .withValidator(a -> a != null && a >= 18, "Must be at least 18")
                .bind(UserDto::getAge, UserDto::setAge);

        TextField gender = new TextField("Gender");
        binder.forField(gender).asRequired("Required")
                .bind(UserDto::getGender, UserDto::setGender);

        TextField address = new TextField("Address");
        binder.forField(address).asRequired("Required")
                .bind(UserDto::getAddress, UserDto::setAddress);

        TextField phoneNumber = new TextField("Phone number");
        binder.forField(phoneNumber).asRequired("Required")
                .bind(UserDto::getPhoneNumber, UserDto::setPhoneNumber);

        EmailField email = new EmailField("Email");
        binder.forField(email).asRequired("Required")
                .withValidator(new com.vaadin.flow.data.validator.EmailValidator("Invalid email"))
                .bind(UserDto::getEmail, UserDto::setEmail);

        PasswordField password = new PasswordField("Password");
        binder.forField(password).asRequired("Required")
                .bind(UserDto::getPassword, UserDto::setPassword);

        PasswordField confirm  = new PasswordField("Confirm Password");

        //confirm that the two passwords match ↓
        binder.forField(confirm)
                .asRequired("Confirm Password")
                .withValidator(p ->p.equals(password.getValue()), "passwords do not match")
                .bind(dto->null, (dto,value) ->{});
        password.addValueChangeListener(e -> binder.validate());
        // confirm that the two passwords match ↑


        Button create = new Button("Create account", e -> {
            if(binder.writeBeanIfValid(clientDto)){
                dtoToDatabaseService.createUserFromDto(clientDto);
                System.err.println("USER CREATED SUCCESSFULLY");
            } else {
                System.err.println("INVALID BEAN MOTHERFU****");
            }
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
