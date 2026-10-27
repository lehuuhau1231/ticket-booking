package com.lhh.ticket_booking.infrastructure.security;

import com.lhh.ticket_booking.application.port.out.TokenProviderPort;
import com.lhh.ticket_booking.domain.model.User;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
@Slf4j
public class NimbusJwtTokenAdapter implements TokenProviderPort {

    @Value("${jwt.signerKey}")
    private String signerKey;

    @Override
    public String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(String.valueOf(user.getId()))
                .issuer("lehuuhau.com")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .claim("role", user.getRole().name())
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(signerKey.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot generate token: ", e);
            throw new RuntimeException("Cannot generate token", e);
        }
    }

    @Override
    public boolean validateToken(String token) {
        try {
            JWSVerifier verifier = new MACVerifier(signerKey.getBytes());
            SignedJWT signedJWT = SignedJWT.parse(token);
            boolean verified = signedJWT.verify(verifier);
            JWTClaimsSet claimSet = signedJWT.getJWTClaimsSet();

            return verified && claimSet.getExpirationTime().after(new Date());
        } catch (Exception e) {
            log.error("Error validating token: ", e);
            return false;
        }
    }

    @Override
    public String getRoleFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claimSet = signedJWT.getJWTClaimsSet();
            return claimSet.getClaim("role").toString();
        } catch (Exception e) {
            log.error("Error getting role from token: ", e);
            throw new RuntimeException("Error getting role from token: ", e);
        }
    }

    @Override
    public String getUserIdFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claimSet = signedJWT.getJWTClaimsSet();
            return claimSet.getSubject();
        } catch (Exception e) {
            log.error("Error getting userId from token: ", e);
            throw new RuntimeException("Error getting userId from token: ", e);
        }
    }
}
