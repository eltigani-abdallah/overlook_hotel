package com.overlook.hotel;

import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.PermitAll;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextFieldVariant;


import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;

@PageTitle("Hello World Hotel – Accueil")
@PermitAll
@Route("home")
@RouteAlias("")
@CssImport(themeFor = "vaadin-button", value = "./themes/hotel-theme/styles.css")
public class HomePage extends Div {

    public HomePage() {
        setSizeFull();
        getStyle()
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("background", "var(--lumo-base-color)");

        add(buildTopbar());            // bandeau supérieur (logo, tel, réserver)
        add(buildBody());              // menu gauche + contenu
        add(buildBestPriceBadge());    // bouton vertical à droite
        add(buildFooter());            // pied de page
    }

    private static final String CONTENT_MAX = "1120px";


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

        // Burger + langue
        Button burger = new Button(new Icon(VaadinIcon.MENU), e -> toggleLeftMenu());
        burger.getStyle()
                .set("border-radius", "999px");

        ComboBox<String> lang = new ComboBox<>();
        lang.setItems("FR", "EN", "ES");
        lang.setValue("FR");
        lang.setWidth("90px");

        HorizontalLayout left = new HorizontalLayout(burger, lang);
        left.setAlignItems(FlexComponent.Alignment.CENTER);

        // Logo
        Image logo = new Image("/images/logo.svg", "Hello World");
        logo.setWidth("250px");
        Div logoWrap = new Div(logo);
        logoWrap.getStyle()
                .set("text-align", "center")
                .set("flex", "1");

        // Phone + CTA
        TextField phone = new TextField();
//        phone.getStyle()
//                .set("text-align", "center");
        phone.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        phone.setValue("06 99 99 99 99");
        phone.setReadOnly(true);
        phone.addClassNames("phone");
        phone.setWidth("170px");
//        phone.getStyle()
//                .set("border", "1px solid #c7d5d8");
        phone.addClassNames(LumoUtility.AlignSelf.CENTER, LumoUtility.JustifyContent.CENTER);

        Button book = new Button("Réserver", e -> UI.getCurrent().getPage().open("#reservation"));
        book.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        book.addClickShortcut(Key.ENTER);

        HorizontalLayout right = new HorizontalLayout(phone, book);
        right.setAlignItems(FlexComponent.Alignment.CENTER);
right.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.END, LumoUtility.Padding.Horizontal.NONE);

        top.setFlexGrow(1, left, logoWrap, right);
        top.add(left, logoWrap, right);
        return top;
    }

    /* ───────────────────────  BODY (menu + contenu)  ─────────────────────── */

    private Component buildBody() {
        HorizontalLayout body = new HorizontalLayout();
        body.setWidthFull();
        body.setPadding(false);
        body.setSpacing(false);

        // menu latéral
        VerticalLayout menu = buildLeftMenu();
        menu.setId("leftMenu");

        // contenu
        VerticalLayout content = new VerticalLayout();
        content.setPadding(false);
        content.setSpacing(false);
        content.setWidthFull();

        content.add(buildHero());           // hero avec image + overlay
        content.add(buildBienvenue());      // section 1
        content.add(buildServices());       // section 2
        content.add(buildRooms());          // section 3
        content.add(buildLocalisation());   // section 4

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
        left.getStyle().set("background", "white")
                .set("border-right", "1px solid rgba(0,0,0,.06)");
        left.add(
                menuItem("CHAMBRES"),
                new Hr(),
                menuItem("SERVICES"),
                new Hr(),
                menuItem("SALLE DE SÉMINAIRE"),
                new Hr(),
                menuItem("LES ENVIRONS"),
                new Hr(),
                menuItem("GALERIE PHOTOS"),
                new Hr(),
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

    /* ─────────────────────────  HERO  ───────────────────────── */

    private Component buildHero() {
        // image libre : remplace par la tienne si besoin
        String img = "/images/familiale4.jpeg";

        Div hero = new Div();
        hero.setWidthFull();
        hero.getStyle()
                .set("display", "flex")
                .set("justify-content", "center")
                .set("align-items", "center")
                .set("position", "relative")
                .set("height", "340px")
                .set("overflow", "hidden")
                .set("background-image", "linear-gradient(0deg, rgba(0,0,0,.35), rgba(0,0,0,.35)), url('" + img + "')")
                .set("background-size", "cover")
                .set("background-position", "center");

        VerticalLayout text = new VerticalLayout();
        text.setSpacing(false);
        text.setPadding(false);
        text.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        text.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        text.getStyle()
                .set("position", "absolute")
                .set("inset", "0")
                .set("color", "white");

        H1 title = new H1("Bienvenue à l’Hello World Hotel");
        title.getStyle()
                .set("margin", "0 0 .25rem 0");

        Paragraph sub = new Paragraph("HÔTEL 3 ÉTOILES À MARSEILLE");
        sub.getStyle()
                .set("margin", "0 0 1rem 0")
                .set("letter-spacing", ".12em");

        Button cta = new Button("Découvrir les chambres");
        cta.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
cta.addClassNames(LumoUtility.AlignSelf.CENTER);

        text.add(title, sub, cta);
        hero.add(text);
        return hero;
    }

    /* ─────────────────────  SECTION “BIENVENUE”  ───────────────────── */

    private Component buildBienvenue() {
        HorizontalLayout row = twoCols(
                bienvenueText(),
                picture("https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?q=80&w=1400&auto=format&fit=crop")
        );
        return sectionWrap(row, "#dcebea");
    }

    private Component bienvenueText() {
        VerticalLayout box = new VerticalLayout();
        //<theme-editor-local-classname>
        box.addClassName("home-page-vertical-layout-1");
        box.setSpacing(false);
        box.setPadding(false);
        box.getStyle()
                .set("max-width", "560px")
                .set("width", "100%");

        H3 h = new H3("Bienvenue");
        h.getStyle().set("margin-bottom", "8px");

        Paragraph p = new Paragraph(
                "Proposant un hébergement 3 étoiles, l'Hôtel Le M est situé à Marseille, à 2,7 km de la plage des Catalans " +
                        "et à 600 mètres de la station de métro Castellane et 800 mètres du vieux port. " +
                        "Doté d’un salon commun, l’hôtel 3 étoiles propose des chambres climatisées avec Wi-Fi gratuite, chacune " +
                        "dotée d’une salle de bains privative.");
        p.getStyle().set("margin", "0");

        Button cta = new Button("Découvrir les chambres");
        cta.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cta.getStyle().set("margin-top", "12px");

        box.add(h, p, cta);
        box.setAlignItems(FlexComponent.Alignment.CENTER);
        box.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        return box;
    }

    /* ─────────────────────  SECTION “SERVICES”  ───────────────────── */

    private Component buildServices() {
        // col image + col bullets
        UnorderedList bullets = new UnorderedList();
        bullets.getStyle().set("line-height", "1.5");
        bullets.add(
li("Check-in 15h / check-out 11h"),
                li("Petit déjeuner buffet 7h-10h"),
                li("Animaux acceptés (supplément)"),
                li("Late check-out (supplément)"),
                li("Bar & snack à la réception"),
                li("TV, Netflix, bouilloire, frigo…"),
                li("Litbébéà lademande"),
                li("Navette aéroportà la demande"),
                li("Réservationdes restaurants"),
                li("Activitéstouristiques")
        );

        VerticalLayout right = new VerticalLayout(new H3("Services"), bullets);
        right.setPadding(false);
        right.setSpacing(false);
        right.getStyle()
                .set("max-width", "560px")
                .set("width", "100%");

        Button cta = new Button("Découvrir les services");
        cta.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        right.add(new Div(), cta);

        HorizontalLayout row = twoCols(
                picture("https://images.unsplash.com/photo-1524758631624-e2822e304c36?q=80&w=1200&auto=format&fit=crop"),
                right
        );
        return sectionWrap(row, "transparent");
    }

    private ListItem li(String txt) {
Icon dot = new Icon(VaadinIcon.CHECK_CIRCLE);
dot.getStyle().set("width", "12px").set("height", "12px").set("fill", "var(--lumo-primary-color)");
Span s = new Span(" " + txt);
        ListItem li = new ListItem(new Span(dot, s));
        li.getStyle().set("list-style", "none");
return li;
    }

    /* ─────────────────────  SECTION “CHAMBRES”  ───────────────────── */

    private Component buildRooms() {
        VerticalLayout wrap = new VerticalLayout();
        wrap.setWidthFull();
        wrap.setAlignItems(FlexComponent.Alignment.CENTER);

        H3 title = new H3("Chambres");
        title.getStyle()
                .set("margin-bottom", "4px");
        Paragraph intro = new Paragraph(
                "Tous les logements sont équipés d’une TV, sèche-cheveux, bouilloire et plateau d’accueil. " +
                        "Le buffet petit-déjeuner est servi tous les jours sur place.");
        intro.getStyle()
                .set("margin-bottom", "24px")
                .set("text-align", "center");

        FlexLayout grid = new FlexLayout(
                roomCard("DOUBLE", imgRoom(1)),
                roomCard("FAMILIALE", imgRoom(2)),
                roomCard("TWIN", imgRoom(3)),
                roomCard("STUDIO", imgRoom(4))
        );
        grid.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        grid.getStyle()
                .set("margin-bottom", "24px")
                .set("gap", "16px");

        Button cta = new Button("Découvrir les chambres");
        cta.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        wrap.add(title, intro, grid, cta);
wrap.setSpacing(false);
wrap.addClassNames(LumoUtility.Padding.NONE);
        return sectionWrap(wrap, "");
    }

    private String imgRoom(int id) {
        return switch (id) {
            case 1 -> "/images/double3.jpeg";
            case 2 -> "/images/familiale4.jpeg";
            case 3 -> "/images/twin4.jpeg";
            default -> "/images/studio3.jpeg";
        };
    }

    private Component roomCard(String label, String img) {
        Div card = new Div();
        card.getStyle()
                .set("width", "260px")
                .set("border-radius", "12px")
                .set("background", "white")
                .set("box-shadow", "0 2px 10px rgba(0,0,0,.06)")
                .set("overflow", "hidden");

        Image image = new Image(img, label);
        image.setWidth("100%");
        image.setHeight("150px");
        image.getStyle().set("object-fit", "cover");

        Span strongLike = new Span(label);
        strongLike.getStyle().set("font-weight", "600");
        Div caption = new Div(strongLike);
        caption.getStyle().set("padding", "10px 12px");

        card.add(image, caption);
        return card;
    }

    /* ─────────────────────  SECTION “LOCALISATION”  ───────────────────── */

    private Component buildLocalisation() {
        VerticalLayout box = new VerticalLayout();
        box.setSpacing(false);
        box.setAlignItems(FlexComponent.Alignment.CENTER);
        box.getStyle().set("background", "#f6edd8"); // beige clair

        H3 title = new H3("Parfaite localisation");
        title.addClassName("yellow-header");
        Paragraph sub = new Paragraph(
                "Quartier préféré des voyageurs visitant Marseille. À proximité : Vieux-Port, métro Castellane, Basilique " +
                        "Notre-Dame de la Garde. Aéroport à 23 km.");
        sub.getStyle().set("text-align", "center").set("max-width", "820px");

        FlexLayout icons = new FlexLayout(
                locationItem(VaadinIcon.ANCHOR, "Vieux Port"),
                locationItem(VaadinIcon.BUILDING, "Basilique Notre-Dame"),
                locationItem(VaadinIcon.MAP_MARKER, "Quartier des Antiquaires")
        );
        icons.getStyle().set("flex-wrap", "wrap");
        icons.getStyle().set("gap", "32px");

        Button cta = new Button("Découvrir les environs");
        cta.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        box.add(title, sub, icons, cta);
        return sectionWrap(box, "#f6edd8");
    }

    private Component locationItem(VaadinIcon icon, String label) {
        VerticalLayout v = new VerticalLayout(new Icon(icon), new Span(label));
        v.setAlignItems(FlexComponent.Alignment.CENTER);
        v.setSpacing(false);
        v.getStyle().set("min-width", "180px");
        return v;
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
brand.addClassNames(LumoUtility.AlignSelf.CENTER, LumoUtility.Gap.MEDIUM, LumoUtility.Padding.SMALL, LumoUtility.Padding.Horizontal.XLARGE, LumoUtility.Padding.Vertical.LARGE);
        Div col1 = footerCol("Menu", "Chambres", "Services", "Salle de séminaire", "Galerie", "Contact");
        Div col2 = footerCol("Liens utiles", "Mentions légales", "Cookies");
        Div col3 = footerCol("Contact",
                "09 73 89 07 41",
                "hotel@example.com",
                "6115-117 rue Paradis, 13006 Marseille");

        cols.add(brand, col1, col2, col3);
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

    /* ────────────────────��  UTILITIES  ───���───────────────── */

    private HorizontalLayout twoCols(Component left, Component right) {
        HorizontalLayout row = new HorizontalLayout(left, right);
        //<theme-editor-local-classname>
        row.addClassName("home-page-horizontal-layout-1");
        row.setWidthFull();
        row.setPadding(false);
        row.setSpacing(true);
        row.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        row.setFlexGrow(1, left, right);
        row.addClassNames(LumoUtility.Gap.MEDIUM, LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);
        row.getStyle().set("padding-left", "24px").set("padding-right", "24px");
        right.getElement().getThemeList().add("spacing-l");
        left.getElement().getStyle().set("max-width", "560px").set("width", "100%");
        right.getElement().getStyle().set("max-width", "560px").set("width", "100%");
        right.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);
        return row;
    }

    private Component picture(String url) {
        Image img = new Image(url, "photo");
        //<theme-editor-local-classname>
        img.addClassName("home-page-img-1");
        img.setWidth("100%");
        img.setHeight("360px");
        img.getStyle()
                .set("max-width", "360px")
                .set("object-fit", "cover")
                .set("border-radius", "12px");
        return img;
    }

    private Component sectionWrap(Component innerContent, String backgroundColor) {
        // inner container limited to max width
        Div fullWidth = new Div();
        fullWidth.setWidthFull();
        fullWidth.getStyle()
                .set("padding", "28px 0")
                .set("width", "100vw")
                .set("display", "flex")
                .set("justify-content", "center"); // centre le container interne

        Div container = new Div(innerContent); // pour limiter le contenu
        container.getStyle()
                .set("max-width", "1120px")  // largeur max commune à toutes les sections
                .set("width", "100%");

        fullWidth.getStyle().set("background", backgroundColor);
        fullWidth.add(container);
        return fullWidth;
    }

private Button buildBestPriceBadge() {
        Button b = new Button("RÉSERVER AU MEILLEUR PRIX");
        b.addClickListener(e -> UI.getCurrent().navigate("home#bestprice"));
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

// burger -> show/hide menu
    private void toggleLeftMenu() {
        getElement().executeJs("""
      const m = this.querySelector('#leftMenu');
      if (!m) return;
      m.style.display = getComputedStyle(m).display === 'none' ? 'block' : 'none';
    """);
    }
}
