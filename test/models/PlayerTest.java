package models;

import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: jefklak
 * Date: 11/10/12
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest {

    @Test
    public void passwordMatches_TrueIfEqal() {
        assertThat(new Player("user", "pass").passwordMatches("pass")).isTrue();
    }

    @Test
    public void passwordMatches_FalseIfNotEqual() {
        assertThat(new Player("user", "pass").passwordMatches("de jos")).isFalse();
    }

    @Test
    public void passwordMatches_FalseIfNull() {
        assertThat(new Player("user", "pass").passwordMatches(null)).isFalse();
    }

}
