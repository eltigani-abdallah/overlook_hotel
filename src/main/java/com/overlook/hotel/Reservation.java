package com.overlook.hotel;

import com.overlook.hotel.security.SecurityUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;


import com.vaadin.flow.component.html.*;
@PageTitle("Hello World Hotel – Reservation")
@AnonymousAllowed
@Route("reservation")
@CssImport(themeFor = "vaadin-button", value = "./themes/hotel-theme/styles.css")
public class Reservation extends Div {

    private Dialog loginDialog; // <-- notre popup

    public Reservation() {
        setSizeFull();
        getStyle()
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("background", "var(--lumo-base-color)");

        // construit une seule fois le dialog
        loginDialog = buildLoginDialog();

        add(buildTopbar());            // bandeau supérieur (logo, tel, réserver)
        add(buildBody());              // menu gauche + contenu
        add(buildBestPriceBadge());    // bouton vertical à droite
        add(buildFooter());            // pied de page

        HorizontalLayout body = (HorizontalLayout) buildBody();
        body.setSizeFull();
        body.getStyle().set("flex", "1 1 auto");
    }

    /* ─────────────────────────  TOP BAR  ───────────────────────── */

    private Component buildTopbar() {
        HorizontalLayout top = new HorizontalLayout();
        top.setWidthFull();
        top.setPadding(true);
        top.setSpacing(true);
        top.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        top.getStyle()
                .set("position", "sticky")
                .set("top", "0")
                .set("z-index", "20")
                .set("background", "white")
                .set("border-bottom", "1px solid rgba(0,0,0,.08)");

        Button burger = new Button(new Icon(VaadinIcon.MENU), e -> toggleLeftMenu());
        burger.getStyle().set("border-radius", "999px");

        ComboBox<String> lang = new ComboBox<>();
        lang.setItems("FR", "EN", "ES");
        lang.setValue("FR");
        lang.setWidth("90px");

        HorizontalLayout left = new HorizontalLayout(burger, lang);
        left.setAlignItems(FlexComponent.Alignment.CENTER);

Image logo = new Image("/images/logo.svg", "Hello World");
        logo.setWidth("250px");
        Div logoWrap = new Div(logo);
        logoWrap.getStyle().set("text-align", "right").set("flex-grow", "1").set("padding-right", "20px");

        TextField phone = new TextField();
        phone.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        phone.setValue("06 99 99 99 99");
        phone.setReadOnly(true);
        phone.addClassNames("phone");
        phone.setWidth("170px");
        phone.addClassNames(LumoUtility.AlignSelf.CENTER, LumoUtility.JustifyContent.CENTER);

        Button book = new Button("Réserver", e -> onReserveClick());
        book.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        book.addClickShortcut(Key.ENTER);

        HorizontalLayout right = new HorizontalLayout(phone, book);
        right.setAlignItems(FlexComponent.Alignment.CENTER);
        right.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        right.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Padding.Horizontal.NONE);

        top.setFlexGrow(1, left, logoWrap, right);
        top.add(left, logoWrap, right);
        return top;
    }

    private void onReserveClick() {
        if (SecurityUtils.isUserLoggedIn()) {
            // déjà connecté -> poursuivre le flux de réservation
            Notification.show("Vous êtes connecté, on continue la réservation…");
            // ex: UI.getCurrent().navigate("reservation/checkout");
        } else {
            // pas connecté -> ouvrir le popup de login au-dessus de la page actuelle
            loginDialog.open();
        }
    }

    /* ───────────────────────  BODY (menu + contenu)  ─────────────────────── */

    private Component buildBody() {
        HorizontalLayout body = new HorizontalLayout();
        body.setWidthFull();
        body.setPadding(false);
        body.setSpacing(false);

        VerticalLayout menu = buildLeftMenu();
        menu.setId("leftMenu");

        VerticalLayout content = new VerticalLayout();
        content.setPadding(false);
        content.setSpacing(false);
        content.setWidthFull();
        content.setSizeFull();
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        content.setAlignItems(FlexComponent.Alignment.CENTER);

        content.add(buildReservationForm());
        content.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

        body.add(menu, content);
        body.setFlexGrow(1, content);
        return body;
    }

    private VerticalLayout buildLeftMenu() {
        VerticalLayout left = new VerticalLayout();
        left.setWidth("420px");
        left.getStyle().set("display", "none");
        left.setSpacing(false);
        left.getElement().getThemeList().add("padding-l");
        left.getStyle().set("background", "white").set("border-right", "1px solid rgba(0,0,0,.06)");
        left.add(
                menuItem("CHAMBRES"), new Hr(),
                menuItem("SERVICES"), new Hr(),
                menuItem("SALLE DE SÉMINAIRE"), new Hr(),
                menuItem("LES ENVIRONS"), new Hr(),
                menuItem("GALERIE PHOTOS"), new Hr(),
                menuItem("CONTACT")
        );
        left.addClassNames(LumoUtility.Padding.Horizontal.XLARGE);
        return left;
    }

    private Component menuItem(String label) {
        H3 h = new H3(label);
        h.getStyle().set("margin", "16px 0").set("letter-spacing", "1px");
        Div wrap = new Div(h);
        wrap.getStyle().set("cursor", "pointer");
        wrap.addClickListener(e -> h.getElement().callJsFunction("scrollIntoView", true));
        return wrap;
    }

    private Component buildReservationForm() {
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setWidth("400px");
        formLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        formLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        formLayout.setPadding(true);

        DatePicker datePickerStart = new DatePicker("Date de début");
        datePickerStart.setWidth("256px");
        DatePicker datePickerEnd   = new DatePicker("Date de fin");
        datePickerEnd.setWidth("256px");

        TextField nom = new TextField("Nom");
        nom.setWidth("256px");
        TextField prenom = new TextField("Prénom");
        prenom.setWidth("256px");
        TextField telephone = new TextField("Téléphone");
        telephone.setWidth("256px");
        EmailField email = new EmailField("Email");
        email.setWidth("256px");
        email.setErrorMessage("Entrez un email valide");

        Button envoyer = new Button("Envoyer", event -> onReserveClick());
        envoyer.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        envoyer.getStyle()
                .set("margin-top", "32px")
                .set("margin-bottom", "32px");
        envoyer.setWidth("256px");

        formLayout.add(datePickerStart, datePickerEnd, prenom, nom, telephone, email, envoyer);
        formLayout.setAlignItems(FlexComponent.Alignment.CENTER);
formLayout.addClassNames(LumoUtility.Gap.MEDIUM);
        formLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        return formLayout;
    }

    /* ─────────────────────  FOOTER  ───────────────────── */

    private Component buildFooter() {
        HorizontalLayout cols = new HorizontalLayout();
        cols.setWidthFull();
        cols.setSpacing(true);
        cols.setPadding(true);
        cols.getStyle()
                .set("background", "#2e6d71")
                .set("color", "white");

        Div brand = new Div(new Image("/images/logo.svg", "Hello World HOTEL"));
        brand.addClassNames(LumoUtility.AlignSelf.CENTER, LumoUtility.Gap.MEDIUM, LumoUtility.Padding.SMALL,
                LumoUtility.Padding.Horizontal.XLARGE, LumoUtility.Padding.Vertical.LARGE);

        Div col1 = footerCol("Menu", "Chambres", "Services", "Salle de séminaire", "Galerie", "Contact");
        Div col2 = footerCol("Liens utiles", "Mentions légales", "Cookies");
        Div col3 = footerCol("Contact", "09 73 89 07 41", "hotel@example.com", "6115-117 rue Paradis, 13006 Marseille");

        cols.add(brand, col1, col2, col3);
        cols.setAlignItems(FlexComponent.Alignment.CENTER);
        cols.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        cols.setFlexGrow(0.4, brand);
        return cols;
    }

    private Div footerCol(String title, String... items) {
        Span strongLike = new Span(title);
        strongLike.getStyle().set("font-weight", "600");
        Div caption = new Div(strongLike);
        caption.getStyle().set("padding", "10px 12px");

        UnorderedList ul = new UnorderedList();
        for (String it : items) ul.add(new ListItem(new Span(it)));
        Div box = new Div();
        box.add(ul);
        return box;
    }

    private Button buildBestPriceBadge() {
        Button b = new Button("RÉSERVER AU MEILLEUR PRIX");
        b.addClickListener(e -> onReserveClick());
        b.getStyle()
                .set("position", "fixed")
                .set("right", "-120px")
                .set("top", "45%")
                .set("transform", "rotate(-90deg)")
                .set("background", "#5c7b7e")
                .set("color", "white")
                .set("letter-spacing", "1px");
        return b;
    }

    private void toggleLeftMenu() {
        getElement().executeJs("""
            const m = this.querySelector('#leftMenu');
            if (!m) return;
m.style.display = getComputedStyle(m).display === 'none' ? 'block' : 'none';
        """);
    }

    /* ────────────── Login Dialog ────────────── */

private Dialog buildLoginDialog() {
        Dialog dialog = new Dialog();
        dialog.setModal(true);
        dialog.setCloseOnEsc(true);
        dialog.setCloseOnOutsideClick(false);
        dialog.setDraggable(true);

        H2 title = new H2("Overlook Hotel");
        Paragraph desc = new Paragraph("Please sign in");

        LoginForm form = new LoginForm();
        form.setAction("login");                 // POST géré par Spring Security
        form.setForgotPasswordButtonVisible(false);
        //form.setWidth("100%");

        Button forgot = new Button("Forgot password");
        forgot.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        forgot.addClickListener(e -> UI.getCurrent().navigate("forgot-password"));
        forgot.getStyle()
                .set("color", "var(--lumo-secondary-color)")
                .set("padding-bottom", "16px");

        Button create = new Button("Create account", e -> UI.getCurrent().navigate("signup"));
        create.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        create.getStyle()
                .set("color", "var(--lumo-secondary-color)");

        VerticalLayout actions = new VerticalLayout(forgot, create);
        actions.setAlignItems(FlexComponent.Alignment.STRETCH);
        actions.setWidthFull();

        VerticalLayout content = new VerticalLayout(title, desc, form, actions);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setWidth("420px");

        Button closeButton = new Button(new Icon(VaadinIcon.CLOSE), e -> dialog.close());
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getStyle()
                .set("position", "absolute")
                .set("top", "32px")
                .set("right", "32px")
                .set("color", "var(--lumo-secondary-color)");
        dialog.add(closeButton, content);

        // après login succès, Spring Security recharge la page /reservation (SavedRequest)
        // si l’utilisateur ferme le popup, on reste sur la page
        return dialog;
    }
}
