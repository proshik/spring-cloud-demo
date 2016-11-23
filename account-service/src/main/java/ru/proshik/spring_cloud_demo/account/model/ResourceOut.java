package ru.proshik.spring_cloud_demo.account.model;

import java.util.Objects;

/**
 * Created by proshik on 04.10.16.
 */
@Deprecated
public class ResourceOut {

    private String key;
    private String value;

    public ResourceOut() {
    }

    public ResourceOut(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceOut that = (ResourceOut) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
