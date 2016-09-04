import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author alexescg
 * @version 1.0
 * @since 9/2/2016
 */
public class Application {

    public static void main(String[] args) throws Exception{
        Parser parser = new Parser("listings.csv");
        List<Listing> listings = parser.parseCsv();
        ListingManipulation listingManipulation = new ListingManipulation(listings);
        listingManipulation.ignoreRowsWithNullField("has_availability");
        System.out.println(listingManipulation.getListings().size());

    }



}
