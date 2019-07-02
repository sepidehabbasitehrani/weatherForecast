package com.weather.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_hourly_forecast")
public class HourlyForecast{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "f_id")
    private Integer id;
    @NotNull
    @Column(name = "f_max_temp")
    private String maxTemp;
    @NotNull
    @Column(name = "f_min_temp")
    private String minTemp;
    @NotNull
    @Column(name = "f_hour")
    private String hour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_weather")
    Weather weather;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
