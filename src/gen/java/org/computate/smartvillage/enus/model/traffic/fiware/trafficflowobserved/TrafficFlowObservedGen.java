/*
 * Copyright (c) 2018-2022 Computate Limited Liability Company in Utah, USA,
 * and the Smarta Byar Smart Village FIWARE IHub. 
 *
 * This program and the accompanying materials are made available under the
 * terms of the GNU GENERAL PUBLIC LICENSE Version 3 which is available at
 * 
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved;

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
import org.computate.vertx.search.list.SearchList;
import org.computate.smartvillage.enus.model.traffic.simulation.TrafficSimulation;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPointSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPointDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.computate.smartvillage.enus.model.traffic.fiware.smarttrafficlight.SmartTrafficLight;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Path;
import org.computate.vertx.serialize.pgclient.PgClientPathSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPathDeserializer;
import java.math.BigDecimal;
import java.lang.Boolean;
import java.lang.Integer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class TrafficFlowObservedGen into the class TrafficFlowObserved. 
 * </li>
 * <h3>About the TrafficFlowObserved class and it's generated class TrafficFlowObservedGen&lt;BaseModel&gt;: </h3>extends TrafficFlowObservedGen
 * <p>
 * This Java class extends a generated Java class TrafficFlowObservedGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved">Find the class TrafficFlowObserved in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends TrafficFlowObservedGen<BaseModel>
 * <p>This <code>class TrafficFlowObserved extends TrafficFlowObservedGen&lt;BaseModel&gt;</code>, which means it extends a newly generated TrafficFlowObservedGen. 
 * The generated <code>class TrafficFlowObservedGen extends BaseModel</code> which means that TrafficFlowObserved extends TrafficFlowObservedGen which extends BaseModel. 
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
 * <p>This class contains a comment <b>"ApiTag: Traffic Flow Observed"</b>, which groups all of the OpenAPIs for TrafficFlowObserved objects under the tag "Traffic Flow Observed". 
 * </p>
 * <h2>ApiUri.enUS: /api/traffic-flow-observed</h2>
 * <p>This class contains a comment <b>"ApiUri: /api/traffic-flow-observed"</b>, which defines the base API URI for TrafficFlowObserved objects as "/api/traffic-flow-observed" in the OpenAPI spec. 
 * </p>
 * <h2>Color: 2017-shaded-spruce</h2>
 * <p>This class contains a comment <b>"Color: 2017-shaded-spruce"</b>, which styles the TrafficFlowObserved page "2017-shaded-spruce". 
 * This will reference a CSS class defined by the stylesheets in the project that starts with "w3-". 
 * A css class of "w3-2017-shaded-spruce" is expected to exist in the project stylesheets, and is inspired by W3 CSS colors. 
 * See: <a href="https://www.w3schools.com/w3css/w3css_colors.asp">https://www.w3schools.com/w3css/w3css_colors.asp</a>. 
 * </p>
 * <h2>IconGroup: duotone</h2>
 * <p>This class contains a comment <b>"IconGroup: duotone"</b>, which adds icons on the TrafficFlowObserved page with a group of "duotone". 
 * This will reference a Font Awesome icon group that starts with "fa-" followed by the icon group "duotone", together is "fa-duotone". 
 * A Font Awesome icon group of "duotone" is expected to exist. 
 * The Font Awesome groups currently supported include: solid, regular, light, thin, duotone, sharp, and kit. 
 * See: <a href="https://fontawesome.com/docs/web/dig-deeper/styles">https://fontawesome.com/docs/web/dig-deeper/styles</a>. 
 * </p>
 * <h2>IconName: map-location-dot</h2>
 * <p>This class contains a comment <b>"IconName: map-location-dot"</b>, which adds icons on the TrafficFlowObserved page with a name of "map-location-dot". 
 * This will reference a Font Awesome icon that starts with the icon group "fa-duotone fa-" followed by the icon name, which is "fa-duotone fa-map-location-dot". 
 * A Font Awesome icon of "fa-duotone fa-map-location-dot" is expected to exist. 
 * See: <a href="https://fontawesome.com/icons">https://fontawesome.com/icons</a>. 
 * </p>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the TrafficFlowObserved class will inherit the helpful inherited class comments from the super class TrafficFlowObservedGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the TrafficFlowObserved API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 18</h2>
 * <p>This class contains a comment <b>"Order: 18"</b>, which means this class will be sorted by the given number 18 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 3</h2>
 * <p>This class contains a comment <b>"SqlOrder: 3"</b>, which means this class will be sorted by the given number 3 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObservedPage. 
 * </p>
 * <h2>SuperPage.enUS: BaseModelPage</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: BaseModelPage"</b>, which identifies the Java super class of the page code by it's class simple name "BaseModelPage". 
 * This means that the newly created class org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObservedPage extends org.computate.smartvillage.enus.model.base.BaseModelPage. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the TrafficFlowObserved Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * This class contains a comment <b>"Role.enUS: SiteAdmin"</b>, which identifies the default role name "SiteAdmin" of the OAuth2/OpenID Connect user role required to access this TrafficFlowObserved API. 
 * It's possible to reconfigure the roles required to access the TrafficFlowObserved API by configuring an environment variable like this: 
 * </p>
 * <pre>AUTH_ROLE_REQUIRED_TrafficFlowObserved: ["SiteAdmin"]</pre>
 * <h2>AName.enUS: a traffic flow observed</h2>
 * <p>This class contains a comment <b>"AName.enUS: a traffic flow observed"</b>, which identifies the language context to describe a TrafficFlowObserved as "a traffic flow observed". 
 * </p>
 * <p>
 * Delete the class TrafficFlowObserved in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class TrafficFlowObservedGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(TrafficFlowObserved.class);

	public static final String TrafficFlowObserved_Description_enUS = "A device for watching vehicles in a lane of traffic on a road. ";
	public static final String TrafficFlowObserved_AName_enUS = "a traffic flow observed";
	public static final String TrafficFlowObserved_This_enUS = "this ";
	public static final String TrafficFlowObserved_ThisName_enUS = "this traffic flow observed";
	public static final String TrafficFlowObserved_A_enUS = "a ";
	public static final String TrafficFlowObserved_TheName_enUS = "the traffic flow observed";
	public static final String TrafficFlowObserved_NameSingular_enUS = "traffic flow observed";
	public static final String TrafficFlowObserved_NamePlural_enUS = "traffic flow observeds";
	public static final String TrafficFlowObserved_NameActual_enUS = "current traffic flow observed";
	public static final String TrafficFlowObserved_AllName_enUS = "all the traffic flow observeds";
	public static final String TrafficFlowObserved_SearchAllNameBy_enUS = "search traffic flow observeds by ";
	public static final String TrafficFlowObserved_Title_enUS = "traffic flow observeds";
	public static final String TrafficFlowObserved_ThePluralName_enUS = "the traffic flow observeds";
	public static final String TrafficFlowObserved_NoNameFound_enUS = "no traffic flow observed found";
	public static final String TrafficFlowObserved_ApiUri_enUS = "/api/traffic-flow-observed";
	public static final String TrafficFlowObserved_ApiUriSearchPage_enUS = "/traffic-flow-observed";
	public static final String TrafficFlowObserved_OfName_enUS = "of traffic flow observed";
	public static final String TrafficFlowObserved_ANameAdjective_enUS = "a traffic flow observed";
	public static final String TrafficFlowObserved_NameAdjectiveSingular_enUS = "traffic flow observed";
	public static final String TrafficFlowObserved_NameAdjectivePlural_enUS = "traffic flow observeds";
	public static final String Search_enUS_Uri = "/api/traffic-flow-observed";
	public static final String Search_enUS_ImageUri = "/png/api/traffic-flow-observed-999.png";
	public static final String GET_enUS_Uri = "/api/traffic-flow-observed/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/traffic-flow-observed/{id}-999.png";
	public static final String PATCH_enUS_Uri = "/api/traffic-flow-observed";
	public static final String PATCH_enUS_ImageUri = "/png/api/traffic-flow-observed-999.png";
	public static final String POST_enUS_Uri = "/api/traffic-flow-observed";
	public static final String POST_enUS_ImageUri = "/png/api/traffic-flow-observed-999.png";
	public static final String PUTImport_enUS_Uri = "/api/traffic-flow-observed-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/traffic-flow-observed-import-999.png";
	public static final String SearchPage_enUS_Uri = "/traffic-flow-observed";
	public static final String SearchPage_enUS_ImageUri = "/png/traffic-flow-observed-999.png";

	public static final String TrafficFlowObserved_Color = "2017-shaded-spruce";
	public static final String TrafficFlowObserved_IconGroup = "duotone";
	public static final String TrafficFlowObserved_IconName = "map-location-dot";
	public static final Integer TrafficFlowObserved_Rows = 100;

	///////////
	// color //
	///////////


	/**	 The entity color
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String color;

	/**	<br> The entity color
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:color">Find the entity color in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _color(Wrap<String> w);

	public String getColor() {
		return color;
	}
	public void setColor(String o) {
		this.color = TrafficFlowObserved.staticSetColor(siteRequest_, o);
	}
	public static String staticSetColor(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved colorInit() {
		Wrap<String> colorWrap = new Wrap<String>().var("color");
		if(color == null) {
			_color(colorWrap);
			Optional.ofNullable(colorWrap.getO()).ifPresent(o -> {
				setColor(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchColor(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrColor(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqColor(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchColor(siteRequest_, TrafficFlowObserved.staticSetColor(siteRequest_, o)).toString();
	}

	public String sqlColor() {
		return color;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:entityId">Find the entity entityId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityId(Wrap<String> w);

	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String o) {
		this.entityId = TrafficFlowObserved.staticSetEntityId(siteRequest_, o);
	}
	public static String staticSetEntityId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved entityIdInit() {
		Wrap<String> entityIdWrap = new Wrap<String>().var("entityId");
		if(entityId == null) {
			_entityId(entityIdWrap);
			Optional.ofNullable(entityIdWrap.getO()).ifPresent(o -> {
				setEntityId(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchEntityId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchEntityId(siteRequest_, TrafficFlowObserved.staticSetEntityId(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:entityShortId">Find the entity entityShortId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityShortId(Wrap<String> w);

	public String getEntityShortId() {
		return entityShortId;
	}
	public void setEntityShortId(String o) {
		this.entityShortId = TrafficFlowObserved.staticSetEntityShortId(siteRequest_, o);
	}
	public static String staticSetEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved entityShortIdInit() {
		Wrap<String> entityShortIdWrap = new Wrap<String>().var("entityShortId");
		if(entityShortId == null) {
			_entityShortId(entityShortIdWrap);
			Optional.ofNullable(entityShortIdWrap.getO()).ifPresent(o -> {
				setEntityShortId(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityShortId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchEntityShortId(siteRequest_, TrafficFlowObserved.staticSetEntityShortId(siteRequest_, o)).toString();
	}

	/////////////////////////
	// trafficSimulationId //
	/////////////////////////


	/**	 The entity trafficSimulationId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String trafficSimulationId;

	/**	<br> The entity trafficSimulationId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:trafficSimulationId">Find the entity trafficSimulationId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _trafficSimulationId(Wrap<String> w);

	public String getTrafficSimulationId() {
		return trafficSimulationId;
	}
	public void setTrafficSimulationId(String o) {
		this.trafficSimulationId = TrafficFlowObserved.staticSetTrafficSimulationId(siteRequest_, o);
	}
	public static String staticSetTrafficSimulationId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved trafficSimulationIdInit() {
		Wrap<String> trafficSimulationIdWrap = new Wrap<String>().var("trafficSimulationId");
		if(trafficSimulationId == null) {
			_trafficSimulationId(trafficSimulationIdWrap);
			Optional.ofNullable(trafficSimulationIdWrap.getO()).ifPresent(o -> {
				setTrafficSimulationId(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchTrafficSimulationId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTrafficSimulationId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTrafficSimulationId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchTrafficSimulationId(siteRequest_, TrafficFlowObserved.staticSetTrafficSimulationId(siteRequest_, o)).toString();
	}

	public String sqlTrafficSimulationId() {
		return trafficSimulationId;
	}

	/////////////////////////////
	// trafficSimulationSearch //
	/////////////////////////////


	/**	 The entity trafficSimulationSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<TrafficSimulation> trafficSimulationSearch;

	/**	<br> The entity trafficSimulationSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:trafficSimulationSearch">Find the entity trafficSimulationSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _trafficSimulationSearch(Promise<SearchList<TrafficSimulation>> promise);

	public SearchList<TrafficSimulation> getTrafficSimulationSearch() {
		return trafficSimulationSearch;
	}

	public void setTrafficSimulationSearch(SearchList<TrafficSimulation> trafficSimulationSearch) {
		this.trafficSimulationSearch = trafficSimulationSearch;
	}
	public static SearchList<TrafficSimulation> staticSetTrafficSimulationSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<TrafficSimulation>> trafficSimulationSearchPromise() {
		Promise<SearchList<TrafficSimulation>> promise = Promise.promise();
		Promise<SearchList<TrafficSimulation>> promise2 = Promise.promise();
		_trafficSimulationSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && trafficSimulationSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setTrafficSimulationSearch(o);
					promise.complete(o);
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			} else {
				promise.complete(o);
			}
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	////////////////////////
	// trafficSimulation_ //
	////////////////////////


	/**	 The entity trafficSimulation_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected TrafficSimulation trafficSimulation_;

	/**	<br> The entity trafficSimulation_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:trafficSimulation_">Find the entity trafficSimulation_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _trafficSimulation_(Wrap<TrafficSimulation> w);

	public TrafficSimulation getTrafficSimulation_() {
		return trafficSimulation_;
	}

	public void setTrafficSimulation_(TrafficSimulation trafficSimulation_) {
		this.trafficSimulation_ = trafficSimulation_;
	}
	public static TrafficSimulation staticSetTrafficSimulation_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficFlowObserved trafficSimulation_Init() {
		Wrap<TrafficSimulation> trafficSimulation_Wrap = new Wrap<TrafficSimulation>().var("trafficSimulation_");
		if(trafficSimulation_ == null) {
			_trafficSimulation_(trafficSimulation_Wrap);
			Optional.ofNullable(trafficSimulation_Wrap.getO()).ifPresent(o -> {
				setTrafficSimulation_(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	////////////////////////
	// laneAreaDetectorId //
	////////////////////////


	/**	 The entity laneAreaDetectorId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String laneAreaDetectorId;

	/**	<br> The entity laneAreaDetectorId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:laneAreaDetectorId">Find the entity laneAreaDetectorId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _laneAreaDetectorId(Wrap<String> w);

	public String getLaneAreaDetectorId() {
		return laneAreaDetectorId;
	}
	public void setLaneAreaDetectorId(String o) {
		this.laneAreaDetectorId = TrafficFlowObserved.staticSetLaneAreaDetectorId(siteRequest_, o);
	}
	public static String staticSetLaneAreaDetectorId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved laneAreaDetectorIdInit() {
		Wrap<String> laneAreaDetectorIdWrap = new Wrap<String>().var("laneAreaDetectorId");
		if(laneAreaDetectorId == null) {
			_laneAreaDetectorId(laneAreaDetectorIdWrap);
			Optional.ofNullable(laneAreaDetectorIdWrap.getO()).ifPresent(o -> {
				setLaneAreaDetectorId(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchLaneAreaDetectorId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLaneAreaDetectorId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLaneAreaDetectorId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchLaneAreaDetectorId(siteRequest_, TrafficFlowObserved.staticSetLaneAreaDetectorId(siteRequest_, o)).toString();
	}

	public String sqlLaneAreaDetectorId() {
		return laneAreaDetectorId;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
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
		this.location = TrafficFlowObserved.staticSetLocation(siteRequest_, o);
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
		this.location = TrafficFlowObserved.staticSetLocation(siteRequest_, o);
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
	protected TrafficFlowObserved locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Point staticSearchLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchLocation(siteRequest_, TrafficFlowObserved.staticSetLocation(siteRequest_, o)).toString();
	}

	public Point sqlLocation() {
		return location;
	}

	////////////////////
	// simulationName //
	////////////////////


	/**	 The entity simulationName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String simulationName;

	/**	<br> The entity simulationName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:simulationName">Find the entity simulationName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _simulationName(Wrap<String> w);

	public String getSimulationName() {
		return simulationName;
	}
	public void setSimulationName(String o) {
		this.simulationName = TrafficFlowObserved.staticSetSimulationName(siteRequest_, o);
	}
	public static String staticSetSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved simulationNameInit() {
		Wrap<String> simulationNameWrap = new Wrap<String>().var("simulationName");
		if(simulationName == null) {
			_simulationName(simulationNameWrap);
			Optional.ofNullable(simulationNameWrap.getO()).ifPresent(o -> {
				setSimulationName(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchSimulationName(siteRequest_, TrafficFlowObserved.staticSetSimulationName(siteRequest_, o)).toString();
	}

	/////////////////
	// sumocfgPath //
	/////////////////


	/**	 The entity sumocfgPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sumocfgPath;

	/**	<br> The entity sumocfgPath
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:sumocfgPath">Find the entity sumocfgPath in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sumocfgPath(Wrap<String> w);

	public String getSumocfgPath() {
		return sumocfgPath;
	}
	public void setSumocfgPath(String o) {
		this.sumocfgPath = TrafficFlowObserved.staticSetSumocfgPath(siteRequest_, o);
	}
	public static String staticSetSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved sumocfgPathInit() {
		Wrap<String> sumocfgPathWrap = new Wrap<String>().var("sumocfgPath");
		if(sumocfgPath == null) {
			_sumocfgPath(sumocfgPathWrap);
			Optional.ofNullable(sumocfgPathWrap.getO()).ifPresent(o -> {
				setSumocfgPath(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchSumocfgPath(siteRequest_, TrafficFlowObserved.staticSetSumocfgPath(siteRequest_, o)).toString();
	}

	public String sqlSumocfgPath() {
		return sumocfgPath;
	}

	//////////////////////////
	// customTrafficLightId //
	//////////////////////////


	/**	 The entity customTrafficLightId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String customTrafficLightId;

	/**	<br> The entity customTrafficLightId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customTrafficLightId">Find the entity customTrafficLightId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customTrafficLightId(Wrap<String> w);

	public String getCustomTrafficLightId() {
		return customTrafficLightId;
	}
	public void setCustomTrafficLightId(String o) {
		this.customTrafficLightId = TrafficFlowObserved.staticSetCustomTrafficLightId(siteRequest_, o);
	}
	public static String staticSetCustomTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved customTrafficLightIdInit() {
		Wrap<String> customTrafficLightIdWrap = new Wrap<String>().var("customTrafficLightId");
		if(customTrafficLightId == null) {
			_customTrafficLightId(customTrafficLightIdWrap);
			Optional.ofNullable(customTrafficLightIdWrap.getO()).ifPresent(o -> {
				setCustomTrafficLightId(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchCustomTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrCustomTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomTrafficLightId(siteRequest_, TrafficFlowObserved.staticSetCustomTrafficLightId(siteRequest_, o)).toString();
	}

	public String sqlCustomTrafficLightId() {
		return customTrafficLightId;
	}

	/////////////////////////////
	// smartTrafficLightSearch //
	/////////////////////////////


	/**	 The entity smartTrafficLightSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SmartTrafficLight> smartTrafficLightSearch;

	/**	<br> The entity smartTrafficLightSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:smartTrafficLightSearch">Find the entity smartTrafficLightSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _smartTrafficLightSearch(Promise<SearchList<SmartTrafficLight>> promise);

	public SearchList<SmartTrafficLight> getSmartTrafficLightSearch() {
		return smartTrafficLightSearch;
	}

	public void setSmartTrafficLightSearch(SearchList<SmartTrafficLight> smartTrafficLightSearch) {
		this.smartTrafficLightSearch = smartTrafficLightSearch;
	}
	public static SearchList<SmartTrafficLight> staticSetSmartTrafficLightSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<SmartTrafficLight>> smartTrafficLightSearchPromise() {
		Promise<SearchList<SmartTrafficLight>> promise = Promise.promise();
		Promise<SearchList<SmartTrafficLight>> promise2 = Promise.promise();
		_smartTrafficLightSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && smartTrafficLightSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setSmartTrafficLightSearch(o);
					promise.complete(o);
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			} else {
				promise.complete(o);
			}
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	////////////////////////
	// smartTrafficLight_ //
	////////////////////////


	/**	 The entity smartTrafficLight_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SmartTrafficLight smartTrafficLight_;

	/**	<br> The entity smartTrafficLight_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:smartTrafficLight_">Find the entity smartTrafficLight_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _smartTrafficLight_(Wrap<SmartTrafficLight> w);

	public SmartTrafficLight getSmartTrafficLight_() {
		return smartTrafficLight_;
	}

	public void setSmartTrafficLight_(SmartTrafficLight smartTrafficLight_) {
		this.smartTrafficLight_ = smartTrafficLight_;
	}
	public static SmartTrafficLight staticSetSmartTrafficLight_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficFlowObserved smartTrafficLight_Init() {
		Wrap<SmartTrafficLight> smartTrafficLight_Wrap = new Wrap<SmartTrafficLight>().var("smartTrafficLight_");
		if(smartTrafficLight_ == null) {
			_smartTrafficLight_(smartTrafficLight_Wrap);
			Optional.ofNullable(smartTrafficLight_Wrap.getO()).ifPresent(o -> {
				setSmartTrafficLight_(o);
			});
		}
		return (TrafficFlowObserved)this;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
		this.address = TrafficFlowObserved.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected TrafficFlowObserved addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchAddress(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAddress(siteRequest_, TrafficFlowObserved.staticSetAddress(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _alternateName(Wrap<String> w);

	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String o) {
		this.alternateName = TrafficFlowObserved.staticSetAlternateName(siteRequest_, o);
	}
	public static String staticSetAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved alternateNameInit() {
		Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
		if(alternateName == null) {
			_alternateName(alternateNameWrap);
			Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
				setAlternateName(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAlternateName(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAlternateName(siteRequest_, TrafficFlowObserved.staticSetAlternateName(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
		String l = TrafficFlowObserved.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public TrafficFlowObserved addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (TrafficFlowObserved)this;
	}
	public TrafficFlowObserved addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (TrafficFlowObserved)this;
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
	protected TrafficFlowObserved areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAreaServedColors(siteRequest_, TrafficFlowObserved.staticSetAreaServedColors(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
		String l = TrafficFlowObserved.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public TrafficFlowObserved addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (TrafficFlowObserved)this;
	}
	public TrafficFlowObserved addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (TrafficFlowObserved)this;
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
	protected TrafficFlowObserved areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAreaServedTitles(siteRequest_, TrafficFlowObserved.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
		String l = TrafficFlowObserved.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public TrafficFlowObserved addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (TrafficFlowObserved)this;
	}
	public TrafficFlowObserved addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (TrafficFlowObserved)this;
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
	protected TrafficFlowObserved areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAreaServedLinks(siteRequest_, TrafficFlowObserved.staticSetAreaServedLinks(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
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
		this.areaServed = TrafficFlowObserved.staticSetAreaServed(siteRequest_, o);
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
		this.areaServed = TrafficFlowObserved.staticSetAreaServed(siteRequest_, o);
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
	protected TrafficFlowObserved areaServedInit() {
		Wrap<Path> areaServedWrap = new Wrap<Path>().var("areaServed");
		if(areaServed == null) {
			_areaServed(areaServedWrap);
			Optional.ofNullable(areaServedWrap.getO()).ifPresent(o -> {
				setAreaServed(o);
			});
		}
		return (TrafficFlowObserved)this;
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
		return TrafficFlowObserved.staticSearchAreaServed(siteRequest_, TrafficFlowObserved.staticSetAreaServed(siteRequest_, o)).toString();
	}

	public Path sqlAreaServed() {
		return areaServed;
	}

	////////////////////////
	// averageGapDistance //
	////////////////////////


	/**	 The entity averageGapDistance
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageGapDistance;

	/**	<br> The entity averageGapDistance
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:averageGapDistance">Find the entity averageGapDistance in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageGapDistance(Wrap<BigDecimal> w);

	public BigDecimal getAverageGapDistance() {
		return averageGapDistance;
	}

	public void setAverageGapDistance(BigDecimal averageGapDistance) {
		this.averageGapDistance = averageGapDistance;
	}
	@JsonIgnore
	public void setAverageGapDistance(String o) {
		this.averageGapDistance = TrafficFlowObserved.staticSetAverageGapDistance(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageGapDistance(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageGapDistance(Double o) {
		setAverageGapDistance(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageGapDistance(Integer o) {
		setAverageGapDistance(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageGapDistance(Number o) {
		setAverageGapDistance(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved averageGapDistanceInit() {
		Wrap<BigDecimal> averageGapDistanceWrap = new Wrap<BigDecimal>().var("averageGapDistance");
		if(averageGapDistance == null) {
			_averageGapDistance(averageGapDistanceWrap);
			Optional.ofNullable(averageGapDistanceWrap.getO()).ifPresent(o -> {
				setAverageGapDistance(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchAverageGapDistance(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageGapDistance(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageGapDistance(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAverageGapDistance(siteRequest_, TrafficFlowObserved.staticSetAverageGapDistance(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageGapDistance() {
		return averageGapDistance;
	}

	////////////////////////
	// averageHeadwayTime //
	////////////////////////


	/**	 The entity averageHeadwayTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageHeadwayTime;

	/**	<br> The entity averageHeadwayTime
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:averageHeadwayTime">Find the entity averageHeadwayTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageHeadwayTime(Wrap<BigDecimal> w);

	public BigDecimal getAverageHeadwayTime() {
		return averageHeadwayTime;
	}

	public void setAverageHeadwayTime(BigDecimal averageHeadwayTime) {
		this.averageHeadwayTime = averageHeadwayTime;
	}
	@JsonIgnore
	public void setAverageHeadwayTime(String o) {
		this.averageHeadwayTime = TrafficFlowObserved.staticSetAverageHeadwayTime(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageHeadwayTime(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageHeadwayTime(Double o) {
		setAverageHeadwayTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageHeadwayTime(Integer o) {
		setAverageHeadwayTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageHeadwayTime(Number o) {
		setAverageHeadwayTime(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved averageHeadwayTimeInit() {
		Wrap<BigDecimal> averageHeadwayTimeWrap = new Wrap<BigDecimal>().var("averageHeadwayTime");
		if(averageHeadwayTime == null) {
			_averageHeadwayTime(averageHeadwayTimeWrap);
			Optional.ofNullable(averageHeadwayTimeWrap.getO()).ifPresent(o -> {
				setAverageHeadwayTime(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchAverageHeadwayTime(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageHeadwayTime(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageHeadwayTime(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAverageHeadwayTime(siteRequest_, TrafficFlowObserved.staticSetAverageHeadwayTime(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageHeadwayTime() {
		return averageHeadwayTime;
	}

	//////////////////////////
	// averageVehicleLength //
	//////////////////////////


	/**	 The entity averageVehicleLength
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageVehicleLength;

	/**	<br> The entity averageVehicleLength
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:averageVehicleLength">Find the entity averageVehicleLength in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageVehicleLength(Wrap<BigDecimal> w);

	public BigDecimal getAverageVehicleLength() {
		return averageVehicleLength;
	}

	public void setAverageVehicleLength(BigDecimal averageVehicleLength) {
		this.averageVehicleLength = averageVehicleLength;
	}
	@JsonIgnore
	public void setAverageVehicleLength(String o) {
		this.averageVehicleLength = TrafficFlowObserved.staticSetAverageVehicleLength(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageVehicleLength(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageVehicleLength(Double o) {
		setAverageVehicleLength(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageVehicleLength(Integer o) {
		setAverageVehicleLength(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageVehicleLength(Number o) {
		setAverageVehicleLength(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved averageVehicleLengthInit() {
		Wrap<BigDecimal> averageVehicleLengthWrap = new Wrap<BigDecimal>().var("averageVehicleLength");
		if(averageVehicleLength == null) {
			_averageVehicleLength(averageVehicleLengthWrap);
			Optional.ofNullable(averageVehicleLengthWrap.getO()).ifPresent(o -> {
				setAverageVehicleLength(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchAverageVehicleLength(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageVehicleLength(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageVehicleLength(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAverageVehicleLength(siteRequest_, TrafficFlowObserved.staticSetAverageVehicleLength(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageVehicleLength() {
		return averageVehicleLength;
	}

	/////////////////////////
	// averageVehicleSpeed //
	/////////////////////////


	/**	 The entity averageVehicleSpeed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageVehicleSpeed;

	/**	<br> The entity averageVehicleSpeed
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:averageVehicleSpeed">Find the entity averageVehicleSpeed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageVehicleSpeed(Wrap<BigDecimal> w);

	public BigDecimal getAverageVehicleSpeed() {
		return averageVehicleSpeed;
	}

	public void setAverageVehicleSpeed(BigDecimal averageVehicleSpeed) {
		this.averageVehicleSpeed = averageVehicleSpeed;
	}
	@JsonIgnore
	public void setAverageVehicleSpeed(String o) {
		this.averageVehicleSpeed = TrafficFlowObserved.staticSetAverageVehicleSpeed(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageVehicleSpeed(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageVehicleSpeed(Double o) {
		setAverageVehicleSpeed(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageVehicleSpeed(Integer o) {
		setAverageVehicleSpeed(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageVehicleSpeed(Number o) {
		setAverageVehicleSpeed(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved averageVehicleSpeedInit() {
		Wrap<BigDecimal> averageVehicleSpeedWrap = new Wrap<BigDecimal>().var("averageVehicleSpeed");
		if(averageVehicleSpeed == null) {
			_averageVehicleSpeed(averageVehicleSpeedWrap);
			Optional.ofNullable(averageVehicleSpeedWrap.getO()).ifPresent(o -> {
				setAverageVehicleSpeed(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchAverageVehicleSpeed(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageVehicleSpeed(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageVehicleSpeed(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchAverageVehicleSpeed(siteRequest_, TrafficFlowObserved.staticSetAverageVehicleSpeed(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageVehicleSpeed() {
		return averageVehicleSpeed;
	}

	///////////////
	// congested //
	///////////////


	/**	 The entity congested
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean congested;

	/**	<br> The entity congested
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:congested">Find the entity congested in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _congested(Wrap<Boolean> w);

	public Boolean getCongested() {
		return congested;
	}

	public void setCongested(Boolean congested) {
		this.congested = congested;
	}
	@JsonIgnore
	public void setCongested(String o) {
		this.congested = TrafficFlowObserved.staticSetCongested(siteRequest_, o);
	}
	public static Boolean staticSetCongested(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected TrafficFlowObserved congestedInit() {
		Wrap<Boolean> congestedWrap = new Wrap<Boolean>().var("congested");
		if(congested == null) {
			_congested(congestedWrap);
			Optional.ofNullable(congestedWrap.getO()).ifPresent(o -> {
				setCongested(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Boolean staticSearchCongested(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrCongested(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCongested(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCongested(siteRequest_, TrafficFlowObserved.staticSetCongested(siteRequest_, o)).toString();
	}

	public Boolean sqlCongested() {
		return congested;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataProvider(Wrap<String> w);

	public String getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(String o) {
		this.dataProvider = TrafficFlowObserved.staticSetDataProvider(siteRequest_, o);
	}
	public static String staticSetDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved dataProviderInit() {
		Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
		if(dataProvider == null) {
			_dataProvider(dataProviderWrap);
			Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
				setDataProvider(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataProvider(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDataProvider(siteRequest_, TrafficFlowObserved.staticSetDataProvider(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateCreated(Wrap<String> w);

	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String o) {
		this.dateCreated = TrafficFlowObserved.staticSetDateCreated(siteRequest_, o);
	}
	public static String staticSetDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved dateCreatedInit() {
		Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
		if(dateCreated == null) {
			_dateCreated(dateCreatedWrap);
			Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
				setDateCreated(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateCreated(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDateCreated(siteRequest_, TrafficFlowObserved.staticSetDateCreated(siteRequest_, o)).toString();
	}

	public String sqlDateCreated() {
		return dateCreated;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateModified(Wrap<String> w);

	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String o) {
		this.dateModified = TrafficFlowObserved.staticSetDateModified(siteRequest_, o);
	}
	public static String staticSetDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved dateModifiedInit() {
		Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
		if(dateModified == null) {
			_dateModified(dateModifiedWrap);
			Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
				setDateModified(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateModified(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateModified(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDateModified(siteRequest_, TrafficFlowObserved.staticSetDateModified(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:dateObserved">Find the entity dateObserved in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObserved(Wrap<String> w);

	public String getDateObserved() {
		return dateObserved;
	}
	public void setDateObserved(String o) {
		this.dateObserved = TrafficFlowObserved.staticSetDateObserved(siteRequest_, o);
	}
	public static String staticSetDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved dateObservedInit() {
		Wrap<String> dateObservedWrap = new Wrap<String>().var("dateObserved");
		if(dateObserved == null) {
			_dateObserved(dateObservedWrap);
			Optional.ofNullable(dateObservedWrap.getO()).ifPresent(o -> {
				setDateObserved(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObserved(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDateObserved(siteRequest_, TrafficFlowObserved.staticSetDateObserved(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:dateObservedFrom">Find the entity dateObservedFrom in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObservedFrom(Wrap<String> w);

	public String getDateObservedFrom() {
		return dateObservedFrom;
	}
	public void setDateObservedFrom(String o) {
		this.dateObservedFrom = TrafficFlowObserved.staticSetDateObservedFrom(siteRequest_, o);
	}
	public static String staticSetDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved dateObservedFromInit() {
		Wrap<String> dateObservedFromWrap = new Wrap<String>().var("dateObservedFrom");
		if(dateObservedFrom == null) {
			_dateObservedFrom(dateObservedFromWrap);
			Optional.ofNullable(dateObservedFromWrap.getO()).ifPresent(o -> {
				setDateObservedFrom(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObservedFrom(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDateObservedFrom(siteRequest_, TrafficFlowObserved.staticSetDateObservedFrom(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:dateObservedTo">Find the entity dateObservedTo in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObservedTo(Wrap<String> w);

	public String getDateObservedTo() {
		return dateObservedTo;
	}
	public void setDateObservedTo(String o) {
		this.dateObservedTo = TrafficFlowObserved.staticSetDateObservedTo(siteRequest_, o);
	}
	public static String staticSetDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved dateObservedToInit() {
		Wrap<String> dateObservedToWrap = new Wrap<String>().var("dateObservedTo");
		if(dateObservedTo == null) {
			_dateObservedTo(dateObservedToWrap);
			Optional.ofNullable(dateObservedToWrap.getO()).ifPresent(o -> {
				setDateObservedTo(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObservedTo(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDateObservedTo(siteRequest_, TrafficFlowObserved.staticSetDateObservedTo(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = TrafficFlowObserved.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchDescription(siteRequest_, TrafficFlowObserved.staticSetDescription(siteRequest_, o)).toString();
	}

	public String sqlDescription() {
		return description;
	}

	///////////////
	// intensity //
	///////////////


	/**	 The entity intensity
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal intensity;

	/**	<br> The entity intensity
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:intensity">Find the entity intensity in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _intensity(Wrap<BigDecimal> w);

	public BigDecimal getIntensity() {
		return intensity;
	}

	public void setIntensity(BigDecimal intensity) {
		this.intensity = intensity;
	}
	@JsonIgnore
	public void setIntensity(String o) {
		this.intensity = TrafficFlowObserved.staticSetIntensity(siteRequest_, o);
	}
	public static BigDecimal staticSetIntensity(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setIntensity(Double o) {
		setIntensity(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setIntensity(Integer o) {
		setIntensity(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setIntensity(Number o) {
		setIntensity(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved intensityInit() {
		Wrap<BigDecimal> intensityWrap = new Wrap<BigDecimal>().var("intensity");
		if(intensity == null) {
			_intensity(intensityWrap);
			Optional.ofNullable(intensityWrap.getO()).ifPresent(o -> {
				setIntensity(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchIntensity(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrIntensity(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqIntensity(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchIntensity(siteRequest_, TrafficFlowObserved.staticSetIntensity(siteRequest_, o)).toString();
	}

	public BigDecimal sqlIntensity() {
		return intensity;
	}

	///////////////////
	// laneDirection //
	///////////////////


	/**	 The entity laneDirection
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String laneDirection;

	/**	<br> The entity laneDirection
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:laneDirection">Find the entity laneDirection in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _laneDirection(Wrap<String> w);

	public String getLaneDirection() {
		return laneDirection;
	}
	public void setLaneDirection(String o) {
		this.laneDirection = TrafficFlowObserved.staticSetLaneDirection(siteRequest_, o);
	}
	public static String staticSetLaneDirection(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved laneDirectionInit() {
		Wrap<String> laneDirectionWrap = new Wrap<String>().var("laneDirection");
		if(laneDirection == null) {
			_laneDirection(laneDirectionWrap);
			Optional.ofNullable(laneDirectionWrap.getO()).ifPresent(o -> {
				setLaneDirection(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchLaneDirection(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLaneDirection(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLaneDirection(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchLaneDirection(siteRequest_, TrafficFlowObserved.staticSetLaneDirection(siteRequest_, o)).toString();
	}

	public String sqlLaneDirection() {
		return laneDirection;
	}

	////////////
	// laneId //
	////////////


	/**	 The entity laneId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer laneId;

	/**	<br> The entity laneId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:laneId">Find the entity laneId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _laneId(Wrap<Integer> w);

	public Integer getLaneId() {
		return laneId;
	}

	public void setLaneId(Integer laneId) {
		this.laneId = laneId;
	}
	@JsonIgnore
	public void setLaneId(String o) {
		this.laneId = TrafficFlowObserved.staticSetLaneId(siteRequest_, o);
	}
	public static Integer staticSetLaneId(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected TrafficFlowObserved laneIdInit() {
		Wrap<Integer> laneIdWrap = new Wrap<Integer>().var("laneId");
		if(laneId == null) {
			_laneId(laneIdWrap);
			Optional.ofNullable(laneIdWrap.getO()).ifPresent(o -> {
				setLaneId(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Integer staticSearchLaneId(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrLaneId(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLaneId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchLaneId(siteRequest_, TrafficFlowObserved.staticSetLaneId(siteRequest_, o)).toString();
	}

	public Integer sqlLaneId() {
		return laneId;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = TrafficFlowObserved.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchName(siteRequest_, TrafficFlowObserved.staticSetName(siteRequest_, o)).toString();
	}

	public String sqlName() {
		return name;
	}

	///////////////
	// occupancy //
	///////////////


	/**	 The entity occupancy
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal occupancy;

	/**	<br> The entity occupancy
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:occupancy">Find the entity occupancy in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _occupancy(Wrap<BigDecimal> w);

	public BigDecimal getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(BigDecimal occupancy) {
		this.occupancy = occupancy;
	}
	@JsonIgnore
	public void setOccupancy(String o) {
		this.occupancy = TrafficFlowObserved.staticSetOccupancy(siteRequest_, o);
	}
	public static BigDecimal staticSetOccupancy(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setOccupancy(Double o) {
		setOccupancy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setOccupancy(Integer o) {
		setOccupancy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setOccupancy(Number o) {
		setOccupancy(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved occupancyInit() {
		Wrap<BigDecimal> occupancyWrap = new Wrap<BigDecimal>().var("occupancy");
		if(occupancy == null) {
			_occupancy(occupancyWrap);
			Optional.ofNullable(occupancyWrap.getO()).ifPresent(o -> {
				setOccupancy(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchOccupancy(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrOccupancy(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOccupancy(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchOccupancy(siteRequest_, TrafficFlowObserved.staticSetOccupancy(siteRequest_, o)).toString();
	}

	public BigDecimal sqlOccupancy() {
		return occupancy;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
		this.owner = TrafficFlowObserved.staticSetOwner(siteRequest_, o);
	}
	public static JsonObject staticSetOwner(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected TrafficFlowObserved ownerInit() {
		Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
		if(owner == null) {
			_owner(ownerWrap);
			Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
				setOwner(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchOwner(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOwner(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOwner(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchOwner(siteRequest_, TrafficFlowObserved.staticSetOwner(siteRequest_, o)).toString();
	}

	public JsonObject sqlOwner() {
		return owner;
	}

	////////////////////
	// refRoadSegment //
	////////////////////


	/**	 The entity refRoadSegment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String refRoadSegment;

	/**	<br> The entity refRoadSegment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:refRoadSegment">Find the entity refRoadSegment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _refRoadSegment(Wrap<String> w);

	public String getRefRoadSegment() {
		return refRoadSegment;
	}
	public void setRefRoadSegment(String o) {
		this.refRoadSegment = TrafficFlowObserved.staticSetRefRoadSegment(siteRequest_, o);
	}
	public static String staticSetRefRoadSegment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved refRoadSegmentInit() {
		Wrap<String> refRoadSegmentWrap = new Wrap<String>().var("refRoadSegment");
		if(refRoadSegment == null) {
			_refRoadSegment(refRoadSegmentWrap);
			Optional.ofNullable(refRoadSegmentWrap.getO()).ifPresent(o -> {
				setRefRoadSegment(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchRefRoadSegment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRefRoadSegment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefRoadSegment(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchRefRoadSegment(siteRequest_, TrafficFlowObserved.staticSetRefRoadSegment(siteRequest_, o)).toString();
	}

	public String sqlRefRoadSegment() {
		return refRoadSegment;
	}

	//////////////////
	// reversedLane //
	//////////////////


	/**	 The entity reversedLane
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean reversedLane;

	/**	<br> The entity reversedLane
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:reversedLane">Find the entity reversedLane in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reversedLane(Wrap<Boolean> w);

	public Boolean getReversedLane() {
		return reversedLane;
	}

	public void setReversedLane(Boolean reversedLane) {
		this.reversedLane = reversedLane;
	}
	@JsonIgnore
	public void setReversedLane(String o) {
		this.reversedLane = TrafficFlowObserved.staticSetReversedLane(siteRequest_, o);
	}
	public static Boolean staticSetReversedLane(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected TrafficFlowObserved reversedLaneInit() {
		Wrap<Boolean> reversedLaneWrap = new Wrap<Boolean>().var("reversedLane");
		if(reversedLane == null) {
			_reversedLane(reversedLaneWrap);
			Optional.ofNullable(reversedLaneWrap.getO()).ifPresent(o -> {
				setReversedLane(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Boolean staticSearchReversedLane(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrReversedLane(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReversedLane(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchReversedLane(siteRequest_, TrafficFlowObserved.staticSetReversedLane(siteRequest_, o)).toString();
	}

	public Boolean sqlReversedLane() {
		return reversedLane;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
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
		this.seeAlso = TrafficFlowObserved.staticSetSeeAlso(siteRequest_, o);
	}
	public static JsonObject staticSetSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected TrafficFlowObserved seeAlsoInit() {
		Wrap<JsonObject> seeAlsoWrap = new Wrap<JsonObject>().var("seeAlso");
		if(seeAlso == null) {
			_seeAlso(seeAlsoWrap);
			Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
				setSeeAlso(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchSeeAlso(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSeeAlso(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchSeeAlso(siteRequest_, TrafficFlowObserved.staticSetSeeAlso(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = TrafficFlowObserved.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
				setSource(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchSource(siteRequest_, TrafficFlowObserved.staticSetSource(siteRequest_, o)).toString();
	}

	public String sqlSource() {
		return source;
	}

	////////////////////
	// vehicleSubType //
	////////////////////


	/**	 The entity vehicleSubType
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String vehicleSubType;

	/**	<br> The entity vehicleSubType
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:vehicleSubType">Find the entity vehicleSubType in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _vehicleSubType(Wrap<String> w);

	public String getVehicleSubType() {
		return vehicleSubType;
	}
	public void setVehicleSubType(String o) {
		this.vehicleSubType = TrafficFlowObserved.staticSetVehicleSubType(siteRequest_, o);
	}
	public static String staticSetVehicleSubType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved vehicleSubTypeInit() {
		Wrap<String> vehicleSubTypeWrap = new Wrap<String>().var("vehicleSubType");
		if(vehicleSubType == null) {
			_vehicleSubType(vehicleSubTypeWrap);
			Optional.ofNullable(vehicleSubTypeWrap.getO()).ifPresent(o -> {
				setVehicleSubType(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchVehicleSubType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrVehicleSubType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVehicleSubType(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchVehicleSubType(siteRequest_, TrafficFlowObserved.staticSetVehicleSubType(siteRequest_, o)).toString();
	}

	public String sqlVehicleSubType() {
		return vehicleSubType;
	}

	/////////////////
	// vehicleType //
	/////////////////


	/**	 The entity vehicleType
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String vehicleType;

	/**	<br> The entity vehicleType
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:vehicleType">Find the entity vehicleType in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _vehicleType(Wrap<String> w);

	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String o) {
		this.vehicleType = TrafficFlowObserved.staticSetVehicleType(siteRequest_, o);
	}
	public static String staticSetVehicleType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficFlowObserved vehicleTypeInit() {
		Wrap<String> vehicleTypeWrap = new Wrap<String>().var("vehicleType");
		if(vehicleType == null) {
			_vehicleType(vehicleTypeWrap);
			Optional.ofNullable(vehicleTypeWrap.getO()).ifPresent(o -> {
				setVehicleType(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static String staticSearchVehicleType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrVehicleType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVehicleType(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchVehicleType(siteRequest_, TrafficFlowObserved.staticSetVehicleType(siteRequest_, o)).toString();
	}

	public String sqlVehicleType() {
		return vehicleType;
	}

	/////////////////
	// customSigma //
	/////////////////


	/**	 The entity customSigma
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customSigma;

	/**	<br> The entity customSigma
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customSigma">Find the entity customSigma in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customSigma(Wrap<BigDecimal> w);

	public BigDecimal getCustomSigma() {
		return customSigma;
	}

	public void setCustomSigma(BigDecimal customSigma) {
		this.customSigma = customSigma;
	}
	@JsonIgnore
	public void setCustomSigma(String o) {
		this.customSigma = TrafficFlowObserved.staticSetCustomSigma(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomSigma(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomSigma(Double o) {
		setCustomSigma(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomSigma(Integer o) {
		setCustomSigma(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomSigma(Number o) {
		setCustomSigma(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customSigmaInit() {
		Wrap<BigDecimal> customSigmaWrap = new Wrap<BigDecimal>().var("customSigma");
		if(customSigma == null) {
			_customSigma(customSigmaWrap);
			Optional.ofNullable(customSigmaWrap.getO()).ifPresent(o -> {
				setCustomSigma(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomSigma(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomSigma(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomSigma(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomSigma(siteRequest_, TrafficFlowObserved.staticSetCustomSigma(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomSigma() {
		return customSigma;
	}

	////////////////////////
	// customAcceleration //
	////////////////////////


	/**	 The entity customAcceleration
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customAcceleration;

	/**	<br> The entity customAcceleration
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customAcceleration">Find the entity customAcceleration in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customAcceleration(Wrap<BigDecimal> w);

	public BigDecimal getCustomAcceleration() {
		return customAcceleration;
	}

	public void setCustomAcceleration(BigDecimal customAcceleration) {
		this.customAcceleration = customAcceleration;
	}
	@JsonIgnore
	public void setCustomAcceleration(String o) {
		this.customAcceleration = TrafficFlowObserved.staticSetCustomAcceleration(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomAcceleration(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomAcceleration(Double o) {
		setCustomAcceleration(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomAcceleration(Integer o) {
		setCustomAcceleration(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomAcceleration(Number o) {
		setCustomAcceleration(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customAccelerationInit() {
		Wrap<BigDecimal> customAccelerationWrap = new Wrap<BigDecimal>().var("customAcceleration");
		if(customAcceleration == null) {
			_customAcceleration(customAccelerationWrap);
			Optional.ofNullable(customAccelerationWrap.getO()).ifPresent(o -> {
				setCustomAcceleration(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomAcceleration(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomAcceleration(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomAcceleration(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomAcceleration(siteRequest_, TrafficFlowObserved.staticSetCustomAcceleration(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomAcceleration() {
		return customAcceleration;
	}

	////////////////////////
	// customDeceleration //
	////////////////////////


	/**	 The entity customDeceleration
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customDeceleration;

	/**	<br> The entity customDeceleration
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customDeceleration">Find the entity customDeceleration in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customDeceleration(Wrap<BigDecimal> w);

	public BigDecimal getCustomDeceleration() {
		return customDeceleration;
	}

	public void setCustomDeceleration(BigDecimal customDeceleration) {
		this.customDeceleration = customDeceleration;
	}
	@JsonIgnore
	public void setCustomDeceleration(String o) {
		this.customDeceleration = TrafficFlowObserved.staticSetCustomDeceleration(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomDeceleration(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomDeceleration(Double o) {
		setCustomDeceleration(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomDeceleration(Integer o) {
		setCustomDeceleration(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomDeceleration(Number o) {
		setCustomDeceleration(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customDecelerationInit() {
		Wrap<BigDecimal> customDecelerationWrap = new Wrap<BigDecimal>().var("customDeceleration");
		if(customDeceleration == null) {
			_customDeceleration(customDecelerationWrap);
			Optional.ofNullable(customDecelerationWrap.getO()).ifPresent(o -> {
				setCustomDeceleration(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomDeceleration(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomDeceleration(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomDeceleration(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomDeceleration(siteRequest_, TrafficFlowObserved.staticSetCustomDeceleration(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomDeceleration() {
		return customDeceleration;
	}

	////////////////////////
	// customMinGreenTime //
	////////////////////////


	/**	 The entity customMinGreenTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customMinGreenTime;

	/**	<br> The entity customMinGreenTime
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customMinGreenTime">Find the entity customMinGreenTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customMinGreenTime(Wrap<BigDecimal> w);

	public BigDecimal getCustomMinGreenTime() {
		return customMinGreenTime;
	}

	public void setCustomMinGreenTime(BigDecimal customMinGreenTime) {
		this.customMinGreenTime = customMinGreenTime;
	}
	@JsonIgnore
	public void setCustomMinGreenTime(String o) {
		this.customMinGreenTime = TrafficFlowObserved.staticSetCustomMinGreenTime(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomMinGreenTime(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomMinGreenTime(Double o) {
		setCustomMinGreenTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomMinGreenTime(Integer o) {
		setCustomMinGreenTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomMinGreenTime(Number o) {
		setCustomMinGreenTime(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customMinGreenTimeInit() {
		Wrap<BigDecimal> customMinGreenTimeWrap = new Wrap<BigDecimal>().var("customMinGreenTime");
		if(customMinGreenTime == null) {
			_customMinGreenTime(customMinGreenTimeWrap);
			Optional.ofNullable(customMinGreenTimeWrap.getO()).ifPresent(o -> {
				setCustomMinGreenTime(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomMinGreenTime(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomMinGreenTime(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomMinGreenTime(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomMinGreenTime(siteRequest_, TrafficFlowObserved.staticSetCustomMinGreenTime(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomMinGreenTime() {
		return customMinGreenTime;
	}

	////////////////////////
	// customMaxGreenTime //
	////////////////////////


	/**	 The entity customMaxGreenTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customMaxGreenTime;

	/**	<br> The entity customMaxGreenTime
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customMaxGreenTime">Find the entity customMaxGreenTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customMaxGreenTime(Wrap<BigDecimal> w);

	public BigDecimal getCustomMaxGreenTime() {
		return customMaxGreenTime;
	}

	public void setCustomMaxGreenTime(BigDecimal customMaxGreenTime) {
		this.customMaxGreenTime = customMaxGreenTime;
	}
	@JsonIgnore
	public void setCustomMaxGreenTime(String o) {
		this.customMaxGreenTime = TrafficFlowObserved.staticSetCustomMaxGreenTime(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomMaxGreenTime(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomMaxGreenTime(Double o) {
		setCustomMaxGreenTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomMaxGreenTime(Integer o) {
		setCustomMaxGreenTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomMaxGreenTime(Number o) {
		setCustomMaxGreenTime(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customMaxGreenTimeInit() {
		Wrap<BigDecimal> customMaxGreenTimeWrap = new Wrap<BigDecimal>().var("customMaxGreenTime");
		if(customMaxGreenTime == null) {
			_customMaxGreenTime(customMaxGreenTimeWrap);
			Optional.ofNullable(customMaxGreenTimeWrap.getO()).ifPresent(o -> {
				setCustomMaxGreenTime(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomMaxGreenTime(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomMaxGreenTime(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomMaxGreenTime(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomMaxGreenTime(siteRequest_, TrafficFlowObserved.staticSetCustomMaxGreenTime(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomMaxGreenTime() {
		return customMaxGreenTime;
	}

	////////////////////////////////////
	// customAverageVehiclesPerMinute //
	////////////////////////////////////


	/**	 The entity customAverageVehiclesPerMinute
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customAverageVehiclesPerMinute;

	/**	<br> The entity customAverageVehiclesPerMinute
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customAverageVehiclesPerMinute">Find the entity customAverageVehiclesPerMinute in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customAverageVehiclesPerMinute(Wrap<BigDecimal> w);

	public BigDecimal getCustomAverageVehiclesPerMinute() {
		return customAverageVehiclesPerMinute;
	}

	public void setCustomAverageVehiclesPerMinute(BigDecimal customAverageVehiclesPerMinute) {
		this.customAverageVehiclesPerMinute = customAverageVehiclesPerMinute;
	}
	@JsonIgnore
	public void setCustomAverageVehiclesPerMinute(String o) {
		this.customAverageVehiclesPerMinute = TrafficFlowObserved.staticSetCustomAverageVehiclesPerMinute(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomAverageVehiclesPerMinute(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomAverageVehiclesPerMinute(Double o) {
		setCustomAverageVehiclesPerMinute(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomAverageVehiclesPerMinute(Integer o) {
		setCustomAverageVehiclesPerMinute(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomAverageVehiclesPerMinute(Number o) {
		setCustomAverageVehiclesPerMinute(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customAverageVehiclesPerMinuteInit() {
		Wrap<BigDecimal> customAverageVehiclesPerMinuteWrap = new Wrap<BigDecimal>().var("customAverageVehiclesPerMinute");
		if(customAverageVehiclesPerMinute == null) {
			_customAverageVehiclesPerMinute(customAverageVehiclesPerMinuteWrap);
			Optional.ofNullable(customAverageVehiclesPerMinuteWrap.getO()).ifPresent(o -> {
				setCustomAverageVehiclesPerMinute(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomAverageVehiclesPerMinute(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomAverageVehiclesPerMinute(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomAverageVehiclesPerMinute(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomAverageVehiclesPerMinute(siteRequest_, TrafficFlowObserved.staticSetCustomAverageVehiclesPerMinute(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomAverageVehiclesPerMinute() {
		return customAverageVehiclesPerMinute;
	}

	///////////////////////////////
	// customDemandScalingFactor //
	///////////////////////////////


	/**	 The entity customDemandScalingFactor
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customDemandScalingFactor;

	/**	<br> The entity customDemandScalingFactor
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customDemandScalingFactor">Find the entity customDemandScalingFactor in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customDemandScalingFactor(Wrap<BigDecimal> w);

	public BigDecimal getCustomDemandScalingFactor() {
		return customDemandScalingFactor;
	}

	public void setCustomDemandScalingFactor(BigDecimal customDemandScalingFactor) {
		this.customDemandScalingFactor = customDemandScalingFactor;
	}
	@JsonIgnore
	public void setCustomDemandScalingFactor(String o) {
		this.customDemandScalingFactor = TrafficFlowObserved.staticSetCustomDemandScalingFactor(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomDemandScalingFactor(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomDemandScalingFactor(Double o) {
		setCustomDemandScalingFactor(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomDemandScalingFactor(Integer o) {
		setCustomDemandScalingFactor(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomDemandScalingFactor(Number o) {
		setCustomDemandScalingFactor(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customDemandScalingFactorInit() {
		Wrap<BigDecimal> customDemandScalingFactorWrap = new Wrap<BigDecimal>().var("customDemandScalingFactor");
		if(customDemandScalingFactor == null) {
			_customDemandScalingFactor(customDemandScalingFactorWrap);
			Optional.ofNullable(customDemandScalingFactorWrap.getO()).ifPresent(o -> {
				setCustomDemandScalingFactor(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomDemandScalingFactor(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomDemandScalingFactor(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomDemandScalingFactor(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomDemandScalingFactor(siteRequest_, TrafficFlowObserved.staticSetCustomDemandScalingFactor(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomDemandScalingFactor() {
		return customDemandScalingFactor;
	}

	////////////////////////////////
	// customQueueLengthThreshold //
	////////////////////////////////


	/**	 The entity customQueueLengthThreshold
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal customQueueLengthThreshold;

	/**	<br> The entity customQueueLengthThreshold
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObserved&fq=entiteVar_enUS_indexed_string:customQueueLengthThreshold">Find the entity customQueueLengthThreshold in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _customQueueLengthThreshold(Wrap<BigDecimal> w);

	public BigDecimal getCustomQueueLengthThreshold() {
		return customQueueLengthThreshold;
	}

	public void setCustomQueueLengthThreshold(BigDecimal customQueueLengthThreshold) {
		this.customQueueLengthThreshold = customQueueLengthThreshold;
	}
	@JsonIgnore
	public void setCustomQueueLengthThreshold(String o) {
		this.customQueueLengthThreshold = TrafficFlowObserved.staticSetCustomQueueLengthThreshold(siteRequest_, o);
	}
	public static BigDecimal staticSetCustomQueueLengthThreshold(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCustomQueueLengthThreshold(Double o) {
		setCustomQueueLengthThreshold(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomQueueLengthThreshold(Integer o) {
		setCustomQueueLengthThreshold(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCustomQueueLengthThreshold(Number o) {
		setCustomQueueLengthThreshold(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficFlowObserved customQueueLengthThresholdInit() {
		Wrap<BigDecimal> customQueueLengthThresholdWrap = new Wrap<BigDecimal>().var("customQueueLengthThreshold");
		if(customQueueLengthThreshold == null) {
			_customQueueLengthThreshold(customQueueLengthThresholdWrap);
			Optional.ofNullable(customQueueLengthThresholdWrap.getO()).ifPresent(o -> {
				setCustomQueueLengthThreshold(o);
			});
		}
		return (TrafficFlowObserved)this;
	}

	public static Double staticSearchCustomQueueLengthThreshold(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCustomQueueLengthThreshold(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCustomQueueLengthThreshold(SiteRequestEnUS siteRequest_, String o) {
		return TrafficFlowObserved.staticSearchCustomQueueLengthThreshold(siteRequest_, TrafficFlowObserved.staticSetCustomQueueLengthThreshold(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCustomQueueLengthThreshold() {
		return customQueueLengthThreshold;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepTrafficFlowObserved(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepTrafficFlowObserved();
	}

	public Future<Void> promiseDeepTrafficFlowObserved() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseTrafficFlowObserved(promise2);
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

	public Future<Void> promiseTrafficFlowObserved(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				colorInit();
				entityIdInit();
				entityShortIdInit();
				trafficSimulationIdInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			trafficSimulationSearchPromise().onSuccess(trafficSimulationSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				trafficSimulation_Init();
				laneAreaDetectorIdInit();
				locationInit();
				simulationNameInit();
				sumocfgPathInit();
				customTrafficLightIdInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			smartTrafficLightSearchPromise().onSuccess(smartTrafficLightSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				smartTrafficLight_Init();
				addressInit();
				alternateNameInit();
				areaServedColorsInit();
				areaServedTitlesInit();
				areaServedLinksInit();
				areaServedInit();
				averageGapDistanceInit();
				averageHeadwayTimeInit();
				averageVehicleLengthInit();
				averageVehicleSpeedInit();
				congestedInit();
				dataProviderInit();
				dateCreatedInit();
				dateModifiedInit();
				dateObservedInit();
				dateObservedFromInit();
				dateObservedToInit();
				descriptionInit();
				intensityInit();
				laneDirectionInit();
				laneIdInit();
				nameInit();
				occupancyInit();
				ownerInit();
				refRoadSegmentInit();
				reversedLaneInit();
				seeAlsoInit();
				sourceInit();
				vehicleSubTypeInit();
				vehicleTypeInit();
				customSigmaInit();
				customAccelerationInit();
				customDecelerationInit();
				customMinGreenTimeInit();
				customMaxGreenTimeInit();
				customAverageVehiclesPerMinuteInit();
				customDemandScalingFactorInit();
				customQueueLengthThresholdInit();
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
		return promiseDeepTrafficFlowObserved(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestTrafficFlowObserved(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
		if(trafficSimulationSearch != null)
			trafficSimulationSearch.setSiteRequest_(siteRequest_);
		if(smartTrafficLightSearch != null)
			smartTrafficLightSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestTrafficFlowObserved(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTrafficFlowObserved(v);
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
	public Object obtainTrafficFlowObserved(String var) {
		TrafficFlowObserved oTrafficFlowObserved = (TrafficFlowObserved)this;
		switch(var) {
			case "color":
				return oTrafficFlowObserved.color;
			case "entityId":
				return oTrafficFlowObserved.entityId;
			case "entityShortId":
				return oTrafficFlowObserved.entityShortId;
			case "trafficSimulationId":
				return oTrafficFlowObserved.trafficSimulationId;
			case "trafficSimulationSearch":
				return oTrafficFlowObserved.trafficSimulationSearch;
			case "trafficSimulation_":
				return oTrafficFlowObserved.trafficSimulation_;
			case "laneAreaDetectorId":
				return oTrafficFlowObserved.laneAreaDetectorId;
			case "location":
				return oTrafficFlowObserved.location;
			case "simulationName":
				return oTrafficFlowObserved.simulationName;
			case "sumocfgPath":
				return oTrafficFlowObserved.sumocfgPath;
			case "customTrafficLightId":
				return oTrafficFlowObserved.customTrafficLightId;
			case "smartTrafficLightSearch":
				return oTrafficFlowObserved.smartTrafficLightSearch;
			case "smartTrafficLight_":
				return oTrafficFlowObserved.smartTrafficLight_;
			case "address":
				return oTrafficFlowObserved.address;
			case "alternateName":
				return oTrafficFlowObserved.alternateName;
			case "areaServedColors":
				return oTrafficFlowObserved.areaServedColors;
			case "areaServedTitles":
				return oTrafficFlowObserved.areaServedTitles;
			case "areaServedLinks":
				return oTrafficFlowObserved.areaServedLinks;
			case "areaServed":
				return oTrafficFlowObserved.areaServed;
			case "averageGapDistance":
				return oTrafficFlowObserved.averageGapDistance;
			case "averageHeadwayTime":
				return oTrafficFlowObserved.averageHeadwayTime;
			case "averageVehicleLength":
				return oTrafficFlowObserved.averageVehicleLength;
			case "averageVehicleSpeed":
				return oTrafficFlowObserved.averageVehicleSpeed;
			case "congested":
				return oTrafficFlowObserved.congested;
			case "dataProvider":
				return oTrafficFlowObserved.dataProvider;
			case "dateCreated":
				return oTrafficFlowObserved.dateCreated;
			case "dateModified":
				return oTrafficFlowObserved.dateModified;
			case "dateObserved":
				return oTrafficFlowObserved.dateObserved;
			case "dateObservedFrom":
				return oTrafficFlowObserved.dateObservedFrom;
			case "dateObservedTo":
				return oTrafficFlowObserved.dateObservedTo;
			case "description":
				return oTrafficFlowObserved.description;
			case "intensity":
				return oTrafficFlowObserved.intensity;
			case "laneDirection":
				return oTrafficFlowObserved.laneDirection;
			case "laneId":
				return oTrafficFlowObserved.laneId;
			case "name":
				return oTrafficFlowObserved.name;
			case "occupancy":
				return oTrafficFlowObserved.occupancy;
			case "owner":
				return oTrafficFlowObserved.owner;
			case "refRoadSegment":
				return oTrafficFlowObserved.refRoadSegment;
			case "reversedLane":
				return oTrafficFlowObserved.reversedLane;
			case "seeAlso":
				return oTrafficFlowObserved.seeAlso;
			case "source":
				return oTrafficFlowObserved.source;
			case "vehicleSubType":
				return oTrafficFlowObserved.vehicleSubType;
			case "vehicleType":
				return oTrafficFlowObserved.vehicleType;
			case "customSigma":
				return oTrafficFlowObserved.customSigma;
			case "customAcceleration":
				return oTrafficFlowObserved.customAcceleration;
			case "customDeceleration":
				return oTrafficFlowObserved.customDeceleration;
			case "customMinGreenTime":
				return oTrafficFlowObserved.customMinGreenTime;
			case "customMaxGreenTime":
				return oTrafficFlowObserved.customMaxGreenTime;
			case "customAverageVehiclesPerMinute":
				return oTrafficFlowObserved.customAverageVehiclesPerMinute;
			case "customDemandScalingFactor":
				return oTrafficFlowObserved.customDemandScalingFactor;
			case "customQueueLengthThreshold":
				return oTrafficFlowObserved.customQueueLengthThreshold;
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
				o = relateTrafficFlowObserved(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateTrafficFlowObserved(String var, Object val) {
		TrafficFlowObserved oTrafficFlowObserved = (TrafficFlowObserved)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetTrafficFlowObserved(entityVar,  siteRequest_, o);
	}
	public static Object staticSetTrafficFlowObserved(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "color":
			return TrafficFlowObserved.staticSetColor(siteRequest_, o);
		case "entityId":
			return TrafficFlowObserved.staticSetEntityId(siteRequest_, o);
		case "entityShortId":
			return TrafficFlowObserved.staticSetEntityShortId(siteRequest_, o);
		case "trafficSimulationId":
			return TrafficFlowObserved.staticSetTrafficSimulationId(siteRequest_, o);
		case "laneAreaDetectorId":
			return TrafficFlowObserved.staticSetLaneAreaDetectorId(siteRequest_, o);
		case "location":
			return TrafficFlowObserved.staticSetLocation(siteRequest_, o);
		case "simulationName":
			return TrafficFlowObserved.staticSetSimulationName(siteRequest_, o);
		case "sumocfgPath":
			return TrafficFlowObserved.staticSetSumocfgPath(siteRequest_, o);
		case "customTrafficLightId":
			return TrafficFlowObserved.staticSetCustomTrafficLightId(siteRequest_, o);
		case "address":
			return TrafficFlowObserved.staticSetAddress(siteRequest_, o);
		case "alternateName":
			return TrafficFlowObserved.staticSetAlternateName(siteRequest_, o);
		case "areaServedColors":
			return TrafficFlowObserved.staticSetAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return TrafficFlowObserved.staticSetAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return TrafficFlowObserved.staticSetAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return TrafficFlowObserved.staticSetAreaServed(siteRequest_, o);
		case "averageGapDistance":
			return TrafficFlowObserved.staticSetAverageGapDistance(siteRequest_, o);
		case "averageHeadwayTime":
			return TrafficFlowObserved.staticSetAverageHeadwayTime(siteRequest_, o);
		case "averageVehicleLength":
			return TrafficFlowObserved.staticSetAverageVehicleLength(siteRequest_, o);
		case "averageVehicleSpeed":
			return TrafficFlowObserved.staticSetAverageVehicleSpeed(siteRequest_, o);
		case "congested":
			return TrafficFlowObserved.staticSetCongested(siteRequest_, o);
		case "dataProvider":
			return TrafficFlowObserved.staticSetDataProvider(siteRequest_, o);
		case "dateCreated":
			return TrafficFlowObserved.staticSetDateCreated(siteRequest_, o);
		case "dateModified":
			return TrafficFlowObserved.staticSetDateModified(siteRequest_, o);
		case "dateObserved":
			return TrafficFlowObserved.staticSetDateObserved(siteRequest_, o);
		case "dateObservedFrom":
			return TrafficFlowObserved.staticSetDateObservedFrom(siteRequest_, o);
		case "dateObservedTo":
			return TrafficFlowObserved.staticSetDateObservedTo(siteRequest_, o);
		case "description":
			return TrafficFlowObserved.staticSetDescription(siteRequest_, o);
		case "intensity":
			return TrafficFlowObserved.staticSetIntensity(siteRequest_, o);
		case "laneDirection":
			return TrafficFlowObserved.staticSetLaneDirection(siteRequest_, o);
		case "laneId":
			return TrafficFlowObserved.staticSetLaneId(siteRequest_, o);
		case "name":
			return TrafficFlowObserved.staticSetName(siteRequest_, o);
		case "occupancy":
			return TrafficFlowObserved.staticSetOccupancy(siteRequest_, o);
		case "owner":
			return TrafficFlowObserved.staticSetOwner(siteRequest_, o);
		case "refRoadSegment":
			return TrafficFlowObserved.staticSetRefRoadSegment(siteRequest_, o);
		case "reversedLane":
			return TrafficFlowObserved.staticSetReversedLane(siteRequest_, o);
		case "seeAlso":
			return TrafficFlowObserved.staticSetSeeAlso(siteRequest_, o);
		case "source":
			return TrafficFlowObserved.staticSetSource(siteRequest_, o);
		case "vehicleSubType":
			return TrafficFlowObserved.staticSetVehicleSubType(siteRequest_, o);
		case "vehicleType":
			return TrafficFlowObserved.staticSetVehicleType(siteRequest_, o);
		case "customSigma":
			return TrafficFlowObserved.staticSetCustomSigma(siteRequest_, o);
		case "customAcceleration":
			return TrafficFlowObserved.staticSetCustomAcceleration(siteRequest_, o);
		case "customDeceleration":
			return TrafficFlowObserved.staticSetCustomDeceleration(siteRequest_, o);
		case "customMinGreenTime":
			return TrafficFlowObserved.staticSetCustomMinGreenTime(siteRequest_, o);
		case "customMaxGreenTime":
			return TrafficFlowObserved.staticSetCustomMaxGreenTime(siteRequest_, o);
		case "customAverageVehiclesPerMinute":
			return TrafficFlowObserved.staticSetCustomAverageVehiclesPerMinute(siteRequest_, o);
		case "customDemandScalingFactor":
			return TrafficFlowObserved.staticSetCustomDemandScalingFactor(siteRequest_, o);
		case "customQueueLengthThreshold":
			return TrafficFlowObserved.staticSetCustomQueueLengthThreshold(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchTrafficFlowObserved(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchTrafficFlowObserved(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "color":
			return TrafficFlowObserved.staticSearchColor(siteRequest_, (String)o);
		case "entityId":
			return TrafficFlowObserved.staticSearchEntityId(siteRequest_, (String)o);
		case "entityShortId":
			return TrafficFlowObserved.staticSearchEntityShortId(siteRequest_, (String)o);
		case "trafficSimulationId":
			return TrafficFlowObserved.staticSearchTrafficSimulationId(siteRequest_, (String)o);
		case "laneAreaDetectorId":
			return TrafficFlowObserved.staticSearchLaneAreaDetectorId(siteRequest_, (String)o);
		case "location":
			return TrafficFlowObserved.staticSearchLocation(siteRequest_, (Point)o);
		case "simulationName":
			return TrafficFlowObserved.staticSearchSimulationName(siteRequest_, (String)o);
		case "sumocfgPath":
			return TrafficFlowObserved.staticSearchSumocfgPath(siteRequest_, (String)o);
		case "customTrafficLightId":
			return TrafficFlowObserved.staticSearchCustomTrafficLightId(siteRequest_, (String)o);
		case "address":
			return TrafficFlowObserved.staticSearchAddress(siteRequest_, (JsonObject)o);
		case "alternateName":
			return TrafficFlowObserved.staticSearchAlternateName(siteRequest_, (String)o);
		case "areaServedColors":
			return TrafficFlowObserved.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return TrafficFlowObserved.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return TrafficFlowObserved.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return TrafficFlowObserved.staticSearchAreaServed(siteRequest_, (Path)o);
		case "averageGapDistance":
			return TrafficFlowObserved.staticSearchAverageGapDistance(siteRequest_, (BigDecimal)o);
		case "averageHeadwayTime":
			return TrafficFlowObserved.staticSearchAverageHeadwayTime(siteRequest_, (BigDecimal)o);
		case "averageVehicleLength":
			return TrafficFlowObserved.staticSearchAverageVehicleLength(siteRequest_, (BigDecimal)o);
		case "averageVehicleSpeed":
			return TrafficFlowObserved.staticSearchAverageVehicleSpeed(siteRequest_, (BigDecimal)o);
		case "congested":
			return TrafficFlowObserved.staticSearchCongested(siteRequest_, (Boolean)o);
		case "dataProvider":
			return TrafficFlowObserved.staticSearchDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return TrafficFlowObserved.staticSearchDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return TrafficFlowObserved.staticSearchDateModified(siteRequest_, (String)o);
		case "dateObserved":
			return TrafficFlowObserved.staticSearchDateObserved(siteRequest_, (String)o);
		case "dateObservedFrom":
			return TrafficFlowObserved.staticSearchDateObservedFrom(siteRequest_, (String)o);
		case "dateObservedTo":
			return TrafficFlowObserved.staticSearchDateObservedTo(siteRequest_, (String)o);
		case "description":
			return TrafficFlowObserved.staticSearchDescription(siteRequest_, (String)o);
		case "intensity":
			return TrafficFlowObserved.staticSearchIntensity(siteRequest_, (BigDecimal)o);
		case "laneDirection":
			return TrafficFlowObserved.staticSearchLaneDirection(siteRequest_, (String)o);
		case "laneId":
			return TrafficFlowObserved.staticSearchLaneId(siteRequest_, (Integer)o);
		case "name":
			return TrafficFlowObserved.staticSearchName(siteRequest_, (String)o);
		case "occupancy":
			return TrafficFlowObserved.staticSearchOccupancy(siteRequest_, (BigDecimal)o);
		case "owner":
			return TrafficFlowObserved.staticSearchOwner(siteRequest_, (JsonObject)o);
		case "refRoadSegment":
			return TrafficFlowObserved.staticSearchRefRoadSegment(siteRequest_, (String)o);
		case "reversedLane":
			return TrafficFlowObserved.staticSearchReversedLane(siteRequest_, (Boolean)o);
		case "seeAlso":
			return TrafficFlowObserved.staticSearchSeeAlso(siteRequest_, (JsonObject)o);
		case "source":
			return TrafficFlowObserved.staticSearchSource(siteRequest_, (String)o);
		case "vehicleSubType":
			return TrafficFlowObserved.staticSearchVehicleSubType(siteRequest_, (String)o);
		case "vehicleType":
			return TrafficFlowObserved.staticSearchVehicleType(siteRequest_, (String)o);
		case "customSigma":
			return TrafficFlowObserved.staticSearchCustomSigma(siteRequest_, (BigDecimal)o);
		case "customAcceleration":
			return TrafficFlowObserved.staticSearchCustomAcceleration(siteRequest_, (BigDecimal)o);
		case "customDeceleration":
			return TrafficFlowObserved.staticSearchCustomDeceleration(siteRequest_, (BigDecimal)o);
		case "customMinGreenTime":
			return TrafficFlowObserved.staticSearchCustomMinGreenTime(siteRequest_, (BigDecimal)o);
		case "customMaxGreenTime":
			return TrafficFlowObserved.staticSearchCustomMaxGreenTime(siteRequest_, (BigDecimal)o);
		case "customAverageVehiclesPerMinute":
			return TrafficFlowObserved.staticSearchCustomAverageVehiclesPerMinute(siteRequest_, (BigDecimal)o);
		case "customDemandScalingFactor":
			return TrafficFlowObserved.staticSearchCustomDemandScalingFactor(siteRequest_, (BigDecimal)o);
		case "customQueueLengthThreshold":
			return TrafficFlowObserved.staticSearchCustomQueueLengthThreshold(siteRequest_, (BigDecimal)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrTrafficFlowObserved(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrTrafficFlowObserved(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "color":
			return TrafficFlowObserved.staticSearchStrColor(siteRequest_, (String)o);
		case "entityId":
			return TrafficFlowObserved.staticSearchStrEntityId(siteRequest_, (String)o);
		case "entityShortId":
			return TrafficFlowObserved.staticSearchStrEntityShortId(siteRequest_, (String)o);
		case "trafficSimulationId":
			return TrafficFlowObserved.staticSearchStrTrafficSimulationId(siteRequest_, (String)o);
		case "laneAreaDetectorId":
			return TrafficFlowObserved.staticSearchStrLaneAreaDetectorId(siteRequest_, (String)o);
		case "location":
			return TrafficFlowObserved.staticSearchStrLocation(siteRequest_, (Point)o);
		case "simulationName":
			return TrafficFlowObserved.staticSearchStrSimulationName(siteRequest_, (String)o);
		case "sumocfgPath":
			return TrafficFlowObserved.staticSearchStrSumocfgPath(siteRequest_, (String)o);
		case "customTrafficLightId":
			return TrafficFlowObserved.staticSearchStrCustomTrafficLightId(siteRequest_, (String)o);
		case "address":
			return TrafficFlowObserved.staticSearchStrAddress(siteRequest_, (String)o);
		case "alternateName":
			return TrafficFlowObserved.staticSearchStrAlternateName(siteRequest_, (String)o);
		case "areaServedColors":
			return TrafficFlowObserved.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return TrafficFlowObserved.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return TrafficFlowObserved.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return TrafficFlowObserved.staticSearchStrAreaServed(siteRequest_, (Path)o);
		case "averageGapDistance":
			return TrafficFlowObserved.staticSearchStrAverageGapDistance(siteRequest_, (Double)o);
		case "averageHeadwayTime":
			return TrafficFlowObserved.staticSearchStrAverageHeadwayTime(siteRequest_, (Double)o);
		case "averageVehicleLength":
			return TrafficFlowObserved.staticSearchStrAverageVehicleLength(siteRequest_, (Double)o);
		case "averageVehicleSpeed":
			return TrafficFlowObserved.staticSearchStrAverageVehicleSpeed(siteRequest_, (Double)o);
		case "congested":
			return TrafficFlowObserved.staticSearchStrCongested(siteRequest_, (Boolean)o);
		case "dataProvider":
			return TrafficFlowObserved.staticSearchStrDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return TrafficFlowObserved.staticSearchStrDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return TrafficFlowObserved.staticSearchStrDateModified(siteRequest_, (String)o);
		case "dateObserved":
			return TrafficFlowObserved.staticSearchStrDateObserved(siteRequest_, (String)o);
		case "dateObservedFrom":
			return TrafficFlowObserved.staticSearchStrDateObservedFrom(siteRequest_, (String)o);
		case "dateObservedTo":
			return TrafficFlowObserved.staticSearchStrDateObservedTo(siteRequest_, (String)o);
		case "description":
			return TrafficFlowObserved.staticSearchStrDescription(siteRequest_, (String)o);
		case "intensity":
			return TrafficFlowObserved.staticSearchStrIntensity(siteRequest_, (Double)o);
		case "laneDirection":
			return TrafficFlowObserved.staticSearchStrLaneDirection(siteRequest_, (String)o);
		case "laneId":
			return TrafficFlowObserved.staticSearchStrLaneId(siteRequest_, (Integer)o);
		case "name":
			return TrafficFlowObserved.staticSearchStrName(siteRequest_, (String)o);
		case "occupancy":
			return TrafficFlowObserved.staticSearchStrOccupancy(siteRequest_, (Double)o);
		case "owner":
			return TrafficFlowObserved.staticSearchStrOwner(siteRequest_, (String)o);
		case "refRoadSegment":
			return TrafficFlowObserved.staticSearchStrRefRoadSegment(siteRequest_, (String)o);
		case "reversedLane":
			return TrafficFlowObserved.staticSearchStrReversedLane(siteRequest_, (Boolean)o);
		case "seeAlso":
			return TrafficFlowObserved.staticSearchStrSeeAlso(siteRequest_, (String)o);
		case "source":
			return TrafficFlowObserved.staticSearchStrSource(siteRequest_, (String)o);
		case "vehicleSubType":
			return TrafficFlowObserved.staticSearchStrVehicleSubType(siteRequest_, (String)o);
		case "vehicleType":
			return TrafficFlowObserved.staticSearchStrVehicleType(siteRequest_, (String)o);
		case "customSigma":
			return TrafficFlowObserved.staticSearchStrCustomSigma(siteRequest_, (Double)o);
		case "customAcceleration":
			return TrafficFlowObserved.staticSearchStrCustomAcceleration(siteRequest_, (Double)o);
		case "customDeceleration":
			return TrafficFlowObserved.staticSearchStrCustomDeceleration(siteRequest_, (Double)o);
		case "customMinGreenTime":
			return TrafficFlowObserved.staticSearchStrCustomMinGreenTime(siteRequest_, (Double)o);
		case "customMaxGreenTime":
			return TrafficFlowObserved.staticSearchStrCustomMaxGreenTime(siteRequest_, (Double)o);
		case "customAverageVehiclesPerMinute":
			return TrafficFlowObserved.staticSearchStrCustomAverageVehiclesPerMinute(siteRequest_, (Double)o);
		case "customDemandScalingFactor":
			return TrafficFlowObserved.staticSearchStrCustomDemandScalingFactor(siteRequest_, (Double)o);
		case "customQueueLengthThreshold":
			return TrafficFlowObserved.staticSearchStrCustomQueueLengthThreshold(siteRequest_, (Double)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqTrafficFlowObserved(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqTrafficFlowObserved(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "color":
			return TrafficFlowObserved.staticSearchFqColor(siteRequest_, o);
		case "entityId":
			return TrafficFlowObserved.staticSearchFqEntityId(siteRequest_, o);
		case "entityShortId":
			return TrafficFlowObserved.staticSearchFqEntityShortId(siteRequest_, o);
		case "trafficSimulationId":
			return TrafficFlowObserved.staticSearchFqTrafficSimulationId(siteRequest_, o);
		case "laneAreaDetectorId":
			return TrafficFlowObserved.staticSearchFqLaneAreaDetectorId(siteRequest_, o);
		case "location":
			return TrafficFlowObserved.staticSearchFqLocation(siteRequest_, o);
		case "simulationName":
			return TrafficFlowObserved.staticSearchFqSimulationName(siteRequest_, o);
		case "sumocfgPath":
			return TrafficFlowObserved.staticSearchFqSumocfgPath(siteRequest_, o);
		case "customTrafficLightId":
			return TrafficFlowObserved.staticSearchFqCustomTrafficLightId(siteRequest_, o);
		case "address":
			return TrafficFlowObserved.staticSearchFqAddress(siteRequest_, o);
		case "alternateName":
			return TrafficFlowObserved.staticSearchFqAlternateName(siteRequest_, o);
		case "areaServedColors":
			return TrafficFlowObserved.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return TrafficFlowObserved.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return TrafficFlowObserved.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return TrafficFlowObserved.staticSearchFqAreaServed(siteRequest_, o);
		case "averageGapDistance":
			return TrafficFlowObserved.staticSearchFqAverageGapDistance(siteRequest_, o);
		case "averageHeadwayTime":
			return TrafficFlowObserved.staticSearchFqAverageHeadwayTime(siteRequest_, o);
		case "averageVehicleLength":
			return TrafficFlowObserved.staticSearchFqAverageVehicleLength(siteRequest_, o);
		case "averageVehicleSpeed":
			return TrafficFlowObserved.staticSearchFqAverageVehicleSpeed(siteRequest_, o);
		case "congested":
			return TrafficFlowObserved.staticSearchFqCongested(siteRequest_, o);
		case "dataProvider":
			return TrafficFlowObserved.staticSearchFqDataProvider(siteRequest_, o);
		case "dateCreated":
			return TrafficFlowObserved.staticSearchFqDateCreated(siteRequest_, o);
		case "dateModified":
			return TrafficFlowObserved.staticSearchFqDateModified(siteRequest_, o);
		case "dateObserved":
			return TrafficFlowObserved.staticSearchFqDateObserved(siteRequest_, o);
		case "dateObservedFrom":
			return TrafficFlowObserved.staticSearchFqDateObservedFrom(siteRequest_, o);
		case "dateObservedTo":
			return TrafficFlowObserved.staticSearchFqDateObservedTo(siteRequest_, o);
		case "description":
			return TrafficFlowObserved.staticSearchFqDescription(siteRequest_, o);
		case "intensity":
			return TrafficFlowObserved.staticSearchFqIntensity(siteRequest_, o);
		case "laneDirection":
			return TrafficFlowObserved.staticSearchFqLaneDirection(siteRequest_, o);
		case "laneId":
			return TrafficFlowObserved.staticSearchFqLaneId(siteRequest_, o);
		case "name":
			return TrafficFlowObserved.staticSearchFqName(siteRequest_, o);
		case "occupancy":
			return TrafficFlowObserved.staticSearchFqOccupancy(siteRequest_, o);
		case "owner":
			return TrafficFlowObserved.staticSearchFqOwner(siteRequest_, o);
		case "refRoadSegment":
			return TrafficFlowObserved.staticSearchFqRefRoadSegment(siteRequest_, o);
		case "reversedLane":
			return TrafficFlowObserved.staticSearchFqReversedLane(siteRequest_, o);
		case "seeAlso":
			return TrafficFlowObserved.staticSearchFqSeeAlso(siteRequest_, o);
		case "source":
			return TrafficFlowObserved.staticSearchFqSource(siteRequest_, o);
		case "vehicleSubType":
			return TrafficFlowObserved.staticSearchFqVehicleSubType(siteRequest_, o);
		case "vehicleType":
			return TrafficFlowObserved.staticSearchFqVehicleType(siteRequest_, o);
		case "customSigma":
			return TrafficFlowObserved.staticSearchFqCustomSigma(siteRequest_, o);
		case "customAcceleration":
			return TrafficFlowObserved.staticSearchFqCustomAcceleration(siteRequest_, o);
		case "customDeceleration":
			return TrafficFlowObserved.staticSearchFqCustomDeceleration(siteRequest_, o);
		case "customMinGreenTime":
			return TrafficFlowObserved.staticSearchFqCustomMinGreenTime(siteRequest_, o);
		case "customMaxGreenTime":
			return TrafficFlowObserved.staticSearchFqCustomMaxGreenTime(siteRequest_, o);
		case "customAverageVehiclesPerMinute":
			return TrafficFlowObserved.staticSearchFqCustomAverageVehiclesPerMinute(siteRequest_, o);
		case "customDemandScalingFactor":
			return TrafficFlowObserved.staticSearchFqCustomDemandScalingFactor(siteRequest_, o);
		case "customQueueLengthThreshold":
			return TrafficFlowObserved.staticSearchFqCustomQueueLengthThreshold(siteRequest_, o);
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
					o = persistTrafficFlowObserved(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistTrafficFlowObserved(String var, Object val) {
		String varLower = var.toLowerCase();
			if("color".equals(varLower)) {
				if(val instanceof String) {
					setColor((String)val);
				}
				saves.add("color");
				return val;
			} else if("entityid".equals(varLower)) {
				if(val instanceof String) {
					setEntityId((String)val);
				}
				saves.add("entityId");
				return val;
			} else if("trafficsimulationid".equals(varLower)) {
				if(val instanceof String) {
					setTrafficSimulationId((String)val);
				}
				saves.add("trafficSimulationId");
				return val;
			} else if("laneareadetectorid".equals(varLower)) {
				if(val instanceof String) {
					setLaneAreaDetectorId((String)val);
				}
				saves.add("laneAreaDetectorId");
				return val;
			} else if("location".equals(varLower)) {
				if(val instanceof String) {
					setLocation((String)val);
				} else if(val instanceof Point) {
					setLocation((Point)val);
				}
				saves.add("location");
				return val;
			} else if("sumocfgpath".equals(varLower)) {
				if(val instanceof String) {
					setSumocfgPath((String)val);
				}
				saves.add("sumocfgPath");
				return val;
			} else if("customtrafficlightid".equals(varLower)) {
				if(val instanceof String) {
					setCustomTrafficLightId((String)val);
				}
				saves.add("customTrafficLightId");
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
				if(val instanceof Path) {
					setAreaServed((Path)val);
				} else {
					setAreaServed(val == null ? null : val.toString());
				}
				saves.add("areaServed");
				return val;
			} else if("averagegapdistance".equals(varLower)) {
				if(val instanceof String) {
					setAverageGapDistance((String)val);
				} else if(val instanceof Number) {
					setAverageGapDistance(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageGapDistance");
				return val;
			} else if("averageheadwaytime".equals(varLower)) {
				if(val instanceof String) {
					setAverageHeadwayTime((String)val);
				} else if(val instanceof Number) {
					setAverageHeadwayTime(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageHeadwayTime");
				return val;
			} else if("averagevehiclelength".equals(varLower)) {
				if(val instanceof String) {
					setAverageVehicleLength((String)val);
				} else if(val instanceof Number) {
					setAverageVehicleLength(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageVehicleLength");
				return val;
			} else if("averagevehiclespeed".equals(varLower)) {
				if(val instanceof String) {
					setAverageVehicleSpeed((String)val);
				} else if(val instanceof Number) {
					setAverageVehicleSpeed(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageVehicleSpeed");
				return val;
			} else if("congested".equals(varLower)) {
				if(val instanceof Boolean) {
					setCongested((Boolean)val);
				} else {
					setCongested(val == null ? null : val.toString());
				}
				saves.add("congested");
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
			} else if("intensity".equals(varLower)) {
				if(val instanceof String) {
					setIntensity((String)val);
				} else if(val instanceof Number) {
					setIntensity(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("intensity");
				return val;
			} else if("lanedirection".equals(varLower)) {
				if(val instanceof String) {
					setLaneDirection((String)val);
				}
				saves.add("laneDirection");
				return val;
			} else if("laneid".equals(varLower)) {
				if(val instanceof Integer) {
					setLaneId((Integer)val);
				} else {
					setLaneId(val == null ? null : val.toString());
				}
				saves.add("laneId");
				return val;
			} else if("name".equals(varLower)) {
				if(val instanceof String) {
					setName((String)val);
				}
				saves.add("name");
				return val;
			} else if("occupancy".equals(varLower)) {
				if(val instanceof String) {
					setOccupancy((String)val);
				} else if(val instanceof Number) {
					setOccupancy(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("occupancy");
				return val;
			} else if("owner".equals(varLower)) {
				if(val instanceof String) {
					setOwner((String)val);
				} else if(val instanceof JsonObject) {
					setOwner((JsonObject)val);
				}
				saves.add("owner");
				return val;
			} else if("refroadsegment".equals(varLower)) {
				if(val instanceof String) {
					setRefRoadSegment((String)val);
				}
				saves.add("refRoadSegment");
				return val;
			} else if("reversedlane".equals(varLower)) {
				if(val instanceof Boolean) {
					setReversedLane((Boolean)val);
				} else {
					setReversedLane(val == null ? null : val.toString());
				}
				saves.add("reversedLane");
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
			} else if("vehiclesubtype".equals(varLower)) {
				if(val instanceof String) {
					setVehicleSubType((String)val);
				}
				saves.add("vehicleSubType");
				return val;
			} else if("vehicletype".equals(varLower)) {
				if(val instanceof String) {
					setVehicleType((String)val);
				}
				saves.add("vehicleType");
				return val;
			} else if("customsigma".equals(varLower)) {
				if(val instanceof String) {
					setCustomSigma((String)val);
				} else if(val instanceof Number) {
					setCustomSigma(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customSigma");
				return val;
			} else if("customacceleration".equals(varLower)) {
				if(val instanceof String) {
					setCustomAcceleration((String)val);
				} else if(val instanceof Number) {
					setCustomAcceleration(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customAcceleration");
				return val;
			} else if("customdeceleration".equals(varLower)) {
				if(val instanceof String) {
					setCustomDeceleration((String)val);
				} else if(val instanceof Number) {
					setCustomDeceleration(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customDeceleration");
				return val;
			} else if("custommingreentime".equals(varLower)) {
				if(val instanceof String) {
					setCustomMinGreenTime((String)val);
				} else if(val instanceof Number) {
					setCustomMinGreenTime(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customMinGreenTime");
				return val;
			} else if("custommaxgreentime".equals(varLower)) {
				if(val instanceof String) {
					setCustomMaxGreenTime((String)val);
				} else if(val instanceof Number) {
					setCustomMaxGreenTime(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customMaxGreenTime");
				return val;
			} else if("customaveragevehiclesperminute".equals(varLower)) {
				if(val instanceof String) {
					setCustomAverageVehiclesPerMinute((String)val);
				} else if(val instanceof Number) {
					setCustomAverageVehiclesPerMinute(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customAverageVehiclesPerMinute");
				return val;
			} else if("customdemandscalingfactor".equals(varLower)) {
				if(val instanceof String) {
					setCustomDemandScalingFactor((String)val);
				} else if(val instanceof Number) {
					setCustomDemandScalingFactor(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customDemandScalingFactor");
				return val;
			} else if("customqueuelengththreshold".equals(varLower)) {
				if(val instanceof String) {
					setCustomQueueLengthThreshold((String)val);
				} else if(val instanceof Number) {
					setCustomQueueLengthThreshold(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("customQueueLengthThreshold");
				return val;
		} else {
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateTrafficFlowObserved(doc);
	}
	public void populateTrafficFlowObserved(SolrResponse.Doc doc) {
		TrafficFlowObserved oTrafficFlowObserved = (TrafficFlowObserved)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("color")) {
				String color = (String)doc.get("color_docvalues_string");
				if(color != null)
					oTrafficFlowObserved.setColor(color);
			}

			if(saves.contains("entityId")) {
				String entityId = (String)doc.get("entityId_docvalues_string");
				if(entityId != null)
					oTrafficFlowObserved.setEntityId(entityId);
			}

			if(saves.contains("entityShortId")) {
				String entityShortId = (String)doc.get("entityShortId_docvalues_string");
				if(entityShortId != null)
					oTrafficFlowObserved.setEntityShortId(entityShortId);
			}

			if(saves.contains("trafficSimulationId")) {
				String trafficSimulationId = (String)doc.get("trafficSimulationId_docvalues_string");
				if(trafficSimulationId != null)
					oTrafficFlowObserved.setTrafficSimulationId(trafficSimulationId);
			}

			if(saves.contains("laneAreaDetectorId")) {
				String laneAreaDetectorId = (String)doc.get("laneAreaDetectorId_docvalues_string");
				if(laneAreaDetectorId != null)
					oTrafficFlowObserved.setLaneAreaDetectorId(laneAreaDetectorId);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oTrafficFlowObserved.setLocation(location);
			}

			if(saves.contains("simulationName")) {
				String simulationName = (String)doc.get("simulationName_docvalues_string");
				if(simulationName != null)
					oTrafficFlowObserved.setSimulationName(simulationName);
			}

			if(saves.contains("sumocfgPath")) {
				String sumocfgPath = (String)doc.get("sumocfgPath_docvalues_string");
				if(sumocfgPath != null)
					oTrafficFlowObserved.setSumocfgPath(sumocfgPath);
			}

			if(saves.contains("customTrafficLightId")) {
				String customTrafficLightId = (String)doc.get("customTrafficLightId_docvalues_string");
				if(customTrafficLightId != null)
					oTrafficFlowObserved.setCustomTrafficLightId(customTrafficLightId);
			}

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oTrafficFlowObserved.setAddress(address);
			}

			if(saves.contains("alternateName")) {
				String alternateName = (String)doc.get("alternateName_docvalues_string");
				if(alternateName != null)
					oTrafficFlowObserved.setAlternateName(alternateName);
			}

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null)
					oTrafficFlowObserved.areaServedColors.addAll(areaServedColors);
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null)
					oTrafficFlowObserved.areaServedTitles.addAll(areaServedTitles);
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null)
					oTrafficFlowObserved.areaServedLinks.addAll(areaServedLinks);
			}

			if(saves.contains("areaServed")) {
				Path areaServed = (Path)doc.get("areaServed_docvalues_location");
				if(areaServed != null)
					oTrafficFlowObserved.setAreaServed(areaServed);
			}

			if(saves.contains("averageGapDistance")) {
				Double averageGapDistance = (Double)doc.get("averageGapDistance_docvalues_double");
				if(averageGapDistance != null)
					oTrafficFlowObserved.setAverageGapDistance(averageGapDistance);
			}

			if(saves.contains("averageHeadwayTime")) {
				Double averageHeadwayTime = (Double)doc.get("averageHeadwayTime_docvalues_double");
				if(averageHeadwayTime != null)
					oTrafficFlowObserved.setAverageHeadwayTime(averageHeadwayTime);
			}

			if(saves.contains("averageVehicleLength")) {
				Double averageVehicleLength = (Double)doc.get("averageVehicleLength_docvalues_double");
				if(averageVehicleLength != null)
					oTrafficFlowObserved.setAverageVehicleLength(averageVehicleLength);
			}

			if(saves.contains("averageVehicleSpeed")) {
				Double averageVehicleSpeed = (Double)doc.get("averageVehicleSpeed_docvalues_double");
				if(averageVehicleSpeed != null)
					oTrafficFlowObserved.setAverageVehicleSpeed(averageVehicleSpeed);
			}

			if(saves.contains("congested")) {
				Boolean congested = (Boolean)doc.get("congested_docvalues_boolean");
				if(congested != null)
					oTrafficFlowObserved.setCongested(congested);
			}

			if(saves.contains("dataProvider")) {
				String dataProvider = (String)doc.get("dataProvider_docvalues_string");
				if(dataProvider != null)
					oTrafficFlowObserved.setDataProvider(dataProvider);
			}

			if(saves.contains("dateCreated")) {
				String dateCreated = (String)doc.get("dateCreated_docvalues_string");
				if(dateCreated != null)
					oTrafficFlowObserved.setDateCreated(dateCreated);
			}

			if(saves.contains("dateModified")) {
				String dateModified = (String)doc.get("dateModified_docvalues_string");
				if(dateModified != null)
					oTrafficFlowObserved.setDateModified(dateModified);
			}

			if(saves.contains("dateObserved")) {
				String dateObserved = (String)doc.get("dateObserved_docvalues_string");
				if(dateObserved != null)
					oTrafficFlowObserved.setDateObserved(dateObserved);
			}

			if(saves.contains("dateObservedFrom")) {
				String dateObservedFrom = (String)doc.get("dateObservedFrom_docvalues_string");
				if(dateObservedFrom != null)
					oTrafficFlowObserved.setDateObservedFrom(dateObservedFrom);
			}

			if(saves.contains("dateObservedTo")) {
				String dateObservedTo = (String)doc.get("dateObservedTo_docvalues_string");
				if(dateObservedTo != null)
					oTrafficFlowObserved.setDateObservedTo(dateObservedTo);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oTrafficFlowObserved.setDescription(description);
			}

			if(saves.contains("intensity")) {
				Double intensity = (Double)doc.get("intensity_docvalues_double");
				if(intensity != null)
					oTrafficFlowObserved.setIntensity(intensity);
			}

			if(saves.contains("laneDirection")) {
				String laneDirection = (String)doc.get("laneDirection_docvalues_string");
				if(laneDirection != null)
					oTrafficFlowObserved.setLaneDirection(laneDirection);
			}

			if(saves.contains("laneId")) {
				Integer laneId = (Integer)doc.get("laneId_docvalues_int");
				if(laneId != null)
					oTrafficFlowObserved.setLaneId(laneId);
			}

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oTrafficFlowObserved.setName(name);
			}

			if(saves.contains("occupancy")) {
				Double occupancy = (Double)doc.get("occupancy_docvalues_double");
				if(occupancy != null)
					oTrafficFlowObserved.setOccupancy(occupancy);
			}

			if(saves.contains("owner")) {
				String owner = (String)doc.get("owner_docvalues_string");
				if(owner != null)
					oTrafficFlowObserved.setOwner(owner);
			}

			if(saves.contains("refRoadSegment")) {
				String refRoadSegment = (String)doc.get("refRoadSegment_docvalues_string");
				if(refRoadSegment != null)
					oTrafficFlowObserved.setRefRoadSegment(refRoadSegment);
			}

			if(saves.contains("reversedLane")) {
				Boolean reversedLane = (Boolean)doc.get("reversedLane_docvalues_boolean");
				if(reversedLane != null)
					oTrafficFlowObserved.setReversedLane(reversedLane);
			}

			if(saves.contains("seeAlso")) {
				String seeAlso = (String)doc.get("seeAlso_docvalues_string");
				if(seeAlso != null)
					oTrafficFlowObserved.setSeeAlso(seeAlso);
			}

			if(saves.contains("source")) {
				String source = (String)doc.get("source_docvalues_string");
				if(source != null)
					oTrafficFlowObserved.setSource(source);
			}

			if(saves.contains("vehicleSubType")) {
				String vehicleSubType = (String)doc.get("vehicleSubType_docvalues_string");
				if(vehicleSubType != null)
					oTrafficFlowObserved.setVehicleSubType(vehicleSubType);
			}

			if(saves.contains("vehicleType")) {
				String vehicleType = (String)doc.get("vehicleType_docvalues_string");
				if(vehicleType != null)
					oTrafficFlowObserved.setVehicleType(vehicleType);
			}

			if(saves.contains("customSigma")) {
				Double customSigma = (Double)doc.get("customSigma_docvalues_double");
				if(customSigma != null)
					oTrafficFlowObserved.setCustomSigma(customSigma);
			}

			if(saves.contains("customAcceleration")) {
				Double customAcceleration = (Double)doc.get("customAcceleration_docvalues_double");
				if(customAcceleration != null)
					oTrafficFlowObserved.setCustomAcceleration(customAcceleration);
			}

			if(saves.contains("customDeceleration")) {
				Double customDeceleration = (Double)doc.get("customDeceleration_docvalues_double");
				if(customDeceleration != null)
					oTrafficFlowObserved.setCustomDeceleration(customDeceleration);
			}

			if(saves.contains("customMinGreenTime")) {
				Double customMinGreenTime = (Double)doc.get("customMinGreenTime_docvalues_double");
				if(customMinGreenTime != null)
					oTrafficFlowObserved.setCustomMinGreenTime(customMinGreenTime);
			}

			if(saves.contains("customMaxGreenTime")) {
				Double customMaxGreenTime = (Double)doc.get("customMaxGreenTime_docvalues_double");
				if(customMaxGreenTime != null)
					oTrafficFlowObserved.setCustomMaxGreenTime(customMaxGreenTime);
			}

			if(saves.contains("customAverageVehiclesPerMinute")) {
				Double customAverageVehiclesPerMinute = (Double)doc.get("customAverageVehiclesPerMinute_docvalues_double");
				if(customAverageVehiclesPerMinute != null)
					oTrafficFlowObserved.setCustomAverageVehiclesPerMinute(customAverageVehiclesPerMinute);
			}

			if(saves.contains("customDemandScalingFactor")) {
				Double customDemandScalingFactor = (Double)doc.get("customDemandScalingFactor_docvalues_double");
				if(customDemandScalingFactor != null)
					oTrafficFlowObserved.setCustomDemandScalingFactor(customDemandScalingFactor);
			}

			if(saves.contains("customQueueLengthThreshold")) {
				Double customQueueLengthThreshold = (Double)doc.get("customQueueLengthThreshold_docvalues_double");
				if(customQueueLengthThreshold != null)
					oTrafficFlowObserved.setCustomQueueLengthThreshold(customQueueLengthThreshold);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexTrafficFlowObserved(JsonObject doc) {
		if(color != null) {
			doc.put("color_docvalues_string", color);
		}
		if(entityId != null) {
			doc.put("entityId_docvalues_string", entityId);
		}
		if(entityShortId != null) {
			doc.put("entityShortId_docvalues_string", entityShortId);
		}
		if(trafficSimulationId != null) {
			doc.put("trafficSimulationId_docvalues_string", trafficSimulationId);
		}
		if(laneAreaDetectorId != null) {
			doc.put("laneAreaDetectorId_docvalues_string", laneAreaDetectorId);
		}
		if(location != null) {
			doc.put("location_docvalues_location", String.format("%s,%s", location.getX(), location.getY()));
		}
		if(simulationName != null) {
			doc.put("simulationName_docvalues_string", simulationName);
		}
		if(sumocfgPath != null) {
			doc.put("sumocfgPath_docvalues_string", sumocfgPath);
		}
		if(customTrafficLightId != null) {
			doc.put("customTrafficLightId_docvalues_string", customTrafficLightId);
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
		if(averageGapDistance != null) {
			doc.put("averageGapDistance_docvalues_double", averageGapDistance.doubleValue());
		}
		if(averageHeadwayTime != null) {
			doc.put("averageHeadwayTime_docvalues_double", averageHeadwayTime.doubleValue());
		}
		if(averageVehicleLength != null) {
			doc.put("averageVehicleLength_docvalues_double", averageVehicleLength.doubleValue());
		}
		if(averageVehicleSpeed != null) {
			doc.put("averageVehicleSpeed_docvalues_double", averageVehicleSpeed.doubleValue());
		}
		if(congested != null) {
			doc.put("congested_docvalues_boolean", congested);
		}
		if(dataProvider != null) {
			doc.put("dataProvider_docvalues_string", dataProvider);
		}
		if(dateCreated != null) {
			doc.put("dateCreated_docvalues_string", dateCreated);
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
		if(intensity != null) {
			doc.put("intensity_docvalues_double", intensity.doubleValue());
		}
		if(laneDirection != null) {
			doc.put("laneDirection_docvalues_string", laneDirection);
		}
		if(laneId != null) {
			doc.put("laneId_docvalues_int", laneId);
		}
		if(name != null) {
			doc.put("name_docvalues_string", name);
		}
		if(occupancy != null) {
			doc.put("occupancy_docvalues_double", occupancy.doubleValue());
		}
		if(owner != null) {
			doc.put("owner_docvalues_string", owner.toString());
		}
		if(refRoadSegment != null) {
			doc.put("refRoadSegment_docvalues_string", refRoadSegment);
		}
		if(reversedLane != null) {
			doc.put("reversedLane_docvalues_boolean", reversedLane);
		}
		if(seeAlso != null) {
			doc.put("seeAlso_docvalues_string", seeAlso.toString());
		}
		if(source != null) {
			doc.put("source_docvalues_string", source);
		}
		if(vehicleSubType != null) {
			doc.put("vehicleSubType_docvalues_string", vehicleSubType);
		}
		if(vehicleType != null) {
			doc.put("vehicleType_docvalues_string", vehicleType);
		}
		if(customSigma != null) {
			doc.put("customSigma_docvalues_double", customSigma.doubleValue());
		}
		if(customAcceleration != null) {
			doc.put("customAcceleration_docvalues_double", customAcceleration.doubleValue());
		}
		if(customDeceleration != null) {
			doc.put("customDeceleration_docvalues_double", customDeceleration.doubleValue());
		}
		if(customMinGreenTime != null) {
			doc.put("customMinGreenTime_docvalues_double", customMinGreenTime.doubleValue());
		}
		if(customMaxGreenTime != null) {
			doc.put("customMaxGreenTime_docvalues_double", customMaxGreenTime.doubleValue());
		}
		if(customAverageVehiclesPerMinute != null) {
			doc.put("customAverageVehiclesPerMinute_docvalues_double", customAverageVehiclesPerMinute.doubleValue());
		}
		if(customDemandScalingFactor != null) {
			doc.put("customDemandScalingFactor_docvalues_double", customDemandScalingFactor.doubleValue());
		}
		if(customQueueLengthThreshold != null) {
			doc.put("customQueueLengthThreshold_docvalues_double", customQueueLengthThreshold.doubleValue());
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredTrafficFlowObserved(String entityVar) {
		switch(entityVar) {
			case "color":
				return "color_docvalues_string";
			case "entityId":
				return "entityId_docvalues_string";
			case "entityShortId":
				return "entityShortId_docvalues_string";
			case "trafficSimulationId":
				return "trafficSimulationId_docvalues_string";
			case "laneAreaDetectorId":
				return "laneAreaDetectorId_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "simulationName":
				return "simulationName_docvalues_string";
			case "sumocfgPath":
				return "sumocfgPath_docvalues_string";
			case "customTrafficLightId":
				return "customTrafficLightId_docvalues_string";
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
			case "averageGapDistance":
				return "averageGapDistance_docvalues_double";
			case "averageHeadwayTime":
				return "averageHeadwayTime_docvalues_double";
			case "averageVehicleLength":
				return "averageVehicleLength_docvalues_double";
			case "averageVehicleSpeed":
				return "averageVehicleSpeed_docvalues_double";
			case "congested":
				return "congested_docvalues_boolean";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
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
			case "intensity":
				return "intensity_docvalues_double";
			case "laneDirection":
				return "laneDirection_docvalues_string";
			case "laneId":
				return "laneId_docvalues_int";
			case "name":
				return "name_docvalues_string";
			case "occupancy":
				return "occupancy_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "refRoadSegment":
				return "refRoadSegment_docvalues_string";
			case "reversedLane":
				return "reversedLane_docvalues_boolean";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "vehicleSubType":
				return "vehicleSubType_docvalues_string";
			case "vehicleType":
				return "vehicleType_docvalues_string";
			case "customSigma":
				return "customSigma_docvalues_double";
			case "customAcceleration":
				return "customAcceleration_docvalues_double";
			case "customDeceleration":
				return "customDeceleration_docvalues_double";
			case "customMinGreenTime":
				return "customMinGreenTime_docvalues_double";
			case "customMaxGreenTime":
				return "customMaxGreenTime_docvalues_double";
			case "customAverageVehiclesPerMinute":
				return "customAverageVehiclesPerMinute_docvalues_double";
			case "customDemandScalingFactor":
				return "customDemandScalingFactor_docvalues_double";
			case "customQueueLengthThreshold":
				return "customQueueLengthThreshold_docvalues_double";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedTrafficFlowObserved(String entityVar) {
		switch(entityVar) {
			case "color":
				return "color_docvalues_string";
			case "entityId":
				return "entityId_docvalues_string";
			case "entityShortId":
				return "entityShortId_docvalues_string";
			case "trafficSimulationId":
				return "trafficSimulationId_docvalues_string";
			case "laneAreaDetectorId":
				return "laneAreaDetectorId_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "simulationName":
				return "simulationName_docvalues_string";
			case "sumocfgPath":
				return "sumocfgPath_docvalues_string";
			case "customTrafficLightId":
				return "customTrafficLightId_docvalues_string";
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
			case "averageGapDistance":
				return "averageGapDistance_docvalues_double";
			case "averageHeadwayTime":
				return "averageHeadwayTime_docvalues_double";
			case "averageVehicleLength":
				return "averageVehicleLength_docvalues_double";
			case "averageVehicleSpeed":
				return "averageVehicleSpeed_docvalues_double";
			case "congested":
				return "congested_docvalues_boolean";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
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
			case "intensity":
				return "intensity_docvalues_double";
			case "laneDirection":
				return "laneDirection_docvalues_string";
			case "laneId":
				return "laneId_docvalues_int";
			case "name":
				return "name_docvalues_string";
			case "occupancy":
				return "occupancy_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "refRoadSegment":
				return "refRoadSegment_docvalues_string";
			case "reversedLane":
				return "reversedLane_docvalues_boolean";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "vehicleSubType":
				return "vehicleSubType_docvalues_string";
			case "vehicleType":
				return "vehicleType_docvalues_string";
			case "customSigma":
				return "customSigma_docvalues_double";
			case "customAcceleration":
				return "customAcceleration_docvalues_double";
			case "customDeceleration":
				return "customDeceleration_docvalues_double";
			case "customMinGreenTime":
				return "customMinGreenTime_docvalues_double";
			case "customMaxGreenTime":
				return "customMaxGreenTime_docvalues_double";
			case "customAverageVehiclesPerMinute":
				return "customAverageVehiclesPerMinute_docvalues_double";
			case "customDemandScalingFactor":
				return "customDemandScalingFactor_docvalues_double";
			case "customQueueLengthThreshold":
				return "customQueueLengthThreshold_docvalues_double";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarTrafficFlowObserved(String searchVar) {
		switch(searchVar) {
			case "color_docvalues_string":
				return "color";
			case "entityId_docvalues_string":
				return "entityId";
			case "entityShortId_docvalues_string":
				return "entityShortId";
			case "trafficSimulationId_docvalues_string":
				return "trafficSimulationId";
			case "laneAreaDetectorId_docvalues_string":
				return "laneAreaDetectorId";
			case "location_docvalues_location":
				return "location";
			case "simulationName_docvalues_string":
				return "simulationName";
			case "sumocfgPath_docvalues_string":
				return "sumocfgPath";
			case "customTrafficLightId_docvalues_string":
				return "customTrafficLightId";
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
			case "averageGapDistance_docvalues_double":
				return "averageGapDistance";
			case "averageHeadwayTime_docvalues_double":
				return "averageHeadwayTime";
			case "averageVehicleLength_docvalues_double":
				return "averageVehicleLength";
			case "averageVehicleSpeed_docvalues_double":
				return "averageVehicleSpeed";
			case "congested_docvalues_boolean":
				return "congested";
			case "dataProvider_docvalues_string":
				return "dataProvider";
			case "dateCreated_docvalues_string":
				return "dateCreated";
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
			case "intensity_docvalues_double":
				return "intensity";
			case "laneDirection_docvalues_string":
				return "laneDirection";
			case "laneId_docvalues_int":
				return "laneId";
			case "name_docvalues_string":
				return "name";
			case "occupancy_docvalues_double":
				return "occupancy";
			case "owner_docvalues_string":
				return "owner";
			case "refRoadSegment_docvalues_string":
				return "refRoadSegment";
			case "reversedLane_docvalues_boolean":
				return "reversedLane";
			case "seeAlso_docvalues_string":
				return "seeAlso";
			case "source_docvalues_string":
				return "source";
			case "vehicleSubType_docvalues_string":
				return "vehicleSubType";
			case "vehicleType_docvalues_string":
				return "vehicleType";
			case "customSigma_docvalues_double":
				return "customSigma";
			case "customAcceleration_docvalues_double":
				return "customAcceleration";
			case "customDeceleration_docvalues_double":
				return "customDeceleration";
			case "customMinGreenTime_docvalues_double":
				return "customMinGreenTime";
			case "customMaxGreenTime_docvalues_double":
				return "customMaxGreenTime";
			case "customAverageVehiclesPerMinute_docvalues_double":
				return "customAverageVehiclesPerMinute";
			case "customDemandScalingFactor_docvalues_double":
				return "customDemandScalingFactor";
			case "customQueueLengthThreshold_docvalues_double":
				return "customQueueLengthThreshold";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchTrafficFlowObserved(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedTrafficFlowObserved(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeTrafficFlowObserved(doc);
	}
	public void storeTrafficFlowObserved(SolrResponse.Doc doc) {
		TrafficFlowObserved oTrafficFlowObserved = (TrafficFlowObserved)this;
		SiteRequestEnUS siteRequest = oTrafficFlowObserved.getSiteRequest_();

		oTrafficFlowObserved.setColor(Optional.ofNullable(doc.get("color_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setEntityId(Optional.ofNullable(doc.get("entityId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setEntityShortId(Optional.ofNullable(doc.get("entityShortId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setTrafficSimulationId(Optional.ofNullable(doc.get("trafficSimulationId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setLaneAreaDetectorId(Optional.ofNullable(doc.get("laneAreaDetectorId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setSimulationName(Optional.ofNullable(doc.get("simulationName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setSumocfgPath(Optional.ofNullable(doc.get("sumocfgPath_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomTrafficLightId(Optional.ofNullable(doc.get("customTrafficLightId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oTrafficFlowObserved.addAreaServedColors(TrafficFlowObserved.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oTrafficFlowObserved.addAreaServedTitles(TrafficFlowObserved.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oTrafficFlowObserved.addAreaServedLinks(TrafficFlowObserved.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		oTrafficFlowObserved.setAreaServed(Optional.ofNullable(doc.get("areaServed_docvalues_location")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setAverageGapDistance(Optional.ofNullable(doc.get("averageGapDistance_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setAverageHeadwayTime(Optional.ofNullable(doc.get("averageHeadwayTime_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setAverageVehicleLength(Optional.ofNullable(doc.get("averageVehicleLength_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setAverageVehicleSpeed(Optional.ofNullable(doc.get("averageVehicleSpeed_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCongested(Optional.ofNullable(doc.get("congested_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDateObserved(Optional.ofNullable(doc.get("dateObserved_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDateObservedFrom(Optional.ofNullable(doc.get("dateObservedFrom_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDateObservedTo(Optional.ofNullable(doc.get("dateObservedTo_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setIntensity(Optional.ofNullable(doc.get("intensity_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setLaneDirection(Optional.ofNullable(doc.get("laneDirection_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setLaneId(Optional.ofNullable(doc.get("laneId_docvalues_int")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setOccupancy(Optional.ofNullable(doc.get("occupancy_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setRefRoadSegment(Optional.ofNullable(doc.get("refRoadSegment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setReversedLane(Optional.ofNullable(doc.get("reversedLane_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setVehicleSubType(Optional.ofNullable(doc.get("vehicleSubType_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setVehicleType(Optional.ofNullable(doc.get("vehicleType_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomSigma(Optional.ofNullable(doc.get("customSigma_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomAcceleration(Optional.ofNullable(doc.get("customAcceleration_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomDeceleration(Optional.ofNullable(doc.get("customDeceleration_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomMinGreenTime(Optional.ofNullable(doc.get("customMinGreenTime_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomMaxGreenTime(Optional.ofNullable(doc.get("customMaxGreenTime_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomAverageVehiclesPerMinute(Optional.ofNullable(doc.get("customAverageVehiclesPerMinute_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomDemandScalingFactor(Optional.ofNullable(doc.get("customDemandScalingFactor_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficFlowObserved.setCustomQueueLengthThreshold(Optional.ofNullable(doc.get("customQueueLengthThreshold_docvalues_double")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestTrafficFlowObserved() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof TrafficFlowObserved) {
			TrafficFlowObserved original = (TrafficFlowObserved)o;
			if(!Objects.equals(color, original.getColor()))
				apiRequest.addVars("color");
			if(!Objects.equals(entityId, original.getEntityId()))
				apiRequest.addVars("entityId");
			if(!Objects.equals(entityShortId, original.getEntityShortId()))
				apiRequest.addVars("entityShortId");
			if(!Objects.equals(trafficSimulationId, original.getTrafficSimulationId()))
				apiRequest.addVars("trafficSimulationId");
			if(!Objects.equals(laneAreaDetectorId, original.getLaneAreaDetectorId()))
				apiRequest.addVars("laneAreaDetectorId");
			if(!Objects.equals(location, original.getLocation()))
				apiRequest.addVars("location");
			if(!Objects.equals(simulationName, original.getSimulationName()))
				apiRequest.addVars("simulationName");
			if(!Objects.equals(sumocfgPath, original.getSumocfgPath()))
				apiRequest.addVars("sumocfgPath");
			if(!Objects.equals(customTrafficLightId, original.getCustomTrafficLightId()))
				apiRequest.addVars("customTrafficLightId");
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
			if(!Objects.equals(averageGapDistance, original.getAverageGapDistance()) && averageGapDistance != null && original.getAverageGapDistance() != null && averageGapDistance.compareTo(original.getAverageGapDistance()) != 0)
				apiRequest.addVars("averageGapDistance");
			if(!Objects.equals(averageHeadwayTime, original.getAverageHeadwayTime()) && averageHeadwayTime != null && original.getAverageHeadwayTime() != null && averageHeadwayTime.compareTo(original.getAverageHeadwayTime()) != 0)
				apiRequest.addVars("averageHeadwayTime");
			if(!Objects.equals(averageVehicleLength, original.getAverageVehicleLength()) && averageVehicleLength != null && original.getAverageVehicleLength() != null && averageVehicleLength.compareTo(original.getAverageVehicleLength()) != 0)
				apiRequest.addVars("averageVehicleLength");
			if(!Objects.equals(averageVehicleSpeed, original.getAverageVehicleSpeed()) && averageVehicleSpeed != null && original.getAverageVehicleSpeed() != null && averageVehicleSpeed.compareTo(original.getAverageVehicleSpeed()) != 0)
				apiRequest.addVars("averageVehicleSpeed");
			if(!Objects.equals(congested, original.getCongested()))
				apiRequest.addVars("congested");
			if(!Objects.equals(dataProvider, original.getDataProvider()))
				apiRequest.addVars("dataProvider");
			if(!Objects.equals(dateCreated, original.getDateCreated()))
				apiRequest.addVars("dateCreated");
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
			if(!Objects.equals(intensity, original.getIntensity()) && intensity != null && original.getIntensity() != null && intensity.compareTo(original.getIntensity()) != 0)
				apiRequest.addVars("intensity");
			if(!Objects.equals(laneDirection, original.getLaneDirection()))
				apiRequest.addVars("laneDirection");
			if(!Objects.equals(laneId, original.getLaneId()))
				apiRequest.addVars("laneId");
			if(!Objects.equals(name, original.getName()))
				apiRequest.addVars("name");
			if(!Objects.equals(occupancy, original.getOccupancy()) && occupancy != null && original.getOccupancy() != null && occupancy.compareTo(original.getOccupancy()) != 0)
				apiRequest.addVars("occupancy");
			if(!Objects.equals(owner, original.getOwner()))
				apiRequest.addVars("owner");
			if(!Objects.equals(refRoadSegment, original.getRefRoadSegment()))
				apiRequest.addVars("refRoadSegment");
			if(!Objects.equals(reversedLane, original.getReversedLane()))
				apiRequest.addVars("reversedLane");
			if(!Objects.equals(seeAlso, original.getSeeAlso()))
				apiRequest.addVars("seeAlso");
			if(!Objects.equals(source, original.getSource()))
				apiRequest.addVars("source");
			if(!Objects.equals(vehicleSubType, original.getVehicleSubType()))
				apiRequest.addVars("vehicleSubType");
			if(!Objects.equals(vehicleType, original.getVehicleType()))
				apiRequest.addVars("vehicleType");
			if(!Objects.equals(customSigma, original.getCustomSigma()) && customSigma != null && original.getCustomSigma() != null && customSigma.compareTo(original.getCustomSigma()) != 0)
				apiRequest.addVars("customSigma");
			if(!Objects.equals(customAcceleration, original.getCustomAcceleration()) && customAcceleration != null && original.getCustomAcceleration() != null && customAcceleration.compareTo(original.getCustomAcceleration()) != 0)
				apiRequest.addVars("customAcceleration");
			if(!Objects.equals(customDeceleration, original.getCustomDeceleration()) && customDeceleration != null && original.getCustomDeceleration() != null && customDeceleration.compareTo(original.getCustomDeceleration()) != 0)
				apiRequest.addVars("customDeceleration");
			if(!Objects.equals(customMinGreenTime, original.getCustomMinGreenTime()) && customMinGreenTime != null && original.getCustomMinGreenTime() != null && customMinGreenTime.compareTo(original.getCustomMinGreenTime()) != 0)
				apiRequest.addVars("customMinGreenTime");
			if(!Objects.equals(customMaxGreenTime, original.getCustomMaxGreenTime()) && customMaxGreenTime != null && original.getCustomMaxGreenTime() != null && customMaxGreenTime.compareTo(original.getCustomMaxGreenTime()) != 0)
				apiRequest.addVars("customMaxGreenTime");
			if(!Objects.equals(customAverageVehiclesPerMinute, original.getCustomAverageVehiclesPerMinute()) && customAverageVehiclesPerMinute != null && original.getCustomAverageVehiclesPerMinute() != null && customAverageVehiclesPerMinute.compareTo(original.getCustomAverageVehiclesPerMinute()) != 0)
				apiRequest.addVars("customAverageVehiclesPerMinute");
			if(!Objects.equals(customDemandScalingFactor, original.getCustomDemandScalingFactor()) && customDemandScalingFactor != null && original.getCustomDemandScalingFactor() != null && customDemandScalingFactor.compareTo(original.getCustomDemandScalingFactor()) != 0)
				apiRequest.addVars("customDemandScalingFactor");
			if(!Objects.equals(customQueueLengthThreshold, original.getCustomQueueLengthThreshold()) && customQueueLengthThreshold != null && original.getCustomQueueLengthThreshold() != null && customQueueLengthThreshold.compareTo(original.getCustomQueueLengthThreshold()) != 0)
				apiRequest.addVars("customQueueLengthThreshold");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(color).map(v -> "color: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(entityId).map(v -> "entityId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(entityShortId).map(v -> "entityShortId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(trafficSimulationId).map(v -> "trafficSimulationId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(laneAreaDetectorId).map(v -> "laneAreaDetectorId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(simulationName).map(v -> "simulationName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(sumocfgPath).map(v -> "sumocfgPath: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(customTrafficLightId).map(v -> "customTrafficLightId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageGapDistance).map(v -> "averageGapDistance: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageHeadwayTime).map(v -> "averageHeadwayTime: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageVehicleLength).map(v -> "averageVehicleLength: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageVehicleSpeed).map(v -> "averageVehicleSpeed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(congested).map(v -> "congested: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObserved).map(v -> "dateObserved: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObservedFrom).map(v -> "dateObservedFrom: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObservedTo).map(v -> "dateObservedTo: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(intensity).map(v -> "intensity: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(laneDirection).map(v -> "laneDirection: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(laneId).map(v -> "laneId: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(name).map(v -> "name: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(occupancy).map(v -> "occupancy: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(refRoadSegment).map(v -> "refRoadSegment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(reversedLane).map(v -> "reversedLane: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(vehicleSubType).map(v -> "vehicleSubType: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(vehicleType).map(v -> "vehicleType: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(customSigma).map(v -> "customSigma: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customAcceleration).map(v -> "customAcceleration: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customDeceleration).map(v -> "customDeceleration: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customMinGreenTime).map(v -> "customMinGreenTime: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customMaxGreenTime).map(v -> "customMaxGreenTime: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customAverageVehiclesPerMinute).map(v -> "customAverageVehiclesPerMinute: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customDemandScalingFactor).map(v -> "customDemandScalingFactor: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(customQueueLengthThreshold).map(v -> "customQueueLengthThreshold: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "TrafficFlowObserved";
	public static final String CLASS_API_ADDRESS_TrafficFlowObserved = "smartabyar-smartvillage-enUS-TrafficFlowObserved";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_TrafficFlowObserved;
	}
	public static final String VAR_color = "color";
	public static final String VAR_entityId = "entityId";
	public static final String VAR_entityShortId = "entityShortId";
	public static final String VAR_trafficSimulationId = "trafficSimulationId";
	public static final String VAR_trafficSimulationSearch = "trafficSimulationSearch";
	public static final String VAR_trafficSimulation_ = "trafficSimulation_";
	public static final String VAR_laneAreaDetectorId = "laneAreaDetectorId";
	public static final String VAR_location = "location";
	public static final String VAR_simulationName = "simulationName";
	public static final String VAR_sumocfgPath = "sumocfgPath";
	public static final String VAR_customTrafficLightId = "customTrafficLightId";
	public static final String VAR_smartTrafficLightSearch = "smartTrafficLightSearch";
	public static final String VAR_smartTrafficLight_ = "smartTrafficLight_";
	public static final String VAR_address = "address";
	public static final String VAR_alternateName = "alternateName";
	public static final String VAR_areaServedColors = "areaServedColors";
	public static final String VAR_areaServedTitles = "areaServedTitles";
	public static final String VAR_areaServedLinks = "areaServedLinks";
	public static final String VAR_areaServed = "areaServed";
	public static final String VAR_averageGapDistance = "averageGapDistance";
	public static final String VAR_averageHeadwayTime = "averageHeadwayTime";
	public static final String VAR_averageVehicleLength = "averageVehicleLength";
	public static final String VAR_averageVehicleSpeed = "averageVehicleSpeed";
	public static final String VAR_congested = "congested";
	public static final String VAR_dataProvider = "dataProvider";
	public static final String VAR_dateCreated = "dateCreated";
	public static final String VAR_dateModified = "dateModified";
	public static final String VAR_dateObserved = "dateObserved";
	public static final String VAR_dateObservedFrom = "dateObservedFrom";
	public static final String VAR_dateObservedTo = "dateObservedTo";
	public static final String VAR_description = "description";
	public static final String VAR_intensity = "intensity";
	public static final String VAR_laneDirection = "laneDirection";
	public static final String VAR_laneId = "laneId";
	public static final String VAR_name = "name";
	public static final String VAR_occupancy = "occupancy";
	public static final String VAR_owner = "owner";
	public static final String VAR_refRoadSegment = "refRoadSegment";
	public static final String VAR_reversedLane = "reversedLane";
	public static final String VAR_seeAlso = "seeAlso";
	public static final String VAR_source = "source";
	public static final String VAR_vehicleSubType = "vehicleSubType";
	public static final String VAR_vehicleType = "vehicleType";
	public static final String VAR_customSigma = "customSigma";
	public static final String VAR_customAcceleration = "customAcceleration";
	public static final String VAR_customDeceleration = "customDeceleration";
	public static final String VAR_customMinGreenTime = "customMinGreenTime";
	public static final String VAR_customMaxGreenTime = "customMaxGreenTime";
	public static final String VAR_customAverageVehiclesPerMinute = "customAverageVehiclesPerMinute";
	public static final String VAR_customDemandScalingFactor = "customDemandScalingFactor";
	public static final String VAR_customQueueLengthThreshold = "customQueueLengthThreshold";

	public static List<String> varsQForClass() {
		return TrafficFlowObserved.varsQTrafficFlowObserved(new ArrayList<String>());
	}
	public static List<String> varsQTrafficFlowObserved(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return TrafficFlowObserved.varsFqTrafficFlowObserved(new ArrayList<String>());
	}
	public static List<String> varsFqTrafficFlowObserved(List<String> vars) {
		vars.add(VAR_color);
		vars.add(VAR_entityId);
		vars.add(VAR_entityShortId);
		vars.add(VAR_trafficSimulationId);
		vars.add(VAR_laneAreaDetectorId);
		vars.add(VAR_location);
		vars.add(VAR_simulationName);
		vars.add(VAR_sumocfgPath);
		vars.add(VAR_customTrafficLightId);
		vars.add(VAR_address);
		vars.add(VAR_alternateName);
		vars.add(VAR_areaServed);
		vars.add(VAR_averageGapDistance);
		vars.add(VAR_averageHeadwayTime);
		vars.add(VAR_averageVehicleLength);
		vars.add(VAR_averageVehicleSpeed);
		vars.add(VAR_congested);
		vars.add(VAR_dataProvider);
		vars.add(VAR_dateCreated);
		vars.add(VAR_dateModified);
		vars.add(VAR_dateObserved);
		vars.add(VAR_dateObservedFrom);
		vars.add(VAR_dateObservedTo);
		vars.add(VAR_description);
		vars.add(VAR_intensity);
		vars.add(VAR_laneDirection);
		vars.add(VAR_laneId);
		vars.add(VAR_name);
		vars.add(VAR_occupancy);
		vars.add(VAR_owner);
		vars.add(VAR_refRoadSegment);
		vars.add(VAR_reversedLane);
		vars.add(VAR_seeAlso);
		vars.add(VAR_source);
		vars.add(VAR_vehicleSubType);
		vars.add(VAR_vehicleType);
		vars.add(VAR_customSigma);
		vars.add(VAR_customAcceleration);
		vars.add(VAR_customDeceleration);
		vars.add(VAR_customMinGreenTime);
		vars.add(VAR_customMaxGreenTime);
		vars.add(VAR_customAverageVehiclesPerMinute);
		vars.add(VAR_customDemandScalingFactor);
		vars.add(VAR_customQueueLengthThreshold);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return TrafficFlowObserved.varsRangeTrafficFlowObserved(new ArrayList<String>());
	}
	public static List<String> varsRangeTrafficFlowObserved(List<String> vars) {
		vars.add(VAR_location);
		vars.add(VAR_address);
		vars.add(VAR_averageGapDistance);
		vars.add(VAR_averageHeadwayTime);
		vars.add(VAR_averageVehicleLength);
		vars.add(VAR_averageVehicleSpeed);
		vars.add(VAR_intensity);
		vars.add(VAR_laneId);
		vars.add(VAR_occupancy);
		vars.add(VAR_owner);
		vars.add(VAR_seeAlso);
		vars.add(VAR_customSigma);
		vars.add(VAR_customAcceleration);
		vars.add(VAR_customDeceleration);
		vars.add(VAR_customMinGreenTime);
		vars.add(VAR_customMaxGreenTime);
		vars.add(VAR_customAverageVehiclesPerMinute);
		vars.add(VAR_customDemandScalingFactor);
		vars.add(VAR_customQueueLengthThreshold);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_color = "color";
	public static final String DISPLAY_NAME_entityId = "entity ID";
	public static final String DISPLAY_NAME_entityShortId = "entity ID";
	public static final String DISPLAY_NAME_trafficSimulationId = "traffic simulation ID";
	public static final String DISPLAY_NAME_trafficSimulationSearch = "";
	public static final String DISPLAY_NAME_trafficSimulation_ = "";
	public static final String DISPLAY_NAME_laneAreaDetectorId = "lane area detector ID";
	public static final String DISPLAY_NAME_location = "map location";
	public static final String DISPLAY_NAME_simulationName = "simulation name";
	public static final String DISPLAY_NAME_sumocfgPath = "sumocfg path";
	public static final String DISPLAY_NAME_customTrafficLightId = "traffic light ID";
	public static final String DISPLAY_NAME_smartTrafficLightSearch = "";
	public static final String DISPLAY_NAME_smartTrafficLight_ = "";
	public static final String DISPLAY_NAME_address = "address";
	public static final String DISPLAY_NAME_alternateName = "alternate name";
	public static final String DISPLAY_NAME_areaServedColors = "area served colors";
	public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
	public static final String DISPLAY_NAME_areaServedLinks = "area served links";
	public static final String DISPLAY_NAME_areaServed = "area served";
	public static final String DISPLAY_NAME_averageGapDistance = "average gap distance";
	public static final String DISPLAY_NAME_averageHeadwayTime = "average headway time";
	public static final String DISPLAY_NAME_averageVehicleLength = "average vehicle length";
	public static final String DISPLAY_NAME_averageVehicleSpeed = "average vehicle speed";
	public static final String DISPLAY_NAME_congested = "congested";
	public static final String DISPLAY_NAME_dataProvider = "data provider";
	public static final String DISPLAY_NAME_dateCreated = "date created";
	public static final String DISPLAY_NAME_dateModified = "date modified";
	public static final String DISPLAY_NAME_dateObserved = "date observed";
	public static final String DISPLAY_NAME_dateObservedFrom = "date observed from";
	public static final String DISPLAY_NAME_dateObservedTo = "date observed to";
	public static final String DISPLAY_NAME_description = "description";
	public static final String DISPLAY_NAME_intensity = "intensity";
	public static final String DISPLAY_NAME_laneDirection = "lane direction";
	public static final String DISPLAY_NAME_laneId = "lane id";
	public static final String DISPLAY_NAME_name = "name";
	public static final String DISPLAY_NAME_occupancy = "occupancy";
	public static final String DISPLAY_NAME_owner = "owner";
	public static final String DISPLAY_NAME_refRoadSegment = "ref road segment";
	public static final String DISPLAY_NAME_reversedLane = "reversed lane";
	public static final String DISPLAY_NAME_seeAlso = "see also";
	public static final String DISPLAY_NAME_source = "source";
	public static final String DISPLAY_NAME_vehicleSubType = "vehicle sub type";
	public static final String DISPLAY_NAME_vehicleType = "vehicle type";
	public static final String DISPLAY_NAME_customSigma = "sigma";
	public static final String DISPLAY_NAME_customAcceleration = "acceleration";
	public static final String DISPLAY_NAME_customDeceleration = "deceleration";
	public static final String DISPLAY_NAME_customMinGreenTime = "min green time";
	public static final String DISPLAY_NAME_customMaxGreenTime = "max green time";
	public static final String DISPLAY_NAME_customAverageVehiclesPerMinute = "average vehicles/minute";
	public static final String DISPLAY_NAME_customDemandScalingFactor = "demand scaling factor";
	public static final String DISPLAY_NAME_customQueueLengthThreshold = "queue length threshold";

	public static String displayNameForClass(String var) {
		return TrafficFlowObserved.displayNameTrafficFlowObserved(var);
	}
	public static String displayNameTrafficFlowObserved(String var) {
		switch(var) {
		case VAR_color:
			return DISPLAY_NAME_color;
		case VAR_entityId:
			return DISPLAY_NAME_entityId;
		case VAR_entityShortId:
			return DISPLAY_NAME_entityShortId;
		case VAR_trafficSimulationId:
			return DISPLAY_NAME_trafficSimulationId;
		case VAR_trafficSimulationSearch:
			return DISPLAY_NAME_trafficSimulationSearch;
		case VAR_trafficSimulation_:
			return DISPLAY_NAME_trafficSimulation_;
		case VAR_laneAreaDetectorId:
			return DISPLAY_NAME_laneAreaDetectorId;
		case VAR_location:
			return DISPLAY_NAME_location;
		case VAR_simulationName:
			return DISPLAY_NAME_simulationName;
		case VAR_sumocfgPath:
			return DISPLAY_NAME_sumocfgPath;
		case VAR_customTrafficLightId:
			return DISPLAY_NAME_customTrafficLightId;
		case VAR_smartTrafficLightSearch:
			return DISPLAY_NAME_smartTrafficLightSearch;
		case VAR_smartTrafficLight_:
			return DISPLAY_NAME_smartTrafficLight_;
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
		case VAR_averageGapDistance:
			return DISPLAY_NAME_averageGapDistance;
		case VAR_averageHeadwayTime:
			return DISPLAY_NAME_averageHeadwayTime;
		case VAR_averageVehicleLength:
			return DISPLAY_NAME_averageVehicleLength;
		case VAR_averageVehicleSpeed:
			return DISPLAY_NAME_averageVehicleSpeed;
		case VAR_congested:
			return DISPLAY_NAME_congested;
		case VAR_dataProvider:
			return DISPLAY_NAME_dataProvider;
		case VAR_dateCreated:
			return DISPLAY_NAME_dateCreated;
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
		case VAR_intensity:
			return DISPLAY_NAME_intensity;
		case VAR_laneDirection:
			return DISPLAY_NAME_laneDirection;
		case VAR_laneId:
			return DISPLAY_NAME_laneId;
		case VAR_name:
			return DISPLAY_NAME_name;
		case VAR_occupancy:
			return DISPLAY_NAME_occupancy;
		case VAR_owner:
			return DISPLAY_NAME_owner;
		case VAR_refRoadSegment:
			return DISPLAY_NAME_refRoadSegment;
		case VAR_reversedLane:
			return DISPLAY_NAME_reversedLane;
		case VAR_seeAlso:
			return DISPLAY_NAME_seeAlso;
		case VAR_source:
			return DISPLAY_NAME_source;
		case VAR_vehicleSubType:
			return DISPLAY_NAME_vehicleSubType;
		case VAR_vehicleType:
			return DISPLAY_NAME_vehicleType;
		case VAR_customSigma:
			return DISPLAY_NAME_customSigma;
		case VAR_customAcceleration:
			return DISPLAY_NAME_customAcceleration;
		case VAR_customDeceleration:
			return DISPLAY_NAME_customDeceleration;
		case VAR_customMinGreenTime:
			return DISPLAY_NAME_customMinGreenTime;
		case VAR_customMaxGreenTime:
			return DISPLAY_NAME_customMaxGreenTime;
		case VAR_customAverageVehiclesPerMinute:
			return DISPLAY_NAME_customAverageVehiclesPerMinute;
		case VAR_customDemandScalingFactor:
			return DISPLAY_NAME_customDemandScalingFactor;
		case VAR_customQueueLengthThreshold:
			return DISPLAY_NAME_customQueueLengthThreshold;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionTrafficFlowObserved(String var) {
		switch(var) {
		case VAR_entityId:
			return "A unique ID for this Smart Data Model";
		case VAR_entityShortId:
			return "A short ID for this Smart Data Model";
		case VAR_trafficSimulationId:
			return "The Traffic Simulation ID";
		case VAR_laneAreaDetectorId:
			return "The unique ID of the lane area detector in SUMO. ";
		case VAR_customTrafficLightId:
			return "The Smart Traffic Light ID";
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
			return "The geographic area where a service or offered item is provided. Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon. ";
		case VAR_averageGapDistance:
			return "Average gap distance between consecutive vehicles";
		case VAR_averageHeadwayTime:
			return "Average headway time. Headway time is the time ellapsed between two consecutive vehicles";
		case VAR_averageVehicleLength:
			return "Average length of the vehicles transiting during     the observation period";
		case VAR_averageVehicleSpeed:
			return "Average speed of the vehicles transiting during the observation period";
		case VAR_congested:
			return "Flags whether there was a traffic congestion during the observation period in the referred lane. The absence of this attribute means no traffic congestion";
		case VAR_dataProvider:
			return "A sequence of characters identifying the provider of the harmonised data entity.";
		case VAR_dateCreated:
			return "Entity creation timestamp. This will usually be allocated by the storage platform.";
		case VAR_dateModified:
			return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform.";
		case VAR_dateObserved:
			return "The date and time of this observation in ISO8601 UTC format. It can be represented by an specific time instant or by an ISO8601 interval. As a workaround for the lack of support of Orion Context Broker for datetime intervals, it can be used two separate attributes: `dateObservedFrom`, `dateObservedTo`. [DateTime](https://schema.org/DateTime) or an ISO8601 interval represented as [Text](https://schema.org/Text)";
		case VAR_dateObservedFrom:
			return "Observation period start date and time. See `dateObserved`";
		case VAR_dateObservedTo:
			return "Observation period end date and time. See `dateObserved`";
		case VAR_description:
			return "A description of this item";
		case VAR_intensity:
			return "Total number of vehicles detected during this observation period";
		case VAR_laneDirection:
			return "Usual direction of travel in the lane referred by this observation. This attribute is useful when the observation is not referencing any road segment, allowing to know the direction of travel of the traffic flow observed. Enum:forward, backward'. See RoadSegment for a description of the semantics of these values.";
		case VAR_laneId:
			return "Lane identifier. Lane identification is done using the conventions defined by RoadSegment entity which are based on [OpenStreetMap](http://wiki.openstreetmap.org/wiki/Forward_%26_backward,_left_%26_right).";
		case VAR_name:
			return "The name of this item.";
		case VAR_occupancy:
			return "Fraction of the observation time where a vehicle has been occupying the observed lane";
		case VAR_owner:
			return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
		case VAR_refRoadSegment:
			return "Concerned road segment on which the observation has been made. Reference to an entity of type RoadSegment";
		case VAR_reversedLane:
			return "Flags whether traffic in the lane was reversed during the observation period. The absence of this attribute means no lane reversion";
		case VAR_seeAlso:
			return "list of uri pointing to additional resources about the item";
		case VAR_source:
			return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object.";
		case VAR_vehicleSubType:
			return "It allows to specify a sub type of `vehicleType`, eg if the `vehicleType` is set to `Lorry` the `vehicleSubType` may be `OGV1` or `OGV2` to convey more information about the exact type of vehicle.";
		case VAR_vehicleType:
			return "Type of vehicle from the point of view of its structural characteristics. Enum:'agriculturalVehicle, bicycle, bus, minibus, car, caravan, tram, tanker, carWithCaravan, carWithTrailer, lorry, moped, motorcycle, motorcycleWithSideCar, motorscooter, trailer, van, constructionOrMaintenanceVehicle, trolley, binTrolley, sweepingMachine, cleaningTrolley'";
		case VAR_customSigma:
			return "The driver imperfection as a floating point number [0,1] (0 denotes perfect driving). ";
		case VAR_customAcceleration:
			return "The acceleration ability of vehicles of this type (in m/s^2). ";
		case VAR_customDeceleration:
			return "The deceleration ability of vehicles of this type (in m/s^2). ";
		case VAR_customMinGreenTime:
			return "Min green time for the traffic light in seconds [1, 50]. ";
		case VAR_customMaxGreenTime:
			return "Max green time for the traffic light in seconds [1, 50]. ";
		case VAR_customAverageVehiclesPerMinute:
			return "Average vehicle/min [1, 30]. ";
		case VAR_customDemandScalingFactor:
			return "Demand scaling factor (multiplies all vehicle demands) [1, 2]. ";
		case VAR_customQueueLengthThreshold:
			return "Demand scaling factor (multiplies all vehicle demands) [1, 2]. ";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameTrafficFlowObserved(String var) {
		switch(var) {
		case VAR_color:
			return "String";
		case VAR_entityId:
			return "String";
		case VAR_entityShortId:
			return "String";
		case VAR_trafficSimulationId:
			return "String";
		case VAR_trafficSimulationSearch:
			return "SearchList";
		case VAR_trafficSimulation_:
			return "TrafficSimulation";
		case VAR_laneAreaDetectorId:
			return "String";
		case VAR_location:
			return "Point";
		case VAR_simulationName:
			return "String";
		case VAR_sumocfgPath:
			return "String";
		case VAR_customTrafficLightId:
			return "String";
		case VAR_smartTrafficLightSearch:
			return "SearchList";
		case VAR_smartTrafficLight_:
			return "SmartTrafficLight";
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
			return "Path";
		case VAR_averageGapDistance:
			return "BigDecimal";
		case VAR_averageHeadwayTime:
			return "BigDecimal";
		case VAR_averageVehicleLength:
			return "BigDecimal";
		case VAR_averageVehicleSpeed:
			return "BigDecimal";
		case VAR_congested:
			return "Boolean";
		case VAR_dataProvider:
			return "String";
		case VAR_dateCreated:
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
		case VAR_intensity:
			return "BigDecimal";
		case VAR_laneDirection:
			return "String";
		case VAR_laneId:
			return "Integer";
		case VAR_name:
			return "String";
		case VAR_occupancy:
			return "BigDecimal";
		case VAR_owner:
			return "JsonObject";
		case VAR_refRoadSegment:
			return "String";
		case VAR_reversedLane:
			return "Boolean";
		case VAR_seeAlso:
			return "JsonObject";
		case VAR_source:
			return "String";
		case VAR_vehicleSubType:
			return "String";
		case VAR_vehicleType:
			return "String";
		case VAR_customSigma:
			return "BigDecimal";
		case VAR_customAcceleration:
			return "BigDecimal";
		case VAR_customDeceleration:
			return "BigDecimal";
		case VAR_customMinGreenTime:
			return "BigDecimal";
		case VAR_customMaxGreenTime:
			return "BigDecimal";
		case VAR_customAverageVehiclesPerMinute:
			return "BigDecimal";
		case VAR_customDemandScalingFactor:
			return "BigDecimal";
		case VAR_customQueueLengthThreshold:
			return "BigDecimal";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmColumnTrafficFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowTrafficFlowObserved(String var) {
		switch(var) {
		case VAR_color:
			return 5;
		case VAR_entityId:
			return 3;
		case VAR_trafficSimulationId:
			return 4;
		case VAR_laneAreaDetectorId:
			return 15;
		case VAR_location:
			return 3;
		case VAR_simulationName:
			return 4;
		case VAR_customTrafficLightId:
			return 17;
		case VAR_address:
			return 5;
		case VAR_alternateName:
			return 5;
		case VAR_areaServed:
			return 6;
		case VAR_averageGapDistance:
			return 6;
		case VAR_averageHeadwayTime:
			return 6;
		case VAR_averageVehicleLength:
			return 7;
		case VAR_averageVehicleSpeed:
			return 7;
		case VAR_congested:
			return 7;
		case VAR_dataProvider:
			return 7;
		case VAR_dateCreated:
			return 8;
		case VAR_dateModified:
			return 8;
		case VAR_dateObserved:
			return 8;
		case VAR_dateObservedFrom:
			return 9;
		case VAR_dateObservedTo:
			return 9;
		case VAR_description:
			return 9;
		case VAR_intensity:
			return 10;
		case VAR_laneDirection:
			return 10;
		case VAR_laneId:
			return 11;
		case VAR_name:
			return 11;
		case VAR_occupancy:
			return 12;
		case VAR_owner:
			return 12;
		case VAR_refRoadSegment:
			return 12;
		case VAR_reversedLane:
			return 13;
		case VAR_seeAlso:
			return 13;
		case VAR_source:
			return 13;
		case VAR_vehicleSubType:
			return 14;
		case VAR_vehicleType:
			return 14;
		case VAR_customSigma:
			return 15;
		case VAR_customAcceleration:
			return 15;
		case VAR_customDeceleration:
			return 15;
		case VAR_customMinGreenTime:
			return 16;
		case VAR_customMaxGreenTime:
			return 16;
		case VAR_customAverageVehiclesPerMinute:
			return 16;
		case VAR_customDemandScalingFactor:
			return 17;
		case VAR_customQueueLengthThreshold:
			return 17;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellTrafficFlowObserved(String var) {
		switch(var) {
		case VAR_color:
			return 1;
		case VAR_entityId:
			return 1;
		case VAR_trafficSimulationId:
			return 2;
		case VAR_laneAreaDetectorId:
			return 1;
		case VAR_location:
			return 2;
		case VAR_simulationName:
			return 2;
		case VAR_customTrafficLightId:
			return 3;
		case VAR_address:
			return 3;
		case VAR_alternateName:
			return 4;
		case VAR_areaServed:
			return 1;
		case VAR_averageGapDistance:
			return 2;
		case VAR_averageHeadwayTime:
			return 3;
		case VAR_averageVehicleLength:
			return 1;
		case VAR_averageVehicleSpeed:
			return 2;
		case VAR_congested:
			return 3;
		case VAR_dataProvider:
			return 4;
		case VAR_dateCreated:
			return 1;
		case VAR_dateModified:
			return 2;
		case VAR_dateObserved:
			return 3;
		case VAR_dateObservedFrom:
			return 1;
		case VAR_dateObservedTo:
			return 2;
		case VAR_description:
			return 3;
		case VAR_intensity:
			return 2;
		case VAR_laneDirection:
			return 3;
		case VAR_laneId:
			return 1;
		case VAR_name:
			return 3;
		case VAR_occupancy:
			return 1;
		case VAR_owner:
			return 2;
		case VAR_refRoadSegment:
			return 3;
		case VAR_reversedLane:
			return 1;
		case VAR_seeAlso:
			return 2;
		case VAR_source:
			return 3;
		case VAR_vehicleSubType:
			return 2;
		case VAR_vehicleType:
			return 3;
		case VAR_customSigma:
			return 1;
		case VAR_customAcceleration:
			return 2;
		case VAR_customDeceleration:
			return 3;
		case VAR_customMinGreenTime:
			return 1;
		case VAR_customMaxGreenTime:
			return 2;
		case VAR_customAverageVehiclesPerMinute:
			return 3;
		case VAR_customDemandScalingFactor:
			return 1;
		case VAR_customQueueLengthThreshold:
			return 2;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinTrafficFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxTrafficFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxTrafficFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minTrafficFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
