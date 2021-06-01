package com.marcelojssantos.dio.avanade.api.secutity;

public class SecurityConstants {

    /*
    * ATENÇÃO
    * O valor de SECRET não deve ser mudado, pois se for
    * parece, ainda não testei, que, se mudarmos dá problema
    * ao decriptar as senhas encriptadas c/ outro valor
    */
    public static final String SECRET = "SecretKeyGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 dias
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String STATUS_URL = "/status";
    public static final String SIGN_UP_URL = "/login";
  }