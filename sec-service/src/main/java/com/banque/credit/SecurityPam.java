package com.banque.credit;

public interface SecurityPam {

    public static final String JWT_HEADER_NAME="Authorization";

    public static final  String SECRET  = "Motsecretpourpourcreationtoken";

    public static final long EXPIRATION = 10 * 24 * 3600;

    public static final String HEADER_PREFIX="Bearer ";
}

