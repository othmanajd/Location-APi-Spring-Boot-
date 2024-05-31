package com.appmobile.Exception;

public enum ErrorCodes {
    Utilisateur_NOT_FOUND(1000),
    Utilisateur_NOT_VALID(1001),
    Utilisateur_ALREADY_IN_USE(1002),
    BAD_CREDENTIALS(1003); // Ajoute cette ligne avec le code approprié

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
