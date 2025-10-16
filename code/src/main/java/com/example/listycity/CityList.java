
package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains a collection of {@link City} objects and provides operations
 * such as add, delete, membership check, count, and sorted retrieval.
 */
public class CityList {

    /** Internal mutable list of cities. */
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it does not already exist.
     *
     * @param city the candidate city to add
     * @throws IllegalArgumentException if the given city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists: " + city);
        }
        cities.add(city);
    }

    /**
     * Returns whether the provided city is present in the list.
     *
     * @param city the city to check
     * @return true if present; false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes the provided city if it exists; otherwise throws an exception.
     *
     * @param city the city to delete
     * @throws IllegalArgumentException if the city is not present
     */
    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException("City not found: " + city);
        }
    }

    /**
     * Returns the number of cities in the list.
     *
     * @return the count of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a sorted copy of the current cities, ordered by city name then province.
     *
     * @return sorted list of cities
     */
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        Collections.sort(copy);
        return copy;
    }
}
