package io.webfolder.ocean.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The name of a custom image&#39;s distribution. Currently, the valid values
 * are &#x60;Arch Linux&#x60;, &#x60;CentOS&#x60;, &#x60;CoreOS&#x60;,
 * &#x60;Debian&#x60;, &#x60;Fedora&#x60;, &#x60;Fedora Atomic&#x60;,
 * &#x60;FreeBSD&#x60;, &#x60;Gentoo&#x60;, &#x60;openSUSE&#x60;,
 * &#x60;RancherOS&#x60;, &#x60;Rocky Linux&#x60;, &#x60;Ubuntu&#x60;, and
 * &#x60;Unknown&#x60;. Any other value will be accepted but ignored, and
 * &#x60;Unknown&#x60; will be used in its place.
 */
public enum Distribution {

    ARCH_LINUX("Arch Linux"),

    CENTOS("CentOS"),

    COREOS("CoreOS"),

    DEBIAN("Debian"),

    FEDORA("Fedora"),

    FEDORA_ATOMIC("Fedora Atomic"),

    FREEBSD("FreeBSD"),

    GENTOO("Gentoo"),

    OPENSUSE("openSUSE"),

    RANCHEROS("RancherOS"),

    ROCKY_LINUX("Rocky Linux"),

    UBUNTU("Ubuntu"),

    UNKNOWN("Unknown");

    private String value;

    Distribution(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Distribution fromValue(String value) {
        for (Distribution b : Distribution.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}