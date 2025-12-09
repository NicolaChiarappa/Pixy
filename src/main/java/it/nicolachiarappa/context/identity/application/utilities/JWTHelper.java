package it.nicolachiarappa.context.identity.application.utilities;

import it.nicolachiarappa.context.identity.domain.models.User;

public interface JWTHelper {



    String generate(User user, Integer duration);

    String extractUsername(String token);


}
