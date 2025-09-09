package com.overlook.hotel;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends VaadinWebSecurity {

    @Bean
  AuthenticationSuccessHandler successHandler() {
    var h = new SimpleUrlAuthenticationSuccessHandler("/");
    h.setAlwaysUseDefaultTargetUrl(true); // ignore saved request => no ?continue
    return h;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // This sets up CSRF, session management, static resource rules,
    // and whitelists all Vaadin internal endpoints.
    super.configure(http);

   // Send users to "/" after a successful login, always
    setLoginView(http, LoginView.class, "/");

    http.httpBasic(c -> c.disable());      // <-- disable Basic auth popup
  }
}
