package asu.jdbc.model;

public class Website {
    private Integer id;
    private String name; // 站点名称
    private String url;
    private Integer alexa; // Alexa 排名
    private String country;  // 国家

    public Website() {
    }

    public Website(String name, String url, Integer alexa, String country) {
        this.name = name;
        this.url = url;
        this.alexa = alexa;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAlexa() {
        return alexa;
    }

    public void setAlexa(Integer alexa) {
        this.alexa = alexa;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", url: " + this.url;
    }
}
