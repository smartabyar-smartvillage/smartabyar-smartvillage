package org.computate.smartvillage.enus.model.photovoltaicmeasurement;

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
import java.math.BigDecimal;
import java.lang.String;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Polygon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPolygonSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPolygonDeserializer;
import org.computate.vertx.serialize.pgclient.PgClientPointSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPointDeserializer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class PhotovoltaicMeasurementGen into the class PhotovoltaicMeasurement. 
 * </li>
 * <h3>About the PhotovoltaicMeasurement class and it's generated class PhotovoltaicMeasurementGen&lt;BaseModel&gt;: </h3>extends PhotovoltaicMeasurementGen
 * <p>
 * This Java class extends a generated Java class PhotovoltaicMeasurementGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement">Find the class PhotovoltaicMeasurement in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends PhotovoltaicMeasurementGen<BaseModel>
 * <p>This <code>class PhotovoltaicMeasurement extends PhotovoltaicMeasurementGen&lt;BaseModel&gt;</code>, which means it extends a newly generated PhotovoltaicMeasurementGen. 
 * The generated <code>class PhotovoltaicMeasurementGen extends BaseModel</code> which means that PhotovoltaicMeasurement extends PhotovoltaicMeasurementGen which extends BaseModel. 
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
 * <p>This class contains a comment <b>"ApiTag: PhotovoltaicMeasurement"</b>, which groups all of the OpenAPIs for PhotovoltaicMeasurement objects under the tag "PhotovoltaicMeasurement". 
 * </p>
 * <h2>ApiUri.enUS: /api/PhotovoltaicMeasurement</h2>
 * <p>This class contains a comment <b>"ApiUri: /api/PhotovoltaicMeasurement"</b>, which defines the base API URI for PhotovoltaicMeasurement objects as "/api/PhotovoltaicMeasurement" in the OpenAPI spec. 
 * </p>
 * <h2>Color: 2017-shaded-spruce</h2>
 * <p>This class contains a comment <b>"Color: 2017-shaded-spruce"</b>, which styles the PhotovoltaicMeasurement page "2017-shaded-spruce". 
 * This will reference a CSS class defined by the stylesheets in the project that starts with "w3-". 
 * A css class of "w3-2017-shaded-spruce" is expected to exist in the project stylesheets, and is inspired by W3 CSS colors. 
 * See: <a href="https://www.w3schools.com/w3css/w3css_colors.asp">https://www.w3schools.com/w3css/w3css_colors.asp</a>. 
 * </p>
 * <h2>IconGroup: duotone</h2>
 * <p>This class contains a comment <b>"IconGroup: duotone"</b>, which adds icons on the PhotovoltaicMeasurement page with a group of "duotone". 
 * This will reference a Font Awesome icon group that starts with "fa-" followed by the icon group "duotone", together is "fa-duotone". 
 * A Font Awesome icon group of "duotone" is expected to exist. 
 * The Font Awesome groups currently supported include: solid, regular, light, thin, duotone, sharp, and kit. 
 * See: <a href="https://fontawesome.com/docs/web/dig-deeper/styles">https://fontawesome.com/docs/web/dig-deeper/styles</a>. 
 * </p>
 * <h2>IconName: map-location-dot</h2>
 * <p>This class contains a comment <b>"IconName: map-location-dot"</b>, which adds icons on the PhotovoltaicMeasurement page with a name of "map-location-dot". 
 * This will reference a Font Awesome icon that starts with the icon group "fa-duotone fa-" followed by the icon name, which is "fa-duotone fa-map-location-dot". 
 * A Font Awesome icon of "fa-duotone fa-map-location-dot" is expected to exist. 
 * See: <a href="https://fontawesome.com/icons">https://fontawesome.com/icons</a>. 
 * </p>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the PhotovoltaicMeasurement class will inherit the helpful inherited class comments from the super class PhotovoltaicMeasurementGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the PhotovoltaicMeasurement API will return a default of 100 records instead of 10 by default. 
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
 * This creates a new Java class org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurementPage. 
 * </p>
 * <h2>SuperPage.enUS: BaseModelPage</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: BaseModelPage"</b>, which identifies the Java super class of the page code by it's class simple name "BaseModelPage". 
 * This means that the newly created class org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurementPage extends org.computate.smartvillage.enus.model.base.BaseModelPage. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the PhotovoltaicMeasurement Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * This class contains a comment <b>"Role.enUS: SiteAdmin"</b>, which identifies the default role name "SiteAdmin" of the OAuth2/OpenID Connect user role required to access this PhotovoltaicMeasurement API. 
 * It's possible to reconfigure the roles required to access the PhotovoltaicMeasurement API by configuring an environment variable like this: 
 * </p>
 * <pre>AUTH_ROLE_REQUIRED_PhotovoltaicMeasurement: ["SiteAdmin"]</pre>
 * <h2>AName.enUS: a PhotovoltaicMeasurement</h2>
 * <p>This class contains a comment <b>"AName.enUS: a PhotovoltaicMeasurement"</b>, which identifies the language context to describe a PhotovoltaicMeasurement as "a PhotovoltaicMeasurement". 
 * </p>
 * <p>
 * Delete the class PhotovoltaicMeasurement in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.photovoltaicmeasurement in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class PhotovoltaicMeasurementGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(PhotovoltaicMeasurement.class);

	public static final String PhotovoltaicMeasurement_Description_enUS = "ApiTag.enUS: PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_AName_enUS = "a PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_This_enUS = "this ";
	public static final String PhotovoltaicMeasurement_ThisName_enUS = "this PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_A_enUS = "a ";
	public static final String PhotovoltaicMeasurement_TheName_enUS = "the PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_NameSingular_enUS = "PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_NamePlural_enUS = "PhotovoltaicMeasurements";
	public static final String PhotovoltaicMeasurement_NameActual_enUS = "current PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_AllName_enUS = "all the PhotovoltaicMeasurements";
	public static final String PhotovoltaicMeasurement_SearchAllNameBy_enUS = "search PhotovoltaicMeasurements by ";
	public static final String PhotovoltaicMeasurement_Title_enUS = "PhotovoltaicMeasurements";
	public static final String PhotovoltaicMeasurement_ThePluralName_enUS = "the PhotovoltaicMeasurements";
	public static final String PhotovoltaicMeasurement_NoNameFound_enUS = "no PhotovoltaicMeasurement found";
	public static final String PhotovoltaicMeasurement_ApiUri_enUS = "/api/PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_ApiUriSearchPage_enUS = "/PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_OfName_enUS = "of PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_ANameAdjective_enUS = "a PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_NameAdjectiveSingular_enUS = "PhotovoltaicMeasurement";
	public static final String PhotovoltaicMeasurement_NameAdjectivePlural_enUS = "PhotovoltaicMeasurements";
	public static final String Search_enUS_Uri = "/api/PhotovoltaicMeasurement";
	public static final String Search_enUS_ImageUri = "/png/api/PhotovoltaicMeasurement-999.png";
	public static final String GET_enUS_Uri = "/api/PhotovoltaicMeasurement/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/PhotovoltaicMeasurement/{id}-999.png";
	public static final String PATCH_enUS_Uri = "/api/PhotovoltaicMeasurement";
	public static final String PATCH_enUS_ImageUri = "/png/api/PhotovoltaicMeasurement-999.png";
	public static final String POST_enUS_Uri = "/api/PhotovoltaicMeasurement";
	public static final String POST_enUS_ImageUri = "/png/api/PhotovoltaicMeasurement-999.png";
	public static final String PUTImport_enUS_Uri = "/api/PhotovoltaicMeasurement-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/PhotovoltaicMeasurement-import-999.png";
	public static final String SearchPage_enUS_Uri = "/PhotovoltaicMeasurement";
	public static final String SearchPage_enUS_ImageUri = "/png/PhotovoltaicMeasurement-999.png";

	public static final String PhotovoltaicMeasurement_Color = "2017-shaded-spruce";
	public static final String PhotovoltaicMeasurement_IconGroup = "duotone";
	public static final String PhotovoltaicMeasurement_IconName = "map-location-dot";
	public static final Integer PhotovoltaicMeasurement_Rows = 100;

	/////////////////
	// activePower //
	/////////////////


	/**	 The entity activePower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal activePower;

	/**	<br> The entity activePower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:activePower">Find the entity activePower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _activePower(Wrap<BigDecimal> w);

	public BigDecimal getActivePower() {
		return activePower;
	}

	public void setActivePower(BigDecimal activePower) {
		this.activePower = activePower;
	}
	@JsonIgnore
	public void setActivePower(String o) {
		this.activePower = PhotovoltaicMeasurement.staticSetActivePower(siteRequest_, o);
	}
	public static BigDecimal staticSetActivePower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setActivePower(Double o) {
		setActivePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setActivePower(Integer o) {
		setActivePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setActivePower(Number o) {
		setActivePower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected PhotovoltaicMeasurement activePowerInit() {
		Wrap<BigDecimal> activePowerWrap = new Wrap<BigDecimal>().var("activePower");
		if(activePower == null) {
			_activePower(activePowerWrap);
			Optional.ofNullable(activePowerWrap.getO()).ifPresent(o -> {
				setActivePower(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Double staticSearchActivePower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrActivePower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqActivePower(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchActivePower(siteRequest_, PhotovoltaicMeasurement.staticSetActivePower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlActivePower() {
		return activePower;
	}

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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
		this.address = PhotovoltaicMeasurement.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurement addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchAddress(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchAddress(siteRequest_, PhotovoltaicMeasurement.staticSetAddress(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _alternateName(Wrap<String> w);

	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String o) {
		this.alternateName = PhotovoltaicMeasurement.staticSetAlternateName(siteRequest_, o);
	}
	public static String staticSetAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement alternateNameInit() {
		Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
		if(alternateName == null) {
			_alternateName(alternateNameWrap);
			Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
				setAlternateName(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchAlternateName(siteRequest_, PhotovoltaicMeasurement.staticSetAlternateName(siteRequest_, o)).toString();
	}

	public String sqlAlternateName() {
		return alternateName;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
		String l = PhotovoltaicMeasurement.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public PhotovoltaicMeasurement addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (PhotovoltaicMeasurement)this;
	}
	public PhotovoltaicMeasurement addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (PhotovoltaicMeasurement)this;
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
	protected PhotovoltaicMeasurement areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchAreaServedColors(siteRequest_, PhotovoltaicMeasurement.staticSetAreaServedColors(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
		String l = PhotovoltaicMeasurement.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public PhotovoltaicMeasurement addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (PhotovoltaicMeasurement)this;
	}
	public PhotovoltaicMeasurement addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (PhotovoltaicMeasurement)this;
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
	protected PhotovoltaicMeasurement areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchAreaServedTitles(siteRequest_, PhotovoltaicMeasurement.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
		String l = PhotovoltaicMeasurement.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public PhotovoltaicMeasurement addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (PhotovoltaicMeasurement)this;
	}
	public PhotovoltaicMeasurement addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (PhotovoltaicMeasurement)this;
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
	protected PhotovoltaicMeasurement areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchAreaServedLinks(siteRequest_, PhotovoltaicMeasurement.staticSetAreaServedLinks(siteRequest_, o)).toString();
	}

	////////////////
	// areaServed //
	////////////////


	/**	 The entity areaServed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPolygonDeserializer.class)
	@JsonSerialize(using = PgClientPolygonSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Polygon areaServed;

	/**	<br> The entity areaServed
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _areaServed(Wrap<Polygon> w);

	public Polygon getAreaServed() {
		return areaServed;
	}

	public void setAreaServed(Polygon areaServed) {
		this.areaServed = areaServed;
	}
	@JsonIgnore
	public void setAreaServed(String o) {
		this.areaServed = PhotovoltaicMeasurement.staticSetAreaServed(siteRequest_, o);
	}
	public static Polygon staticSetAreaServed(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
			try {
				Polygon shape = null;
				if(StringUtils.isNotBlank(o)) {
					ObjectMapper objectMapper = new ObjectMapper();
					SimpleModule module = new SimpleModule();
					module.setDeserializerModifier(new BeanDeserializerModifier() {
						@Override
						public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
							if (beanDesc.getBeanClass() == Polygon.class) {
								return new PgClientPolygonDeserializer();
							}
							return deserializer;
						}
					});
					objectMapper.registerModule(module);
					shape = objectMapper.readValue(Json.encode(o), Polygon.class);
				}
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	public void setAreaServed(JsonObject o) {
		this.areaServed = PhotovoltaicMeasurement.staticSetAreaServed(siteRequest_, o);
	}
	public static Polygon staticSetAreaServed(SiteRequestEnUS siteRequest_, JsonObject o) {
		if(o != null) {
			try {
				Polygon shape = new Polygon();
				o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(g -> {
					g.stream().map(a -> (JsonArray)a).forEach(points -> {
						shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
					});
				});
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	protected PhotovoltaicMeasurement areaServedInit() {
		Wrap<Polygon> areaServedWrap = new Wrap<Polygon>().var("areaServed");
		if(areaServed == null) {
			_areaServed(areaServedWrap);
			Optional.ofNullable(areaServedWrap.getO()).ifPresent(o -> {
				setAreaServed(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Polygon staticSearchAreaServed(SiteRequestEnUS siteRequest_, Polygon o) {
		return o;
	}

	public static String staticSearchStrAreaServed(SiteRequestEnUS siteRequest_, Polygon o) {
		JsonArray pointsArray = new JsonArray();
		o.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
		return new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString();
	}

	public static String staticSearchFqAreaServed(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchAreaServed(siteRequest_, PhotovoltaicMeasurement.staticSetAreaServed(siteRequest_, o)).toString();
	}

	public Polygon sqlAreaServed() {
		return areaServed;
	}

	/////////////
	// current //
	/////////////


	/**	 The entity current
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal current;

	/**	<br> The entity current
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:current">Find the entity current in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _current(Wrap<BigDecimal> w);

	public BigDecimal getCurrent() {
		return current;
	}

	public void setCurrent(BigDecimal current) {
		this.current = current;
	}
	@JsonIgnore
	public void setCurrent(String o) {
		this.current = PhotovoltaicMeasurement.staticSetCurrent(siteRequest_, o);
	}
	public static BigDecimal staticSetCurrent(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCurrent(Double o) {
		setCurrent(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCurrent(Integer o) {
		setCurrent(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCurrent(Number o) {
		setCurrent(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected PhotovoltaicMeasurement currentInit() {
		Wrap<BigDecimal> currentWrap = new Wrap<BigDecimal>().var("current");
		if(current == null) {
			_current(currentWrap);
			Optional.ofNullable(currentWrap.getO()).ifPresent(o -> {
				setCurrent(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Double staticSearchCurrent(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCurrent(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCurrent(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchCurrent(siteRequest_, PhotovoltaicMeasurement.staticSetCurrent(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCurrent() {
		return current;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataProvider(Wrap<String> w);

	public String getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(String o) {
		this.dataProvider = PhotovoltaicMeasurement.staticSetDataProvider(siteRequest_, o);
	}
	public static String staticSetDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dataProviderInit() {
		Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
		if(dataProvider == null) {
			_dataProvider(dataProviderWrap);
			Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
				setDataProvider(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDataProvider(siteRequest_, PhotovoltaicMeasurement.staticSetDataProvider(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateCreated(Wrap<String> w);

	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String o) {
		this.dateCreated = PhotovoltaicMeasurement.staticSetDateCreated(siteRequest_, o);
	}
	public static String staticSetDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dateCreatedInit() {
		Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
		if(dateCreated == null) {
			_dateCreated(dateCreatedWrap);
			Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
				setDateCreated(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDateCreated(siteRequest_, PhotovoltaicMeasurement.staticSetDateCreated(siteRequest_, o)).toString();
	}

	public String sqlDateCreated() {
		return dateCreated;
	}

	///////////////////////////////
	// dateEnergyMeteringStarted //
	///////////////////////////////


	/**	 The entity dateEnergyMeteringStarted
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateEnergyMeteringStarted;

	/**	<br> The entity dateEnergyMeteringStarted
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dateEnergyMeteringStarted">Find the entity dateEnergyMeteringStarted in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateEnergyMeteringStarted(Wrap<String> w);

	public String getDateEnergyMeteringStarted() {
		return dateEnergyMeteringStarted;
	}
	public void setDateEnergyMeteringStarted(String o) {
		this.dateEnergyMeteringStarted = PhotovoltaicMeasurement.staticSetDateEnergyMeteringStarted(siteRequest_, o);
	}
	public static String staticSetDateEnergyMeteringStarted(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dateEnergyMeteringStartedInit() {
		Wrap<String> dateEnergyMeteringStartedWrap = new Wrap<String>().var("dateEnergyMeteringStarted");
		if(dateEnergyMeteringStarted == null) {
			_dateEnergyMeteringStarted(dateEnergyMeteringStartedWrap);
			Optional.ofNullable(dateEnergyMeteringStartedWrap.getO()).ifPresent(o -> {
				setDateEnergyMeteringStarted(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDateEnergyMeteringStarted(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateEnergyMeteringStarted(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateEnergyMeteringStarted(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDateEnergyMeteringStarted(siteRequest_, PhotovoltaicMeasurement.staticSetDateEnergyMeteringStarted(siteRequest_, o)).toString();
	}

	public String sqlDateEnergyMeteringStarted() {
		return dateEnergyMeteringStarted;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateModified(Wrap<String> w);

	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String o) {
		this.dateModified = PhotovoltaicMeasurement.staticSetDateModified(siteRequest_, o);
	}
	public static String staticSetDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dateModifiedInit() {
		Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
		if(dateModified == null) {
			_dateModified(dateModifiedWrap);
			Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
				setDateModified(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateModified(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDateModified(siteRequest_, PhotovoltaicMeasurement.staticSetDateModified(siteRequest_, o)).toString();
	}

	public String sqlDateModified() {
		return dateModified;
	}

	//////////////////
	// dateObserved //
	//////////////////


	/**	 The entity dateObserved
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateObserved;

	/**	<br> The entity dateObserved
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dateObserved">Find the entity dateObserved in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObserved(Wrap<String> w);

	public String getDateObserved() {
		return dateObserved;
	}
	public void setDateObserved(String o) {
		this.dateObserved = PhotovoltaicMeasurement.staticSetDateObserved(siteRequest_, o);
	}
	public static String staticSetDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dateObservedInit() {
		Wrap<String> dateObservedWrap = new Wrap<String>().var("dateObserved");
		if(dateObserved == null) {
			_dateObserved(dateObservedWrap);
			Optional.ofNullable(dateObservedWrap.getO()).ifPresent(o -> {
				setDateObserved(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDateObserved(siteRequest_, PhotovoltaicMeasurement.staticSetDateObserved(siteRequest_, o)).toString();
	}

	public String sqlDateObserved() {
		return dateObserved;
	}

	//////////////////////
	// dateObservedFrom //
	//////////////////////


	/**	 The entity dateObservedFrom
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateObservedFrom;

	/**	<br> The entity dateObservedFrom
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dateObservedFrom">Find the entity dateObservedFrom in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObservedFrom(Wrap<String> w);

	public String getDateObservedFrom() {
		return dateObservedFrom;
	}
	public void setDateObservedFrom(String o) {
		this.dateObservedFrom = PhotovoltaicMeasurement.staticSetDateObservedFrom(siteRequest_, o);
	}
	public static String staticSetDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dateObservedFromInit() {
		Wrap<String> dateObservedFromWrap = new Wrap<String>().var("dateObservedFrom");
		if(dateObservedFrom == null) {
			_dateObservedFrom(dateObservedFromWrap);
			Optional.ofNullable(dateObservedFromWrap.getO()).ifPresent(o -> {
				setDateObservedFrom(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDateObservedFrom(siteRequest_, PhotovoltaicMeasurement.staticSetDateObservedFrom(siteRequest_, o)).toString();
	}

	public String sqlDateObservedFrom() {
		return dateObservedFrom;
	}

	////////////////////
	// dateObservedTo //
	////////////////////


	/**	 The entity dateObservedTo
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateObservedTo;

	/**	<br> The entity dateObservedTo
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:dateObservedTo">Find the entity dateObservedTo in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObservedTo(Wrap<String> w);

	public String getDateObservedTo() {
		return dateObservedTo;
	}
	public void setDateObservedTo(String o) {
		this.dateObservedTo = PhotovoltaicMeasurement.staticSetDateObservedTo(siteRequest_, o);
	}
	public static String staticSetDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement dateObservedToInit() {
		Wrap<String> dateObservedToWrap = new Wrap<String>().var("dateObservedTo");
		if(dateObservedTo == null) {
			_dateObservedTo(dateObservedToWrap);
			Optional.ofNullable(dateObservedToWrap.getO()).ifPresent(o -> {
				setDateObservedTo(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDateObservedTo(siteRequest_, PhotovoltaicMeasurement.staticSetDateObservedTo(siteRequest_, o)).toString();
	}

	public String sqlDateObservedTo() {
		return dateObservedTo;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = PhotovoltaicMeasurement.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchDescription(siteRequest_, PhotovoltaicMeasurement.staticSetDescription(siteRequest_, o)).toString();
	}

	public String sqlDescription() {
		return description;
	}

	////////////////////
	// inverterStatus //
	////////////////////


	/**	 The entity inverterStatus
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject inverterStatus;

	/**	<br> The entity inverterStatus
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:inverterStatus">Find the entity inverterStatus in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _inverterStatus(Wrap<JsonObject> w);

	public JsonObject getInverterStatus() {
		return inverterStatus;
	}

	public void setInverterStatus(JsonObject inverterStatus) {
		this.inverterStatus = inverterStatus;
	}
	@JsonIgnore
	public void setInverterStatus(String o) {
		this.inverterStatus = PhotovoltaicMeasurement.staticSetInverterStatus(siteRequest_, o);
	}
	public static JsonObject staticSetInverterStatus(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurement inverterStatusInit() {
		Wrap<JsonObject> inverterStatusWrap = new Wrap<JsonObject>().var("inverterStatus");
		if(inverterStatus == null) {
			_inverterStatus(inverterStatusWrap);
			Optional.ofNullable(inverterStatusWrap.getO()).ifPresent(o -> {
				setInverterStatus(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchInverterStatus(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrInverterStatus(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInverterStatus(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchInverterStatus(siteRequest_, PhotovoltaicMeasurement.staticSetInverterStatus(siteRequest_, o)).toString();
	}

	public JsonObject sqlInverterStatus() {
		return inverterStatus;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
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
		this.location = PhotovoltaicMeasurement.staticSetLocation(siteRequest_, o);
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
		this.location = PhotovoltaicMeasurement.staticSetLocation(siteRequest_, o);
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
	protected PhotovoltaicMeasurement locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Point staticSearchLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchLocation(siteRequest_, PhotovoltaicMeasurement.staticSetLocation(siteRequest_, o)).toString();
	}

	public Point sqlLocation() {
		return location;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = PhotovoltaicMeasurement.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchName(siteRequest_, PhotovoltaicMeasurement.staticSetName(siteRequest_, o)).toString();
	}

	public String sqlName() {
		return name;
	}

	////////////////////////////////
	// nominalPeakPowerGeneration //
	////////////////////////////////


	/**	 The entity nominalPeakPowerGeneration
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal nominalPeakPowerGeneration;

	/**	<br> The entity nominalPeakPowerGeneration
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:nominalPeakPowerGeneration">Find the entity nominalPeakPowerGeneration in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _nominalPeakPowerGeneration(Wrap<BigDecimal> w);

	public BigDecimal getNominalPeakPowerGeneration() {
		return nominalPeakPowerGeneration;
	}

	public void setNominalPeakPowerGeneration(BigDecimal nominalPeakPowerGeneration) {
		this.nominalPeakPowerGeneration = nominalPeakPowerGeneration;
	}
	@JsonIgnore
	public void setNominalPeakPowerGeneration(String o) {
		this.nominalPeakPowerGeneration = PhotovoltaicMeasurement.staticSetNominalPeakPowerGeneration(siteRequest_, o);
	}
	public static BigDecimal staticSetNominalPeakPowerGeneration(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setNominalPeakPowerGeneration(Double o) {
		setNominalPeakPowerGeneration(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalPeakPowerGeneration(Integer o) {
		setNominalPeakPowerGeneration(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setNominalPeakPowerGeneration(Number o) {
		setNominalPeakPowerGeneration(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected PhotovoltaicMeasurement nominalPeakPowerGenerationInit() {
		Wrap<BigDecimal> nominalPeakPowerGenerationWrap = new Wrap<BigDecimal>().var("nominalPeakPowerGeneration");
		if(nominalPeakPowerGeneration == null) {
			_nominalPeakPowerGeneration(nominalPeakPowerGenerationWrap);
			Optional.ofNullable(nominalPeakPowerGenerationWrap.getO()).ifPresent(o -> {
				setNominalPeakPowerGeneration(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Double staticSearchNominalPeakPowerGeneration(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrNominalPeakPowerGeneration(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNominalPeakPowerGeneration(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchNominalPeakPowerGeneration(siteRequest_, PhotovoltaicMeasurement.staticSetNominalPeakPowerGeneration(siteRequest_, o)).toString();
	}

	public BigDecimal sqlNominalPeakPowerGeneration() {
		return nominalPeakPowerGeneration;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
		this.owner = PhotovoltaicMeasurement.staticSetOwner(siteRequest_, o);
	}
	public static JsonObject staticSetOwner(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurement ownerInit() {
		Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
		if(owner == null) {
			_owner(ownerWrap);
			Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
				setOwner(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchOwner(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOwner(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOwner(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchOwner(siteRequest_, PhotovoltaicMeasurement.staticSetOwner(siteRequest_, o)).toString();
	}

	public JsonObject sqlOwner() {
		return owner;
	}

	///////////////////
	// reactivePower //
	///////////////////


	/**	 The entity reactivePower
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal reactivePower;

	/**	<br> The entity reactivePower
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:reactivePower">Find the entity reactivePower in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reactivePower(Wrap<BigDecimal> w);

	public BigDecimal getReactivePower() {
		return reactivePower;
	}

	public void setReactivePower(BigDecimal reactivePower) {
		this.reactivePower = reactivePower;
	}
	@JsonIgnore
	public void setReactivePower(String o) {
		this.reactivePower = PhotovoltaicMeasurement.staticSetReactivePower(siteRequest_, o);
	}
	public static BigDecimal staticSetReactivePower(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setReactivePower(Double o) {
		setReactivePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setReactivePower(Integer o) {
		setReactivePower(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setReactivePower(Number o) {
		setReactivePower(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected PhotovoltaicMeasurement reactivePowerInit() {
		Wrap<BigDecimal> reactivePowerWrap = new Wrap<BigDecimal>().var("reactivePower");
		if(reactivePower == null) {
			_reactivePower(reactivePowerWrap);
			Optional.ofNullable(reactivePowerWrap.getO()).ifPresent(o -> {
				setReactivePower(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Double staticSearchReactivePower(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrReactivePower(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReactivePower(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchReactivePower(siteRequest_, PhotovoltaicMeasurement.staticSetReactivePower(siteRequest_, o)).toString();
	}

	public BigDecimal sqlReactivePower() {
		return reactivePower;
	}

	///////////////////////////
	// refPhotovoltaicDevice //
	///////////////////////////


	/**	 The entity refPhotovoltaicDevice
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject refPhotovoltaicDevice;

	/**	<br> The entity refPhotovoltaicDevice
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:refPhotovoltaicDevice">Find the entity refPhotovoltaicDevice in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _refPhotovoltaicDevice(Wrap<JsonObject> w);

	public JsonObject getRefPhotovoltaicDevice() {
		return refPhotovoltaicDevice;
	}

	public void setRefPhotovoltaicDevice(JsonObject refPhotovoltaicDevice) {
		this.refPhotovoltaicDevice = refPhotovoltaicDevice;
	}
	@JsonIgnore
	public void setRefPhotovoltaicDevice(String o) {
		this.refPhotovoltaicDevice = PhotovoltaicMeasurement.staticSetRefPhotovoltaicDevice(siteRequest_, o);
	}
	public static JsonObject staticSetRefPhotovoltaicDevice(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurement refPhotovoltaicDeviceInit() {
		Wrap<JsonObject> refPhotovoltaicDeviceWrap = new Wrap<JsonObject>().var("refPhotovoltaicDevice");
		if(refPhotovoltaicDevice == null) {
			_refPhotovoltaicDevice(refPhotovoltaicDeviceWrap);
			Optional.ofNullable(refPhotovoltaicDeviceWrap.getO()).ifPresent(o -> {
				setRefPhotovoltaicDevice(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchRefPhotovoltaicDevice(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrRefPhotovoltaicDevice(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefPhotovoltaicDevice(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchRefPhotovoltaicDevice(siteRequest_, PhotovoltaicMeasurement.staticSetRefPhotovoltaicDevice(siteRequest_, o)).toString();
	}

	public JsonObject sqlRefPhotovoltaicDevice() {
		return refPhotovoltaicDevice;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:refPointOfInterest">Find the entity refPointOfInterest in Solr</a>
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
		this.refPointOfInterest = PhotovoltaicMeasurement.staticSetRefPointOfInterest(siteRequest_, o);
	}
	public static JsonObject staticSetRefPointOfInterest(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurement refPointOfInterestInit() {
		Wrap<JsonObject> refPointOfInterestWrap = new Wrap<JsonObject>().var("refPointOfInterest");
		if(refPointOfInterest == null) {
			_refPointOfInterest(refPointOfInterestWrap);
			Optional.ofNullable(refPointOfInterestWrap.getO()).ifPresent(o -> {
				setRefPointOfInterest(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchRefPointOfInterest(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrRefPointOfInterest(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefPointOfInterest(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchRefPointOfInterest(siteRequest_, PhotovoltaicMeasurement.staticSetRefPointOfInterest(siteRequest_, o)).toString();
	}

	public JsonObject sqlRefPointOfInterest() {
		return refPointOfInterest;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
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
		this.seeAlso = PhotovoltaicMeasurement.staticSetSeeAlso(siteRequest_, o);
	}
	public static JsonObject staticSetSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurement seeAlsoInit() {
		Wrap<JsonObject> seeAlsoWrap = new Wrap<JsonObject>().var("seeAlso");
		if(seeAlso == null) {
			_seeAlso(seeAlsoWrap);
			Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
				setSeeAlso(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchSeeAlso(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchSeeAlso(siteRequest_, PhotovoltaicMeasurement.staticSetSeeAlso(siteRequest_, o)).toString();
	}

	public JsonObject sqlSeeAlso() {
		return seeAlso;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = PhotovoltaicMeasurement.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
				setSource(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchSource(siteRequest_, PhotovoltaicMeasurement.staticSetSource(siteRequest_, o)).toString();
	}

	public String sqlSource() {
		return source;
	}

	/////////////////
	// temperature //
	/////////////////


	/**	 The entity temperature
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal temperature;

	/**	<br> The entity temperature
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:temperature">Find the entity temperature in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _temperature(Wrap<BigDecimal> w);

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	@JsonIgnore
	public void setTemperature(String o) {
		this.temperature = PhotovoltaicMeasurement.staticSetTemperature(siteRequest_, o);
	}
	public static BigDecimal staticSetTemperature(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setTemperature(Double o) {
		setTemperature(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setTemperature(Integer o) {
		setTemperature(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setTemperature(Number o) {
		setTemperature(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected PhotovoltaicMeasurement temperatureInit() {
		Wrap<BigDecimal> temperatureWrap = new Wrap<BigDecimal>().var("temperature");
		if(temperature == null) {
			_temperature(temperatureWrap);
			Optional.ofNullable(temperatureWrap.getO()).ifPresent(o -> {
				setTemperature(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static Double staticSearchTemperature(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrTemperature(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTemperature(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchTemperature(siteRequest_, PhotovoltaicMeasurement.staticSetTemperature(siteRequest_, o)).toString();
	}

	public BigDecimal sqlTemperature() {
		return temperature;
	}

	//////////////
	// entityId //
	//////////////


	/**	 The entity entityId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String entityId;

	/**	<br> The entity entityId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:entityId">Find the entity entityId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityId(Wrap<String> w);

	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String o) {
		this.entityId = PhotovoltaicMeasurement.staticSetEntityId(siteRequest_, o);
	}
	public static String staticSetEntityId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement entityIdInit() {
		Wrap<String> entityIdWrap = new Wrap<String>().var("entityId");
		if(entityId == null) {
			_entityId(entityIdWrap);
			Optional.ofNullable(entityIdWrap.getO()).ifPresent(o -> {
				setEntityId(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchEntityId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityId(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchEntityId(siteRequest_, PhotovoltaicMeasurement.staticSetEntityId(siteRequest_, o)).toString();
	}

	public String sqlEntityId() {
		return entityId;
	}

	///////////////////
	// entityShortId //
	///////////////////


	/**	 The entity entityShortId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String entityShortId;

	/**	<br> The entity entityShortId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.photovoltaicmeasurement.PhotovoltaicMeasurement&fq=entiteVar_enUS_indexed_string:entityShortId">Find the entity entityShortId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityShortId(Wrap<String> w);

	public String getEntityShortId() {
		return entityShortId;
	}
	public void setEntityShortId(String o) {
		this.entityShortId = PhotovoltaicMeasurement.staticSetEntityShortId(siteRequest_, o);
	}
	public static String staticSetEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurement entityShortIdInit() {
		Wrap<String> entityShortIdWrap = new Wrap<String>().var("entityShortId");
		if(entityShortId == null) {
			_entityShortId(entityShortIdWrap);
			Optional.ofNullable(entityShortIdWrap.getO()).ifPresent(o -> {
				setEntityShortId(o);
			});
		}
		return (PhotovoltaicMeasurement)this;
	}

	public static String staticSearchEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurement.staticSearchEntityShortId(siteRequest_, PhotovoltaicMeasurement.staticSetEntityShortId(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepPhotovoltaicMeasurement();
	}

	public Future<Void> promiseDeepPhotovoltaicMeasurement() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promisePhotovoltaicMeasurement(promise2);
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

	public Future<Void> promisePhotovoltaicMeasurement(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				activePowerInit();
				addressInit();
				alternateNameInit();
				areaServedColorsInit();
				areaServedTitlesInit();
				areaServedLinksInit();
				areaServedInit();
				currentInit();
				dataProviderInit();
				dateCreatedInit();
				dateEnergyMeteringStartedInit();
				dateModifiedInit();
				dateObservedInit();
				dateObservedFromInit();
				dateObservedToInit();
				descriptionInit();
				inverterStatusInit();
				locationInit();
				nameInit();
				nominalPeakPowerGenerationInit();
				ownerInit();
				reactivePowerInit();
				refPhotovoltaicDeviceInit();
				refPointOfInterestInit();
				seeAlsoInit();
				sourceInit();
				temperatureInit();
				entityIdInit();
				entityShortIdInit();
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
		return promiseDeepPhotovoltaicMeasurement(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestPhotovoltaicMeasurement(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainPhotovoltaicMeasurement(v);
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
	public Object obtainPhotovoltaicMeasurement(String var) {
		PhotovoltaicMeasurement oPhotovoltaicMeasurement = (PhotovoltaicMeasurement)this;
		switch(var) {
			case "activePower":
				return oPhotovoltaicMeasurement.activePower;
			case "address":
				return oPhotovoltaicMeasurement.address;
			case "alternateName":
				return oPhotovoltaicMeasurement.alternateName;
			case "areaServedColors":
				return oPhotovoltaicMeasurement.areaServedColors;
			case "areaServedTitles":
				return oPhotovoltaicMeasurement.areaServedTitles;
			case "areaServedLinks":
				return oPhotovoltaicMeasurement.areaServedLinks;
			case "areaServed":
				return oPhotovoltaicMeasurement.areaServed;
			case "current":
				return oPhotovoltaicMeasurement.current;
			case "dataProvider":
				return oPhotovoltaicMeasurement.dataProvider;
			case "dateCreated":
				return oPhotovoltaicMeasurement.dateCreated;
			case "dateEnergyMeteringStarted":
				return oPhotovoltaicMeasurement.dateEnergyMeteringStarted;
			case "dateModified":
				return oPhotovoltaicMeasurement.dateModified;
			case "dateObserved":
				return oPhotovoltaicMeasurement.dateObserved;
			case "dateObservedFrom":
				return oPhotovoltaicMeasurement.dateObservedFrom;
			case "dateObservedTo":
				return oPhotovoltaicMeasurement.dateObservedTo;
			case "description":
				return oPhotovoltaicMeasurement.description;
			case "inverterStatus":
				return oPhotovoltaicMeasurement.inverterStatus;
			case "location":
				return oPhotovoltaicMeasurement.location;
			case "name":
				return oPhotovoltaicMeasurement.name;
			case "nominalPeakPowerGeneration":
				return oPhotovoltaicMeasurement.nominalPeakPowerGeneration;
			case "owner":
				return oPhotovoltaicMeasurement.owner;
			case "reactivePower":
				return oPhotovoltaicMeasurement.reactivePower;
			case "refPhotovoltaicDevice":
				return oPhotovoltaicMeasurement.refPhotovoltaicDevice;
			case "refPointOfInterest":
				return oPhotovoltaicMeasurement.refPointOfInterest;
			case "seeAlso":
				return oPhotovoltaicMeasurement.seeAlso;
			case "source":
				return oPhotovoltaicMeasurement.source;
			case "temperature":
				return oPhotovoltaicMeasurement.temperature;
			case "entityId":
				return oPhotovoltaicMeasurement.entityId;
			case "entityShortId":
				return oPhotovoltaicMeasurement.entityShortId;
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
				o = relatePhotovoltaicMeasurement(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relatePhotovoltaicMeasurement(String var, Object val) {
		PhotovoltaicMeasurement oPhotovoltaicMeasurement = (PhotovoltaicMeasurement)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetPhotovoltaicMeasurement(entityVar,  siteRequest_, o);
	}
	public static Object staticSetPhotovoltaicMeasurement(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "activePower":
			return PhotovoltaicMeasurement.staticSetActivePower(siteRequest_, o);
		case "address":
			return PhotovoltaicMeasurement.staticSetAddress(siteRequest_, o);
		case "alternateName":
			return PhotovoltaicMeasurement.staticSetAlternateName(siteRequest_, o);
		case "areaServedColors":
			return PhotovoltaicMeasurement.staticSetAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return PhotovoltaicMeasurement.staticSetAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return PhotovoltaicMeasurement.staticSetAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return PhotovoltaicMeasurement.staticSetAreaServed(siteRequest_, o);
		case "current":
			return PhotovoltaicMeasurement.staticSetCurrent(siteRequest_, o);
		case "dataProvider":
			return PhotovoltaicMeasurement.staticSetDataProvider(siteRequest_, o);
		case "dateCreated":
			return PhotovoltaicMeasurement.staticSetDateCreated(siteRequest_, o);
		case "dateEnergyMeteringStarted":
			return PhotovoltaicMeasurement.staticSetDateEnergyMeteringStarted(siteRequest_, o);
		case "dateModified":
			return PhotovoltaicMeasurement.staticSetDateModified(siteRequest_, o);
		case "dateObserved":
			return PhotovoltaicMeasurement.staticSetDateObserved(siteRequest_, o);
		case "dateObservedFrom":
			return PhotovoltaicMeasurement.staticSetDateObservedFrom(siteRequest_, o);
		case "dateObservedTo":
			return PhotovoltaicMeasurement.staticSetDateObservedTo(siteRequest_, o);
		case "description":
			return PhotovoltaicMeasurement.staticSetDescription(siteRequest_, o);
		case "inverterStatus":
			return PhotovoltaicMeasurement.staticSetInverterStatus(siteRequest_, o);
		case "location":
			return PhotovoltaicMeasurement.staticSetLocation(siteRequest_, o);
		case "name":
			return PhotovoltaicMeasurement.staticSetName(siteRequest_, o);
		case "nominalPeakPowerGeneration":
			return PhotovoltaicMeasurement.staticSetNominalPeakPowerGeneration(siteRequest_, o);
		case "owner":
			return PhotovoltaicMeasurement.staticSetOwner(siteRequest_, o);
		case "reactivePower":
			return PhotovoltaicMeasurement.staticSetReactivePower(siteRequest_, o);
		case "refPhotovoltaicDevice":
			return PhotovoltaicMeasurement.staticSetRefPhotovoltaicDevice(siteRequest_, o);
		case "refPointOfInterest":
			return PhotovoltaicMeasurement.staticSetRefPointOfInterest(siteRequest_, o);
		case "seeAlso":
			return PhotovoltaicMeasurement.staticSetSeeAlso(siteRequest_, o);
		case "source":
			return PhotovoltaicMeasurement.staticSetSource(siteRequest_, o);
		case "temperature":
			return PhotovoltaicMeasurement.staticSetTemperature(siteRequest_, o);
		case "entityId":
			return PhotovoltaicMeasurement.staticSetEntityId(siteRequest_, o);
		case "entityShortId":
			return PhotovoltaicMeasurement.staticSetEntityShortId(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchPhotovoltaicMeasurement(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchPhotovoltaicMeasurement(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "activePower":
			return PhotovoltaicMeasurement.staticSearchActivePower(siteRequest_, (BigDecimal)o);
		case "address":
			return PhotovoltaicMeasurement.staticSearchAddress(siteRequest_, (JsonObject)o);
		case "alternateName":
			return PhotovoltaicMeasurement.staticSearchAlternateName(siteRequest_, (String)o);
		case "areaServedColors":
			return PhotovoltaicMeasurement.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return PhotovoltaicMeasurement.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return PhotovoltaicMeasurement.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return PhotovoltaicMeasurement.staticSearchAreaServed(siteRequest_, (Polygon)o);
		case "current":
			return PhotovoltaicMeasurement.staticSearchCurrent(siteRequest_, (BigDecimal)o);
		case "dataProvider":
			return PhotovoltaicMeasurement.staticSearchDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return PhotovoltaicMeasurement.staticSearchDateCreated(siteRequest_, (String)o);
		case "dateEnergyMeteringStarted":
			return PhotovoltaicMeasurement.staticSearchDateEnergyMeteringStarted(siteRequest_, (String)o);
		case "dateModified":
			return PhotovoltaicMeasurement.staticSearchDateModified(siteRequest_, (String)o);
		case "dateObserved":
			return PhotovoltaicMeasurement.staticSearchDateObserved(siteRequest_, (String)o);
		case "dateObservedFrom":
			return PhotovoltaicMeasurement.staticSearchDateObservedFrom(siteRequest_, (String)o);
		case "dateObservedTo":
			return PhotovoltaicMeasurement.staticSearchDateObservedTo(siteRequest_, (String)o);
		case "description":
			return PhotovoltaicMeasurement.staticSearchDescription(siteRequest_, (String)o);
		case "inverterStatus":
			return PhotovoltaicMeasurement.staticSearchInverterStatus(siteRequest_, (JsonObject)o);
		case "location":
			return PhotovoltaicMeasurement.staticSearchLocation(siteRequest_, (Point)o);
		case "name":
			return PhotovoltaicMeasurement.staticSearchName(siteRequest_, (String)o);
		case "nominalPeakPowerGeneration":
			return PhotovoltaicMeasurement.staticSearchNominalPeakPowerGeneration(siteRequest_, (BigDecimal)o);
		case "owner":
			return PhotovoltaicMeasurement.staticSearchOwner(siteRequest_, (JsonObject)o);
		case "reactivePower":
			return PhotovoltaicMeasurement.staticSearchReactivePower(siteRequest_, (BigDecimal)o);
		case "refPhotovoltaicDevice":
			return PhotovoltaicMeasurement.staticSearchRefPhotovoltaicDevice(siteRequest_, (JsonObject)o);
		case "refPointOfInterest":
			return PhotovoltaicMeasurement.staticSearchRefPointOfInterest(siteRequest_, (JsonObject)o);
		case "seeAlso":
			return PhotovoltaicMeasurement.staticSearchSeeAlso(siteRequest_, (JsonObject)o);
		case "source":
			return PhotovoltaicMeasurement.staticSearchSource(siteRequest_, (String)o);
		case "temperature":
			return PhotovoltaicMeasurement.staticSearchTemperature(siteRequest_, (BigDecimal)o);
		case "entityId":
			return PhotovoltaicMeasurement.staticSearchEntityId(siteRequest_, (String)o);
		case "entityShortId":
			return PhotovoltaicMeasurement.staticSearchEntityShortId(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrPhotovoltaicMeasurement(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrPhotovoltaicMeasurement(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "activePower":
			return PhotovoltaicMeasurement.staticSearchStrActivePower(siteRequest_, (Double)o);
		case "address":
			return PhotovoltaicMeasurement.staticSearchStrAddress(siteRequest_, (String)o);
		case "alternateName":
			return PhotovoltaicMeasurement.staticSearchStrAlternateName(siteRequest_, (String)o);
		case "areaServedColors":
			return PhotovoltaicMeasurement.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return PhotovoltaicMeasurement.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return PhotovoltaicMeasurement.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return PhotovoltaicMeasurement.staticSearchStrAreaServed(siteRequest_, (Polygon)o);
		case "current":
			return PhotovoltaicMeasurement.staticSearchStrCurrent(siteRequest_, (Double)o);
		case "dataProvider":
			return PhotovoltaicMeasurement.staticSearchStrDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return PhotovoltaicMeasurement.staticSearchStrDateCreated(siteRequest_, (String)o);
		case "dateEnergyMeteringStarted":
			return PhotovoltaicMeasurement.staticSearchStrDateEnergyMeteringStarted(siteRequest_, (String)o);
		case "dateModified":
			return PhotovoltaicMeasurement.staticSearchStrDateModified(siteRequest_, (String)o);
		case "dateObserved":
			return PhotovoltaicMeasurement.staticSearchStrDateObserved(siteRequest_, (String)o);
		case "dateObservedFrom":
			return PhotovoltaicMeasurement.staticSearchStrDateObservedFrom(siteRequest_, (String)o);
		case "dateObservedTo":
			return PhotovoltaicMeasurement.staticSearchStrDateObservedTo(siteRequest_, (String)o);
		case "description":
			return PhotovoltaicMeasurement.staticSearchStrDescription(siteRequest_, (String)o);
		case "inverterStatus":
			return PhotovoltaicMeasurement.staticSearchStrInverterStatus(siteRequest_, (String)o);
		case "location":
			return PhotovoltaicMeasurement.staticSearchStrLocation(siteRequest_, (Point)o);
		case "name":
			return PhotovoltaicMeasurement.staticSearchStrName(siteRequest_, (String)o);
		case "nominalPeakPowerGeneration":
			return PhotovoltaicMeasurement.staticSearchStrNominalPeakPowerGeneration(siteRequest_, (Double)o);
		case "owner":
			return PhotovoltaicMeasurement.staticSearchStrOwner(siteRequest_, (String)o);
		case "reactivePower":
			return PhotovoltaicMeasurement.staticSearchStrReactivePower(siteRequest_, (Double)o);
		case "refPhotovoltaicDevice":
			return PhotovoltaicMeasurement.staticSearchStrRefPhotovoltaicDevice(siteRequest_, (String)o);
		case "refPointOfInterest":
			return PhotovoltaicMeasurement.staticSearchStrRefPointOfInterest(siteRequest_, (String)o);
		case "seeAlso":
			return PhotovoltaicMeasurement.staticSearchStrSeeAlso(siteRequest_, (String)o);
		case "source":
			return PhotovoltaicMeasurement.staticSearchStrSource(siteRequest_, (String)o);
		case "temperature":
			return PhotovoltaicMeasurement.staticSearchStrTemperature(siteRequest_, (Double)o);
		case "entityId":
			return PhotovoltaicMeasurement.staticSearchStrEntityId(siteRequest_, (String)o);
		case "entityShortId":
			return PhotovoltaicMeasurement.staticSearchStrEntityShortId(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqPhotovoltaicMeasurement(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqPhotovoltaicMeasurement(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "activePower":
			return PhotovoltaicMeasurement.staticSearchFqActivePower(siteRequest_, o);
		case "address":
			return PhotovoltaicMeasurement.staticSearchFqAddress(siteRequest_, o);
		case "alternateName":
			return PhotovoltaicMeasurement.staticSearchFqAlternateName(siteRequest_, o);
		case "areaServedColors":
			return PhotovoltaicMeasurement.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return PhotovoltaicMeasurement.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return PhotovoltaicMeasurement.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return PhotovoltaicMeasurement.staticSearchFqAreaServed(siteRequest_, o);
		case "current":
			return PhotovoltaicMeasurement.staticSearchFqCurrent(siteRequest_, o);
		case "dataProvider":
			return PhotovoltaicMeasurement.staticSearchFqDataProvider(siteRequest_, o);
		case "dateCreated":
			return PhotovoltaicMeasurement.staticSearchFqDateCreated(siteRequest_, o);
		case "dateEnergyMeteringStarted":
			return PhotovoltaicMeasurement.staticSearchFqDateEnergyMeteringStarted(siteRequest_, o);
		case "dateModified":
			return PhotovoltaicMeasurement.staticSearchFqDateModified(siteRequest_, o);
		case "dateObserved":
			return PhotovoltaicMeasurement.staticSearchFqDateObserved(siteRequest_, o);
		case "dateObservedFrom":
			return PhotovoltaicMeasurement.staticSearchFqDateObservedFrom(siteRequest_, o);
		case "dateObservedTo":
			return PhotovoltaicMeasurement.staticSearchFqDateObservedTo(siteRequest_, o);
		case "description":
			return PhotovoltaicMeasurement.staticSearchFqDescription(siteRequest_, o);
		case "inverterStatus":
			return PhotovoltaicMeasurement.staticSearchFqInverterStatus(siteRequest_, o);
		case "location":
			return PhotovoltaicMeasurement.staticSearchFqLocation(siteRequest_, o);
		case "name":
			return PhotovoltaicMeasurement.staticSearchFqName(siteRequest_, o);
		case "nominalPeakPowerGeneration":
			return PhotovoltaicMeasurement.staticSearchFqNominalPeakPowerGeneration(siteRequest_, o);
		case "owner":
			return PhotovoltaicMeasurement.staticSearchFqOwner(siteRequest_, o);
		case "reactivePower":
			return PhotovoltaicMeasurement.staticSearchFqReactivePower(siteRequest_, o);
		case "refPhotovoltaicDevice":
			return PhotovoltaicMeasurement.staticSearchFqRefPhotovoltaicDevice(siteRequest_, o);
		case "refPointOfInterest":
			return PhotovoltaicMeasurement.staticSearchFqRefPointOfInterest(siteRequest_, o);
		case "seeAlso":
			return PhotovoltaicMeasurement.staticSearchFqSeeAlso(siteRequest_, o);
		case "source":
			return PhotovoltaicMeasurement.staticSearchFqSource(siteRequest_, o);
		case "temperature":
			return PhotovoltaicMeasurement.staticSearchFqTemperature(siteRequest_, o);
		case "entityId":
			return PhotovoltaicMeasurement.staticSearchFqEntityId(siteRequest_, o);
		case "entityShortId":
			return PhotovoltaicMeasurement.staticSearchFqEntityShortId(siteRequest_, o);
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
					o = persistPhotovoltaicMeasurement(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistPhotovoltaicMeasurement(String var, Object val) {
		String varLower = var.toLowerCase();
			if("activepower".equals(varLower)) {
				if(val instanceof String) {
					setActivePower((String)val);
				} else if(val instanceof Number) {
					setActivePower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("activePower");
				return val;
			} else if("address".equals(varLower)) {
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
			} else if("areaserved".equals(varLower)) {
				if(val instanceof Polygon) {
					setAreaServed((Polygon)val);
				} else {
					setAreaServed(val == null ? null : val.toString());
				}
				saves.add("areaServed");
				return val;
			} else if("current".equals(varLower)) {
				if(val instanceof String) {
					setCurrent((String)val);
				} else if(val instanceof Number) {
					setCurrent(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("current");
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
			} else if("dateenergymeteringstarted".equals(varLower)) {
				if(val instanceof String) {
					setDateEnergyMeteringStarted((String)val);
				}
				saves.add("dateEnergyMeteringStarted");
				return val;
			} else if("datemodified".equals(varLower)) {
				if(val instanceof String) {
					setDateModified((String)val);
				}
				saves.add("dateModified");
				return val;
			} else if("dateobserved".equals(varLower)) {
				if(val instanceof String) {
					setDateObserved((String)val);
				}
				saves.add("dateObserved");
				return val;
			} else if("dateobservedfrom".equals(varLower)) {
				if(val instanceof String) {
					setDateObservedFrom((String)val);
				}
				saves.add("dateObservedFrom");
				return val;
			} else if("dateobservedto".equals(varLower)) {
				if(val instanceof String) {
					setDateObservedTo((String)val);
				}
				saves.add("dateObservedTo");
				return val;
			} else if("description".equals(varLower)) {
				if(val instanceof String) {
					setDescription((String)val);
				}
				saves.add("description");
				return val;
			} else if("inverterstatus".equals(varLower)) {
				if(val instanceof String) {
					setInverterStatus((String)val);
				} else if(val instanceof JsonObject) {
					setInverterStatus((JsonObject)val);
				}
				saves.add("inverterStatus");
				return val;
			} else if("location".equals(varLower)) {
				if(val instanceof String) {
					setLocation((String)val);
				} else if(val instanceof Point) {
					setLocation((Point)val);
				}
				saves.add("location");
				return val;
			} else if("name".equals(varLower)) {
				if(val instanceof String) {
					setName((String)val);
				}
				saves.add("name");
				return val;
			} else if("nominalpeakpowergeneration".equals(varLower)) {
				if(val instanceof String) {
					setNominalPeakPowerGeneration((String)val);
				} else if(val instanceof Number) {
					setNominalPeakPowerGeneration(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("nominalPeakPowerGeneration");
				return val;
			} else if("owner".equals(varLower)) {
				if(val instanceof String) {
					setOwner((String)val);
				} else if(val instanceof JsonObject) {
					setOwner((JsonObject)val);
				}
				saves.add("owner");
				return val;
			} else if("reactivepower".equals(varLower)) {
				if(val instanceof String) {
					setReactivePower((String)val);
				} else if(val instanceof Number) {
					setReactivePower(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("reactivePower");
				return val;
			} else if("refphotovoltaicdevice".equals(varLower)) {
				if(val instanceof String) {
					setRefPhotovoltaicDevice((String)val);
				} else if(val instanceof JsonObject) {
					setRefPhotovoltaicDevice((JsonObject)val);
				}
				saves.add("refPhotovoltaicDevice");
				return val;
			} else if("refpointofinterest".equals(varLower)) {
				if(val instanceof String) {
					setRefPointOfInterest((String)val);
				} else if(val instanceof JsonObject) {
					setRefPointOfInterest((JsonObject)val);
				}
				saves.add("refPointOfInterest");
				return val;
			} else if("seealso".equals(varLower)) {
				if(val instanceof String) {
					setSeeAlso((String)val);
				} else if(val instanceof JsonObject) {
					setSeeAlso((JsonObject)val);
				}
				saves.add("seeAlso");
				return val;
			} else if("source".equals(varLower)) {
				if(val instanceof String) {
					setSource((String)val);
				}
				saves.add("source");
				return val;
			} else if("temperature".equals(varLower)) {
				if(val instanceof String) {
					setTemperature((String)val);
				} else if(val instanceof Number) {
					setTemperature(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("temperature");
				return val;
			} else if("entityid".equals(varLower)) {
				if(val instanceof String) {
					setEntityId((String)val);
				}
				saves.add("entityId");
				return val;
		} else {
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populatePhotovoltaicMeasurement(doc);
	}
	public void populatePhotovoltaicMeasurement(SolrResponse.Doc doc) {
		PhotovoltaicMeasurement oPhotovoltaicMeasurement = (PhotovoltaicMeasurement)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("activePower")) {
				Double activePower = (Double)doc.get("activePower_docvalues_double");
				if(activePower != null)
					oPhotovoltaicMeasurement.setActivePower(activePower);
			}

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oPhotovoltaicMeasurement.setAddress(address);
			}

			if(saves.contains("alternateName")) {
				String alternateName = (String)doc.get("alternateName_docvalues_string");
				if(alternateName != null)
					oPhotovoltaicMeasurement.setAlternateName(alternateName);
			}

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null)
					oPhotovoltaicMeasurement.areaServedColors.addAll(areaServedColors);
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null)
					oPhotovoltaicMeasurement.areaServedTitles.addAll(areaServedTitles);
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null)
					oPhotovoltaicMeasurement.areaServedLinks.addAll(areaServedLinks);
			}

			if(saves.contains("areaServed")) {
				Polygon areaServed = (Polygon)doc.get("areaServed_docvalues_location");
				if(areaServed != null)
					oPhotovoltaicMeasurement.setAreaServed(areaServed);
			}

			if(saves.contains("current")) {
				Double current = (Double)doc.get("current_docvalues_double");
				if(current != null)
					oPhotovoltaicMeasurement.setCurrent(current);
			}

			if(saves.contains("dataProvider")) {
				String dataProvider = (String)doc.get("dataProvider_docvalues_string");
				if(dataProvider != null)
					oPhotovoltaicMeasurement.setDataProvider(dataProvider);
			}

			if(saves.contains("dateCreated")) {
				String dateCreated = (String)doc.get("dateCreated_docvalues_string");
				if(dateCreated != null)
					oPhotovoltaicMeasurement.setDateCreated(dateCreated);
			}

			if(saves.contains("dateEnergyMeteringStarted")) {
				String dateEnergyMeteringStarted = (String)doc.get("dateEnergyMeteringStarted_docvalues_string");
				if(dateEnergyMeteringStarted != null)
					oPhotovoltaicMeasurement.setDateEnergyMeteringStarted(dateEnergyMeteringStarted);
			}

			if(saves.contains("dateModified")) {
				String dateModified = (String)doc.get("dateModified_docvalues_string");
				if(dateModified != null)
					oPhotovoltaicMeasurement.setDateModified(dateModified);
			}

			if(saves.contains("dateObserved")) {
				String dateObserved = (String)doc.get("dateObserved_docvalues_string");
				if(dateObserved != null)
					oPhotovoltaicMeasurement.setDateObserved(dateObserved);
			}

			if(saves.contains("dateObservedFrom")) {
				String dateObservedFrom = (String)doc.get("dateObservedFrom_docvalues_string");
				if(dateObservedFrom != null)
					oPhotovoltaicMeasurement.setDateObservedFrom(dateObservedFrom);
			}

			if(saves.contains("dateObservedTo")) {
				String dateObservedTo = (String)doc.get("dateObservedTo_docvalues_string");
				if(dateObservedTo != null)
					oPhotovoltaicMeasurement.setDateObservedTo(dateObservedTo);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oPhotovoltaicMeasurement.setDescription(description);
			}

			if(saves.contains("inverterStatus")) {
				String inverterStatus = (String)doc.get("inverterStatus_docvalues_string");
				if(inverterStatus != null)
					oPhotovoltaicMeasurement.setInverterStatus(inverterStatus);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oPhotovoltaicMeasurement.setLocation(location);
			}

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oPhotovoltaicMeasurement.setName(name);
			}

			if(saves.contains("nominalPeakPowerGeneration")) {
				Double nominalPeakPowerGeneration = (Double)doc.get("nominalPeakPowerGeneration_docvalues_double");
				if(nominalPeakPowerGeneration != null)
					oPhotovoltaicMeasurement.setNominalPeakPowerGeneration(nominalPeakPowerGeneration);
			}

			if(saves.contains("owner")) {
				String owner = (String)doc.get("owner_docvalues_string");
				if(owner != null)
					oPhotovoltaicMeasurement.setOwner(owner);
			}

			if(saves.contains("reactivePower")) {
				Double reactivePower = (Double)doc.get("reactivePower_docvalues_double");
				if(reactivePower != null)
					oPhotovoltaicMeasurement.setReactivePower(reactivePower);
			}

			if(saves.contains("refPhotovoltaicDevice")) {
				String refPhotovoltaicDevice = (String)doc.get("refPhotovoltaicDevice_docvalues_string");
				if(refPhotovoltaicDevice != null)
					oPhotovoltaicMeasurement.setRefPhotovoltaicDevice(refPhotovoltaicDevice);
			}

			if(saves.contains("refPointOfInterest")) {
				String refPointOfInterest = (String)doc.get("refPointOfInterest_docvalues_string");
				if(refPointOfInterest != null)
					oPhotovoltaicMeasurement.setRefPointOfInterest(refPointOfInterest);
			}

			if(saves.contains("seeAlso")) {
				String seeAlso = (String)doc.get("seeAlso_docvalues_string");
				if(seeAlso != null)
					oPhotovoltaicMeasurement.setSeeAlso(seeAlso);
			}

			if(saves.contains("source")) {
				String source = (String)doc.get("source_docvalues_string");
				if(source != null)
					oPhotovoltaicMeasurement.setSource(source);
			}

			if(saves.contains("temperature")) {
				Double temperature = (Double)doc.get("temperature_docvalues_double");
				if(temperature != null)
					oPhotovoltaicMeasurement.setTemperature(temperature);
			}

			if(saves.contains("entityId")) {
				String entityId = (String)doc.get("entityId_docvalues_string");
				if(entityId != null)
					oPhotovoltaicMeasurement.setEntityId(entityId);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexPhotovoltaicMeasurement(JsonObject doc) {
		if(activePower != null) {
			doc.put("activePower_docvalues_double", activePower.doubleValue());
		}
		if(address != null) {
			doc.put("address_docvalues_string", address.toString());
		}
		if(alternateName != null) {
			doc.put("alternateName_docvalues_string", alternateName);
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
		if(current != null) {
			doc.put("current_docvalues_double", current.doubleValue());
		}
		if(dataProvider != null) {
			doc.put("dataProvider_docvalues_string", dataProvider);
		}
		if(dateCreated != null) {
			doc.put("dateCreated_docvalues_string", dateCreated);
		}
		if(dateEnergyMeteringStarted != null) {
			doc.put("dateEnergyMeteringStarted_docvalues_string", dateEnergyMeteringStarted);
		}
		if(dateModified != null) {
			doc.put("dateModified_docvalues_string", dateModified);
		}
		if(dateObserved != null) {
			doc.put("dateObserved_docvalues_string", dateObserved);
		}
		if(dateObservedFrom != null) {
			doc.put("dateObservedFrom_docvalues_string", dateObservedFrom);
		}
		if(dateObservedTo != null) {
			doc.put("dateObservedTo_docvalues_string", dateObservedTo);
		}
		if(description != null) {
			doc.put("description_docvalues_string", description);
		}
		if(inverterStatus != null) {
			doc.put("inverterStatus_docvalues_string", inverterStatus.toString());
		}
		if(location != null) {
			doc.put("location_docvalues_location", String.format("%s,%s", location.getX(), location.getY()));
		}
		if(name != null) {
			doc.put("name_docvalues_string", name);
		}
		if(nominalPeakPowerGeneration != null) {
			doc.put("nominalPeakPowerGeneration_docvalues_double", nominalPeakPowerGeneration.doubleValue());
		}
		if(owner != null) {
			doc.put("owner_docvalues_string", owner.toString());
		}
		if(reactivePower != null) {
			doc.put("reactivePower_docvalues_double", reactivePower.doubleValue());
		}
		if(refPhotovoltaicDevice != null) {
			doc.put("refPhotovoltaicDevice_docvalues_string", refPhotovoltaicDevice.toString());
		}
		if(refPointOfInterest != null) {
			doc.put("refPointOfInterest_docvalues_string", refPointOfInterest.toString());
		}
		if(seeAlso != null) {
			doc.put("seeAlso_docvalues_string", seeAlso.toString());
		}
		if(source != null) {
			doc.put("source_docvalues_string", source);
		}
		if(temperature != null) {
			doc.put("temperature_docvalues_double", temperature.doubleValue());
		}
		if(entityId != null) {
			doc.put("entityId_docvalues_string", entityId);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredPhotovoltaicMeasurement(String entityVar) {
		switch(entityVar) {
			case "activePower":
				return "activePower_docvalues_double";
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_location";
			case "current":
				return "current_docvalues_double";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateEnergyMeteringStarted":
				return "dateEnergyMeteringStarted_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "dateObserved":
				return "dateObserved_docvalues_string";
			case "dateObservedFrom":
				return "dateObservedFrom_docvalues_string";
			case "dateObservedTo":
				return "dateObservedTo_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "inverterStatus":
				return "inverterStatus_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "name":
				return "name_docvalues_string";
			case "nominalPeakPowerGeneration":
				return "nominalPeakPowerGeneration_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "reactivePower":
				return "reactivePower_docvalues_double";
			case "refPhotovoltaicDevice":
				return "refPhotovoltaicDevice_docvalues_string";
			case "refPointOfInterest":
				return "refPointOfInterest_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "temperature":
				return "temperature_docvalues_double";
			case "entityId":
				return "entityId_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedPhotovoltaicMeasurement(String entityVar) {
		switch(entityVar) {
			case "activePower":
				return "activePower_docvalues_double";
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_location";
			case "current":
				return "current_docvalues_double";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateEnergyMeteringStarted":
				return "dateEnergyMeteringStarted_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "dateObserved":
				return "dateObserved_docvalues_string";
			case "dateObservedFrom":
				return "dateObservedFrom_docvalues_string";
			case "dateObservedTo":
				return "dateObservedTo_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "inverterStatus":
				return "inverterStatus_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "name":
				return "name_docvalues_string";
			case "nominalPeakPowerGeneration":
				return "nominalPeakPowerGeneration_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "reactivePower":
				return "reactivePower_docvalues_double";
			case "refPhotovoltaicDevice":
				return "refPhotovoltaicDevice_docvalues_string";
			case "refPointOfInterest":
				return "refPointOfInterest_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "temperature":
				return "temperature_docvalues_double";
			case "entityId":
				return "entityId_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarPhotovoltaicMeasurement(String searchVar) {
		switch(searchVar) {
			case "activePower_docvalues_double":
				return "activePower";
			case "address_docvalues_string":
				return "address";
			case "alternateName_docvalues_string":
				return "alternateName";
			case "areaServedColors_indexedstored_strings":
				return "areaServedColors";
			case "areaServedTitles_indexedstored_strings":
				return "areaServedTitles";
			case "areaServedLinks_indexedstored_strings":
				return "areaServedLinks";
			case "areaServed_docvalues_location":
				return "areaServed";
			case "current_docvalues_double":
				return "current";
			case "dataProvider_docvalues_string":
				return "dataProvider";
			case "dateCreated_docvalues_string":
				return "dateCreated";
			case "dateEnergyMeteringStarted_docvalues_string":
				return "dateEnergyMeteringStarted";
			case "dateModified_docvalues_string":
				return "dateModified";
			case "dateObserved_docvalues_string":
				return "dateObserved";
			case "dateObservedFrom_docvalues_string":
				return "dateObservedFrom";
			case "dateObservedTo_docvalues_string":
				return "dateObservedTo";
			case "description_docvalues_string":
				return "description";
			case "inverterStatus_docvalues_string":
				return "inverterStatus";
			case "location_docvalues_location":
				return "location";
			case "name_docvalues_string":
				return "name";
			case "nominalPeakPowerGeneration_docvalues_double":
				return "nominalPeakPowerGeneration";
			case "owner_docvalues_string":
				return "owner";
			case "reactivePower_docvalues_double":
				return "reactivePower";
			case "refPhotovoltaicDevice_docvalues_string":
				return "refPhotovoltaicDevice";
			case "refPointOfInterest_docvalues_string":
				return "refPointOfInterest";
			case "seeAlso_docvalues_string":
				return "seeAlso";
			case "source_docvalues_string":
				return "source";
			case "temperature_docvalues_double":
				return "temperature";
			case "entityId_docvalues_string":
				return "entityId";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchPhotovoltaicMeasurement(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedPhotovoltaicMeasurement(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storePhotovoltaicMeasurement(doc);
	}
	public void storePhotovoltaicMeasurement(SolrResponse.Doc doc) {
		PhotovoltaicMeasurement oPhotovoltaicMeasurement = (PhotovoltaicMeasurement)this;
		SiteRequestEnUS siteRequest = oPhotovoltaicMeasurement.getSiteRequest_();

		oPhotovoltaicMeasurement.setActivePower(Optional.ofNullable(doc.get("activePower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oPhotovoltaicMeasurement.addAreaServedColors(PhotovoltaicMeasurement.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oPhotovoltaicMeasurement.addAreaServedTitles(PhotovoltaicMeasurement.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oPhotovoltaicMeasurement.addAreaServedLinks(PhotovoltaicMeasurement.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		oPhotovoltaicMeasurement.setAreaServed(Optional.ofNullable(doc.get("areaServed_docvalues_location")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setCurrent(Optional.ofNullable(doc.get("current_docvalues_double")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDateEnergyMeteringStarted(Optional.ofNullable(doc.get("dateEnergyMeteringStarted_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDateObserved(Optional.ofNullable(doc.get("dateObserved_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDateObservedFrom(Optional.ofNullable(doc.get("dateObservedFrom_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDateObservedTo(Optional.ofNullable(doc.get("dateObservedTo_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setInverterStatus(Optional.ofNullable(doc.get("inverterStatus_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setNominalPeakPowerGeneration(Optional.ofNullable(doc.get("nominalPeakPowerGeneration_docvalues_double")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setReactivePower(Optional.ofNullable(doc.get("reactivePower_docvalues_double")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setRefPhotovoltaicDevice(Optional.ofNullable(doc.get("refPhotovoltaicDevice_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setRefPointOfInterest(Optional.ofNullable(doc.get("refPointOfInterest_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setTemperature(Optional.ofNullable(doc.get("temperature_docvalues_double")).map(v -> v.toString()).orElse(null));
		oPhotovoltaicMeasurement.setEntityId(Optional.ofNullable(doc.get("entityId_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestPhotovoltaicMeasurement() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof PhotovoltaicMeasurement) {
			PhotovoltaicMeasurement original = (PhotovoltaicMeasurement)o;
			if(!Objects.equals(activePower, original.getActivePower()) && activePower != null && original.getActivePower() != null && activePower.compareTo(original.getActivePower()) != 0)
				apiRequest.addVars("activePower");
			if(!Objects.equals(address, original.getAddress()))
				apiRequest.addVars("address");
			if(!Objects.equals(alternateName, original.getAlternateName()))
				apiRequest.addVars("alternateName");
			if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
				apiRequest.addVars("areaServedColors");
			if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
				apiRequest.addVars("areaServedTitles");
			if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
				apiRequest.addVars("areaServedLinks");
			if(!Objects.equals(areaServed, original.getAreaServed()))
				apiRequest.addVars("areaServed");
			if(!Objects.equals(current, original.getCurrent()) && current != null && original.getCurrent() != null && current.compareTo(original.getCurrent()) != 0)
				apiRequest.addVars("current");
			if(!Objects.equals(dataProvider, original.getDataProvider()))
				apiRequest.addVars("dataProvider");
			if(!Objects.equals(dateCreated, original.getDateCreated()))
				apiRequest.addVars("dateCreated");
			if(!Objects.equals(dateEnergyMeteringStarted, original.getDateEnergyMeteringStarted()))
				apiRequest.addVars("dateEnergyMeteringStarted");
			if(!Objects.equals(dateModified, original.getDateModified()))
				apiRequest.addVars("dateModified");
			if(!Objects.equals(dateObserved, original.getDateObserved()))
				apiRequest.addVars("dateObserved");
			if(!Objects.equals(dateObservedFrom, original.getDateObservedFrom()))
				apiRequest.addVars("dateObservedFrom");
			if(!Objects.equals(dateObservedTo, original.getDateObservedTo()))
				apiRequest.addVars("dateObservedTo");
			if(!Objects.equals(description, original.getDescription()))
				apiRequest.addVars("description");
			if(!Objects.equals(inverterStatus, original.getInverterStatus()))
				apiRequest.addVars("inverterStatus");
			if(!Objects.equals(location, original.getLocation()))
				apiRequest.addVars("location");
			if(!Objects.equals(name, original.getName()))
				apiRequest.addVars("name");
			if(!Objects.equals(nominalPeakPowerGeneration, original.getNominalPeakPowerGeneration()) && nominalPeakPowerGeneration != null && original.getNominalPeakPowerGeneration() != null && nominalPeakPowerGeneration.compareTo(original.getNominalPeakPowerGeneration()) != 0)
				apiRequest.addVars("nominalPeakPowerGeneration");
			if(!Objects.equals(owner, original.getOwner()))
				apiRequest.addVars("owner");
			if(!Objects.equals(reactivePower, original.getReactivePower()) && reactivePower != null && original.getReactivePower() != null && reactivePower.compareTo(original.getReactivePower()) != 0)
				apiRequest.addVars("reactivePower");
			if(!Objects.equals(refPhotovoltaicDevice, original.getRefPhotovoltaicDevice()))
				apiRequest.addVars("refPhotovoltaicDevice");
			if(!Objects.equals(refPointOfInterest, original.getRefPointOfInterest()))
				apiRequest.addVars("refPointOfInterest");
			if(!Objects.equals(seeAlso, original.getSeeAlso()))
				apiRequest.addVars("seeAlso");
			if(!Objects.equals(source, original.getSource()))
				apiRequest.addVars("source");
			if(!Objects.equals(temperature, original.getTemperature()) && temperature != null && original.getTemperature() != null && temperature.compareTo(original.getTemperature()) != 0)
				apiRequest.addVars("temperature");
			if(!Objects.equals(entityId, original.getEntityId()))
				apiRequest.addVars("entityId");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(activePower).map(v -> "activePower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(current).map(v -> "current: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateEnergyMeteringStarted).map(v -> "dateEnergyMeteringStarted: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObserved).map(v -> "dateObserved: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObservedFrom).map(v -> "dateObservedFrom: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObservedTo).map(v -> "dateObservedTo: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(inverterStatus).map(v -> "inverterStatus: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(name).map(v -> "name: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(nominalPeakPowerGeneration).map(v -> "nominalPeakPowerGeneration: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(reactivePower).map(v -> "reactivePower: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(refPhotovoltaicDevice).map(v -> "refPhotovoltaicDevice: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(refPointOfInterest).map(v -> "refPointOfInterest: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(temperature).map(v -> "temperature: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(entityId).map(v -> "entityId: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "PhotovoltaicMeasurement";
	public static final String CLASS_API_ADDRESS_PhotovoltaicMeasurement = "smartabyar-smartvillage-enUS-PhotovoltaicMeasurement";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_PhotovoltaicMeasurement;
	}
	public static final String VAR_activePower = "activePower";
	public static final String VAR_address = "address";
	public static final String VAR_alternateName = "alternateName";
	public static final String VAR_areaServedColors = "areaServedColors";
	public static final String VAR_areaServedTitles = "areaServedTitles";
	public static final String VAR_areaServedLinks = "areaServedLinks";
	public static final String VAR_areaServed = "areaServed";
	public static final String VAR_current = "current";
	public static final String VAR_dataProvider = "dataProvider";
	public static final String VAR_dateCreated = "dateCreated";
	public static final String VAR_dateEnergyMeteringStarted = "dateEnergyMeteringStarted";
	public static final String VAR_dateModified = "dateModified";
	public static final String VAR_dateObserved = "dateObserved";
	public static final String VAR_dateObservedFrom = "dateObservedFrom";
	public static final String VAR_dateObservedTo = "dateObservedTo";
	public static final String VAR_description = "description";
	public static final String VAR_inverterStatus = "inverterStatus";
	public static final String VAR_location = "location";
	public static final String VAR_name = "name";
	public static final String VAR_nominalPeakPowerGeneration = "nominalPeakPowerGeneration";
	public static final String VAR_owner = "owner";
	public static final String VAR_reactivePower = "reactivePower";
	public static final String VAR_refPhotovoltaicDevice = "refPhotovoltaicDevice";
	public static final String VAR_refPointOfInterest = "refPointOfInterest";
	public static final String VAR_seeAlso = "seeAlso";
	public static final String VAR_source = "source";
	public static final String VAR_temperature = "temperature";
	public static final String VAR_entityId = "entityId";
	public static final String VAR_entityShortId = "entityShortId";

	public static List<String> varsQForClass() {
		return PhotovoltaicMeasurement.varsQPhotovoltaicMeasurement(new ArrayList<String>());
	}
	public static List<String> varsQPhotovoltaicMeasurement(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return PhotovoltaicMeasurement.varsFqPhotovoltaicMeasurement(new ArrayList<String>());
	}
	public static List<String> varsFqPhotovoltaicMeasurement(List<String> vars) {
		vars.add(VAR_activePower);
		vars.add(VAR_address);
		vars.add(VAR_alternateName);
		vars.add(VAR_areaServed);
		vars.add(VAR_current);
		vars.add(VAR_dataProvider);
		vars.add(VAR_dateCreated);
		vars.add(VAR_dateEnergyMeteringStarted);
		vars.add(VAR_dateModified);
		vars.add(VAR_dateObserved);
		vars.add(VAR_dateObservedFrom);
		vars.add(VAR_dateObservedTo);
		vars.add(VAR_description);
		vars.add(VAR_inverterStatus);
		vars.add(VAR_location);
		vars.add(VAR_name);
		vars.add(VAR_nominalPeakPowerGeneration);
		vars.add(VAR_owner);
		vars.add(VAR_reactivePower);
		vars.add(VAR_refPhotovoltaicDevice);
		vars.add(VAR_refPointOfInterest);
		vars.add(VAR_seeAlso);
		vars.add(VAR_source);
		vars.add(VAR_temperature);
		vars.add(VAR_entityId);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return PhotovoltaicMeasurement.varsRangePhotovoltaicMeasurement(new ArrayList<String>());
	}
	public static List<String> varsRangePhotovoltaicMeasurement(List<String> vars) {
		vars.add(VAR_activePower);
		vars.add(VAR_address);
		vars.add(VAR_current);
		vars.add(VAR_inverterStatus);
		vars.add(VAR_location);
		vars.add(VAR_nominalPeakPowerGeneration);
		vars.add(VAR_owner);
		vars.add(VAR_reactivePower);
		vars.add(VAR_refPhotovoltaicDevice);
		vars.add(VAR_refPointOfInterest);
		vars.add(VAR_seeAlso);
		vars.add(VAR_temperature);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_activePower = "active power";
	public static final String DISPLAY_NAME_address = "address";
	public static final String DISPLAY_NAME_alternateName = "alternate name";
	public static final String DISPLAY_NAME_areaServedColors = "area served colors";
	public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
	public static final String DISPLAY_NAME_areaServedLinks = "area served links";
	public static final String DISPLAY_NAME_areaServed = "area served";
	public static final String DISPLAY_NAME_current = "current";
	public static final String DISPLAY_NAME_dataProvider = "data provider";
	public static final String DISPLAY_NAME_dateCreated = "date created";
	public static final String DISPLAY_NAME_dateEnergyMeteringStarted = "date energy metering started";
	public static final String DISPLAY_NAME_dateModified = "date modified";
	public static final String DISPLAY_NAME_dateObserved = "date observed";
	public static final String DISPLAY_NAME_dateObservedFrom = "date observed from";
	public static final String DISPLAY_NAME_dateObservedTo = "date observed to";
	public static final String DISPLAY_NAME_description = "description";
	public static final String DISPLAY_NAME_inverterStatus = "inverter status";
	public static final String DISPLAY_NAME_location = "location";
	public static final String DISPLAY_NAME_name = "name";
	public static final String DISPLAY_NAME_nominalPeakPowerGeneration = "nominal peak power generation";
	public static final String DISPLAY_NAME_owner = "owner";
	public static final String DISPLAY_NAME_reactivePower = "reactive power";
	public static final String DISPLAY_NAME_refPhotovoltaicDevice = "ref photovoltaic device";
	public static final String DISPLAY_NAME_refPointOfInterest = "ref point of interest";
	public static final String DISPLAY_NAME_seeAlso = "see also";
	public static final String DISPLAY_NAME_source = "source";
	public static final String DISPLAY_NAME_temperature = "temperature";
	public static final String DISPLAY_NAME_entityId = "entity ID";
	public static final String DISPLAY_NAME_entityShortId = "short entity ID";

	public static String displayNameForClass(String var) {
		return PhotovoltaicMeasurement.displayNamePhotovoltaicMeasurement(var);
	}
	public static String displayNamePhotovoltaicMeasurement(String var) {
		switch(var) {
		case VAR_activePower:
			return DISPLAY_NAME_activePower;
		case VAR_address:
			return DISPLAY_NAME_address;
		case VAR_alternateName:
			return DISPLAY_NAME_alternateName;
		case VAR_areaServedColors:
			return DISPLAY_NAME_areaServedColors;
		case VAR_areaServedTitles:
			return DISPLAY_NAME_areaServedTitles;
		case VAR_areaServedLinks:
			return DISPLAY_NAME_areaServedLinks;
		case VAR_areaServed:
			return DISPLAY_NAME_areaServed;
		case VAR_current:
			return DISPLAY_NAME_current;
		case VAR_dataProvider:
			return DISPLAY_NAME_dataProvider;
		case VAR_dateCreated:
			return DISPLAY_NAME_dateCreated;
		case VAR_dateEnergyMeteringStarted:
			return DISPLAY_NAME_dateEnergyMeteringStarted;
		case VAR_dateModified:
			return DISPLAY_NAME_dateModified;
		case VAR_dateObserved:
			return DISPLAY_NAME_dateObserved;
		case VAR_dateObservedFrom:
			return DISPLAY_NAME_dateObservedFrom;
		case VAR_dateObservedTo:
			return DISPLAY_NAME_dateObservedTo;
		case VAR_description:
			return DISPLAY_NAME_description;
		case VAR_inverterStatus:
			return DISPLAY_NAME_inverterStatus;
		case VAR_location:
			return DISPLAY_NAME_location;
		case VAR_name:
			return DISPLAY_NAME_name;
		case VAR_nominalPeakPowerGeneration:
			return DISPLAY_NAME_nominalPeakPowerGeneration;
		case VAR_owner:
			return DISPLAY_NAME_owner;
		case VAR_reactivePower:
			return DISPLAY_NAME_reactivePower;
		case VAR_refPhotovoltaicDevice:
			return DISPLAY_NAME_refPhotovoltaicDevice;
		case VAR_refPointOfInterest:
			return DISPLAY_NAME_refPointOfInterest;
		case VAR_seeAlso:
			return DISPLAY_NAME_seeAlso;
		case VAR_source:
			return DISPLAY_NAME_source;
		case VAR_temperature:
			return DISPLAY_NAME_temperature;
		case VAR_entityId:
			return DISPLAY_NAME_entityId;
		case VAR_entityShortId:
			return DISPLAY_NAME_entityShortId;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionPhotovoltaicMeasurement(String var) {
		switch(var) {
		case VAR_activePower:
			return "Active Power,where phi is the phase shift of the current compared to the voltage. The unit code (text) is given using the UN/CEFACT_Common_Codes (max 3 characters). For instance, For instance, **KWT** represents Kilowatt";
		case VAR_address:
			return "The mailing address";
		case VAR_alternateName:
			return "An alternative name for this item";
		case VAR_areaServedColors:
			return "The colors of each areaServed Paths. ";
		case VAR_areaServedTitles:
			return "The titles of each areaServed Paths. ";
		case VAR_areaServedLinks:
			return "The links of each areaServed Paths. ";
		case VAR_areaServed:
			return "The geographic area where a service or offered item is provided";
		case VAR_current:
			return "Electrical intensity of the current. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **AMP** represents Ampere";
		case VAR_dataProvider:
			return "A sequence of characters identifying the provider of the harmonised data entity";
		case VAR_dateCreated:
			return "Entity creation timestamp. This will usually be allocated by the storage platform";
		case VAR_dateEnergyMeteringStarted:
			return "The starting date for metering energy in an ISO8601 UTC format";
		case VAR_dateModified:
			return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform";
		case VAR_dateObserved:
			return "Date of the observed entity defined by the user";
		case VAR_dateObservedFrom:
			return "Observation period: Start date and time in an ISO8601 UTC format. The attribute can be used in addition to the 'dateObserved attribute when it corresponds to a time interval to be highlighted";
		case VAR_dateObservedTo:
			return "Observation period: End date and time in an ISO8601 UTC format. The attribute can be used in addition to the 'dateObserved' attribute when it corresponds to a time interval to be highlighted";
		case VAR_description:
			return "A description of this item";
		case VAR_inverterStatus:
			return "Active Power,where phi is the phase shift of the current compared to the voltage. The unit code (text) is given using the UN/CEFACT_Common_Codes (max 3 characters). For instance, For instance, **KWT** represents Kilowatt. Enum:'00-On sector, 01-Power failure / On battery, 02-Loss of communication,  03-Battery fault, 04-System shutdown, 05-Tension dip, 06-Overvoltage, 07-Voltage drop, 08-Voltage increase, 09-Line noise, 10-Frequency variation, 11-Transient distortion, 12-Harmonic distortion'";
		case VAR_location:
			return "Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon";
		case VAR_name:
			return "The name of this item";
		case VAR_nominalPeakPowerGeneration:
			return "nominalPeakPowerGeneration is a number. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **KWT** represents Kilowatt";
		case VAR_owner:
			return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
		case VAR_reactivePower:
			return "Reactive Power used by circuits. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **K5** represents kilovolt-ampere-reactive";
		case VAR_refPhotovoltaicDevice:
			return "HtmRow: 9";
		case VAR_refPointOfInterest:
			return "Reference to a [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) linked with the Repository";
		case VAR_seeAlso:
			return "list of uri pointing to additional resources about the item";
		case VAR_source:
			return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object";
		case VAR_temperature:
			return "Temperature recorded at the time of Observation compared to the  nominal reference temperature of the device. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **CEL** represents Degree Celsius";
		case VAR_entityId:
			return "A unique ID for this Smart Data Model";
		case VAR_entityShortId:
			return "A short ID for this Smart Data Model";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNamePhotovoltaicMeasurement(String var) {
		switch(var) {
		case VAR_activePower:
			return "BigDecimal";
		case VAR_address:
			return "JsonObject";
		case VAR_alternateName:
			return "String";
		case VAR_areaServedColors:
			return "List";
		case VAR_areaServedTitles:
			return "List";
		case VAR_areaServedLinks:
			return "List";
		case VAR_areaServed:
			return "Polygon";
		case VAR_current:
			return "BigDecimal";
		case VAR_dataProvider:
			return "String";
		case VAR_dateCreated:
			return "String";
		case VAR_dateEnergyMeteringStarted:
			return "String";
		case VAR_dateModified:
			return "String";
		case VAR_dateObserved:
			return "String";
		case VAR_dateObservedFrom:
			return "String";
		case VAR_dateObservedTo:
			return "String";
		case VAR_description:
			return "String";
		case VAR_inverterStatus:
			return "JsonObject";
		case VAR_location:
			return "Point";
		case VAR_name:
			return "String";
		case VAR_nominalPeakPowerGeneration:
			return "BigDecimal";
		case VAR_owner:
			return "JsonObject";
		case VAR_reactivePower:
			return "BigDecimal";
		case VAR_refPhotovoltaicDevice:
			return "JsonObject";
		case VAR_refPointOfInterest:
			return "JsonObject";
		case VAR_seeAlso:
			return "JsonObject";
		case VAR_source:
			return "String";
		case VAR_temperature:
			return "BigDecimal";
		case VAR_entityId:
			return "String";
		case VAR_entityShortId:
			return "String";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmColumnPhotovoltaicMeasurement(String var) {
		switch(var) {
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowPhotovoltaicMeasurement(String var) {
		switch(var) {
		case VAR_activePower:
			return 3;
		case VAR_address:
			return 3;
		case VAR_alternateName:
			return 3;
		case VAR_areaServed:
			return 4;
		case VAR_current:
			return 4;
		case VAR_dataProvider:
			return 4;
		case VAR_dateCreated:
			return 5;
		case VAR_dateEnergyMeteringStarted:
			return 5;
		case VAR_dateModified:
			return 5;
		case VAR_dateObserved:
			return 6;
		case VAR_dateObservedFrom:
			return 6;
		case VAR_dateObservedTo:
			return 6;
		case VAR_description:
			return 7;
		case VAR_inverterStatus:
			return 7;
		case VAR_location:
			return 7;
		case VAR_name:
			return 8;
		case VAR_nominalPeakPowerGeneration:
			return 8;
		case VAR_owner:
			return 8;
		case VAR_reactivePower:
			return 9;
		case VAR_refPhotovoltaicDevice:
			return 9;
		case VAR_refPointOfInterest:
			return 9;
		case VAR_seeAlso:
			return 10;
		case VAR_source:
			return 10;
		case VAR_temperature:
			return 10;
		case VAR_entityId:
			return 3;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellPhotovoltaicMeasurement(String var) {
		switch(var) {
		case VAR_activePower:
			return 1;
		case VAR_address:
			return 2;
		case VAR_alternateName:
			return 3;
		case VAR_areaServed:
			return 1;
		case VAR_current:
			return 2;
		case VAR_dataProvider:
			return 3;
		case VAR_dateCreated:
			return 1;
		case VAR_dateEnergyMeteringStarted:
			return 2;
		case VAR_dateModified:
			return 3;
		case VAR_dateObserved:
			return 1;
		case VAR_dateObservedFrom:
			return 2;
		case VAR_dateObservedTo:
			return 3;
		case VAR_description:
			return 1;
		case VAR_inverterStatus:
			return 2;
		case VAR_location:
			return 3;
		case VAR_name:
			return 1;
		case VAR_nominalPeakPowerGeneration:
			return 2;
		case VAR_owner:
			return 3;
		case VAR_reactivePower:
			return 1;
		case VAR_refPhotovoltaicDevice:
			return 2;
		case VAR_refPointOfInterest:
			return 3;
		case VAR_seeAlso:
			return 1;
		case VAR_source:
			return 2;
		case VAR_temperature:
			return 3;
		case VAR_entityId:
			return 1;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinPhotovoltaicMeasurement(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxPhotovoltaicMeasurement(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxPhotovoltaicMeasurement(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minPhotovoltaicMeasurement(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
