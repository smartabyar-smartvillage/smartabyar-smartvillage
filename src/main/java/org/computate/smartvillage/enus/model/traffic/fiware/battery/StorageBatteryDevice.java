package org.computate.smartvillage.enus.model.traffic.fiware.battery;

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
 * SmartDataModel: StorageBatteryDevice - Battery - SmartEnergy
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
 * ApiTag.enUS: StorageBatteryDevice
 * ApiUri.enUS: /api/StorageBatteryDevice
 *
 * ApiMethod.enUS: Search
 * ApiMethod: GET
 * ApiMethod: PATCH
 * ApiMethod: POST
 * ApiMethod: PUTImport
 *
 * ApiMethod.enUS: SearchPage
 * Page.SearchPage.enUS: StorageBatteryDevicePage
 * ApiUri.SearchPage.enUS: /StorageBatteryDevice
 *
 * Role.enUS: SiteAdmin
 *
 * AName.enUS: a StorageBatteryDevice
 * Color: 2017-shaded-spruce
 * IconGroup: duotone
 * IconName: map-location-dot
 * Rows: 100
 **/
public class StorageBatteryDevice extends StorageBatteryDeviceGen<BaseModel> {

    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: address
     * Description: The mailing address
     * HtmRow: 3
     * HtmCell: 1
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
     * HtmCell: 2
     * Facet: true
     **/
    protected void _alternateName(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: application
     * Description: Enum:'electricMobility, energyStorage, emergencyStorage, houseHoldStorage, industrialStorage, lighting, production, robotics, other'. Target application of the Device regarding the storage. A combination of the enumeration
     * HtmRow: 3
     * HtmCell: 3
     * Facet: true
     **/
    protected void _application(Wrap<JsonObject> w) {}


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
     * DisplayName: average life
     * Description: average life under normal battery usage conditions at reference temperatures. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **ANN** represents Year
     * HtmRow: 4
     * HtmCell: 2
     * Facet: true
     **/
    protected void _averageLife(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: battery assessment methods
     * Description: Enum:'ampereHourMeter, dischargeTest, electrolyteDensity, highFrequencyImpedance, lowFrequencyImpedance, mathematicalModel, operatingVoltageWithClosedCircuit, quiescentVoltageWithOpenCircuit'.  
     * HtmRow: 4
     * HtmCell: 3
     * Facet: true
     **/
    protected void _batteryAssessmentMethods(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: battery type
     * Description: Enum:'alkaline, gel, lead, lead-AGM, Li-Ion, Li-Po, Li-Po4, LMP, Li-Air, Na-NiCl2(Zebra), Ni-Cd, Ni-MH, Ni-Zn, other'. Type of battery used
     * HtmRow: 5
     * HtmCell: 1
     * Facet: true
     **/
    protected void _batteryType(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: brand name
     * Description: Brand Name of the item
     * HtmRow: 5
     * HtmCell: 2
     * Facet: true
     **/
    protected void _brandName(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: capacity cnnn
     * Description: Remaining energy as a function of the discharge time for 6 keys according the temperature of reference. Each Key is a structured value with the format {`Cnnn`:[`value1`,`value2`]} describing the different measurement of [CapacityCnnn]
     * HtmRow: 5
     * HtmCell: 3
     * Facet: true
     **/
    protected void _capacityCnnn(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: charge discharge reactivity
     * Description:  Charge and Discharge Reactivity which characterizes the reactive behavior of the system. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **SEC** represents Second
     * HtmRow: 6
     * HtmCell: 1
     * Facet: true
     **/
    protected void _chargeDischargeReactivity(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: charge efficiency
     * Description: Charge Efficiency *(code PV-BAT)*. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percent
     * HtmRow: 6
     * HtmCell: 2
     * Facet: true
     **/
    protected void _chargeEfficiency(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: charge power
     * Description: Load Power. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt
     * HtmRow: 6
     * HtmCell: 3
     * Facet: true
     **/
    protected void _chargePower(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: charging mode allowed
     * Description:  Charging mode permitted to avoid damage to the battery. enum:'fast, normal, quick'
     * HtmRow: 7
     * HtmCell: 1
     * Facet: true
     **/
    protected void _chargingModeAllowed(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: communication
     * Description: List of communication protocol with others device depending manufacturers. Enum:'CAN 2.0 B, dryContactTerminal, maintenanceInterface, RS485, RS485BMS, RS485Inverter, other'
     * HtmRow: 7
     * HtmCell: 2
     * Facet: true
     **/
    protected void _communication(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: data provider
     * Description: A sequence of characters identifying the provider of the harmonised data entity
     * HtmRow: 7
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
     * HtmRow: 8
     * HtmCell: 1
     * Facet: true
     **/
    protected void _dateCreated(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: date last reported
     * Description: A timestamp which denotes the last time when the device successfully reported data. Date and time in an ISO8601 UTCformat. 
     * HtmRow: 8
     * HtmCell: 2
     * Facet: true
     **/
    protected void _dateLastReported(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: date modified
     * Description: Timestamp of the last modification of the entity. This will usually be allocated by the storage platform
     * HtmRow: 8
     * HtmCell: 3
     * Facet: true
     **/
    protected void _dateModified(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: description
     * Description: A description of this item
     * HtmRow: 9
     * HtmCell: 1
     * Facet: true
     **/
    protected void _description(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: dimension
     * Description: External dimension of a Panel. The format is structured by a sub-property of 3 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **CMT** represents Centimeter
     * HtmRow: 9
     * HtmCell: 2
     * Facet: true
     **/
    protected void _dimension(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: discharge efficiency
     * Description: Discharge Efficiency *(code PV-OND)*. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percent
     * HtmRow: 9
     * HtmCell: 3
     * Facet: true
     **/
    protected void _dischargeEfficiency(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: discharge power
     * Description: Discharge Power. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt
     * HtmRow: 10
     * HtmCell: 1
     * Facet: true
     **/
    protected void _dischargePower(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: documentation
     * Description: Technical Documentation (Installation / maintenance / use)
     * HtmRow: 10
     * HtmCell: 2
     * Facet: true
     **/
    protected void _documentation(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: duration peak power
     * Description: Reference Time recorded for the attribute [peakPower]. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **SEC** represents Second
     * HtmRow: 10
     * HtmCell: 3
     * Facet: true
     **/
    protected void _durationPeakPower(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: installation condition
     * Description: Enum:'desert, dust, extremeClimate, extremeCold, extremeHeat, extremeHumidity, marine, saline, sand, seismic, other'. Condition and possibility of use in the following environments
     * HtmRow: 11
     * HtmCell: 1
     * Facet: true
     **/
    protected void _installationCondition(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: installation mode
     * Description: Enum:'aerial, ground, pole, roofing, underGround, wall, other'. Positioning of the device in relation to a ground reference system
     * HtmRow: 11
     * HtmCell: 2
     * Facet: true
     **/
    protected void _installationMode(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: life cycle number
     * Description: Number of admissible charge / discharge life cycles. The format is structured by a sub-property of 2 items
     * HtmRow: 11
     * HtmCell: 3
     * Facet: true
     **/
    protected void _lifeCycleNumber(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * FiwareType: geo:point
     * DocValues: true
     * Persist: true
     * DisplayName: location
     * Description: Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon
     * HtmRow: 12
     * HtmCell: 1
     * Facet: true
     **/
    protected void _location(Wrap<Point> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: manufacturer name
     * Description: Manufacturer Name of the item
     * HtmRow: 12
     * HtmCell: 2
     * Facet: true
     **/
    protected void _manufacturerName(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: mass energy density
     * Description: Mass Energy density *(Code D)*. Ratio between the capacity of the battery to deliver a certain power for a certain time and its weight. The format is structured by a sub-property of 2 items. The unit code (text) of measurement is **Wh/Kg** WattHour per Kilogram
     * HtmRow: 12
     * HtmCell: 3
     * Facet: true
     **/
    protected void _massEnergyDensity(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: max output power
     * Description: Maximum Power. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWT** represents Kilowatt
     * HtmRow: 13
     * HtmCell: 1
     * Facet: true
     **/
    protected void _maxOutputPower(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: maximum voltage eoc
     * Description: Maximum authorized voltage after end of charge and Battery still connected to to a charge generator. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt
     * HtmRow: 13
     * HtmCell: 2
     * Facet: true
     **/
    protected void _maximumVoltageEOC(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: minimum voltage eod
     * Description: Minimum voltage after end of discharge and not connected to to a charge generator. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt
     * HtmRow: 13
     * HtmCell: 3
     * Facet: true
     **/
    protected void _minimumVoltageEOD(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: model name
     * Description: Model Name of the item. 
     * HtmRow: 14
     * HtmCell: 1
     * Facet: true
     **/
    protected void _modelName(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: name
     * Description: The name of this item
     * HtmRow: 14
     * HtmCell: 2
     * Facet: true
     **/
    protected void _name(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: nominal ampere
     * Description: Nominal Amperage. *(Code I)*. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMP** represents Ampere
     * HtmRow: 14
     * HtmCell: 3
     * Facet: true
     **/
    protected void _nominalAmpere(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: nominal capacity
     * Description: Nominal Energy capacity. *(Code C)* to link with the attribute [CapacityCnnn] to measure the predefined levels parameters C / xx h of discharge regimes. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMH** represents Ampere Hour
     * HtmRow: 15
     * HtmCell: 1
     * Facet: true
     **/
    protected void _nominalCapacity(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: nominal frequency
     * Description: Nominal Frequency. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **HTZ** represents Hertz
     * HtmRow: 15
     * HtmCell: 2
     * Facet: true
     **/
    protected void _nominalFrequency(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: nominal voltage
     * Description: Nominal battery voltage. *(Code U)* The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt
     * HtmRow: 15
     * HtmCell: 3
     * Facet: true
     **/
    protected void _nominalVoltage(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: operating altitude
     * Description: Operating altitude with minimum and maximum resistance to height and depth. The format is structured by a sub-property of 2 items with the keys [min] =<0 and [max] >=0. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **MTR** represents Meter
     * HtmRow: 16
     * HtmCell: 1
     * Facet: true
     **/
    protected void _operatingAltitude(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: operating ampere
     * Description:  Minimum and Maximum Ampere allowed. The format is structured by a sub-property of 2 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMP** represents Ampere
     * HtmRow: 16
     * HtmCell: 2
     * Facet: true
     **/
    protected void _operatingAmpere(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: operating frequency
     * Description:  Minimum and Maximum frequency allowed. The format is structured by a sub-property of 2 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **HTZ** represents Hertz
     * HtmRow: 16
     * HtmCell: 3
     * Facet: true
     **/
    protected void _operatingFrequency(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: operating temperature
     * Description: Ambient operating temperature range. This is the minimum and maximum resistance to cold and heat for an [event]. The format is structured by a sub-property of 3 items with the format  {`event`:[`min`,`max`]}. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **CEL** represents Degree Celsius
     * HtmRow: 17
     * HtmCell: 1
     * Facet: true
     **/
    protected void _operatingTemperature(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: operating voltage
     * Description: Minimum and Maximum voltage allowed. The format is structured by a sub-property of 2 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt
     * HtmRow: 17
     * HtmCell: 2
     * Facet: true
     **/
    protected void _operatingVoltage(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: overload accepted
     * Description: Overload is permitted after exceeding the threshold.(`true` for yes)
     * HtmRow: 17
     * HtmCell: 3
     * Facet: true
     **/
    protected void _overloadAccepted(Wrap<Boolean> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: overload accepted time
     * Description: Accepted overcharge time without damage to the battery
     * HtmRow: 18
     * HtmCell: 1
     * Facet: true
     **/
    protected void _overloadAcceptedTime(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: owner
     * Description: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
     * HtmRow: 18
     * HtmCell: 2
     * Facet: true
     **/
    protected void _owner(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: peak power
     * Description:  Maximum intensity extractable over a short period. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWT** represents Kilowatt
     * HtmRow: 18
     * HtmCell: 3
     * Facet: true
     **/
    protected void _peakPower(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: possibility of use
     * Description: Possibility of use. A unique value. Enum:'mobile, mixed, stationary, other'.  
     * HtmRow: 19
     * HtmCell: 1
     * Facet: true
     **/
    protected void _possibilityOfUse(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: protection ik
     * Description: IK 'Mecanic Protection' level relating to numeric classification for the degrees of protection provided by enclosures for electrical equipment against external mechanical impacts, according to International Electro technical Commission standard (EN 62-262). - IK varies from 0 (minimum resistance) to 10 (maximum resistance) which represents an Impact Energy (Unit Joule)
     * HtmRow: 19
     * HtmCell: 2
     * Facet: true
     **/
    protected void _protectionIK(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: protection ip
     * Description: IP *Ingress Protection* for the Junction Box. This is the level classifies and rates the degree of protection provided by mechanical casings and electrical enclosures against intrusion, dust, accidental contact, and water according to International Electrotechnical Commission standard (EN 60-529). - First digit: Solid particle protection (Single numeral: 0–6 or 'X'). - Second digit: Liquid ingress protection (Single numeral: 0–9 or 'X'). - Third digit: Personal Protection  against access to dangerous parts (optional additional letter). - Fourth digit: Other protections (optional additional letter)
     * HtmRow: 19
     * HtmCell: 3
     * Facet: true
     **/
    protected void _protectionIP(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: recharge energy source
     * Description: Enum:'electric, hydraulic, windTurbine, other'. Recharge Energy Source. A unique value of the list 
     * HtmRow: 20
     * HtmCell: 1
     * Facet: true
     **/
    protected void _rechargeEnergySource(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: ref device
     * Description: Reference to the Main Entity [Device](https://github.com/smart-data-models/dataModel.Device/blob/master/Device/doc/spec.md) if used as second link
     * HtmRow: 20
     * HtmCell: 2
     * Facet: true
     **/
    protected void _refDevice(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: ref point of interest
     * Description: Reference to a [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) linked with the observation
     * HtmRow: 20
     * HtmCell: 3
     * Facet: true
     **/
    protected void _refPointOfInterest(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: round trip efficiency
     * Description: Round-Trip Efficiency. Efficiency, defined as the ratio between stored energy and returned energy. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percent
     * HtmRow: 21
     * HtmCell: 1
     * Facet: true
     **/
    protected void _roundTripEfficiency(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: see also
     * Description: list of uri pointing to additional resources about the item
     * HtmRow: 21
     * HtmCell: 2
     * Facet: true
     **/
    protected void _seeAlso(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: self discharge rate
     * Description: Battery discharge rate without any use on a baseline of 1 month according the [temperature of reference]. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percentage
     * HtmRow: 21
     * HtmCell: 3
     * Facet: true
     **/
    protected void _selfDischargeRate(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: serial number
     * Description: Serial numbers of the item
     * HtmRow: 22
     * HtmCell: 1
     * Facet: true
     **/
    protected void _serialNumber(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: source
     * Description: A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object
     * HtmRow: 22
     * HtmCell: 2
     * Facet: true
     **/
    protected void _source(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: storable energy
     * Description: Total Storage Energy = [nominalVoltage] * [nominalCapacity]. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWH** represents Kilowatt Hour
     * HtmRow: 22
     * HtmCell: 3
     * Facet: true
     **/
    protected void _storableEnergy(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: tool bms
     * Description: Use of a Battery Management System tool to protect, guarantee and optimize battery life. (`true` for yes)
     * HtmRow: 23
     * HtmCell: 1
     * Facet: true
     **/
    protected void _toolBMS(Wrap<Boolean> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: type energy source
     * Description: Enum:'dam, fall, generator, network, photovoltaic, river, sea, waterTurbine, wind, other'. Type of Energy Source regarding `RechargeEnergySource` attribute
     * HtmRow: 23
     * HtmCell: 2
     * Facet: true
     **/
    protected void _typeEnergySource(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: type of use
     * Description: Accepted use regarding its positioning in an indoor / outdoor environment. Enum:' indoor, mixed, outdoor, other'
     * HtmRow: 23
     * HtmCell: 3
     * Facet: true
     **/
    protected void _typeOfUse(Wrap<String> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: usable energy
     * Description: Usable Energy. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWH** represents Kilowatt Hour
     * HtmRow: 24
     * HtmCell: 1
     * Facet: true
     **/
    protected void _usableEnergy(Wrap<BigDecimal> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: vol energy density
     * Description: Volume Energy density *(Code D)*. The format is structured by a sub-property of 2 items. The unit code (text) of measurement is **Wh/L** WattHour per Liter
     * HtmRow: 24
     * HtmCell: 2
     * Facet: true
     **/
    protected void _volEnergyDensity(Wrap<JsonObject> w) {}


    /**
     * {@inheritDoc}
     * DocValues: true
     * Persist: true
     * DisplayName: weight
     * Description: Weight. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KGM** represents KiloGramme
     * HtmRow: 24
     * HtmCell: 3
     * Facet: true
     **/
    protected void _weight(Wrap<BigDecimal> w) {}

}
