package de.myrnet.testshow.domain;

import java.util.Objects;

public class EntityHelper {

    public static boolean isLogicallyEquals(UserEntity userEntity1, UserEntity userEntity2) {
         return hasSamePrename(userEntity1, userEntity2) && hasSameLastname(userEntity1, userEntity2);
    }

    private static boolean hasSamePrename(UserEntity userEntity1, UserEntity userEntity2) {
        return Objects.equals(userEntity1.getPrename(), userEntity2.getPrename());
    }

    private static boolean hasSameLastname(UserEntity userEntity1, UserEntity userEntity2) {
        return Objects.equals(userEntity1.getLastname(), userEntity2.getLastname());
    }

}
