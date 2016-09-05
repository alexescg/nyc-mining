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

    private BigDecimal getWeeklyPriceIncreaseAsPercent(BigDecimal dailyApartmentPriceAverage, BigDecimal weeklyApartmentPriceAverage) {
        return dailyApartmentPriceAverage.divide(weeklyApartmentPriceAverage, 2, RoundingMode.HALF_UP);
    }

    private List<Listing> getApartmentListings(List<Listing> listings) {
        return listings
                .stream()
                .filter(listing -> listing.getProperty_type() != null)
                .filter(listing -> listing.getProperty_type().equals("Apartment"))
                .collect(Collectors.toList());
    }


    private BigDecimal toDollars(String amount) {
        final NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        try {
            return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
        } catch (ParseException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal getDailyPriceAverage(List<Listing> listings) {
        return listings.stream()
                .map(listing -> toDollars(listing.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(listings.size()), 2, RoundingMode.HALF_UP);

    }

    private BigDecimal getWeeklyPriceAverage(List<Listing> listings) {
        return listings.stream()
                .filter(listing -> listing.getWeekly_price() != null)
                .map(listing -> toDollars(listing.getWeekly_price()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(listings.stream().filter(listing -> listing.getWeekly_price() != null).count()), 2, RoundingMode.HALF_UP);
    }

}
