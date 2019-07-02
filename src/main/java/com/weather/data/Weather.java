package com.weather.data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="t_weather")
public class Weather /*implements Serializable*/{
    public Weather(){

    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "f_id")
    private Integer id;

    @NotNull
    @Column(name = "f_city_code")
    private CityCode cityCode;
    public static enum CityCode {
        TABRIZ, MASHHAD, TEHRAN, ISFAHAN, SHIRAZ
    }

    @OneToMany(mappedBy = "weather")
    private List<HourlyForecast> hourlyForecast;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityCode getCityCode() {
        return cityCode;
    }

    public List<HourlyForecast> getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(List<HourlyForecast> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public void setCityCode(CityCode cityCode) {
        this.cityCode = cityCode;
    }


}
