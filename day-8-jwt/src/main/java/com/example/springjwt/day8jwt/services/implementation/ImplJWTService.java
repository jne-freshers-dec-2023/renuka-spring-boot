package com.example.springjwt.day8jwt.services.implementation;

import com.example.springjwt.day8jwt.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
@Service
public class ImplJWTService implements JWTService {

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 ))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

    }
    @Override
    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
     //to extract the username from token
    private  <T> T extractClaim(String token, Function<Claims, T>claimsResolvers){
        final  Claims claims= extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }
    private  Claims extractAllClaims(String token){
        return  Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
    private Key getSignKey(){
        byte[] key= Decoders.BASE64.decode("233643t6854dw737udue37468762662K737439E74364366382Y347434G");
        return Keys.hmacShaKeyFor(key);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
