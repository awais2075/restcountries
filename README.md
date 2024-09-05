# restcountries

[![Maven Central](https://img.shields.io/maven-central/v/io.github.awais2075/restcountries.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.awais2075/restcountries)

A Java library for accessing information about countries from the [REST Countries API](https://restcountries.com/). This library provides a simple interface for fetching country details such as names, capitals, population, currencies, and much more.

## Features

- Fetch country data by name, code, or region.
- Retrieve country details like capital, population, currency, languages, and more.
- Support for filtering and searching countries based on various criteria.

## Installation

### Maven

To use this library in your Maven project, add the following dependency to your `pom.xml`:

```xml
<dependency>
  <groupId>io.github.awais2075</groupId>
  <artifactId>restcountries</artifactId>
  <version>1.0.0</version> <!-- Replace with the latest version -->
</dependency>
```

### Gradle

To use this library in your Gradle project, add the following dependency to your `build.gradle`:

```
implementation 'io.github.awais2075:restcountries:1.0.0' // Replace with the latest version
```

### Methods
```
public Country getCountryByName(String countryName);

public Country getCountryByCode(String countryCode);

public List<Country> getCountriesByCurrency(String currency);

public List<Country> getCountriesByLanguage(String language);

public List<Country> getAllCountries();

public List<Country> getCountriesByRegion(String region);

public List<Country> getCountriesBySubregion(String subregion);

public List<Country> searchCountriesByPartialName(String partialName);
```


### Code Usage
```
import io.github.awais2075.restcountries.RestCountries;
import io.github.awais2075.restcountries.model.Country;

public class Main {
    public static void main(String[] args) {
        // Create an instance of RestCountries
        RestCountries restCountries = new RestCountries();

        // Fetch country details by name
        Country country = restCountries.getCountryByName("Canada");
        System.out.println("Country: " + country.getName());
        System.out.println("Capital: " + country.getCapital());
        System.out.println("Population: " + country.getPopulation());
        System.out.println("Currency: " + country.getCurrencies().get(0).getName());
        
        // get All Countries
        List<Country> countries = restCountries.getAllCountries();
        countries.forEach(country -> System.out.println(country.getName()));
        
        // get Country by Region
        List<Country> asianCountries = restCountries.getCountriesByRegion("Asia");
        asianCountries.forEach(country -> System.out.println(country.getName()));
    }
}
```

#### Contact
for any queries, please email at awais2075@gmail.com
