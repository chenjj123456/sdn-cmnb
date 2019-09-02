package com.gwtt.ems.cmnb.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;


public class Uuid implements Serializable {
    private static final long serialVersionUID = -6700962668564346825L;
    private static final Pattern[] patterns;
    public static final List<String> PATTERN_CONSTANTS = ImmutableList.of("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    private final String _value;

    private static void check_valueLength(final String value) {
        int length = value.length();
        if (length < 0) {
            throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[0‥2147483647]].", value));
        }
    }

    @ConstructorProperties({"value"})
    public Uuid(String _value) {
        if (_value != null) {
            check_valueLength(_value);
        }

        Preconditions.checkNotNull(_value, "Supplied value may not be null");
        Pattern[] var2 = patterns;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Pattern p = var2[var4];
            Preconditions.checkArgument(p.matcher(_value).matches(), "Supplied value \"%s\" does not match required pattern \"%s\"", new Object[]{_value, p});
        }

        this._value = _value;
    }

    public Uuid(Uuid source) {
        this._value = source._value;
    }

    public static Uuid getDefaultInstance(String defaultValue) {
        return new Uuid(defaultValue);
    }

    public String getValue() {
        return this._value;
    }

    public int hashCode() {
        boolean prime = true;
        int result = 1;
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Uuid other = (Uuid)obj;
            return Objects.equals(this._value, other._value);
        }
    }

    public String toString() {
        StringBuilder builder = (new StringBuilder(Uuid.class.getSimpleName())).append(" [");
        boolean first = true;
        if (this._value != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }

            builder.append("_value=");
            builder.append(this._value);
        }

        return builder.append(']').toString();
    }

    static {
        Pattern[] a = new Pattern[PATTERN_CONSTANTS.size()];
        int i = 0;

        String regEx;
        for(Iterator var2 = PATTERN_CONSTANTS.iterator(); var2.hasNext(); a[i++] = Pattern.compile(regEx)) {
            regEx = (String)var2.next();
        }

        patterns = a;
    }
}
