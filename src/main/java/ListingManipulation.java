import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author alexescg
 * @version 1.0
 * @since 9/3/2016
 */
public class ListingManipulation {

    private List<Listing> listings;

    public List<Listing> getListings() {
        return listings;
    }

    public ListingManipulation(List<Listing> listings) {
        this.listings = listings;
    }

    /**
     * Filter rows that contain a null value in a column
     *
     * @param field column to filter value from
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public void ignoreRowsWithNullField(String field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Class clazz = Listing.class;
        Method getterMethod = clazz.getDeclaredMethod("get" + capitalize(field));
        listings = listings.stream().filter(fieldFilter(getterMethod)).collect(Collectors.toList());
    }

    /**
     * Obtain mode from field within listing collection.
     *
     * @param field to obtain mode from
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public String getModeFromField(String field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class clazz = Listing.class;
        Method getterMethod = clazz.getDeclaredMethod("get" + capitalize(field));

        HashMap<String, Integer> ocurrences = new HashMap<>();

        for (Listing listing : listings) {
            Object methodOutput = getterMethod.invoke(listing);
            if (methodOutput != null) {
                if (methodOutput.toString() != "null") {
                    if (!ocurrences.containsKey(methodOutput)) {
                        ocurrences.put(methodOutput.toString(), 1);
                    } else {
                        ocurrences.replace(methodOutput.toString(), ocurrences.get(methodOutput.toString()) + 1);
                    }
                }
            }
        }

        return ocurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }

    private Predicate<Listing> fieldFilter(Method method) {
        return listing -> {
            try {
                return method.invoke(listing) != null;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return false;
            }
        };
    }

    /**
     * Make first letter of a word uppercase.
     *
     * @param toCapitalize word to capitalize
     * @return capitalized word
     */
    private String capitalize(String toCapitalize) {
        return Character.toUpperCase(toCapitalize.charAt(0)) + toCapitalize.substring(1);
    }
}
