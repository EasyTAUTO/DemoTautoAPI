package org.example.utils;

import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

public class JSONFile {
    public CustomComparator getStrictCustomComparator() {
        return new CustomComparator(JSONCompareMode.STRICT,
                new Customization("data[1].id", (o1, o2) -> true),
                new Customization("data[3].email", (o1, o2) -> true)
        );
    }
}
