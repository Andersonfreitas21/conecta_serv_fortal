package br.com.conectaservfortal.controller.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
