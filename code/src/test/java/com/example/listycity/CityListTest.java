
package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class CityListTest {

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAddAndAddException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City regina = new City("Regina", "Saskatchewan");
        cityList.add(regina);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(regina));

        // Adding duplicate should throw
        assertThrows(IllegalArgumentException.class, () -> cityList.add(regina));
        assertThrows(IllegalArgumentException.class, () -> cityList.add(mockCity()));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City other = new City("Calgary", "Alberta");
        assertTrue(cityList.hasCity(mockCity()));
        assertFalse(cityList.hasCity(other));
    }

    @Test
    void testDeleteAndException() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "Alberta");
        cityList.add(calgary);
        assertTrue(cityList.hasCity(calgary));
        cityList.delete(calgary);
        assertFalse(cityList.hasCity(calgary));

        // deleting absent city throws
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(calgary));
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        cityList.add(new City("Charlottetown", "Prince Edward Island"));
        assertEquals(3, cityList.countCities());
    }

    @Test
    void testGetCitiesSortedOrder() {
        CityList cityList = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");
        City banff = new City("Banff", "Alberta");
        cityList.add(edmonton);
        cityList.add(calgary);
        cityList.add(banff);

        List<City> sorted = cityList.getCities();
        assertEquals(banff, sorted.get(0));   // Banff
        assertEquals(calgary, sorted.get(1)); // Calgary
        assertEquals(edmonton, sorted.get(2)); // Edmonton
    }
}
