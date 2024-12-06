package com.example.TrabalhoCarlao02.util.security.token;

import com.example.TrabalhoCarlao02.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final PW3TokenService pw3tokenservice;
    private final UsuarioRepository repository;

    public SecurityFilter(PW3TokenService pw3TokenService, UsuarioRepository repository) {
        this.pw3tokenservice = pw3TokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            var authorizationHeader = request.getHeader("Authorization");

            if (authorizationHeader != null) {
                authorizationHeader = authorizationHeader.replace("Bearer ", "");
                var subject = pw3tokenservice.getSubject(authorizationHeader);
                var usuario = repository.findByLogin(subject);

                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            if (response.getStatus() == 403) {
                System.out.println("Erro 403 ocorreu: " + e.getMessage());
            }
            throw e;
        }
    }
}
