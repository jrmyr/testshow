package de.myrnet.testshow.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

class EntityHelperTest {

    private final static UserEntity USER_1 = new UserEntity(null, "Pre", "Last", 2);
    private final static UserEntity USER_2 = new UserEntity(null, "Pre", "Last", 4);
    private final static UserEntity USER_3 = new UserEntity(null, "Pre1", "Last1", 2);
    private final static UserEntity USER_4 = new UserEntity(null, "Pre", "Last1", 2);

    private static Stream userEntityArgumentLists() {
        return Stream.of(
                Arguments.of(USER_1, USER_2, true),
                Arguments.of(USER_1, USER_3, false),
                Arguments.of(USER_1, USER_4, false)
                );
    }

    @ParameterizedTest
    @MethodSource("userEntityArgumentLists")
    void isLogicallyEquals(UserEntity userEntity1, UserEntity userEntity2, boolean expectedResult) {
        assertThat("Fail!" , EntityHelper.isLogicallyEquals(userEntity1, userEntity2) == expectedResult);
    }

}
