package org.eclipse.nebula.snippets.grid.wrapper.data;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    public static List<PeopleDTO> getPeople() {
        List<PeopleDTO> people = new ArrayList<PeopleDTO>(4);
        people.add(new PeopleDTO("Amanda", 17, false, null));
        people.add(new PeopleDTO("Bob", 20, true, "student"));
        people.add(new PeopleDTO("Adam", 25, true, "senior java developer"));
        people.add(new PeopleDTO("Alex", 24, false, "middle PHP developer; know Drupal"));
        return people;
    }
}
