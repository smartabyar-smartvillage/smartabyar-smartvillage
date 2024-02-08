package org.computate.smartvillage.enus.model.traffic.fiware.battery;

import org.computate.smartvillage.enus.request.SiteRequestEnUS;
import org.computate.smartvillage.enus.model.base.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
import org.computate.vertx.api.ApiRequest;
import org.computate.smartvillage.enus.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import java.lang.String;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPathSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPathDeserializer;
import java.math.BigDecimal;
import org.computate.vertx.serialize.pgclient.PgClientPointSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPointDeserializer;
import java.lang.Boolean;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class StorageBatteryDeviceGen into the class StorageBatteryDevice. 
 * </li>
 * <h3>About the StorageBatteryDevice class and it's generated class StorageBatteryDeviceGen&lt;BaseModel&gt;: </h3>extends StorageBatteryDeviceGen
 * <p>
 * This Java class extends a generated Java class StorageBatteryDeviceGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice">Find the class StorageBatteryDevice in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends StorageBatteryDeviceGen<BaseModel>
 * <p>This <code>class StorageBatteryDevice extends StorageBatteryDeviceGen&lt;BaseModel&gt;</code>, which means it extends a newly generated StorageBatteryDeviceGen. 
 * The generated <code>class StorageBatteryDeviceGen extends BaseModel</code> which means that StorageBatteryDevice extends StorageBatteryDeviceGen which extends BaseModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <p>This class contains a comment <b>"Api: true"</b>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiMethode: Search</h2>
 * <p>This class contains a comment <b>"ApiMethod: Search"</b>, which creates an API "Search". 
 * </p>
 * <h2>ApiMethode: GET</h2>
 * <p>This class contains a comment <b>"ApiMethod: GET"</b>, which creates an API "GET". 
 * </p>
 * <h2>ApiMethode: PATCH</h2>
 * <p>This class contains a comment <b>"ApiMethod: PATCH"</b>, which creates an API "PATCH". 
 * </p>
 * <h2>ApiMethode: POST</h2>
 * <p>This class contains a comment <b>"ApiMethod: POST"</b>, which creates an API "POST". 
 * </p>
 * <h2>ApiMethode: PUTImport</h2>
 * <p>This class contains a comment <b>"ApiMethod: PUTImport"</b>, which creates an API "PUTImport". 
 * </p>
 * <h2>ApiMethode: SearchPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: SearchPage"</b>, which creates an API "SearchPage". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: StorageBatteryDevice"</b>, which groups all of the OpenAPIs for StorageBatteryDevice objects under the tag "StorageBatteryDevice". 
 * </p>
 * <h2>ApiUri.enUS: /api/StorageBatteryDevice</h2>
 * <p>This class contains a comment <b>"ApiUri: /api/StorageBatteryDevice"</b>, which defines the base API URI for StorageBatteryDevice objects as "/api/StorageBatteryDevice" in the OpenAPI spec. 
 * </p>
 * <h2>Color: 2017-shaded-spruce</h2>
 * <p>This class contains a comment <b>"Color: 2017-shaded-spruce"</b>, which styles the StorageBatteryDevice page "2017-shaded-spruce". 
 * This will reference a CSS class defined by the stylesheets in the project that starts with "w3-". 
 * A css class of "w3-2017-shaded-spruce" is expected to exist in the project stylesheets, and is inspired by W3 CSS colors. 
 * See: <a href="https://www.w3schools.com/w3css/w3css_colors.asp">https://www.w3schools.com/w3css/w3css_colors.asp</a>. 
 * </p>
 * <h2>IconGroup: duotone</h2>
 * <p>This class contains a comment <b>"IconGroup: duotone"</b>, which adds icons on the StorageBatteryDevice page with a group of "duotone". 
 * This will reference a Font Awesome icon group that starts with "fa-" followed by the icon group "duotone", together is "fa-duotone". 
 * A Font Awesome icon group of "duotone" is expected to exist. 
 * The Font Awesome groups currently supported include: solid, regular, light, thin, duotone, sharp, and kit. 
 * See: <a href="https://fontawesome.com/docs/web/dig-deeper/styles">https://fontawesome.com/docs/web/dig-deeper/styles</a>. 
 * </p>
 * <h2>IconName: map-location-dot</h2>
 * <p>This class contains a comment <b>"IconName: map-location-dot"</b>, which adds icons on the StorageBatteryDevice page with a name of "map-location-dot". 
 * This will reference a Font Awesome icon that starts with the icon group "fa-duotone fa-" followed by the icon name, which is "fa-duotone fa-map-location-dot". 
 * A Font Awesome icon of "fa-duotone fa-map-location-dot" is expected to exist. 
 * See: <a href="https://fontawesome.com/icons">https://fontawesome.com/icons</a>. 
 * </p>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the StorageBatteryDevice class will inherit the helpful inherited class comments from the super class StorageBatteryDeviceGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the StorageBatteryDevice API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 1</h2>
 * <p>This class contains a comment <b>"Order: 1"</b>, which means this class will be sorted by the given number 1 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 1</h2>
 * <p>This class contains a comment <b>"SqlOrder: 1"</b>, which means this class will be sorted by the given number 1 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevicePage. 
 * </p>
 * <h2>SuperPage.enUS: BaseModelPage</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: BaseModelPage"</b>, which identifies the Java super class of the page code by it's class simple name "BaseModelPage". 
 * This means that the newly created class org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevicePage extends org.computate.smartvillage.enus.model.base.BaseModelPage. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the StorageBatteryDevice Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
 * </p>
 * <p>
 *   Adding protected void methods beginning with an underscore with a Promise as the only parameter will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   <pre>
 *   
 *   	protected void _promiseBefore(Promise&lt;Void&gt; promise) {
 *   		promise.complete();
 *   	}
 *   </pre>
 * </p>
 * <p>
 *   Java classes with the `Model: true` will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   If a super class of this Java class with `Model: true`, then the child class will also inherit `Promise: true`. 
 * </p>
 * <h2>Role.enUS: SiteAdmin</h2>
 * <p>
 * This class contains a comment <b>"Role.enUS: SiteAdmin"</b>, which identifies the default role name "SiteAdmin" of the OAuth2/OpenID Connect user role required to access this StorageBatteryDevice API. 
 * It's possible to reconfigure the roles required to access the StorageBatteryDevice API by configuring an environment variable like this: 
 * </p>
 * <pre>AUTH_ROLE_REQUIRED_StorageBatteryDevice: ["SiteAdmin"]</pre>
 * <h2>AName.enUS: a StorageBatteryDevice</h2>
 * <p>This class contains a comment <b>"AName.enUS: a StorageBatteryDevice"</b>, which identifies the language context to describe a StorageBatteryDevice as "a StorageBatteryDevice". 
 * </p>
 * <p>
 * Delete the class StorageBatteryDevice in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.traffic.fiware.battery in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class StorageBatteryDeviceGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(StorageBatteryDevice.class);

	public static final String StorageBatteryDevice_Description_enUS = "ApiTag.enUS: StorageBatteryDevice";
	public static final String StorageBatteryDevice_AName_enUS = "a StorageBatteryDevice";
	public static final String StorageBatteryDevice_This_enUS = "this ";
	public static final String StorageBatteryDevice_ThisName_enUS = "this StorageBatteryDevice";
	public static final String StorageBatteryDevice_A_enUS = "a ";
	public static final String StorageBatteryDevice_TheName_enUS = "the StorageBatteryDevice";
	public static final String StorageBatteryDevice_NameSingular_enUS = "StorageBatteryDevice";
	public static final String StorageBatteryDevice_NamePlural_enUS = "StorageBatteryDevices";
	public static final String StorageBatteryDevice_NameActual_enUS = "current StorageBatteryDevice";
	public static final String StorageBatteryDevice_AllName_enUS = "all the StorageBatteryDevices";
	public static final String StorageBatteryDevice_SearchAllNameBy_enUS = "search StorageBatteryDevices by ";
	public static final String StorageBatteryDevice_Title_enUS = "StorageBatteryDevices";
	public static final String StorageBatteryDevice_ThePluralName_enUS = "the StorageBatteryDevices";
	public static final String StorageBatteryDevice_NoNameFound_enUS = "no StorageBatteryDevice found";
	public static final String StorageBatteryDevice_ApiUri_enUS = "/api/StorageBatteryDevice";
	public static final String StorageBatteryDevice_ApiUriSearchPage_enUS = "/StorageBatteryDevice";
	public static final String StorageBatteryDevice_OfName_enUS = "of StorageBatteryDevice";
	public static final String StorageBatteryDevice_ANameAdjective_enUS = "a StorageBatteryDevice";
	public static final String StorageBatteryDevice_NameAdjectiveSingular_enUS = "StorageBatteryDevice";
	public static final String StorageBatteryDevice_NameAdjectivePlural_enUS = "StorageBatteryDevices";
	public static final String Search_enUS_Uri = "/api/StorageBatteryDevice";
	public static final String Search_enUS_ImageUri = "/png/api/StorageBatteryDevice-999.png";
	public static final String GET_enUS_Uri = "/api/StorageBatteryDevice/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/StorageBatteryDevice/{id}-999.png";
	public static final String PATCH_enUS_Uri = "/api/StorageBatteryDevice";
	public static final String PATCH_enUS_ImageUri = "/png/api/StorageBatteryDevice-999.png";
	public static final String POST_enUS_Uri = "/api/StorageBatteryDevice";
	public static final String POST_enUS_ImageUri = "/png/api/StorageBatteryDevice-999.png";
	public static final String PUTImport_enUS_Uri = "/api/StorageBatteryDevice-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/StorageBatteryDevice-import-999.png";
	public static final String SearchPage_enUS_Uri = "/StorageBatteryDevice";
	public static final String SearchPage_enUS_ImageUri = "/png/StorageBatteryDevice-999.png";

	public static final String StorageBatteryDevice_Color = "2017-shaded-spruce";
	public static final String StorageBatteryDevice_IconGroup = "duotone";
	public static final String StorageBatteryDevice_IconName = "map-location-dot";
	public static final Integer StorageBatteryDevice_Rows = 100;

	/////////////
	// address //
	/////////////


	/**	 The entity address
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject address;

	/**	<br> The entity address
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _address(Wrap<JsonObject> w);

	public JsonObject getAddress() {
		return address;
	}

	public void setAddress(JsonObject address) {
		this.address = address;
	}
	@JsonIgnore
	public void setAddress(String o) {
		this.address = StorageBatteryDevice.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchAddress(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAddress(siteRequest_, StorageBatteryDevice.staticSetAddress(siteRequest_, o)).toString();
	}

	public JsonObject sqlAddress() {
		return address;
	}

	///////////////////
	// alternateName //
	///////////////////


	/**	 The entity alternateName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String alternateName;

	/**	<br> The entity alternateName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _alternateName(Wrap<String> w);

	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String o) {
		this.alternateName = StorageBatteryDevice.staticSetAlternateName(siteRequest_, o);
	}
	public static String staticSetAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice alternateNameInit() {
		Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
		if(alternateName == null) {
			_alternateName(alternateNameWrap);
			Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
				setAlternateName(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAlternateName(siteRequest_, StorageBatteryDevice.staticSetAlternateName(siteRequest_, o)).toString();
	}

	public String sqlAlternateName() {
		return alternateName;
	}

	/////////////////
	// application //
	/////////////////


	/**	 The entity application
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject application;

	/**	<br> The entity application
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:application">Find the entity application in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _application(Wrap<JsonObject> w);

	public JsonObject getApplication() {
		return application;
	}

	public void setApplication(JsonObject application) {
		this.application = application;
	}
	@JsonIgnore
	public void setApplication(String o) {
		this.application = StorageBatteryDevice.staticSetApplication(siteRequest_, o);
	}
	public static JsonObject staticSetApplication(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice applicationInit() {
		Wrap<JsonObject> applicationWrap = new Wrap<JsonObject>().var("application");
		if(application == null) {
			_application(applicationWrap);
			Optional.ofNullable(applicationWrap.getO()).ifPresent(o -> {
				setApplication(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchApplication(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrApplication(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqApplication(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchApplication(siteRequest_, StorageBatteryDevice.staticSetApplication(siteRequest_, o)).toString();
	}

	public JsonObject sqlApplication() {
		return application;
	}

	//////////////////////
	// areaServedColors //
	//////////////////////


	/**	 The entity areaServedColors
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> areaServedColors = new ArrayList<String>();

	/**	<br> The entity areaServedColors
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServedColors(List<String> l);

	public List<String> getAreaServedColors() {
		return areaServedColors;
	}

	public void setAreaServedColors(List<String> areaServedColors) {
		this.areaServedColors = areaServedColors;
	}
	public void setAreaServedColors(String o) {
		String l = StorageBatteryDevice.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public StorageBatteryDevice addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (StorageBatteryDevice)this;
	}
	public StorageBatteryDevice addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (StorageBatteryDevice)this;
	}
	@JsonIgnore
	public void setAreaServedColors(JsonArray objects) {
		areaServedColors.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAreaServedColors(o);
		}
	}
	protected StorageBatteryDevice areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAreaServedColors(siteRequest_, StorageBatteryDevice.staticSetAreaServedColors(siteRequest_, o)).toString();
	}

	//////////////////////
	// areaServedTitles //
	//////////////////////


	/**	 The entity areaServedTitles
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> areaServedTitles = new ArrayList<String>();

	/**	<br> The entity areaServedTitles
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServedTitles(List<String> l);

	public List<String> getAreaServedTitles() {
		return areaServedTitles;
	}

	public void setAreaServedTitles(List<String> areaServedTitles) {
		this.areaServedTitles = areaServedTitles;
	}
	public void setAreaServedTitles(String o) {
		String l = StorageBatteryDevice.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public StorageBatteryDevice addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (StorageBatteryDevice)this;
	}
	public StorageBatteryDevice addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (StorageBatteryDevice)this;
	}
	@JsonIgnore
	public void setAreaServedTitles(JsonArray objects) {
		areaServedTitles.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAreaServedTitles(o);
		}
	}
	protected StorageBatteryDevice areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAreaServedTitles(siteRequest_, StorageBatteryDevice.staticSetAreaServedTitles(siteRequest_, o)).toString();
	}

	/////////////////////
	// areaServedLinks //
	/////////////////////


	/**	 The entity areaServedLinks
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> areaServedLinks = new ArrayList<String>();

	/**	<br> The entity areaServedLinks
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServedLinks(List<String> l);

	public List<String> getAreaServedLinks() {
		return areaServedLinks;
	}

	public void setAreaServedLinks(List<String> areaServedLinks) {
		this.areaServedLinks = areaServedLinks;
	}
	public void setAreaServedLinks(String o) {
		String l = StorageBatteryDevice.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public StorageBatteryDevice addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (StorageBatteryDevice)this;
	}
	public StorageBatteryDevice addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (StorageBatteryDevice)this;
	}
	@JsonIgnore
	public void setAreaServedLinks(JsonArray objects) {
		areaServedLinks.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAreaServedLinks(o);
		}
	}
	protected StorageBatteryDevice areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAreaServedLinks(siteRequest_, StorageBatteryDevice.staticSetAreaServedLinks(siteRequest_, o)).toString();
	}

	////////////////
	// areaServed //
	////////////////


	/**	 The entity areaServed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPathDeserializer.class)
	@JsonSerialize(using = PgClientPathSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Path areaServed;

	/**	<br> The entity areaServed
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _areaServed(Wrap<Path> w);

	public Path getAreaServed() {
		return areaServed;
	}

	public void setAreaServed(Path areaServed) {
		this.areaServed = areaServed;
	}
	@JsonIgnore
	public void setAreaServed(String o) {
		this.areaServed = StorageBatteryDevice.staticSetAreaServed(siteRequest_, o);
	}
	public static Path staticSetAreaServed(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
			try {
				Path shape = null;
				if(StringUtils.isNotBlank(o)) {
					ObjectMapper objectMapper = new ObjectMapper();
					SimpleModule module = new SimpleModule();
					module.setDeserializerModifier(new BeanDeserializerModifier() {
						@Override
						public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
							if (beanDesc.getBeanClass() == Path.class) {
								return new PgClientPathDeserializer();
							}
							return deserializer;
						}
					});
					objectMapper.registerModule(module);
					shape = objectMapper.readValue(Json.encode(o), Path.class);
				}
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	public void setAreaServed(JsonObject o) {
		this.areaServed = StorageBatteryDevice.staticSetAreaServed(siteRequest_, o);
	}
	public static Path staticSetAreaServed(SiteRequestEnUS siteRequest_, JsonObject o) {
		if(o != null) {
			try {
				Path shape = new Path();
				o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(points -> {
					shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
				});
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	protected StorageBatteryDevice areaServedInit() {
		Wrap<Path> areaServedWrap = new Wrap<Path>().var("areaServed");
		if(areaServed == null) {
			_areaServed(areaServedWrap);
			Optional.ofNullable(areaServedWrap.getO()).ifPresent(o -> {
				setAreaServed(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Path staticSearchAreaServed(SiteRequestEnUS siteRequest_, Path o) {
		return o;
	}

	public static String staticSearchStrAreaServed(SiteRequestEnUS siteRequest_, Path o) {
		JsonArray pointsArray = new JsonArray();
		o.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
		return new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString();
	}

	public static String staticSearchFqAreaServed(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAreaServed(siteRequest_, StorageBatteryDevice.staticSetAreaServed(siteRequest_, o)).toString();
	}

	public Path sqlAreaServed() {
		return areaServed;
	}

	/////////////////
	// averageLife //
	/////////////////


	/**	 The entity averageLife
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageLife;

	/**	<br> The entity averageLife
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:averageLife">Find the entity averageLife in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageLife(Wrap<BigDecimal> w);

	public BigDecimal getAverageLife() {
		return averageLife;
	}

	public void setAverageLife(BigDecimal averageLife) {
		this.averageLife = averageLife;
	}
	@JsonIgnore
	public void setAverageLife(String o) {
		this.averageLife = StorageBatteryDevice.staticSetAverageLife(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageLife(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageLife(Double o) {
		setAverageLife(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageLife(Integer o) {
		setAverageLife(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageLife(Number o) {
		setAverageLife(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice averageLifeInit() {
		Wrap<BigDecimal> averageLifeWrap = new Wrap<BigDecimal>().var("averageLife");
		if(averageLife == null) {
			_averageLife(averageLifeWrap);
			Optional.ofNullable(averageLifeWrap.getO()).ifPresent(o -> {
				setAverageLife(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchAverageLife(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageLife(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageLife(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchAverageLife(siteRequest_, StorageBatteryDevice.staticSetAverageLife(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageLife() {
		return averageLife;
	}

	//////////////////////////////
	// batteryAssessmentMethods //
	//////////////////////////////


	/**	 The entity batteryAssessmentMethods
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String batteryAssessmentMethods;

	/**	<br> The entity batteryAssessmentMethods
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:batteryAssessmentMethods">Find the entity batteryAssessmentMethods in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _batteryAssessmentMethods(Wrap<String> w);

	public String getBatteryAssessmentMethods() {
		return batteryAssessmentMethods;
	}
	public void setBatteryAssessmentMethods(String o) {
		this.batteryAssessmentMethods = StorageBatteryDevice.staticSetBatteryAssessmentMethods(siteRequest_, o);
	}
	public static String staticSetBatteryAssessmentMethods(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice batteryAssessmentMethodsInit() {
		Wrap<String> batteryAssessmentMethodsWrap = new Wrap<String>().var("batteryAssessmentMethods");
		if(batteryAssessmentMethods == null) {
			_batteryAssessmentMethods(batteryAssessmentMethodsWrap);
			Optional.ofNullable(batteryAssessmentMethodsWrap.getO()).ifPresent(o -> {
				setBatteryAssessmentMethods(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchBatteryAssessmentMethods(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrBatteryAssessmentMethods(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqBatteryAssessmentMethods(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchBatteryAssessmentMethods(siteRequest_, StorageBatteryDevice.staticSetBatteryAssessmentMethods(siteRequest_, o)).toString();
	}

	public String sqlBatteryAssessmentMethods() {
		return batteryAssessmentMethods;
	}

	/////////////////
	// batteryType //
	/////////////////


	/**	 The entity batteryType
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String batteryType;

	/**	<br> The entity batteryType
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:batteryType">Find the entity batteryType in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _batteryType(Wrap<String> w);

	public String getBatteryType() {
		return batteryType;
	}
	public void setBatteryType(String o) {
		this.batteryType = StorageBatteryDevice.staticSetBatteryType(siteRequest_, o);
	}
	public static String staticSetBatteryType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice batteryTypeInit() {
		Wrap<String> batteryTypeWrap = new Wrap<String>().var("batteryType");
		if(batteryType == null) {
			_batteryType(batteryTypeWrap);
			Optional.ofNullable(batteryTypeWrap.getO()).ifPresent(o -> {
				setBatteryType(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchBatteryType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrBatteryType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqBatteryType(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchBatteryType(siteRequest_, StorageBatteryDevice.staticSetBatteryType(siteRequest_, o)).toString();
	}

	public String sqlBatteryType() {
		return batteryType;
	}

	///////////////
	// brandName //
	///////////////


	/**	 The entity brandName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String brandName;

	/**	<br> The entity brandName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:brandName">Find the entity brandName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _brandName(Wrap<String> w);

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String o) {
		this.brandName = StorageBatteryDevice.staticSetBrandName(siteRequest_, o);
	}
	public static String staticSetBrandName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice brandNameInit() {
		Wrap<String> brandNameWrap = new Wrap<String>().var("brandName");
		if(brandName == null) {
			_brandName(brandNameWrap);
			Optional.ofNullable(brandNameWrap.getO()).ifPresent(o -> {
				setBrandName(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchBrandName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrBrandName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqBrandName(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchBrandName(siteRequest_, StorageBatteryDevice.staticSetBrandName(siteRequest_, o)).toString();
	}

	public String sqlBrandName() {
		return brandName;
	}

	//////////////////
	// capacityCnnn //
	//////////////////


	/**	 The entity capacityCnnn
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject capacityCnnn;

	/**	<br> The entity capacityCnnn
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:capacityCnnn">Find the entity capacityCnnn in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _capacityCnnn(Wrap<JsonObject> w);

	public JsonObject getCapacityCnnn() {
		return capacityCnnn;
	}

	public void setCapacityCnnn(JsonObject capacityCnnn) {
		this.capacityCnnn = capacityCnnn;
	}
	@JsonIgnore
	public void setCapacityCnnn(String o) {
		this.capacityCnnn = StorageBatteryDevice.staticSetCapacityCnnn(siteRequest_, o);
	}
	public static JsonObject staticSetCapacityCnnn(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice capacityCnnnInit() {
		Wrap<JsonObject> capacityCnnnWrap = new Wrap<JsonObject>().var("capacityCnnn");
		if(capacityCnnn == null) {
			_capacityCnnn(capacityCnnnWrap);
			Optional.ofNullable(capacityCnnnWrap.getO()).ifPresent(o -> {
				setCapacityCnnn(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchCapacityCnnn(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrCapacityCnnn(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCapacityCnnn(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchCapacityCnnn(siteRequest_, StorageBatteryDevice.staticSetCapacityCnnn(siteRequest_, o)).toString();
	}

	public JsonObject sqlCapacityCnnn() {
		return capacityCnnn;
	}

	///////////////////////////////
	// chargeDischargeReactivity //
	///////////////////////////////


	/**	 The entity chargeDischargeReactivity
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal chargeDischargeReactivity;

	/**	<br> The entity chargeDischargeReactivity
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:chargeDischargeReactivity">Find the entity chargeDischargeReactivity in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _chargeDischargeReactivity(Wrap<BigDecimal> w);

	public BigDecimal getChargeDischargeReactivity() {
		return chargeDischargeReactivity;
	}

	public void setChargeDischargeReactivity(BigDecimal chargeDischargeReactivity) {
		this.chargeDischargeReactivity = chargeDischargeReactivity;
	}
	@JsonIgnore
	public void setChargeDischargeReactivity(String o) {
		this.chargeDischargeReactivity = StorageBatteryDevice.staticSetChargeDischargeReactivity(siteRequest_, o);
	}
	public static BigDecimal staticSetChargeDischargeReactivity(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setChargeDischargeReactivity(Double o) {
		setChargeDischargeReactivity(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setChargeDischargeReactivity(Integer o) {
		setChargeDischargeReactivity(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setChargeDischargeReactivity(Number o) {
		setChargeDischargeReactivity(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice chargeDischargeReactivityInit() {
		Wrap<BigDecimal> chargeDischargeReactivityWrap = new Wrap<BigDecimal>().var("chargeDischargeReactivity");
		if(chargeDischargeReactivity == null) {
			_chargeDischargeReactivity(chargeDischargeReactivityWrap);
			Optional.ofNullable(chargeDischargeReactivityWrap.getO()).ifPresent(o -> {
				setChargeDischargeReactivity(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchChargeDischargeReactivity(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrChargeDischargeReactivity(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqChargeDischargeReactivity(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchChargeDischargeReactivity(siteRequest_, StorageBatteryDevice.staticSetChargeDischargeReactivity(siteRequest_, o)).toString();
	}

	public BigDecimal sqlChargeDischargeReactivity() {
		return chargeDischargeReactivity;
	}

	//////////////////////
	// chargeEfficiency //
	//////////////////////


	/**	 The entity chargeEfficiency
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal chargeEfficiency;

	/**	<br> The entity chargeEfficiency
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:chargeEfficiency">Find the entity chargeEfficiency in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _chargeEfficiency(Wrap<BigDecimal> w);

	public BigDecimal getChargeEfficiency() {
		return chargeEfficiency;
	}

	public void setChargeEfficiency(BigDecimal chargeEfficiency) {
		this.chargeEfficiency = chargeEfficiency;
	}
	@JsonIgnore
	public void setChargeEfficiency(String o) {
		this.chargeEfficiency = StorageBatteryDevice.staticSetChargeEfficiency(siteRequest_, o);
	}
	public static BigDecimal staticSetChargeEfficiency(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setChargeEfficiency(Double o) {
		setChargeEfficiency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setChargeEfficiency(Integer o) {
		setChargeEfficiency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setChargeEfficiency(Number o) {
		setChargeEfficiency(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice chargeEfficiencyInit() {
		Wrap<BigDecimal> chargeEfficiencyWrap = new Wrap<BigDecimal>().var("chargeEfficiency");
		if(chargeEfficiency == null) {
			_chargeEfficiency(chargeEfficiencyWrap);
			Optional.ofNullable(chargeEfficiencyWrap.getO()).ifPresent(o -> {
				setChargeEfficiency(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchChargeEfficiency(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrChargeEfficiency(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqChargeEfficiency(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchChargeEfficiency(siteRequest_, StorageBatteryDevice.staticSetChargeEfficiency(siteRequest_, o)).toString();
	}

	public BigDecimal sqlChargeEfficiency() {
		return chargeEfficiency;
	}

	/////////////////
	// chargePower //
	/////////////////


	/**	 The entity chargePower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal chargePower;

	/**	<br> The entity chargePower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:chargePower">Find the entity chargePower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _chargePower(Wrap<BigDecimal> w);

	public BigDecimal getChargePower() {
		return chargePower;
	}

	public void setChargePower(BigDecimal chargePower) {
		this.chargePower = chargePower;
	}
	@JsonIgnore
	public void setChargePower(String o) {
		this.chargePower = StorageBatteryDevice.staticSetChargePower(siteRequest_, o);
	}
	public static BigDecimal staticSetChargePower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setChargePower(Double o) {
		setChargePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setChargePower(Integer o) {
		setChargePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setChargePower(Number o) {
		setChargePower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice chargePowerInit() {
		Wrap<BigDecimal> chargePowerWrap = new Wrap<BigDecimal>().var("chargePower");
		if(chargePower == null) {
			_chargePower(chargePowerWrap);
			Optional.ofNullable(chargePowerWrap.getO()).ifPresent(o -> {
				setChargePower(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchChargePower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrChargePower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqChargePower(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchChargePower(siteRequest_, StorageBatteryDevice.staticSetChargePower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlChargePower() {
		return chargePower;
	}

	/////////////////////////
	// chargingModeAllowed //
	/////////////////////////


	/**	 The entity chargingModeAllowed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject chargingModeAllowed;

	/**	<br> The entity chargingModeAllowed
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:chargingModeAllowed">Find the entity chargingModeAllowed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _chargingModeAllowed(Wrap<JsonObject> w);

	public JsonObject getChargingModeAllowed() {
		return chargingModeAllowed;
	}

	public void setChargingModeAllowed(JsonObject chargingModeAllowed) {
		this.chargingModeAllowed = chargingModeAllowed;
	}
	@JsonIgnore
	public void setChargingModeAllowed(String o) {
		this.chargingModeAllowed = StorageBatteryDevice.staticSetChargingModeAllowed(siteRequest_, o);
	}
	public static JsonObject staticSetChargingModeAllowed(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice chargingModeAllowedInit() {
		Wrap<JsonObject> chargingModeAllowedWrap = new Wrap<JsonObject>().var("chargingModeAllowed");
		if(chargingModeAllowed == null) {
			_chargingModeAllowed(chargingModeAllowedWrap);
			Optional.ofNullable(chargingModeAllowedWrap.getO()).ifPresent(o -> {
				setChargingModeAllowed(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchChargingModeAllowed(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrChargingModeAllowed(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqChargingModeAllowed(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchChargingModeAllowed(siteRequest_, StorageBatteryDevice.staticSetChargingModeAllowed(siteRequest_, o)).toString();
	}

	public JsonObject sqlChargingModeAllowed() {
		return chargingModeAllowed;
	}

	///////////////////
	// communication //
	///////////////////


	/**	 The entity communication
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject communication;

	/**	<br> The entity communication
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:communication">Find the entity communication in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _communication(Wrap<JsonObject> w);

	public JsonObject getCommunication() {
		return communication;
	}

	public void setCommunication(JsonObject communication) {
		this.communication = communication;
	}
	@JsonIgnore
	public void setCommunication(String o) {
		this.communication = StorageBatteryDevice.staticSetCommunication(siteRequest_, o);
	}
	public static JsonObject staticSetCommunication(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice communicationInit() {
		Wrap<JsonObject> communicationWrap = new Wrap<JsonObject>().var("communication");
		if(communication == null) {
			_communication(communicationWrap);
			Optional.ofNullable(communicationWrap.getO()).ifPresent(o -> {
				setCommunication(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchCommunication(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrCommunication(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCommunication(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchCommunication(siteRequest_, StorageBatteryDevice.staticSetCommunication(siteRequest_, o)).toString();
	}

	public JsonObject sqlCommunication() {
		return communication;
	}

	//////////////////
	// dataProvider //
	//////////////////


	/**	 The entity dataProvider
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dataProvider;

	/**	<br> The entity dataProvider
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataProvider(Wrap<String> w);

	public String getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(String o) {
		this.dataProvider = StorageBatteryDevice.staticSetDataProvider(siteRequest_, o);
	}
	public static String staticSetDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice dataProviderInit() {
		Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
		if(dataProvider == null) {
			_dataProvider(dataProviderWrap);
			Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
				setDataProvider(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDataProvider(siteRequest_, StorageBatteryDevice.staticSetDataProvider(siteRequest_, o)).toString();
	}

	public String sqlDataProvider() {
		return dataProvider;
	}

	/////////////////
	// dateCreated //
	/////////////////


	/**	 The entity dateCreated
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateCreated;

	/**	<br> The entity dateCreated
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateCreated(Wrap<String> w);

	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String o) {
		this.dateCreated = StorageBatteryDevice.staticSetDateCreated(siteRequest_, o);
	}
	public static String staticSetDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice dateCreatedInit() {
		Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
		if(dateCreated == null) {
			_dateCreated(dateCreatedWrap);
			Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
				setDateCreated(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDateCreated(siteRequest_, StorageBatteryDevice.staticSetDateCreated(siteRequest_, o)).toString();
	}

	public String sqlDateCreated() {
		return dateCreated;
	}

	//////////////////////
	// dateLastReported //
	//////////////////////


	/**	 The entity dateLastReported
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateLastReported;

	/**	<br> The entity dateLastReported
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dateLastReported">Find the entity dateLastReported in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateLastReported(Wrap<String> w);

	public String getDateLastReported() {
		return dateLastReported;
	}
	public void setDateLastReported(String o) {
		this.dateLastReported = StorageBatteryDevice.staticSetDateLastReported(siteRequest_, o);
	}
	public static String staticSetDateLastReported(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice dateLastReportedInit() {
		Wrap<String> dateLastReportedWrap = new Wrap<String>().var("dateLastReported");
		if(dateLastReported == null) {
			_dateLastReported(dateLastReportedWrap);
			Optional.ofNullable(dateLastReportedWrap.getO()).ifPresent(o -> {
				setDateLastReported(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDateLastReported(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateLastReported(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateLastReported(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDateLastReported(siteRequest_, StorageBatteryDevice.staticSetDateLastReported(siteRequest_, o)).toString();
	}

	public String sqlDateLastReported() {
		return dateLastReported;
	}

	//////////////////
	// dateModified //
	//////////////////


	/**	 The entity dateModified
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateModified;

	/**	<br> The entity dateModified
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateModified(Wrap<String> w);

	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String o) {
		this.dateModified = StorageBatteryDevice.staticSetDateModified(siteRequest_, o);
	}
	public static String staticSetDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice dateModifiedInit() {
		Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
		if(dateModified == null) {
			_dateModified(dateModifiedWrap);
			Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
				setDateModified(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateModified(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDateModified(siteRequest_, StorageBatteryDevice.staticSetDateModified(siteRequest_, o)).toString();
	}

	public String sqlDateModified() {
		return dateModified;
	}

	/////////////////
	// description //
	/////////////////


	/**	 The entity description
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String description;

	/**	<br> The entity description
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = StorageBatteryDevice.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDescription(siteRequest_, StorageBatteryDevice.staticSetDescription(siteRequest_, o)).toString();
	}

	public String sqlDescription() {
		return description;
	}

	///////////////
	// dimension //
	///////////////


	/**	 The entity dimension
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject dimension;

	/**	<br> The entity dimension
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dimension">Find the entity dimension in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dimension(Wrap<JsonObject> w);

	public JsonObject getDimension() {
		return dimension;
	}

	public void setDimension(JsonObject dimension) {
		this.dimension = dimension;
	}
	@JsonIgnore
	public void setDimension(String o) {
		this.dimension = StorageBatteryDevice.staticSetDimension(siteRequest_, o);
	}
	public static JsonObject staticSetDimension(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice dimensionInit() {
		Wrap<JsonObject> dimensionWrap = new Wrap<JsonObject>().var("dimension");
		if(dimension == null) {
			_dimension(dimensionWrap);
			Optional.ofNullable(dimensionWrap.getO()).ifPresent(o -> {
				setDimension(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDimension(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrDimension(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDimension(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDimension(siteRequest_, StorageBatteryDevice.staticSetDimension(siteRequest_, o)).toString();
	}

	public JsonObject sqlDimension() {
		return dimension;
	}

	/////////////////////////
	// dischargeEfficiency //
	/////////////////////////


	/**	 The entity dischargeEfficiency
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal dischargeEfficiency;

	/**	<br> The entity dischargeEfficiency
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dischargeEfficiency">Find the entity dischargeEfficiency in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dischargeEfficiency(Wrap<BigDecimal> w);

	public BigDecimal getDischargeEfficiency() {
		return dischargeEfficiency;
	}

	public void setDischargeEfficiency(BigDecimal dischargeEfficiency) {
		this.dischargeEfficiency = dischargeEfficiency;
	}
	@JsonIgnore
	public void setDischargeEfficiency(String o) {
		this.dischargeEfficiency = StorageBatteryDevice.staticSetDischargeEfficiency(siteRequest_, o);
	}
	public static BigDecimal staticSetDischargeEfficiency(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDischargeEfficiency(Double o) {
		setDischargeEfficiency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDischargeEfficiency(Integer o) {
		setDischargeEfficiency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDischargeEfficiency(Number o) {
		setDischargeEfficiency(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice dischargeEfficiencyInit() {
		Wrap<BigDecimal> dischargeEfficiencyWrap = new Wrap<BigDecimal>().var("dischargeEfficiency");
		if(dischargeEfficiency == null) {
			_dischargeEfficiency(dischargeEfficiencyWrap);
			Optional.ofNullable(dischargeEfficiencyWrap.getO()).ifPresent(o -> {
				setDischargeEfficiency(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchDischargeEfficiency(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDischargeEfficiency(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDischargeEfficiency(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDischargeEfficiency(siteRequest_, StorageBatteryDevice.staticSetDischargeEfficiency(siteRequest_, o)).toString();
	}

	public BigDecimal sqlDischargeEfficiency() {
		return dischargeEfficiency;
	}

	////////////////////
	// dischargePower //
	////////////////////


	/**	 The entity dischargePower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal dischargePower;

	/**	<br> The entity dischargePower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:dischargePower">Find the entity dischargePower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dischargePower(Wrap<BigDecimal> w);

	public BigDecimal getDischargePower() {
		return dischargePower;
	}

	public void setDischargePower(BigDecimal dischargePower) {
		this.dischargePower = dischargePower;
	}
	@JsonIgnore
	public void setDischargePower(String o) {
		this.dischargePower = StorageBatteryDevice.staticSetDischargePower(siteRequest_, o);
	}
	public static BigDecimal staticSetDischargePower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDischargePower(Double o) {
		setDischargePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDischargePower(Integer o) {
		setDischargePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDischargePower(Number o) {
		setDischargePower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice dischargePowerInit() {
		Wrap<BigDecimal> dischargePowerWrap = new Wrap<BigDecimal>().var("dischargePower");
		if(dischargePower == null) {
			_dischargePower(dischargePowerWrap);
			Optional.ofNullable(dischargePowerWrap.getO()).ifPresent(o -> {
				setDischargePower(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchDischargePower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDischargePower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDischargePower(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDischargePower(siteRequest_, StorageBatteryDevice.staticSetDischargePower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlDischargePower() {
		return dischargePower;
	}

	///////////////////
	// documentation //
	///////////////////


	/**	 The entity documentation
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String documentation;

	/**	<br> The entity documentation
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:documentation">Find the entity documentation in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _documentation(Wrap<String> w);

	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String o) {
		this.documentation = StorageBatteryDevice.staticSetDocumentation(siteRequest_, o);
	}
	public static String staticSetDocumentation(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice documentationInit() {
		Wrap<String> documentationWrap = new Wrap<String>().var("documentation");
		if(documentation == null) {
			_documentation(documentationWrap);
			Optional.ofNullable(documentationWrap.getO()).ifPresent(o -> {
				setDocumentation(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchDocumentation(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDocumentation(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDocumentation(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDocumentation(siteRequest_, StorageBatteryDevice.staticSetDocumentation(siteRequest_, o)).toString();
	}

	public String sqlDocumentation() {
		return documentation;
	}

	///////////////////////
	// durationPeakPower //
	///////////////////////


	/**	 The entity durationPeakPower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal durationPeakPower;

	/**	<br> The entity durationPeakPower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:durationPeakPower">Find the entity durationPeakPower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _durationPeakPower(Wrap<BigDecimal> w);

	public BigDecimal getDurationPeakPower() {
		return durationPeakPower;
	}

	public void setDurationPeakPower(BigDecimal durationPeakPower) {
		this.durationPeakPower = durationPeakPower;
	}
	@JsonIgnore
	public void setDurationPeakPower(String o) {
		this.durationPeakPower = StorageBatteryDevice.staticSetDurationPeakPower(siteRequest_, o);
	}
	public static BigDecimal staticSetDurationPeakPower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDurationPeakPower(Double o) {
		setDurationPeakPower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDurationPeakPower(Integer o) {
		setDurationPeakPower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDurationPeakPower(Number o) {
		setDurationPeakPower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice durationPeakPowerInit() {
		Wrap<BigDecimal> durationPeakPowerWrap = new Wrap<BigDecimal>().var("durationPeakPower");
		if(durationPeakPower == null) {
			_durationPeakPower(durationPeakPowerWrap);
			Optional.ofNullable(durationPeakPowerWrap.getO()).ifPresent(o -> {
				setDurationPeakPower(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchDurationPeakPower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDurationPeakPower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDurationPeakPower(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchDurationPeakPower(siteRequest_, StorageBatteryDevice.staticSetDurationPeakPower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlDurationPeakPower() {
		return durationPeakPower;
	}

	///////////////////////////
	// installationCondition //
	///////////////////////////


	/**	 The entity installationCondition
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject installationCondition;

	/**	<br> The entity installationCondition
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:installationCondition">Find the entity installationCondition in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _installationCondition(Wrap<JsonObject> w);

	public JsonObject getInstallationCondition() {
		return installationCondition;
	}

	public void setInstallationCondition(JsonObject installationCondition) {
		this.installationCondition = installationCondition;
	}
	@JsonIgnore
	public void setInstallationCondition(String o) {
		this.installationCondition = StorageBatteryDevice.staticSetInstallationCondition(siteRequest_, o);
	}
	public static JsonObject staticSetInstallationCondition(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice installationConditionInit() {
		Wrap<JsonObject> installationConditionWrap = new Wrap<JsonObject>().var("installationCondition");
		if(installationCondition == null) {
			_installationCondition(installationConditionWrap);
			Optional.ofNullable(installationConditionWrap.getO()).ifPresent(o -> {
				setInstallationCondition(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchInstallationCondition(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrInstallationCondition(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInstallationCondition(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchInstallationCondition(siteRequest_, StorageBatteryDevice.staticSetInstallationCondition(siteRequest_, o)).toString();
	}

	public JsonObject sqlInstallationCondition() {
		return installationCondition;
	}

	//////////////////////
	// installationMode //
	//////////////////////


	/**	 The entity installationMode
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String installationMode;

	/**	<br> The entity installationMode
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:installationMode">Find the entity installationMode in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _installationMode(Wrap<String> w);

	public String getInstallationMode() {
		return installationMode;
	}
	public void setInstallationMode(String o) {
		this.installationMode = StorageBatteryDevice.staticSetInstallationMode(siteRequest_, o);
	}
	public static String staticSetInstallationMode(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice installationModeInit() {
		Wrap<String> installationModeWrap = new Wrap<String>().var("installationMode");
		if(installationMode == null) {
			_installationMode(installationModeWrap);
			Optional.ofNullable(installationModeWrap.getO()).ifPresent(o -> {
				setInstallationMode(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchInstallationMode(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrInstallationMode(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInstallationMode(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchInstallationMode(siteRequest_, StorageBatteryDevice.staticSetInstallationMode(siteRequest_, o)).toString();
	}

	public String sqlInstallationMode() {
		return installationMode;
	}

	/////////////////////
	// lifeCycleNumber //
	/////////////////////


	/**	 The entity lifeCycleNumber
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject lifeCycleNumber;

	/**	<br> The entity lifeCycleNumber
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:lifeCycleNumber">Find the entity lifeCycleNumber in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _lifeCycleNumber(Wrap<JsonObject> w);

	public JsonObject getLifeCycleNumber() {
		return lifeCycleNumber;
	}

	public void setLifeCycleNumber(JsonObject lifeCycleNumber) {
		this.lifeCycleNumber = lifeCycleNumber;
	}
	@JsonIgnore
	public void setLifeCycleNumber(String o) {
		this.lifeCycleNumber = StorageBatteryDevice.staticSetLifeCycleNumber(siteRequest_, o);
	}
	public static JsonObject staticSetLifeCycleNumber(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice lifeCycleNumberInit() {
		Wrap<JsonObject> lifeCycleNumberWrap = new Wrap<JsonObject>().var("lifeCycleNumber");
		if(lifeCycleNumber == null) {
			_lifeCycleNumber(lifeCycleNumberWrap);
			Optional.ofNullable(lifeCycleNumberWrap.getO()).ifPresent(o -> {
				setLifeCycleNumber(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchLifeCycleNumber(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrLifeCycleNumber(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLifeCycleNumber(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchLifeCycleNumber(siteRequest_, StorageBatteryDevice.staticSetLifeCycleNumber(siteRequest_, o)).toString();
	}

	public JsonObject sqlLifeCycleNumber() {
		return lifeCycleNumber;
	}

	//////////////
	// location //
	//////////////


	/**	 The entity location
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPointDeserializer.class)
	@JsonSerialize(using = PgClientPointSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Point location;

	/**	<br> The entity location
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _location(Wrap<Point> w);

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	@JsonIgnore
	public void setLocation(String o) {
		this.location = StorageBatteryDevice.staticSetLocation(siteRequest_, o);
	}
	public static Point staticSetLocation(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
			try {
				Point shape = null;
				if(StringUtils.isNotBlank(o)) {
					ObjectMapper objectMapper = new ObjectMapper();
					SimpleModule module = new SimpleModule();
					module.setDeserializerModifier(new BeanDeserializerModifier() {
						@Override
						public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
							if (beanDesc.getBeanClass() == Point.class) {
								return new PgClientPointDeserializer();
							}
							return deserializer;
						}
					});
					objectMapper.registerModule(module);
					shape = objectMapper.readValue(Json.encode(o), Point.class);
				}
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	public void setLocation(JsonObject o) {
		this.location = StorageBatteryDevice.staticSetLocation(siteRequest_, o);
	}
	public static Point staticSetLocation(SiteRequestEnUS siteRequest_, JsonObject o) {
		if(o != null) {
			try {
				Point shape = new Point();
				JsonArray coordinates = o.getJsonArray("coordinates");
				shape.setX(coordinates.getDouble(0));
				shape.setY(coordinates.getDouble(1));
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	protected StorageBatteryDevice locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Point staticSearchLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchLocation(siteRequest_, StorageBatteryDevice.staticSetLocation(siteRequest_, o)).toString();
	}

	public Point sqlLocation() {
		return location;
	}

	//////////////////////
	// manufacturerName //
	//////////////////////


	/**	 The entity manufacturerName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String manufacturerName;

	/**	<br> The entity manufacturerName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:manufacturerName">Find the entity manufacturerName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _manufacturerName(Wrap<String> w);

	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String o) {
		this.manufacturerName = StorageBatteryDevice.staticSetManufacturerName(siteRequest_, o);
	}
	public static String staticSetManufacturerName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice manufacturerNameInit() {
		Wrap<String> manufacturerNameWrap = new Wrap<String>().var("manufacturerName");
		if(manufacturerName == null) {
			_manufacturerName(manufacturerNameWrap);
			Optional.ofNullable(manufacturerNameWrap.getO()).ifPresent(o -> {
				setManufacturerName(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchManufacturerName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrManufacturerName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqManufacturerName(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchManufacturerName(siteRequest_, StorageBatteryDevice.staticSetManufacturerName(siteRequest_, o)).toString();
	}

	public String sqlManufacturerName() {
		return manufacturerName;
	}

	///////////////////////
	// massEnergyDensity //
	///////////////////////


	/**	 The entity massEnergyDensity
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject massEnergyDensity;

	/**	<br> The entity massEnergyDensity
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:massEnergyDensity">Find the entity massEnergyDensity in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _massEnergyDensity(Wrap<JsonObject> w);

	public JsonObject getMassEnergyDensity() {
		return massEnergyDensity;
	}

	public void setMassEnergyDensity(JsonObject massEnergyDensity) {
		this.massEnergyDensity = massEnergyDensity;
	}
	@JsonIgnore
	public void setMassEnergyDensity(String o) {
		this.massEnergyDensity = StorageBatteryDevice.staticSetMassEnergyDensity(siteRequest_, o);
	}
	public static JsonObject staticSetMassEnergyDensity(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice massEnergyDensityInit() {
		Wrap<JsonObject> massEnergyDensityWrap = new Wrap<JsonObject>().var("massEnergyDensity");
		if(massEnergyDensity == null) {
			_massEnergyDensity(massEnergyDensityWrap);
			Optional.ofNullable(massEnergyDensityWrap.getO()).ifPresent(o -> {
				setMassEnergyDensity(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchMassEnergyDensity(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrMassEnergyDensity(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMassEnergyDensity(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchMassEnergyDensity(siteRequest_, StorageBatteryDevice.staticSetMassEnergyDensity(siteRequest_, o)).toString();
	}

	public JsonObject sqlMassEnergyDensity() {
		return massEnergyDensity;
	}

	////////////////////
	// maxOutputPower //
	////////////////////


	/**	 The entity maxOutputPower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal maxOutputPower;

	/**	<br> The entity maxOutputPower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:maxOutputPower">Find the entity maxOutputPower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _maxOutputPower(Wrap<BigDecimal> w);

	public BigDecimal getMaxOutputPower() {
		return maxOutputPower;
	}

	public void setMaxOutputPower(BigDecimal maxOutputPower) {
		this.maxOutputPower = maxOutputPower;
	}
	@JsonIgnore
	public void setMaxOutputPower(String o) {
		this.maxOutputPower = StorageBatteryDevice.staticSetMaxOutputPower(siteRequest_, o);
	}
	public static BigDecimal staticSetMaxOutputPower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setMaxOutputPower(Double o) {
		setMaxOutputPower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMaxOutputPower(Integer o) {
		setMaxOutputPower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMaxOutputPower(Number o) {
		setMaxOutputPower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice maxOutputPowerInit() {
		Wrap<BigDecimal> maxOutputPowerWrap = new Wrap<BigDecimal>().var("maxOutputPower");
		if(maxOutputPower == null) {
			_maxOutputPower(maxOutputPowerWrap);
			Optional.ofNullable(maxOutputPowerWrap.getO()).ifPresent(o -> {
				setMaxOutputPower(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchMaxOutputPower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrMaxOutputPower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMaxOutputPower(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchMaxOutputPower(siteRequest_, StorageBatteryDevice.staticSetMaxOutputPower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlMaxOutputPower() {
		return maxOutputPower;
	}

	///////////////////////
	// maximumVoltageEOC //
	///////////////////////


	/**	 The entity maximumVoltageEOC
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal maximumVoltageEOC;

	/**	<br> The entity maximumVoltageEOC
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:maximumVoltageEOC">Find the entity maximumVoltageEOC in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _maximumVoltageEOC(Wrap<BigDecimal> w);

	public BigDecimal getMaximumVoltageEOC() {
		return maximumVoltageEOC;
	}

	public void setMaximumVoltageEOC(BigDecimal maximumVoltageEOC) {
		this.maximumVoltageEOC = maximumVoltageEOC;
	}
	@JsonIgnore
	public void setMaximumVoltageEOC(String o) {
		this.maximumVoltageEOC = StorageBatteryDevice.staticSetMaximumVoltageEOC(siteRequest_, o);
	}
	public static BigDecimal staticSetMaximumVoltageEOC(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setMaximumVoltageEOC(Double o) {
		setMaximumVoltageEOC(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMaximumVoltageEOC(Integer o) {
		setMaximumVoltageEOC(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMaximumVoltageEOC(Number o) {
		setMaximumVoltageEOC(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice maximumVoltageEOCInit() {
		Wrap<BigDecimal> maximumVoltageEOCWrap = new Wrap<BigDecimal>().var("maximumVoltageEOC");
		if(maximumVoltageEOC == null) {
			_maximumVoltageEOC(maximumVoltageEOCWrap);
			Optional.ofNullable(maximumVoltageEOCWrap.getO()).ifPresent(o -> {
				setMaximumVoltageEOC(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchMaximumVoltageEOC(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrMaximumVoltageEOC(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMaximumVoltageEOC(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchMaximumVoltageEOC(siteRequest_, StorageBatteryDevice.staticSetMaximumVoltageEOC(siteRequest_, o)).toString();
	}

	public BigDecimal sqlMaximumVoltageEOC() {
		return maximumVoltageEOC;
	}

	///////////////////////
	// minimumVoltageEOD //
	///////////////////////


	/**	 The entity minimumVoltageEOD
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal minimumVoltageEOD;

	/**	<br> The entity minimumVoltageEOD
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:minimumVoltageEOD">Find the entity minimumVoltageEOD in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _minimumVoltageEOD(Wrap<BigDecimal> w);

	public BigDecimal getMinimumVoltageEOD() {
		return minimumVoltageEOD;
	}

	public void setMinimumVoltageEOD(BigDecimal minimumVoltageEOD) {
		this.minimumVoltageEOD = minimumVoltageEOD;
	}
	@JsonIgnore
	public void setMinimumVoltageEOD(String o) {
		this.minimumVoltageEOD = StorageBatteryDevice.staticSetMinimumVoltageEOD(siteRequest_, o);
	}
	public static BigDecimal staticSetMinimumVoltageEOD(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setMinimumVoltageEOD(Double o) {
		setMinimumVoltageEOD(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMinimumVoltageEOD(Integer o) {
		setMinimumVoltageEOD(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMinimumVoltageEOD(Number o) {
		setMinimumVoltageEOD(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice minimumVoltageEODInit() {
		Wrap<BigDecimal> minimumVoltageEODWrap = new Wrap<BigDecimal>().var("minimumVoltageEOD");
		if(minimumVoltageEOD == null) {
			_minimumVoltageEOD(minimumVoltageEODWrap);
			Optional.ofNullable(minimumVoltageEODWrap.getO()).ifPresent(o -> {
				setMinimumVoltageEOD(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchMinimumVoltageEOD(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrMinimumVoltageEOD(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMinimumVoltageEOD(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchMinimumVoltageEOD(siteRequest_, StorageBatteryDevice.staticSetMinimumVoltageEOD(siteRequest_, o)).toString();
	}

	public BigDecimal sqlMinimumVoltageEOD() {
		return minimumVoltageEOD;
	}

	///////////////
	// modelName //
	///////////////


	/**	 The entity modelName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String modelName;

	/**	<br> The entity modelName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:modelName">Find the entity modelName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _modelName(Wrap<String> w);

	public String getModelName() {
		return modelName;
	}
	public void setModelName(String o) {
		this.modelName = StorageBatteryDevice.staticSetModelName(siteRequest_, o);
	}
	public static String staticSetModelName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice modelNameInit() {
		Wrap<String> modelNameWrap = new Wrap<String>().var("modelName");
		if(modelName == null) {
			_modelName(modelNameWrap);
			Optional.ofNullable(modelNameWrap.getO()).ifPresent(o -> {
				setModelName(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchModelName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrModelName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqModelName(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchModelName(siteRequest_, StorageBatteryDevice.staticSetModelName(siteRequest_, o)).toString();
	}

	public String sqlModelName() {
		return modelName;
	}

	//////////
	// name //
	//////////


	/**	 The entity name
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String name;

	/**	<br> The entity name
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = StorageBatteryDevice.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchName(siteRequest_, StorageBatteryDevice.staticSetName(siteRequest_, o)).toString();
	}

	public String sqlName() {
		return name;
	}

	///////////////////
	// nominalAmpere //
	///////////////////


	/**	 The entity nominalAmpere
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal nominalAmpere;

	/**	<br> The entity nominalAmpere
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:nominalAmpere">Find the entity nominalAmpere in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _nominalAmpere(Wrap<BigDecimal> w);

	public BigDecimal getNominalAmpere() {
		return nominalAmpere;
	}

	public void setNominalAmpere(BigDecimal nominalAmpere) {
		this.nominalAmpere = nominalAmpere;
	}
	@JsonIgnore
	public void setNominalAmpere(String o) {
		this.nominalAmpere = StorageBatteryDevice.staticSetNominalAmpere(siteRequest_, o);
	}
	public static BigDecimal staticSetNominalAmpere(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setNominalAmpere(Double o) {
		setNominalAmpere(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalAmpere(Integer o) {
		setNominalAmpere(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalAmpere(Number o) {
		setNominalAmpere(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice nominalAmpereInit() {
		Wrap<BigDecimal> nominalAmpereWrap = new Wrap<BigDecimal>().var("nominalAmpere");
		if(nominalAmpere == null) {
			_nominalAmpere(nominalAmpereWrap);
			Optional.ofNullable(nominalAmpereWrap.getO()).ifPresent(o -> {
				setNominalAmpere(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchNominalAmpere(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrNominalAmpere(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNominalAmpere(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchNominalAmpere(siteRequest_, StorageBatteryDevice.staticSetNominalAmpere(siteRequest_, o)).toString();
	}

	public BigDecimal sqlNominalAmpere() {
		return nominalAmpere;
	}

	/////////////////////
	// nominalCapacity //
	/////////////////////


	/**	 The entity nominalCapacity
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal nominalCapacity;

	/**	<br> The entity nominalCapacity
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:nominalCapacity">Find the entity nominalCapacity in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _nominalCapacity(Wrap<BigDecimal> w);

	public BigDecimal getNominalCapacity() {
		return nominalCapacity;
	}

	public void setNominalCapacity(BigDecimal nominalCapacity) {
		this.nominalCapacity = nominalCapacity;
	}
	@JsonIgnore
	public void setNominalCapacity(String o) {
		this.nominalCapacity = StorageBatteryDevice.staticSetNominalCapacity(siteRequest_, o);
	}
	public static BigDecimal staticSetNominalCapacity(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setNominalCapacity(Double o) {
		setNominalCapacity(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalCapacity(Integer o) {
		setNominalCapacity(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalCapacity(Number o) {
		setNominalCapacity(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice nominalCapacityInit() {
		Wrap<BigDecimal> nominalCapacityWrap = new Wrap<BigDecimal>().var("nominalCapacity");
		if(nominalCapacity == null) {
			_nominalCapacity(nominalCapacityWrap);
			Optional.ofNullable(nominalCapacityWrap.getO()).ifPresent(o -> {
				setNominalCapacity(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchNominalCapacity(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrNominalCapacity(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNominalCapacity(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchNominalCapacity(siteRequest_, StorageBatteryDevice.staticSetNominalCapacity(siteRequest_, o)).toString();
	}

	public BigDecimal sqlNominalCapacity() {
		return nominalCapacity;
	}

	//////////////////////
	// nominalFrequency //
	//////////////////////


	/**	 The entity nominalFrequency
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal nominalFrequency;

	/**	<br> The entity nominalFrequency
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:nominalFrequency">Find the entity nominalFrequency in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _nominalFrequency(Wrap<BigDecimal> w);

	public BigDecimal getNominalFrequency() {
		return nominalFrequency;
	}

	public void setNominalFrequency(BigDecimal nominalFrequency) {
		this.nominalFrequency = nominalFrequency;
	}
	@JsonIgnore
	public void setNominalFrequency(String o) {
		this.nominalFrequency = StorageBatteryDevice.staticSetNominalFrequency(siteRequest_, o);
	}
	public static BigDecimal staticSetNominalFrequency(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setNominalFrequency(Double o) {
		setNominalFrequency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalFrequency(Integer o) {
		setNominalFrequency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalFrequency(Number o) {
		setNominalFrequency(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice nominalFrequencyInit() {
		Wrap<BigDecimal> nominalFrequencyWrap = new Wrap<BigDecimal>().var("nominalFrequency");
		if(nominalFrequency == null) {
			_nominalFrequency(nominalFrequencyWrap);
			Optional.ofNullable(nominalFrequencyWrap.getO()).ifPresent(o -> {
				setNominalFrequency(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchNominalFrequency(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrNominalFrequency(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNominalFrequency(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchNominalFrequency(siteRequest_, StorageBatteryDevice.staticSetNominalFrequency(siteRequest_, o)).toString();
	}

	public BigDecimal sqlNominalFrequency() {
		return nominalFrequency;
	}

	////////////////////
	// nominalVoltage //
	////////////////////


	/**	 The entity nominalVoltage
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal nominalVoltage;

	/**	<br> The entity nominalVoltage
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:nominalVoltage">Find the entity nominalVoltage in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _nominalVoltage(Wrap<BigDecimal> w);

	public BigDecimal getNominalVoltage() {
		return nominalVoltage;
	}

	public void setNominalVoltage(BigDecimal nominalVoltage) {
		this.nominalVoltage = nominalVoltage;
	}
	@JsonIgnore
	public void setNominalVoltage(String o) {
		this.nominalVoltage = StorageBatteryDevice.staticSetNominalVoltage(siteRequest_, o);
	}
	public static BigDecimal staticSetNominalVoltage(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setNominalVoltage(Double o) {
		setNominalVoltage(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalVoltage(Integer o) {
		setNominalVoltage(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalVoltage(Number o) {
		setNominalVoltage(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice nominalVoltageInit() {
		Wrap<BigDecimal> nominalVoltageWrap = new Wrap<BigDecimal>().var("nominalVoltage");
		if(nominalVoltage == null) {
			_nominalVoltage(nominalVoltageWrap);
			Optional.ofNullable(nominalVoltageWrap.getO()).ifPresent(o -> {
				setNominalVoltage(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchNominalVoltage(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrNominalVoltage(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNominalVoltage(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchNominalVoltage(siteRequest_, StorageBatteryDevice.staticSetNominalVoltage(siteRequest_, o)).toString();
	}

	public BigDecimal sqlNominalVoltage() {
		return nominalVoltage;
	}

	///////////////////////
	// operatingAltitude //
	///////////////////////


	/**	 The entity operatingAltitude
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject operatingAltitude;

	/**	<br> The entity operatingAltitude
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:operatingAltitude">Find the entity operatingAltitude in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _operatingAltitude(Wrap<JsonObject> w);

	public JsonObject getOperatingAltitude() {
		return operatingAltitude;
	}

	public void setOperatingAltitude(JsonObject operatingAltitude) {
		this.operatingAltitude = operatingAltitude;
	}
	@JsonIgnore
	public void setOperatingAltitude(String o) {
		this.operatingAltitude = StorageBatteryDevice.staticSetOperatingAltitude(siteRequest_, o);
	}
	public static JsonObject staticSetOperatingAltitude(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice operatingAltitudeInit() {
		Wrap<JsonObject> operatingAltitudeWrap = new Wrap<JsonObject>().var("operatingAltitude");
		if(operatingAltitude == null) {
			_operatingAltitude(operatingAltitudeWrap);
			Optional.ofNullable(operatingAltitudeWrap.getO()).ifPresent(o -> {
				setOperatingAltitude(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOperatingAltitude(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOperatingAltitude(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOperatingAltitude(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOperatingAltitude(siteRequest_, StorageBatteryDevice.staticSetOperatingAltitude(siteRequest_, o)).toString();
	}

	public JsonObject sqlOperatingAltitude() {
		return operatingAltitude;
	}

	/////////////////////
	// operatingAmpere //
	/////////////////////


	/**	 The entity operatingAmpere
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject operatingAmpere;

	/**	<br> The entity operatingAmpere
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:operatingAmpere">Find the entity operatingAmpere in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _operatingAmpere(Wrap<JsonObject> w);

	public JsonObject getOperatingAmpere() {
		return operatingAmpere;
	}

	public void setOperatingAmpere(JsonObject operatingAmpere) {
		this.operatingAmpere = operatingAmpere;
	}
	@JsonIgnore
	public void setOperatingAmpere(String o) {
		this.operatingAmpere = StorageBatteryDevice.staticSetOperatingAmpere(siteRequest_, o);
	}
	public static JsonObject staticSetOperatingAmpere(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice operatingAmpereInit() {
		Wrap<JsonObject> operatingAmpereWrap = new Wrap<JsonObject>().var("operatingAmpere");
		if(operatingAmpere == null) {
			_operatingAmpere(operatingAmpereWrap);
			Optional.ofNullable(operatingAmpereWrap.getO()).ifPresent(o -> {
				setOperatingAmpere(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOperatingAmpere(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOperatingAmpere(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOperatingAmpere(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOperatingAmpere(siteRequest_, StorageBatteryDevice.staticSetOperatingAmpere(siteRequest_, o)).toString();
	}

	public JsonObject sqlOperatingAmpere() {
		return operatingAmpere;
	}

	////////////////////////
	// operatingFrequency //
	////////////////////////


	/**	 The entity operatingFrequency
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject operatingFrequency;

	/**	<br> The entity operatingFrequency
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:operatingFrequency">Find the entity operatingFrequency in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _operatingFrequency(Wrap<JsonObject> w);

	public JsonObject getOperatingFrequency() {
		return operatingFrequency;
	}

	public void setOperatingFrequency(JsonObject operatingFrequency) {
		this.operatingFrequency = operatingFrequency;
	}
	@JsonIgnore
	public void setOperatingFrequency(String o) {
		this.operatingFrequency = StorageBatteryDevice.staticSetOperatingFrequency(siteRequest_, o);
	}
	public static JsonObject staticSetOperatingFrequency(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice operatingFrequencyInit() {
		Wrap<JsonObject> operatingFrequencyWrap = new Wrap<JsonObject>().var("operatingFrequency");
		if(operatingFrequency == null) {
			_operatingFrequency(operatingFrequencyWrap);
			Optional.ofNullable(operatingFrequencyWrap.getO()).ifPresent(o -> {
				setOperatingFrequency(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOperatingFrequency(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOperatingFrequency(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOperatingFrequency(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOperatingFrequency(siteRequest_, StorageBatteryDevice.staticSetOperatingFrequency(siteRequest_, o)).toString();
	}

	public JsonObject sqlOperatingFrequency() {
		return operatingFrequency;
	}

	//////////////////////////
	// operatingTemperature //
	//////////////////////////


	/**	 The entity operatingTemperature
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject operatingTemperature;

	/**	<br> The entity operatingTemperature
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:operatingTemperature">Find the entity operatingTemperature in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _operatingTemperature(Wrap<JsonObject> w);

	public JsonObject getOperatingTemperature() {
		return operatingTemperature;
	}

	public void setOperatingTemperature(JsonObject operatingTemperature) {
		this.operatingTemperature = operatingTemperature;
	}
	@JsonIgnore
	public void setOperatingTemperature(String o) {
		this.operatingTemperature = StorageBatteryDevice.staticSetOperatingTemperature(siteRequest_, o);
	}
	public static JsonObject staticSetOperatingTemperature(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice operatingTemperatureInit() {
		Wrap<JsonObject> operatingTemperatureWrap = new Wrap<JsonObject>().var("operatingTemperature");
		if(operatingTemperature == null) {
			_operatingTemperature(operatingTemperatureWrap);
			Optional.ofNullable(operatingTemperatureWrap.getO()).ifPresent(o -> {
				setOperatingTemperature(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOperatingTemperature(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOperatingTemperature(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOperatingTemperature(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOperatingTemperature(siteRequest_, StorageBatteryDevice.staticSetOperatingTemperature(siteRequest_, o)).toString();
	}

	public JsonObject sqlOperatingTemperature() {
		return operatingTemperature;
	}

	//////////////////////
	// operatingVoltage //
	//////////////////////


	/**	 The entity operatingVoltage
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject operatingVoltage;

	/**	<br> The entity operatingVoltage
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:operatingVoltage">Find the entity operatingVoltage in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _operatingVoltage(Wrap<JsonObject> w);

	public JsonObject getOperatingVoltage() {
		return operatingVoltage;
	}

	public void setOperatingVoltage(JsonObject operatingVoltage) {
		this.operatingVoltage = operatingVoltage;
	}
	@JsonIgnore
	public void setOperatingVoltage(String o) {
		this.operatingVoltage = StorageBatteryDevice.staticSetOperatingVoltage(siteRequest_, o);
	}
	public static JsonObject staticSetOperatingVoltage(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice operatingVoltageInit() {
		Wrap<JsonObject> operatingVoltageWrap = new Wrap<JsonObject>().var("operatingVoltage");
		if(operatingVoltage == null) {
			_operatingVoltage(operatingVoltageWrap);
			Optional.ofNullable(operatingVoltageWrap.getO()).ifPresent(o -> {
				setOperatingVoltage(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOperatingVoltage(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOperatingVoltage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOperatingVoltage(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOperatingVoltage(siteRequest_, StorageBatteryDevice.staticSetOperatingVoltage(siteRequest_, o)).toString();
	}

	public JsonObject sqlOperatingVoltage() {
		return operatingVoltage;
	}

	//////////////////////
	// overloadAccepted //
	//////////////////////


	/**	 The entity overloadAccepted
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean overloadAccepted;

	/**	<br> The entity overloadAccepted
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:overloadAccepted">Find the entity overloadAccepted in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _overloadAccepted(Wrap<Boolean> w);

	public Boolean getOverloadAccepted() {
		return overloadAccepted;
	}

	public void setOverloadAccepted(Boolean overloadAccepted) {
		this.overloadAccepted = overloadAccepted;
	}
	@JsonIgnore
	public void setOverloadAccepted(String o) {
		this.overloadAccepted = StorageBatteryDevice.staticSetOverloadAccepted(siteRequest_, o);
	}
	public static Boolean staticSetOverloadAccepted(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected StorageBatteryDevice overloadAcceptedInit() {
		Wrap<Boolean> overloadAcceptedWrap = new Wrap<Boolean>().var("overloadAccepted");
		if(overloadAccepted == null) {
			_overloadAccepted(overloadAcceptedWrap);
			Optional.ofNullable(overloadAcceptedWrap.getO()).ifPresent(o -> {
				setOverloadAccepted(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Boolean staticSearchOverloadAccepted(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrOverloadAccepted(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOverloadAccepted(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOverloadAccepted(siteRequest_, StorageBatteryDevice.staticSetOverloadAccepted(siteRequest_, o)).toString();
	}

	public Boolean sqlOverloadAccepted() {
		return overloadAccepted;
	}

	//////////////////////////
	// overloadAcceptedTime //
	//////////////////////////


	/**	 The entity overloadAcceptedTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String overloadAcceptedTime;

	/**	<br> The entity overloadAcceptedTime
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:overloadAcceptedTime">Find the entity overloadAcceptedTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _overloadAcceptedTime(Wrap<String> w);

	public String getOverloadAcceptedTime() {
		return overloadAcceptedTime;
	}
	public void setOverloadAcceptedTime(String o) {
		this.overloadAcceptedTime = StorageBatteryDevice.staticSetOverloadAcceptedTime(siteRequest_, o);
	}
	public static String staticSetOverloadAcceptedTime(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice overloadAcceptedTimeInit() {
		Wrap<String> overloadAcceptedTimeWrap = new Wrap<String>().var("overloadAcceptedTime");
		if(overloadAcceptedTime == null) {
			_overloadAcceptedTime(overloadAcceptedTimeWrap);
			Optional.ofNullable(overloadAcceptedTimeWrap.getO()).ifPresent(o -> {
				setOverloadAcceptedTime(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOverloadAcceptedTime(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOverloadAcceptedTime(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOverloadAcceptedTime(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOverloadAcceptedTime(siteRequest_, StorageBatteryDevice.staticSetOverloadAcceptedTime(siteRequest_, o)).toString();
	}

	public String sqlOverloadAcceptedTime() {
		return overloadAcceptedTime;
	}

	///////////
	// owner //
	///////////


	/**	 The entity owner
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject owner;

	/**	<br> The entity owner
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _owner(Wrap<JsonObject> w);

	public JsonObject getOwner() {
		return owner;
	}

	public void setOwner(JsonObject owner) {
		this.owner = owner;
	}
	@JsonIgnore
	public void setOwner(String o) {
		this.owner = StorageBatteryDevice.staticSetOwner(siteRequest_, o);
	}
	public static JsonObject staticSetOwner(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice ownerInit() {
		Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
		if(owner == null) {
			_owner(ownerWrap);
			Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
				setOwner(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchOwner(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOwner(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOwner(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchOwner(siteRequest_, StorageBatteryDevice.staticSetOwner(siteRequest_, o)).toString();
	}

	public JsonObject sqlOwner() {
		return owner;
	}

	///////////////
	// peakPower //
	///////////////


	/**	 The entity peakPower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal peakPower;

	/**	<br> The entity peakPower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:peakPower">Find the entity peakPower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _peakPower(Wrap<BigDecimal> w);

	public BigDecimal getPeakPower() {
		return peakPower;
	}

	public void setPeakPower(BigDecimal peakPower) {
		this.peakPower = peakPower;
	}
	@JsonIgnore
	public void setPeakPower(String o) {
		this.peakPower = StorageBatteryDevice.staticSetPeakPower(siteRequest_, o);
	}
	public static BigDecimal staticSetPeakPower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setPeakPower(Double o) {
		setPeakPower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setPeakPower(Integer o) {
		setPeakPower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setPeakPower(Number o) {
		setPeakPower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice peakPowerInit() {
		Wrap<BigDecimal> peakPowerWrap = new Wrap<BigDecimal>().var("peakPower");
		if(peakPower == null) {
			_peakPower(peakPowerWrap);
			Optional.ofNullable(peakPowerWrap.getO()).ifPresent(o -> {
				setPeakPower(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchPeakPower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrPeakPower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPeakPower(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchPeakPower(siteRequest_, StorageBatteryDevice.staticSetPeakPower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlPeakPower() {
		return peakPower;
	}

	//////////////////////
	// possibilityOfUse //
	//////////////////////


	/**	 The entity possibilityOfUse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String possibilityOfUse;

	/**	<br> The entity possibilityOfUse
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:possibilityOfUse">Find the entity possibilityOfUse in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _possibilityOfUse(Wrap<String> w);

	public String getPossibilityOfUse() {
		return possibilityOfUse;
	}
	public void setPossibilityOfUse(String o) {
		this.possibilityOfUse = StorageBatteryDevice.staticSetPossibilityOfUse(siteRequest_, o);
	}
	public static String staticSetPossibilityOfUse(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice possibilityOfUseInit() {
		Wrap<String> possibilityOfUseWrap = new Wrap<String>().var("possibilityOfUse");
		if(possibilityOfUse == null) {
			_possibilityOfUse(possibilityOfUseWrap);
			Optional.ofNullable(possibilityOfUseWrap.getO()).ifPresent(o -> {
				setPossibilityOfUse(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchPossibilityOfUse(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPossibilityOfUse(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPossibilityOfUse(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchPossibilityOfUse(siteRequest_, StorageBatteryDevice.staticSetPossibilityOfUse(siteRequest_, o)).toString();
	}

	public String sqlPossibilityOfUse() {
		return possibilityOfUse;
	}

	//////////////////
	// protectionIK //
	//////////////////


	/**	 The entity protectionIK
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal protectionIK;

	/**	<br> The entity protectionIK
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:protectionIK">Find the entity protectionIK in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _protectionIK(Wrap<BigDecimal> w);

	public BigDecimal getProtectionIK() {
		return protectionIK;
	}

	public void setProtectionIK(BigDecimal protectionIK) {
		this.protectionIK = protectionIK;
	}
	@JsonIgnore
	public void setProtectionIK(String o) {
		this.protectionIK = StorageBatteryDevice.staticSetProtectionIK(siteRequest_, o);
	}
	public static BigDecimal staticSetProtectionIK(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setProtectionIK(Double o) {
		setProtectionIK(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setProtectionIK(Integer o) {
		setProtectionIK(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setProtectionIK(Number o) {
		setProtectionIK(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice protectionIKInit() {
		Wrap<BigDecimal> protectionIKWrap = new Wrap<BigDecimal>().var("protectionIK");
		if(protectionIK == null) {
			_protectionIK(protectionIKWrap);
			Optional.ofNullable(protectionIKWrap.getO()).ifPresent(o -> {
				setProtectionIK(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchProtectionIK(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrProtectionIK(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqProtectionIK(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchProtectionIK(siteRequest_, StorageBatteryDevice.staticSetProtectionIK(siteRequest_, o)).toString();
	}

	public BigDecimal sqlProtectionIK() {
		return protectionIK;
	}

	//////////////////
	// protectionIP //
	//////////////////


	/**	 The entity protectionIP
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String protectionIP;

	/**	<br> The entity protectionIP
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:protectionIP">Find the entity protectionIP in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _protectionIP(Wrap<String> w);

	public String getProtectionIP() {
		return protectionIP;
	}
	public void setProtectionIP(String o) {
		this.protectionIP = StorageBatteryDevice.staticSetProtectionIP(siteRequest_, o);
	}
	public static String staticSetProtectionIP(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice protectionIPInit() {
		Wrap<String> protectionIPWrap = new Wrap<String>().var("protectionIP");
		if(protectionIP == null) {
			_protectionIP(protectionIPWrap);
			Optional.ofNullable(protectionIPWrap.getO()).ifPresent(o -> {
				setProtectionIP(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchProtectionIP(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrProtectionIP(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqProtectionIP(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchProtectionIP(siteRequest_, StorageBatteryDevice.staticSetProtectionIP(siteRequest_, o)).toString();
	}

	public String sqlProtectionIP() {
		return protectionIP;
	}

	//////////////////////////
	// rechargeEnergySource //
	//////////////////////////


	/**	 The entity rechargeEnergySource
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String rechargeEnergySource;

	/**	<br> The entity rechargeEnergySource
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:rechargeEnergySource">Find the entity rechargeEnergySource in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _rechargeEnergySource(Wrap<String> w);

	public String getRechargeEnergySource() {
		return rechargeEnergySource;
	}
	public void setRechargeEnergySource(String o) {
		this.rechargeEnergySource = StorageBatteryDevice.staticSetRechargeEnergySource(siteRequest_, o);
	}
	public static String staticSetRechargeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice rechargeEnergySourceInit() {
		Wrap<String> rechargeEnergySourceWrap = new Wrap<String>().var("rechargeEnergySource");
		if(rechargeEnergySource == null) {
			_rechargeEnergySource(rechargeEnergySourceWrap);
			Optional.ofNullable(rechargeEnergySourceWrap.getO()).ifPresent(o -> {
				setRechargeEnergySource(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchRechargeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRechargeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRechargeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchRechargeEnergySource(siteRequest_, StorageBatteryDevice.staticSetRechargeEnergySource(siteRequest_, o)).toString();
	}

	public String sqlRechargeEnergySource() {
		return rechargeEnergySource;
	}

	///////////////
	// refDevice //
	///////////////


	/**	 The entity refDevice
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject refDevice;

	/**	<br> The entity refDevice
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:refDevice">Find the entity refDevice in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _refDevice(Wrap<JsonObject> w);

	public JsonObject getRefDevice() {
		return refDevice;
	}

	public void setRefDevice(JsonObject refDevice) {
		this.refDevice = refDevice;
	}
	@JsonIgnore
	public void setRefDevice(String o) {
		this.refDevice = StorageBatteryDevice.staticSetRefDevice(siteRequest_, o);
	}
	public static JsonObject staticSetRefDevice(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice refDeviceInit() {
		Wrap<JsonObject> refDeviceWrap = new Wrap<JsonObject>().var("refDevice");
		if(refDevice == null) {
			_refDevice(refDeviceWrap);
			Optional.ofNullable(refDeviceWrap.getO()).ifPresent(o -> {
				setRefDevice(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchRefDevice(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrRefDevice(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefDevice(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchRefDevice(siteRequest_, StorageBatteryDevice.staticSetRefDevice(siteRequest_, o)).toString();
	}

	public JsonObject sqlRefDevice() {
		return refDevice;
	}

	////////////////////////
	// refPointOfInterest //
	////////////////////////


	/**	 The entity refPointOfInterest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject refPointOfInterest;

	/**	<br> The entity refPointOfInterest
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:refPointOfInterest">Find the entity refPointOfInterest in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _refPointOfInterest(Wrap<JsonObject> w);

	public JsonObject getRefPointOfInterest() {
		return refPointOfInterest;
	}

	public void setRefPointOfInterest(JsonObject refPointOfInterest) {
		this.refPointOfInterest = refPointOfInterest;
	}
	@JsonIgnore
	public void setRefPointOfInterest(String o) {
		this.refPointOfInterest = StorageBatteryDevice.staticSetRefPointOfInterest(siteRequest_, o);
	}
	public static JsonObject staticSetRefPointOfInterest(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice refPointOfInterestInit() {
		Wrap<JsonObject> refPointOfInterestWrap = new Wrap<JsonObject>().var("refPointOfInterest");
		if(refPointOfInterest == null) {
			_refPointOfInterest(refPointOfInterestWrap);
			Optional.ofNullable(refPointOfInterestWrap.getO()).ifPresent(o -> {
				setRefPointOfInterest(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchRefPointOfInterest(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrRefPointOfInterest(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefPointOfInterest(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchRefPointOfInterest(siteRequest_, StorageBatteryDevice.staticSetRefPointOfInterest(siteRequest_, o)).toString();
	}

	public JsonObject sqlRefPointOfInterest() {
		return refPointOfInterest;
	}

	/////////////////////////
	// roundTripEfficiency //
	/////////////////////////


	/**	 The entity roundTripEfficiency
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal roundTripEfficiency;

	/**	<br> The entity roundTripEfficiency
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:roundTripEfficiency">Find the entity roundTripEfficiency in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _roundTripEfficiency(Wrap<BigDecimal> w);

	public BigDecimal getRoundTripEfficiency() {
		return roundTripEfficiency;
	}

	public void setRoundTripEfficiency(BigDecimal roundTripEfficiency) {
		this.roundTripEfficiency = roundTripEfficiency;
	}
	@JsonIgnore
	public void setRoundTripEfficiency(String o) {
		this.roundTripEfficiency = StorageBatteryDevice.staticSetRoundTripEfficiency(siteRequest_, o);
	}
	public static BigDecimal staticSetRoundTripEfficiency(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setRoundTripEfficiency(Double o) {
		setRoundTripEfficiency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setRoundTripEfficiency(Integer o) {
		setRoundTripEfficiency(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setRoundTripEfficiency(Number o) {
		setRoundTripEfficiency(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice roundTripEfficiencyInit() {
		Wrap<BigDecimal> roundTripEfficiencyWrap = new Wrap<BigDecimal>().var("roundTripEfficiency");
		if(roundTripEfficiency == null) {
			_roundTripEfficiency(roundTripEfficiencyWrap);
			Optional.ofNullable(roundTripEfficiencyWrap.getO()).ifPresent(o -> {
				setRoundTripEfficiency(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchRoundTripEfficiency(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrRoundTripEfficiency(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRoundTripEfficiency(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchRoundTripEfficiency(siteRequest_, StorageBatteryDevice.staticSetRoundTripEfficiency(siteRequest_, o)).toString();
	}

	public BigDecimal sqlRoundTripEfficiency() {
		return roundTripEfficiency;
	}

	/////////////
	// seeAlso //
	/////////////


	/**	 The entity seeAlso
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject seeAlso;

	/**	<br> The entity seeAlso
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeAlso(Wrap<JsonObject> w);

	public JsonObject getSeeAlso() {
		return seeAlso;
	}

	public void setSeeAlso(JsonObject seeAlso) {
		this.seeAlso = seeAlso;
	}
	@JsonIgnore
	public void setSeeAlso(String o) {
		this.seeAlso = StorageBatteryDevice.staticSetSeeAlso(siteRequest_, o);
	}
	public static JsonObject staticSetSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice seeAlsoInit() {
		Wrap<JsonObject> seeAlsoWrap = new Wrap<JsonObject>().var("seeAlso");
		if(seeAlso == null) {
			_seeAlso(seeAlsoWrap);
			Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
				setSeeAlso(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchSeeAlso(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchSeeAlso(siteRequest_, StorageBatteryDevice.staticSetSeeAlso(siteRequest_, o)).toString();
	}

	public JsonObject sqlSeeAlso() {
		return seeAlso;
	}

	///////////////////////
	// selfDischargeRate //
	///////////////////////


	/**	 The entity selfDischargeRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal selfDischargeRate;

	/**	<br> The entity selfDischargeRate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:selfDischargeRate">Find the entity selfDischargeRate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _selfDischargeRate(Wrap<BigDecimal> w);

	public BigDecimal getSelfDischargeRate() {
		return selfDischargeRate;
	}

	public void setSelfDischargeRate(BigDecimal selfDischargeRate) {
		this.selfDischargeRate = selfDischargeRate;
	}
	@JsonIgnore
	public void setSelfDischargeRate(String o) {
		this.selfDischargeRate = StorageBatteryDevice.staticSetSelfDischargeRate(siteRequest_, o);
	}
	public static BigDecimal staticSetSelfDischargeRate(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setSelfDischargeRate(Double o) {
		setSelfDischargeRate(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setSelfDischargeRate(Integer o) {
		setSelfDischargeRate(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setSelfDischargeRate(Number o) {
		setSelfDischargeRate(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice selfDischargeRateInit() {
		Wrap<BigDecimal> selfDischargeRateWrap = new Wrap<BigDecimal>().var("selfDischargeRate");
		if(selfDischargeRate == null) {
			_selfDischargeRate(selfDischargeRateWrap);
			Optional.ofNullable(selfDischargeRateWrap.getO()).ifPresent(o -> {
				setSelfDischargeRate(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchSelfDischargeRate(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrSelfDischargeRate(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSelfDischargeRate(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchSelfDischargeRate(siteRequest_, StorageBatteryDevice.staticSetSelfDischargeRate(siteRequest_, o)).toString();
	}

	public BigDecimal sqlSelfDischargeRate() {
		return selfDischargeRate;
	}

	//////////////////
	// serialNumber //
	//////////////////


	/**	 The entity serialNumber
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String serialNumber;

	/**	<br> The entity serialNumber
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:serialNumber">Find the entity serialNumber in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _serialNumber(Wrap<String> w);

	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String o) {
		this.serialNumber = StorageBatteryDevice.staticSetSerialNumber(siteRequest_, o);
	}
	public static String staticSetSerialNumber(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice serialNumberInit() {
		Wrap<String> serialNumberWrap = new Wrap<String>().var("serialNumber");
		if(serialNumber == null) {
			_serialNumber(serialNumberWrap);
			Optional.ofNullable(serialNumberWrap.getO()).ifPresent(o -> {
				setSerialNumber(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchSerialNumber(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSerialNumber(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSerialNumber(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchSerialNumber(siteRequest_, StorageBatteryDevice.staticSetSerialNumber(siteRequest_, o)).toString();
	}

	public String sqlSerialNumber() {
		return serialNumber;
	}

	////////////
	// source //
	////////////


	/**	 The entity source
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String source;

	/**	<br> The entity source
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = StorageBatteryDevice.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
				setSource(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchSource(siteRequest_, StorageBatteryDevice.staticSetSource(siteRequest_, o)).toString();
	}

	public String sqlSource() {
		return source;
	}

	////////////////////
	// storableEnergy //
	////////////////////


	/**	 The entity storableEnergy
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal storableEnergy;

	/**	<br> The entity storableEnergy
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:storableEnergy">Find the entity storableEnergy in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _storableEnergy(Wrap<BigDecimal> w);

	public BigDecimal getStorableEnergy() {
		return storableEnergy;
	}

	public void setStorableEnergy(BigDecimal storableEnergy) {
		this.storableEnergy = storableEnergy;
	}
	@JsonIgnore
	public void setStorableEnergy(String o) {
		this.storableEnergy = StorageBatteryDevice.staticSetStorableEnergy(siteRequest_, o);
	}
	public static BigDecimal staticSetStorableEnergy(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setStorableEnergy(Double o) {
		setStorableEnergy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setStorableEnergy(Integer o) {
		setStorableEnergy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setStorableEnergy(Number o) {
		setStorableEnergy(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice storableEnergyInit() {
		Wrap<BigDecimal> storableEnergyWrap = new Wrap<BigDecimal>().var("storableEnergy");
		if(storableEnergy == null) {
			_storableEnergy(storableEnergyWrap);
			Optional.ofNullable(storableEnergyWrap.getO()).ifPresent(o -> {
				setStorableEnergy(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchStorableEnergy(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrStorableEnergy(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStorableEnergy(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchStorableEnergy(siteRequest_, StorageBatteryDevice.staticSetStorableEnergy(siteRequest_, o)).toString();
	}

	public BigDecimal sqlStorableEnergy() {
		return storableEnergy;
	}

	/////////////
	// toolBMS //
	/////////////


	/**	 The entity toolBMS
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean toolBMS;

	/**	<br> The entity toolBMS
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:toolBMS">Find the entity toolBMS in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _toolBMS(Wrap<Boolean> w);

	public Boolean getToolBMS() {
		return toolBMS;
	}

	public void setToolBMS(Boolean toolBMS) {
		this.toolBMS = toolBMS;
	}
	@JsonIgnore
	public void setToolBMS(String o) {
		this.toolBMS = StorageBatteryDevice.staticSetToolBMS(siteRequest_, o);
	}
	public static Boolean staticSetToolBMS(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected StorageBatteryDevice toolBMSInit() {
		Wrap<Boolean> toolBMSWrap = new Wrap<Boolean>().var("toolBMS");
		if(toolBMS == null) {
			_toolBMS(toolBMSWrap);
			Optional.ofNullable(toolBMSWrap.getO()).ifPresent(o -> {
				setToolBMS(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Boolean staticSearchToolBMS(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrToolBMS(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqToolBMS(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchToolBMS(siteRequest_, StorageBatteryDevice.staticSetToolBMS(siteRequest_, o)).toString();
	}

	public Boolean sqlToolBMS() {
		return toolBMS;
	}

	//////////////////////
	// typeEnergySource //
	//////////////////////


	/**	 The entity typeEnergySource
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject typeEnergySource;

	/**	<br> The entity typeEnergySource
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:typeEnergySource">Find the entity typeEnergySource in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _typeEnergySource(Wrap<JsonObject> w);

	public JsonObject getTypeEnergySource() {
		return typeEnergySource;
	}

	public void setTypeEnergySource(JsonObject typeEnergySource) {
		this.typeEnergySource = typeEnergySource;
	}
	@JsonIgnore
	public void setTypeEnergySource(String o) {
		this.typeEnergySource = StorageBatteryDevice.staticSetTypeEnergySource(siteRequest_, o);
	}
	public static JsonObject staticSetTypeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice typeEnergySourceInit() {
		Wrap<JsonObject> typeEnergySourceWrap = new Wrap<JsonObject>().var("typeEnergySource");
		if(typeEnergySource == null) {
			_typeEnergySource(typeEnergySourceWrap);
			Optional.ofNullable(typeEnergySourceWrap.getO()).ifPresent(o -> {
				setTypeEnergySource(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchTypeEnergySource(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrTypeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTypeEnergySource(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchTypeEnergySource(siteRequest_, StorageBatteryDevice.staticSetTypeEnergySource(siteRequest_, o)).toString();
	}

	public JsonObject sqlTypeEnergySource() {
		return typeEnergySource;
	}

	///////////////
	// typeOfUse //
	///////////////


	/**	 The entity typeOfUse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String typeOfUse;

	/**	<br> The entity typeOfUse
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:typeOfUse">Find the entity typeOfUse in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _typeOfUse(Wrap<String> w);

	public String getTypeOfUse() {
		return typeOfUse;
	}
	public void setTypeOfUse(String o) {
		this.typeOfUse = StorageBatteryDevice.staticSetTypeOfUse(siteRequest_, o);
	}
	public static String staticSetTypeOfUse(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDevice typeOfUseInit() {
		Wrap<String> typeOfUseWrap = new Wrap<String>().var("typeOfUse");
		if(typeOfUse == null) {
			_typeOfUse(typeOfUseWrap);
			Optional.ofNullable(typeOfUseWrap.getO()).ifPresent(o -> {
				setTypeOfUse(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchTypeOfUse(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTypeOfUse(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTypeOfUse(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchTypeOfUse(siteRequest_, StorageBatteryDevice.staticSetTypeOfUse(siteRequest_, o)).toString();
	}

	public String sqlTypeOfUse() {
		return typeOfUse;
	}

	//////////////////
	// usableEnergy //
	//////////////////


	/**	 The entity usableEnergy
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal usableEnergy;

	/**	<br> The entity usableEnergy
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:usableEnergy">Find the entity usableEnergy in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _usableEnergy(Wrap<BigDecimal> w);

	public BigDecimal getUsableEnergy() {
		return usableEnergy;
	}

	public void setUsableEnergy(BigDecimal usableEnergy) {
		this.usableEnergy = usableEnergy;
	}
	@JsonIgnore
	public void setUsableEnergy(String o) {
		this.usableEnergy = StorageBatteryDevice.staticSetUsableEnergy(siteRequest_, o);
	}
	public static BigDecimal staticSetUsableEnergy(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setUsableEnergy(Double o) {
		setUsableEnergy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setUsableEnergy(Integer o) {
		setUsableEnergy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setUsableEnergy(Number o) {
		setUsableEnergy(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice usableEnergyInit() {
		Wrap<BigDecimal> usableEnergyWrap = new Wrap<BigDecimal>().var("usableEnergy");
		if(usableEnergy == null) {
			_usableEnergy(usableEnergyWrap);
			Optional.ofNullable(usableEnergyWrap.getO()).ifPresent(o -> {
				setUsableEnergy(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchUsableEnergy(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrUsableEnergy(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUsableEnergy(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchUsableEnergy(siteRequest_, StorageBatteryDevice.staticSetUsableEnergy(siteRequest_, o)).toString();
	}

	public BigDecimal sqlUsableEnergy() {
		return usableEnergy;
	}

	//////////////////////
	// volEnergyDensity //
	//////////////////////


	/**	 The entity volEnergyDensity
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject volEnergyDensity;

	/**	<br> The entity volEnergyDensity
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:volEnergyDensity">Find the entity volEnergyDensity in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _volEnergyDensity(Wrap<JsonObject> w);

	public JsonObject getVolEnergyDensity() {
		return volEnergyDensity;
	}

	public void setVolEnergyDensity(JsonObject volEnergyDensity) {
		this.volEnergyDensity = volEnergyDensity;
	}
	@JsonIgnore
	public void setVolEnergyDensity(String o) {
		this.volEnergyDensity = StorageBatteryDevice.staticSetVolEnergyDensity(siteRequest_, o);
	}
	public static JsonObject staticSetVolEnergyDensity(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected StorageBatteryDevice volEnergyDensityInit() {
		Wrap<JsonObject> volEnergyDensityWrap = new Wrap<JsonObject>().var("volEnergyDensity");
		if(volEnergyDensity == null) {
			_volEnergyDensity(volEnergyDensityWrap);
			Optional.ofNullable(volEnergyDensityWrap.getO()).ifPresent(o -> {
				setVolEnergyDensity(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static String staticSearchVolEnergyDensity(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrVolEnergyDensity(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVolEnergyDensity(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchVolEnergyDensity(siteRequest_, StorageBatteryDevice.staticSetVolEnergyDensity(siteRequest_, o)).toString();
	}

	public JsonObject sqlVolEnergyDensity() {
		return volEnergyDensity;
	}

	////////////
	// weight //
	////////////


	/**	 The entity weight
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal weight;

	/**	<br> The entity weight
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice&fq=entiteVar_enUS_indexed_string:weight">Find the entity weight in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _weight(Wrap<BigDecimal> w);

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	@JsonIgnore
	public void setWeight(String o) {
		this.weight = StorageBatteryDevice.staticSetWeight(siteRequest_, o);
	}
	public static BigDecimal staticSetWeight(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setWeight(Double o) {
		setWeight(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setWeight(Integer o) {
		setWeight(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setWeight(Number o) {
		setWeight(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected StorageBatteryDevice weightInit() {
		Wrap<BigDecimal> weightWrap = new Wrap<BigDecimal>().var("weight");
		if(weight == null) {
			_weight(weightWrap);
			Optional.ofNullable(weightWrap.getO()).ifPresent(o -> {
				setWeight(o);
			});
		}
		return (StorageBatteryDevice)this;
	}

	public static Double staticSearchWeight(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrWeight(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqWeight(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDevice.staticSearchWeight(siteRequest_, StorageBatteryDevice.staticSetWeight(siteRequest_, o)).toString();
	}

	public BigDecimal sqlWeight() {
		return weight;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepStorageBatteryDevice(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepStorageBatteryDevice();
	}

	public Future<Void> promiseDeepStorageBatteryDevice() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseStorageBatteryDevice(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseStorageBatteryDevice(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				addressInit();
				alternateNameInit();
				applicationInit();
				areaServedColorsInit();
				areaServedTitlesInit();
				areaServedLinksInit();
				areaServedInit();
				averageLifeInit();
				batteryAssessmentMethodsInit();
				batteryTypeInit();
				brandNameInit();
				capacityCnnnInit();
				chargeDischargeReactivityInit();
				chargeEfficiencyInit();
				chargePowerInit();
				chargingModeAllowedInit();
				communicationInit();
				dataProviderInit();
				dateCreatedInit();
				dateLastReportedInit();
				dateModifiedInit();
				descriptionInit();
				dimensionInit();
				dischargeEfficiencyInit();
				dischargePowerInit();
				documentationInit();
				durationPeakPowerInit();
				installationConditionInit();
				installationModeInit();
				lifeCycleNumberInit();
				locationInit();
				manufacturerNameInit();
				massEnergyDensityInit();
				maxOutputPowerInit();
				maximumVoltageEOCInit();
				minimumVoltageEODInit();
				modelNameInit();
				nameInit();
				nominalAmpereInit();
				nominalCapacityInit();
				nominalFrequencyInit();
				nominalVoltageInit();
				operatingAltitudeInit();
				operatingAmpereInit();
				operatingFrequencyInit();
				operatingTemperatureInit();
				operatingVoltageInit();
				overloadAcceptedInit();
				overloadAcceptedTimeInit();
				ownerInit();
				peakPowerInit();
				possibilityOfUseInit();
				protectionIKInit();
				protectionIPInit();
				rechargeEnergySourceInit();
				refDeviceInit();
				refPointOfInterestInit();
				roundTripEfficiencyInit();
				seeAlsoInit();
				selfDischargeRateInit();
				serialNumberInit();
				sourceInit();
				storableEnergyInit();
				toolBMSInit();
				typeEnergySourceInit();
				typeOfUseInit();
				usableEnergyInit();
				volEnergyDensityInit();
				weightInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepStorageBatteryDevice(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestStorageBatteryDevice(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestStorageBatteryDevice(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainStorageBatteryDevice(v);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.obtainForClass(v);
			}
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainStorageBatteryDevice(String var) {
		StorageBatteryDevice oStorageBatteryDevice = (StorageBatteryDevice)this;
		switch(var) {
			case "address":
				return oStorageBatteryDevice.address;
			case "alternateName":
				return oStorageBatteryDevice.alternateName;
			case "application":
				return oStorageBatteryDevice.application;
			case "areaServedColors":
				return oStorageBatteryDevice.areaServedColors;
			case "areaServedTitles":
				return oStorageBatteryDevice.areaServedTitles;
			case "areaServedLinks":
				return oStorageBatteryDevice.areaServedLinks;
			case "areaServed":
				return oStorageBatteryDevice.areaServed;
			case "averageLife":
				return oStorageBatteryDevice.averageLife;
			case "batteryAssessmentMethods":
				return oStorageBatteryDevice.batteryAssessmentMethods;
			case "batteryType":
				return oStorageBatteryDevice.batteryType;
			case "brandName":
				return oStorageBatteryDevice.brandName;
			case "capacityCnnn":
				return oStorageBatteryDevice.capacityCnnn;
			case "chargeDischargeReactivity":
				return oStorageBatteryDevice.chargeDischargeReactivity;
			case "chargeEfficiency":
				return oStorageBatteryDevice.chargeEfficiency;
			case "chargePower":
				return oStorageBatteryDevice.chargePower;
			case "chargingModeAllowed":
				return oStorageBatteryDevice.chargingModeAllowed;
			case "communication":
				return oStorageBatteryDevice.communication;
			case "dataProvider":
				return oStorageBatteryDevice.dataProvider;
			case "dateCreated":
				return oStorageBatteryDevice.dateCreated;
			case "dateLastReported":
				return oStorageBatteryDevice.dateLastReported;
			case "dateModified":
				return oStorageBatteryDevice.dateModified;
			case "description":
				return oStorageBatteryDevice.description;
			case "dimension":
				return oStorageBatteryDevice.dimension;
			case "dischargeEfficiency":
				return oStorageBatteryDevice.dischargeEfficiency;
			case "dischargePower":
				return oStorageBatteryDevice.dischargePower;
			case "documentation":
				return oStorageBatteryDevice.documentation;
			case "durationPeakPower":
				return oStorageBatteryDevice.durationPeakPower;
			case "installationCondition":
				return oStorageBatteryDevice.installationCondition;
			case "installationMode":
				return oStorageBatteryDevice.installationMode;
			case "lifeCycleNumber":
				return oStorageBatteryDevice.lifeCycleNumber;
			case "location":
				return oStorageBatteryDevice.location;
			case "manufacturerName":
				return oStorageBatteryDevice.manufacturerName;
			case "massEnergyDensity":
				return oStorageBatteryDevice.massEnergyDensity;
			case "maxOutputPower":
				return oStorageBatteryDevice.maxOutputPower;
			case "maximumVoltageEOC":
				return oStorageBatteryDevice.maximumVoltageEOC;
			case "minimumVoltageEOD":
				return oStorageBatteryDevice.minimumVoltageEOD;
			case "modelName":
				return oStorageBatteryDevice.modelName;
			case "name":
				return oStorageBatteryDevice.name;
			case "nominalAmpere":
				return oStorageBatteryDevice.nominalAmpere;
			case "nominalCapacity":
				return oStorageBatteryDevice.nominalCapacity;
			case "nominalFrequency":
				return oStorageBatteryDevice.nominalFrequency;
			case "nominalVoltage":
				return oStorageBatteryDevice.nominalVoltage;
			case "operatingAltitude":
				return oStorageBatteryDevice.operatingAltitude;
			case "operatingAmpere":
				return oStorageBatteryDevice.operatingAmpere;
			case "operatingFrequency":
				return oStorageBatteryDevice.operatingFrequency;
			case "operatingTemperature":
				return oStorageBatteryDevice.operatingTemperature;
			case "operatingVoltage":
				return oStorageBatteryDevice.operatingVoltage;
			case "overloadAccepted":
				return oStorageBatteryDevice.overloadAccepted;
			case "overloadAcceptedTime":
				return oStorageBatteryDevice.overloadAcceptedTime;
			case "owner":
				return oStorageBatteryDevice.owner;
			case "peakPower":
				return oStorageBatteryDevice.peakPower;
			case "possibilityOfUse":
				return oStorageBatteryDevice.possibilityOfUse;
			case "protectionIK":
				return oStorageBatteryDevice.protectionIK;
			case "protectionIP":
				return oStorageBatteryDevice.protectionIP;
			case "rechargeEnergySource":
				return oStorageBatteryDevice.rechargeEnergySource;
			case "refDevice":
				return oStorageBatteryDevice.refDevice;
			case "refPointOfInterest":
				return oStorageBatteryDevice.refPointOfInterest;
			case "roundTripEfficiency":
				return oStorageBatteryDevice.roundTripEfficiency;
			case "seeAlso":
				return oStorageBatteryDevice.seeAlso;
			case "selfDischargeRate":
				return oStorageBatteryDevice.selfDischargeRate;
			case "serialNumber":
				return oStorageBatteryDevice.serialNumber;
			case "source":
				return oStorageBatteryDevice.source;
			case "storableEnergy":
				return oStorageBatteryDevice.storableEnergy;
			case "toolBMS":
				return oStorageBatteryDevice.toolBMS;
			case "typeEnergySource":
				return oStorageBatteryDevice.typeEnergySource;
			case "typeOfUse":
				return oStorageBatteryDevice.typeOfUse;
			case "usableEnergy":
				return oStorageBatteryDevice.usableEnergy;
			case "volEnergyDensity":
				return oStorageBatteryDevice.volEnergyDensity;
			case "weight":
				return oStorageBatteryDevice.weight;
			default:
				return super.obtainBaseModel(var);
		}
	}

	///////////////
	// relate //
	///////////////

	@Override public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateStorageBatteryDevice(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateStorageBatteryDevice(String var, Object val) {
		StorageBatteryDevice oStorageBatteryDevice = (StorageBatteryDevice)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetStorageBatteryDevice(entityVar,  siteRequest_, o);
	}
	public static Object staticSetStorageBatteryDevice(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "address":
			return StorageBatteryDevice.staticSetAddress(siteRequest_, o);
		case "alternateName":
			return StorageBatteryDevice.staticSetAlternateName(siteRequest_, o);
		case "application":
			return StorageBatteryDevice.staticSetApplication(siteRequest_, o);
		case "areaServedColors":
			return StorageBatteryDevice.staticSetAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return StorageBatteryDevice.staticSetAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return StorageBatteryDevice.staticSetAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return StorageBatteryDevice.staticSetAreaServed(siteRequest_, o);
		case "averageLife":
			return StorageBatteryDevice.staticSetAverageLife(siteRequest_, o);
		case "batteryAssessmentMethods":
			return StorageBatteryDevice.staticSetBatteryAssessmentMethods(siteRequest_, o);
		case "batteryType":
			return StorageBatteryDevice.staticSetBatteryType(siteRequest_, o);
		case "brandName":
			return StorageBatteryDevice.staticSetBrandName(siteRequest_, o);
		case "capacityCnnn":
			return StorageBatteryDevice.staticSetCapacityCnnn(siteRequest_, o);
		case "chargeDischargeReactivity":
			return StorageBatteryDevice.staticSetChargeDischargeReactivity(siteRequest_, o);
		case "chargeEfficiency":
			return StorageBatteryDevice.staticSetChargeEfficiency(siteRequest_, o);
		case "chargePower":
			return StorageBatteryDevice.staticSetChargePower(siteRequest_, o);
		case "chargingModeAllowed":
			return StorageBatteryDevice.staticSetChargingModeAllowed(siteRequest_, o);
		case "communication":
			return StorageBatteryDevice.staticSetCommunication(siteRequest_, o);
		case "dataProvider":
			return StorageBatteryDevice.staticSetDataProvider(siteRequest_, o);
		case "dateCreated":
			return StorageBatteryDevice.staticSetDateCreated(siteRequest_, o);
		case "dateLastReported":
			return StorageBatteryDevice.staticSetDateLastReported(siteRequest_, o);
		case "dateModified":
			return StorageBatteryDevice.staticSetDateModified(siteRequest_, o);
		case "description":
			return StorageBatteryDevice.staticSetDescription(siteRequest_, o);
		case "dimension":
			return StorageBatteryDevice.staticSetDimension(siteRequest_, o);
		case "dischargeEfficiency":
			return StorageBatteryDevice.staticSetDischargeEfficiency(siteRequest_, o);
		case "dischargePower":
			return StorageBatteryDevice.staticSetDischargePower(siteRequest_, o);
		case "documentation":
			return StorageBatteryDevice.staticSetDocumentation(siteRequest_, o);
		case "durationPeakPower":
			return StorageBatteryDevice.staticSetDurationPeakPower(siteRequest_, o);
		case "installationCondition":
			return StorageBatteryDevice.staticSetInstallationCondition(siteRequest_, o);
		case "installationMode":
			return StorageBatteryDevice.staticSetInstallationMode(siteRequest_, o);
		case "lifeCycleNumber":
			return StorageBatteryDevice.staticSetLifeCycleNumber(siteRequest_, o);
		case "location":
			return StorageBatteryDevice.staticSetLocation(siteRequest_, o);
		case "manufacturerName":
			return StorageBatteryDevice.staticSetManufacturerName(siteRequest_, o);
		case "massEnergyDensity":
			return StorageBatteryDevice.staticSetMassEnergyDensity(siteRequest_, o);
		case "maxOutputPower":
			return StorageBatteryDevice.staticSetMaxOutputPower(siteRequest_, o);
		case "maximumVoltageEOC":
			return StorageBatteryDevice.staticSetMaximumVoltageEOC(siteRequest_, o);
		case "minimumVoltageEOD":
			return StorageBatteryDevice.staticSetMinimumVoltageEOD(siteRequest_, o);
		case "modelName":
			return StorageBatteryDevice.staticSetModelName(siteRequest_, o);
		case "name":
			return StorageBatteryDevice.staticSetName(siteRequest_, o);
		case "nominalAmpere":
			return StorageBatteryDevice.staticSetNominalAmpere(siteRequest_, o);
		case "nominalCapacity":
			return StorageBatteryDevice.staticSetNominalCapacity(siteRequest_, o);
		case "nominalFrequency":
			return StorageBatteryDevice.staticSetNominalFrequency(siteRequest_, o);
		case "nominalVoltage":
			return StorageBatteryDevice.staticSetNominalVoltage(siteRequest_, o);
		case "operatingAltitude":
			return StorageBatteryDevice.staticSetOperatingAltitude(siteRequest_, o);
		case "operatingAmpere":
			return StorageBatteryDevice.staticSetOperatingAmpere(siteRequest_, o);
		case "operatingFrequency":
			return StorageBatteryDevice.staticSetOperatingFrequency(siteRequest_, o);
		case "operatingTemperature":
			return StorageBatteryDevice.staticSetOperatingTemperature(siteRequest_, o);
		case "operatingVoltage":
			return StorageBatteryDevice.staticSetOperatingVoltage(siteRequest_, o);
		case "overloadAccepted":
			return StorageBatteryDevice.staticSetOverloadAccepted(siteRequest_, o);
		case "overloadAcceptedTime":
			return StorageBatteryDevice.staticSetOverloadAcceptedTime(siteRequest_, o);
		case "owner":
			return StorageBatteryDevice.staticSetOwner(siteRequest_, o);
		case "peakPower":
			return StorageBatteryDevice.staticSetPeakPower(siteRequest_, o);
		case "possibilityOfUse":
			return StorageBatteryDevice.staticSetPossibilityOfUse(siteRequest_, o);
		case "protectionIK":
			return StorageBatteryDevice.staticSetProtectionIK(siteRequest_, o);
		case "protectionIP":
			return StorageBatteryDevice.staticSetProtectionIP(siteRequest_, o);
		case "rechargeEnergySource":
			return StorageBatteryDevice.staticSetRechargeEnergySource(siteRequest_, o);
		case "refDevice":
			return StorageBatteryDevice.staticSetRefDevice(siteRequest_, o);
		case "refPointOfInterest":
			return StorageBatteryDevice.staticSetRefPointOfInterest(siteRequest_, o);
		case "roundTripEfficiency":
			return StorageBatteryDevice.staticSetRoundTripEfficiency(siteRequest_, o);
		case "seeAlso":
			return StorageBatteryDevice.staticSetSeeAlso(siteRequest_, o);
		case "selfDischargeRate":
			return StorageBatteryDevice.staticSetSelfDischargeRate(siteRequest_, o);
		case "serialNumber":
			return StorageBatteryDevice.staticSetSerialNumber(siteRequest_, o);
		case "source":
			return StorageBatteryDevice.staticSetSource(siteRequest_, o);
		case "storableEnergy":
			return StorageBatteryDevice.staticSetStorableEnergy(siteRequest_, o);
		case "toolBMS":
			return StorageBatteryDevice.staticSetToolBMS(siteRequest_, o);
		case "typeEnergySource":
			return StorageBatteryDevice.staticSetTypeEnergySource(siteRequest_, o);
		case "typeOfUse":
			return StorageBatteryDevice.staticSetTypeOfUse(siteRequest_, o);
		case "usableEnergy":
			return StorageBatteryDevice.staticSetUsableEnergy(siteRequest_, o);
		case "volEnergyDensity":
			return StorageBatteryDevice.staticSetVolEnergyDensity(siteRequest_, o);
		case "weight":
			return StorageBatteryDevice.staticSetWeight(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStorageBatteryDevice(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchStorageBatteryDevice(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return StorageBatteryDevice.staticSearchAddress(siteRequest_, (JsonObject)o);
		case "alternateName":
			return StorageBatteryDevice.staticSearchAlternateName(siteRequest_, (String)o);
		case "application":
			return StorageBatteryDevice.staticSearchApplication(siteRequest_, (JsonObject)o);
		case "areaServedColors":
			return StorageBatteryDevice.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return StorageBatteryDevice.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return StorageBatteryDevice.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return StorageBatteryDevice.staticSearchAreaServed(siteRequest_, (Path)o);
		case "averageLife":
			return StorageBatteryDevice.staticSearchAverageLife(siteRequest_, (BigDecimal)o);
		case "batteryAssessmentMethods":
			return StorageBatteryDevice.staticSearchBatteryAssessmentMethods(siteRequest_, (String)o);
		case "batteryType":
			return StorageBatteryDevice.staticSearchBatteryType(siteRequest_, (String)o);
		case "brandName":
			return StorageBatteryDevice.staticSearchBrandName(siteRequest_, (String)o);
		case "capacityCnnn":
			return StorageBatteryDevice.staticSearchCapacityCnnn(siteRequest_, (JsonObject)o);
		case "chargeDischargeReactivity":
			return StorageBatteryDevice.staticSearchChargeDischargeReactivity(siteRequest_, (BigDecimal)o);
		case "chargeEfficiency":
			return StorageBatteryDevice.staticSearchChargeEfficiency(siteRequest_, (BigDecimal)o);
		case "chargePower":
			return StorageBatteryDevice.staticSearchChargePower(siteRequest_, (BigDecimal)o);
		case "chargingModeAllowed":
			return StorageBatteryDevice.staticSearchChargingModeAllowed(siteRequest_, (JsonObject)o);
		case "communication":
			return StorageBatteryDevice.staticSearchCommunication(siteRequest_, (JsonObject)o);
		case "dataProvider":
			return StorageBatteryDevice.staticSearchDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return StorageBatteryDevice.staticSearchDateCreated(siteRequest_, (String)o);
		case "dateLastReported":
			return StorageBatteryDevice.staticSearchDateLastReported(siteRequest_, (String)o);
		case "dateModified":
			return StorageBatteryDevice.staticSearchDateModified(siteRequest_, (String)o);
		case "description":
			return StorageBatteryDevice.staticSearchDescription(siteRequest_, (String)o);
		case "dimension":
			return StorageBatteryDevice.staticSearchDimension(siteRequest_, (JsonObject)o);
		case "dischargeEfficiency":
			return StorageBatteryDevice.staticSearchDischargeEfficiency(siteRequest_, (BigDecimal)o);
		case "dischargePower":
			return StorageBatteryDevice.staticSearchDischargePower(siteRequest_, (BigDecimal)o);
		case "documentation":
			return StorageBatteryDevice.staticSearchDocumentation(siteRequest_, (String)o);
		case "durationPeakPower":
			return StorageBatteryDevice.staticSearchDurationPeakPower(siteRequest_, (BigDecimal)o);
		case "installationCondition":
			return StorageBatteryDevice.staticSearchInstallationCondition(siteRequest_, (JsonObject)o);
		case "installationMode":
			return StorageBatteryDevice.staticSearchInstallationMode(siteRequest_, (String)o);
		case "lifeCycleNumber":
			return StorageBatteryDevice.staticSearchLifeCycleNumber(siteRequest_, (JsonObject)o);
		case "location":
			return StorageBatteryDevice.staticSearchLocation(siteRequest_, (Point)o);
		case "manufacturerName":
			return StorageBatteryDevice.staticSearchManufacturerName(siteRequest_, (String)o);
		case "massEnergyDensity":
			return StorageBatteryDevice.staticSearchMassEnergyDensity(siteRequest_, (JsonObject)o);
		case "maxOutputPower":
			return StorageBatteryDevice.staticSearchMaxOutputPower(siteRequest_, (BigDecimal)o);
		case "maximumVoltageEOC":
			return StorageBatteryDevice.staticSearchMaximumVoltageEOC(siteRequest_, (BigDecimal)o);
		case "minimumVoltageEOD":
			return StorageBatteryDevice.staticSearchMinimumVoltageEOD(siteRequest_, (BigDecimal)o);
		case "modelName":
			return StorageBatteryDevice.staticSearchModelName(siteRequest_, (String)o);
		case "name":
			return StorageBatteryDevice.staticSearchName(siteRequest_, (String)o);
		case "nominalAmpere":
			return StorageBatteryDevice.staticSearchNominalAmpere(siteRequest_, (BigDecimal)o);
		case "nominalCapacity":
			return StorageBatteryDevice.staticSearchNominalCapacity(siteRequest_, (BigDecimal)o);
		case "nominalFrequency":
			return StorageBatteryDevice.staticSearchNominalFrequency(siteRequest_, (BigDecimal)o);
		case "nominalVoltage":
			return StorageBatteryDevice.staticSearchNominalVoltage(siteRequest_, (BigDecimal)o);
		case "operatingAltitude":
			return StorageBatteryDevice.staticSearchOperatingAltitude(siteRequest_, (JsonObject)o);
		case "operatingAmpere":
			return StorageBatteryDevice.staticSearchOperatingAmpere(siteRequest_, (JsonObject)o);
		case "operatingFrequency":
			return StorageBatteryDevice.staticSearchOperatingFrequency(siteRequest_, (JsonObject)o);
		case "operatingTemperature":
			return StorageBatteryDevice.staticSearchOperatingTemperature(siteRequest_, (JsonObject)o);
		case "operatingVoltage":
			return StorageBatteryDevice.staticSearchOperatingVoltage(siteRequest_, (JsonObject)o);
		case "overloadAccepted":
			return StorageBatteryDevice.staticSearchOverloadAccepted(siteRequest_, (Boolean)o);
		case "overloadAcceptedTime":
			return StorageBatteryDevice.staticSearchOverloadAcceptedTime(siteRequest_, (String)o);
		case "owner":
			return StorageBatteryDevice.staticSearchOwner(siteRequest_, (JsonObject)o);
		case "peakPower":
			return StorageBatteryDevice.staticSearchPeakPower(siteRequest_, (BigDecimal)o);
		case "possibilityOfUse":
			return StorageBatteryDevice.staticSearchPossibilityOfUse(siteRequest_, (String)o);
		case "protectionIK":
			return StorageBatteryDevice.staticSearchProtectionIK(siteRequest_, (BigDecimal)o);
		case "protectionIP":
			return StorageBatteryDevice.staticSearchProtectionIP(siteRequest_, (String)o);
		case "rechargeEnergySource":
			return StorageBatteryDevice.staticSearchRechargeEnergySource(siteRequest_, (String)o);
		case "refDevice":
			return StorageBatteryDevice.staticSearchRefDevice(siteRequest_, (JsonObject)o);
		case "refPointOfInterest":
			return StorageBatteryDevice.staticSearchRefPointOfInterest(siteRequest_, (JsonObject)o);
		case "roundTripEfficiency":
			return StorageBatteryDevice.staticSearchRoundTripEfficiency(siteRequest_, (BigDecimal)o);
		case "seeAlso":
			return StorageBatteryDevice.staticSearchSeeAlso(siteRequest_, (JsonObject)o);
		case "selfDischargeRate":
			return StorageBatteryDevice.staticSearchSelfDischargeRate(siteRequest_, (BigDecimal)o);
		case "serialNumber":
			return StorageBatteryDevice.staticSearchSerialNumber(siteRequest_, (String)o);
		case "source":
			return StorageBatteryDevice.staticSearchSource(siteRequest_, (String)o);
		case "storableEnergy":
			return StorageBatteryDevice.staticSearchStorableEnergy(siteRequest_, (BigDecimal)o);
		case "toolBMS":
			return StorageBatteryDevice.staticSearchToolBMS(siteRequest_, (Boolean)o);
		case "typeEnergySource":
			return StorageBatteryDevice.staticSearchTypeEnergySource(siteRequest_, (JsonObject)o);
		case "typeOfUse":
			return StorageBatteryDevice.staticSearchTypeOfUse(siteRequest_, (String)o);
		case "usableEnergy":
			return StorageBatteryDevice.staticSearchUsableEnergy(siteRequest_, (BigDecimal)o);
		case "volEnergyDensity":
			return StorageBatteryDevice.staticSearchVolEnergyDensity(siteRequest_, (JsonObject)o);
		case "weight":
			return StorageBatteryDevice.staticSearchWeight(siteRequest_, (BigDecimal)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrStorageBatteryDevice(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrStorageBatteryDevice(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return StorageBatteryDevice.staticSearchStrAddress(siteRequest_, (String)o);
		case "alternateName":
			return StorageBatteryDevice.staticSearchStrAlternateName(siteRequest_, (String)o);
		case "application":
			return StorageBatteryDevice.staticSearchStrApplication(siteRequest_, (String)o);
		case "areaServedColors":
			return StorageBatteryDevice.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return StorageBatteryDevice.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return StorageBatteryDevice.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return StorageBatteryDevice.staticSearchStrAreaServed(siteRequest_, (Path)o);
		case "averageLife":
			return StorageBatteryDevice.staticSearchStrAverageLife(siteRequest_, (Double)o);
		case "batteryAssessmentMethods":
			return StorageBatteryDevice.staticSearchStrBatteryAssessmentMethods(siteRequest_, (String)o);
		case "batteryType":
			return StorageBatteryDevice.staticSearchStrBatteryType(siteRequest_, (String)o);
		case "brandName":
			return StorageBatteryDevice.staticSearchStrBrandName(siteRequest_, (String)o);
		case "capacityCnnn":
			return StorageBatteryDevice.staticSearchStrCapacityCnnn(siteRequest_, (String)o);
		case "chargeDischargeReactivity":
			return StorageBatteryDevice.staticSearchStrChargeDischargeReactivity(siteRequest_, (Double)o);
		case "chargeEfficiency":
			return StorageBatteryDevice.staticSearchStrChargeEfficiency(siteRequest_, (Double)o);
		case "chargePower":
			return StorageBatteryDevice.staticSearchStrChargePower(siteRequest_, (Double)o);
		case "chargingModeAllowed":
			return StorageBatteryDevice.staticSearchStrChargingModeAllowed(siteRequest_, (String)o);
		case "communication":
			return StorageBatteryDevice.staticSearchStrCommunication(siteRequest_, (String)o);
		case "dataProvider":
			return StorageBatteryDevice.staticSearchStrDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return StorageBatteryDevice.staticSearchStrDateCreated(siteRequest_, (String)o);
		case "dateLastReported":
			return StorageBatteryDevice.staticSearchStrDateLastReported(siteRequest_, (String)o);
		case "dateModified":
			return StorageBatteryDevice.staticSearchStrDateModified(siteRequest_, (String)o);
		case "description":
			return StorageBatteryDevice.staticSearchStrDescription(siteRequest_, (String)o);
		case "dimension":
			return StorageBatteryDevice.staticSearchStrDimension(siteRequest_, (String)o);
		case "dischargeEfficiency":
			return StorageBatteryDevice.staticSearchStrDischargeEfficiency(siteRequest_, (Double)o);
		case "dischargePower":
			return StorageBatteryDevice.staticSearchStrDischargePower(siteRequest_, (Double)o);
		case "documentation":
			return StorageBatteryDevice.staticSearchStrDocumentation(siteRequest_, (String)o);
		case "durationPeakPower":
			return StorageBatteryDevice.staticSearchStrDurationPeakPower(siteRequest_, (Double)o);
		case "installationCondition":
			return StorageBatteryDevice.staticSearchStrInstallationCondition(siteRequest_, (String)o);
		case "installationMode":
			return StorageBatteryDevice.staticSearchStrInstallationMode(siteRequest_, (String)o);
		case "lifeCycleNumber":
			return StorageBatteryDevice.staticSearchStrLifeCycleNumber(siteRequest_, (String)o);
		case "location":
			return StorageBatteryDevice.staticSearchStrLocation(siteRequest_, (Point)o);
		case "manufacturerName":
			return StorageBatteryDevice.staticSearchStrManufacturerName(siteRequest_, (String)o);
		case "massEnergyDensity":
			return StorageBatteryDevice.staticSearchStrMassEnergyDensity(siteRequest_, (String)o);
		case "maxOutputPower":
			return StorageBatteryDevice.staticSearchStrMaxOutputPower(siteRequest_, (Double)o);
		case "maximumVoltageEOC":
			return StorageBatteryDevice.staticSearchStrMaximumVoltageEOC(siteRequest_, (Double)o);
		case "minimumVoltageEOD":
			return StorageBatteryDevice.staticSearchStrMinimumVoltageEOD(siteRequest_, (Double)o);
		case "modelName":
			return StorageBatteryDevice.staticSearchStrModelName(siteRequest_, (String)o);
		case "name":
			return StorageBatteryDevice.staticSearchStrName(siteRequest_, (String)o);
		case "nominalAmpere":
			return StorageBatteryDevice.staticSearchStrNominalAmpere(siteRequest_, (Double)o);
		case "nominalCapacity":
			return StorageBatteryDevice.staticSearchStrNominalCapacity(siteRequest_, (Double)o);
		case "nominalFrequency":
			return StorageBatteryDevice.staticSearchStrNominalFrequency(siteRequest_, (Double)o);
		case "nominalVoltage":
			return StorageBatteryDevice.staticSearchStrNominalVoltage(siteRequest_, (Double)o);
		case "operatingAltitude":
			return StorageBatteryDevice.staticSearchStrOperatingAltitude(siteRequest_, (String)o);
		case "operatingAmpere":
			return StorageBatteryDevice.staticSearchStrOperatingAmpere(siteRequest_, (String)o);
		case "operatingFrequency":
			return StorageBatteryDevice.staticSearchStrOperatingFrequency(siteRequest_, (String)o);
		case "operatingTemperature":
			return StorageBatteryDevice.staticSearchStrOperatingTemperature(siteRequest_, (String)o);
		case "operatingVoltage":
			return StorageBatteryDevice.staticSearchStrOperatingVoltage(siteRequest_, (String)o);
		case "overloadAccepted":
			return StorageBatteryDevice.staticSearchStrOverloadAccepted(siteRequest_, (Boolean)o);
		case "overloadAcceptedTime":
			return StorageBatteryDevice.staticSearchStrOverloadAcceptedTime(siteRequest_, (String)o);
		case "owner":
			return StorageBatteryDevice.staticSearchStrOwner(siteRequest_, (String)o);
		case "peakPower":
			return StorageBatteryDevice.staticSearchStrPeakPower(siteRequest_, (Double)o);
		case "possibilityOfUse":
			return StorageBatteryDevice.staticSearchStrPossibilityOfUse(siteRequest_, (String)o);
		case "protectionIK":
			return StorageBatteryDevice.staticSearchStrProtectionIK(siteRequest_, (Double)o);
		case "protectionIP":
			return StorageBatteryDevice.staticSearchStrProtectionIP(siteRequest_, (String)o);
		case "rechargeEnergySource":
			return StorageBatteryDevice.staticSearchStrRechargeEnergySource(siteRequest_, (String)o);
		case "refDevice":
			return StorageBatteryDevice.staticSearchStrRefDevice(siteRequest_, (String)o);
		case "refPointOfInterest":
			return StorageBatteryDevice.staticSearchStrRefPointOfInterest(siteRequest_, (String)o);
		case "roundTripEfficiency":
			return StorageBatteryDevice.staticSearchStrRoundTripEfficiency(siteRequest_, (Double)o);
		case "seeAlso":
			return StorageBatteryDevice.staticSearchStrSeeAlso(siteRequest_, (String)o);
		case "selfDischargeRate":
			return StorageBatteryDevice.staticSearchStrSelfDischargeRate(siteRequest_, (Double)o);
		case "serialNumber":
			return StorageBatteryDevice.staticSearchStrSerialNumber(siteRequest_, (String)o);
		case "source":
			return StorageBatteryDevice.staticSearchStrSource(siteRequest_, (String)o);
		case "storableEnergy":
			return StorageBatteryDevice.staticSearchStrStorableEnergy(siteRequest_, (Double)o);
		case "toolBMS":
			return StorageBatteryDevice.staticSearchStrToolBMS(siteRequest_, (Boolean)o);
		case "typeEnergySource":
			return StorageBatteryDevice.staticSearchStrTypeEnergySource(siteRequest_, (String)o);
		case "typeOfUse":
			return StorageBatteryDevice.staticSearchStrTypeOfUse(siteRequest_, (String)o);
		case "usableEnergy":
			return StorageBatteryDevice.staticSearchStrUsableEnergy(siteRequest_, (Double)o);
		case "volEnergyDensity":
			return StorageBatteryDevice.staticSearchStrVolEnergyDensity(siteRequest_, (String)o);
		case "weight":
			return StorageBatteryDevice.staticSearchStrWeight(siteRequest_, (Double)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqStorageBatteryDevice(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqStorageBatteryDevice(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "address":
			return StorageBatteryDevice.staticSearchFqAddress(siteRequest_, o);
		case "alternateName":
			return StorageBatteryDevice.staticSearchFqAlternateName(siteRequest_, o);
		case "application":
			return StorageBatteryDevice.staticSearchFqApplication(siteRequest_, o);
		case "areaServedColors":
			return StorageBatteryDevice.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return StorageBatteryDevice.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return StorageBatteryDevice.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return StorageBatteryDevice.staticSearchFqAreaServed(siteRequest_, o);
		case "averageLife":
			return StorageBatteryDevice.staticSearchFqAverageLife(siteRequest_, o);
		case "batteryAssessmentMethods":
			return StorageBatteryDevice.staticSearchFqBatteryAssessmentMethods(siteRequest_, o);
		case "batteryType":
			return StorageBatteryDevice.staticSearchFqBatteryType(siteRequest_, o);
		case "brandName":
			return StorageBatteryDevice.staticSearchFqBrandName(siteRequest_, o);
		case "capacityCnnn":
			return StorageBatteryDevice.staticSearchFqCapacityCnnn(siteRequest_, o);
		case "chargeDischargeReactivity":
			return StorageBatteryDevice.staticSearchFqChargeDischargeReactivity(siteRequest_, o);
		case "chargeEfficiency":
			return StorageBatteryDevice.staticSearchFqChargeEfficiency(siteRequest_, o);
		case "chargePower":
			return StorageBatteryDevice.staticSearchFqChargePower(siteRequest_, o);
		case "chargingModeAllowed":
			return StorageBatteryDevice.staticSearchFqChargingModeAllowed(siteRequest_, o);
		case "communication":
			return StorageBatteryDevice.staticSearchFqCommunication(siteRequest_, o);
		case "dataProvider":
			return StorageBatteryDevice.staticSearchFqDataProvider(siteRequest_, o);
		case "dateCreated":
			return StorageBatteryDevice.staticSearchFqDateCreated(siteRequest_, o);
		case "dateLastReported":
			return StorageBatteryDevice.staticSearchFqDateLastReported(siteRequest_, o);
		case "dateModified":
			return StorageBatteryDevice.staticSearchFqDateModified(siteRequest_, o);
		case "description":
			return StorageBatteryDevice.staticSearchFqDescription(siteRequest_, o);
		case "dimension":
			return StorageBatteryDevice.staticSearchFqDimension(siteRequest_, o);
		case "dischargeEfficiency":
			return StorageBatteryDevice.staticSearchFqDischargeEfficiency(siteRequest_, o);
		case "dischargePower":
			return StorageBatteryDevice.staticSearchFqDischargePower(siteRequest_, o);
		case "documentation":
			return StorageBatteryDevice.staticSearchFqDocumentation(siteRequest_, o);
		case "durationPeakPower":
			return StorageBatteryDevice.staticSearchFqDurationPeakPower(siteRequest_, o);
		case "installationCondition":
			return StorageBatteryDevice.staticSearchFqInstallationCondition(siteRequest_, o);
		case "installationMode":
			return StorageBatteryDevice.staticSearchFqInstallationMode(siteRequest_, o);
		case "lifeCycleNumber":
			return StorageBatteryDevice.staticSearchFqLifeCycleNumber(siteRequest_, o);
		case "location":
			return StorageBatteryDevice.staticSearchFqLocation(siteRequest_, o);
		case "manufacturerName":
			return StorageBatteryDevice.staticSearchFqManufacturerName(siteRequest_, o);
		case "massEnergyDensity":
			return StorageBatteryDevice.staticSearchFqMassEnergyDensity(siteRequest_, o);
		case "maxOutputPower":
			return StorageBatteryDevice.staticSearchFqMaxOutputPower(siteRequest_, o);
		case "maximumVoltageEOC":
			return StorageBatteryDevice.staticSearchFqMaximumVoltageEOC(siteRequest_, o);
		case "minimumVoltageEOD":
			return StorageBatteryDevice.staticSearchFqMinimumVoltageEOD(siteRequest_, o);
		case "modelName":
			return StorageBatteryDevice.staticSearchFqModelName(siteRequest_, o);
		case "name":
			return StorageBatteryDevice.staticSearchFqName(siteRequest_, o);
		case "nominalAmpere":
			return StorageBatteryDevice.staticSearchFqNominalAmpere(siteRequest_, o);
		case "nominalCapacity":
			return StorageBatteryDevice.staticSearchFqNominalCapacity(siteRequest_, o);
		case "nominalFrequency":
			return StorageBatteryDevice.staticSearchFqNominalFrequency(siteRequest_, o);
		case "nominalVoltage":
			return StorageBatteryDevice.staticSearchFqNominalVoltage(siteRequest_, o);
		case "operatingAltitude":
			return StorageBatteryDevice.staticSearchFqOperatingAltitude(siteRequest_, o);
		case "operatingAmpere":
			return StorageBatteryDevice.staticSearchFqOperatingAmpere(siteRequest_, o);
		case "operatingFrequency":
			return StorageBatteryDevice.staticSearchFqOperatingFrequency(siteRequest_, o);
		case "operatingTemperature":
			return StorageBatteryDevice.staticSearchFqOperatingTemperature(siteRequest_, o);
		case "operatingVoltage":
			return StorageBatteryDevice.staticSearchFqOperatingVoltage(siteRequest_, o);
		case "overloadAccepted":
			return StorageBatteryDevice.staticSearchFqOverloadAccepted(siteRequest_, o);
		case "overloadAcceptedTime":
			return StorageBatteryDevice.staticSearchFqOverloadAcceptedTime(siteRequest_, o);
		case "owner":
			return StorageBatteryDevice.staticSearchFqOwner(siteRequest_, o);
		case "peakPower":
			return StorageBatteryDevice.staticSearchFqPeakPower(siteRequest_, o);
		case "possibilityOfUse":
			return StorageBatteryDevice.staticSearchFqPossibilityOfUse(siteRequest_, o);
		case "protectionIK":
			return StorageBatteryDevice.staticSearchFqProtectionIK(siteRequest_, o);
		case "protectionIP":
			return StorageBatteryDevice.staticSearchFqProtectionIP(siteRequest_, o);
		case "rechargeEnergySource":
			return StorageBatteryDevice.staticSearchFqRechargeEnergySource(siteRequest_, o);
		case "refDevice":
			return StorageBatteryDevice.staticSearchFqRefDevice(siteRequest_, o);
		case "refPointOfInterest":
			return StorageBatteryDevice.staticSearchFqRefPointOfInterest(siteRequest_, o);
		case "roundTripEfficiency":
			return StorageBatteryDevice.staticSearchFqRoundTripEfficiency(siteRequest_, o);
		case "seeAlso":
			return StorageBatteryDevice.staticSearchFqSeeAlso(siteRequest_, o);
		case "selfDischargeRate":
			return StorageBatteryDevice.staticSearchFqSelfDischargeRate(siteRequest_, o);
		case "serialNumber":
			return StorageBatteryDevice.staticSearchFqSerialNumber(siteRequest_, o);
		case "source":
			return StorageBatteryDevice.staticSearchFqSource(siteRequest_, o);
		case "storableEnergy":
			return StorageBatteryDevice.staticSearchFqStorableEnergy(siteRequest_, o);
		case "toolBMS":
			return StorageBatteryDevice.staticSearchFqToolBMS(siteRequest_, o);
		case "typeEnergySource":
			return StorageBatteryDevice.staticSearchFqTypeEnergySource(siteRequest_, o);
		case "typeOfUse":
			return StorageBatteryDevice.staticSearchFqTypeOfUse(siteRequest_, o);
		case "usableEnergy":
			return StorageBatteryDevice.staticSearchFqUsableEnergy(siteRequest_, o);
		case "volEnergyDensity":
			return StorageBatteryDevice.staticSearchFqVolEnergyDensity(siteRequest_, o);
		case "weight":
			return StorageBatteryDevice.staticSearchFqWeight(siteRequest_, o);
			default:
				return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// persist //
	/////////////

	@Override public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = persistStorageBatteryDevice(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistStorageBatteryDevice(String var, Object val) {
		String varLower = var.toLowerCase();
			if("address".equals(varLower)) {
				if(val instanceof String) {
					setAddress((String)val);
				} else if(val instanceof JsonObject) {
					setAddress((JsonObject)val);
				}
				saves.add("address");
				return val;
			} else if("alternatename".equals(varLower)) {
				if(val instanceof String) {
					setAlternateName((String)val);
				}
				saves.add("alternateName");
				return val;
			} else if("application".equals(varLower)) {
				if(val instanceof String) {
					setApplication((String)val);
				} else if(val instanceof JsonObject) {
					setApplication((JsonObject)val);
				}
				saves.add("application");
				return val;
			} else if("areaserved".equals(varLower)) {
				if(val instanceof Path) {
					setAreaServed((Path)val);
				} else {
					setAreaServed(val == null ? null : val.toString());
				}
				saves.add("areaServed");
				return val;
			} else if("averagelife".equals(varLower)) {
				if(val instanceof String) {
					setAverageLife((String)val);
				} else if(val instanceof Number) {
					setAverageLife(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageLife");
				return val;
			} else if("batteryassessmentmethods".equals(varLower)) {
				if(val instanceof String) {
					setBatteryAssessmentMethods((String)val);
				}
				saves.add("batteryAssessmentMethods");
				return val;
			} else if("batterytype".equals(varLower)) {
				if(val instanceof String) {
					setBatteryType((String)val);
				}
				saves.add("batteryType");
				return val;
			} else if("brandname".equals(varLower)) {
				if(val instanceof String) {
					setBrandName((String)val);
				}
				saves.add("brandName");
				return val;
			} else if("capacitycnnn".equals(varLower)) {
				if(val instanceof String) {
					setCapacityCnnn((String)val);
				} else if(val instanceof JsonObject) {
					setCapacityCnnn((JsonObject)val);
				}
				saves.add("capacityCnnn");
				return val;
			} else if("chargedischargereactivity".equals(varLower)) {
				if(val instanceof String) {
					setChargeDischargeReactivity((String)val);
				} else if(val instanceof Number) {
					setChargeDischargeReactivity(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("chargeDischargeReactivity");
				return val;
			} else if("chargeefficiency".equals(varLower)) {
				if(val instanceof String) {
					setChargeEfficiency((String)val);
				} else if(val instanceof Number) {
					setChargeEfficiency(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("chargeEfficiency");
				return val;
			} else if("chargepower".equals(varLower)) {
				if(val instanceof String) {
					setChargePower((String)val);
				} else if(val instanceof Number) {
					setChargePower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("chargePower");
				return val;
			} else if("chargingmodeallowed".equals(varLower)) {
				if(val instanceof String) {
					setChargingModeAllowed((String)val);
				} else if(val instanceof JsonObject) {
					setChargingModeAllowed((JsonObject)val);
				}
				saves.add("chargingModeAllowed");
				return val;
			} else if("communication".equals(varLower)) {
				if(val instanceof String) {
					setCommunication((String)val);
				} else if(val instanceof JsonObject) {
					setCommunication((JsonObject)val);
				}
				saves.add("communication");
				return val;
			} else if("dataprovider".equals(varLower)) {
				if(val instanceof String) {
					setDataProvider((String)val);
				}
				saves.add("dataProvider");
				return val;
			} else if("datecreated".equals(varLower)) {
				if(val instanceof String) {
					setDateCreated((String)val);
				}
				saves.add("dateCreated");
				return val;
			} else if("datelastreported".equals(varLower)) {
				if(val instanceof String) {
					setDateLastReported((String)val);
				}
				saves.add("dateLastReported");
				return val;
			} else if("datemodified".equals(varLower)) {
				if(val instanceof String) {
					setDateModified((String)val);
				}
				saves.add("dateModified");
				return val;
			} else if("description".equals(varLower)) {
				if(val instanceof String) {
					setDescription((String)val);
				}
				saves.add("description");
				return val;
			} else if("dimension".equals(varLower)) {
				if(val instanceof String) {
					setDimension((String)val);
				} else if(val instanceof JsonObject) {
					setDimension((JsonObject)val);
				}
				saves.add("dimension");
				return val;
			} else if("dischargeefficiency".equals(varLower)) {
				if(val instanceof String) {
					setDischargeEfficiency((String)val);
				} else if(val instanceof Number) {
					setDischargeEfficiency(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("dischargeEfficiency");
				return val;
			} else if("dischargepower".equals(varLower)) {
				if(val instanceof String) {
					setDischargePower((String)val);
				} else if(val instanceof Number) {
					setDischargePower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("dischargePower");
				return val;
			} else if("documentation".equals(varLower)) {
				if(val instanceof String) {
					setDocumentation((String)val);
				}
				saves.add("documentation");
				return val;
			} else if("durationpeakpower".equals(varLower)) {
				if(val instanceof String) {
					setDurationPeakPower((String)val);
				} else if(val instanceof Number) {
					setDurationPeakPower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("durationPeakPower");
				return val;
			} else if("installationcondition".equals(varLower)) {
				if(val instanceof String) {
					setInstallationCondition((String)val);
				} else if(val instanceof JsonObject) {
					setInstallationCondition((JsonObject)val);
				}
				saves.add("installationCondition");
				return val;
			} else if("installationmode".equals(varLower)) {
				if(val instanceof String) {
					setInstallationMode((String)val);
				}
				saves.add("installationMode");
				return val;
			} else if("lifecyclenumber".equals(varLower)) {
				if(val instanceof String) {
					setLifeCycleNumber((String)val);
				} else if(val instanceof JsonObject) {
					setLifeCycleNumber((JsonObject)val);
				}
				saves.add("lifeCycleNumber");
				return val;
			} else if("location".equals(varLower)) {
				if(val instanceof String) {
					setLocation((String)val);
				} else if(val instanceof Point) {
					setLocation((Point)val);
				}
				saves.add("location");
				return val;
			} else if("manufacturername".equals(varLower)) {
				if(val instanceof String) {
					setManufacturerName((String)val);
				}
				saves.add("manufacturerName");
				return val;
			} else if("massenergydensity".equals(varLower)) {
				if(val instanceof String) {
					setMassEnergyDensity((String)val);
				} else if(val instanceof JsonObject) {
					setMassEnergyDensity((JsonObject)val);
				}
				saves.add("massEnergyDensity");
				return val;
			} else if("maxoutputpower".equals(varLower)) {
				if(val instanceof String) {
					setMaxOutputPower((String)val);
				} else if(val instanceof Number) {
					setMaxOutputPower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("maxOutputPower");
				return val;
			} else if("maximumvoltageeoc".equals(varLower)) {
				if(val instanceof String) {
					setMaximumVoltageEOC((String)val);
				} else if(val instanceof Number) {
					setMaximumVoltageEOC(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("maximumVoltageEOC");
				return val;
			} else if("minimumvoltageeod".equals(varLower)) {
				if(val instanceof String) {
					setMinimumVoltageEOD((String)val);
				} else if(val instanceof Number) {
					setMinimumVoltageEOD(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("minimumVoltageEOD");
				return val;
			} else if("modelname".equals(varLower)) {
				if(val instanceof String) {
					setModelName((String)val);
				}
				saves.add("modelName");
				return val;
			} else if("name".equals(varLower)) {
				if(val instanceof String) {
					setName((String)val);
				}
				saves.add("name");
				return val;
			} else if("nominalampere".equals(varLower)) {
				if(val instanceof String) {
					setNominalAmpere((String)val);
				} else if(val instanceof Number) {
					setNominalAmpere(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("nominalAmpere");
				return val;
			} else if("nominalcapacity".equals(varLower)) {
				if(val instanceof String) {
					setNominalCapacity((String)val);
				} else if(val instanceof Number) {
					setNominalCapacity(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("nominalCapacity");
				return val;
			} else if("nominalfrequency".equals(varLower)) {
				if(val instanceof String) {
					setNominalFrequency((String)val);
				} else if(val instanceof Number) {
					setNominalFrequency(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("nominalFrequency");
				return val;
			} else if("nominalvoltage".equals(varLower)) {
				if(val instanceof String) {
					setNominalVoltage((String)val);
				} else if(val instanceof Number) {
					setNominalVoltage(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("nominalVoltage");
				return val;
			} else if("operatingaltitude".equals(varLower)) {
				if(val instanceof String) {
					setOperatingAltitude((String)val);
				} else if(val instanceof JsonObject) {
					setOperatingAltitude((JsonObject)val);
				}
				saves.add("operatingAltitude");
				return val;
			} else if("operatingampere".equals(varLower)) {
				if(val instanceof String) {
					setOperatingAmpere((String)val);
				} else if(val instanceof JsonObject) {
					setOperatingAmpere((JsonObject)val);
				}
				saves.add("operatingAmpere");
				return val;
			} else if("operatingfrequency".equals(varLower)) {
				if(val instanceof String) {
					setOperatingFrequency((String)val);
				} else if(val instanceof JsonObject) {
					setOperatingFrequency((JsonObject)val);
				}
				saves.add("operatingFrequency");
				return val;
			} else if("operatingtemperature".equals(varLower)) {
				if(val instanceof String) {
					setOperatingTemperature((String)val);
				} else if(val instanceof JsonObject) {
					setOperatingTemperature((JsonObject)val);
				}
				saves.add("operatingTemperature");
				return val;
			} else if("operatingvoltage".equals(varLower)) {
				if(val instanceof String) {
					setOperatingVoltage((String)val);
				} else if(val instanceof JsonObject) {
					setOperatingVoltage((JsonObject)val);
				}
				saves.add("operatingVoltage");
				return val;
			} else if("overloadaccepted".equals(varLower)) {
				if(val instanceof Boolean) {
					setOverloadAccepted((Boolean)val);
				} else {
					setOverloadAccepted(val == null ? null : val.toString());
				}
				saves.add("overloadAccepted");
				return val;
			} else if("overloadacceptedtime".equals(varLower)) {
				if(val instanceof String) {
					setOverloadAcceptedTime((String)val);
				}
				saves.add("overloadAcceptedTime");
				return val;
			} else if("owner".equals(varLower)) {
				if(val instanceof String) {
					setOwner((String)val);
				} else if(val instanceof JsonObject) {
					setOwner((JsonObject)val);
				}
				saves.add("owner");
				return val;
			} else if("peakpower".equals(varLower)) {
				if(val instanceof String) {
					setPeakPower((String)val);
				} else if(val instanceof Number) {
					setPeakPower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("peakPower");
				return val;
			} else if("possibilityofuse".equals(varLower)) {
				if(val instanceof String) {
					setPossibilityOfUse((String)val);
				}
				saves.add("possibilityOfUse");
				return val;
			} else if("protectionik".equals(varLower)) {
				if(val instanceof String) {
					setProtectionIK((String)val);
				} else if(val instanceof Number) {
					setProtectionIK(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("protectionIK");
				return val;
			} else if("protectionip".equals(varLower)) {
				if(val instanceof String) {
					setProtectionIP((String)val);
				}
				saves.add("protectionIP");
				return val;
			} else if("rechargeenergysource".equals(varLower)) {
				if(val instanceof String) {
					setRechargeEnergySource((String)val);
				}
				saves.add("rechargeEnergySource");
				return val;
			} else if("refdevice".equals(varLower)) {
				if(val instanceof String) {
					setRefDevice((String)val);
				} else if(val instanceof JsonObject) {
					setRefDevice((JsonObject)val);
				}
				saves.add("refDevice");
				return val;
			} else if("refpointofinterest".equals(varLower)) {
				if(val instanceof String) {
					setRefPointOfInterest((String)val);
				} else if(val instanceof JsonObject) {
					setRefPointOfInterest((JsonObject)val);
				}
				saves.add("refPointOfInterest");
				return val;
			} else if("roundtripefficiency".equals(varLower)) {
				if(val instanceof String) {
					setRoundTripEfficiency((String)val);
				} else if(val instanceof Number) {
					setRoundTripEfficiency(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("roundTripEfficiency");
				return val;
			} else if("seealso".equals(varLower)) {
				if(val instanceof String) {
					setSeeAlso((String)val);
				} else if(val instanceof JsonObject) {
					setSeeAlso((JsonObject)val);
				}
				saves.add("seeAlso");
				return val;
			} else if("selfdischargerate".equals(varLower)) {
				if(val instanceof String) {
					setSelfDischargeRate((String)val);
				} else if(val instanceof Number) {
					setSelfDischargeRate(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("selfDischargeRate");
				return val;
			} else if("serialnumber".equals(varLower)) {
				if(val instanceof String) {
					setSerialNumber((String)val);
				}
				saves.add("serialNumber");
				return val;
			} else if("source".equals(varLower)) {
				if(val instanceof String) {
					setSource((String)val);
				}
				saves.add("source");
				return val;
			} else if("storableenergy".equals(varLower)) {
				if(val instanceof String) {
					setStorableEnergy((String)val);
				} else if(val instanceof Number) {
					setStorableEnergy(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("storableEnergy");
				return val;
			} else if("toolbms".equals(varLower)) {
				if(val instanceof Boolean) {
					setToolBMS((Boolean)val);
				} else {
					setToolBMS(val == null ? null : val.toString());
				}
				saves.add("toolBMS");
				return val;
			} else if("typeenergysource".equals(varLower)) {
				if(val instanceof String) {
					setTypeEnergySource((String)val);
				} else if(val instanceof JsonObject) {
					setTypeEnergySource((JsonObject)val);
				}
				saves.add("typeEnergySource");
				return val;
			} else if("typeofuse".equals(varLower)) {
				if(val instanceof String) {
					setTypeOfUse((String)val);
				}
				saves.add("typeOfUse");
				return val;
			} else if("usableenergy".equals(varLower)) {
				if(val instanceof String) {
					setUsableEnergy((String)val);
				} else if(val instanceof Number) {
					setUsableEnergy(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("usableEnergy");
				return val;
			} else if("volenergydensity".equals(varLower)) {
				if(val instanceof String) {
					setVolEnergyDensity((String)val);
				} else if(val instanceof JsonObject) {
					setVolEnergyDensity((JsonObject)val);
				}
				saves.add("volEnergyDensity");
				return val;
			} else if("weight".equals(varLower)) {
				if(val instanceof String) {
					setWeight((String)val);
				} else if(val instanceof Number) {
					setWeight(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("weight");
				return val;
		} else {
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateStorageBatteryDevice(doc);
	}
	public void populateStorageBatteryDevice(SolrResponse.Doc doc) {
		StorageBatteryDevice oStorageBatteryDevice = (StorageBatteryDevice)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oStorageBatteryDevice.setAddress(address);
			}

			if(saves.contains("alternateName")) {
				String alternateName = (String)doc.get("alternateName_docvalues_string");
				if(alternateName != null)
					oStorageBatteryDevice.setAlternateName(alternateName);
			}

			if(saves.contains("application")) {
				String application = (String)doc.get("application_docvalues_string");
				if(application != null)
					oStorageBatteryDevice.setApplication(application);
			}

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null)
					oStorageBatteryDevice.areaServedColors.addAll(areaServedColors);
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null)
					oStorageBatteryDevice.areaServedTitles.addAll(areaServedTitles);
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null)
					oStorageBatteryDevice.areaServedLinks.addAll(areaServedLinks);
			}

			if(saves.contains("areaServed")) {
				Path areaServed = (Path)doc.get("areaServed_docvalues_location");
				if(areaServed != null)
					oStorageBatteryDevice.setAreaServed(areaServed);
			}

			if(saves.contains("averageLife")) {
				Double averageLife = (Double)doc.get("averageLife_docvalues_double");
				if(averageLife != null)
					oStorageBatteryDevice.setAverageLife(averageLife);
			}

			if(saves.contains("batteryAssessmentMethods")) {
				String batteryAssessmentMethods = (String)doc.get("batteryAssessmentMethods_docvalues_string");
				if(batteryAssessmentMethods != null)
					oStorageBatteryDevice.setBatteryAssessmentMethods(batteryAssessmentMethods);
			}

			if(saves.contains("batteryType")) {
				String batteryType = (String)doc.get("batteryType_docvalues_string");
				if(batteryType != null)
					oStorageBatteryDevice.setBatteryType(batteryType);
			}

			if(saves.contains("brandName")) {
				String brandName = (String)doc.get("brandName_docvalues_string");
				if(brandName != null)
					oStorageBatteryDevice.setBrandName(brandName);
			}

			if(saves.contains("capacityCnnn")) {
				String capacityCnnn = (String)doc.get("capacityCnnn_docvalues_string");
				if(capacityCnnn != null)
					oStorageBatteryDevice.setCapacityCnnn(capacityCnnn);
			}

			if(saves.contains("chargeDischargeReactivity")) {
				Double chargeDischargeReactivity = (Double)doc.get("chargeDischargeReactivity_docvalues_double");
				if(chargeDischargeReactivity != null)
					oStorageBatteryDevice.setChargeDischargeReactivity(chargeDischargeReactivity);
			}

			if(saves.contains("chargeEfficiency")) {
				Double chargeEfficiency = (Double)doc.get("chargeEfficiency_docvalues_double");
				if(chargeEfficiency != null)
					oStorageBatteryDevice.setChargeEfficiency(chargeEfficiency);
			}

			if(saves.contains("chargePower")) {
				Double chargePower = (Double)doc.get("chargePower_docvalues_double");
				if(chargePower != null)
					oStorageBatteryDevice.setChargePower(chargePower);
			}

			if(saves.contains("chargingModeAllowed")) {
				String chargingModeAllowed = (String)doc.get("chargingModeAllowed_docvalues_string");
				if(chargingModeAllowed != null)
					oStorageBatteryDevice.setChargingModeAllowed(chargingModeAllowed);
			}

			if(saves.contains("communication")) {
				String communication = (String)doc.get("communication_docvalues_string");
				if(communication != null)
					oStorageBatteryDevice.setCommunication(communication);
			}

			if(saves.contains("dataProvider")) {
				String dataProvider = (String)doc.get("dataProvider_docvalues_string");
				if(dataProvider != null)
					oStorageBatteryDevice.setDataProvider(dataProvider);
			}

			if(saves.contains("dateCreated")) {
				String dateCreated = (String)doc.get("dateCreated_docvalues_string");
				if(dateCreated != null)
					oStorageBatteryDevice.setDateCreated(dateCreated);
			}

			if(saves.contains("dateLastReported")) {
				String dateLastReported = (String)doc.get("dateLastReported_docvalues_string");
				if(dateLastReported != null)
					oStorageBatteryDevice.setDateLastReported(dateLastReported);
			}

			if(saves.contains("dateModified")) {
				String dateModified = (String)doc.get("dateModified_docvalues_string");
				if(dateModified != null)
					oStorageBatteryDevice.setDateModified(dateModified);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oStorageBatteryDevice.setDescription(description);
			}

			if(saves.contains("dimension")) {
				String dimension = (String)doc.get("dimension_docvalues_string");
				if(dimension != null)
					oStorageBatteryDevice.setDimension(dimension);
			}

			if(saves.contains("dischargeEfficiency")) {
				Double dischargeEfficiency = (Double)doc.get("dischargeEfficiency_docvalues_double");
				if(dischargeEfficiency != null)
					oStorageBatteryDevice.setDischargeEfficiency(dischargeEfficiency);
			}

			if(saves.contains("dischargePower")) {
				Double dischargePower = (Double)doc.get("dischargePower_docvalues_double");
				if(dischargePower != null)
					oStorageBatteryDevice.setDischargePower(dischargePower);
			}

			if(saves.contains("documentation")) {
				String documentation = (String)doc.get("documentation_docvalues_string");
				if(documentation != null)
					oStorageBatteryDevice.setDocumentation(documentation);
			}

			if(saves.contains("durationPeakPower")) {
				Double durationPeakPower = (Double)doc.get("durationPeakPower_docvalues_double");
				if(durationPeakPower != null)
					oStorageBatteryDevice.setDurationPeakPower(durationPeakPower);
			}

			if(saves.contains("installationCondition")) {
				String installationCondition = (String)doc.get("installationCondition_docvalues_string");
				if(installationCondition != null)
					oStorageBatteryDevice.setInstallationCondition(installationCondition);
			}

			if(saves.contains("installationMode")) {
				String installationMode = (String)doc.get("installationMode_docvalues_string");
				if(installationMode != null)
					oStorageBatteryDevice.setInstallationMode(installationMode);
			}

			if(saves.contains("lifeCycleNumber")) {
				String lifeCycleNumber = (String)doc.get("lifeCycleNumber_docvalues_string");
				if(lifeCycleNumber != null)
					oStorageBatteryDevice.setLifeCycleNumber(lifeCycleNumber);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oStorageBatteryDevice.setLocation(location);
			}

			if(saves.contains("manufacturerName")) {
				String manufacturerName = (String)doc.get("manufacturerName_docvalues_string");
				if(manufacturerName != null)
					oStorageBatteryDevice.setManufacturerName(manufacturerName);
			}

			if(saves.contains("massEnergyDensity")) {
				String massEnergyDensity = (String)doc.get("massEnergyDensity_docvalues_string");
				if(massEnergyDensity != null)
					oStorageBatteryDevice.setMassEnergyDensity(massEnergyDensity);
			}

			if(saves.contains("maxOutputPower")) {
				Double maxOutputPower = (Double)doc.get("maxOutputPower_docvalues_double");
				if(maxOutputPower != null)
					oStorageBatteryDevice.setMaxOutputPower(maxOutputPower);
			}

			if(saves.contains("maximumVoltageEOC")) {
				Double maximumVoltageEOC = (Double)doc.get("maximumVoltageEOC_docvalues_double");
				if(maximumVoltageEOC != null)
					oStorageBatteryDevice.setMaximumVoltageEOC(maximumVoltageEOC);
			}

			if(saves.contains("minimumVoltageEOD")) {
				Double minimumVoltageEOD = (Double)doc.get("minimumVoltageEOD_docvalues_double");
				if(minimumVoltageEOD != null)
					oStorageBatteryDevice.setMinimumVoltageEOD(minimumVoltageEOD);
			}

			if(saves.contains("modelName")) {
				String modelName = (String)doc.get("modelName_docvalues_string");
				if(modelName != null)
					oStorageBatteryDevice.setModelName(modelName);
			}

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oStorageBatteryDevice.setName(name);
			}

			if(saves.contains("nominalAmpere")) {
				Double nominalAmpere = (Double)doc.get("nominalAmpere_docvalues_double");
				if(nominalAmpere != null)
					oStorageBatteryDevice.setNominalAmpere(nominalAmpere);
			}

			if(saves.contains("nominalCapacity")) {
				Double nominalCapacity = (Double)doc.get("nominalCapacity_docvalues_double");
				if(nominalCapacity != null)
					oStorageBatteryDevice.setNominalCapacity(nominalCapacity);
			}

			if(saves.contains("nominalFrequency")) {
				Double nominalFrequency = (Double)doc.get("nominalFrequency_docvalues_double");
				if(nominalFrequency != null)
					oStorageBatteryDevice.setNominalFrequency(nominalFrequency);
			}

			if(saves.contains("nominalVoltage")) {
				Double nominalVoltage = (Double)doc.get("nominalVoltage_docvalues_double");
				if(nominalVoltage != null)
					oStorageBatteryDevice.setNominalVoltage(nominalVoltage);
			}

			if(saves.contains("operatingAltitude")) {
				String operatingAltitude = (String)doc.get("operatingAltitude_docvalues_string");
				if(operatingAltitude != null)
					oStorageBatteryDevice.setOperatingAltitude(operatingAltitude);
			}

			if(saves.contains("operatingAmpere")) {
				String operatingAmpere = (String)doc.get("operatingAmpere_docvalues_string");
				if(operatingAmpere != null)
					oStorageBatteryDevice.setOperatingAmpere(operatingAmpere);
			}

			if(saves.contains("operatingFrequency")) {
				String operatingFrequency = (String)doc.get("operatingFrequency_docvalues_string");
				if(operatingFrequency != null)
					oStorageBatteryDevice.setOperatingFrequency(operatingFrequency);
			}

			if(saves.contains("operatingTemperature")) {
				String operatingTemperature = (String)doc.get("operatingTemperature_docvalues_string");
				if(operatingTemperature != null)
					oStorageBatteryDevice.setOperatingTemperature(operatingTemperature);
			}

			if(saves.contains("operatingVoltage")) {
				String operatingVoltage = (String)doc.get("operatingVoltage_docvalues_string");
				if(operatingVoltage != null)
					oStorageBatteryDevice.setOperatingVoltage(operatingVoltage);
			}

			if(saves.contains("overloadAccepted")) {
				Boolean overloadAccepted = (Boolean)doc.get("overloadAccepted_docvalues_boolean");
				if(overloadAccepted != null)
					oStorageBatteryDevice.setOverloadAccepted(overloadAccepted);
			}

			if(saves.contains("overloadAcceptedTime")) {
				String overloadAcceptedTime = (String)doc.get("overloadAcceptedTime_docvalues_string");
				if(overloadAcceptedTime != null)
					oStorageBatteryDevice.setOverloadAcceptedTime(overloadAcceptedTime);
			}

			if(saves.contains("owner")) {
				String owner = (String)doc.get("owner_docvalues_string");
				if(owner != null)
					oStorageBatteryDevice.setOwner(owner);
			}

			if(saves.contains("peakPower")) {
				Double peakPower = (Double)doc.get("peakPower_docvalues_double");
				if(peakPower != null)
					oStorageBatteryDevice.setPeakPower(peakPower);
			}

			if(saves.contains("possibilityOfUse")) {
				String possibilityOfUse = (String)doc.get("possibilityOfUse_docvalues_string");
				if(possibilityOfUse != null)
					oStorageBatteryDevice.setPossibilityOfUse(possibilityOfUse);
			}

			if(saves.contains("protectionIK")) {
				Double protectionIK = (Double)doc.get("protectionIK_docvalues_double");
				if(protectionIK != null)
					oStorageBatteryDevice.setProtectionIK(protectionIK);
			}

			if(saves.contains("protectionIP")) {
				String protectionIP = (String)doc.get("protectionIP_docvalues_string");
				if(protectionIP != null)
					oStorageBatteryDevice.setProtectionIP(protectionIP);
			}

			if(saves.contains("rechargeEnergySource")) {
				String rechargeEnergySource = (String)doc.get("rechargeEnergySource_docvalues_string");
				if(rechargeEnergySource != null)
					oStorageBatteryDevice.setRechargeEnergySource(rechargeEnergySource);
			}

			if(saves.contains("refDevice")) {
				String refDevice = (String)doc.get("refDevice_docvalues_string");
				if(refDevice != null)
					oStorageBatteryDevice.setRefDevice(refDevice);
			}

			if(saves.contains("refPointOfInterest")) {
				String refPointOfInterest = (String)doc.get("refPointOfInterest_docvalues_string");
				if(refPointOfInterest != null)
					oStorageBatteryDevice.setRefPointOfInterest(refPointOfInterest);
			}

			if(saves.contains("roundTripEfficiency")) {
				Double roundTripEfficiency = (Double)doc.get("roundTripEfficiency_docvalues_double");
				if(roundTripEfficiency != null)
					oStorageBatteryDevice.setRoundTripEfficiency(roundTripEfficiency);
			}

			if(saves.contains("seeAlso")) {
				String seeAlso = (String)doc.get("seeAlso_docvalues_string");
				if(seeAlso != null)
					oStorageBatteryDevice.setSeeAlso(seeAlso);
			}

			if(saves.contains("selfDischargeRate")) {
				Double selfDischargeRate = (Double)doc.get("selfDischargeRate_docvalues_double");
				if(selfDischargeRate != null)
					oStorageBatteryDevice.setSelfDischargeRate(selfDischargeRate);
			}

			if(saves.contains("serialNumber")) {
				String serialNumber = (String)doc.get("serialNumber_docvalues_string");
				if(serialNumber != null)
					oStorageBatteryDevice.setSerialNumber(serialNumber);
			}

			if(saves.contains("source")) {
				String source = (String)doc.get("source_docvalues_string");
				if(source != null)
					oStorageBatteryDevice.setSource(source);
			}

			if(saves.contains("storableEnergy")) {
				Double storableEnergy = (Double)doc.get("storableEnergy_docvalues_double");
				if(storableEnergy != null)
					oStorageBatteryDevice.setStorableEnergy(storableEnergy);
			}

			if(saves.contains("toolBMS")) {
				Boolean toolBMS = (Boolean)doc.get("toolBMS_docvalues_boolean");
				if(toolBMS != null)
					oStorageBatteryDevice.setToolBMS(toolBMS);
			}

			if(saves.contains("typeEnergySource")) {
				String typeEnergySource = (String)doc.get("typeEnergySource_docvalues_string");
				if(typeEnergySource != null)
					oStorageBatteryDevice.setTypeEnergySource(typeEnergySource);
			}

			if(saves.contains("typeOfUse")) {
				String typeOfUse = (String)doc.get("typeOfUse_docvalues_string");
				if(typeOfUse != null)
					oStorageBatteryDevice.setTypeOfUse(typeOfUse);
			}

			if(saves.contains("usableEnergy")) {
				Double usableEnergy = (Double)doc.get("usableEnergy_docvalues_double");
				if(usableEnergy != null)
					oStorageBatteryDevice.setUsableEnergy(usableEnergy);
			}

			if(saves.contains("volEnergyDensity")) {
				String volEnergyDensity = (String)doc.get("volEnergyDensity_docvalues_string");
				if(volEnergyDensity != null)
					oStorageBatteryDevice.setVolEnergyDensity(volEnergyDensity);
			}

			if(saves.contains("weight")) {
				Double weight = (Double)doc.get("weight_docvalues_double");
				if(weight != null)
					oStorageBatteryDevice.setWeight(weight);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexStorageBatteryDevice(JsonObject doc) {
		if(address != null) {
			doc.put("address_docvalues_string", address.toString());
		}
		if(alternateName != null) {
			doc.put("alternateName_docvalues_string", alternateName);
		}
		if(application != null) {
			doc.put("application_docvalues_string", application.toString());
		}
		if(areaServedColors != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedColors_indexedstored_strings", l);
			for(String o : areaServedColors) {
				l.add(o);
			}
		}
		if(areaServedTitles != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedTitles_indexedstored_strings", l);
			for(String o : areaServedTitles) {
				l.add(o);
			}
		}
		if(areaServedLinks != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedLinks_indexedstored_strings", l);
			for(String o : areaServedLinks) {
				l.add(o);
			}
		}
		if(areaServed != null) {
			JsonArray pointsArray = new JsonArray();
			areaServed.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
			doc.put("areaServed_docvalues_location", new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString());
		}
		if(averageLife != null) {
			doc.put("averageLife_docvalues_double", averageLife.doubleValue());
		}
		if(batteryAssessmentMethods != null) {
			doc.put("batteryAssessmentMethods_docvalues_string", batteryAssessmentMethods);
		}
		if(batteryType != null) {
			doc.put("batteryType_docvalues_string", batteryType);
		}
		if(brandName != null) {
			doc.put("brandName_docvalues_string", brandName);
		}
		if(capacityCnnn != null) {
			doc.put("capacityCnnn_docvalues_string", capacityCnnn.toString());
		}
		if(chargeDischargeReactivity != null) {
			doc.put("chargeDischargeReactivity_docvalues_double", chargeDischargeReactivity.doubleValue());
		}
		if(chargeEfficiency != null) {
			doc.put("chargeEfficiency_docvalues_double", chargeEfficiency.doubleValue());
		}
		if(chargePower != null) {
			doc.put("chargePower_docvalues_double", chargePower.doubleValue());
		}
		if(chargingModeAllowed != null) {
			doc.put("chargingModeAllowed_docvalues_string", chargingModeAllowed.toString());
		}
		if(communication != null) {
			doc.put("communication_docvalues_string", communication.toString());
		}
		if(dataProvider != null) {
			doc.put("dataProvider_docvalues_string", dataProvider);
		}
		if(dateCreated != null) {
			doc.put("dateCreated_docvalues_string", dateCreated);
		}
		if(dateLastReported != null) {
			doc.put("dateLastReported_docvalues_string", dateLastReported);
		}
		if(dateModified != null) {
			doc.put("dateModified_docvalues_string", dateModified);
		}
		if(description != null) {
			doc.put("description_docvalues_string", description);
		}
		if(dimension != null) {
			doc.put("dimension_docvalues_string", dimension.toString());
		}
		if(dischargeEfficiency != null) {
			doc.put("dischargeEfficiency_docvalues_double", dischargeEfficiency.doubleValue());
		}
		if(dischargePower != null) {
			doc.put("dischargePower_docvalues_double", dischargePower.doubleValue());
		}
		if(documentation != null) {
			doc.put("documentation_docvalues_string", documentation);
		}
		if(durationPeakPower != null) {
			doc.put("durationPeakPower_docvalues_double", durationPeakPower.doubleValue());
		}
		if(installationCondition != null) {
			doc.put("installationCondition_docvalues_string", installationCondition.toString());
		}
		if(installationMode != null) {
			doc.put("installationMode_docvalues_string", installationMode);
		}
		if(lifeCycleNumber != null) {
			doc.put("lifeCycleNumber_docvalues_string", lifeCycleNumber.toString());
		}
		if(location != null) {
			doc.put("location_docvalues_location", String.format("%s,%s", location.getX(), location.getY()));
		}
		if(manufacturerName != null) {
			doc.put("manufacturerName_docvalues_string", manufacturerName);
		}
		if(massEnergyDensity != null) {
			doc.put("massEnergyDensity_docvalues_string", massEnergyDensity.toString());
		}
		if(maxOutputPower != null) {
			doc.put("maxOutputPower_docvalues_double", maxOutputPower.doubleValue());
		}
		if(maximumVoltageEOC != null) {
			doc.put("maximumVoltageEOC_docvalues_double", maximumVoltageEOC.doubleValue());
		}
		if(minimumVoltageEOD != null) {
			doc.put("minimumVoltageEOD_docvalues_double", minimumVoltageEOD.doubleValue());
		}
		if(modelName != null) {
			doc.put("modelName_docvalues_string", modelName);
		}
		if(name != null) {
			doc.put("name_docvalues_string", name);
		}
		if(nominalAmpere != null) {
			doc.put("nominalAmpere_docvalues_double", nominalAmpere.doubleValue());
		}
		if(nominalCapacity != null) {
			doc.put("nominalCapacity_docvalues_double", nominalCapacity.doubleValue());
		}
		if(nominalFrequency != null) {
			doc.put("nominalFrequency_docvalues_double", nominalFrequency.doubleValue());
		}
		if(nominalVoltage != null) {
			doc.put("nominalVoltage_docvalues_double", nominalVoltage.doubleValue());
		}
		if(operatingAltitude != null) {
			doc.put("operatingAltitude_docvalues_string", operatingAltitude.toString());
		}
		if(operatingAmpere != null) {
			doc.put("operatingAmpere_docvalues_string", operatingAmpere.toString());
		}
		if(operatingFrequency != null) {
			doc.put("operatingFrequency_docvalues_string", operatingFrequency.toString());
		}
		if(operatingTemperature != null) {
			doc.put("operatingTemperature_docvalues_string", operatingTemperature.toString());
		}
		if(operatingVoltage != null) {
			doc.put("operatingVoltage_docvalues_string", operatingVoltage.toString());
		}
		if(overloadAccepted != null) {
			doc.put("overloadAccepted_docvalues_boolean", overloadAccepted);
		}
		if(overloadAcceptedTime != null) {
			doc.put("overloadAcceptedTime_docvalues_string", overloadAcceptedTime);
		}
		if(owner != null) {
			doc.put("owner_docvalues_string", owner.toString());
		}
		if(peakPower != null) {
			doc.put("peakPower_docvalues_double", peakPower.doubleValue());
		}
		if(possibilityOfUse != null) {
			doc.put("possibilityOfUse_docvalues_string", possibilityOfUse);
		}
		if(protectionIK != null) {
			doc.put("protectionIK_docvalues_double", protectionIK.doubleValue());
		}
		if(protectionIP != null) {
			doc.put("protectionIP_docvalues_string", protectionIP);
		}
		if(rechargeEnergySource != null) {
			doc.put("rechargeEnergySource_docvalues_string", rechargeEnergySource);
		}
		if(refDevice != null) {
			doc.put("refDevice_docvalues_string", refDevice.toString());
		}
		if(refPointOfInterest != null) {
			doc.put("refPointOfInterest_docvalues_string", refPointOfInterest.toString());
		}
		if(roundTripEfficiency != null) {
			doc.put("roundTripEfficiency_docvalues_double", roundTripEfficiency.doubleValue());
		}
		if(seeAlso != null) {
			doc.put("seeAlso_docvalues_string", seeAlso.toString());
		}
		if(selfDischargeRate != null) {
			doc.put("selfDischargeRate_docvalues_double", selfDischargeRate.doubleValue());
		}
		if(serialNumber != null) {
			doc.put("serialNumber_docvalues_string", serialNumber);
		}
		if(source != null) {
			doc.put("source_docvalues_string", source);
		}
		if(storableEnergy != null) {
			doc.put("storableEnergy_docvalues_double", storableEnergy.doubleValue());
		}
		if(toolBMS != null) {
			doc.put("toolBMS_docvalues_boolean", toolBMS);
		}
		if(typeEnergySource != null) {
			doc.put("typeEnergySource_docvalues_string", typeEnergySource.toString());
		}
		if(typeOfUse != null) {
			doc.put("typeOfUse_docvalues_string", typeOfUse);
		}
		if(usableEnergy != null) {
			doc.put("usableEnergy_docvalues_double", usableEnergy.doubleValue());
		}
		if(volEnergyDensity != null) {
			doc.put("volEnergyDensity_docvalues_string", volEnergyDensity.toString());
		}
		if(weight != null) {
			doc.put("weight_docvalues_double", weight.doubleValue());
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredStorageBatteryDevice(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "application":
				return "application_docvalues_string";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_location";
			case "averageLife":
				return "averageLife_docvalues_double";
			case "batteryAssessmentMethods":
				return "batteryAssessmentMethods_docvalues_string";
			case "batteryType":
				return "batteryType_docvalues_string";
			case "brandName":
				return "brandName_docvalues_string";
			case "capacityCnnn":
				return "capacityCnnn_docvalues_string";
			case "chargeDischargeReactivity":
				return "chargeDischargeReactivity_docvalues_double";
			case "chargeEfficiency":
				return "chargeEfficiency_docvalues_double";
			case "chargePower":
				return "chargePower_docvalues_double";
			case "chargingModeAllowed":
				return "chargingModeAllowed_docvalues_string";
			case "communication":
				return "communication_docvalues_string";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateLastReported":
				return "dateLastReported_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "dimension":
				return "dimension_docvalues_string";
			case "dischargeEfficiency":
				return "dischargeEfficiency_docvalues_double";
			case "dischargePower":
				return "dischargePower_docvalues_double";
			case "documentation":
				return "documentation_docvalues_string";
			case "durationPeakPower":
				return "durationPeakPower_docvalues_double";
			case "installationCondition":
				return "installationCondition_docvalues_string";
			case "installationMode":
				return "installationMode_docvalues_string";
			case "lifeCycleNumber":
				return "lifeCycleNumber_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "manufacturerName":
				return "manufacturerName_docvalues_string";
			case "massEnergyDensity":
				return "massEnergyDensity_docvalues_string";
			case "maxOutputPower":
				return "maxOutputPower_docvalues_double";
			case "maximumVoltageEOC":
				return "maximumVoltageEOC_docvalues_double";
			case "minimumVoltageEOD":
				return "minimumVoltageEOD_docvalues_double";
			case "modelName":
				return "modelName_docvalues_string";
			case "name":
				return "name_docvalues_string";
			case "nominalAmpere":
				return "nominalAmpere_docvalues_double";
			case "nominalCapacity":
				return "nominalCapacity_docvalues_double";
			case "nominalFrequency":
				return "nominalFrequency_docvalues_double";
			case "nominalVoltage":
				return "nominalVoltage_docvalues_double";
			case "operatingAltitude":
				return "operatingAltitude_docvalues_string";
			case "operatingAmpere":
				return "operatingAmpere_docvalues_string";
			case "operatingFrequency":
				return "operatingFrequency_docvalues_string";
			case "operatingTemperature":
				return "operatingTemperature_docvalues_string";
			case "operatingVoltage":
				return "operatingVoltage_docvalues_string";
			case "overloadAccepted":
				return "overloadAccepted_docvalues_boolean";
			case "overloadAcceptedTime":
				return "overloadAcceptedTime_docvalues_string";
			case "owner":
				return "owner_docvalues_string";
			case "peakPower":
				return "peakPower_docvalues_double";
			case "possibilityOfUse":
				return "possibilityOfUse_docvalues_string";
			case "protectionIK":
				return "protectionIK_docvalues_double";
			case "protectionIP":
				return "protectionIP_docvalues_string";
			case "rechargeEnergySource":
				return "rechargeEnergySource_docvalues_string";
			case "refDevice":
				return "refDevice_docvalues_string";
			case "refPointOfInterest":
				return "refPointOfInterest_docvalues_string";
			case "roundTripEfficiency":
				return "roundTripEfficiency_docvalues_double";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "selfDischargeRate":
				return "selfDischargeRate_docvalues_double";
			case "serialNumber":
				return "serialNumber_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "storableEnergy":
				return "storableEnergy_docvalues_double";
			case "toolBMS":
				return "toolBMS_docvalues_boolean";
			case "typeEnergySource":
				return "typeEnergySource_docvalues_string";
			case "typeOfUse":
				return "typeOfUse_docvalues_string";
			case "usableEnergy":
				return "usableEnergy_docvalues_double";
			case "volEnergyDensity":
				return "volEnergyDensity_docvalues_string";
			case "weight":
				return "weight_docvalues_double";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedStorageBatteryDevice(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "application":
				return "application_docvalues_string";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_location";
			case "averageLife":
				return "averageLife_docvalues_double";
			case "batteryAssessmentMethods":
				return "batteryAssessmentMethods_docvalues_string";
			case "batteryType":
				return "batteryType_docvalues_string";
			case "brandName":
				return "brandName_docvalues_string";
			case "capacityCnnn":
				return "capacityCnnn_docvalues_string";
			case "chargeDischargeReactivity":
				return "chargeDischargeReactivity_docvalues_double";
			case "chargeEfficiency":
				return "chargeEfficiency_docvalues_double";
			case "chargePower":
				return "chargePower_docvalues_double";
			case "chargingModeAllowed":
				return "chargingModeAllowed_docvalues_string";
			case "communication":
				return "communication_docvalues_string";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateLastReported":
				return "dateLastReported_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "dimension":
				return "dimension_docvalues_string";
			case "dischargeEfficiency":
				return "dischargeEfficiency_docvalues_double";
			case "dischargePower":
				return "dischargePower_docvalues_double";
			case "documentation":
				return "documentation_docvalues_string";
			case "durationPeakPower":
				return "durationPeakPower_docvalues_double";
			case "installationCondition":
				return "installationCondition_docvalues_string";
			case "installationMode":
				return "installationMode_docvalues_string";
			case "lifeCycleNumber":
				return "lifeCycleNumber_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "manufacturerName":
				return "manufacturerName_docvalues_string";
			case "massEnergyDensity":
				return "massEnergyDensity_docvalues_string";
			case "maxOutputPower":
				return "maxOutputPower_docvalues_double";
			case "maximumVoltageEOC":
				return "maximumVoltageEOC_docvalues_double";
			case "minimumVoltageEOD":
				return "minimumVoltageEOD_docvalues_double";
			case "modelName":
				return "modelName_docvalues_string";
			case "name":
				return "name_docvalues_string";
			case "nominalAmpere":
				return "nominalAmpere_docvalues_double";
			case "nominalCapacity":
				return "nominalCapacity_docvalues_double";
			case "nominalFrequency":
				return "nominalFrequency_docvalues_double";
			case "nominalVoltage":
				return "nominalVoltage_docvalues_double";
			case "operatingAltitude":
				return "operatingAltitude_docvalues_string";
			case "operatingAmpere":
				return "operatingAmpere_docvalues_string";
			case "operatingFrequency":
				return "operatingFrequency_docvalues_string";
			case "operatingTemperature":
				return "operatingTemperature_docvalues_string";
			case "operatingVoltage":
				return "operatingVoltage_docvalues_string";
			case "overloadAccepted":
				return "overloadAccepted_docvalues_boolean";
			case "overloadAcceptedTime":
				return "overloadAcceptedTime_docvalues_string";
			case "owner":
				return "owner_docvalues_string";
			case "peakPower":
				return "peakPower_docvalues_double";
			case "possibilityOfUse":
				return "possibilityOfUse_docvalues_string";
			case "protectionIK":
				return "protectionIK_docvalues_double";
			case "protectionIP":
				return "protectionIP_docvalues_string";
			case "rechargeEnergySource":
				return "rechargeEnergySource_docvalues_string";
			case "refDevice":
				return "refDevice_docvalues_string";
			case "refPointOfInterest":
				return "refPointOfInterest_docvalues_string";
			case "roundTripEfficiency":
				return "roundTripEfficiency_docvalues_double";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "selfDischargeRate":
				return "selfDischargeRate_docvalues_double";
			case "serialNumber":
				return "serialNumber_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "storableEnergy":
				return "storableEnergy_docvalues_double";
			case "toolBMS":
				return "toolBMS_docvalues_boolean";
			case "typeEnergySource":
				return "typeEnergySource_docvalues_string";
			case "typeOfUse":
				return "typeOfUse_docvalues_string";
			case "usableEnergy":
				return "usableEnergy_docvalues_double";
			case "volEnergyDensity":
				return "volEnergyDensity_docvalues_string";
			case "weight":
				return "weight_docvalues_double";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarStorageBatteryDevice(String searchVar) {
		switch(searchVar) {
			case "address_docvalues_string":
				return "address";
			case "alternateName_docvalues_string":
				return "alternateName";
			case "application_docvalues_string":
				return "application";
			case "areaServedColors_indexedstored_strings":
				return "areaServedColors";
			case "areaServedTitles_indexedstored_strings":
				return "areaServedTitles";
			case "areaServedLinks_indexedstored_strings":
				return "areaServedLinks";
			case "areaServed_docvalues_location":
				return "areaServed";
			case "averageLife_docvalues_double":
				return "averageLife";
			case "batteryAssessmentMethods_docvalues_string":
				return "batteryAssessmentMethods";
			case "batteryType_docvalues_string":
				return "batteryType";
			case "brandName_docvalues_string":
				return "brandName";
			case "capacityCnnn_docvalues_string":
				return "capacityCnnn";
			case "chargeDischargeReactivity_docvalues_double":
				return "chargeDischargeReactivity";
			case "chargeEfficiency_docvalues_double":
				return "chargeEfficiency";
			case "chargePower_docvalues_double":
				return "chargePower";
			case "chargingModeAllowed_docvalues_string":
				return "chargingModeAllowed";
			case "communication_docvalues_string":
				return "communication";
			case "dataProvider_docvalues_string":
				return "dataProvider";
			case "dateCreated_docvalues_string":
				return "dateCreated";
			case "dateLastReported_docvalues_string":
				return "dateLastReported";
			case "dateModified_docvalues_string":
				return "dateModified";
			case "description_docvalues_string":
				return "description";
			case "dimension_docvalues_string":
				return "dimension";
			case "dischargeEfficiency_docvalues_double":
				return "dischargeEfficiency";
			case "dischargePower_docvalues_double":
				return "dischargePower";
			case "documentation_docvalues_string":
				return "documentation";
			case "durationPeakPower_docvalues_double":
				return "durationPeakPower";
			case "installationCondition_docvalues_string":
				return "installationCondition";
			case "installationMode_docvalues_string":
				return "installationMode";
			case "lifeCycleNumber_docvalues_string":
				return "lifeCycleNumber";
			case "location_docvalues_location":
				return "location";
			case "manufacturerName_docvalues_string":
				return "manufacturerName";
			case "massEnergyDensity_docvalues_string":
				return "massEnergyDensity";
			case "maxOutputPower_docvalues_double":
				return "maxOutputPower";
			case "maximumVoltageEOC_docvalues_double":
				return "maximumVoltageEOC";
			case "minimumVoltageEOD_docvalues_double":
				return "minimumVoltageEOD";
			case "modelName_docvalues_string":
				return "modelName";
			case "name_docvalues_string":
				return "name";
			case "nominalAmpere_docvalues_double":
				return "nominalAmpere";
			case "nominalCapacity_docvalues_double":
				return "nominalCapacity";
			case "nominalFrequency_docvalues_double":
				return "nominalFrequency";
			case "nominalVoltage_docvalues_double":
				return "nominalVoltage";
			case "operatingAltitude_docvalues_string":
				return "operatingAltitude";
			case "operatingAmpere_docvalues_string":
				return "operatingAmpere";
			case "operatingFrequency_docvalues_string":
				return "operatingFrequency";
			case "operatingTemperature_docvalues_string":
				return "operatingTemperature";
			case "operatingVoltage_docvalues_string":
				return "operatingVoltage";
			case "overloadAccepted_docvalues_boolean":
				return "overloadAccepted";
			case "overloadAcceptedTime_docvalues_string":
				return "overloadAcceptedTime";
			case "owner_docvalues_string":
				return "owner";
			case "peakPower_docvalues_double":
				return "peakPower";
			case "possibilityOfUse_docvalues_string":
				return "possibilityOfUse";
			case "protectionIK_docvalues_double":
				return "protectionIK";
			case "protectionIP_docvalues_string":
				return "protectionIP";
			case "rechargeEnergySource_docvalues_string":
				return "rechargeEnergySource";
			case "refDevice_docvalues_string":
				return "refDevice";
			case "refPointOfInterest_docvalues_string":
				return "refPointOfInterest";
			case "roundTripEfficiency_docvalues_double":
				return "roundTripEfficiency";
			case "seeAlso_docvalues_string":
				return "seeAlso";
			case "selfDischargeRate_docvalues_double":
				return "selfDischargeRate";
			case "serialNumber_docvalues_string":
				return "serialNumber";
			case "source_docvalues_string":
				return "source";
			case "storableEnergy_docvalues_double":
				return "storableEnergy";
			case "toolBMS_docvalues_boolean":
				return "toolBMS";
			case "typeEnergySource_docvalues_string":
				return "typeEnergySource";
			case "typeOfUse_docvalues_string":
				return "typeOfUse";
			case "usableEnergy_docvalues_double":
				return "usableEnergy";
			case "volEnergyDensity_docvalues_string":
				return "volEnergyDensity";
			case "weight_docvalues_double":
				return "weight";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchStorageBatteryDevice(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedStorageBatteryDevice(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeStorageBatteryDevice(doc);
	}
	public void storeStorageBatteryDevice(SolrResponse.Doc doc) {
		StorageBatteryDevice oStorageBatteryDevice = (StorageBatteryDevice)this;
		SiteRequestEnUS siteRequest = oStorageBatteryDevice.getSiteRequest_();

		oStorageBatteryDevice.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setApplication(Optional.ofNullable(doc.get("application_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oStorageBatteryDevice.addAreaServedColors(StorageBatteryDevice.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oStorageBatteryDevice.addAreaServedTitles(StorageBatteryDevice.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oStorageBatteryDevice.addAreaServedLinks(StorageBatteryDevice.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		oStorageBatteryDevice.setAreaServed(Optional.ofNullable(doc.get("areaServed_docvalues_location")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setAverageLife(Optional.ofNullable(doc.get("averageLife_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setBatteryAssessmentMethods(Optional.ofNullable(doc.get("batteryAssessmentMethods_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setBatteryType(Optional.ofNullable(doc.get("batteryType_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setBrandName(Optional.ofNullable(doc.get("brandName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setCapacityCnnn(Optional.ofNullable(doc.get("capacityCnnn_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setChargeDischargeReactivity(Optional.ofNullable(doc.get("chargeDischargeReactivity_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setChargeEfficiency(Optional.ofNullable(doc.get("chargeEfficiency_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setChargePower(Optional.ofNullable(doc.get("chargePower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setChargingModeAllowed(Optional.ofNullable(doc.get("chargingModeAllowed_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setCommunication(Optional.ofNullable(doc.get("communication_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDateLastReported(Optional.ofNullable(doc.get("dateLastReported_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDimension(Optional.ofNullable(doc.get("dimension_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDischargeEfficiency(Optional.ofNullable(doc.get("dischargeEfficiency_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDischargePower(Optional.ofNullable(doc.get("dischargePower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDocumentation(Optional.ofNullable(doc.get("documentation_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setDurationPeakPower(Optional.ofNullable(doc.get("durationPeakPower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setInstallationCondition(Optional.ofNullable(doc.get("installationCondition_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setInstallationMode(Optional.ofNullable(doc.get("installationMode_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setLifeCycleNumber(Optional.ofNullable(doc.get("lifeCycleNumber_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setManufacturerName(Optional.ofNullable(doc.get("manufacturerName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setMassEnergyDensity(Optional.ofNullable(doc.get("massEnergyDensity_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setMaxOutputPower(Optional.ofNullable(doc.get("maxOutputPower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setMaximumVoltageEOC(Optional.ofNullable(doc.get("maximumVoltageEOC_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setMinimumVoltageEOD(Optional.ofNullable(doc.get("minimumVoltageEOD_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setModelName(Optional.ofNullable(doc.get("modelName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setNominalAmpere(Optional.ofNullable(doc.get("nominalAmpere_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setNominalCapacity(Optional.ofNullable(doc.get("nominalCapacity_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setNominalFrequency(Optional.ofNullable(doc.get("nominalFrequency_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setNominalVoltage(Optional.ofNullable(doc.get("nominalVoltage_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOperatingAltitude(Optional.ofNullable(doc.get("operatingAltitude_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOperatingAmpere(Optional.ofNullable(doc.get("operatingAmpere_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOperatingFrequency(Optional.ofNullable(doc.get("operatingFrequency_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOperatingTemperature(Optional.ofNullable(doc.get("operatingTemperature_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOperatingVoltage(Optional.ofNullable(doc.get("operatingVoltage_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOverloadAccepted(Optional.ofNullable(doc.get("overloadAccepted_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOverloadAcceptedTime(Optional.ofNullable(doc.get("overloadAcceptedTime_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setPeakPower(Optional.ofNullable(doc.get("peakPower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setPossibilityOfUse(Optional.ofNullable(doc.get("possibilityOfUse_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setProtectionIK(Optional.ofNullable(doc.get("protectionIK_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setProtectionIP(Optional.ofNullable(doc.get("protectionIP_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setRechargeEnergySource(Optional.ofNullable(doc.get("rechargeEnergySource_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setRefDevice(Optional.ofNullable(doc.get("refDevice_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setRefPointOfInterest(Optional.ofNullable(doc.get("refPointOfInterest_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setRoundTripEfficiency(Optional.ofNullable(doc.get("roundTripEfficiency_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setSelfDischargeRate(Optional.ofNullable(doc.get("selfDischargeRate_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setSerialNumber(Optional.ofNullable(doc.get("serialNumber_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setStorableEnergy(Optional.ofNullable(doc.get("storableEnergy_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setToolBMS(Optional.ofNullable(doc.get("toolBMS_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setTypeEnergySource(Optional.ofNullable(doc.get("typeEnergySource_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setTypeOfUse(Optional.ofNullable(doc.get("typeOfUse_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setUsableEnergy(Optional.ofNullable(doc.get("usableEnergy_docvalues_double")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setVolEnergyDensity(Optional.ofNullable(doc.get("volEnergyDensity_docvalues_string")).map(v -> v.toString()).orElse(null));
		oStorageBatteryDevice.setWeight(Optional.ofNullable(doc.get("weight_docvalues_double")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestStorageBatteryDevice() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof StorageBatteryDevice) {
			StorageBatteryDevice original = (StorageBatteryDevice)o;
			if(!Objects.equals(address, original.getAddress()))
				apiRequest.addVars("address");
			if(!Objects.equals(alternateName, original.getAlternateName()))
				apiRequest.addVars("alternateName");
			if(!Objects.equals(application, original.getApplication()))
				apiRequest.addVars("application");
			if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
				apiRequest.addVars("areaServedColors");
			if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
				apiRequest.addVars("areaServedTitles");
			if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
				apiRequest.addVars("areaServedLinks");
			if(!Objects.equals(areaServed, original.getAreaServed()))
				apiRequest.addVars("areaServed");
			if(!Objects.equals(averageLife, original.getAverageLife()) && averageLife != null && original.getAverageLife() != null && averageLife.compareTo(original.getAverageLife()) != 0)
				apiRequest.addVars("averageLife");
			if(!Objects.equals(batteryAssessmentMethods, original.getBatteryAssessmentMethods()))
				apiRequest.addVars("batteryAssessmentMethods");
			if(!Objects.equals(batteryType, original.getBatteryType()))
				apiRequest.addVars("batteryType");
			if(!Objects.equals(brandName, original.getBrandName()))
				apiRequest.addVars("brandName");
			if(!Objects.equals(capacityCnnn, original.getCapacityCnnn()))
				apiRequest.addVars("capacityCnnn");
			if(!Objects.equals(chargeDischargeReactivity, original.getChargeDischargeReactivity()) && chargeDischargeReactivity != null && original.getChargeDischargeReactivity() != null && chargeDischargeReactivity.compareTo(original.getChargeDischargeReactivity()) != 0)
				apiRequest.addVars("chargeDischargeReactivity");
			if(!Objects.equals(chargeEfficiency, original.getChargeEfficiency()) && chargeEfficiency != null && original.getChargeEfficiency() != null && chargeEfficiency.compareTo(original.getChargeEfficiency()) != 0)
				apiRequest.addVars("chargeEfficiency");
			if(!Objects.equals(chargePower, original.getChargePower()) && chargePower != null && original.getChargePower() != null && chargePower.compareTo(original.getChargePower()) != 0)
				apiRequest.addVars("chargePower");
			if(!Objects.equals(chargingModeAllowed, original.getChargingModeAllowed()))
				apiRequest.addVars("chargingModeAllowed");
			if(!Objects.equals(communication, original.getCommunication()))
				apiRequest.addVars("communication");
			if(!Objects.equals(dataProvider, original.getDataProvider()))
				apiRequest.addVars("dataProvider");
			if(!Objects.equals(dateCreated, original.getDateCreated()))
				apiRequest.addVars("dateCreated");
			if(!Objects.equals(dateLastReported, original.getDateLastReported()))
				apiRequest.addVars("dateLastReported");
			if(!Objects.equals(dateModified, original.getDateModified()))
				apiRequest.addVars("dateModified");
			if(!Objects.equals(description, original.getDescription()))
				apiRequest.addVars("description");
			if(!Objects.equals(dimension, original.getDimension()))
				apiRequest.addVars("dimension");
			if(!Objects.equals(dischargeEfficiency, original.getDischargeEfficiency()) && dischargeEfficiency != null && original.getDischargeEfficiency() != null && dischargeEfficiency.compareTo(original.getDischargeEfficiency()) != 0)
				apiRequest.addVars("dischargeEfficiency");
			if(!Objects.equals(dischargePower, original.getDischargePower()) && dischargePower != null && original.getDischargePower() != null && dischargePower.compareTo(original.getDischargePower()) != 0)
				apiRequest.addVars("dischargePower");
			if(!Objects.equals(documentation, original.getDocumentation()))
				apiRequest.addVars("documentation");
			if(!Objects.equals(durationPeakPower, original.getDurationPeakPower()) && durationPeakPower != null && original.getDurationPeakPower() != null && durationPeakPower.compareTo(original.getDurationPeakPower()) != 0)
				apiRequest.addVars("durationPeakPower");
			if(!Objects.equals(installationCondition, original.getInstallationCondition()))
				apiRequest.addVars("installationCondition");
			if(!Objects.equals(installationMode, original.getInstallationMode()))
				apiRequest.addVars("installationMode");
			if(!Objects.equals(lifeCycleNumber, original.getLifeCycleNumber()))
				apiRequest.addVars("lifeCycleNumber");
			if(!Objects.equals(location, original.getLocation()))
				apiRequest.addVars("location");
			if(!Objects.equals(manufacturerName, original.getManufacturerName()))
				apiRequest.addVars("manufacturerName");
			if(!Objects.equals(massEnergyDensity, original.getMassEnergyDensity()))
				apiRequest.addVars("massEnergyDensity");
			if(!Objects.equals(maxOutputPower, original.getMaxOutputPower()) && maxOutputPower != null && original.getMaxOutputPower() != null && maxOutputPower.compareTo(original.getMaxOutputPower()) != 0)
				apiRequest.addVars("maxOutputPower");
			if(!Objects.equals(maximumVoltageEOC, original.getMaximumVoltageEOC()) && maximumVoltageEOC != null && original.getMaximumVoltageEOC() != null && maximumVoltageEOC.compareTo(original.getMaximumVoltageEOC()) != 0)
				apiRequest.addVars("maximumVoltageEOC");
			if(!Objects.equals(minimumVoltageEOD, original.getMinimumVoltageEOD()) && minimumVoltageEOD != null && original.getMinimumVoltageEOD() != null && minimumVoltageEOD.compareTo(original.getMinimumVoltageEOD()) != 0)
				apiRequest.addVars("minimumVoltageEOD");
			if(!Objects.equals(modelName, original.getModelName()))
				apiRequest.addVars("modelName");
			if(!Objects.equals(name, original.getName()))
				apiRequest.addVars("name");
			if(!Objects.equals(nominalAmpere, original.getNominalAmpere()) && nominalAmpere != null && original.getNominalAmpere() != null && nominalAmpere.compareTo(original.getNominalAmpere()) != 0)
				apiRequest.addVars("nominalAmpere");
			if(!Objects.equals(nominalCapacity, original.getNominalCapacity()) && nominalCapacity != null && original.getNominalCapacity() != null && nominalCapacity.compareTo(original.getNominalCapacity()) != 0)
				apiRequest.addVars("nominalCapacity");
			if(!Objects.equals(nominalFrequency, original.getNominalFrequency()) && nominalFrequency != null && original.getNominalFrequency() != null && nominalFrequency.compareTo(original.getNominalFrequency()) != 0)
				apiRequest.addVars("nominalFrequency");
			if(!Objects.equals(nominalVoltage, original.getNominalVoltage()) && nominalVoltage != null && original.getNominalVoltage() != null && nominalVoltage.compareTo(original.getNominalVoltage()) != 0)
				apiRequest.addVars("nominalVoltage");
			if(!Objects.equals(operatingAltitude, original.getOperatingAltitude()))
				apiRequest.addVars("operatingAltitude");
			if(!Objects.equals(operatingAmpere, original.getOperatingAmpere()))
				apiRequest.addVars("operatingAmpere");
			if(!Objects.equals(operatingFrequency, original.getOperatingFrequency()))
				apiRequest.addVars("operatingFrequency");
			if(!Objects.equals(operatingTemperature, original.getOperatingTemperature()))
				apiRequest.addVars("operatingTemperature");
			if(!Objects.equals(operatingVoltage, original.getOperatingVoltage()))
				apiRequest.addVars("operatingVoltage");
			if(!Objects.equals(overloadAccepted, original.getOverloadAccepted()))
				apiRequest.addVars("overloadAccepted");
			if(!Objects.equals(overloadAcceptedTime, original.getOverloadAcceptedTime()))
				apiRequest.addVars("overloadAcceptedTime");
			if(!Objects.equals(owner, original.getOwner()))
				apiRequest.addVars("owner");
			if(!Objects.equals(peakPower, original.getPeakPower()) && peakPower != null && original.getPeakPower() != null && peakPower.compareTo(original.getPeakPower()) != 0)
				apiRequest.addVars("peakPower");
			if(!Objects.equals(possibilityOfUse, original.getPossibilityOfUse()))
				apiRequest.addVars("possibilityOfUse");
			if(!Objects.equals(protectionIK, original.getProtectionIK()) && protectionIK != null && original.getProtectionIK() != null && protectionIK.compareTo(original.getProtectionIK()) != 0)
				apiRequest.addVars("protectionIK");
			if(!Objects.equals(protectionIP, original.getProtectionIP()))
				apiRequest.addVars("protectionIP");
			if(!Objects.equals(rechargeEnergySource, original.getRechargeEnergySource()))
				apiRequest.addVars("rechargeEnergySource");
			if(!Objects.equals(refDevice, original.getRefDevice()))
				apiRequest.addVars("refDevice");
			if(!Objects.equals(refPointOfInterest, original.getRefPointOfInterest()))
				apiRequest.addVars("refPointOfInterest");
			if(!Objects.equals(roundTripEfficiency, original.getRoundTripEfficiency()) && roundTripEfficiency != null && original.getRoundTripEfficiency() != null && roundTripEfficiency.compareTo(original.getRoundTripEfficiency()) != 0)
				apiRequest.addVars("roundTripEfficiency");
			if(!Objects.equals(seeAlso, original.getSeeAlso()))
				apiRequest.addVars("seeAlso");
			if(!Objects.equals(selfDischargeRate, original.getSelfDischargeRate()) && selfDischargeRate != null && original.getSelfDischargeRate() != null && selfDischargeRate.compareTo(original.getSelfDischargeRate()) != 0)
				apiRequest.addVars("selfDischargeRate");
			if(!Objects.equals(serialNumber, original.getSerialNumber()))
				apiRequest.addVars("serialNumber");
			if(!Objects.equals(source, original.getSource()))
				apiRequest.addVars("source");
			if(!Objects.equals(storableEnergy, original.getStorableEnergy()) && storableEnergy != null && original.getStorableEnergy() != null && storableEnergy.compareTo(original.getStorableEnergy()) != 0)
				apiRequest.addVars("storableEnergy");
			if(!Objects.equals(toolBMS, original.getToolBMS()))
				apiRequest.addVars("toolBMS");
			if(!Objects.equals(typeEnergySource, original.getTypeEnergySource()))
				apiRequest.addVars("typeEnergySource");
			if(!Objects.equals(typeOfUse, original.getTypeOfUse()))
				apiRequest.addVars("typeOfUse");
			if(!Objects.equals(usableEnergy, original.getUsableEnergy()) && usableEnergy != null && original.getUsableEnergy() != null && usableEnergy.compareTo(original.getUsableEnergy()) != 0)
				apiRequest.addVars("usableEnergy");
			if(!Objects.equals(volEnergyDensity, original.getVolEnergyDensity()))
				apiRequest.addVars("volEnergyDensity");
			if(!Objects.equals(weight, original.getWeight()) && weight != null && original.getWeight() != null && weight.compareTo(original.getWeight()) != 0)
				apiRequest.addVars("weight");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(application).map(v -> "application: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageLife).map(v -> "averageLife: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(batteryAssessmentMethods).map(v -> "batteryAssessmentMethods: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(batteryType).map(v -> "batteryType: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(brandName).map(v -> "brandName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(capacityCnnn).map(v -> "capacityCnnn: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(chargeDischargeReactivity).map(v -> "chargeDischargeReactivity: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(chargeEfficiency).map(v -> "chargeEfficiency: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(chargePower).map(v -> "chargePower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(chargingModeAllowed).map(v -> "chargingModeAllowed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(communication).map(v -> "communication: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateLastReported).map(v -> "dateLastReported: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dimension).map(v -> "dimension: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dischargeEfficiency).map(v -> "dischargeEfficiency: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dischargePower).map(v -> "dischargePower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(documentation).map(v -> "documentation: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(durationPeakPower).map(v -> "durationPeakPower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(installationCondition).map(v -> "installationCondition: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(installationMode).map(v -> "installationMode: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(lifeCycleNumber).map(v -> "lifeCycleNumber: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(manufacturerName).map(v -> "manufacturerName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(massEnergyDensity).map(v -> "massEnergyDensity: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(maxOutputPower).map(v -> "maxOutputPower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(maximumVoltageEOC).map(v -> "maximumVoltageEOC: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(minimumVoltageEOD).map(v -> "minimumVoltageEOD: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(modelName).map(v -> "modelName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(name).map(v -> "name: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(nominalAmpere).map(v -> "nominalAmpere: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(nominalCapacity).map(v -> "nominalCapacity: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(nominalFrequency).map(v -> "nominalFrequency: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(nominalVoltage).map(v -> "nominalVoltage: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(operatingAltitude).map(v -> "operatingAltitude: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(operatingAmpere).map(v -> "operatingAmpere: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(operatingFrequency).map(v -> "operatingFrequency: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(operatingTemperature).map(v -> "operatingTemperature: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(operatingVoltage).map(v -> "operatingVoltage: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(overloadAccepted).map(v -> "overloadAccepted: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(overloadAcceptedTime).map(v -> "overloadAcceptedTime: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(peakPower).map(v -> "peakPower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(possibilityOfUse).map(v -> "possibilityOfUse: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(protectionIK).map(v -> "protectionIK: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(protectionIP).map(v -> "protectionIP: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(rechargeEnergySource).map(v -> "rechargeEnergySource: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(refDevice).map(v -> "refDevice: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(refPointOfInterest).map(v -> "refPointOfInterest: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(roundTripEfficiency).map(v -> "roundTripEfficiency: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(selfDischargeRate).map(v -> "selfDischargeRate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(serialNumber).map(v -> "serialNumber: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(storableEnergy).map(v -> "storableEnergy: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(toolBMS).map(v -> "toolBMS: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(typeEnergySource).map(v -> "typeEnergySource: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(typeOfUse).map(v -> "typeOfUse: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(usableEnergy).map(v -> "usableEnergy: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(volEnergyDensity).map(v -> "volEnergyDensity: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(weight).map(v -> "weight: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "StorageBatteryDevice";
	public static final String CLASS_API_ADDRESS_StorageBatteryDevice = "smartabyar-smartvillage-enUS-StorageBatteryDevice";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_StorageBatteryDevice;
	}
	public static final String VAR_address = "address";
	public static final String VAR_alternateName = "alternateName";
	public static final String VAR_application = "application";
	public static final String VAR_areaServedColors = "areaServedColors";
	public static final String VAR_areaServedTitles = "areaServedTitles";
	public static final String VAR_areaServedLinks = "areaServedLinks";
	public static final String VAR_areaServed = "areaServed";
	public static final String VAR_averageLife = "averageLife";
	public static final String VAR_batteryAssessmentMethods = "batteryAssessmentMethods";
	public static final String VAR_batteryType = "batteryType";
	public static final String VAR_brandName = "brandName";
	public static final String VAR_capacityCnnn = "capacityCnnn";
	public static final String VAR_chargeDischargeReactivity = "chargeDischargeReactivity";
	public static final String VAR_chargeEfficiency = "chargeEfficiency";
	public static final String VAR_chargePower = "chargePower";
	public static final String VAR_chargingModeAllowed = "chargingModeAllowed";
	public static final String VAR_communication = "communication";
	public static final String VAR_dataProvider = "dataProvider";
	public static final String VAR_dateCreated = "dateCreated";
	public static final String VAR_dateLastReported = "dateLastReported";
	public static final String VAR_dateModified = "dateModified";
	public static final String VAR_description = "description";
	public static final String VAR_dimension = "dimension";
	public static final String VAR_dischargeEfficiency = "dischargeEfficiency";
	public static final String VAR_dischargePower = "dischargePower";
	public static final String VAR_documentation = "documentation";
	public static final String VAR_durationPeakPower = "durationPeakPower";
	public static final String VAR_installationCondition = "installationCondition";
	public static final String VAR_installationMode = "installationMode";
	public static final String VAR_lifeCycleNumber = "lifeCycleNumber";
	public static final String VAR_location = "location";
	public static final String VAR_manufacturerName = "manufacturerName";
	public static final String VAR_massEnergyDensity = "massEnergyDensity";
	public static final String VAR_maxOutputPower = "maxOutputPower";
	public static final String VAR_maximumVoltageEOC = "maximumVoltageEOC";
	public static final String VAR_minimumVoltageEOD = "minimumVoltageEOD";
	public static final String VAR_modelName = "modelName";
	public static final String VAR_name = "name";
	public static final String VAR_nominalAmpere = "nominalAmpere";
	public static final String VAR_nominalCapacity = "nominalCapacity";
	public static final String VAR_nominalFrequency = "nominalFrequency";
	public static final String VAR_nominalVoltage = "nominalVoltage";
	public static final String VAR_operatingAltitude = "operatingAltitude";
	public static final String VAR_operatingAmpere = "operatingAmpere";
	public static final String VAR_operatingFrequency = "operatingFrequency";
	public static final String VAR_operatingTemperature = "operatingTemperature";
	public static final String VAR_operatingVoltage = "operatingVoltage";
	public static final String VAR_overloadAccepted = "overloadAccepted";
	public static final String VAR_overloadAcceptedTime = "overloadAcceptedTime";
	public static final String VAR_owner = "owner";
	public static final String VAR_peakPower = "peakPower";
	public static final String VAR_possibilityOfUse = "possibilityOfUse";
	public static final String VAR_protectionIK = "protectionIK";
	public static final String VAR_protectionIP = "protectionIP";
	public static final String VAR_rechargeEnergySource = "rechargeEnergySource";
	public static final String VAR_refDevice = "refDevice";
	public static final String VAR_refPointOfInterest = "refPointOfInterest";
	public static final String VAR_roundTripEfficiency = "roundTripEfficiency";
	public static final String VAR_seeAlso = "seeAlso";
	public static final String VAR_selfDischargeRate = "selfDischargeRate";
	public static final String VAR_serialNumber = "serialNumber";
	public static final String VAR_source = "source";
	public static final String VAR_storableEnergy = "storableEnergy";
	public static final String VAR_toolBMS = "toolBMS";
	public static final String VAR_typeEnergySource = "typeEnergySource";
	public static final String VAR_typeOfUse = "typeOfUse";
	public static final String VAR_usableEnergy = "usableEnergy";
	public static final String VAR_volEnergyDensity = "volEnergyDensity";
	public static final String VAR_weight = "weight";

	public static List<String> varsQForClass() {
		return StorageBatteryDevice.varsQStorageBatteryDevice(new ArrayList<String>());
	}
	public static List<String> varsQStorageBatteryDevice(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return StorageBatteryDevice.varsFqStorageBatteryDevice(new ArrayList<String>());
	}
	public static List<String> varsFqStorageBatteryDevice(List<String> vars) {
		vars.add(VAR_address);
		vars.add(VAR_alternateName);
		vars.add(VAR_application);
		vars.add(VAR_areaServed);
		vars.add(VAR_averageLife);
		vars.add(VAR_batteryAssessmentMethods);
		vars.add(VAR_batteryType);
		vars.add(VAR_brandName);
		vars.add(VAR_capacityCnnn);
		vars.add(VAR_chargeDischargeReactivity);
		vars.add(VAR_chargeEfficiency);
		vars.add(VAR_chargePower);
		vars.add(VAR_chargingModeAllowed);
		vars.add(VAR_communication);
		vars.add(VAR_dataProvider);
		vars.add(VAR_dateCreated);
		vars.add(VAR_dateLastReported);
		vars.add(VAR_dateModified);
		vars.add(VAR_description);
		vars.add(VAR_dimension);
		vars.add(VAR_dischargeEfficiency);
		vars.add(VAR_dischargePower);
		vars.add(VAR_documentation);
		vars.add(VAR_durationPeakPower);
		vars.add(VAR_installationCondition);
		vars.add(VAR_installationMode);
		vars.add(VAR_lifeCycleNumber);
		vars.add(VAR_location);
		vars.add(VAR_manufacturerName);
		vars.add(VAR_massEnergyDensity);
		vars.add(VAR_maxOutputPower);
		vars.add(VAR_maximumVoltageEOC);
		vars.add(VAR_minimumVoltageEOD);
		vars.add(VAR_modelName);
		vars.add(VAR_name);
		vars.add(VAR_nominalAmpere);
		vars.add(VAR_nominalCapacity);
		vars.add(VAR_nominalFrequency);
		vars.add(VAR_nominalVoltage);
		vars.add(VAR_operatingAltitude);
		vars.add(VAR_operatingAmpere);
		vars.add(VAR_operatingFrequency);
		vars.add(VAR_operatingTemperature);
		vars.add(VAR_operatingVoltage);
		vars.add(VAR_overloadAccepted);
		vars.add(VAR_overloadAcceptedTime);
		vars.add(VAR_owner);
		vars.add(VAR_peakPower);
		vars.add(VAR_possibilityOfUse);
		vars.add(VAR_protectionIK);
		vars.add(VAR_protectionIP);
		vars.add(VAR_rechargeEnergySource);
		vars.add(VAR_refDevice);
		vars.add(VAR_refPointOfInterest);
		vars.add(VAR_roundTripEfficiency);
		vars.add(VAR_seeAlso);
		vars.add(VAR_selfDischargeRate);
		vars.add(VAR_serialNumber);
		vars.add(VAR_source);
		vars.add(VAR_storableEnergy);
		vars.add(VAR_toolBMS);
		vars.add(VAR_typeEnergySource);
		vars.add(VAR_typeOfUse);
		vars.add(VAR_usableEnergy);
		vars.add(VAR_volEnergyDensity);
		vars.add(VAR_weight);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return StorageBatteryDevice.varsRangeStorageBatteryDevice(new ArrayList<String>());
	}
	public static List<String> varsRangeStorageBatteryDevice(List<String> vars) {
		vars.add(VAR_address);
		vars.add(VAR_application);
		vars.add(VAR_averageLife);
		vars.add(VAR_capacityCnnn);
		vars.add(VAR_chargeDischargeReactivity);
		vars.add(VAR_chargeEfficiency);
		vars.add(VAR_chargePower);
		vars.add(VAR_chargingModeAllowed);
		vars.add(VAR_communication);
		vars.add(VAR_dimension);
		vars.add(VAR_dischargeEfficiency);
		vars.add(VAR_dischargePower);
		vars.add(VAR_durationPeakPower);
		vars.add(VAR_installationCondition);
		vars.add(VAR_lifeCycleNumber);
		vars.add(VAR_location);
		vars.add(VAR_massEnergyDensity);
		vars.add(VAR_maxOutputPower);
		vars.add(VAR_maximumVoltageEOC);
		vars.add(VAR_minimumVoltageEOD);
		vars.add(VAR_nominalAmpere);
		vars.add(VAR_nominalCapacity);
		vars.add(VAR_nominalFrequency);
		vars.add(VAR_nominalVoltage);
		vars.add(VAR_operatingAltitude);
		vars.add(VAR_operatingAmpere);
		vars.add(VAR_operatingFrequency);
		vars.add(VAR_operatingTemperature);
		vars.add(VAR_operatingVoltage);
		vars.add(VAR_owner);
		vars.add(VAR_peakPower);
		vars.add(VAR_protectionIK);
		vars.add(VAR_refDevice);
		vars.add(VAR_refPointOfInterest);
		vars.add(VAR_roundTripEfficiency);
		vars.add(VAR_seeAlso);
		vars.add(VAR_selfDischargeRate);
		vars.add(VAR_storableEnergy);
		vars.add(VAR_typeEnergySource);
		vars.add(VAR_usableEnergy);
		vars.add(VAR_volEnergyDensity);
		vars.add(VAR_weight);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_address = "address";
	public static final String DISPLAY_NAME_alternateName = "alternate name";
	public static final String DISPLAY_NAME_application = "application";
	public static final String DISPLAY_NAME_areaServedColors = "area served colors";
	public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
	public static final String DISPLAY_NAME_areaServedLinks = "area served links";
	public static final String DISPLAY_NAME_areaServed = "area served";
	public static final String DISPLAY_NAME_averageLife = "average life";
	public static final String DISPLAY_NAME_batteryAssessmentMethods = "battery assessment methods";
	public static final String DISPLAY_NAME_batteryType = "battery type";
	public static final String DISPLAY_NAME_brandName = "brand name";
	public static final String DISPLAY_NAME_capacityCnnn = "capacity cnnn";
	public static final String DISPLAY_NAME_chargeDischargeReactivity = "charge discharge reactivity";
	public static final String DISPLAY_NAME_chargeEfficiency = "charge efficiency";
	public static final String DISPLAY_NAME_chargePower = "charge power";
	public static final String DISPLAY_NAME_chargingModeAllowed = "charging mode allowed";
	public static final String DISPLAY_NAME_communication = "communication";
	public static final String DISPLAY_NAME_dataProvider = "data provider";
	public static final String DISPLAY_NAME_dateCreated = "date created";
	public static final String DISPLAY_NAME_dateLastReported = "date last reported";
	public static final String DISPLAY_NAME_dateModified = "date modified";
	public static final String DISPLAY_NAME_description = "description";
	public static final String DISPLAY_NAME_dimension = "dimension";
	public static final String DISPLAY_NAME_dischargeEfficiency = "discharge efficiency";
	public static final String DISPLAY_NAME_dischargePower = "discharge power";
	public static final String DISPLAY_NAME_documentation = "documentation";
	public static final String DISPLAY_NAME_durationPeakPower = "duration peak power";
	public static final String DISPLAY_NAME_installationCondition = "installation condition";
	public static final String DISPLAY_NAME_installationMode = "installation mode";
	public static final String DISPLAY_NAME_lifeCycleNumber = "life cycle number";
	public static final String DISPLAY_NAME_location = "location";
	public static final String DISPLAY_NAME_manufacturerName = "manufacturer name";
	public static final String DISPLAY_NAME_massEnergyDensity = "mass energy density";
	public static final String DISPLAY_NAME_maxOutputPower = "max output power";
	public static final String DISPLAY_NAME_maximumVoltageEOC = "maximum voltage eoc";
	public static final String DISPLAY_NAME_minimumVoltageEOD = "minimum voltage eod";
	public static final String DISPLAY_NAME_modelName = "model name";
	public static final String DISPLAY_NAME_name = "name";
	public static final String DISPLAY_NAME_nominalAmpere = "nominal ampere";
	public static final String DISPLAY_NAME_nominalCapacity = "nominal capacity";
	public static final String DISPLAY_NAME_nominalFrequency = "nominal frequency";
	public static final String DISPLAY_NAME_nominalVoltage = "nominal voltage";
	public static final String DISPLAY_NAME_operatingAltitude = "operating altitude";
	public static final String DISPLAY_NAME_operatingAmpere = "operating ampere";
	public static final String DISPLAY_NAME_operatingFrequency = "operating frequency";
	public static final String DISPLAY_NAME_operatingTemperature = "operating temperature";
	public static final String DISPLAY_NAME_operatingVoltage = "operating voltage";
	public static final String DISPLAY_NAME_overloadAccepted = "overload accepted";
	public static final String DISPLAY_NAME_overloadAcceptedTime = "overload accepted time";
	public static final String DISPLAY_NAME_owner = "owner";
	public static final String DISPLAY_NAME_peakPower = "peak power";
	public static final String DISPLAY_NAME_possibilityOfUse = "possibility of use";
	public static final String DISPLAY_NAME_protectionIK = "protection ik";
	public static final String DISPLAY_NAME_protectionIP = "protection ip";
	public static final String DISPLAY_NAME_rechargeEnergySource = "recharge energy source";
	public static final String DISPLAY_NAME_refDevice = "ref device";
	public static final String DISPLAY_NAME_refPointOfInterest = "ref point of interest";
	public static final String DISPLAY_NAME_roundTripEfficiency = "round trip efficiency";
	public static final String DISPLAY_NAME_seeAlso = "see also";
	public static final String DISPLAY_NAME_selfDischargeRate = "self discharge rate";
	public static final String DISPLAY_NAME_serialNumber = "serial number";
	public static final String DISPLAY_NAME_source = "source";
	public static final String DISPLAY_NAME_storableEnergy = "storable energy";
	public static final String DISPLAY_NAME_toolBMS = "tool bms";
	public static final String DISPLAY_NAME_typeEnergySource = "type energy source";
	public static final String DISPLAY_NAME_typeOfUse = "type of use";
	public static final String DISPLAY_NAME_usableEnergy = "usable energy";
	public static final String DISPLAY_NAME_volEnergyDensity = "vol energy density";
	public static final String DISPLAY_NAME_weight = "weight";

	public static String displayNameForClass(String var) {
		return StorageBatteryDevice.displayNameStorageBatteryDevice(var);
	}
	public static String displayNameStorageBatteryDevice(String var) {
		switch(var) {
		case VAR_address:
			return DISPLAY_NAME_address;
		case VAR_alternateName:
			return DISPLAY_NAME_alternateName;
		case VAR_application:
			return DISPLAY_NAME_application;
		case VAR_areaServedColors:
			return DISPLAY_NAME_areaServedColors;
		case VAR_areaServedTitles:
			return DISPLAY_NAME_areaServedTitles;
		case VAR_areaServedLinks:
			return DISPLAY_NAME_areaServedLinks;
		case VAR_areaServed:
			return DISPLAY_NAME_areaServed;
		case VAR_averageLife:
			return DISPLAY_NAME_averageLife;
		case VAR_batteryAssessmentMethods:
			return DISPLAY_NAME_batteryAssessmentMethods;
		case VAR_batteryType:
			return DISPLAY_NAME_batteryType;
		case VAR_brandName:
			return DISPLAY_NAME_brandName;
		case VAR_capacityCnnn:
			return DISPLAY_NAME_capacityCnnn;
		case VAR_chargeDischargeReactivity:
			return DISPLAY_NAME_chargeDischargeReactivity;
		case VAR_chargeEfficiency:
			return DISPLAY_NAME_chargeEfficiency;
		case VAR_chargePower:
			return DISPLAY_NAME_chargePower;
		case VAR_chargingModeAllowed:
			return DISPLAY_NAME_chargingModeAllowed;
		case VAR_communication:
			return DISPLAY_NAME_communication;
		case VAR_dataProvider:
			return DISPLAY_NAME_dataProvider;
		case VAR_dateCreated:
			return DISPLAY_NAME_dateCreated;
		case VAR_dateLastReported:
			return DISPLAY_NAME_dateLastReported;
		case VAR_dateModified:
			return DISPLAY_NAME_dateModified;
		case VAR_description:
			return DISPLAY_NAME_description;
		case VAR_dimension:
			return DISPLAY_NAME_dimension;
		case VAR_dischargeEfficiency:
			return DISPLAY_NAME_dischargeEfficiency;
		case VAR_dischargePower:
			return DISPLAY_NAME_dischargePower;
		case VAR_documentation:
			return DISPLAY_NAME_documentation;
		case VAR_durationPeakPower:
			return DISPLAY_NAME_durationPeakPower;
		case VAR_installationCondition:
			return DISPLAY_NAME_installationCondition;
		case VAR_installationMode:
			return DISPLAY_NAME_installationMode;
		case VAR_lifeCycleNumber:
			return DISPLAY_NAME_lifeCycleNumber;
		case VAR_location:
			return DISPLAY_NAME_location;
		case VAR_manufacturerName:
			return DISPLAY_NAME_manufacturerName;
		case VAR_massEnergyDensity:
			return DISPLAY_NAME_massEnergyDensity;
		case VAR_maxOutputPower:
			return DISPLAY_NAME_maxOutputPower;
		case VAR_maximumVoltageEOC:
			return DISPLAY_NAME_maximumVoltageEOC;
		case VAR_minimumVoltageEOD:
			return DISPLAY_NAME_minimumVoltageEOD;
		case VAR_modelName:
			return DISPLAY_NAME_modelName;
		case VAR_name:
			return DISPLAY_NAME_name;
		case VAR_nominalAmpere:
			return DISPLAY_NAME_nominalAmpere;
		case VAR_nominalCapacity:
			return DISPLAY_NAME_nominalCapacity;
		case VAR_nominalFrequency:
			return DISPLAY_NAME_nominalFrequency;
		case VAR_nominalVoltage:
			return DISPLAY_NAME_nominalVoltage;
		case VAR_operatingAltitude:
			return DISPLAY_NAME_operatingAltitude;
		case VAR_operatingAmpere:
			return DISPLAY_NAME_operatingAmpere;
		case VAR_operatingFrequency:
			return DISPLAY_NAME_operatingFrequency;
		case VAR_operatingTemperature:
			return DISPLAY_NAME_operatingTemperature;
		case VAR_operatingVoltage:
			return DISPLAY_NAME_operatingVoltage;
		case VAR_overloadAccepted:
			return DISPLAY_NAME_overloadAccepted;
		case VAR_overloadAcceptedTime:
			return DISPLAY_NAME_overloadAcceptedTime;
		case VAR_owner:
			return DISPLAY_NAME_owner;
		case VAR_peakPower:
			return DISPLAY_NAME_peakPower;
		case VAR_possibilityOfUse:
			return DISPLAY_NAME_possibilityOfUse;
		case VAR_protectionIK:
			return DISPLAY_NAME_protectionIK;
		case VAR_protectionIP:
			return DISPLAY_NAME_protectionIP;
		case VAR_rechargeEnergySource:
			return DISPLAY_NAME_rechargeEnergySource;
		case VAR_refDevice:
			return DISPLAY_NAME_refDevice;
		case VAR_refPointOfInterest:
			return DISPLAY_NAME_refPointOfInterest;
		case VAR_roundTripEfficiency:
			return DISPLAY_NAME_roundTripEfficiency;
		case VAR_seeAlso:
			return DISPLAY_NAME_seeAlso;
		case VAR_selfDischargeRate:
			return DISPLAY_NAME_selfDischargeRate;
		case VAR_serialNumber:
			return DISPLAY_NAME_serialNumber;
		case VAR_source:
			return DISPLAY_NAME_source;
		case VAR_storableEnergy:
			return DISPLAY_NAME_storableEnergy;
		case VAR_toolBMS:
			return DISPLAY_NAME_toolBMS;
		case VAR_typeEnergySource:
			return DISPLAY_NAME_typeEnergySource;
		case VAR_typeOfUse:
			return DISPLAY_NAME_typeOfUse;
		case VAR_usableEnergy:
			return DISPLAY_NAME_usableEnergy;
		case VAR_volEnergyDensity:
			return DISPLAY_NAME_volEnergyDensity;
		case VAR_weight:
			return DISPLAY_NAME_weight;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionStorageBatteryDevice(String var) {
		switch(var) {
		case VAR_address:
			return "The mailing address";
		case VAR_alternateName:
			return "An alternative name for this item";
		case VAR_application:
			return "Enum:'electricMobility, energyStorage, emergencyStorage, houseHoldStorage, industrialStorage, lighting, production, robotics, other'. Target application of the Device regarding the storage. A combination of the enumeration";
		case VAR_areaServedColors:
			return "The colors of each areaServed Paths. ";
		case VAR_areaServedTitles:
			return "The titles of each areaServed Paths. ";
		case VAR_areaServedLinks:
			return "The links of each areaServed Paths. ";
		case VAR_areaServed:
			return "The geographic area where a service or offered item is provided";
		case VAR_averageLife:
			return "average life under normal battery usage conditions at reference temperatures. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **ANN** represents Year";
		case VAR_batteryAssessmentMethods:
			return "Enum:'ampereHourMeter, dischargeTest, electrolyteDensity, highFrequencyImpedance, lowFrequencyImpedance, mathematicalModel, operatingVoltageWithClosedCircuit, quiescentVoltageWithOpenCircuit'.  ";
		case VAR_batteryType:
			return "Enum:'alkaline, gel, lead, lead-AGM, Li-Ion, Li-Po, Li-Po4, LMP, Li-Air, Na-NiCl2(Zebra), Ni-Cd, Ni-MH, Ni-Zn, other'. Type of battery used";
		case VAR_brandName:
			return "Brand Name of the item";
		case VAR_capacityCnnn:
			return "Remaining energy as a function of the discharge time for 6 keys according the temperature of reference. Each Key is a structured value with the format {`Cnnn`:[`value1`,`value2`]} describing the different measurement of [CapacityCnnn]";
		case VAR_chargeDischargeReactivity:
			return "Charge and Discharge Reactivity which characterizes the reactive behavior of the system. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **SEC** represents Second";
		case VAR_chargeEfficiency:
			return "Charge Efficiency *(code PV-BAT)*. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percent";
		case VAR_chargePower:
			return "Load Power. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt";
		case VAR_chargingModeAllowed:
			return "Charging mode permitted to avoid damage to the battery. enum:'fast, normal, quick'";
		case VAR_communication:
			return "List of communication protocol with others device depending manufacturers. Enum:'CAN 2.0 B, dryContactTerminal, maintenanceInterface, RS485, RS485BMS, RS485Inverter, other'";
		case VAR_dataProvider:
			return "A sequence of characters identifying the provider of the harmonised data entity";
		case VAR_dateCreated:
			return "Entity creation timestamp. This will usually be allocated by the storage platform";
		case VAR_dateLastReported:
			return "A timestamp which denotes the last time when the device successfully reported data. Date and time in an ISO8601 UTCformat. ";
		case VAR_dateModified:
			return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform";
		case VAR_description:
			return "A description of this item";
		case VAR_dimension:
			return "External dimension of a Panel. The format is structured by a sub-property of 3 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **CMT** represents Centimeter";
		case VAR_dischargeEfficiency:
			return "Discharge Efficiency *(code PV-OND)*. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percent";
		case VAR_dischargePower:
			return "Discharge Power. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt";
		case VAR_documentation:
			return "Technical Documentation (Installation / maintenance / use)";
		case VAR_durationPeakPower:
			return "Reference Time recorded for the attribute [peakPower]. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **SEC** represents Second";
		case VAR_installationCondition:
			return "Enum:'desert, dust, extremeClimate, extremeCold, extremeHeat, extremeHumidity, marine, saline, sand, seismic, other'. Condition and possibility of use in the following environments";
		case VAR_installationMode:
			return "Enum:'aerial, ground, pole, roofing, underGround, wall, other'. Positioning of the device in relation to a ground reference system";
		case VAR_lifeCycleNumber:
			return "Number of admissible charge / discharge life cycles. The format is structured by a sub-property of 2 items";
		case VAR_location:
			return "Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon";
		case VAR_manufacturerName:
			return "Manufacturer Name of the item";
		case VAR_massEnergyDensity:
			return "Mass Energy density *(Code D)*. Ratio between the capacity of the battery to deliver a certain power for a certain time and its weight. The format is structured by a sub-property of 2 items. The unit code (text) of measurement is **Wh/Kg** WattHour per Kilogram";
		case VAR_maxOutputPower:
			return "Maximum Power. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWT** represents Kilowatt";
		case VAR_maximumVoltageEOC:
			return "Maximum authorized voltage after end of charge and Battery still connected to to a charge generator. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt";
		case VAR_minimumVoltageEOD:
			return "Minimum voltage after end of discharge and not connected to to a charge generator. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt";
		case VAR_modelName:
			return "Model Name of the item. ";
		case VAR_name:
			return "The name of this item";
		case VAR_nominalAmpere:
			return "Nominal Amperage. *(Code I)*. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMP** represents Ampere";
		case VAR_nominalCapacity:
			return "Nominal Energy capacity. *(Code C)* to link with the attribute [CapacityCnnn] to measure the predefined levels parameters C / xx h of discharge regimes. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMH** represents Ampere Hour";
		case VAR_nominalFrequency:
			return "Nominal Frequency. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **HTZ** represents Hertz";
		case VAR_nominalVoltage:
			return "Nominal battery voltage. *(Code U)* The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt";
		case VAR_operatingAltitude:
			return "Operating altitude with minimum and maximum resistance to height and depth. The format is structured by a sub-property of 2 items with the keys [min] =<0 and [max] >=0. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **MTR** represents Meter";
		case VAR_operatingAmpere:
			return "Minimum and Maximum Ampere allowed. The format is structured by a sub-property of 2 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMP** represents Ampere";
		case VAR_operatingFrequency:
			return "Minimum and Maximum frequency allowed. The format is structured by a sub-property of 2 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **HTZ** represents Hertz";
		case VAR_operatingTemperature:
			return "Ambient operating temperature range. This is the minimum and maximum resistance to cold and heat for an [event]. The format is structured by a sub-property of 3 items with the format  {`event`:[`min`,`max`]}. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **CEL** represents Degree Celsius";
		case VAR_operatingVoltage:
			return "Minimum and Maximum voltage allowed. The format is structured by a sub-property of 2 items. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **VLT** represents Volt";
		case VAR_overloadAccepted:
			return "Overload is permitted after exceeding the threshold.(`true` for yes)";
		case VAR_overloadAcceptedTime:
			return "Accepted overcharge time without damage to the battery";
		case VAR_owner:
			return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
		case VAR_peakPower:
			return "Maximum intensity extractable over a short period. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWT** represents Kilowatt";
		case VAR_possibilityOfUse:
			return "Possibility of use. A unique value. Enum:'mobile, mixed, stationary, other'.  ";
		case VAR_protectionIK:
			return "IK 'Mecanic Protection' level relating to numeric classification for the degrees of protection provided by enclosures for electrical equipment against external mechanical impacts, according to International Electro technical Commission standard (EN 62-262). - IK varies from 0 (minimum resistance) to 10 (maximum resistance) which represents an Impact Energy (Unit Joule)";
		case VAR_protectionIP:
			return "IP *Ingress Protection* for the Junction Box. This is the level classifies and rates the degree of protection provided by mechanical casings and electrical enclosures against intrusion, dust, accidental contact, and water according to International Electrotechnical Commission standard (EN 60-529). - First digit: Solid particle protection (Single numeral: 0\u20136 or 'X'). - Second digit: Liquid ingress protection (Single numeral: 0\u20139 or 'X'). - Third digit: Personal Protection  against access to dangerous parts (optional additional letter). - Fourth digit: Other protections (optional additional letter)";
		case VAR_rechargeEnergySource:
			return "Enum:'electric, hydraulic, windTurbine, other'. Recharge Energy Source. A unique value of the list ";
		case VAR_refDevice:
			return "Reference to the Main Entity [Device](https://github.com/smart-data-models/dataModel.Device/blob/master/Device/doc/spec.md) if used as second link";
		case VAR_refPointOfInterest:
			return "Reference to a [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) linked with the observation";
		case VAR_roundTripEfficiency:
			return "Round-Trip Efficiency. Efficiency, defined as the ratio between stored energy and returned energy. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percent";
		case VAR_seeAlso:
			return "list of uri pointing to additional resources about the item";
		case VAR_selfDischargeRate:
			return "Battery discharge rate without any use on a baseline of 1 month according the [temperature of reference]. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **P1** represents Percentage";
		case VAR_serialNumber:
			return "Serial numbers of the item";
		case VAR_source:
			return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object";
		case VAR_storableEnergy:
			return "Total Storage Energy = [nominalVoltage] * [nominalCapacity]. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWH** represents Kilowatt Hour";
		case VAR_toolBMS:
			return "Use of a Battery Management System tool to protect, guarantee and optimize battery life. (`true` for yes)";
		case VAR_typeEnergySource:
			return "Enum:'dam, fall, generator, network, photovoltaic, river, sea, waterTurbine, wind, other'. Type of Energy Source regarding `RechargeEnergySource` attribute";
		case VAR_typeOfUse:
			return "Accepted use regarding its positioning in an indoor / outdoor environment. Enum:' indoor, mixed, outdoor, other'";
		case VAR_usableEnergy:
			return "Usable Energy. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWH** represents Kilowatt Hour";
		case VAR_volEnergyDensity:
			return "Volume Energy density *(Code D)*. The format is structured by a sub-property of 2 items. The unit code (text) of measurement is **Wh/L** WattHour per Liter";
		case VAR_weight:
			return "Weight. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KGM** represents KiloGramme";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameStorageBatteryDevice(String var) {
		switch(var) {
		case VAR_address:
			return "JsonObject";
		case VAR_alternateName:
			return "String";
		case VAR_application:
			return "JsonObject";
		case VAR_areaServedColors:
			return "List";
		case VAR_areaServedTitles:
			return "List";
		case VAR_areaServedLinks:
			return "List";
		case VAR_areaServed:
			return "Path";
		case VAR_averageLife:
			return "BigDecimal";
		case VAR_batteryAssessmentMethods:
			return "String";
		case VAR_batteryType:
			return "String";
		case VAR_brandName:
			return "String";
		case VAR_capacityCnnn:
			return "JsonObject";
		case VAR_chargeDischargeReactivity:
			return "BigDecimal";
		case VAR_chargeEfficiency:
			return "BigDecimal";
		case VAR_chargePower:
			return "BigDecimal";
		case VAR_chargingModeAllowed:
			return "JsonObject";
		case VAR_communication:
			return "JsonObject";
		case VAR_dataProvider:
			return "String";
		case VAR_dateCreated:
			return "String";
		case VAR_dateLastReported:
			return "String";
		case VAR_dateModified:
			return "String";
		case VAR_description:
			return "String";
		case VAR_dimension:
			return "JsonObject";
		case VAR_dischargeEfficiency:
			return "BigDecimal";
		case VAR_dischargePower:
			return "BigDecimal";
		case VAR_documentation:
			return "String";
		case VAR_durationPeakPower:
			return "BigDecimal";
		case VAR_installationCondition:
			return "JsonObject";
		case VAR_installationMode:
			return "String";
		case VAR_lifeCycleNumber:
			return "JsonObject";
		case VAR_location:
			return "Point";
		case VAR_manufacturerName:
			return "String";
		case VAR_massEnergyDensity:
			return "JsonObject";
		case VAR_maxOutputPower:
			return "BigDecimal";
		case VAR_maximumVoltageEOC:
			return "BigDecimal";
		case VAR_minimumVoltageEOD:
			return "BigDecimal";
		case VAR_modelName:
			return "String";
		case VAR_name:
			return "String";
		case VAR_nominalAmpere:
			return "BigDecimal";
		case VAR_nominalCapacity:
			return "BigDecimal";
		case VAR_nominalFrequency:
			return "BigDecimal";
		case VAR_nominalVoltage:
			return "BigDecimal";
		case VAR_operatingAltitude:
			return "JsonObject";
		case VAR_operatingAmpere:
			return "JsonObject";
		case VAR_operatingFrequency:
			return "JsonObject";
		case VAR_operatingTemperature:
			return "JsonObject";
		case VAR_operatingVoltage:
			return "JsonObject";
		case VAR_overloadAccepted:
			return "Boolean";
		case VAR_overloadAcceptedTime:
			return "String";
		case VAR_owner:
			return "JsonObject";
		case VAR_peakPower:
			return "BigDecimal";
		case VAR_possibilityOfUse:
			return "String";
		case VAR_protectionIK:
			return "BigDecimal";
		case VAR_protectionIP:
			return "String";
		case VAR_rechargeEnergySource:
			return "String";
		case VAR_refDevice:
			return "JsonObject";
		case VAR_refPointOfInterest:
			return "JsonObject";
		case VAR_roundTripEfficiency:
			return "BigDecimal";
		case VAR_seeAlso:
			return "JsonObject";
		case VAR_selfDischargeRate:
			return "BigDecimal";
		case VAR_serialNumber:
			return "String";
		case VAR_source:
			return "String";
		case VAR_storableEnergy:
			return "BigDecimal";
		case VAR_toolBMS:
			return "Boolean";
		case VAR_typeEnergySource:
			return "JsonObject";
		case VAR_typeOfUse:
			return "String";
		case VAR_usableEnergy:
			return "BigDecimal";
		case VAR_volEnergyDensity:
			return "JsonObject";
		case VAR_weight:
			return "BigDecimal";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmColumnStorageBatteryDevice(String var) {
		switch(var) {
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowStorageBatteryDevice(String var) {
		switch(var) {
		case VAR_address:
			return 3;
		case VAR_alternateName:
			return 3;
		case VAR_application:
			return 3;
		case VAR_areaServed:
			return 4;
		case VAR_averageLife:
			return 4;
		case VAR_batteryAssessmentMethods:
			return 4;
		case VAR_batteryType:
			return 5;
		case VAR_brandName:
			return 5;
		case VAR_capacityCnnn:
			return 5;
		case VAR_chargeDischargeReactivity:
			return 6;
		case VAR_chargeEfficiency:
			return 6;
		case VAR_chargePower:
			return 6;
		case VAR_chargingModeAllowed:
			return 7;
		case VAR_communication:
			return 7;
		case VAR_dataProvider:
			return 7;
		case VAR_dateCreated:
			return 8;
		case VAR_dateLastReported:
			return 8;
		case VAR_dateModified:
			return 8;
		case VAR_description:
			return 9;
		case VAR_dimension:
			return 9;
		case VAR_dischargeEfficiency:
			return 9;
		case VAR_dischargePower:
			return 10;
		case VAR_documentation:
			return 10;
		case VAR_durationPeakPower:
			return 10;
		case VAR_installationCondition:
			return 11;
		case VAR_installationMode:
			return 11;
		case VAR_lifeCycleNumber:
			return 11;
		case VAR_location:
			return 12;
		case VAR_manufacturerName:
			return 12;
		case VAR_massEnergyDensity:
			return 12;
		case VAR_maxOutputPower:
			return 13;
		case VAR_maximumVoltageEOC:
			return 13;
		case VAR_minimumVoltageEOD:
			return 13;
		case VAR_modelName:
			return 14;
		case VAR_name:
			return 14;
		case VAR_nominalAmpere:
			return 14;
		case VAR_nominalCapacity:
			return 15;
		case VAR_nominalFrequency:
			return 15;
		case VAR_nominalVoltage:
			return 15;
		case VAR_operatingAltitude:
			return 16;
		case VAR_operatingAmpere:
			return 16;
		case VAR_operatingFrequency:
			return 16;
		case VAR_operatingTemperature:
			return 17;
		case VAR_operatingVoltage:
			return 17;
		case VAR_overloadAccepted:
			return 17;
		case VAR_overloadAcceptedTime:
			return 18;
		case VAR_owner:
			return 18;
		case VAR_peakPower:
			return 18;
		case VAR_possibilityOfUse:
			return 19;
		case VAR_protectionIK:
			return 19;
		case VAR_protectionIP:
			return 19;
		case VAR_rechargeEnergySource:
			return 20;
		case VAR_refDevice:
			return 20;
		case VAR_refPointOfInterest:
			return 20;
		case VAR_roundTripEfficiency:
			return 21;
		case VAR_seeAlso:
			return 21;
		case VAR_selfDischargeRate:
			return 21;
		case VAR_serialNumber:
			return 22;
		case VAR_source:
			return 22;
		case VAR_storableEnergy:
			return 22;
		case VAR_toolBMS:
			return 23;
		case VAR_typeEnergySource:
			return 23;
		case VAR_typeOfUse:
			return 23;
		case VAR_usableEnergy:
			return 24;
		case VAR_volEnergyDensity:
			return 24;
		case VAR_weight:
			return 24;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellStorageBatteryDevice(String var) {
		switch(var) {
		case VAR_address:
			return 1;
		case VAR_alternateName:
			return 2;
		case VAR_application:
			return 3;
		case VAR_areaServed:
			return 1;
		case VAR_averageLife:
			return 2;
		case VAR_batteryAssessmentMethods:
			return 3;
		case VAR_batteryType:
			return 1;
		case VAR_brandName:
			return 2;
		case VAR_capacityCnnn:
			return 3;
		case VAR_chargeDischargeReactivity:
			return 1;
		case VAR_chargeEfficiency:
			return 2;
		case VAR_chargePower:
			return 3;
		case VAR_chargingModeAllowed:
			return 1;
		case VAR_communication:
			return 2;
		case VAR_dataProvider:
			return 3;
		case VAR_dateCreated:
			return 1;
		case VAR_dateLastReported:
			return 2;
		case VAR_dateModified:
			return 3;
		case VAR_description:
			return 1;
		case VAR_dimension:
			return 2;
		case VAR_dischargeEfficiency:
			return 3;
		case VAR_dischargePower:
			return 1;
		case VAR_documentation:
			return 2;
		case VAR_durationPeakPower:
			return 3;
		case VAR_installationCondition:
			return 1;
		case VAR_installationMode:
			return 2;
		case VAR_lifeCycleNumber:
			return 3;
		case VAR_location:
			return 1;
		case VAR_manufacturerName:
			return 2;
		case VAR_massEnergyDensity:
			return 3;
		case VAR_maxOutputPower:
			return 1;
		case VAR_maximumVoltageEOC:
			return 2;
		case VAR_minimumVoltageEOD:
			return 3;
		case VAR_modelName:
			return 1;
		case VAR_name:
			return 2;
		case VAR_nominalAmpere:
			return 3;
		case VAR_nominalCapacity:
			return 1;
		case VAR_nominalFrequency:
			return 2;
		case VAR_nominalVoltage:
			return 3;
		case VAR_operatingAltitude:
			return 1;
		case VAR_operatingAmpere:
			return 2;
		case VAR_operatingFrequency:
			return 3;
		case VAR_operatingTemperature:
			return 1;
		case VAR_operatingVoltage:
			return 2;
		case VAR_overloadAccepted:
			return 3;
		case VAR_overloadAcceptedTime:
			return 1;
		case VAR_owner:
			return 2;
		case VAR_peakPower:
			return 3;
		case VAR_possibilityOfUse:
			return 1;
		case VAR_protectionIK:
			return 2;
		case VAR_protectionIP:
			return 3;
		case VAR_rechargeEnergySource:
			return 1;
		case VAR_refDevice:
			return 2;
		case VAR_refPointOfInterest:
			return 3;
		case VAR_roundTripEfficiency:
			return 1;
		case VAR_seeAlso:
			return 2;
		case VAR_selfDischargeRate:
			return 3;
		case VAR_serialNumber:
			return 1;
		case VAR_source:
			return 2;
		case VAR_storableEnergy:
			return 3;
		case VAR_toolBMS:
			return 1;
		case VAR_typeEnergySource:
			return 2;
		case VAR_typeOfUse:
			return 3;
		case VAR_usableEnergy:
			return 1;
		case VAR_volEnergyDensity:
			return 2;
		case VAR_weight:
			return 3;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinStorageBatteryDevice(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxStorageBatteryDevice(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxStorageBatteryDevice(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minStorageBatteryDevice(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
