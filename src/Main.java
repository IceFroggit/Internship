import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static final String CSV_FILENAME = "C:\\Users\\aikak\\Downloads\\Задача ВС Java Сбер (1).csv";

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<City> cityList = readFileConsolWrite(CSV_FILENAME);
        showCityList(cityList);
        cityList = sortByName(cityList);
        System.out.println('\n'+"Sorted by name");
        showCityList(cityList);
        cityList = sortByNameAndRegion(cityList);
        System.out.println('\n'+"Sorted by name and region");
        showCityList(cityList);

    }

    public static ArrayList<City> readFileConsolWrite(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        ArrayList<City> cityList = new ArrayList();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(";");
            City city = new City(line);
            cityList.add(city);
        }
        sc.close();
        return cityList;
    }
    private static void showCityList(ArrayList<City> cityList){
        for (City city : cityList){
            System.out.println(city.toString());
        }
    }
    public static ArrayList<City> sortList(ArrayList<City> cityList, Comparator<City> comparator) {
        ArrayList<City> result = new ArrayList<City>();
        result.addAll(cityList.stream().sorted(comparator).toList());
        return result;
    }
    public static ArrayList<City> sortByName(ArrayList<City> cityList) {
        Comparator<City> comparator = Comparator.comparing(city -> city.getName().toLowerCase());
        return sortList(cityList,comparator);
    }

    public static ArrayList<City> sortByNameAndRegion(ArrayList<City> cityList) {
        Comparator<City> comparator = Comparator.comparing(City::getDistrict);
        comparator = comparator.thenComparing(City::getName);
        return sortList(cityList,comparator);
    }


}
