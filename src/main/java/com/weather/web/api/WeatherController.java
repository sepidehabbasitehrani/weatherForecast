package com.weather.web.api;

import com.weather.data.Weather;
import com.weather.data.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/weather",
        produces="application/json")
@CrossOrigin(origins="*")

public class WeatherController {
    private final WeatherRepository weatherRepository;
    @Autowired
    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
    @GetMapping(path = "/predict/hourly/{cityCode}")
    public Weather getHourlyWeather(@PathVariable("cityCode") String cityCode)throws Exception{
        try {
            if (cityCode == null || cityCode.isEmpty())
                throw new Exception("cityCode has not been detected");
            Weather weather = weatherRepository.findByCityCode(Weather.CityCode.valueOf(cityCode.toUpperCase()));
            return weather;
        }catch (Exception ex){
            throw ex;
        }
    }

}
