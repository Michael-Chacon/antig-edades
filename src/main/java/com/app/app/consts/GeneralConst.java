package com.app.app.consts;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class GeneralConst {
    public static final String ID_IN_PATH = "/{id}";
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

}
