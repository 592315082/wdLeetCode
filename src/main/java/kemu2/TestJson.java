package kemu2;

import java.util.LinkedList;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class TestJson {

    public static void main(String[] args) {
        List<Weather> list = new LinkedList<>();
        Weather weather1 = new Weather();
        weather1.setSunny("1111");
        weather1.setRain("2222");
        Weather weather2 = new Weather();
        weather2.setSunny("333");
        weather2.setRain("444");
        list.add(weather1);
        list.add(weather2);
        String json = JSON.toJSONString(list);
        System.out.println(json);
    }



}

class Weather {
    private String sunny;

    private String rain;

    public String getSunny() {
        return sunny;
    }

    public void setSunny(String sunny) {
        this.sunny = sunny;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }
}