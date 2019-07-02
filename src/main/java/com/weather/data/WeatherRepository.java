package com.weather.data;

import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    public Weather findByCityCode(Weather.CityCode cityCode);

}
