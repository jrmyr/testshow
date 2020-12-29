package de.myrnet.testshow.domain;

import java.util.Objects;

public class EntityHelper {

    public boolean logicallyEquals(UserEntity userEntity1, UserEntity userEntity2) {
        return Objects.equals(userEntity1.getPrename(), userEntity2.getPrename()) &&
                Objects.equals(userEntity1.getLastname(), userEntity2.getLastname());
    }

}
