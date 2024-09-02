package io.github.awais2075.restcountries.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.awais2075.restcountries.dto.Country;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class RestCountry {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String BASE_URL = "https://restcountries.com/v3.1";

    public static List<Country> getAll() {
        return getRestCountries("/all");
    }

    public static List<Country> searchByName(String name) {
        return getRestCountries(String.format("/name/%s", name));
    }

    public static List<Country> searchByFullName(String name) {
        return getRestCountries(String.format("/name/%s?fullText=true", name));
    }

    public static List<Country> searchByCode(String code) {
        return getRestCountries(String.format("/aplha/%s", code));
    }

    public static List<Country> searchByListOfCodes(String[] codes) {
        return getRestCountries(String.format("/alpha?codes=%s", StringUtils.joinWith(",", codes)));
    }

    public static List<Country> searchByCurrency(String currency) {
        return getRestCountries(String.format("/currency/%s", currency));
    }

    public static List<Country> searchByDemonym(String demonym) {
        return getRestCountries(String.format("/demonym/%s", demonym));
    }

    public static List<Country> searchByLanguage(String language) {
        return getRestCountries(String.format("/lang/%s", language));
    }

    public static List<Country> searchByCapital(String capital) {
        return getRestCountries(String.format("/capital/%s", capital));
    }

    public static List<Country> searchByRegion(String region) {
        return getRestCountries(String.format("/region/%s", region));
    }

    public static List<Country> searchBySubregion(String subregion) {
        return getRestCountries(String.format("/subregion/%s", subregion));
    }

    public static List<Country> searchByTranslation(String translation) {
        return getRestCountries(String.format("/translation/%s", translation));
    }

    private static List<Country> getRestCountries(String uri) {
        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL.concat(uri).replace(" ", "%20")))
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(response.body(), new TypeReference<>() {});
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
