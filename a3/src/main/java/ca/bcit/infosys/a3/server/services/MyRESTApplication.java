package ca.bcit.infosys.a3.server.services;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * RestEasy Application.
 */
public class MyRESTApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public MyRESTApplication() {
        classes.add(UserResource.class);
        classes.add(QuizResource.class);
        classes.add(ResultResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
