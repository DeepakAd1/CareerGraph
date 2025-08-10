package com.example.NetConnect.controller;

import com.example.NetConnect.object.RefreshToken;
import com.example.NetConnect.service.RefreshTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final RefreshTokenService refreshTokenService;

    public TokenController(RefreshTokenService refreshTokenService) {
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateToken(@RequestParam Long userId) {
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userId);
        return ResponseEntity.ok(Map.of(
                "refreshToken", refreshToken.getToken(),
                "expiryDate", refreshToken.getExpiryDate()
        ));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestParam String token) {
        return refreshTokenService.findByToken(token)
                .map(rt -> refreshTokenService.isTokenValid(rt)
                        ? ResponseEntity.ok("Valid Token")
                        : ResponseEntity.status(401).body("Invalid or expired token"))
                .orElse(ResponseEntity.status(404).body("Token not found"));
    }

    @PostMapping("/revoke")
    public ResponseEntity<?> revokeToken(@RequestParam String token) {
        refreshTokenService.revokeToken(token);
        return ResponseEntity.ok("Token revoked");
    }
}

