package org.computate.smartvillage.enus.model.traffic.photovolteic;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartvillage.enus.model.base.BaseModel;
import org.computate.vertx.search.list.SearchList;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;

/**
 * SmartDataModel: PhotovoltaicMeasurement - GreenEnergy - SmartEnergy
 * Fiware: true
 *
 * Model: true
 * SqlOrder: 1
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Order: 1
 * Description: 
 * ApiTag.enUS: PhotovoltaicMeasurement
 * ApiUri.enUS: /api/PhotovoltaicMeasurement
 *
 * ApiMethod.enUS: Search
 * ApiMethod: GET
 * ApiMethod: PATCH
 * ApiMethod: POST
 * ApiMethod: PUTImport
 *
 * ApiMethod.enUS: SearchPage
 * Page.SearchPage.enUS: PhotovoltaicMeasurementPage
 * ApiUri.SearchPage.enUS: /PhotovoltaicMeasurement
 *
 * Role.enUS: SiteAdmin
 *
 * AName.enUS: a photovoltaic measurement
 * Color: 2017-shaded-spruce
 * IconGroup: duotone
 * IconName: map-location-dot
 * Rows: 100
 **/
public class PhotovoltaicMeasurement extends PhotovoltaicMeasurementGen<BaseModel> {

        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: active power
         * Description: Active Power,where phi is the phase shift of the current compared to the voltage. The unit code (text) is given using the UN/CEFACT_Common_Codes (max 3 characters). For instance, For instance, **KWT** represents Kilowatt
         * HtmRow: 3
         * HtmCell: 1
         * Facet: true
         **/
        protected void _activePower(Wrap<BigDecimal> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: address
         * Description: The mailing address
         * HtmRow: 3
         * HtmCell: 2
         * Facet: true
         **/
        protected void _address(Wrap<JsonObject> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: alternate name
         * Description: An alternative name for this item
         * HtmRow: 3
         * HtmCell: 3
         * Facet: true
         **/
        protected void _alternateName(Wrap<String> w) {}


        /**
         * {@inheritDoc}

         * LocationColor: true
         * Indexed: true
         * Stored: true
         * DisplayName: area served colors
         * Description: The colors of each areaServed Paths. 
         */
        protected void _areaServedColors(List<String> l) {
        }

        /**
         * {@inheritDoc}
         * LocationTitle: true
         * Indexed: true
         * Stored: true
         * DisplayName: area served titles
         * Description: The titles of each areaServed Paths. 
         */
        protected void _areaServedTitles(List<String> l) {
        }

        /**
         * {@inheritDoc}
         * LocationUrl: true
         * Indexed: true
         * Stored: true
         * DisplayName: area served links
         * Description: The links of each areaServed Paths. 
         */
        protected void _areaServedLinks(List<String> l) {
        }

        /**
         * {@inheritDoc}
         * FiwareType: geo:linestring
         * Location: true
         * DocValues: true
         * Persist: true
         * DisplayName: area served
         * Description: The geographic area where a service or offered item is provided
         * HtmRow: 4
         * HtmCell: 1
         * Facet: true
         **/
        protected void _areaServed(Wrap<Path> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: current
         * Description: Electrical intensity of the current. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMP** represents Ampere
         * HtmRow: 4
         * HtmCell: 2
         * Facet: true
         **/
        protected void _current(Wrap<BigDecimal> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: data provider
         * Description: A sequence of characters identifying the provider of the harmonised data entity
         * HtmRow: 4
         * HtmCell: 3
         * Facet: true
         **/
        protected void _dataProvider(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: date created
         * Description: Entity creation timestamp. This will usually be allocated by the storage platform
         * HtmRow: 5
         * HtmCell: 1
         * Facet: true
         **/
        protected void _dateCreated(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: date energy metering started
         * Description: The starting date for metering energy in an ISO8601 UTC format
         * HtmRow: 5
         * HtmCell: 2
         * Facet: true
         **/
        protected void _dateEnergyMeteringStarted(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: date modified
         * Description: Timestamp of the last modification of the entity. This will usually be allocated by the storage platform
         * HtmRow: 5
         * HtmCell: 3
         * Facet: true
         **/
        protected void _dateModified(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: date observed
         * Description: Date of the observed entity defined by the user
         * HtmRow: 6
         * HtmCell: 1
         * Facet: true
         **/
        protected void _dateObserved(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: date observed from
         * Description: Observation period: Start date and time in an ISO8601 UTC format. The attribute can be used in addition to the 'dateObserved attribute when it corresponds to a time interval to be highlighted
         * HtmRow: 6
         * HtmCell: 2
         * Facet: true
         **/
        protected void _dateObservedFrom(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: date observed to
         * Description: Observation period: End date and time in an ISO8601 UTC format. The attribute can be used in addition to the 'dateObserved' attribute when it corresponds to a time interval to be highlighted
         * HtmRow: 6
         * HtmCell: 3
         * Facet: true
         **/
        protected void _dateObservedTo(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: description
         * Description: A description of this item
         * HtmRow: 7
         * HtmCell: 1
         * Facet: true
         **/
        protected void _description(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: inverter status
         * Description: Active Power,where phi is the phase shift of the current compared to the voltage. The unit code (text) is given using the UN/CEFACT_Common_Codes (max 3 characters). For instance, For instance, **KWT** represents Kilowatt. Enum:'00-On sector, 01-Power failure / On battery, 02-Loss of communication,  03-Battery fault, 04-System shutdown, 05-Tension dip, 06-Overvoltage, 07-Voltage drop, 08-Voltage increase, 09-Line noise, 10-Frequency variation, 11-Transient distortion, 12-Harmonic distortion'
         * HtmRow: 7
         * HtmCell: 2
         * Facet: true
         **/
        protected void _inverterStatus(Wrap<JsonObject> w) {}


        /**
         * {@inheritDoc}
         * FiwareType: geo:point
         * DocValues: true
         * Persist: true
         * DisplayName: location
         * Description: Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon
         * HtmRow: 7
         * HtmCell: 3
         * Facet: true
         **/
        protected void _location(Wrap<Point> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: name
         * Description: The name of this item
         * HtmRow: 8
         * HtmCell: 1
         * Facet: true
         **/
        protected void _name(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: nominal peak power generation
         * Description: nominalPeakPowerGeneration is a number. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWT** represents Kilowatt
         * HtmRow: 8
         * HtmCell: 2
         * Facet: true
         **/
        protected void _nominalPeakPowerGeneration(Wrap<BigDecimal> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: owner
         * Description: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
         * HtmRow: 8
         * HtmCell: 3
         * Facet: true
         **/
        protected void _owner(Wrap<JsonObject> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: reactive power
         * Description: Reactive Power used by circuits. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **K5** represents kilovolt-ampere-reactive
         * HtmRow: 9
         * HtmCell: 1
         * Facet: true
         **/
        protected void _reactivePower(Wrap<BigDecimal> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: ref photovoltaic device
         * Description: 
         * HtmRow: 9
         * HtmCell: 2
         * Facet: true
         **/
        protected void _refPhotovoltaicDevice(Wrap<JsonObject> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: ref point of interest
         * Description: Reference to a [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) linked with the Repository
         * HtmRow: 9
         * HtmCell: 3
         * Facet: true
         **/
        protected void _refPointOfInterest(Wrap<JsonObject> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: see also
         * Description: list of uri pointing to additional resources about the item
         * HtmRow: 10
         * HtmCell: 1
         * Facet: true
         **/
        protected void _seeAlso(Wrap<JsonObject> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: source
         * Description: A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object
         * HtmRow: 10
         * HtmCell: 2
         * Facet: true
         **/
        protected void _source(Wrap<String> w) {}


        /**
         * {@inheritDoc}
         * DocValues: true
         * Persist: true
         * DisplayName: temperature
         * Description: Temperature recorded at the time of Observation compared to the  nominal reference temperature of the device. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **CEL** represents Degree Celsius
         * HtmRow: 10
         * HtmCell: 3
         * Facet: true
         **/
        protected void _temperature(Wrap<BigDecimal> w) {}

}
