package com.example.springjwt.day8jwt.config;

import com.example.springjwt.day8jwt.services.JWTService;
import com.example.springjwt.day8jwt.services.implementation.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private  JWTService jwtService;

    @Autowired
    private UserServiceImpl userDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            System.out.println("In filter ");
            final String authHeader = request.getHeader("Authorization");
            System.out.println("Auth header "+authHeader);
             String jwt = null;
             String userEmail = null;
//            if(StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
//                System.out.println("in first if");
//                filterChain.doFilter(request, response);
//                System.out.println("filter");
//                System.out.println(authHeader);
//                return;
//            }
//                jwt = authHeader.substring(7);
//                userEmail = jwtService.extractUsername(jwt);
//            System.out.println(">>>"+userEmail);
//            if(StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
//                System.out.println("inside second if");
//                UserDetails userDetails =userService.userDetailsService().loadUserByUsername(userEmail);
//                //validating user  jwt token
//                if(jwtService.isTokenValid(jwt, userDetails)){
//                    System.out.println("valid token");
//                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//
//                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
//                            userDetails,null,userDetails.getAuthorities());
//
//                    token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    securityContext.setAuthentication(token);
//                    SecurityContextHolder.setContext(securityContext);
//                    System.out.println("created security context");
//                }

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                System.out.println("inside 1st  if");
                jwt = authHeader.substring(7);
                userEmail = jwtService.extractUsername(jwt);
            }

            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                System.out.println("inside 2nd filter");
                UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request,response);

        } catch (Exception e){
            System.out.println("Error message"+e.getMessage());
        }
    }


}
