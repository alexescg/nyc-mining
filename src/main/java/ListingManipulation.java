import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
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

    public void ignoreRowsWithNullField(String field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Class clazz = Listing.class;
        Method method = clazz.getDeclaredMethod("get" + capitalize(field));
        listings = listings.stream().filter(fieldFilter(method)).collect(Collectors.toList());
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

    private String capitalize(String toCapitalize) {
        return Character.toUpperCase(toCapitalize.charAt(0)) + toCapitalize.substring(1);
    }
}
