
package com.example.listycity;

import java.util.Objects;

/**
 * Represents a City with a name and a province/state.
 * <p>
 * This class is immutable and implements {@link Comparable} so that
 * cities can be sorted lexicographically by city name, then by province name.
 */
public class City implements Comparable<City> {
    /** The city name, e.g., "Edmonton". */
    private final String city;
    /** The province or state name, e.g., "Alberta". */
    private final String province;

    /**
     * Constructs a new {@code City}.
     *
     * @param city     the city name (non-null)
     * @param province the province/state name (non-null)
     * @throws NullPointerException if any argument is null
     */
    public City(String city, String province) {
        this.city = Objects.requireNonNull(city, "city");
        this.province = Objects.requireNonNull(province, "province");
    }

    /**
     * Returns the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Returns the province or state name.
     *
     * @return the province/state name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Defines natural ordering: compare by city name, then by province.
     *
     * @param other other city to compare to
     * @return a negative, zero, or positive integer as this city is less than,
     * equal to, or greater than the specified city
     */
    @Override
    public int compareTo(City other) {
        int byCity = this.city.compareTo(other.getCityName());
        if (byCity != 0) return byCity;
        return this.province.compareTo(other.getProvinceName());
    }

    /**
     * Two cities are equal if both their city and province names are equal.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    /**
     * Hash code consistent with {@link #equals(Object)}.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    /**
     * Returns a human-readable representation of this city.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return city + ", " + province;
    }
}
