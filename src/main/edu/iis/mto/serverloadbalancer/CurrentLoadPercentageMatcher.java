package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {

    private double expectedLoadPercentage;

    public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
    }

    protected boolean matchesSafely(Server server) {
        return doublesAreEqual(server.currentLoadPercentage, expectedLoadPercentage);
    }

    private boolean doublesAreEqual(double currentLoadPercentage, double expectedLoadPercentage) {
        return expectedLoadPercentage == currentLoadPercentage || Math.abs(expectedLoadPercentage) - currentLoadPercentage < 0.01d;
    }

    public void describeTo(Description description) {
        description.appendText("a server with load percentage of").appendValue(expectedLoadPercentage);
    }

    public static CurrentLoadPercentageMatcher hasCurrentLoadOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
    }
}
