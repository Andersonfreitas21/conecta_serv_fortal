package br.com.conectaservfortal.controller.auth.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
