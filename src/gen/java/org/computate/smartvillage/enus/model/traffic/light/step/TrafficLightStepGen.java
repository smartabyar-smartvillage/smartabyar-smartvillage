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
package org.computate.smartvillage.enus.model.traffic.light.step;

import org.computate.smartvillage.enus.request.SiteRequestEnUS;
import org.computate.smartvillage.enus.result.map.MapResult;
import org.computate.smartvillage.enus.model.base.BaseModel;
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
import java.math.BigDecimal;
import java.lang.Long;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;
import io.vertx.core.json.JsonObject;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class TrafficLightStepGen into the class TrafficLightStep. 
 * </li><li>You can add a class comment "Model: true" if you wish to persist these TrafficLightStep objects in a relational PostgreSQL database transactionally in the RESTful API. 
 * The code to persist and query the TrafficLightStepGen data in the database will then be automatically generated. 
 * </li>
 * <h3>About the TrafficLightStep class and it's generated class TrafficLightStepGen&lt;MapResult&gt;: </h3>extends TrafficLightStepGen
 * <p>
 * This Java class extends a generated Java class TrafficLightStepGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep">Find the class TrafficLightStep in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends TrafficLightStepGen<MapResult>
 * <p>This <code>class TrafficLightStep extends TrafficLightStepGen&lt;MapResult&gt;</code>, which means it extends a newly generated TrafficLightStepGen. 
 * The generated <code>class TrafficLightStepGen extends MapResult</code> which means that TrafficLightStep extends TrafficLightStepGen which extends MapResult. 
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
 * <p>This class contains a comment <b>"ApiTag: Traffic Light"</b>, which groups all of the OpenAPIs for TrafficLightStep objects under the tag "Traffic Light". 
 * </p>
 * <h2>ApiUri.enUS: /api/traffic-light-step</h2>
 * <p>This class contains a comment <b>"ApiUri: /api/traffic-light-step"</b>, which defines the base API URI for TrafficLightStep objects as "/api/traffic-light-step" in the OpenAPI spec. 
 * </p>
 * <h2>Color: 2017-shaded-spruce</h2>
 * <p>This class contains a comment <b>"Color: 2017-shaded-spruce"</b>, which styles the TrafficLightStep page "2017-shaded-spruce". 
 * This will reference a CSS class defined by the stylesheets in the project that starts with "w3-". 
 * A css class of "w3-2017-shaded-spruce" is expected to exist in the project stylesheets, and is inspired by W3 CSS colors. 
 * See: <a href="https://www.w3schools.com/w3css/w3css_colors.asp">https://www.w3schools.com/w3css/w3css_colors.asp</a>. 
 * </p>
 * <h2>IconGroup: duotone</h2>
 * <p>This class contains a comment <b>"IconGroup: duotone"</b>, which adds icons on the TrafficLightStep page with a group of "duotone". 
 * This will reference a Font Awesome icon group that starts with "fa-" followed by the icon group "duotone", together is "fa-duotone". 
 * A Font Awesome icon group of "duotone" is expected to exist. 
 * The Font Awesome groups currently supported include: solid, regular, light, thin, duotone, sharp, and kit. 
 * See: <a href="https://fontawesome.com/docs/web/dig-deeper/styles">https://fontawesome.com/docs/web/dig-deeper/styles</a>. 
 * </p>
 * <h2>IconName: map-location-dot</h2>
 * <p>This class contains a comment <b>"IconName: map-location-dot"</b>, which adds icons on the TrafficLightStep page with a name of "map-location-dot". 
 * This will reference a Font Awesome icon that starts with the icon group "fa-duotone fa-" followed by the icon name, which is "fa-duotone fa-map-location-dot". 
 * A Font Awesome icon of "fa-duotone fa-map-location-dot" is expected to exist. 
 * See: <a href="https://fontawesome.com/icons">https://fontawesome.com/icons</a>. 
 * </p>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the TrafficLightStep class will inherit the helpful inherited class comments from the super class TrafficLightStepGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the TrafficLightStep API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 10</h2>
 * <p>This class contains a comment <b>"Order: 10"</b>, which means this class will be sorted by the given number 10 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStepPage. 
 * </p>
 * <h2>SuperPage.enUS: MapResultPage</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: MapResultPage"</b>, which identifies the Java super class of the page code by it's class simple name "MapResultPage". 
 * This means that the newly created class org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStepPage extends org.computate.smartvillage.enus.result.map.MapResultPage. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the TrafficLightStep Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * This class contains a comment <b>"Role.enUS: SiteAdmin"</b>, which identifies the default role name "SiteAdmin" of the OAuth2/OpenID Connect user role required to access this TrafficLightStep API. 
 * It's possible to reconfigure the roles required to access the TrafficLightStep API by configuring an environment variable like this: 
 * </p>
 * <pre>AUTH_ROLE_REQUIRED_TrafficLightStep: ["SiteAdmin"]</pre>
 * <h2>AName.enUS: a traffic light step</h2>
 * <p>This class contains a comment <b>"AName.enUS: a traffic light step"</b>, which identifies the language context to describe a TrafficLightStep as "a traffic light step". 
 * </p>
 * <p>
 * Delete the class TrafficLightStep in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.traffic.light.step in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class TrafficLightStepGen<DEV> extends MapResult {
	protected static final Logger LOG = LoggerFactory.getLogger(TrafficLightStep.class);

	public static final String TrafficLightStep_AName_enUS = "a traffic light step";
	public static final String TrafficLightStep_This_enUS = "this ";
	public static final String TrafficLightStep_ThisName_enUS = "this traffic light step";
	public static final String TrafficLightStep_A_enUS = "a ";
	public static final String TrafficLightStep_TheName_enUS = "the traffic light step";
	public static final String TrafficLightStep_NameSingular_enUS = "traffic light step";
	public static final String TrafficLightStep_NamePlural_enUS = "traffic light steps";
	public static final String TrafficLightStep_NameActual_enUS = "current traffic light step";
	public static final String TrafficLightStep_AllName_enUS = "all the traffic light steps";
	public static final String TrafficLightStep_SearchAllNameBy_enUS = "search traffic light steps by ";
	public static final String TrafficLightStep_Title_enUS = "traffic light steps";
	public static final String TrafficLightStep_ThePluralName_enUS = "the traffic light steps";
	public static final String TrafficLightStep_NoNameFound_enUS = "no traffic light step found";
	public static final String TrafficLightStep_ApiUri_enUS = "/api/traffic-light-step";
	public static final String TrafficLightStep_ApiUriSearchPage_enUS = "/traffic-light-step";
	public static final String TrafficLightStep_OfName_enUS = "of traffic light step";
	public static final String TrafficLightStep_ANameAdjective_enUS = "a traffic light step";
	public static final String TrafficLightStep_NameAdjectiveSingular_enUS = "traffic light step";
	public static final String TrafficLightStep_NameAdjectivePlural_enUS = "traffic light steps";
	public static final String Search_enUS_Uri = "/api/traffic-light-step";
	public static final String Search_enUS_ImageUri = "/png/api/traffic-light-step-999.png";
	public static final String GET_enUS_Uri = "/api/traffic-light-step/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/traffic-light-step/{id}-999.png";
	public static final String PATCH_enUS_Uri = "/api/traffic-light-step";
	public static final String PATCH_enUS_ImageUri = "/png/api/traffic-light-step-999.png";
	public static final String POST_enUS_Uri = "/api/traffic-light-step";
	public static final String POST_enUS_ImageUri = "/png/api/traffic-light-step-999.png";
	public static final String PUTImport_enUS_Uri = "/api/traffic-light-step-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/traffic-light-step-import-999.png";
	public static final String SearchPage_enUS_Uri = "/traffic-light-step";
	public static final String SearchPage_enUS_ImageUri = "/png/traffic-light-step-999.png";

	public static final String TrafficLightStep_Color = "2017-shaded-spruce";
	public static final String TrafficLightStep_IconGroup = "duotone";
	public static final String TrafficLightStep_IconName = "map-location-dot";
	public static final Integer TrafficLightStep_Rows = 100;

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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:simulationName">Find the entity simulationName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _simulationName(Wrap<String> w);

	public String getSimulationName() {
		return simulationName;
	}
	public void setSimulationName(String o) {
		this.simulationName = TrafficLightStep.staticSetSimulationName(siteRequest_, o);
	}
	public static String staticSetSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficLightStep simulationNameInit() {
		Wrap<String> simulationNameWrap = new Wrap<String>().var("simulationName");
		if(simulationName == null) {
			_simulationName(simulationNameWrap);
			Optional.ofNullable(simulationNameWrap.getO()).ifPresent(o -> {
				setSimulationName(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static String staticSearchSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchSimulationName(siteRequest_, TrafficLightStep.staticSetSimulationName(siteRequest_, o)).toString();
	}

	public String sqlSimulationName() {
		return simulationName;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:sumocfgPath">Find the entity sumocfgPath in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sumocfgPath(Wrap<String> w);

	public String getSumocfgPath() {
		return sumocfgPath;
	}
	public void setSumocfgPath(String o) {
		this.sumocfgPath = TrafficLightStep.staticSetSumocfgPath(siteRequest_, o);
	}
	public static String staticSetSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficLightStep sumocfgPathInit() {
		Wrap<String> sumocfgPathWrap = new Wrap<String>().var("sumocfgPath");
		if(sumocfgPath == null) {
			_sumocfgPath(sumocfgPathWrap);
			Optional.ofNullable(sumocfgPathWrap.getO()).ifPresent(o -> {
				setSumocfgPath(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static String staticSearchSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSumocfgPath(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchSumocfgPath(siteRequest_, TrafficLightStep.staticSetSumocfgPath(siteRequest_, o)).toString();
	}

	public String sqlSumocfgPath() {
		return sumocfgPath;
	}

	////////////////////
	// trafficLightId //
	////////////////////


	/**	 The entity trafficLightId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String trafficLightId;

	/**	<br> The entity trafficLightId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:trafficLightId">Find the entity trafficLightId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _trafficLightId(Wrap<String> w);

	public String getTrafficLightId() {
		return trafficLightId;
	}
	public void setTrafficLightId(String o) {
		this.trafficLightId = TrafficLightStep.staticSetTrafficLightId(siteRequest_, o);
	}
	public static String staticSetTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficLightStep trafficLightIdInit() {
		Wrap<String> trafficLightIdWrap = new Wrap<String>().var("trafficLightId");
		if(trafficLightId == null) {
			_trafficLightId(trafficLightIdWrap);
			Optional.ofNullable(trafficLightIdWrap.getO()).ifPresent(o -> {
				setTrafficLightId(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static String staticSearchTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchTrafficLightId(siteRequest_, TrafficLightStep.staticSetTrafficLightId(siteRequest_, o)).toString();
	}

	public String sqlTrafficLightId() {
		return trafficLightId;
	}

	//////////////////////
	// trafficLightType //
	//////////////////////


	/**	 The entity trafficLightType
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String trafficLightType;

	/**	<br> The entity trafficLightType
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:trafficLightType">Find the entity trafficLightType in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _trafficLightType(Wrap<String> w);

	public String getTrafficLightType() {
		return trafficLightType;
	}
	public void setTrafficLightType(String o) {
		this.trafficLightType = TrafficLightStep.staticSetTrafficLightType(siteRequest_, o);
	}
	public static String staticSetTrafficLightType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficLightStep trafficLightTypeInit() {
		Wrap<String> trafficLightTypeWrap = new Wrap<String>().var("trafficLightType");
		if(trafficLightType == null) {
			_trafficLightType(trafficLightTypeWrap);
			Optional.ofNullable(trafficLightTypeWrap.getO()).ifPresent(o -> {
				setTrafficLightType(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static String staticSearchTrafficLightType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTrafficLightType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTrafficLightType(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchTrafficLightType(siteRequest_, TrafficLightStep.staticSetTrafficLightType(siteRequest_, o)).toString();
	}

	public String sqlTrafficLightType() {
		return trafficLightType;
	}

	///////////
	// angle //
	///////////


	/**	 The entity angle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal angle;

	/**	<br> The entity angle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:angle">Find the entity angle in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _angle(Wrap<BigDecimal> w);

	public BigDecimal getAngle() {
		return angle;
	}

	public void setAngle(BigDecimal angle) {
		this.angle = angle;
	}
	@JsonIgnore
	public void setAngle(String o) {
		this.angle = TrafficLightStep.staticSetAngle(siteRequest_, o);
	}
	public static BigDecimal staticSetAngle(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAngle(Double o) {
		setAngle(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAngle(Integer o) {
		setAngle(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAngle(Number o) {
		setAngle(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficLightStep angleInit() {
		Wrap<BigDecimal> angleWrap = new Wrap<BigDecimal>().var("angle");
		if(angle == null) {
			_angle(angleWrap);
			Optional.ofNullable(angleWrap.getO()).ifPresent(o -> {
				setAngle(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static Double staticSearchAngle(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAngle(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAngle(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchAngle(siteRequest_, TrafficLightStep.staticSetAngle(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAngle() {
		return angle;
	}

	///////////
	// state //
	///////////


	/**	 The entity state
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String state;

	/**	<br> The entity state
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:state">Find the entity state in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _state(Wrap<String> w);

	public String getState() {
		return state;
	}
	public void setState(String o) {
		this.state = TrafficLightStep.staticSetState(siteRequest_, o);
	}
	public static String staticSetState(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficLightStep stateInit() {
		Wrap<String> stateWrap = new Wrap<String>().var("state");
		if(state == null) {
			_state(stateWrap);
			Optional.ofNullable(stateWrap.getO()).ifPresent(o -> {
				setState(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static String staticSearchState(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrState(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqState(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchState(siteRequest_, TrafficLightStep.staticSetState(siteRequest_, o)).toString();
	}

	public String sqlState() {
		return state;
	}

	///////////////
	// programId //
	///////////////


	/**	 The entity programId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long programId;

	/**	<br> The entity programId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:programId">Find the entity programId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _programId(Wrap<Long> w);

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	@JsonIgnore
	public void setProgramId(String o) {
		this.programId = TrafficLightStep.staticSetProgramId(siteRequest_, o);
	}
	public static Long staticSetProgramId(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected TrafficLightStep programIdInit() {
		Wrap<Long> programIdWrap = new Wrap<Long>().var("programId");
		if(programId == null) {
			_programId(programIdWrap);
			Optional.ofNullable(programIdWrap.getO()).ifPresent(o -> {
				setProgramId(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static Long staticSearchProgramId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrProgramId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqProgramId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchProgramId(siteRequest_, TrafficLightStep.staticSetProgramId(siteRequest_, o)).toString();
	}

	public Long sqlProgramId() {
		return programId;
	}

	///////////
	// phase //
	///////////


	/**	 The entity phase
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long phase;

	/**	<br> The entity phase
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.light.step.TrafficLightStep&fq=entiteVar_enUS_indexed_string:phase">Find the entity phase in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _phase(Wrap<Long> w);

	public Long getPhase() {
		return phase;
	}

	public void setPhase(Long phase) {
		this.phase = phase;
	}
	@JsonIgnore
	public void setPhase(String o) {
		this.phase = TrafficLightStep.staticSetPhase(siteRequest_, o);
	}
	public static Long staticSetPhase(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected TrafficLightStep phaseInit() {
		Wrap<Long> phaseWrap = new Wrap<Long>().var("phase");
		if(phase == null) {
			_phase(phaseWrap);
			Optional.ofNullable(phaseWrap.getO()).ifPresent(o -> {
				setPhase(o);
			});
		}
		return (TrafficLightStep)this;
	}

	public static Long staticSearchPhase(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPhase(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPhase(SiteRequestEnUS siteRequest_, String o) {
		return TrafficLightStep.staticSearchPhase(siteRequest_, TrafficLightStep.staticSetPhase(siteRequest_, o)).toString();
	}

	public Long sqlPhase() {
		return phase;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepTrafficLightStep(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepTrafficLightStep();
	}

	public Future<Void> promiseDeepTrafficLightStep() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseTrafficLightStep(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepMapResult(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseTrafficLightStep(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				simulationNameInit();
				sumocfgPathInit();
				trafficLightIdInit();
				trafficLightTypeInit();
				angleInit();
				stateInit();
				programIdInit();
				phaseInit();
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
		return promiseDeepTrafficLightStep(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestTrafficLightStep(SiteRequestEnUS siteRequest_) {
			super.siteRequestMapResult(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestTrafficLightStep(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTrafficLightStep(v);
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
	public Object obtainTrafficLightStep(String var) {
		TrafficLightStep oTrafficLightStep = (TrafficLightStep)this;
		switch(var) {
			case "simulationName":
				return oTrafficLightStep.simulationName;
			case "sumocfgPath":
				return oTrafficLightStep.sumocfgPath;
			case "trafficLightId":
				return oTrafficLightStep.trafficLightId;
			case "trafficLightType":
				return oTrafficLightStep.trafficLightType;
			case "angle":
				return oTrafficLightStep.angle;
			case "state":
				return oTrafficLightStep.state;
			case "programId":
				return oTrafficLightStep.programId;
			case "phase":
				return oTrafficLightStep.phase;
			default:
				return super.obtainMapResult(var);
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
				o = relateTrafficLightStep(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateTrafficLightStep(String var, Object val) {
		TrafficLightStep oTrafficLightStep = (TrafficLightStep)this;
		switch(var) {
			default:
				return super.relateMapResult(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetTrafficLightStep(entityVar,  siteRequest_, o);
	}
	public static Object staticSetTrafficLightStep(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "simulationName":
			return TrafficLightStep.staticSetSimulationName(siteRequest_, o);
		case "sumocfgPath":
			return TrafficLightStep.staticSetSumocfgPath(siteRequest_, o);
		case "trafficLightId":
			return TrafficLightStep.staticSetTrafficLightId(siteRequest_, o);
		case "trafficLightType":
			return TrafficLightStep.staticSetTrafficLightType(siteRequest_, o);
		case "angle":
			return TrafficLightStep.staticSetAngle(siteRequest_, o);
		case "state":
			return TrafficLightStep.staticSetState(siteRequest_, o);
		case "programId":
			return TrafficLightStep.staticSetProgramId(siteRequest_, o);
		case "phase":
			return TrafficLightStep.staticSetPhase(siteRequest_, o);
			default:
				return MapResult.staticSetMapResult(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchTrafficLightStep(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchTrafficLightStep(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "simulationName":
			return TrafficLightStep.staticSearchSimulationName(siteRequest_, (String)o);
		case "sumocfgPath":
			return TrafficLightStep.staticSearchSumocfgPath(siteRequest_, (String)o);
		case "trafficLightId":
			return TrafficLightStep.staticSearchTrafficLightId(siteRequest_, (String)o);
		case "trafficLightType":
			return TrafficLightStep.staticSearchTrafficLightType(siteRequest_, (String)o);
		case "angle":
			return TrafficLightStep.staticSearchAngle(siteRequest_, (BigDecimal)o);
		case "state":
			return TrafficLightStep.staticSearchState(siteRequest_, (String)o);
		case "programId":
			return TrafficLightStep.staticSearchProgramId(siteRequest_, (Long)o);
		case "phase":
			return TrafficLightStep.staticSearchPhase(siteRequest_, (Long)o);
			default:
				return MapResult.staticSearchMapResult(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrTrafficLightStep(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrTrafficLightStep(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "simulationName":
			return TrafficLightStep.staticSearchStrSimulationName(siteRequest_, (String)o);
		case "sumocfgPath":
			return TrafficLightStep.staticSearchStrSumocfgPath(siteRequest_, (String)o);
		case "trafficLightId":
			return TrafficLightStep.staticSearchStrTrafficLightId(siteRequest_, (String)o);
		case "trafficLightType":
			return TrafficLightStep.staticSearchStrTrafficLightType(siteRequest_, (String)o);
		case "angle":
			return TrafficLightStep.staticSearchStrAngle(siteRequest_, (Double)o);
		case "state":
			return TrafficLightStep.staticSearchStrState(siteRequest_, (String)o);
		case "programId":
			return TrafficLightStep.staticSearchStrProgramId(siteRequest_, (Long)o);
		case "phase":
			return TrafficLightStep.staticSearchStrPhase(siteRequest_, (Long)o);
			default:
				return MapResult.staticSearchStrMapResult(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqTrafficLightStep(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqTrafficLightStep(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "simulationName":
			return TrafficLightStep.staticSearchFqSimulationName(siteRequest_, o);
		case "sumocfgPath":
			return TrafficLightStep.staticSearchFqSumocfgPath(siteRequest_, o);
		case "trafficLightId":
			return TrafficLightStep.staticSearchFqTrafficLightId(siteRequest_, o);
		case "trafficLightType":
			return TrafficLightStep.staticSearchFqTrafficLightType(siteRequest_, o);
		case "angle":
			return TrafficLightStep.staticSearchFqAngle(siteRequest_, o);
		case "state":
			return TrafficLightStep.staticSearchFqState(siteRequest_, o);
		case "programId":
			return TrafficLightStep.staticSearchFqProgramId(siteRequest_, o);
		case "phase":
			return TrafficLightStep.staticSearchFqPhase(siteRequest_, o);
			default:
				return MapResult.staticSearchFqMapResult(entityVar,  siteRequest_, o);
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
					o = persistTrafficLightStep(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistTrafficLightStep(String var, Object val) {
		String varLower = var.toLowerCase();
			if("simulationname".equals(varLower)) {
				if(val instanceof String) {
					setSimulationName((String)val);
				}
				saves.add("simulationName");
				return val;
			} else if("sumocfgpath".equals(varLower)) {
				if(val instanceof String) {
					setSumocfgPath((String)val);
				}
				saves.add("sumocfgPath");
				return val;
			} else if("trafficlightid".equals(varLower)) {
				if(val instanceof String) {
					setTrafficLightId((String)val);
				}
				saves.add("trafficLightId");
				return val;
			} else if("trafficlighttype".equals(varLower)) {
				if(val instanceof String) {
					setTrafficLightType((String)val);
				}
				saves.add("trafficLightType");
				return val;
			} else if("angle".equals(varLower)) {
				if(val instanceof String) {
					setAngle((String)val);
				} else if(val instanceof Number) {
					setAngle(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("angle");
				return val;
			} else if("state".equals(varLower)) {
				if(val instanceof String) {
					setState((String)val);
				}
				saves.add("state");
				return val;
			} else if("programid".equals(varLower)) {
				if(val instanceof Long) {
					setProgramId((Long)val);
				} else {
					setProgramId(val == null ? null : val.toString());
				}
				saves.add("programId");
				return val;
			} else if("phase".equals(varLower)) {
				if(val instanceof Long) {
					setPhase((Long)val);
				} else {
					setPhase(val == null ? null : val.toString());
				}
				saves.add("phase");
				return val;
		} else {
			return super.persistMapResult(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateTrafficLightStep(doc);
	}
	public void populateTrafficLightStep(SolrResponse.Doc doc) {
		TrafficLightStep oTrafficLightStep = (TrafficLightStep)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("simulationName")) {
				String simulationName = (String)doc.get("simulationName_docvalues_string");
				if(simulationName != null)
					oTrafficLightStep.setSimulationName(simulationName);
			}

			if(saves.contains("sumocfgPath")) {
				String sumocfgPath = (String)doc.get("sumocfgPath_docvalues_string");
				if(sumocfgPath != null)
					oTrafficLightStep.setSumocfgPath(sumocfgPath);
			}

			if(saves.contains("trafficLightId")) {
				String trafficLightId = (String)doc.get("trafficLightId_docvalues_string");
				if(trafficLightId != null)
					oTrafficLightStep.setTrafficLightId(trafficLightId);
			}

			if(saves.contains("trafficLightType")) {
				String trafficLightType = (String)doc.get("trafficLightType_docvalues_string");
				if(trafficLightType != null)
					oTrafficLightStep.setTrafficLightType(trafficLightType);
			}

			if(saves.contains("angle")) {
				Double angle = (Double)doc.get("angle_docvalues_double");
				if(angle != null)
					oTrafficLightStep.setAngle(angle);
			}

			if(saves.contains("state")) {
				String state = (String)doc.get("state_docvalues_string");
				if(state != null)
					oTrafficLightStep.setState(state);
			}

			if(saves.contains("programId")) {
				Long programId = (Long)doc.get("programId_docvalues_long");
				if(programId != null)
					oTrafficLightStep.setProgramId(programId);
			}

			if(saves.contains("phase")) {
				Long phase = (Long)doc.get("phase_docvalues_long");
				if(phase != null)
					oTrafficLightStep.setPhase(phase);
			}
		}

		super.populateMapResult(doc);
	}

	public void indexTrafficLightStep(JsonObject doc) {
		if(simulationName != null) {
			doc.put("simulationName_docvalues_string", simulationName);
		}
		if(sumocfgPath != null) {
			doc.put("sumocfgPath_docvalues_string", sumocfgPath);
		}
		if(trafficLightId != null) {
			doc.put("trafficLightId_docvalues_string", trafficLightId);
		}
		if(trafficLightType != null) {
			doc.put("trafficLightType_docvalues_string", trafficLightType);
		}
		if(angle != null) {
			doc.put("angle_docvalues_double", angle.doubleValue());
		}
		if(state != null) {
			doc.put("state_docvalues_string", state);
		}
		if(programId != null) {
			doc.put("programId_docvalues_long", programId);
		}
		if(phase != null) {
			doc.put("phase_docvalues_long", phase);
		}
		super.indexMapResult(doc);

	}

	public static String varStoredTrafficLightStep(String entityVar) {
		switch(entityVar) {
			case "simulationName":
				return "simulationName_docvalues_string";
			case "sumocfgPath":
				return "sumocfgPath_docvalues_string";
			case "trafficLightId":
				return "trafficLightId_docvalues_string";
			case "trafficLightType":
				return "trafficLightType_docvalues_string";
			case "angle":
				return "angle_docvalues_double";
			case "state":
				return "state_docvalues_string";
			case "programId":
				return "programId_docvalues_long";
			case "phase":
				return "phase_docvalues_long";
			default:
				return MapResult.varStoredMapResult(entityVar);
		}
	}

	public static String varIndexedTrafficLightStep(String entityVar) {
		switch(entityVar) {
			case "simulationName":
				return "simulationName_docvalues_string";
			case "sumocfgPath":
				return "sumocfgPath_docvalues_string";
			case "trafficLightId":
				return "trafficLightId_docvalues_string";
			case "trafficLightType":
				return "trafficLightType_docvalues_string";
			case "angle":
				return "angle_docvalues_double";
			case "state":
				return "state_docvalues_string";
			case "programId":
				return "programId_docvalues_long";
			case "phase":
				return "phase_docvalues_long";
			default:
				return MapResult.varIndexedMapResult(entityVar);
		}
	}

	public static String searchVarTrafficLightStep(String searchVar) {
		switch(searchVar) {
			case "simulationName_docvalues_string":
				return "simulationName";
			case "sumocfgPath_docvalues_string":
				return "sumocfgPath";
			case "trafficLightId_docvalues_string":
				return "trafficLightId";
			case "trafficLightType_docvalues_string":
				return "trafficLightType";
			case "angle_docvalues_double":
				return "angle";
			case "state_docvalues_string":
				return "state";
			case "programId_docvalues_long":
				return "programId";
			case "phase_docvalues_long":
				return "phase";
			default:
				return MapResult.searchVarMapResult(searchVar);
		}
	}

	public static String varSearchTrafficLightStep(String entityVar) {
		switch(entityVar) {
			default:
				return MapResult.varSearchMapResult(entityVar);
		}
	}

	public static String varSuggestedTrafficLightStep(String entityVar) {
		switch(entityVar) {
			default:
				return MapResult.varSuggestedMapResult(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeTrafficLightStep(doc);
	}
	public void storeTrafficLightStep(SolrResponse.Doc doc) {
		TrafficLightStep oTrafficLightStep = (TrafficLightStep)this;
		SiteRequestEnUS siteRequest = oTrafficLightStep.getSiteRequest_();

		oTrafficLightStep.setSimulationName(Optional.ofNullable(doc.get("simulationName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setSumocfgPath(Optional.ofNullable(doc.get("sumocfgPath_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setTrafficLightId(Optional.ofNullable(doc.get("trafficLightId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setTrafficLightType(Optional.ofNullable(doc.get("trafficLightType_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setAngle(Optional.ofNullable(doc.get("angle_docvalues_double")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setState(Optional.ofNullable(doc.get("state_docvalues_string")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setProgramId(Optional.ofNullable(doc.get("programId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oTrafficLightStep.setPhase(Optional.ofNullable(doc.get("phase_docvalues_long")).map(v -> v.toString()).orElse(null));

		super.storeMapResult(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestTrafficLightStep() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof TrafficLightStep) {
			TrafficLightStep original = (TrafficLightStep)o;
			if(!Objects.equals(simulationName, original.getSimulationName()))
				apiRequest.addVars("simulationName");
			if(!Objects.equals(sumocfgPath, original.getSumocfgPath()))
				apiRequest.addVars("sumocfgPath");
			if(!Objects.equals(trafficLightId, original.getTrafficLightId()))
				apiRequest.addVars("trafficLightId");
			if(!Objects.equals(trafficLightType, original.getTrafficLightType()))
				apiRequest.addVars("trafficLightType");
			if(!Objects.equals(angle, original.getAngle()) && angle != null && original.getAngle() != null && angle.compareTo(original.getAngle()) != 0)
				apiRequest.addVars("angle");
			if(!Objects.equals(state, original.getState()))
				apiRequest.addVars("state");
			if(!Objects.equals(programId, original.getProgramId()))
				apiRequest.addVars("programId");
			if(!Objects.equals(phase, original.getPhase()))
				apiRequest.addVars("phase");
			super.apiRequestMapResult();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(simulationName).map(v -> "simulationName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(sumocfgPath).map(v -> "sumocfgPath: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(trafficLightId).map(v -> "trafficLightId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(trafficLightType).map(v -> "trafficLightType: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(angle).map(v -> "angle: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(state).map(v -> "state: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(programId).map(v -> "programId: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(phase).map(v -> "phase: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "TrafficLightStep";
	public static final String CLASS_API_ADDRESS_TrafficLightStep = "smartabyar-smartvillage-enUS-TrafficLightStep";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_TrafficLightStep;
	}
	public static final String VAR_simulationName = "simulationName";
	public static final String VAR_sumocfgPath = "sumocfgPath";
	public static final String VAR_trafficLightId = "trafficLightId";
	public static final String VAR_trafficLightType = "trafficLightType";
	public static final String VAR_angle = "angle";
	public static final String VAR_state = "state";
	public static final String VAR_programId = "programId";
	public static final String VAR_phase = "phase";

	public static List<String> varsQForClass() {
		return TrafficLightStep.varsQTrafficLightStep(new ArrayList<String>());
	}
	public static List<String> varsQTrafficLightStep(List<String> vars) {
		MapResult.varsQMapResult(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return TrafficLightStep.varsFqTrafficLightStep(new ArrayList<String>());
	}
	public static List<String> varsFqTrafficLightStep(List<String> vars) {
		vars.add(VAR_simulationName);
		vars.add(VAR_sumocfgPath);
		vars.add(VAR_trafficLightId);
		vars.add(VAR_trafficLightType);
		vars.add(VAR_angle);
		vars.add(VAR_state);
		vars.add(VAR_programId);
		vars.add(VAR_phase);
		MapResult.varsFqMapResult(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return TrafficLightStep.varsRangeTrafficLightStep(new ArrayList<String>());
	}
	public static List<String> varsRangeTrafficLightStep(List<String> vars) {
		vars.add(VAR_angle);
		vars.add(VAR_programId);
		vars.add(VAR_phase);
		MapResult.varsRangeMapResult(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_simulationName = "simulation name";
	public static final String DISPLAY_NAME_sumocfgPath = "sumocfg path";
	public static final String DISPLAY_NAME_trafficLightId = "traffic light ID";
	public static final String DISPLAY_NAME_trafficLightType = "traffic light type";
	public static final String DISPLAY_NAME_angle = "Angle in degrees";
	public static final String DISPLAY_NAME_state = "state";
	public static final String DISPLAY_NAME_programId = "program ID";
	public static final String DISPLAY_NAME_phase = "phase";

	public static String displayNameForClass(String var) {
		return TrafficLightStep.displayNameTrafficLightStep(var);
	}
	public static String displayNameTrafficLightStep(String var) {
		switch(var) {
		case VAR_simulationName:
			return DISPLAY_NAME_simulationName;
		case VAR_sumocfgPath:
			return DISPLAY_NAME_sumocfgPath;
		case VAR_trafficLightId:
			return DISPLAY_NAME_trafficLightId;
		case VAR_trafficLightType:
			return DISPLAY_NAME_trafficLightType;
		case VAR_angle:
			return DISPLAY_NAME_angle;
		case VAR_state:
			return DISPLAY_NAME_state;
		case VAR_programId:
			return DISPLAY_NAME_programId;
		case VAR_phase:
			return DISPLAY_NAME_phase;
		default:
			return MapResult.displayNameMapResult(var);
		}
	}

	public static String descriptionTrafficLightStep(String var) {
		switch(var) {
			default:
				return MapResult.descriptionMapResult(var);
		}
	}

	public static String classSimpleNameTrafficLightStep(String var) {
		switch(var) {
		case VAR_simulationName:
			return "String";
		case VAR_sumocfgPath:
			return "String";
		case VAR_trafficLightId:
			return "String";
		case VAR_trafficLightType:
			return "String";
		case VAR_angle:
			return "BigDecimal";
		case VAR_state:
			return "String";
		case VAR_programId:
			return "Long";
		case VAR_phase:
			return "Long";
			default:
				return MapResult.classSimpleNameMapResult(var);
		}
	}

	public static Integer htmColumnTrafficLightStep(String var) {
		switch(var) {
			default:
				return MapResult.htmColumnMapResult(var);
		}
	}

	public static Integer htmRowTrafficLightStep(String var) {
		switch(var) {
		case VAR_simulationName:
			return 3;
		case VAR_sumocfgPath:
			return 3;
		case VAR_trafficLightId:
			return 4;
		case VAR_trafficLightType:
			return 4;
		case VAR_angle:
			return 5;
		case VAR_state:
			return 6;
		case VAR_programId:
			return 6;
		case VAR_phase:
			return 6;
			default:
				return MapResult.htmRowMapResult(var);
		}
	}

	public static Integer htmCellTrafficLightStep(String var) {
		switch(var) {
		case VAR_simulationName:
			return 1;
		case VAR_sumocfgPath:
			return 2;
		case VAR_trafficLightId:
			return 3;
		case VAR_trafficLightType:
			return 4;
		case VAR_angle:
			return 1;
		case VAR_state:
			return 1;
		case VAR_programId:
			return 2;
		case VAR_phase:
			return 3;
			default:
				return MapResult.htmCellMapResult(var);
		}
	}

	public static Integer lengthMinTrafficLightStep(String var) {
		switch(var) {
			default:
				return MapResult.lengthMinMapResult(var);
		}
	}

	public static Integer lengthMaxTrafficLightStep(String var) {
		switch(var) {
			default:
				return MapResult.lengthMaxMapResult(var);
		}
	}

	public static Integer maxTrafficLightStep(String var) {
		switch(var) {
			default:
				return MapResult.maxMapResult(var);
		}
	}

	public static Integer minTrafficLightStep(String var) {
		switch(var) {
			default:
				return MapResult.minMapResult(var);
		}
	}
}
