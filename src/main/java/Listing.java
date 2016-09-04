import com.univocity.parsers.annotations.BooleanString;
import com.univocity.parsers.annotations.Parsed;

import java.util.Date;

/**
 * @author alexescg
 * @version 1.0
 * @since 1.0
 * @date 9/3/2016
 */
public class Listing {
    @Parsed
    private Long id;

    @Parsed
    private String listing_url;

    @Parsed
    private Long scrape_id;

    @Parsed
    private String last_scraped;

    @Parsed
    private String name;

    @Parsed
    private String summary;

    @Parsed
    private String space;

    @Parsed
    private String description;

    @Parsed
    private String experiences_offered;

    @Parsed
    private String neighborhood_overview;

    @Parsed
    private String notes;

    @Parsed
    private String transit;

    @Parsed
    private String access;

    @Parsed
    private String interaction;

    @Parsed
    private String house_rules;

    @Parsed
    private String thumbnail_url;

    @Parsed
    private String medium_url;

    @Parsed
    private String picture_url;

    @Parsed
    private String xl_picture_url;

    @Parsed
    private Long host_id;

    @Parsed
    private String host_url;

    @Parsed
    private String host_name;

    @Parsed
    private String host_since;

    @Parsed
    private String host_location;

    @Parsed
    private String host_about;

    @Parsed
    private String host_response_time;


    @Parsed
    //porcentaje
    private String host_response_rate;
    //porcentaje
    @Parsed
    private String host_acceptance_rate;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean host_is_superhost;

    @Parsed
    private String host_thumbnail_url;

    @Parsed
    private String host_picture_url;

    @Parsed
    private String host_neighbourhood;

    @Parsed
    private Long host_listings_count;

    @Parsed
    private Double host_total_listings_count;

    @Parsed
    private String host_verifications;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean host_has_profile_pic;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean host_identity_verified;

    @Parsed
    private String street;

    @Parsed
    private String neighbourhood;

    @Parsed
    private String neighbourhood_cleansed;

    @Parsed
    private String neighbourhood_group_cleansed;

    @Parsed
    private String city;

    @Parsed
    private String state;

    @Parsed
    private String zipcode;

    @Parsed
    private String market;

    @Parsed
    private String smart_location;

    @Parsed
    private String country_code;

    @Parsed
    private String country;

    @Parsed
    private Double latitude;

    @Parsed
    private Double longitude;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean is_location_exact;

    //enum house, aparment, condominium, dorm, townhouse, bed&breakfast, boat, loft, cabin, bungalow
    @Parsed
    private String property_type;

    //enum private room, entire home/apt, shared room
    @Parsed
    private String room_type;

    @Parsed
    private Double accommodates;

    @Parsed
    private Double bathrooms;

    @Parsed
    private Double bedrooms;

    @Parsed
    private Double beds;

    //enum real bed, pull-out sofa, airbed, futon, couch
    @Parsed
    private String bed_type;

    //pseudo json
    @Parsed
    private String amenities;

    //vacio en todos lados?
    @Parsed
    private String square_feet;

    //simbolo de dineros
    @Parsed
    private String price;

    //simbolo de dineros
    @Parsed
    private String weekly_price;

    //simbolo de dineros
    @Parsed
    private String monthly_price;

    //simbolo de dineros
    @Parsed
    private String security_deposit;

    //simbolo de dineros
    @Parsed
    private String cleaning_fee;

    @Parsed
    private Integer guests_included;

    //simbolo de dineros
    @Parsed
    private String extra_people;


    @Parsed
    private Double minimum_nights;

    @Parsed
    private Double maximum_nights;

    @Parsed
    private String calendar_updated;

    //null everywhere
    @Parsed
    private String has_availability;

    @Parsed
    private Double availability_30;

    @Parsed
    private Double availability_60;

    @Parsed
    private Double availability_90;

    @Parsed
    private Double availability_365;

    @Parsed
    private String calendar_last_scraped;

    @Parsed
    private Double number_of_reviews;

    //date que puede ser ######
    @Parsed
    private String first_review;

    //date que puede ser ######
    @Parsed
    private String last_review;

    @Parsed
    private Double review_scores_rating;

    @Parsed
    private Double review_scores_accuracy;

    @Parsed
    private Double review_scores_cleanliness;

    @Parsed
    private Double review_scores_checkin;

    @Parsed
    private Double review_scores_communication;

    @Parsed
    private Double review_scores_location;

    @Parsed
    private Double review_scores_value;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean requires_license;
    //todos vacios?
    private String license;

    @Parsed
    private String jurisdiction_names;

    //t o f
    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean instant_bookable;

    //moderate, flexible, strict
    @Parsed
    private String cancellation_policy;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean require_guest_profile_picture;

    @Parsed
    @BooleanString(falseStrings = {"f"}, trueStrings = {"t"})
    private Boolean require_guest_phone_verification;

    @Parsed
    private Double calculated_host_listings_count;

    @Parsed(defaultNullRead = "0")
    private Double reviews_per_month;

    public Listing(Long id, String listing_url, Long scrape_id, String last_scraped, String name, String summary, String space, String description, String experiences_offered, String neighborhood_overview, String notes, String transit, String access, String interaction, String house_rules, String thumbnail_url, String medium_url, String picture_url, String xl_picture_url, Long host_id, String host_url, String host_name, String host_since, String host_location, String host_about, String host_response_time, String host_response_rate, String host_acceptance_rate, Boolean host_is_superhost, String host_thumbnail_url, String host_picture_url, String host_neighbourhood, Long host_listings_count, Double host_total_listings_count, String host_verifications, Boolean host_has_profile_pic, Boolean host_identity_verified, String street, String neighbourhood, String neighbourhood_cleansed, String neighbourhood_group_cleansed, String city, String state, String zipcode, String market, String smart_location, String country_code, String country, Double latitude, Double longitude, Boolean is_location_exact, String property_type, String room_type, Double accommodates, Double bathrooms, Double bedrooms, Double beds, String bed_type, String amenities, String square_feet, String price, String weekly_price, String monthly_price, String security_deposit, String cleaning_fee, Integer guests_included, String extra_people, Double minimum_nights, Double maximum_nights, String calendar_updated, String has_availability, Double availability_30, Double availability_60, Double availability_90, Double availability_365, String calendar_last_scraped, Double number_of_reviews, String first_review, String last_review, Double review_scores_rating, Double review_scores_accuracy, Double review_scores_cleanliness, Double review_scores_checkin, Double review_scores_communication, Double review_scores_location, Double review_scores_value, Boolean requires_license, String license, String jurisdiction_names, Boolean instant_bookable, String cancellation_policy, Boolean require_guest_profile_picture, Boolean require_guest_phone_verification, Double calculated_host_listings_count, Double reviews_per_month) {
        this.id = id;
        this.listing_url = listing_url;
        this.scrape_id = scrape_id;
        this.last_scraped = last_scraped;
        this.name = name;
        this.summary = summary;
        this.space = space;
        this.description = description;
        this.experiences_offered = experiences_offered;
        this.neighborhood_overview = neighborhood_overview;
        this.notes = notes;
        this.transit = transit;
        this.access = access;
        this.interaction = interaction;
        this.house_rules = house_rules;
        this.thumbnail_url = thumbnail_url;
        this.medium_url = medium_url;
        this.picture_url = picture_url;
        this.xl_picture_url = xl_picture_url;
        this.host_id = host_id;
        this.host_url = host_url;
        this.host_name = host_name;
        this.host_since = host_since;
        this.host_location = host_location;
        this.host_about = host_about;
        this.host_response_time = host_response_time;
        this.host_response_rate = host_response_rate;
        this.host_acceptance_rate = host_acceptance_rate;
        this.host_is_superhost = host_is_superhost;
        this.host_thumbnail_url = host_thumbnail_url;
        this.host_picture_url = host_picture_url;
        this.host_neighbourhood = host_neighbourhood;
        this.host_listings_count = host_listings_count;
        this.host_total_listings_count = host_total_listings_count;
        this.host_verifications = host_verifications;
        this.host_has_profile_pic = host_has_profile_pic;
        this.host_identity_verified = host_identity_verified;
        this.street = street;
        this.neighbourhood = neighbourhood;
        this.neighbourhood_cleansed = neighbourhood_cleansed;
        this.neighbourhood_group_cleansed = neighbourhood_group_cleansed;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.market = market;
        this.smart_location = smart_location;
        this.country_code = country_code;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.is_location_exact = is_location_exact;
        this.property_type = property_type;
        this.room_type = room_type;
        this.accommodates = accommodates;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.beds = beds;
        this.bed_type = bed_type;
        this.amenities = amenities;
        this.square_feet = square_feet;
        this.price = price;
        this.weekly_price = weekly_price;
        this.monthly_price = monthly_price;
        this.security_deposit = security_deposit;
        this.cleaning_fee = cleaning_fee;
        this.guests_included = guests_included;
        this.extra_people = extra_people;
        this.minimum_nights = minimum_nights;
        this.maximum_nights = maximum_nights;
        this.calendar_updated = calendar_updated;
        this.has_availability = has_availability;
        this.availability_30 = availability_30;
        this.availability_60 = availability_60;
        this.availability_90 = availability_90;
        this.availability_365 = availability_365;
        this.calendar_last_scraped = calendar_last_scraped;
        this.number_of_reviews = number_of_reviews;
        this.first_review = first_review;
        this.last_review = last_review;
        this.review_scores_rating = review_scores_rating;
        this.review_scores_accuracy = review_scores_accuracy;
        this.review_scores_cleanliness = review_scores_cleanliness;
        this.review_scores_checkin = review_scores_checkin;
        this.review_scores_communication = review_scores_communication;
        this.review_scores_location = review_scores_location;
        this.review_scores_value = review_scores_value;
        this.requires_license = requires_license;
        this.license = license;
        this.jurisdiction_names = jurisdiction_names;
        this.instant_bookable = instant_bookable;
        this.cancellation_policy = cancellation_policy;
        this.require_guest_profile_picture = require_guest_profile_picture;
        this.require_guest_phone_verification = require_guest_phone_verification;
        this.calculated_host_listings_count = calculated_host_listings_count;
        this.reviews_per_month = reviews_per_month;
    }

    public Listing() {
    }

    public Long getId() {
        return id;
    }

    public String getListing_url() {
        return listing_url;
    }

    public Long getScrape_id() {
        return scrape_id;
    }

    public String getLast_scraped() {
        return last_scraped;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getSpace() {
        return space;
    }

    public String getDescription() {
        return description;
    }

    public String getExperiences_offered() {
        return experiences_offered;
    }

    public String getNeighborhood_overview() {
        return neighborhood_overview;
    }

    public String getNotes() {
        return notes;
    }

    public String getTransit() {
        return transit;
    }

    public String getAccess() {
        return access;
    }

    public String getInteraction() {
        return interaction;
    }

    public String getHouse_rules() {
        return house_rules;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public String getXl_picture_url() {
        return xl_picture_url;
    }

    public Long getHost_id() {
        return host_id;
    }

    public String getHost_url() {
        return host_url;
    }

    public String getHost_name() {
        return host_name;
    }

    public String getHost_since() {
        return host_since;
    }

    public String getHost_location() {
        return host_location;
    }

    public String getHost_about() {
        return host_about;
    }

    public String getHost_response_time() {
        return host_response_time;
    }

    public String getHost_response_rate() {
        return host_response_rate;
    }

    public String getHost_acceptance_rate() {
        return host_acceptance_rate;
    }

    public Boolean getHost_is_superhost() {
        return host_is_superhost;
    }

    public String getHost_thumbnail_url() {
        return host_thumbnail_url;
    }

    public String getHost_picture_url() {
        return host_picture_url;
    }

    public String getHost_neighbourhood() {
        return host_neighbourhood;
    }

    public Long getHost_listings_count() {
        return host_listings_count;
    }

    public Double getHost_total_listings_count() {
        return host_total_listings_count;
    }

    public String getHost_verifications() {
        return host_verifications;
    }

    public Boolean getHost_has_profile_pic() {
        return host_has_profile_pic;
    }

    public Boolean getHost_identity_verified() {
        return host_identity_verified;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getNeighbourhood_cleansed() {
        return neighbourhood_cleansed;
    }

    public String getNeighbourhood_group_cleansed() {
        return neighbourhood_group_cleansed;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getMarket() {
        return market;
    }

    public String getSmart_location() {
        return smart_location;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Boolean getIs_location_exact() {
        return is_location_exact;
    }

    public String getProperty_type() {
        return property_type;
    }

    public String getRoom_type() {
        return room_type;
    }

    public Double getAccommodates() {
        return accommodates;
    }

    public Double getBathrooms() {
        return bathrooms;
    }

    public Double getBedrooms() {
        return bedrooms;
    }

    public Double getBeds() {
        return beds;
    }

    public String getBed_type() {
        return bed_type;
    }

    public String getAmenities() {
        return amenities;
    }

    public String getSquare_feet() {
        return square_feet;
    }

    public String getPrice() {
        return price;
    }

    public String getWeekly_price() {
        return weekly_price;
    }

    public String getMonthly_price() {
        return monthly_price;
    }

    public String getSecurity_deposit() {
        return security_deposit;
    }

    public String getCleaning_fee() {
        return cleaning_fee;
    }

    public Integer getGuests_included() {
        return guests_included;
    }

    public String getExtra_people() {
        return extra_people;
    }

    public Double getMinimum_nights() {
        return minimum_nights;
    }

    public Double getMaximum_nights() {
        return maximum_nights;
    }

    public String getCalendar_updated() {
        return calendar_updated;
    }

    public String getHas_availability() {
        return has_availability;
    }

    public Double getAvailability_30() {
        return availability_30;
    }

    public Double getAvailability_60() {
        return availability_60;
    }

    public Double getAvailability_90() {
        return availability_90;
    }

    public Double getAvailability_365() {
        return availability_365;
    }

    public String getCalendar_last_scraped() {
        return calendar_last_scraped;
    }

    public Double getNumber_of_reviews() {
        return number_of_reviews;
    }

    public String getFirst_review() {
        return first_review;
    }

    public String getLast_review() {
        return last_review;
    }

    public Double getReview_scores_rating() {
        return review_scores_rating;
    }

    public Double getReview_scores_accuracy() {
        return review_scores_accuracy;
    }

    public Double getReview_scores_cleanliness() {
        return review_scores_cleanliness;
    }

    public Double getReview_scores_checkin() {
        return review_scores_checkin;
    }

    public Double getReview_scores_communication() {
        return review_scores_communication;
    }

    public Double getReview_scores_location() {
        return review_scores_location;
    }

    public Double getReview_scores_value() {
        return review_scores_value;
    }

    public Boolean getRequires_license() {
        return requires_license;
    }

    public String getLicense() {
        return license;
    }

    public String getJurisdiction_names() {
        return jurisdiction_names;
    }

    public Boolean getInstant_bookable() {
        return instant_bookable;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public Boolean getRequire_guest_profile_picture() {
        return require_guest_profile_picture;
    }

    public Boolean getRequire_guest_phone_verification() {
        return require_guest_phone_verification;
    }

    public Double getCalculated_host_listings_count() {
        return calculated_host_listings_count;
    }

    public Double getReviews_per_month() {
        return reviews_per_month;
    }
}
