package com.overlook.hotel;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.PermitAll;

@PageTitle("Helloworld Hôtel – Accueil")
@PermitAll
@Route("home")
@RouteAlias("") // page par défaut
public class HomePage extends Div {

    public HomePage() {
        setSizeFull();
        getStyle()
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("background", "var(--lumo-base-color)");

        // === TOP BAR ============================================================
        HorizontalLayout topbar = new HorizontalLayout();
        topbar.setWidthFull();
        topbar.setPadding(true);
        topbar.setSpacing(true);
        topbar.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        topbar.getStyle()
                .set("position", "sticky")
                .set("top", "0")
                .set("z-index", "10")
                .set("background", "white")
                .set("border-bottom", "1px solid rgba(0,0,0,0.06)");

        // À gauche : burger + langue
        Button burger = new Button(new Icon(VaadinIcon.MENU));
        burger.getElement().setProperty("title", "Menu");
        burger.addClickListener(e -> toggleLeftMenu());
        burger.getStyle().set("border-radius", "999px");

        ComboBox<String> lang = new ComboBox<>();
        lang.setItems("FR", "EN", "ES");
        lang.setValue("FR");
        lang.setWidth("90px");

        HorizontalLayout leftTop = new HorizontalLayout(burger, lang);
        leftTop.setSpacing(true);
        leftTop.setAlignItems(FlexComponent.Alignment.CENTER);

        // Centre : logo
        Span logo = new Span("Hello World");
        logo.getStyle()
                .set("font-weight", "700")
                .set("font-size", "28px")
                .set("color", "#d2a736"); // doré
//         Sous-titre en tout petit (facultatif)
         Span subtitle = new Span("HÔTEL");
         subtitle.getStyle().set("font-size", "12px").set("letter-spacing", "2px");

        // À droite : téléphone + réserver
        TextField phone = new TextField();
        phone.setValue("06 99 99 99 99");
        phone.setClearButtonVisible(false);
        phone.setReadOnly(true);
        phone.setWidth("170px");
        phone.getStyle()
                .set("background", "white")
                .set("border", "1px solid #c7d5d8");

        Button reserver = new Button("Réserver", e ->
                UI.getCurrent().getPage().open("#reservation")); // à relier plus tard
        reserver.addClickShortcut(Key.ENTER);
        reserver.getStyle()
                .set("background", "#2e6d71")
                .set("color", "white");

        HorizontalLayout rightTop = new HorizontalLayout(phone, reserver);
        rightTop.setSpacing(true);
        rightTop.setAlignItems(FlexComponent.Alignment.CENTER);

        // On pousse le centre au milieu
        topbar.setFlexGrow(1, leftTop);
        topbar.setFlexGrow(1, rightTop);

        topbar.add(leftTop, new Div(logo), rightTop);
        add(topbar);

        // === CORPS (LAYOUT 2 COLONNES) ==========================================
        HorizontalLayout body = new HorizontalLayout();
        body.setWidthFull();
        body.setHeightFull();
        body.setPadding(false);
        body.setSpacing(false);

        // --- Colonne gauche : menu large ---------------------------------------
        VerticalLayout leftMenu = new VerticalLayout();
        leftMenu.setId("leftMenu");
        leftMenu.setPadding(true);
        leftMenu.setSpacing(false);
        leftMenu.setWidth("420px");
        leftMenu.getStyle()
                .set("border-right", "1px solid rgba(0,0,0,0.06)")
                .set("background", "white");

        leftMenu.add(menuItem("CHAMBRES"),
                separator(),
                menuItem("SERVICES"),
                separator(),
                menuItem("SALLE DE SÉMINAIRE"),
                separator(),
                menuItem("LES ENVIRONS"),
                separator(),
                menuItem("GALERIE PHOTOS"),
                separator(),
                menuItem("CONTACT"));

        // --- Colonne droite : hero + contenu -----------------------------------
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setPadding(false);
        content.setSpacing(false);
        content.getStyle().set("display","flex").set("flex-direction","column");


        Div hero = new Div();
        hero.addClassName("hero");
        hero.getStyle()
                .set("width", "100%")
                .set("min-height", "70vh")                // important pour voir le bg
                .set("display", "flex")
                .set("align-items", "center")
                .set("background", "var(--hero-bg)");     // on va mettre l'image via CSS

        Div heroContent = new Div();
        heroContent.addClassName("hero-content");
        heroContent.getStyle()
                .set("margin", "0 auto")                  // centre horizontalement
                .set("max-width", "860px")
                .set("padding", "2rem");

        H1 title = new H1("Bienvenue à l'Hello World");
        title.getStyle().set("margin", "0 0 .5rem 0");

        Paragraph subtitle2 = new Paragraph("HÔTEL 4 ÉTOILES À MARSEILLE");
        subtitle2.getStyle().set("margin", "0 0 1rem 0")
                .set("letter-spacing", ".12em");

        Button cta = new Button("Découvrir les chambres");
        cta.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        heroContent.add(title, subtitle, cta);
        hero.add(heroContent);

        content.add(hero);

        // === Assembler les deux colonnes dans le body ============================
// NEW
        body.add(leftMenu, content);
        body.setFlexGrow(1, content);   // la partie droite prend tout l’espace
// NEW
        add(body);                      // ajouter le body dans la page (après la top

        // === Badge vertical à droite ============================================
        Button bestPrice = new Button("RÉSERVER AU MEILLEUR PRIX");
        bestPrice.addClickListener(e -> UI.getCurrent().navigate("home#bestprice"));
        bestPrice.getStyle()
                .set("position", "fixed")
                .set("right", "-70px")     // sort un peu à droite
                .set("top", "45%")
                .set("transform", "rotate(-90deg)")
                .set("background", "#5c7b7e")
                .set("color", "white")
                .set("letter-spacing", "1px");
        add(bestPrice);
    }

    // === Composants ===========================================================

    private Component menuItem(String label) {
        H3 h = new H3(label);
        h.getStyle()
                .set("font-weight", "600")
                .set("letter-spacing", "1px")
                .set("margin", "18px 0");
        Div wrap = new Div(h);
        wrap.getStyle().set("cursor", "pointer");
        wrap.addClickListener(e -> {
            // Navigation future : UI.getCurrent().navigate(...);
            h.getElement().callJsFunction("scrollIntoView", true);
        });
        return wrap;
    }

    private Hr separator() {
        Hr hr = new Hr();
        hr.getStyle().set("opacity", "0.3");
        return hr;
    }

    private Div buildHero() {
        // Image héro : mets ici une URL publique ou un fichier du dossier frontend
        String heroUrl =
                "https://images.unsplash.com/photo-1554995207-c18c203602cb?q=80&w=1600&auto=format&fit=crop"; // placeholder

        Div hero = new Div();
        hero.setHeight("560px");
        hero.getStyle()
                .set("position", "relative")
                .set("background-image", "url('" + heroUrl + "')")
                .set("background-size", "cover")
                .set("background-position", "center")
                .set("filter", "saturate(90%)");

        // Calque sombre pour le contraste du texte
        Div overlay = new Div();
        overlay.getStyle()
                .set("position", "absolute")
                .set("inset", "0")
                .set("background", "rgba(0,0,0,0.35)");
        hero.add(overlay);

        // Bloc de texte centré
        VerticalLayout text = new VerticalLayout();
        text.setWidthFull();
        text.setHeightFull();
        text.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        text.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        text.getStyle()
                .set("position", "absolute")
                .set("inset", "0")
                .set("color", "white")
                .set("text-align", "center");

        H1 t1 = new H1("Bienvenue à l'hôtel le");
        t1.getStyle().set("margin", "0").set("font-size", "42px");

        H1 t2 = new H1("M");
        t2.getStyle().set("margin", "0").set("font-size", "64px");

        Paragraph sub = new Paragraph("HÔTEL 3 ÉTOILES À MARSEILLE");
        sub.getStyle().set("margin-top", "12px").set("letter-spacing", "1px");

        Button cta = new Button("Découvrir les chambres", e -> UI.getCurrent().navigate("home#rooms"));
        cta.getStyle()
                .set("margin-top", "24px")
                .set("background", "rgba(255,255,255,0.9)")
                .set("color", "#1b1b1b");

        text.add(t1, t2, sub, cta);
        hero.add(text);
        return hero;
    }

    // Montre / cache la colonne de gauche en mobile/burger
    private void toggleLeftMenu() {
        getElement().executeJs("""
      const m = this.querySelector('#leftMenu');
      if (!m) return;
      const shown = getComputedStyle(m).display !== 'none';
      m.style.display = shown ? 'none' : 'block';
    """);
    }
}
