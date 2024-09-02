package io.github.awais2075.restcountries.dto;

import java.util.Map;

public class Name {

    private String common;
    private String official;
    private Map<String, Native> nativeName;

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public Map<String, Native> getNativeName() {
        return nativeName;
    }

    public void setNativeName(Map<String, Native> nativeName) {
        this.nativeName = nativeName;
    }
}
