package com.overlook.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import java.lang.management.ManagementFactory;

public class MainViewIT {

    Page page;

    @BeforeEach
    public void setup() {
        String args = ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
        Boolean headed = args.contains("jdwp") || Boolean.getBoolean("headed");
        LaunchOptions ops = new BrowserType.LaunchOptions().setHeadless(!headed);
        page = Playwright.create().chromium().launch(ops).newContext().newPage();
        page.setDefaultTimeout(30000);
        page.navigate("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown() {
        page.context().browser().close();
    }

    @Test
    public void testInitialStateOfMainView() throws Exception {
        // Given the user is on the page MainView
        // (This is implicitly handled by the setup method)

        // Then the user should see a vertical layout with tag name 'vaadin-vertical-layout'
        Locator verticalLayout = page.locator("vaadin-vertical-layout");
        PlaywrightAssertions.assertThat(verticalLayout).isVisible();

        // And the user should see a header with tag name 'h1' and text 'Welcome to the Overlook Hotel!'
        Locator header = page.locator("h1");
        header = header.filter(new Locator.FilterOptions().setHasText("Welcome to the Overlook Hotel!"));
        PlaywrightAssertions.assertThat(header).isVisible();
    }
}