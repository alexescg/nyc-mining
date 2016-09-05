import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author alexescg
 * @version 1.0
 * @since 9/4/2016
 */
public class ListingManipulationTest {

    ListingManipulation listingManipulation;
    List<Listing> listings;
    Integer dataSetSize = 38810;

    @Before
    public void prepareSuite() {
        Parser parser = new Parser("listings.csv");
        listings = parser.parseCsv();
    }

    @Test
    public void ignoreRowsWithNullFieldTest() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        ListingManipulation listingManipulation = new ListingManipulation(listings);
        listingManipulation.ignoreRowsWithNullField("has_availability");
        assert (listingManipulation.getListings().size() == 0);
    }

    @Test
    public void replaceNullWithValueUsingAnnotation() {
        ListingManipulation listingManipulation = new ListingManipulation(listings);
        List<Listing> checkedListings = listingManipulation.getListings()
                .stream()
                .filter(listing -> listing.getReviews_per_month() != null && listing.getReviews_per_month() >= 0)
                .collect(Collectors.toList());

        assert (checkedListings.size() == dataSetSize);
    }

    @Test
    public void replaceNullWithMode() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ListingManipulation listingManipulation = new ListingManipulation(listings);
        String mode = listingManipulation.getModeFromField("market");
        listingManipulation.getListings().stream().filter(listing -> listing.getMarket() == null).forEach(listing -> {
            listing.setMarket(mode);
        });
        List<Listing> replacedWithModeListings = listingManipulation.getListings().stream().filter(listing -> listing.getMarket() == null).collect(Collectors.toList());
        assert (replacedWithModeListings.size() == 0);
    }

    @Test
    public void getAverageWeeklyFromAparments() {
        ListingManipulation listingManipulation = new ListingManipulation(listings);
        listingManipulation.filterApartmentListings();
        listingManipulation.fillMissingWeeklyPrices();
        listingManipulation.fetchWeeklyPrices();
    }

}
