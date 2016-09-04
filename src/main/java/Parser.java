import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author alexescg
 * @version 1.0
 * @since 1.0
 * @date 9/3/2016
 */
public class Parser {

    private CsvParserSettings settings;
    private BeanListProcessor<Listing> processor;
    final private String filePath;

    public Parser(String filePath) {
        this.filePath = filePath;
        configureParserSettings();
    }

    private void configureParserSettings() {
        settings = new CsvParserSettings();
        settings.setLineSeparatorDetectionEnabled(true);
        settings.setHeaderExtractionEnabled(true);
        settings.setMaxCharsPerColumn(200000);

        processor = new BeanListProcessor<>(Listing.class);
        settings.setProcessor(processor);
    }

    public List<Listing> parseCsv() {
        CsvParser parser = new CsvParser(settings);
        parser.parseAll(getReader(filePath));
        List<Listing> listings = processor.getBeans();
        return listings;

    }

    private Reader getReader(String relativePath) {
        try {
            return new InputStreamReader(this.getClass().getResourceAsStream(relativePath), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unable to read input", e);
        }
    }

    private void printHeaders(String[] headers){
        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i]);
        }
    }

    private void printRows(final List<String[]> rows){
        rows.stream().forEach( row -> System.out.println(Arrays.toString(row)));
    }

    private void getDifferent(String[] column){
        List<String> diffs = Arrays.asList(column);
        diffs.stream().distinct().forEach( diff -> System.out.println(diff));
    }
}
