public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;
    public City(
            String name,
            String region,
            String district,
            int population,
            String foundation
    ){
        setName(name);
        setRegion(region);
        setDistrict(district);
        setPopulation(population);
        setFoundation(foundation);
    }
    public City(String[] list) {
        name = list[1];
        region = list[2];
        district = list[3];
        population = Integer.parseInt(list[4]);
        foundation = list.length < 6 ? "none" : list[5];
    }
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) throws IllegalArgumentException {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws IllegalArgumentException {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) throws IllegalArgumentException {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) throws IllegalArgumentException {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City: " +
                "name='" + getName() + '\'' +
                ", region='" + getRegion() + '\'' +
                ", district='" + getDistrict() + '\'' +
                ", population=" + getPopulation() +
                ", foundation='" + getFoundation() + '\n';
    }
}


