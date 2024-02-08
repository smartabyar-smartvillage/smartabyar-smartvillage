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
package org.computate.smartvillage.enus.model.traffic.simulation.report;

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
import java.lang.Long;
import org.computate.smartvillage.enus.model.traffic.simulation.TrafficSimulation;
import org.computate.vertx.search.list.SearchList;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Path;
import org.computate.vertx.serialize.pgclient.PgClientPathSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPathDeserializer;
import org.computate.smartvillage.enus.model.traffic.fiware.smarttrafficlight.SmartTrafficLight;
import java.math.BigDecimal;
import java.lang.Integer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <h3>About the SimulationReport class and it's generated class SimulationReportGen&lt;BaseModel&gt;: </h3>extends SimulationReportGen
 * <p>
 * This Java class extends a generated Java class SimulationReportGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport">Find the class SimulationReport in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends SimulationReportGen<BaseModel>
 * <p>This <code>class SimulationReport extends SimulationReportGen&lt;BaseModel&gt;</code>, which means it extends a newly generated SimulationReportGen. 
 * The generated <code>class SimulationReportGen extends BaseModel</code> which means that SimulationReport extends SimulationReportGen which extends BaseModel. 
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
 * <h2>ApiMethode: PUTCopy</h2>
 * <p>This class contains a comment <b>"ApiMethod: PUTCopy"</b>, which creates an API "PUTCopy". 
 * </p>
 * <h2>ApiMethode: PATCHRunSimulation</h2>
 * <p>This class contains a comment <b>"ApiMethod: PATCHRunSimulation"</b>, which creates an API "PATCHRunSimulation". 
 * </p>
 * <h2>ApiMethode: SearchPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: SearchPage"</b>, which creates an API "SearchPage". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: SimulationReport"</b>, which groups all of the OpenAPIs for SimulationReport objects under the tag "SimulationReport". 
 * </p>
 * <h2>ApiUri.enUS: /api/simulation-report</h2>
 * <p>This class contains a comment <b>"ApiUri: /api/simulation-report"</b>, which defines the base API URI for SimulationReport objects as "/api/simulation-report" in the OpenAPI spec. 
 * </p>
 * <h2>Color: 2017-shaded-spruce</h2>
 * <p>This class contains a comment <b>"Color: 2017-shaded-spruce"</b>, which styles the SimulationReport page "2017-shaded-spruce". 
 * This will reference a CSS class defined by the stylesheets in the project that starts with "w3-". 
 * A css class of "w3-2017-shaded-spruce" is expected to exist in the project stylesheets, and is inspired by W3 CSS colors. 
 * See: <a href="https://www.w3schools.com/w3css/w3css_colors.asp">https://www.w3schools.com/w3css/w3css_colors.asp</a>. 
 * </p>
 * <h2>IconGroup: duotone</h2>
 * <p>This class contains a comment <b>"IconGroup: duotone"</b>, which adds icons on the SimulationReport page with a group of "duotone". 
 * This will reference a Font Awesome icon group that starts with "fa-" followed by the icon group "duotone", together is "fa-duotone". 
 * A Font Awesome icon group of "duotone" is expected to exist. 
 * The Font Awesome groups currently supported include: solid, regular, light, thin, duotone, sharp, and kit. 
 * See: <a href="https://fontawesome.com/docs/web/dig-deeper/styles">https://fontawesome.com/docs/web/dig-deeper/styles</a>. 
 * </p>
 * <h2>IconName: file-chart-column</h2>
 * <p>This class contains a comment <b>"IconName: file-chart-column"</b>, which adds icons on the SimulationReport page with a name of "file-chart-column". 
 * This will reference a Font Awesome icon that starts with the icon group "fa-duotone fa-" followed by the icon name, which is "fa-duotone fa-file-chart-column". 
 * A Font Awesome icon of "fa-duotone fa-file-chart-column" is expected to exist. 
 * See: <a href="https://fontawesome.com/icons">https://fontawesome.com/icons</a>. 
 * </p>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the SimulationReport class will inherit the helpful inherited class comments from the super class SimulationReportGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the SimulationReport API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 9</h2>
 * <p>This class contains a comment <b>"Order: 9"</b>, which means this class will be sorted by the given number 9 ascending when code that relates to multiple classes at the same time is generated. 
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
 * This creates a new Java class org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReportPage. 
 * </p>
 * <h2>SuperPage.enUS: BaseModelPage</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: BaseModelPage"</b>, which identifies the Java super class of the page code by it's class simple name "BaseModelPage". 
 * This means that the newly created class org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReportPage extends org.computate.smartvillage.enus.model.base.BaseModelPage. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the SimulationReport Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * This class contains a comment <b>"Role.enUS: SiteAdmin"</b>, which identifies the default role name "SiteAdmin" of the OAuth2/OpenID Connect user role required to access this SimulationReport API. 
 * It's possible to reconfigure the roles required to access the SimulationReport API by configuring an environment variable like this: 
 * </p>
 * <pre>AUTH_ROLE_REQUIRED_SimulationReport: ["SiteAdmin"]</pre>
 * <h2>AName.enUS: a simulation report</h2>
 * <p>This class contains a comment <b>"AName.enUS: a simulation report"</b>, which identifies the language context to describe a SimulationReport as "a simulation report". 
 * </p>
 * <p>
 * Delete the class SimulationReport in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.traffic.simulation.report in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class SimulationReportGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(SimulationReport.class);

	public static final String SimulationReport_AName_enUS = "a simulation report";
	public static final String SimulationReport_This_enUS = "this ";
	public static final String SimulationReport_ThisName_enUS = "this simulation report";
	public static final String SimulationReport_A_enUS = "a ";
	public static final String SimulationReport_TheName_enUS = "the simulation report";
	public static final String SimulationReport_NameSingular_enUS = "simulation report";
	public static final String SimulationReport_NamePlural_enUS = "simulation reports";
	public static final String SimulationReport_NameActual_enUS = "current simulation report";
	public static final String SimulationReport_AllName_enUS = "all the simulation reports";
	public static final String SimulationReport_SearchAllNameBy_enUS = "search simulation reports by ";
	public static final String SimulationReport_Title_enUS = "simulation reports";
	public static final String SimulationReport_ThePluralName_enUS = "the simulation reports";
	public static final String SimulationReport_NoNameFound_enUS = "no simulation report found";
	public static final String SimulationReport_ApiUri_enUS = "/api/simulation-report";
	public static final String SimulationReport_ApiUriSearchPage_enUS = "/simulation-report";
	public static final String SimulationReport_OfName_enUS = "of simulation report";
	public static final String SimulationReport_ANameAdjective_enUS = "a simulation report";
	public static final String SimulationReport_NameAdjectiveSingular_enUS = "simulation report";
	public static final String SimulationReport_NameAdjectivePlural_enUS = "simulation reports";
	public static final String Search_enUS_Uri = "/api/simulation-report";
	public static final String Search_enUS_ImageUri = "/png/api/simulation-report-999.png";
	public static final String GET_enUS_Uri = "/api/simulation-report/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/simulation-report/{id}-999.png";
	public static final String PATCH_enUS_Uri = "/api/simulation-report";
	public static final String PATCH_enUS_ImageUri = "/png/api/simulation-report-999.png";
	public static final String POST_enUS_Uri = "/api/simulation-report";
	public static final String POST_enUS_ImageUri = "/png/api/simulation-report-999.png";
	public static final String PUTImport_enUS_Uri = "/api/simulation-report-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/simulation-report-import-999.png";
	public static final String PUTCopy_enUS_Uri = "/api/simulation-report/copy";
	public static final String PUTCopy_enUS_ImageUri = "/png/api/simulation-report/copy-999.png";
	public static final String PATCHRunSimulation_enUS_Uri = "/api/run-simulation-report";
	public static final String PATCHRunSimulation_enUS_ImageUri = "/png/api/run-simulation-report-999.png";
	public static final String SearchPage_enUS_Uri = "/simulation-report";
	public static final String SearchPage_enUS_ImageUri = "/png/simulation-report-999.png";

	public static final String SimulationReport_Color = "2017-shaded-spruce";
	public static final String SimulationReport_IconGroup = "duotone";
	public static final String SimulationReport_IconName = "file-chart-column";
	public static final Integer SimulationReport_Rows = 100;

	////////////////
	// reportName //
	////////////////


	/**	 The entity reportName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String reportName;

	/**	<br> The entity reportName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:reportName">Find the entity reportName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportName(Wrap<String> w);

	public String getReportName() {
		return reportName;
	}
	public void setReportName(String o) {
		this.reportName = SimulationReport.staticSetReportName(siteRequest_, o);
	}
	public static String staticSetReportName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SimulationReport reportNameInit() {
		Wrap<String> reportNameWrap = new Wrap<String>().var("reportName");
		if(reportName == null) {
			_reportName(reportNameWrap);
			Optional.ofNullable(reportNameWrap.getO()).ifPresent(o -> {
				setReportName(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchReportName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrReportName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportName(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchReportName(siteRequest_, SimulationReport.staticSetReportName(siteRequest_, o)).toString();
	}

	public String sqlReportName() {
		return reportName;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
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
		this.location = SimulationReport.staticSetLocation(siteRequest_, o);
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
		this.location = SimulationReport.staticSetLocation(siteRequest_, o);
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
	protected SimulationReport locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Point staticSearchLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequestEnUS siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchLocation(siteRequest_, SimulationReport.staticSetLocation(siteRequest_, o)).toString();
	}

	public Point sqlLocation() {
		return location;
	}

	///////////////////
	// simulationKey //
	///////////////////


	/**	 The entity simulationKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long simulationKey;

	/**	<br> The entity simulationKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:simulationKey">Find the entity simulationKey in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _simulationKey(Wrap<Long> w);

	public Long getSimulationKey() {
		return simulationKey;
	}

	public void setSimulationKey(Long simulationKey) {
		this.simulationKey = simulationKey;
	}
	@JsonIgnore
	public void setSimulationKey(String o) {
		this.simulationKey = SimulationReport.staticSetSimulationKey(siteRequest_, o);
	}
	public static Long staticSetSimulationKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SimulationReport simulationKeyInit() {
		Wrap<Long> simulationKeyWrap = new Wrap<Long>().var("simulationKey");
		if(simulationKey == null) {
			_simulationKey(simulationKeyWrap);
			Optional.ofNullable(simulationKeyWrap.getO()).ifPresent(o -> {
				setSimulationKey(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Long staticSearchSimulationKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrSimulationKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSimulationKey(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchSimulationKey(siteRequest_, SimulationReport.staticSetSimulationKey(siteRequest_, o)).toString();
	}

	public Long sqlSimulationKey() {
		return simulationKey;
	}

	//////////////////////
	// simulationSearch //
	//////////////////////


	/**	 The entity simulationSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<TrafficSimulation> simulationSearch;

	/**	<br> The entity simulationSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:simulationSearch">Find the entity simulationSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _simulationSearch(Promise<SearchList<TrafficSimulation>> promise);

	public SearchList<TrafficSimulation> getSimulationSearch() {
		return simulationSearch;
	}

	public void setSimulationSearch(SearchList<TrafficSimulation> simulationSearch) {
		this.simulationSearch = simulationSearch;
	}
	public static SearchList<TrafficSimulation> staticSetSimulationSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<TrafficSimulation>> simulationSearchPromise() {
		Promise<SearchList<TrafficSimulation>> promise = Promise.promise();
		Promise<SearchList<TrafficSimulation>> promise2 = Promise.promise();
		_simulationSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && simulationSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setSimulationSearch(o);
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

	/////////////////
	// simulation_ //
	/////////////////


	/**	 The entity simulation_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected TrafficSimulation simulation_;

	/**	<br> The entity simulation_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:simulation_">Find the entity simulation_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _simulation_(Wrap<TrafficSimulation> w);

	public TrafficSimulation getSimulation_() {
		return simulation_;
	}

	public void setSimulation_(TrafficSimulation simulation_) {
		this.simulation_ = simulation_;
	}
	public static TrafficSimulation staticSetSimulation_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SimulationReport simulation_Init() {
		Wrap<TrafficSimulation> simulation_Wrap = new Wrap<TrafficSimulation>().var("simulation_");
		if(simulation_ == null) {
			_simulation_(simulation_Wrap);
			Optional.ofNullable(simulation_Wrap.getO()).ifPresent(o -> {
				setSimulation_(o);
			});
		}
		return (SimulationReport)this;
	}

	////////////////////
	// observedSearch //
	////////////////////


	/**	 The entity observedSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SearchList<BaseModel> observedSearch;

	/**	<br> The entity observedSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:observedSearch">Find the entity observedSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _observedSearch(Promise<SearchList<BaseModel>> promise);

	public SearchList<BaseModel> getObservedSearch() {
		return observedSearch;
	}

	public void setObservedSearch(SearchList<BaseModel> observedSearch) {
		this.observedSearch = observedSearch;
	}
	public static SearchList<BaseModel> staticSetObservedSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<BaseModel>> observedSearchPromise() {
		Promise<SearchList<BaseModel>> promise = Promise.promise();
		Promise<SearchList<BaseModel>> promise2 = Promise.promise();
		_observedSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && observedSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setObservedSearch(o);
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
		String l = SimulationReport.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public SimulationReport addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (SimulationReport)this;
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
	protected SimulationReport areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (SimulationReport)this;
	}

	public static String staticSearchAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAreaServedColors(siteRequest_, SimulationReport.staticSetAreaServedColors(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
		String l = SimulationReport.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public SimulationReport addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (SimulationReport)this;
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
	protected SimulationReport areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (SimulationReport)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAreaServedTitles(siteRequest_, SimulationReport.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
		String l = SimulationReport.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public SimulationReport addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (SimulationReport)this;
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
	protected SimulationReport areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (SimulationReport)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAreaServedLinks(siteRequest_, SimulationReport.staticSetAreaServedLinks(siteRequest_, o)).toString();
	}

	////////////////
	// areaServed //
	////////////////


	/**	 The entity areaServed
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonDeserialize(contentUsing = PgClientPathDeserializer.class)
	@JsonSerialize(contentUsing = PgClientPathSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Path> areaServed = new ArrayList<Path>();

	/**	<br> The entity areaServed
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServed(List<Path> l);

	public List<Path> getAreaServed() {
		return areaServed;
	}

	public void setAreaServed(List<Path> areaServed) {
		this.areaServed = areaServed;
	}
	@JsonIgnore
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
	public SimulationReport addAreaServed(Path...objects) {
		for(Path o : objects) {
			addAreaServed(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addAreaServed(Path o) {
		if(o != null)
			this.areaServed.add(o);
		return (SimulationReport)this;
	}
	protected SimulationReport areaServedInit() {
		_areaServed(areaServed);
		return (SimulationReport)this;
	}

	public static Path staticSearchAreaServed(SiteRequestEnUS siteRequest_, Path o) {
		return o;
	}

	public static String staticSearchStrAreaServed(SiteRequestEnUS siteRequest_, Path o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServed(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAreaServed(siteRequest_, SimulationReport.staticSetAreaServed(siteRequest_, o)).toString();
	}

	//////////////////////////
	// smartTrafficLightKey //
	//////////////////////////


	/**	 The entity smartTrafficLightKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long smartTrafficLightKey;

	/**	<br> The entity smartTrafficLightKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:smartTrafficLightKey">Find the entity smartTrafficLightKey in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _smartTrafficLightKey(Wrap<Long> w);

	public Long getSmartTrafficLightKey() {
		return smartTrafficLightKey;
	}

	public void setSmartTrafficLightKey(Long smartTrafficLightKey) {
		this.smartTrafficLightKey = smartTrafficLightKey;
	}
	@JsonIgnore
	public void setSmartTrafficLightKey(String o) {
		this.smartTrafficLightKey = SimulationReport.staticSetSmartTrafficLightKey(siteRequest_, o);
	}
	public static Long staticSetSmartTrafficLightKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SimulationReport smartTrafficLightKeyInit() {
		Wrap<Long> smartTrafficLightKeyWrap = new Wrap<Long>().var("smartTrafficLightKey");
		if(smartTrafficLightKey == null) {
			_smartTrafficLightKey(smartTrafficLightKeyWrap);
			Optional.ofNullable(smartTrafficLightKeyWrap.getO()).ifPresent(o -> {
				setSmartTrafficLightKey(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Long staticSearchSmartTrafficLightKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrSmartTrafficLightKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSmartTrafficLightKey(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchSmartTrafficLightKey(siteRequest_, SimulationReport.staticSetSmartTrafficLightKey(siteRequest_, o)).toString();
	}

	public Long sqlSmartTrafficLightKey() {
		return smartTrafficLightKey;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:smartTrafficLightSearch">Find the entity smartTrafficLightSearch in Solr</a>
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:smartTrafficLight_">Find the entity smartTrafficLight_ in Solr</a>
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
	protected SimulationReport smartTrafficLight_Init() {
		Wrap<SmartTrafficLight> smartTrafficLight_Wrap = new Wrap<SmartTrafficLight>().var("smartTrafficLight_");
		if(smartTrafficLight_ == null) {
			_smartTrafficLight_(smartTrafficLight_Wrap);
			Optional.ofNullable(smartTrafficLight_Wrap.getO()).ifPresent(o -> {
				setSmartTrafficLight_(o);
			});
		}
		return (SimulationReport)this;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:simulationName">Find the entity simulationName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _simulationName(Wrap<String> w);

	public String getSimulationName() {
		return simulationName;
	}
	public void setSimulationName(String o) {
		this.simulationName = SimulationReport.staticSetSimulationName(siteRequest_, o);
	}
	public static String staticSetSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SimulationReport simulationNameInit() {
		Wrap<String> simulationNameWrap = new Wrap<String>().var("simulationName");
		if(simulationName == null) {
			_simulationName(simulationNameWrap);
			Optional.ofNullable(simulationNameWrap.getO()).ifPresent(o -> {
				setSimulationName(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSimulationName(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchSimulationName(siteRequest_, SimulationReport.staticSetSimulationName(siteRequest_, o)).toString();
	}

	public String sqlSimulationName() {
		return simulationName;
	}

	/////////////////////////
	// smartTrafficLightId //
	/////////////////////////


	/**	 The entity smartTrafficLightId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String smartTrafficLightId;

	/**	<br> The entity smartTrafficLightId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:smartTrafficLightId">Find the entity smartTrafficLightId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _smartTrafficLightId(Wrap<String> w);

	public String getSmartTrafficLightId() {
		return smartTrafficLightId;
	}
	public void setSmartTrafficLightId(String o) {
		this.smartTrafficLightId = SimulationReport.staticSetSmartTrafficLightId(siteRequest_, o);
	}
	public static String staticSetSmartTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SimulationReport smartTrafficLightIdInit() {
		Wrap<String> smartTrafficLightIdWrap = new Wrap<String>().var("smartTrafficLightId");
		if(smartTrafficLightId == null) {
			_smartTrafficLightId(smartTrafficLightIdWrap);
			Optional.ofNullable(smartTrafficLightIdWrap.getO()).ifPresent(o -> {
				setSmartTrafficLightId(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchSmartTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSmartTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSmartTrafficLightId(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchSmartTrafficLightId(siteRequest_, SimulationReport.staticSetSmartTrafficLightId(siteRequest_, o)).toString();
	}

	public String sqlSmartTrafficLightId() {
		return smartTrafficLightId;
	}

	///////////////////////////
	// smartTrafficLightName //
	///////////////////////////


	/**	 The entity smartTrafficLightName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String smartTrafficLightName;

	/**	<br> The entity smartTrafficLightName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:smartTrafficLightName">Find the entity smartTrafficLightName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _smartTrafficLightName(Wrap<String> w);

	public String getSmartTrafficLightName() {
		return smartTrafficLightName;
	}
	public void setSmartTrafficLightName(String o) {
		this.smartTrafficLightName = SimulationReport.staticSetSmartTrafficLightName(siteRequest_, o);
	}
	public static String staticSetSmartTrafficLightName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SimulationReport smartTrafficLightNameInit() {
		Wrap<String> smartTrafficLightNameWrap = new Wrap<String>().var("smartTrafficLightName");
		if(smartTrafficLightName == null) {
			_smartTrafficLightName(smartTrafficLightNameWrap);
			Optional.ofNullable(smartTrafficLightNameWrap.getO()).ifPresent(o -> {
				setSmartTrafficLightName(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchSmartTrafficLightName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSmartTrafficLightName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSmartTrafficLightName(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchSmartTrafficLightName(siteRequest_, SimulationReport.staticSetSmartTrafficLightName(siteRequest_, o)).toString();
	}

	public String sqlSmartTrafficLightName() {
		return smartTrafficLightName;
	}

	/////////////////////////////////////////
	// paramAvgVehiclePerMinFromWestToEast //
	/////////////////////////////////////////


	/**	 The entity paramAvgVehiclePerMinFromWestToEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramAvgVehiclePerMinFromWestToEast;

	/**	<br> The entity paramAvgVehiclePerMinFromWestToEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramAvgVehiclePerMinFromWestToEast">Find the entity paramAvgVehiclePerMinFromWestToEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramAvgVehiclePerMinFromWestToEast(Wrap<BigDecimal> w);

	public BigDecimal getParamAvgVehiclePerMinFromWestToEast() {
		return paramAvgVehiclePerMinFromWestToEast;
	}

	public void setParamAvgVehiclePerMinFromWestToEast(BigDecimal paramAvgVehiclePerMinFromWestToEast) {
		this.paramAvgVehiclePerMinFromWestToEast = paramAvgVehiclePerMinFromWestToEast;
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromWestToEast(String o) {
		this.paramAvgVehiclePerMinFromWestToEast = SimulationReport.staticSetParamAvgVehiclePerMinFromWestToEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamAvgVehiclePerMinFromWestToEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromWestToEast(Double o) {
		setParamAvgVehiclePerMinFromWestToEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromWestToEast(Integer o) {
		setParamAvgVehiclePerMinFromWestToEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromWestToEast(Number o) {
		setParamAvgVehiclePerMinFromWestToEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramAvgVehiclePerMinFromWestToEastInit() {
		Wrap<BigDecimal> paramAvgVehiclePerMinFromWestToEastWrap = new Wrap<BigDecimal>().var("paramAvgVehiclePerMinFromWestToEast");
		if(paramAvgVehiclePerMinFromWestToEast == null) {
			_paramAvgVehiclePerMinFromWestToEast(paramAvgVehiclePerMinFromWestToEastWrap);
			Optional.ofNullable(paramAvgVehiclePerMinFromWestToEastWrap.getO()).ifPresent(o -> {
				setParamAvgVehiclePerMinFromWestToEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamAvgVehiclePerMinFromWestToEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamAvgVehiclePerMinFromWestToEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamAvgVehiclePerMinFromWestToEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamAvgVehiclePerMinFromWestToEast(siteRequest_, SimulationReport.staticSetParamAvgVehiclePerMinFromWestToEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamAvgVehiclePerMinFromWestToEast() {
		return paramAvgVehiclePerMinFromWestToEast;
	}

	///////////////////////////////////////////
	// paramAvgVehiclePerMinFromSouthToNorth //
	///////////////////////////////////////////


	/**	 The entity paramAvgVehiclePerMinFromSouthToNorth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramAvgVehiclePerMinFromSouthToNorth;

	/**	<br> The entity paramAvgVehiclePerMinFromSouthToNorth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramAvgVehiclePerMinFromSouthToNorth">Find the entity paramAvgVehiclePerMinFromSouthToNorth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramAvgVehiclePerMinFromSouthToNorth(Wrap<BigDecimal> w);

	public BigDecimal getParamAvgVehiclePerMinFromSouthToNorth() {
		return paramAvgVehiclePerMinFromSouthToNorth;
	}

	public void setParamAvgVehiclePerMinFromSouthToNorth(BigDecimal paramAvgVehiclePerMinFromSouthToNorth) {
		this.paramAvgVehiclePerMinFromSouthToNorth = paramAvgVehiclePerMinFromSouthToNorth;
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromSouthToNorth(String o) {
		this.paramAvgVehiclePerMinFromSouthToNorth = SimulationReport.staticSetParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamAvgVehiclePerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromSouthToNorth(Double o) {
		setParamAvgVehiclePerMinFromSouthToNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromSouthToNorth(Integer o) {
		setParamAvgVehiclePerMinFromSouthToNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgVehiclePerMinFromSouthToNorth(Number o) {
		setParamAvgVehiclePerMinFromSouthToNorth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramAvgVehiclePerMinFromSouthToNorthInit() {
		Wrap<BigDecimal> paramAvgVehiclePerMinFromSouthToNorthWrap = new Wrap<BigDecimal>().var("paramAvgVehiclePerMinFromSouthToNorth");
		if(paramAvgVehiclePerMinFromSouthToNorth == null) {
			_paramAvgVehiclePerMinFromSouthToNorth(paramAvgVehiclePerMinFromSouthToNorthWrap);
			Optional.ofNullable(paramAvgVehiclePerMinFromSouthToNorthWrap.getO()).ifPresent(o -> {
				setParamAvgVehiclePerMinFromSouthToNorth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamAvgVehiclePerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamAvgVehiclePerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamAvgVehiclePerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, SimulationReport.staticSetParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamAvgVehiclePerMinFromSouthToNorth() {
		return paramAvgVehiclePerMinFromSouthToNorth;
	}

	/////////////////////////////////////
	// paramVehicleDemandScalingFactor //
	/////////////////////////////////////


	/**	 The entity paramVehicleDemandScalingFactor
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramVehicleDemandScalingFactor;

	/**	<br> The entity paramVehicleDemandScalingFactor
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramVehicleDemandScalingFactor">Find the entity paramVehicleDemandScalingFactor in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramVehicleDemandScalingFactor(Wrap<BigDecimal> w);

	public BigDecimal getParamVehicleDemandScalingFactor() {
		return paramVehicleDemandScalingFactor;
	}

	public void setParamVehicleDemandScalingFactor(BigDecimal paramVehicleDemandScalingFactor) {
		this.paramVehicleDemandScalingFactor = paramVehicleDemandScalingFactor;
	}
	@JsonIgnore
	public void setParamVehicleDemandScalingFactor(String o) {
		this.paramVehicleDemandScalingFactor = SimulationReport.staticSetParamVehicleDemandScalingFactor(siteRequest_, o);
	}
	public static BigDecimal staticSetParamVehicleDemandScalingFactor(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamVehicleDemandScalingFactor(Double o) {
		setParamVehicleDemandScalingFactor(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamVehicleDemandScalingFactor(Integer o) {
		setParamVehicleDemandScalingFactor(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamVehicleDemandScalingFactor(Number o) {
		setParamVehicleDemandScalingFactor(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramVehicleDemandScalingFactorInit() {
		Wrap<BigDecimal> paramVehicleDemandScalingFactorWrap = new Wrap<BigDecimal>().var("paramVehicleDemandScalingFactor");
		if(paramVehicleDemandScalingFactor == null) {
			_paramVehicleDemandScalingFactor(paramVehicleDemandScalingFactorWrap);
			Optional.ofNullable(paramVehicleDemandScalingFactorWrap.getO()).ifPresent(o -> {
				setParamVehicleDemandScalingFactor(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamVehicleDemandScalingFactor(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamVehicleDemandScalingFactor(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamVehicleDemandScalingFactor(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamVehicleDemandScalingFactor(siteRequest_, SimulationReport.staticSetParamVehicleDemandScalingFactor(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamVehicleDemandScalingFactor() {
		return paramVehicleDemandScalingFactor;
	}

	////////////////////////////////////////////
	// paramAvgPedestrianPerMinFromWestToEast //
	////////////////////////////////////////////


	/**	 The entity paramAvgPedestrianPerMinFromWestToEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramAvgPedestrianPerMinFromWestToEast;

	/**	<br> The entity paramAvgPedestrianPerMinFromWestToEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramAvgPedestrianPerMinFromWestToEast">Find the entity paramAvgPedestrianPerMinFromWestToEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramAvgPedestrianPerMinFromWestToEast(Wrap<BigDecimal> w);

	public BigDecimal getParamAvgPedestrianPerMinFromWestToEast() {
		return paramAvgPedestrianPerMinFromWestToEast;
	}

	public void setParamAvgPedestrianPerMinFromWestToEast(BigDecimal paramAvgPedestrianPerMinFromWestToEast) {
		this.paramAvgPedestrianPerMinFromWestToEast = paramAvgPedestrianPerMinFromWestToEast;
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromWestToEast(String o) {
		this.paramAvgPedestrianPerMinFromWestToEast = SimulationReport.staticSetParamAvgPedestrianPerMinFromWestToEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamAvgPedestrianPerMinFromWestToEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromWestToEast(Double o) {
		setParamAvgPedestrianPerMinFromWestToEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromWestToEast(Integer o) {
		setParamAvgPedestrianPerMinFromWestToEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromWestToEast(Number o) {
		setParamAvgPedestrianPerMinFromWestToEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramAvgPedestrianPerMinFromWestToEastInit() {
		Wrap<BigDecimal> paramAvgPedestrianPerMinFromWestToEastWrap = new Wrap<BigDecimal>().var("paramAvgPedestrianPerMinFromWestToEast");
		if(paramAvgPedestrianPerMinFromWestToEast == null) {
			_paramAvgPedestrianPerMinFromWestToEast(paramAvgPedestrianPerMinFromWestToEastWrap);
			Optional.ofNullable(paramAvgPedestrianPerMinFromWestToEastWrap.getO()).ifPresent(o -> {
				setParamAvgPedestrianPerMinFromWestToEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamAvgPedestrianPerMinFromWestToEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamAvgPedestrianPerMinFromWestToEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamAvgPedestrianPerMinFromWestToEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamAvgPedestrianPerMinFromWestToEast(siteRequest_, SimulationReport.staticSetParamAvgPedestrianPerMinFromWestToEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamAvgPedestrianPerMinFromWestToEast() {
		return paramAvgPedestrianPerMinFromWestToEast;
	}

	//////////////////////////////////////////////
	// paramAvgPedestrianPerMinFromSouthToNorth //
	//////////////////////////////////////////////


	/**	 The entity paramAvgPedestrianPerMinFromSouthToNorth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramAvgPedestrianPerMinFromSouthToNorth;

	/**	<br> The entity paramAvgPedestrianPerMinFromSouthToNorth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramAvgPedestrianPerMinFromSouthToNorth">Find the entity paramAvgPedestrianPerMinFromSouthToNorth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramAvgPedestrianPerMinFromSouthToNorth(Wrap<BigDecimal> w);

	public BigDecimal getParamAvgPedestrianPerMinFromSouthToNorth() {
		return paramAvgPedestrianPerMinFromSouthToNorth;
	}

	public void setParamAvgPedestrianPerMinFromSouthToNorth(BigDecimal paramAvgPedestrianPerMinFromSouthToNorth) {
		this.paramAvgPedestrianPerMinFromSouthToNorth = paramAvgPedestrianPerMinFromSouthToNorth;
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromSouthToNorth(String o) {
		this.paramAvgPedestrianPerMinFromSouthToNorth = SimulationReport.staticSetParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamAvgPedestrianPerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromSouthToNorth(Double o) {
		setParamAvgPedestrianPerMinFromSouthToNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromSouthToNorth(Integer o) {
		setParamAvgPedestrianPerMinFromSouthToNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamAvgPedestrianPerMinFromSouthToNorth(Number o) {
		setParamAvgPedestrianPerMinFromSouthToNorth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramAvgPedestrianPerMinFromSouthToNorthInit() {
		Wrap<BigDecimal> paramAvgPedestrianPerMinFromSouthToNorthWrap = new Wrap<BigDecimal>().var("paramAvgPedestrianPerMinFromSouthToNorth");
		if(paramAvgPedestrianPerMinFromSouthToNorth == null) {
			_paramAvgPedestrianPerMinFromSouthToNorth(paramAvgPedestrianPerMinFromSouthToNorthWrap);
			Optional.ofNullable(paramAvgPedestrianPerMinFromSouthToNorthWrap.getO()).ifPresent(o -> {
				setParamAvgPedestrianPerMinFromSouthToNorth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamAvgPedestrianPerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamAvgPedestrianPerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamAvgPedestrianPerMinFromSouthToNorth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, SimulationReport.staticSetParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamAvgPedestrianPerMinFromSouthToNorth() {
		return paramAvgPedestrianPerMinFromSouthToNorth;
	}

	////////////////////////////////////////
	// paramPedestrianDemandScalingFactor //
	////////////////////////////////////////


	/**	 The entity paramPedestrianDemandScalingFactor
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramPedestrianDemandScalingFactor;

	/**	<br> The entity paramPedestrianDemandScalingFactor
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramPedestrianDemandScalingFactor">Find the entity paramPedestrianDemandScalingFactor in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramPedestrianDemandScalingFactor(Wrap<BigDecimal> w);

	public BigDecimal getParamPedestrianDemandScalingFactor() {
		return paramPedestrianDemandScalingFactor;
	}

	public void setParamPedestrianDemandScalingFactor(BigDecimal paramPedestrianDemandScalingFactor) {
		this.paramPedestrianDemandScalingFactor = paramPedestrianDemandScalingFactor;
	}
	@JsonIgnore
	public void setParamPedestrianDemandScalingFactor(String o) {
		this.paramPedestrianDemandScalingFactor = SimulationReport.staticSetParamPedestrianDemandScalingFactor(siteRequest_, o);
	}
	public static BigDecimal staticSetParamPedestrianDemandScalingFactor(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamPedestrianDemandScalingFactor(Double o) {
		setParamPedestrianDemandScalingFactor(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianDemandScalingFactor(Integer o) {
		setParamPedestrianDemandScalingFactor(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianDemandScalingFactor(Number o) {
		setParamPedestrianDemandScalingFactor(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramPedestrianDemandScalingFactorInit() {
		Wrap<BigDecimal> paramPedestrianDemandScalingFactorWrap = new Wrap<BigDecimal>().var("paramPedestrianDemandScalingFactor");
		if(paramPedestrianDemandScalingFactor == null) {
			_paramPedestrianDemandScalingFactor(paramPedestrianDemandScalingFactorWrap);
			Optional.ofNullable(paramPedestrianDemandScalingFactorWrap.getO()).ifPresent(o -> {
				setParamPedestrianDemandScalingFactor(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamPedestrianDemandScalingFactor(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamPedestrianDemandScalingFactor(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamPedestrianDemandScalingFactor(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamPedestrianDemandScalingFactor(siteRequest_, SimulationReport.staticSetParamPedestrianDemandScalingFactor(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamPedestrianDemandScalingFactor() {
		return paramPedestrianDemandScalingFactor;
	}

	//////////////
	// paramLam //
	//////////////


	/**	 The entity paramLam
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<BigDecimal> paramLam = new ArrayList<BigDecimal>();

	/**	<br> The entity paramLam
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramLam">Find the entity paramLam in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _paramLam(List<BigDecimal> l);

	public List<BigDecimal> getParamLam() {
		return paramLam;
	}

	public void setParamLam(List<BigDecimal> paramLam) {
		this.paramLam = paramLam;
	}
	@JsonIgnore
	public void setParamLam(String o) {
		BigDecimal l = SimulationReport.staticSetParamLam(siteRequest_, o);
		if(l != null)
			addParamLam(l);
	}
	public static BigDecimal staticSetParamLam(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamLam(Double o) {
		addParamLam(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamLam(Integer o) {
		addParamLam(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamLam(Number o) {
		addParamLam(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	public SimulationReport addParamLam(BigDecimal...objects) {
		for(BigDecimal o : objects) {
			addParamLam(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addParamLam(BigDecimal o) {
		if(o != null)
			this.paramLam.add(o);
		return (SimulationReport)this;
	}
	@JsonIgnore
	public void setParamLam(JsonArray objects) {
		paramLam.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addParamLam(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
		}
	}
	public SimulationReport addParamLam(String o) {
		if(NumberUtils.isParsable(o)) {
			BigDecimal p = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
			addParamLam(p);
		}
		return (SimulationReport)this;
	}
	protected SimulationReport paramLamInit() {
		_paramLam(paramLam);
		return (SimulationReport)this;
	}

	public static BigDecimal staticSearchParamLam(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o;
	}

	public static String staticSearchStrParamLam(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamLam(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamLam(siteRequest_, SimulationReport.staticSetParamLam(siteRequest_, o)).toString();
	}

	//////////////////////////////////
	// paramMinGreenTimeSecWestEast //
	//////////////////////////////////


	/**	 The entity paramMinGreenTimeSecWestEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramMinGreenTimeSecWestEast;

	/**	<br> The entity paramMinGreenTimeSecWestEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramMinGreenTimeSecWestEast">Find the entity paramMinGreenTimeSecWestEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramMinGreenTimeSecWestEast(Wrap<BigDecimal> w);

	public BigDecimal getParamMinGreenTimeSecWestEast() {
		return paramMinGreenTimeSecWestEast;
	}

	public void setParamMinGreenTimeSecWestEast(BigDecimal paramMinGreenTimeSecWestEast) {
		this.paramMinGreenTimeSecWestEast = paramMinGreenTimeSecWestEast;
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecWestEast(String o) {
		this.paramMinGreenTimeSecWestEast = SimulationReport.staticSetParamMinGreenTimeSecWestEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamMinGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecWestEast(Double o) {
		setParamMinGreenTimeSecWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecWestEast(Integer o) {
		setParamMinGreenTimeSecWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecWestEast(Number o) {
		setParamMinGreenTimeSecWestEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramMinGreenTimeSecWestEastInit() {
		Wrap<BigDecimal> paramMinGreenTimeSecWestEastWrap = new Wrap<BigDecimal>().var("paramMinGreenTimeSecWestEast");
		if(paramMinGreenTimeSecWestEast == null) {
			_paramMinGreenTimeSecWestEast(paramMinGreenTimeSecWestEastWrap);
			Optional.ofNullable(paramMinGreenTimeSecWestEastWrap.getO()).ifPresent(o -> {
				setParamMinGreenTimeSecWestEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamMinGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamMinGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamMinGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamMinGreenTimeSecWestEast(siteRequest_, SimulationReport.staticSetParamMinGreenTimeSecWestEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamMinGreenTimeSecWestEast() {
		return paramMinGreenTimeSecWestEast;
	}

	//////////////////////////////////
	// paramMaxGreenTimeSecWestEast //
	//////////////////////////////////


	/**	 The entity paramMaxGreenTimeSecWestEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramMaxGreenTimeSecWestEast;

	/**	<br> The entity paramMaxGreenTimeSecWestEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramMaxGreenTimeSecWestEast">Find the entity paramMaxGreenTimeSecWestEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramMaxGreenTimeSecWestEast(Wrap<BigDecimal> w);

	public BigDecimal getParamMaxGreenTimeSecWestEast() {
		return paramMaxGreenTimeSecWestEast;
	}

	public void setParamMaxGreenTimeSecWestEast(BigDecimal paramMaxGreenTimeSecWestEast) {
		this.paramMaxGreenTimeSecWestEast = paramMaxGreenTimeSecWestEast;
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecWestEast(String o) {
		this.paramMaxGreenTimeSecWestEast = SimulationReport.staticSetParamMaxGreenTimeSecWestEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamMaxGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecWestEast(Double o) {
		setParamMaxGreenTimeSecWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecWestEast(Integer o) {
		setParamMaxGreenTimeSecWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecWestEast(Number o) {
		setParamMaxGreenTimeSecWestEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramMaxGreenTimeSecWestEastInit() {
		Wrap<BigDecimal> paramMaxGreenTimeSecWestEastWrap = new Wrap<BigDecimal>().var("paramMaxGreenTimeSecWestEast");
		if(paramMaxGreenTimeSecWestEast == null) {
			_paramMaxGreenTimeSecWestEast(paramMaxGreenTimeSecWestEastWrap);
			Optional.ofNullable(paramMaxGreenTimeSecWestEastWrap.getO()).ifPresent(o -> {
				setParamMaxGreenTimeSecWestEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamMaxGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamMaxGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamMaxGreenTimeSecWestEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamMaxGreenTimeSecWestEast(siteRequest_, SimulationReport.staticSetParamMaxGreenTimeSecWestEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamMaxGreenTimeSecWestEast() {
		return paramMaxGreenTimeSecWestEast;
	}

	////////////////////////////////////
	// paramMinGreenTimeSecSouthNorth //
	////////////////////////////////////


	/**	 The entity paramMinGreenTimeSecSouthNorth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramMinGreenTimeSecSouthNorth;

	/**	<br> The entity paramMinGreenTimeSecSouthNorth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramMinGreenTimeSecSouthNorth">Find the entity paramMinGreenTimeSecSouthNorth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramMinGreenTimeSecSouthNorth(Wrap<BigDecimal> w);

	public BigDecimal getParamMinGreenTimeSecSouthNorth() {
		return paramMinGreenTimeSecSouthNorth;
	}

	public void setParamMinGreenTimeSecSouthNorth(BigDecimal paramMinGreenTimeSecSouthNorth) {
		this.paramMinGreenTimeSecSouthNorth = paramMinGreenTimeSecSouthNorth;
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecSouthNorth(String o) {
		this.paramMinGreenTimeSecSouthNorth = SimulationReport.staticSetParamMinGreenTimeSecSouthNorth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamMinGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecSouthNorth(Double o) {
		setParamMinGreenTimeSecSouthNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecSouthNorth(Integer o) {
		setParamMinGreenTimeSecSouthNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMinGreenTimeSecSouthNorth(Number o) {
		setParamMinGreenTimeSecSouthNorth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramMinGreenTimeSecSouthNorthInit() {
		Wrap<BigDecimal> paramMinGreenTimeSecSouthNorthWrap = new Wrap<BigDecimal>().var("paramMinGreenTimeSecSouthNorth");
		if(paramMinGreenTimeSecSouthNorth == null) {
			_paramMinGreenTimeSecSouthNorth(paramMinGreenTimeSecSouthNorthWrap);
			Optional.ofNullable(paramMinGreenTimeSecSouthNorthWrap.getO()).ifPresent(o -> {
				setParamMinGreenTimeSecSouthNorth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamMinGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamMinGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamMinGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamMinGreenTimeSecSouthNorth(siteRequest_, SimulationReport.staticSetParamMinGreenTimeSecSouthNorth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamMinGreenTimeSecSouthNorth() {
		return paramMinGreenTimeSecSouthNorth;
	}

	////////////////////////////////////
	// paramMaxGreenTimeSecSouthNorth //
	////////////////////////////////////


	/**	 The entity paramMaxGreenTimeSecSouthNorth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramMaxGreenTimeSecSouthNorth;

	/**	<br> The entity paramMaxGreenTimeSecSouthNorth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramMaxGreenTimeSecSouthNorth">Find the entity paramMaxGreenTimeSecSouthNorth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramMaxGreenTimeSecSouthNorth(Wrap<BigDecimal> w);

	public BigDecimal getParamMaxGreenTimeSecSouthNorth() {
		return paramMaxGreenTimeSecSouthNorth;
	}

	public void setParamMaxGreenTimeSecSouthNorth(BigDecimal paramMaxGreenTimeSecSouthNorth) {
		this.paramMaxGreenTimeSecSouthNorth = paramMaxGreenTimeSecSouthNorth;
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecSouthNorth(String o) {
		this.paramMaxGreenTimeSecSouthNorth = SimulationReport.staticSetParamMaxGreenTimeSecSouthNorth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamMaxGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecSouthNorth(Double o) {
		setParamMaxGreenTimeSecSouthNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecSouthNorth(Integer o) {
		setParamMaxGreenTimeSecSouthNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamMaxGreenTimeSecSouthNorth(Number o) {
		setParamMaxGreenTimeSecSouthNorth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramMaxGreenTimeSecSouthNorthInit() {
		Wrap<BigDecimal> paramMaxGreenTimeSecSouthNorthWrap = new Wrap<BigDecimal>().var("paramMaxGreenTimeSecSouthNorth");
		if(paramMaxGreenTimeSecSouthNorth == null) {
			_paramMaxGreenTimeSecSouthNorth(paramMaxGreenTimeSecSouthNorthWrap);
			Optional.ofNullable(paramMaxGreenTimeSecSouthNorthWrap.getO()).ifPresent(o -> {
				setParamMaxGreenTimeSecSouthNorth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamMaxGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamMaxGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamMaxGreenTimeSecSouthNorth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamMaxGreenTimeSecSouthNorth(siteRequest_, SimulationReport.staticSetParamMaxGreenTimeSecSouthNorth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamMaxGreenTimeSecSouthNorth() {
		return paramMaxGreenTimeSecSouthNorth;
	}

	///////////////////////////////////////////////
	// paramPedestrianWaitThresholdSecNorthSouth //
	///////////////////////////////////////////////


	/**	 The entity paramPedestrianWaitThresholdSecNorthSouth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramPedestrianWaitThresholdSecNorthSouth;

	/**	<br> The entity paramPedestrianWaitThresholdSecNorthSouth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramPedestrianWaitThresholdSecNorthSouth">Find the entity paramPedestrianWaitThresholdSecNorthSouth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramPedestrianWaitThresholdSecNorthSouth(Wrap<BigDecimal> w);

	public BigDecimal getParamPedestrianWaitThresholdSecNorthSouth() {
		return paramPedestrianWaitThresholdSecNorthSouth;
	}

	public void setParamPedestrianWaitThresholdSecNorthSouth(BigDecimal paramPedestrianWaitThresholdSecNorthSouth) {
		this.paramPedestrianWaitThresholdSecNorthSouth = paramPedestrianWaitThresholdSecNorthSouth;
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecNorthSouth(String o) {
		this.paramPedestrianWaitThresholdSecNorthSouth = SimulationReport.staticSetParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamPedestrianWaitThresholdSecNorthSouth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecNorthSouth(Double o) {
		setParamPedestrianWaitThresholdSecNorthSouth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecNorthSouth(Integer o) {
		setParamPedestrianWaitThresholdSecNorthSouth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecNorthSouth(Number o) {
		setParamPedestrianWaitThresholdSecNorthSouth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramPedestrianWaitThresholdSecNorthSouthInit() {
		Wrap<BigDecimal> paramPedestrianWaitThresholdSecNorthSouthWrap = new Wrap<BigDecimal>().var("paramPedestrianWaitThresholdSecNorthSouth");
		if(paramPedestrianWaitThresholdSecNorthSouth == null) {
			_paramPedestrianWaitThresholdSecNorthSouth(paramPedestrianWaitThresholdSecNorthSouthWrap);
			Optional.ofNullable(paramPedestrianWaitThresholdSecNorthSouthWrap.getO()).ifPresent(o -> {
				setParamPedestrianWaitThresholdSecNorthSouth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamPedestrianWaitThresholdSecNorthSouth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamPedestrianWaitThresholdSecNorthSouth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamPedestrianWaitThresholdSecNorthSouth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, SimulationReport.staticSetParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamPedestrianWaitThresholdSecNorthSouth() {
		return paramPedestrianWaitThresholdSecNorthSouth;
	}

	/////////////////////////////////////////////
	// paramPedestrianWaitThresholdSecWestEast //
	/////////////////////////////////////////////


	/**	 The entity paramPedestrianWaitThresholdSecWestEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramPedestrianWaitThresholdSecWestEast;

	/**	<br> The entity paramPedestrianWaitThresholdSecWestEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramPedestrianWaitThresholdSecWestEast">Find the entity paramPedestrianWaitThresholdSecWestEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramPedestrianWaitThresholdSecWestEast(Wrap<BigDecimal> w);

	public BigDecimal getParamPedestrianWaitThresholdSecWestEast() {
		return paramPedestrianWaitThresholdSecWestEast;
	}

	public void setParamPedestrianWaitThresholdSecWestEast(BigDecimal paramPedestrianWaitThresholdSecWestEast) {
		this.paramPedestrianWaitThresholdSecWestEast = paramPedestrianWaitThresholdSecWestEast;
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecWestEast(String o) {
		this.paramPedestrianWaitThresholdSecWestEast = SimulationReport.staticSetParamPedestrianWaitThresholdSecWestEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamPedestrianWaitThresholdSecWestEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecWestEast(Double o) {
		setParamPedestrianWaitThresholdSecWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecWestEast(Integer o) {
		setParamPedestrianWaitThresholdSecWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianWaitThresholdSecWestEast(Number o) {
		setParamPedestrianWaitThresholdSecWestEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramPedestrianWaitThresholdSecWestEastInit() {
		Wrap<BigDecimal> paramPedestrianWaitThresholdSecWestEastWrap = new Wrap<BigDecimal>().var("paramPedestrianWaitThresholdSecWestEast");
		if(paramPedestrianWaitThresholdSecWestEast == null) {
			_paramPedestrianWaitThresholdSecWestEast(paramPedestrianWaitThresholdSecWestEastWrap);
			Optional.ofNullable(paramPedestrianWaitThresholdSecWestEastWrap.getO()).ifPresent(o -> {
				setParamPedestrianWaitThresholdSecWestEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamPedestrianWaitThresholdSecWestEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamPedestrianWaitThresholdSecWestEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamPedestrianWaitThresholdSecWestEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamPedestrianWaitThresholdSecWestEast(siteRequest_, SimulationReport.staticSetParamPedestrianWaitThresholdSecWestEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamPedestrianWaitThresholdSecWestEast() {
		return paramPedestrianWaitThresholdSecWestEast;
	}

	////////////////////////////////////////
	// paramVehicleQueueThresholdWestEast //
	////////////////////////////////////////


	/**	 The entity paramVehicleQueueThresholdWestEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramVehicleQueueThresholdWestEast;

	/**	<br> The entity paramVehicleQueueThresholdWestEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramVehicleQueueThresholdWestEast">Find the entity paramVehicleQueueThresholdWestEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramVehicleQueueThresholdWestEast(Wrap<BigDecimal> w);

	public BigDecimal getParamVehicleQueueThresholdWestEast() {
		return paramVehicleQueueThresholdWestEast;
	}

	public void setParamVehicleQueueThresholdWestEast(BigDecimal paramVehicleQueueThresholdWestEast) {
		this.paramVehicleQueueThresholdWestEast = paramVehicleQueueThresholdWestEast;
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdWestEast(String o) {
		this.paramVehicleQueueThresholdWestEast = SimulationReport.staticSetParamVehicleQueueThresholdWestEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamVehicleQueueThresholdWestEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdWestEast(Double o) {
		setParamVehicleQueueThresholdWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdWestEast(Integer o) {
		setParamVehicleQueueThresholdWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdWestEast(Number o) {
		setParamVehicleQueueThresholdWestEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramVehicleQueueThresholdWestEastInit() {
		Wrap<BigDecimal> paramVehicleQueueThresholdWestEastWrap = new Wrap<BigDecimal>().var("paramVehicleQueueThresholdWestEast");
		if(paramVehicleQueueThresholdWestEast == null) {
			_paramVehicleQueueThresholdWestEast(paramVehicleQueueThresholdWestEastWrap);
			Optional.ofNullable(paramVehicleQueueThresholdWestEastWrap.getO()).ifPresent(o -> {
				setParamVehicleQueueThresholdWestEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamVehicleQueueThresholdWestEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamVehicleQueueThresholdWestEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamVehicleQueueThresholdWestEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamVehicleQueueThresholdWestEast(siteRequest_, SimulationReport.staticSetParamVehicleQueueThresholdWestEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamVehicleQueueThresholdWestEast() {
		return paramVehicleQueueThresholdWestEast;
	}

	//////////////////////////////////////////
	// paramVehicleQueueThresholdSouthNorth //
	//////////////////////////////////////////


	/**	 The entity paramVehicleQueueThresholdSouthNorth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramVehicleQueueThresholdSouthNorth;

	/**	<br> The entity paramVehicleQueueThresholdSouthNorth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramVehicleQueueThresholdSouthNorth">Find the entity paramVehicleQueueThresholdSouthNorth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramVehicleQueueThresholdSouthNorth(Wrap<BigDecimal> w);

	public BigDecimal getParamVehicleQueueThresholdSouthNorth() {
		return paramVehicleQueueThresholdSouthNorth;
	}

	public void setParamVehicleQueueThresholdSouthNorth(BigDecimal paramVehicleQueueThresholdSouthNorth) {
		this.paramVehicleQueueThresholdSouthNorth = paramVehicleQueueThresholdSouthNorth;
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdSouthNorth(String o) {
		this.paramVehicleQueueThresholdSouthNorth = SimulationReport.staticSetParamVehicleQueueThresholdSouthNorth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamVehicleQueueThresholdSouthNorth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdSouthNorth(Double o) {
		setParamVehicleQueueThresholdSouthNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdSouthNorth(Integer o) {
		setParamVehicleQueueThresholdSouthNorth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamVehicleQueueThresholdSouthNorth(Number o) {
		setParamVehicleQueueThresholdSouthNorth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramVehicleQueueThresholdSouthNorthInit() {
		Wrap<BigDecimal> paramVehicleQueueThresholdSouthNorthWrap = new Wrap<BigDecimal>().var("paramVehicleQueueThresholdSouthNorth");
		if(paramVehicleQueueThresholdSouthNorth == null) {
			_paramVehicleQueueThresholdSouthNorth(paramVehicleQueueThresholdSouthNorthWrap);
			Optional.ofNullable(paramVehicleQueueThresholdSouthNorthWrap.getO()).ifPresent(o -> {
				setParamVehicleQueueThresholdSouthNorth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamVehicleQueueThresholdSouthNorth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamVehicleQueueThresholdSouthNorth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamVehicleQueueThresholdSouthNorth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamVehicleQueueThresholdSouthNorth(siteRequest_, SimulationReport.staticSetParamVehicleQueueThresholdSouthNorth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamVehicleQueueThresholdSouthNorth() {
		return paramVehicleQueueThresholdSouthNorth;
	}

	/////////////////////////////////////////////
	// paramPedestrianQueueThresholdNorthSouth //
	/////////////////////////////////////////////


	/**	 The entity paramPedestrianQueueThresholdNorthSouth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramPedestrianQueueThresholdNorthSouth;

	/**	<br> The entity paramPedestrianQueueThresholdNorthSouth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramPedestrianQueueThresholdNorthSouth">Find the entity paramPedestrianQueueThresholdNorthSouth in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramPedestrianQueueThresholdNorthSouth(Wrap<BigDecimal> w);

	public BigDecimal getParamPedestrianQueueThresholdNorthSouth() {
		return paramPedestrianQueueThresholdNorthSouth;
	}

	public void setParamPedestrianQueueThresholdNorthSouth(BigDecimal paramPedestrianQueueThresholdNorthSouth) {
		this.paramPedestrianQueueThresholdNorthSouth = paramPedestrianQueueThresholdNorthSouth;
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdNorthSouth(String o) {
		this.paramPedestrianQueueThresholdNorthSouth = SimulationReport.staticSetParamPedestrianQueueThresholdNorthSouth(siteRequest_, o);
	}
	public static BigDecimal staticSetParamPedestrianQueueThresholdNorthSouth(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdNorthSouth(Double o) {
		setParamPedestrianQueueThresholdNorthSouth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdNorthSouth(Integer o) {
		setParamPedestrianQueueThresholdNorthSouth(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdNorthSouth(Number o) {
		setParamPedestrianQueueThresholdNorthSouth(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramPedestrianQueueThresholdNorthSouthInit() {
		Wrap<BigDecimal> paramPedestrianQueueThresholdNorthSouthWrap = new Wrap<BigDecimal>().var("paramPedestrianQueueThresholdNorthSouth");
		if(paramPedestrianQueueThresholdNorthSouth == null) {
			_paramPedestrianQueueThresholdNorthSouth(paramPedestrianQueueThresholdNorthSouthWrap);
			Optional.ofNullable(paramPedestrianQueueThresholdNorthSouthWrap.getO()).ifPresent(o -> {
				setParamPedestrianQueueThresholdNorthSouth(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamPedestrianQueueThresholdNorthSouth(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamPedestrianQueueThresholdNorthSouth(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamPedestrianQueueThresholdNorthSouth(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamPedestrianQueueThresholdNorthSouth(siteRequest_, SimulationReport.staticSetParamPedestrianQueueThresholdNorthSouth(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamPedestrianQueueThresholdNorthSouth() {
		return paramPedestrianQueueThresholdNorthSouth;
	}

	///////////////////////////////////////////
	// paramPedestrianQueueThresholdWestEast //
	///////////////////////////////////////////


	/**	 The entity paramPedestrianQueueThresholdWestEast
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramPedestrianQueueThresholdWestEast;

	/**	<br> The entity paramPedestrianQueueThresholdWestEast
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramPedestrianQueueThresholdWestEast">Find the entity paramPedestrianQueueThresholdWestEast in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramPedestrianQueueThresholdWestEast(Wrap<BigDecimal> w);

	public BigDecimal getParamPedestrianQueueThresholdWestEast() {
		return paramPedestrianQueueThresholdWestEast;
	}

	public void setParamPedestrianQueueThresholdWestEast(BigDecimal paramPedestrianQueueThresholdWestEast) {
		this.paramPedestrianQueueThresholdWestEast = paramPedestrianQueueThresholdWestEast;
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdWestEast(String o) {
		this.paramPedestrianQueueThresholdWestEast = SimulationReport.staticSetParamPedestrianQueueThresholdWestEast(siteRequest_, o);
	}
	public static BigDecimal staticSetParamPedestrianQueueThresholdWestEast(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdWestEast(Double o) {
		setParamPedestrianQueueThresholdWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdWestEast(Integer o) {
		setParamPedestrianQueueThresholdWestEast(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamPedestrianQueueThresholdWestEast(Number o) {
		setParamPedestrianQueueThresholdWestEast(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramPedestrianQueueThresholdWestEastInit() {
		Wrap<BigDecimal> paramPedestrianQueueThresholdWestEastWrap = new Wrap<BigDecimal>().var("paramPedestrianQueueThresholdWestEast");
		if(paramPedestrianQueueThresholdWestEast == null) {
			_paramPedestrianQueueThresholdWestEast(paramPedestrianQueueThresholdWestEastWrap);
			Optional.ofNullable(paramPedestrianQueueThresholdWestEastWrap.getO()).ifPresent(o -> {
				setParamPedestrianQueueThresholdWestEast(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamPedestrianQueueThresholdWestEast(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamPedestrianQueueThresholdWestEast(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamPedestrianQueueThresholdWestEast(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamPedestrianQueueThresholdWestEast(siteRequest_, SimulationReport.staticSetParamPedestrianQueueThresholdWestEast(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamPedestrianQueueThresholdWestEast() {
		return paramPedestrianQueueThresholdWestEast;
	}

	//////////////////////
	// paramDemandScale //
	//////////////////////


	/**	 The entity paramDemandScale
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<BigDecimal> paramDemandScale = new ArrayList<BigDecimal>();

	/**	<br> The entity paramDemandScale
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramDemandScale">Find the entity paramDemandScale in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _paramDemandScale(List<BigDecimal> l);

	public List<BigDecimal> getParamDemandScale() {
		return paramDemandScale;
	}

	public void setParamDemandScale(List<BigDecimal> paramDemandScale) {
		this.paramDemandScale = paramDemandScale;
	}
	@JsonIgnore
	public void setParamDemandScale(String o) {
		BigDecimal l = SimulationReport.staticSetParamDemandScale(siteRequest_, o);
		if(l != null)
			addParamDemandScale(l);
	}
	public static BigDecimal staticSetParamDemandScale(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamDemandScale(Double o) {
		addParamDemandScale(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamDemandScale(Integer o) {
		addParamDemandScale(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamDemandScale(Number o) {
		addParamDemandScale(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	public SimulationReport addParamDemandScale(BigDecimal...objects) {
		for(BigDecimal o : objects) {
			addParamDemandScale(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addParamDemandScale(BigDecimal o) {
		if(o != null)
			this.paramDemandScale.add(o);
		return (SimulationReport)this;
	}
	@JsonIgnore
	public void setParamDemandScale(JsonArray objects) {
		paramDemandScale.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addParamDemandScale(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
		}
	}
	public SimulationReport addParamDemandScale(String o) {
		if(NumberUtils.isParsable(o)) {
			BigDecimal p = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
			addParamDemandScale(p);
		}
		return (SimulationReport)this;
	}
	protected SimulationReport paramDemandScaleInit() {
		_paramDemandScale(paramDemandScale);
		return (SimulationReport)this;
	}

	public static BigDecimal staticSearchParamDemandScale(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o;
	}

	public static String staticSearchStrParamDemandScale(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamDemandScale(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamDemandScale(siteRequest_, SimulationReport.staticSetParamDemandScale(siteRequest_, o)).toString();
	}

	public Number[] sqlParamDemandScale() {
		return paramDemandScale.stream().map(v -> (Number)v).toArray(Number[]::new);
	}

	/////////////////////
	// paramInitialPar //
	/////////////////////


	/**	 The entity paramInitialPar
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<BigDecimal> paramInitialPar = new ArrayList<BigDecimal>();

	/**	<br> The entity paramInitialPar
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramInitialPar">Find the entity paramInitialPar in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _paramInitialPar(List<BigDecimal> l);

	public List<BigDecimal> getParamInitialPar() {
		return paramInitialPar;
	}

	public void setParamInitialPar(List<BigDecimal> paramInitialPar) {
		this.paramInitialPar = paramInitialPar;
	}
	@JsonIgnore
	public void setParamInitialPar(String o) {
		BigDecimal l = SimulationReport.staticSetParamInitialPar(siteRequest_, o);
		if(l != null)
			addParamInitialPar(l);
	}
	public static BigDecimal staticSetParamInitialPar(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamInitialPar(Double o) {
		addParamInitialPar(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamInitialPar(Integer o) {
		addParamInitialPar(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamInitialPar(Number o) {
		addParamInitialPar(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	public SimulationReport addParamInitialPar(BigDecimal...objects) {
		for(BigDecimal o : objects) {
			addParamInitialPar(o);
		}
		return (SimulationReport)this;
	}
	public SimulationReport addParamInitialPar(BigDecimal o) {
		if(o != null)
			this.paramInitialPar.add(o);
		return (SimulationReport)this;
	}
	@JsonIgnore
	public void setParamInitialPar(JsonArray objects) {
		paramInitialPar.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addParamInitialPar(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
		}
	}
	public SimulationReport addParamInitialPar(String o) {
		if(NumberUtils.isParsable(o)) {
			BigDecimal p = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
			addParamInitialPar(p);
		}
		return (SimulationReport)this;
	}
	protected SimulationReport paramInitialParInit() {
		_paramInitialPar(paramInitialPar);
		return (SimulationReport)this;
	}

	public static BigDecimal staticSearchParamInitialPar(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o;
	}

	public static String staticSearchStrParamInitialPar(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamInitialPar(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamInitialPar(siteRequest_, SimulationReport.staticSetParamInitialPar(siteRequest_, o)).toString();
	}

	///////////////////
	// paramStepSize //
	///////////////////


	/**	 The entity paramStepSize
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal paramStepSize;

	/**	<br> The entity paramStepSize
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramStepSize">Find the entity paramStepSize in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramStepSize(Wrap<BigDecimal> w);

	public BigDecimal getParamStepSize() {
		return paramStepSize;
	}

	public void setParamStepSize(BigDecimal paramStepSize) {
		this.paramStepSize = paramStepSize;
	}
	@JsonIgnore
	public void setParamStepSize(String o) {
		this.paramStepSize = SimulationReport.staticSetParamStepSize(siteRequest_, o);
	}
	public static BigDecimal staticSetParamStepSize(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setParamStepSize(Double o) {
		setParamStepSize(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamStepSize(Integer o) {
		setParamStepSize(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setParamStepSize(Number o) {
		setParamStepSize(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected SimulationReport paramStepSizeInit() {
		Wrap<BigDecimal> paramStepSizeWrap = new Wrap<BigDecimal>().var("paramStepSize");
		if(paramStepSize == null) {
			_paramStepSize(paramStepSizeWrap);
			Optional.ofNullable(paramStepSizeWrap.getO()).ifPresent(o -> {
				setParamStepSize(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Double staticSearchParamStepSize(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrParamStepSize(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamStepSize(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamStepSize(siteRequest_, SimulationReport.staticSetParamStepSize(siteRequest_, o)).toString();
	}

	public BigDecimal sqlParamStepSize() {
		return paramStepSize;
	}

	//////////////////
	// paramRunTime //
	//////////////////


	/**	 The entity paramRunTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer paramRunTime;

	/**	<br> The entity paramRunTime
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramRunTime">Find the entity paramRunTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramRunTime(Wrap<Integer> w);

	public Integer getParamRunTime() {
		return paramRunTime;
	}

	public void setParamRunTime(Integer paramRunTime) {
		this.paramRunTime = paramRunTime;
	}
	@JsonIgnore
	public void setParamRunTime(String o) {
		this.paramRunTime = SimulationReport.staticSetParamRunTime(siteRequest_, o);
	}
	public static Integer staticSetParamRunTime(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SimulationReport paramRunTimeInit() {
		Wrap<Integer> paramRunTimeWrap = new Wrap<Integer>().var("paramRunTime");
		if(paramRunTime == null) {
			_paramRunTime(paramRunTimeWrap);
			Optional.ofNullable(paramRunTimeWrap.getO()).ifPresent(o -> {
				setParamRunTime(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Integer staticSearchParamRunTime(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrParamRunTime(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamRunTime(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamRunTime(siteRequest_, SimulationReport.staticSetParamRunTime(siteRequest_, o)).toString();
	}

	public Integer sqlParamRunTime() {
		return paramRunTime;
	}

	//////////////////////
	// paramItersPerPar //
	//////////////////////


	/**	 The entity paramItersPerPar
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer paramItersPerPar;

	/**	<br> The entity paramItersPerPar
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramItersPerPar">Find the entity paramItersPerPar in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramItersPerPar(Wrap<Integer> w);

	public Integer getParamItersPerPar() {
		return paramItersPerPar;
	}

	public void setParamItersPerPar(Integer paramItersPerPar) {
		this.paramItersPerPar = paramItersPerPar;
	}
	@JsonIgnore
	public void setParamItersPerPar(String o) {
		this.paramItersPerPar = SimulationReport.staticSetParamItersPerPar(siteRequest_, o);
	}
	public static Integer staticSetParamItersPerPar(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SimulationReport paramItersPerParInit() {
		Wrap<Integer> paramItersPerParWrap = new Wrap<Integer>().var("paramItersPerPar");
		if(paramItersPerPar == null) {
			_paramItersPerPar(paramItersPerParWrap);
			Optional.ofNullable(paramItersPerParWrap.getO()).ifPresent(o -> {
				setParamItersPerPar(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Integer staticSearchParamItersPerPar(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrParamItersPerPar(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamItersPerPar(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamItersPerPar(siteRequest_, SimulationReport.staticSetParamItersPerPar(siteRequest_, o)).toString();
	}

	public Integer sqlParamItersPerPar() {
		return paramItersPerPar;
	}

	///////////////////////
	// paramTotalIterNum //
	///////////////////////


	/**	 The entity paramTotalIterNum
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer paramTotalIterNum;

	/**	<br> The entity paramTotalIterNum
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:paramTotalIterNum">Find the entity paramTotalIterNum in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _paramTotalIterNum(Wrap<Integer> w);

	public Integer getParamTotalIterNum() {
		return paramTotalIterNum;
	}

	public void setParamTotalIterNum(Integer paramTotalIterNum) {
		this.paramTotalIterNum = paramTotalIterNum;
	}
	@JsonIgnore
	public void setParamTotalIterNum(String o) {
		this.paramTotalIterNum = SimulationReport.staticSetParamTotalIterNum(siteRequest_, o);
	}
	public static Integer staticSetParamTotalIterNum(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SimulationReport paramTotalIterNumInit() {
		Wrap<Integer> paramTotalIterNumWrap = new Wrap<Integer>().var("paramTotalIterNum");
		if(paramTotalIterNum == null) {
			_paramTotalIterNum(paramTotalIterNumWrap);
			Optional.ofNullable(paramTotalIterNumWrap.getO()).ifPresent(o -> {
				setParamTotalIterNum(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Integer staticSearchParamTotalIterNum(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrParamTotalIterNum(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParamTotalIterNum(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchParamTotalIterNum(siteRequest_, SimulationReport.staticSetParamTotalIterNum(siteRequest_, o)).toString();
	}

	public Integer sqlParamTotalIterNum() {
		return paramTotalIterNum;
	}

	///////////////////////
	// updatedParameters //
	///////////////////////


	/**	 The entity updatedParameters
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters;

	/**	<br> The entity updatedParameters
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters">Find the entity updatedParameters in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters() {
		return updatedParameters;
	}

	public void setUpdatedParameters(JsonArray updatedParameters) {
		this.updatedParameters = updatedParameters;
	}
	@JsonIgnore
	public void setUpdatedParameters(String o) {
		this.updatedParameters = SimulationReport.staticSetUpdatedParameters(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParametersInit() {
		Wrap<JsonArray> updatedParametersWrap = new Wrap<JsonArray>().var("updatedParameters");
		if(updatedParameters == null) {
			_updatedParameters(updatedParametersWrap);
			Optional.ofNullable(updatedParametersWrap.getO()).ifPresent(o -> {
				setUpdatedParameters(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters(siteRequest_, SimulationReport.staticSetUpdatedParameters(siteRequest_, o)).toString();
	}

	public JsonArray sqlUpdatedParameters() {
		return updatedParameters;
	}

	////////////////////////
	// updatedParameters1 //
	////////////////////////


	/**	 The entity updatedParameters1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters1;

	/**	<br> The entity updatedParameters1
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters1">Find the entity updatedParameters1 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters1(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters1() {
		return updatedParameters1;
	}

	public void setUpdatedParameters1(JsonArray updatedParameters1) {
		this.updatedParameters1 = updatedParameters1;
	}
	@JsonIgnore
	public void setUpdatedParameters1(String o) {
		this.updatedParameters1 = SimulationReport.staticSetUpdatedParameters1(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters1(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters1Init() {
		Wrap<JsonArray> updatedParameters1Wrap = new Wrap<JsonArray>().var("updatedParameters1");
		if(updatedParameters1 == null) {
			_updatedParameters1(updatedParameters1Wrap);
			Optional.ofNullable(updatedParameters1Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters1(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters1(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters1(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters1(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters1(siteRequest_, SimulationReport.staticSetUpdatedParameters1(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters2 //
	////////////////////////


	/**	 The entity updatedParameters2
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters2;

	/**	<br> The entity updatedParameters2
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters2">Find the entity updatedParameters2 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters2(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters2() {
		return updatedParameters2;
	}

	public void setUpdatedParameters2(JsonArray updatedParameters2) {
		this.updatedParameters2 = updatedParameters2;
	}
	@JsonIgnore
	public void setUpdatedParameters2(String o) {
		this.updatedParameters2 = SimulationReport.staticSetUpdatedParameters2(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters2(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters2Init() {
		Wrap<JsonArray> updatedParameters2Wrap = new Wrap<JsonArray>().var("updatedParameters2");
		if(updatedParameters2 == null) {
			_updatedParameters2(updatedParameters2Wrap);
			Optional.ofNullable(updatedParameters2Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters2(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters2(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters2(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters2(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters2(siteRequest_, SimulationReport.staticSetUpdatedParameters2(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters3 //
	////////////////////////


	/**	 The entity updatedParameters3
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters3;

	/**	<br> The entity updatedParameters3
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters3">Find the entity updatedParameters3 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters3(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters3() {
		return updatedParameters3;
	}

	public void setUpdatedParameters3(JsonArray updatedParameters3) {
		this.updatedParameters3 = updatedParameters3;
	}
	@JsonIgnore
	public void setUpdatedParameters3(String o) {
		this.updatedParameters3 = SimulationReport.staticSetUpdatedParameters3(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters3(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters3Init() {
		Wrap<JsonArray> updatedParameters3Wrap = new Wrap<JsonArray>().var("updatedParameters3");
		if(updatedParameters3 == null) {
			_updatedParameters3(updatedParameters3Wrap);
			Optional.ofNullable(updatedParameters3Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters3(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters3(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters3(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters3(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters3(siteRequest_, SimulationReport.staticSetUpdatedParameters3(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters4 //
	////////////////////////


	/**	 The entity updatedParameters4
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters4;

	/**	<br> The entity updatedParameters4
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters4">Find the entity updatedParameters4 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters4(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters4() {
		return updatedParameters4;
	}

	public void setUpdatedParameters4(JsonArray updatedParameters4) {
		this.updatedParameters4 = updatedParameters4;
	}
	@JsonIgnore
	public void setUpdatedParameters4(String o) {
		this.updatedParameters4 = SimulationReport.staticSetUpdatedParameters4(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters4(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters4Init() {
		Wrap<JsonArray> updatedParameters4Wrap = new Wrap<JsonArray>().var("updatedParameters4");
		if(updatedParameters4 == null) {
			_updatedParameters4(updatedParameters4Wrap);
			Optional.ofNullable(updatedParameters4Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters4(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters4(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters4(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters4(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters4(siteRequest_, SimulationReport.staticSetUpdatedParameters4(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters5 //
	////////////////////////


	/**	 The entity updatedParameters5
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters5;

	/**	<br> The entity updatedParameters5
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters5">Find the entity updatedParameters5 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters5(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters5() {
		return updatedParameters5;
	}

	public void setUpdatedParameters5(JsonArray updatedParameters5) {
		this.updatedParameters5 = updatedParameters5;
	}
	@JsonIgnore
	public void setUpdatedParameters5(String o) {
		this.updatedParameters5 = SimulationReport.staticSetUpdatedParameters5(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters5(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters5Init() {
		Wrap<JsonArray> updatedParameters5Wrap = new Wrap<JsonArray>().var("updatedParameters5");
		if(updatedParameters5 == null) {
			_updatedParameters5(updatedParameters5Wrap);
			Optional.ofNullable(updatedParameters5Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters5(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters5(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters5(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters5(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters5(siteRequest_, SimulationReport.staticSetUpdatedParameters5(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters6 //
	////////////////////////


	/**	 The entity updatedParameters6
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters6;

	/**	<br> The entity updatedParameters6
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters6">Find the entity updatedParameters6 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters6(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters6() {
		return updatedParameters6;
	}

	public void setUpdatedParameters6(JsonArray updatedParameters6) {
		this.updatedParameters6 = updatedParameters6;
	}
	@JsonIgnore
	public void setUpdatedParameters6(String o) {
		this.updatedParameters6 = SimulationReport.staticSetUpdatedParameters6(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters6(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters6Init() {
		Wrap<JsonArray> updatedParameters6Wrap = new Wrap<JsonArray>().var("updatedParameters6");
		if(updatedParameters6 == null) {
			_updatedParameters6(updatedParameters6Wrap);
			Optional.ofNullable(updatedParameters6Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters6(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters6(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters6(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters6(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters6(siteRequest_, SimulationReport.staticSetUpdatedParameters6(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters7 //
	////////////////////////


	/**	 The entity updatedParameters7
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters7;

	/**	<br> The entity updatedParameters7
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters7">Find the entity updatedParameters7 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters7(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters7() {
		return updatedParameters7;
	}

	public void setUpdatedParameters7(JsonArray updatedParameters7) {
		this.updatedParameters7 = updatedParameters7;
	}
	@JsonIgnore
	public void setUpdatedParameters7(String o) {
		this.updatedParameters7 = SimulationReport.staticSetUpdatedParameters7(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters7(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters7Init() {
		Wrap<JsonArray> updatedParameters7Wrap = new Wrap<JsonArray>().var("updatedParameters7");
		if(updatedParameters7 == null) {
			_updatedParameters7(updatedParameters7Wrap);
			Optional.ofNullable(updatedParameters7Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters7(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters7(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters7(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters7(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters7(siteRequest_, SimulationReport.staticSetUpdatedParameters7(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters8 //
	////////////////////////


	/**	 The entity updatedParameters8
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters8;

	/**	<br> The entity updatedParameters8
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters8">Find the entity updatedParameters8 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters8(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters8() {
		return updatedParameters8;
	}

	public void setUpdatedParameters8(JsonArray updatedParameters8) {
		this.updatedParameters8 = updatedParameters8;
	}
	@JsonIgnore
	public void setUpdatedParameters8(String o) {
		this.updatedParameters8 = SimulationReport.staticSetUpdatedParameters8(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters8(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters8Init() {
		Wrap<JsonArray> updatedParameters8Wrap = new Wrap<JsonArray>().var("updatedParameters8");
		if(updatedParameters8 == null) {
			_updatedParameters8(updatedParameters8Wrap);
			Optional.ofNullable(updatedParameters8Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters8(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters8(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters8(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters8(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters8(siteRequest_, SimulationReport.staticSetUpdatedParameters8(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedParameters9 //
	////////////////////////


	/**	 The entity updatedParameters9
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters9;

	/**	<br> The entity updatedParameters9
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters9">Find the entity updatedParameters9 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters9(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters9() {
		return updatedParameters9;
	}

	public void setUpdatedParameters9(JsonArray updatedParameters9) {
		this.updatedParameters9 = updatedParameters9;
	}
	@JsonIgnore
	public void setUpdatedParameters9(String o) {
		this.updatedParameters9 = SimulationReport.staticSetUpdatedParameters9(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters9(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters9Init() {
		Wrap<JsonArray> updatedParameters9Wrap = new Wrap<JsonArray>().var("updatedParameters9");
		if(updatedParameters9 == null) {
			_updatedParameters9(updatedParameters9Wrap);
			Optional.ofNullable(updatedParameters9Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters9(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters9(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters9(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters9(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters9(siteRequest_, SimulationReport.staticSetUpdatedParameters9(siteRequest_, o)).toString();
	}

	/////////////////////////
	// updatedParameters10 //
	/////////////////////////


	/**	 The entity updatedParameters10
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedParameters10;

	/**	<br> The entity updatedParameters10
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedParameters10">Find the entity updatedParameters10 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedParameters10(Wrap<JsonArray> w);

	public JsonArray getUpdatedParameters10() {
		return updatedParameters10;
	}

	public void setUpdatedParameters10(JsonArray updatedParameters10) {
		this.updatedParameters10 = updatedParameters10;
	}
	@JsonIgnore
	public void setUpdatedParameters10(String o) {
		this.updatedParameters10 = SimulationReport.staticSetUpdatedParameters10(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedParameters10(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedParameters10Init() {
		Wrap<JsonArray> updatedParameters10Wrap = new Wrap<JsonArray>().var("updatedParameters10");
		if(updatedParameters10 == null) {
			_updatedParameters10(updatedParameters10Wrap);
			Optional.ofNullable(updatedParameters10Wrap.getO()).ifPresent(o -> {
				setUpdatedParameters10(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedParameters10(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedParameters10(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedParameters10(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedParameters10(siteRequest_, SimulationReport.staticSetUpdatedParameters10(siteRequest_, o)).toString();
	}

	////////////////////////
	// updatedPerformance //
	////////////////////////


	/**	 The entity updatedPerformance
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedPerformance;

	/**	<br> The entity updatedPerformance
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedPerformance">Find the entity updatedPerformance in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedPerformance(Wrap<JsonArray> w);

	public JsonArray getUpdatedPerformance() {
		return updatedPerformance;
	}

	public void setUpdatedPerformance(JsonArray updatedPerformance) {
		this.updatedPerformance = updatedPerformance;
	}
	@JsonIgnore
	public void setUpdatedPerformance(String o) {
		this.updatedPerformance = SimulationReport.staticSetUpdatedPerformance(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedPerformance(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedPerformanceInit() {
		Wrap<JsonArray> updatedPerformanceWrap = new Wrap<JsonArray>().var("updatedPerformance");
		if(updatedPerformance == null) {
			_updatedPerformance(updatedPerformanceWrap);
			Optional.ofNullable(updatedPerformanceWrap.getO()).ifPresent(o -> {
				setUpdatedPerformance(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedPerformance(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedPerformance(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedPerformance(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedPerformance(siteRequest_, SimulationReport.staticSetUpdatedPerformance(siteRequest_, o)).toString();
	}

	public JsonArray sqlUpdatedPerformance() {
		return updatedPerformance;
	}

	////////////////////////
	// averageQueueLength //
	////////////////////////


	/**	 The entity averageQueueLength
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray averageQueueLength;

	/**	<br> The entity averageQueueLength
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:averageQueueLength">Find the entity averageQueueLength in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageQueueLength(Wrap<JsonArray> w);

	public JsonArray getAverageQueueLength() {
		return averageQueueLength;
	}

	public void setAverageQueueLength(JsonArray averageQueueLength) {
		this.averageQueueLength = averageQueueLength;
	}
	@JsonIgnore
	public void setAverageQueueLength(String o) {
		this.averageQueueLength = SimulationReport.staticSetAverageQueueLength(siteRequest_, o);
	}
	public static JsonArray staticSetAverageQueueLength(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport averageQueueLengthInit() {
		Wrap<JsonArray> averageQueueLengthWrap = new Wrap<JsonArray>().var("averageQueueLength");
		if(averageQueueLength == null) {
			_averageQueueLength(averageQueueLengthWrap);
			Optional.ofNullable(averageQueueLengthWrap.getO()).ifPresent(o -> {
				setAverageQueueLength(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchAverageQueueLength(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrAverageQueueLength(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageQueueLength(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAverageQueueLength(siteRequest_, SimulationReport.staticSetAverageQueueLength(siteRequest_, o)).toString();
	}

	public JsonArray sqlAverageQueueLength() {
		return averageQueueLength;
	}

	//////////////////////////////////////////////
	// updatedPerformanceWaitWestEastVehicleSec //
	//////////////////////////////////////////////


	/**	 The entity updatedPerformanceWaitWestEastVehicleSec
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedPerformanceWaitWestEastVehicleSec;

	/**	<br> The entity updatedPerformanceWaitWestEastVehicleSec
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedPerformanceWaitWestEastVehicleSec">Find the entity updatedPerformanceWaitWestEastVehicleSec in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedPerformanceWaitWestEastVehicleSec(Wrap<JsonArray> w);

	public JsonArray getUpdatedPerformanceWaitWestEastVehicleSec() {
		return updatedPerformanceWaitWestEastVehicleSec;
	}

	public void setUpdatedPerformanceWaitWestEastVehicleSec(JsonArray updatedPerformanceWaitWestEastVehicleSec) {
		this.updatedPerformanceWaitWestEastVehicleSec = updatedPerformanceWaitWestEastVehicleSec;
	}
	@JsonIgnore
	public void setUpdatedPerformanceWaitWestEastVehicleSec(String o) {
		this.updatedPerformanceWaitWestEastVehicleSec = SimulationReport.staticSetUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedPerformanceWaitWestEastVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedPerformanceWaitWestEastVehicleSecInit() {
		Wrap<JsonArray> updatedPerformanceWaitWestEastVehicleSecWrap = new Wrap<JsonArray>().var("updatedPerformanceWaitWestEastVehicleSec");
		if(updatedPerformanceWaitWestEastVehicleSec == null) {
			_updatedPerformanceWaitWestEastVehicleSec(updatedPerformanceWaitWestEastVehicleSecWrap);
			Optional.ofNullable(updatedPerformanceWaitWestEastVehicleSecWrap.getO()).ifPresent(o -> {
				setUpdatedPerformanceWaitWestEastVehicleSec(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedPerformanceWaitWestEastVehicleSec(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedPerformanceWaitWestEastVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedPerformanceWaitWestEastVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, SimulationReport.staticSetUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, o)).toString();
	}

	////////////////////////////////////////////////
	// updatedPerformanceWaitSouthNorthVehicleSec //
	////////////////////////////////////////////////


	/**	 The entity updatedPerformanceWaitSouthNorthVehicleSec
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedPerformanceWaitSouthNorthVehicleSec;

	/**	<br> The entity updatedPerformanceWaitSouthNorthVehicleSec
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedPerformanceWaitSouthNorthVehicleSec">Find the entity updatedPerformanceWaitSouthNorthVehicleSec in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedPerformanceWaitSouthNorthVehicleSec(Wrap<JsonArray> w);

	public JsonArray getUpdatedPerformanceWaitSouthNorthVehicleSec() {
		return updatedPerformanceWaitSouthNorthVehicleSec;
	}

	public void setUpdatedPerformanceWaitSouthNorthVehicleSec(JsonArray updatedPerformanceWaitSouthNorthVehicleSec) {
		this.updatedPerformanceWaitSouthNorthVehicleSec = updatedPerformanceWaitSouthNorthVehicleSec;
	}
	@JsonIgnore
	public void setUpdatedPerformanceWaitSouthNorthVehicleSec(String o) {
		this.updatedPerformanceWaitSouthNorthVehicleSec = SimulationReport.staticSetUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedPerformanceWaitSouthNorthVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedPerformanceWaitSouthNorthVehicleSecInit() {
		Wrap<JsonArray> updatedPerformanceWaitSouthNorthVehicleSecWrap = new Wrap<JsonArray>().var("updatedPerformanceWaitSouthNorthVehicleSec");
		if(updatedPerformanceWaitSouthNorthVehicleSec == null) {
			_updatedPerformanceWaitSouthNorthVehicleSec(updatedPerformanceWaitSouthNorthVehicleSecWrap);
			Optional.ofNullable(updatedPerformanceWaitSouthNorthVehicleSecWrap.getO()).ifPresent(o -> {
				setUpdatedPerformanceWaitSouthNorthVehicleSec(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedPerformanceWaitSouthNorthVehicleSec(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedPerformanceWaitSouthNorthVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedPerformanceWaitSouthNorthVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, SimulationReport.staticSetUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, o)).toString();
	}

	/////////////////////////////////////////
	// updatedPerformanceWaitAllVehicleSec //
	/////////////////////////////////////////


	/**	 The entity updatedPerformanceWaitAllVehicleSec
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedPerformanceWaitAllVehicleSec;

	/**	<br> The entity updatedPerformanceWaitAllVehicleSec
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedPerformanceWaitAllVehicleSec">Find the entity updatedPerformanceWaitAllVehicleSec in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedPerformanceWaitAllVehicleSec(Wrap<JsonArray> w);

	public JsonArray getUpdatedPerformanceWaitAllVehicleSec() {
		return updatedPerformanceWaitAllVehicleSec;
	}

	public void setUpdatedPerformanceWaitAllVehicleSec(JsonArray updatedPerformanceWaitAllVehicleSec) {
		this.updatedPerformanceWaitAllVehicleSec = updatedPerformanceWaitAllVehicleSec;
	}
	@JsonIgnore
	public void setUpdatedPerformanceWaitAllVehicleSec(String o) {
		this.updatedPerformanceWaitAllVehicleSec = SimulationReport.staticSetUpdatedPerformanceWaitAllVehicleSec(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedPerformanceWaitAllVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedPerformanceWaitAllVehicleSecInit() {
		Wrap<JsonArray> updatedPerformanceWaitAllVehicleSecWrap = new Wrap<JsonArray>().var("updatedPerformanceWaitAllVehicleSec");
		if(updatedPerformanceWaitAllVehicleSec == null) {
			_updatedPerformanceWaitAllVehicleSec(updatedPerformanceWaitAllVehicleSecWrap);
			Optional.ofNullable(updatedPerformanceWaitAllVehicleSecWrap.getO()).ifPresent(o -> {
				setUpdatedPerformanceWaitAllVehicleSec(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedPerformanceWaitAllVehicleSec(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedPerformanceWaitAllVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedPerformanceWaitAllVehicleSec(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedPerformanceWaitAllVehicleSec(siteRequest_, SimulationReport.staticSetUpdatedPerformanceWaitAllVehicleSec(siteRequest_, o)).toString();
	}

	////////////////////////////////////////////
	// updatedPerformanceWaitAllPedestrianSec //
	////////////////////////////////////////////


	/**	 The entity updatedPerformanceWaitAllPedestrianSec
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedPerformanceWaitAllPedestrianSec;

	/**	<br> The entity updatedPerformanceWaitAllPedestrianSec
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedPerformanceWaitAllPedestrianSec">Find the entity updatedPerformanceWaitAllPedestrianSec in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedPerformanceWaitAllPedestrianSec(Wrap<JsonArray> w);

	public JsonArray getUpdatedPerformanceWaitAllPedestrianSec() {
		return updatedPerformanceWaitAllPedestrianSec;
	}

	public void setUpdatedPerformanceWaitAllPedestrianSec(JsonArray updatedPerformanceWaitAllPedestrianSec) {
		this.updatedPerformanceWaitAllPedestrianSec = updatedPerformanceWaitAllPedestrianSec;
	}
	@JsonIgnore
	public void setUpdatedPerformanceWaitAllPedestrianSec(String o) {
		this.updatedPerformanceWaitAllPedestrianSec = SimulationReport.staticSetUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedPerformanceWaitAllPedestrianSec(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedPerformanceWaitAllPedestrianSecInit() {
		Wrap<JsonArray> updatedPerformanceWaitAllPedestrianSecWrap = new Wrap<JsonArray>().var("updatedPerformanceWaitAllPedestrianSec");
		if(updatedPerformanceWaitAllPedestrianSec == null) {
			_updatedPerformanceWaitAllPedestrianSec(updatedPerformanceWaitAllPedestrianSecWrap);
			Optional.ofNullable(updatedPerformanceWaitAllPedestrianSecWrap.getO()).ifPresent(o -> {
				setUpdatedPerformanceWaitAllPedestrianSec(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedPerformanceWaitAllPedestrianSec(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedPerformanceWaitAllPedestrianSec(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedPerformanceWaitAllPedestrianSec(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, SimulationReport.staticSetUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, o)).toString();
	}

	///////////////////////////////////////////////////
	// updatedPerformanceWaitAllVehiclePedestrianSec //
	///////////////////////////////////////////////////


	/**	 The entity updatedPerformanceWaitAllVehiclePedestrianSec
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray updatedPerformanceWaitAllVehiclePedestrianSec;

	/**	<br> The entity updatedPerformanceWaitAllVehiclePedestrianSec
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:updatedPerformanceWaitAllVehiclePedestrianSec">Find the entity updatedPerformanceWaitAllVehiclePedestrianSec in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _updatedPerformanceWaitAllVehiclePedestrianSec(Wrap<JsonArray> w);

	public JsonArray getUpdatedPerformanceWaitAllVehiclePedestrianSec() {
		return updatedPerformanceWaitAllVehiclePedestrianSec;
	}

	public void setUpdatedPerformanceWaitAllVehiclePedestrianSec(JsonArray updatedPerformanceWaitAllVehiclePedestrianSec) {
		this.updatedPerformanceWaitAllVehiclePedestrianSec = updatedPerformanceWaitAllVehiclePedestrianSec;
	}
	@JsonIgnore
	public void setUpdatedPerformanceWaitAllVehiclePedestrianSec(String o) {
		this.updatedPerformanceWaitAllVehiclePedestrianSec = SimulationReport.staticSetUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, o);
	}
	public static JsonArray staticSetUpdatedPerformanceWaitAllVehiclePedestrianSec(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport updatedPerformanceWaitAllVehiclePedestrianSecInit() {
		Wrap<JsonArray> updatedPerformanceWaitAllVehiclePedestrianSecWrap = new Wrap<JsonArray>().var("updatedPerformanceWaitAllVehiclePedestrianSec");
		if(updatedPerformanceWaitAllVehiclePedestrianSec == null) {
			_updatedPerformanceWaitAllVehiclePedestrianSec(updatedPerformanceWaitAllVehiclePedestrianSecWrap);
			Optional.ofNullable(updatedPerformanceWaitAllVehiclePedestrianSecWrap.getO()).ifPresent(o -> {
				setUpdatedPerformanceWaitAllVehiclePedestrianSec(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchUpdatedPerformanceWaitAllVehiclePedestrianSec(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUpdatedPerformanceWaitAllVehiclePedestrianSec(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUpdatedPerformanceWaitAllVehiclePedestrianSec(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, SimulationReport.staticSetUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, o)).toString();
	}

	///////////////////////////////////
	// avgQueueLengthWestEastVehicle //
	///////////////////////////////////


	/**	 The entity avgQueueLengthWestEastVehicle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray avgQueueLengthWestEastVehicle;

	/**	<br> The entity avgQueueLengthWestEastVehicle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:avgQueueLengthWestEastVehicle">Find the entity avgQueueLengthWestEastVehicle in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _avgQueueLengthWestEastVehicle(Wrap<JsonArray> w);

	public JsonArray getAvgQueueLengthWestEastVehicle() {
		return avgQueueLengthWestEastVehicle;
	}

	public void setAvgQueueLengthWestEastVehicle(JsonArray avgQueueLengthWestEastVehicle) {
		this.avgQueueLengthWestEastVehicle = avgQueueLengthWestEastVehicle;
	}
	@JsonIgnore
	public void setAvgQueueLengthWestEastVehicle(String o) {
		this.avgQueueLengthWestEastVehicle = SimulationReport.staticSetAvgQueueLengthWestEastVehicle(siteRequest_, o);
	}
	public static JsonArray staticSetAvgQueueLengthWestEastVehicle(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport avgQueueLengthWestEastVehicleInit() {
		Wrap<JsonArray> avgQueueLengthWestEastVehicleWrap = new Wrap<JsonArray>().var("avgQueueLengthWestEastVehicle");
		if(avgQueueLengthWestEastVehicle == null) {
			_avgQueueLengthWestEastVehicle(avgQueueLengthWestEastVehicleWrap);
			Optional.ofNullable(avgQueueLengthWestEastVehicleWrap.getO()).ifPresent(o -> {
				setAvgQueueLengthWestEastVehicle(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchAvgQueueLengthWestEastVehicle(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrAvgQueueLengthWestEastVehicle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAvgQueueLengthWestEastVehicle(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAvgQueueLengthWestEastVehicle(siteRequest_, SimulationReport.staticSetAvgQueueLengthWestEastVehicle(siteRequest_, o)).toString();
	}

	/////////////////////////////////////
	// avgQueueLengthSouthNorthVehicle //
	/////////////////////////////////////


	/**	 The entity avgQueueLengthSouthNorthVehicle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray avgQueueLengthSouthNorthVehicle;

	/**	<br> The entity avgQueueLengthSouthNorthVehicle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:avgQueueLengthSouthNorthVehicle">Find the entity avgQueueLengthSouthNorthVehicle in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _avgQueueLengthSouthNorthVehicle(Wrap<JsonArray> w);

	public JsonArray getAvgQueueLengthSouthNorthVehicle() {
		return avgQueueLengthSouthNorthVehicle;
	}

	public void setAvgQueueLengthSouthNorthVehicle(JsonArray avgQueueLengthSouthNorthVehicle) {
		this.avgQueueLengthSouthNorthVehicle = avgQueueLengthSouthNorthVehicle;
	}
	@JsonIgnore
	public void setAvgQueueLengthSouthNorthVehicle(String o) {
		this.avgQueueLengthSouthNorthVehicle = SimulationReport.staticSetAvgQueueLengthSouthNorthVehicle(siteRequest_, o);
	}
	public static JsonArray staticSetAvgQueueLengthSouthNorthVehicle(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport avgQueueLengthSouthNorthVehicleInit() {
		Wrap<JsonArray> avgQueueLengthSouthNorthVehicleWrap = new Wrap<JsonArray>().var("avgQueueLengthSouthNorthVehicle");
		if(avgQueueLengthSouthNorthVehicle == null) {
			_avgQueueLengthSouthNorthVehicle(avgQueueLengthSouthNorthVehicleWrap);
			Optional.ofNullable(avgQueueLengthSouthNorthVehicleWrap.getO()).ifPresent(o -> {
				setAvgQueueLengthSouthNorthVehicle(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchAvgQueueLengthSouthNorthVehicle(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrAvgQueueLengthSouthNorthVehicle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAvgQueueLengthSouthNorthVehicle(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAvgQueueLengthSouthNorthVehicle(siteRequest_, SimulationReport.staticSetAvgQueueLengthSouthNorthVehicle(siteRequest_, o)).toString();
	}

	////////////////////////////////////////
	// avgQueueLengthNorthSouthPedestrian //
	////////////////////////////////////////


	/**	 The entity avgQueueLengthNorthSouthPedestrian
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray avgQueueLengthNorthSouthPedestrian;

	/**	<br> The entity avgQueueLengthNorthSouthPedestrian
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:avgQueueLengthNorthSouthPedestrian">Find the entity avgQueueLengthNorthSouthPedestrian in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _avgQueueLengthNorthSouthPedestrian(Wrap<JsonArray> w);

	public JsonArray getAvgQueueLengthNorthSouthPedestrian() {
		return avgQueueLengthNorthSouthPedestrian;
	}

	public void setAvgQueueLengthNorthSouthPedestrian(JsonArray avgQueueLengthNorthSouthPedestrian) {
		this.avgQueueLengthNorthSouthPedestrian = avgQueueLengthNorthSouthPedestrian;
	}
	@JsonIgnore
	public void setAvgQueueLengthNorthSouthPedestrian(String o) {
		this.avgQueueLengthNorthSouthPedestrian = SimulationReport.staticSetAvgQueueLengthNorthSouthPedestrian(siteRequest_, o);
	}
	public static JsonArray staticSetAvgQueueLengthNorthSouthPedestrian(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport avgQueueLengthNorthSouthPedestrianInit() {
		Wrap<JsonArray> avgQueueLengthNorthSouthPedestrianWrap = new Wrap<JsonArray>().var("avgQueueLengthNorthSouthPedestrian");
		if(avgQueueLengthNorthSouthPedestrian == null) {
			_avgQueueLengthNorthSouthPedestrian(avgQueueLengthNorthSouthPedestrianWrap);
			Optional.ofNullable(avgQueueLengthNorthSouthPedestrianWrap.getO()).ifPresent(o -> {
				setAvgQueueLengthNorthSouthPedestrian(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchAvgQueueLengthNorthSouthPedestrian(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrAvgQueueLengthNorthSouthPedestrian(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAvgQueueLengthNorthSouthPedestrian(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAvgQueueLengthNorthSouthPedestrian(siteRequest_, SimulationReport.staticSetAvgQueueLengthNorthSouthPedestrian(siteRequest_, o)).toString();
	}

	//////////////////////////////////////
	// avgQueueLengthWestEastPedestrian //
	//////////////////////////////////////


	/**	 The entity avgQueueLengthWestEastPedestrian
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray avgQueueLengthWestEastPedestrian;

	/**	<br> The entity avgQueueLengthWestEastPedestrian
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:avgQueueLengthWestEastPedestrian">Find the entity avgQueueLengthWestEastPedestrian in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _avgQueueLengthWestEastPedestrian(Wrap<JsonArray> w);

	public JsonArray getAvgQueueLengthWestEastPedestrian() {
		return avgQueueLengthWestEastPedestrian;
	}

	public void setAvgQueueLengthWestEastPedestrian(JsonArray avgQueueLengthWestEastPedestrian) {
		this.avgQueueLengthWestEastPedestrian = avgQueueLengthWestEastPedestrian;
	}
	@JsonIgnore
	public void setAvgQueueLengthWestEastPedestrian(String o) {
		this.avgQueueLengthWestEastPedestrian = SimulationReport.staticSetAvgQueueLengthWestEastPedestrian(siteRequest_, o);
	}
	public static JsonArray staticSetAvgQueueLengthWestEastPedestrian(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected SimulationReport avgQueueLengthWestEastPedestrianInit() {
		Wrap<JsonArray> avgQueueLengthWestEastPedestrianWrap = new Wrap<JsonArray>().var("avgQueueLengthWestEastPedestrian");
		if(avgQueueLengthWestEastPedestrian == null) {
			_avgQueueLengthWestEastPedestrian(avgQueueLengthWestEastPedestrianWrap);
			Optional.ofNullable(avgQueueLengthWestEastPedestrianWrap.getO()).ifPresent(o -> {
				setAvgQueueLengthWestEastPedestrian(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchAvgQueueLengthWestEastPedestrian(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrAvgQueueLengthWestEastPedestrian(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAvgQueueLengthWestEastPedestrian(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchAvgQueueLengthWestEastPedestrian(siteRequest_, SimulationReport.staticSetAvgQueueLengthWestEastPedestrian(siteRequest_, o)).toString();
	}

	//////////////////
	// reportStatus //
	//////////////////

	public static final String reportStatusStop1_enUS = "Stop";
	public static final String reportStatusStop_enUS = reportStatusStop1_enUS;
	public static final String reportStatusStopped1_enUS = "Stopped";
	public static final String reportStatusStopped_enUS = reportStatusStopped1_enUS;
	public static final String reportStatusCompleted1_enUS = "Completed";
	public static final String reportStatusCompleted_enUS = reportStatusCompleted1_enUS;
	public static final String reportStatusRun1_enUS = "Run";
	public static final String reportStatusRun_enUS = reportStatusRun1_enUS;
	public static final String reportStatusRunning1_enUS = "Running";
	public static final String reportStatusRunning_enUS = reportStatusRunning1_enUS;
	public static final String reportStatusError1_enUS = "Error";
	public static final String reportStatusError_enUS = reportStatusError1_enUS;

	/**	 The entity reportStatus
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String reportStatus;

	/**	<br> The entity reportStatus
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:reportStatus">Find the entity reportStatus in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportStatus(Wrap<String> w);

	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String o) {
		this.reportStatus = SimulationReport.staticSetReportStatus(siteRequest_, o);
	}
	public static String staticSetReportStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SimulationReport reportStatusInit() {
		Wrap<String> reportStatusWrap = new Wrap<String>().var("reportStatus");
		if(reportStatus == null) {
			_reportStatus(reportStatusWrap);
			Optional.ofNullable(reportStatusWrap.getO()).ifPresent(o -> {
				setReportStatus(o);
			});
		}
		return (SimulationReport)this;
	}

	public static String staticSearchReportStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrReportStatus(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportStatus(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchReportStatus(siteRequest_, SimulationReport.staticSetReportStatus(siteRequest_, o)).toString();
	}

	public String sqlReportStatus() {
		return reportStatus;
	}

	////////////////////
	// reportProgress //
	////////////////////


	/**	 The entity reportProgress
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportProgress;

	/**	<br> The entity reportProgress
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.report.SimulationReport&fq=entiteVar_enUS_indexed_string:reportProgress">Find the entity reportProgress in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportProgress(Wrap<Integer> w);

	public Integer getReportProgress() {
		return reportProgress;
	}

	public void setReportProgress(Integer reportProgress) {
		this.reportProgress = reportProgress;
	}
	@JsonIgnore
	public void setReportProgress(String o) {
		this.reportProgress = SimulationReport.staticSetReportProgress(siteRequest_, o);
	}
	public static Integer staticSetReportProgress(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected SimulationReport reportProgressInit() {
		Wrap<Integer> reportProgressWrap = new Wrap<Integer>().var("reportProgress");
		if(reportProgress == null) {
			_reportProgress(reportProgressWrap);
			Optional.ofNullable(reportProgressWrap.getO()).ifPresent(o -> {
				setReportProgress(o);
			});
		}
		return (SimulationReport)this;
	}

	public static Integer staticSearchReportProgress(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrReportProgress(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportProgress(SiteRequestEnUS siteRequest_, String o) {
		return SimulationReport.staticSearchReportProgress(siteRequest_, SimulationReport.staticSetReportProgress(siteRequest_, o)).toString();
	}

	public Integer sqlReportProgress() {
		return reportProgress;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSimulationReport(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSimulationReport();
	}

	public Future<Void> promiseDeepSimulationReport() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSimulationReport(promise2);
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

	public Future<Void> promiseSimulationReport(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				reportNameInit();
				locationInit();
				simulationKeyInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			simulationSearchPromise().onSuccess(simulationSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				simulation_Init();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			observedSearchPromise().onSuccess(observedSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				areaServedColorsInit();
				areaServedTitlesInit();
				areaServedLinksInit();
				areaServedInit();
				smartTrafficLightKeyInit();
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
				simulationNameInit();
				smartTrafficLightIdInit();
				smartTrafficLightNameInit();
				paramAvgVehiclePerMinFromWestToEastInit();
				paramAvgVehiclePerMinFromSouthToNorthInit();
				paramVehicleDemandScalingFactorInit();
				paramAvgPedestrianPerMinFromWestToEastInit();
				paramAvgPedestrianPerMinFromSouthToNorthInit();
				paramPedestrianDemandScalingFactorInit();
				paramLamInit();
				paramMinGreenTimeSecWestEastInit();
				paramMaxGreenTimeSecWestEastInit();
				paramMinGreenTimeSecSouthNorthInit();
				paramMaxGreenTimeSecSouthNorthInit();
				paramPedestrianWaitThresholdSecNorthSouthInit();
				paramPedestrianWaitThresholdSecWestEastInit();
				paramVehicleQueueThresholdWestEastInit();
				paramVehicleQueueThresholdSouthNorthInit();
				paramPedestrianQueueThresholdNorthSouthInit();
				paramPedestrianQueueThresholdWestEastInit();
				paramDemandScaleInit();
				paramInitialParInit();
				paramStepSizeInit();
				paramRunTimeInit();
				paramItersPerParInit();
				paramTotalIterNumInit();
				updatedParametersInit();
				updatedParameters1Init();
				updatedParameters2Init();
				updatedParameters3Init();
				updatedParameters4Init();
				updatedParameters5Init();
				updatedParameters6Init();
				updatedParameters7Init();
				updatedParameters8Init();
				updatedParameters9Init();
				updatedParameters10Init();
				updatedPerformanceInit();
				averageQueueLengthInit();
				updatedPerformanceWaitWestEastVehicleSecInit();
				updatedPerformanceWaitSouthNorthVehicleSecInit();
				updatedPerformanceWaitAllVehicleSecInit();
				updatedPerformanceWaitAllPedestrianSecInit();
				updatedPerformanceWaitAllVehiclePedestrianSecInit();
				avgQueueLengthWestEastVehicleInit();
				avgQueueLengthSouthNorthVehicleInit();
				avgQueueLengthNorthSouthPedestrianInit();
				avgQueueLengthWestEastPedestrianInit();
				reportStatusInit();
				reportProgressInit();
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
		return promiseDeepSimulationReport(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSimulationReport(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
		if(simulationSearch != null)
			simulationSearch.setSiteRequest_(siteRequest_);
		if(observedSearch != null)
			observedSearch.setSiteRequest_(siteRequest_);
		if(smartTrafficLightSearch != null)
			smartTrafficLightSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSimulationReport(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSimulationReport(v);
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
	public Object obtainSimulationReport(String var) {
		SimulationReport oSimulationReport = (SimulationReport)this;
		switch(var) {
			case "reportName":
				return oSimulationReport.reportName;
			case "location":
				return oSimulationReport.location;
			case "simulationKey":
				return oSimulationReport.simulationKey;
			case "simulationSearch":
				return oSimulationReport.simulationSearch;
			case "simulation_":
				return oSimulationReport.simulation_;
			case "observedSearch":
				return oSimulationReport.observedSearch;
			case "areaServedColors":
				return oSimulationReport.areaServedColors;
			case "areaServedTitles":
				return oSimulationReport.areaServedTitles;
			case "areaServedLinks":
				return oSimulationReport.areaServedLinks;
			case "areaServed":
				return oSimulationReport.areaServed;
			case "smartTrafficLightKey":
				return oSimulationReport.smartTrafficLightKey;
			case "smartTrafficLightSearch":
				return oSimulationReport.smartTrafficLightSearch;
			case "smartTrafficLight_":
				return oSimulationReport.smartTrafficLight_;
			case "simulationName":
				return oSimulationReport.simulationName;
			case "smartTrafficLightId":
				return oSimulationReport.smartTrafficLightId;
			case "smartTrafficLightName":
				return oSimulationReport.smartTrafficLightName;
			case "paramAvgVehiclePerMinFromWestToEast":
				return oSimulationReport.paramAvgVehiclePerMinFromWestToEast;
			case "paramAvgVehiclePerMinFromSouthToNorth":
				return oSimulationReport.paramAvgVehiclePerMinFromSouthToNorth;
			case "paramVehicleDemandScalingFactor":
				return oSimulationReport.paramVehicleDemandScalingFactor;
			case "paramAvgPedestrianPerMinFromWestToEast":
				return oSimulationReport.paramAvgPedestrianPerMinFromWestToEast;
			case "paramAvgPedestrianPerMinFromSouthToNorth":
				return oSimulationReport.paramAvgPedestrianPerMinFromSouthToNorth;
			case "paramPedestrianDemandScalingFactor":
				return oSimulationReport.paramPedestrianDemandScalingFactor;
			case "paramLam":
				return oSimulationReport.paramLam;
			case "paramMinGreenTimeSecWestEast":
				return oSimulationReport.paramMinGreenTimeSecWestEast;
			case "paramMaxGreenTimeSecWestEast":
				return oSimulationReport.paramMaxGreenTimeSecWestEast;
			case "paramMinGreenTimeSecSouthNorth":
				return oSimulationReport.paramMinGreenTimeSecSouthNorth;
			case "paramMaxGreenTimeSecSouthNorth":
				return oSimulationReport.paramMaxGreenTimeSecSouthNorth;
			case "paramPedestrianWaitThresholdSecNorthSouth":
				return oSimulationReport.paramPedestrianWaitThresholdSecNorthSouth;
			case "paramPedestrianWaitThresholdSecWestEast":
				return oSimulationReport.paramPedestrianWaitThresholdSecWestEast;
			case "paramVehicleQueueThresholdWestEast":
				return oSimulationReport.paramVehicleQueueThresholdWestEast;
			case "paramVehicleQueueThresholdSouthNorth":
				return oSimulationReport.paramVehicleQueueThresholdSouthNorth;
			case "paramPedestrianQueueThresholdNorthSouth":
				return oSimulationReport.paramPedestrianQueueThresholdNorthSouth;
			case "paramPedestrianQueueThresholdWestEast":
				return oSimulationReport.paramPedestrianQueueThresholdWestEast;
			case "paramDemandScale":
				return oSimulationReport.paramDemandScale;
			case "paramInitialPar":
				return oSimulationReport.paramInitialPar;
			case "paramStepSize":
				return oSimulationReport.paramStepSize;
			case "paramRunTime":
				return oSimulationReport.paramRunTime;
			case "paramItersPerPar":
				return oSimulationReport.paramItersPerPar;
			case "paramTotalIterNum":
				return oSimulationReport.paramTotalIterNum;
			case "updatedParameters":
				return oSimulationReport.updatedParameters;
			case "updatedParameters1":
				return oSimulationReport.updatedParameters1;
			case "updatedParameters2":
				return oSimulationReport.updatedParameters2;
			case "updatedParameters3":
				return oSimulationReport.updatedParameters3;
			case "updatedParameters4":
				return oSimulationReport.updatedParameters4;
			case "updatedParameters5":
				return oSimulationReport.updatedParameters5;
			case "updatedParameters6":
				return oSimulationReport.updatedParameters6;
			case "updatedParameters7":
				return oSimulationReport.updatedParameters7;
			case "updatedParameters8":
				return oSimulationReport.updatedParameters8;
			case "updatedParameters9":
				return oSimulationReport.updatedParameters9;
			case "updatedParameters10":
				return oSimulationReport.updatedParameters10;
			case "updatedPerformance":
				return oSimulationReport.updatedPerformance;
			case "averageQueueLength":
				return oSimulationReport.averageQueueLength;
			case "updatedPerformanceWaitWestEastVehicleSec":
				return oSimulationReport.updatedPerformanceWaitWestEastVehicleSec;
			case "updatedPerformanceWaitSouthNorthVehicleSec":
				return oSimulationReport.updatedPerformanceWaitSouthNorthVehicleSec;
			case "updatedPerformanceWaitAllVehicleSec":
				return oSimulationReport.updatedPerformanceWaitAllVehicleSec;
			case "updatedPerformanceWaitAllPedestrianSec":
				return oSimulationReport.updatedPerformanceWaitAllPedestrianSec;
			case "updatedPerformanceWaitAllVehiclePedestrianSec":
				return oSimulationReport.updatedPerformanceWaitAllVehiclePedestrianSec;
			case "avgQueueLengthWestEastVehicle":
				return oSimulationReport.avgQueueLengthWestEastVehicle;
			case "avgQueueLengthSouthNorthVehicle":
				return oSimulationReport.avgQueueLengthSouthNorthVehicle;
			case "avgQueueLengthNorthSouthPedestrian":
				return oSimulationReport.avgQueueLengthNorthSouthPedestrian;
			case "avgQueueLengthWestEastPedestrian":
				return oSimulationReport.avgQueueLengthWestEastPedestrian;
			case "reportStatus":
				return oSimulationReport.reportStatus;
			case "reportProgress":
				return oSimulationReport.reportProgress;
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
				o = relateSimulationReport(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateSimulationReport(String var, Object val) {
		SimulationReport oSimulationReport = (SimulationReport)this;
		switch(var) {
			case "simulationKey":
				if(oSimulationReport.getSimulationKey() == null)
					oSimulationReport.setSimulationKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
				if(!saves.contains("simulationKey"))
					saves.add("simulationKey");
				return val;
			case "smartTrafficLightKey":
				if(oSimulationReport.getSmartTrafficLightKey() == null)
					oSimulationReport.setSmartTrafficLightKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
				if(!saves.contains("smartTrafficLightKey"))
					saves.add("smartTrafficLightKey");
				return val;
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSimulationReport(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSimulationReport(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportName":
			return SimulationReport.staticSetReportName(siteRequest_, o);
		case "location":
			return SimulationReport.staticSetLocation(siteRequest_, o);
		case "simulationKey":
			return SimulationReport.staticSetSimulationKey(siteRequest_, o);
		case "areaServedColors":
			return SimulationReport.staticSetAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return SimulationReport.staticSetAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return SimulationReport.staticSetAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return SimulationReport.staticSetAreaServed(siteRequest_, o);
		case "smartTrafficLightKey":
			return SimulationReport.staticSetSmartTrafficLightKey(siteRequest_, o);
		case "simulationName":
			return SimulationReport.staticSetSimulationName(siteRequest_, o);
		case "smartTrafficLightId":
			return SimulationReport.staticSetSmartTrafficLightId(siteRequest_, o);
		case "smartTrafficLightName":
			return SimulationReport.staticSetSmartTrafficLightName(siteRequest_, o);
		case "paramAvgVehiclePerMinFromWestToEast":
			return SimulationReport.staticSetParamAvgVehiclePerMinFromWestToEast(siteRequest_, o);
		case "paramAvgVehiclePerMinFromSouthToNorth":
			return SimulationReport.staticSetParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, o);
		case "paramVehicleDemandScalingFactor":
			return SimulationReport.staticSetParamVehicleDemandScalingFactor(siteRequest_, o);
		case "paramAvgPedestrianPerMinFromWestToEast":
			return SimulationReport.staticSetParamAvgPedestrianPerMinFromWestToEast(siteRequest_, o);
		case "paramAvgPedestrianPerMinFromSouthToNorth":
			return SimulationReport.staticSetParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, o);
		case "paramPedestrianDemandScalingFactor":
			return SimulationReport.staticSetParamPedestrianDemandScalingFactor(siteRequest_, o);
		case "paramLam":
			return SimulationReport.staticSetParamLam(siteRequest_, o);
		case "paramMinGreenTimeSecWestEast":
			return SimulationReport.staticSetParamMinGreenTimeSecWestEast(siteRequest_, o);
		case "paramMaxGreenTimeSecWestEast":
			return SimulationReport.staticSetParamMaxGreenTimeSecWestEast(siteRequest_, o);
		case "paramMinGreenTimeSecSouthNorth":
			return SimulationReport.staticSetParamMinGreenTimeSecSouthNorth(siteRequest_, o);
		case "paramMaxGreenTimeSecSouthNorth":
			return SimulationReport.staticSetParamMaxGreenTimeSecSouthNorth(siteRequest_, o);
		case "paramPedestrianWaitThresholdSecNorthSouth":
			return SimulationReport.staticSetParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, o);
		case "paramPedestrianWaitThresholdSecWestEast":
			return SimulationReport.staticSetParamPedestrianWaitThresholdSecWestEast(siteRequest_, o);
		case "paramVehicleQueueThresholdWestEast":
			return SimulationReport.staticSetParamVehicleQueueThresholdWestEast(siteRequest_, o);
		case "paramVehicleQueueThresholdSouthNorth":
			return SimulationReport.staticSetParamVehicleQueueThresholdSouthNorth(siteRequest_, o);
		case "paramPedestrianQueueThresholdNorthSouth":
			return SimulationReport.staticSetParamPedestrianQueueThresholdNorthSouth(siteRequest_, o);
		case "paramPedestrianQueueThresholdWestEast":
			return SimulationReport.staticSetParamPedestrianQueueThresholdWestEast(siteRequest_, o);
		case "paramDemandScale":
			return SimulationReport.staticSetParamDemandScale(siteRequest_, o);
		case "paramInitialPar":
			return SimulationReport.staticSetParamInitialPar(siteRequest_, o);
		case "paramStepSize":
			return SimulationReport.staticSetParamStepSize(siteRequest_, o);
		case "paramRunTime":
			return SimulationReport.staticSetParamRunTime(siteRequest_, o);
		case "paramItersPerPar":
			return SimulationReport.staticSetParamItersPerPar(siteRequest_, o);
		case "paramTotalIterNum":
			return SimulationReport.staticSetParamTotalIterNum(siteRequest_, o);
		case "updatedParameters":
			return SimulationReport.staticSetUpdatedParameters(siteRequest_, o);
		case "updatedParameters1":
			return SimulationReport.staticSetUpdatedParameters1(siteRequest_, o);
		case "updatedParameters2":
			return SimulationReport.staticSetUpdatedParameters2(siteRequest_, o);
		case "updatedParameters3":
			return SimulationReport.staticSetUpdatedParameters3(siteRequest_, o);
		case "updatedParameters4":
			return SimulationReport.staticSetUpdatedParameters4(siteRequest_, o);
		case "updatedParameters5":
			return SimulationReport.staticSetUpdatedParameters5(siteRequest_, o);
		case "updatedParameters6":
			return SimulationReport.staticSetUpdatedParameters6(siteRequest_, o);
		case "updatedParameters7":
			return SimulationReport.staticSetUpdatedParameters7(siteRequest_, o);
		case "updatedParameters8":
			return SimulationReport.staticSetUpdatedParameters8(siteRequest_, o);
		case "updatedParameters9":
			return SimulationReport.staticSetUpdatedParameters9(siteRequest_, o);
		case "updatedParameters10":
			return SimulationReport.staticSetUpdatedParameters10(siteRequest_, o);
		case "updatedPerformance":
			return SimulationReport.staticSetUpdatedPerformance(siteRequest_, o);
		case "averageQueueLength":
			return SimulationReport.staticSetAverageQueueLength(siteRequest_, o);
		case "updatedPerformanceWaitWestEastVehicleSec":
			return SimulationReport.staticSetUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, o);
		case "updatedPerformanceWaitSouthNorthVehicleSec":
			return SimulationReport.staticSetUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, o);
		case "updatedPerformanceWaitAllVehicleSec":
			return SimulationReport.staticSetUpdatedPerformanceWaitAllVehicleSec(siteRequest_, o);
		case "updatedPerformanceWaitAllPedestrianSec":
			return SimulationReport.staticSetUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, o);
		case "updatedPerformanceWaitAllVehiclePedestrianSec":
			return SimulationReport.staticSetUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, o);
		case "avgQueueLengthWestEastVehicle":
			return SimulationReport.staticSetAvgQueueLengthWestEastVehicle(siteRequest_, o);
		case "avgQueueLengthSouthNorthVehicle":
			return SimulationReport.staticSetAvgQueueLengthSouthNorthVehicle(siteRequest_, o);
		case "avgQueueLengthNorthSouthPedestrian":
			return SimulationReport.staticSetAvgQueueLengthNorthSouthPedestrian(siteRequest_, o);
		case "avgQueueLengthWestEastPedestrian":
			return SimulationReport.staticSetAvgQueueLengthWestEastPedestrian(siteRequest_, o);
		case "reportStatus":
			return SimulationReport.staticSetReportStatus(siteRequest_, o);
		case "reportProgress":
			return SimulationReport.staticSetReportProgress(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchSimulationReport(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchSimulationReport(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportName":
			return SimulationReport.staticSearchReportName(siteRequest_, (String)o);
		case "location":
			return SimulationReport.staticSearchLocation(siteRequest_, (Point)o);
		case "simulationKey":
			return SimulationReport.staticSearchSimulationKey(siteRequest_, (Long)o);
		case "areaServedColors":
			return SimulationReport.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return SimulationReport.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return SimulationReport.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return SimulationReport.staticSearchAreaServed(siteRequest_, (Path)o);
		case "smartTrafficLightKey":
			return SimulationReport.staticSearchSmartTrafficLightKey(siteRequest_, (Long)o);
		case "simulationName":
			return SimulationReport.staticSearchSimulationName(siteRequest_, (String)o);
		case "smartTrafficLightId":
			return SimulationReport.staticSearchSmartTrafficLightId(siteRequest_, (String)o);
		case "smartTrafficLightName":
			return SimulationReport.staticSearchSmartTrafficLightName(siteRequest_, (String)o);
		case "paramAvgVehiclePerMinFromWestToEast":
			return SimulationReport.staticSearchParamAvgVehiclePerMinFromWestToEast(siteRequest_, (BigDecimal)o);
		case "paramAvgVehiclePerMinFromSouthToNorth":
			return SimulationReport.staticSearchParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, (BigDecimal)o);
		case "paramVehicleDemandScalingFactor":
			return SimulationReport.staticSearchParamVehicleDemandScalingFactor(siteRequest_, (BigDecimal)o);
		case "paramAvgPedestrianPerMinFromWestToEast":
			return SimulationReport.staticSearchParamAvgPedestrianPerMinFromWestToEast(siteRequest_, (BigDecimal)o);
		case "paramAvgPedestrianPerMinFromSouthToNorth":
			return SimulationReport.staticSearchParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, (BigDecimal)o);
		case "paramPedestrianDemandScalingFactor":
			return SimulationReport.staticSearchParamPedestrianDemandScalingFactor(siteRequest_, (BigDecimal)o);
		case "paramLam":
			return SimulationReport.staticSearchParamLam(siteRequest_, (BigDecimal)o);
		case "paramMinGreenTimeSecWestEast":
			return SimulationReport.staticSearchParamMinGreenTimeSecWestEast(siteRequest_, (BigDecimal)o);
		case "paramMaxGreenTimeSecWestEast":
			return SimulationReport.staticSearchParamMaxGreenTimeSecWestEast(siteRequest_, (BigDecimal)o);
		case "paramMinGreenTimeSecSouthNorth":
			return SimulationReport.staticSearchParamMinGreenTimeSecSouthNorth(siteRequest_, (BigDecimal)o);
		case "paramMaxGreenTimeSecSouthNorth":
			return SimulationReport.staticSearchParamMaxGreenTimeSecSouthNorth(siteRequest_, (BigDecimal)o);
		case "paramPedestrianWaitThresholdSecNorthSouth":
			return SimulationReport.staticSearchParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, (BigDecimal)o);
		case "paramPedestrianWaitThresholdSecWestEast":
			return SimulationReport.staticSearchParamPedestrianWaitThresholdSecWestEast(siteRequest_, (BigDecimal)o);
		case "paramVehicleQueueThresholdWestEast":
			return SimulationReport.staticSearchParamVehicleQueueThresholdWestEast(siteRequest_, (BigDecimal)o);
		case "paramVehicleQueueThresholdSouthNorth":
			return SimulationReport.staticSearchParamVehicleQueueThresholdSouthNorth(siteRequest_, (BigDecimal)o);
		case "paramPedestrianQueueThresholdNorthSouth":
			return SimulationReport.staticSearchParamPedestrianQueueThresholdNorthSouth(siteRequest_, (BigDecimal)o);
		case "paramPedestrianQueueThresholdWestEast":
			return SimulationReport.staticSearchParamPedestrianQueueThresholdWestEast(siteRequest_, (BigDecimal)o);
		case "paramDemandScale":
			return SimulationReport.staticSearchParamDemandScale(siteRequest_, (BigDecimal)o);
		case "paramInitialPar":
			return SimulationReport.staticSearchParamInitialPar(siteRequest_, (BigDecimal)o);
		case "paramStepSize":
			return SimulationReport.staticSearchParamStepSize(siteRequest_, (BigDecimal)o);
		case "paramRunTime":
			return SimulationReport.staticSearchParamRunTime(siteRequest_, (Integer)o);
		case "paramItersPerPar":
			return SimulationReport.staticSearchParamItersPerPar(siteRequest_, (Integer)o);
		case "paramTotalIterNum":
			return SimulationReport.staticSearchParamTotalIterNum(siteRequest_, (Integer)o);
		case "updatedParameters":
			return SimulationReport.staticSearchUpdatedParameters(siteRequest_, (JsonArray)o);
		case "updatedParameters1":
			return SimulationReport.staticSearchUpdatedParameters1(siteRequest_, (JsonArray)o);
		case "updatedParameters2":
			return SimulationReport.staticSearchUpdatedParameters2(siteRequest_, (JsonArray)o);
		case "updatedParameters3":
			return SimulationReport.staticSearchUpdatedParameters3(siteRequest_, (JsonArray)o);
		case "updatedParameters4":
			return SimulationReport.staticSearchUpdatedParameters4(siteRequest_, (JsonArray)o);
		case "updatedParameters5":
			return SimulationReport.staticSearchUpdatedParameters5(siteRequest_, (JsonArray)o);
		case "updatedParameters6":
			return SimulationReport.staticSearchUpdatedParameters6(siteRequest_, (JsonArray)o);
		case "updatedParameters7":
			return SimulationReport.staticSearchUpdatedParameters7(siteRequest_, (JsonArray)o);
		case "updatedParameters8":
			return SimulationReport.staticSearchUpdatedParameters8(siteRequest_, (JsonArray)o);
		case "updatedParameters9":
			return SimulationReport.staticSearchUpdatedParameters9(siteRequest_, (JsonArray)o);
		case "updatedParameters10":
			return SimulationReport.staticSearchUpdatedParameters10(siteRequest_, (JsonArray)o);
		case "updatedPerformance":
			return SimulationReport.staticSearchUpdatedPerformance(siteRequest_, (JsonArray)o);
		case "averageQueueLength":
			return SimulationReport.staticSearchAverageQueueLength(siteRequest_, (JsonArray)o);
		case "updatedPerformanceWaitWestEastVehicleSec":
			return SimulationReport.staticSearchUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, (JsonArray)o);
		case "updatedPerformanceWaitSouthNorthVehicleSec":
			return SimulationReport.staticSearchUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, (JsonArray)o);
		case "updatedPerformanceWaitAllVehicleSec":
			return SimulationReport.staticSearchUpdatedPerformanceWaitAllVehicleSec(siteRequest_, (JsonArray)o);
		case "updatedPerformanceWaitAllPedestrianSec":
			return SimulationReport.staticSearchUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, (JsonArray)o);
		case "updatedPerformanceWaitAllVehiclePedestrianSec":
			return SimulationReport.staticSearchUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, (JsonArray)o);
		case "avgQueueLengthWestEastVehicle":
			return SimulationReport.staticSearchAvgQueueLengthWestEastVehicle(siteRequest_, (JsonArray)o);
		case "avgQueueLengthSouthNorthVehicle":
			return SimulationReport.staticSearchAvgQueueLengthSouthNorthVehicle(siteRequest_, (JsonArray)o);
		case "avgQueueLengthNorthSouthPedestrian":
			return SimulationReport.staticSearchAvgQueueLengthNorthSouthPedestrian(siteRequest_, (JsonArray)o);
		case "avgQueueLengthWestEastPedestrian":
			return SimulationReport.staticSearchAvgQueueLengthWestEastPedestrian(siteRequest_, (JsonArray)o);
		case "reportStatus":
			return SimulationReport.staticSearchReportStatus(siteRequest_, (String)o);
		case "reportProgress":
			return SimulationReport.staticSearchReportProgress(siteRequest_, (Integer)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrSimulationReport(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrSimulationReport(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportName":
			return SimulationReport.staticSearchStrReportName(siteRequest_, (String)o);
		case "location":
			return SimulationReport.staticSearchStrLocation(siteRequest_, (Point)o);
		case "simulationKey":
			return SimulationReport.staticSearchStrSimulationKey(siteRequest_, (Long)o);
		case "areaServedColors":
			return SimulationReport.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return SimulationReport.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return SimulationReport.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return SimulationReport.staticSearchStrAreaServed(siteRequest_, (Path)o);
		case "smartTrafficLightKey":
			return SimulationReport.staticSearchStrSmartTrafficLightKey(siteRequest_, (Long)o);
		case "simulationName":
			return SimulationReport.staticSearchStrSimulationName(siteRequest_, (String)o);
		case "smartTrafficLightId":
			return SimulationReport.staticSearchStrSmartTrafficLightId(siteRequest_, (String)o);
		case "smartTrafficLightName":
			return SimulationReport.staticSearchStrSmartTrafficLightName(siteRequest_, (String)o);
		case "paramAvgVehiclePerMinFromWestToEast":
			return SimulationReport.staticSearchStrParamAvgVehiclePerMinFromWestToEast(siteRequest_, (Double)o);
		case "paramAvgVehiclePerMinFromSouthToNorth":
			return SimulationReport.staticSearchStrParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, (Double)o);
		case "paramVehicleDemandScalingFactor":
			return SimulationReport.staticSearchStrParamVehicleDemandScalingFactor(siteRequest_, (Double)o);
		case "paramAvgPedestrianPerMinFromWestToEast":
			return SimulationReport.staticSearchStrParamAvgPedestrianPerMinFromWestToEast(siteRequest_, (Double)o);
		case "paramAvgPedestrianPerMinFromSouthToNorth":
			return SimulationReport.staticSearchStrParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, (Double)o);
		case "paramPedestrianDemandScalingFactor":
			return SimulationReport.staticSearchStrParamPedestrianDemandScalingFactor(siteRequest_, (Double)o);
		case "paramLam":
			return SimulationReport.staticSearchStrParamLam(siteRequest_, (BigDecimal)o);
		case "paramMinGreenTimeSecWestEast":
			return SimulationReport.staticSearchStrParamMinGreenTimeSecWestEast(siteRequest_, (Double)o);
		case "paramMaxGreenTimeSecWestEast":
			return SimulationReport.staticSearchStrParamMaxGreenTimeSecWestEast(siteRequest_, (Double)o);
		case "paramMinGreenTimeSecSouthNorth":
			return SimulationReport.staticSearchStrParamMinGreenTimeSecSouthNorth(siteRequest_, (Double)o);
		case "paramMaxGreenTimeSecSouthNorth":
			return SimulationReport.staticSearchStrParamMaxGreenTimeSecSouthNorth(siteRequest_, (Double)o);
		case "paramPedestrianWaitThresholdSecNorthSouth":
			return SimulationReport.staticSearchStrParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, (Double)o);
		case "paramPedestrianWaitThresholdSecWestEast":
			return SimulationReport.staticSearchStrParamPedestrianWaitThresholdSecWestEast(siteRequest_, (Double)o);
		case "paramVehicleQueueThresholdWestEast":
			return SimulationReport.staticSearchStrParamVehicleQueueThresholdWestEast(siteRequest_, (Double)o);
		case "paramVehicleQueueThresholdSouthNorth":
			return SimulationReport.staticSearchStrParamVehicleQueueThresholdSouthNorth(siteRequest_, (Double)o);
		case "paramPedestrianQueueThresholdNorthSouth":
			return SimulationReport.staticSearchStrParamPedestrianQueueThresholdNorthSouth(siteRequest_, (Double)o);
		case "paramPedestrianQueueThresholdWestEast":
			return SimulationReport.staticSearchStrParamPedestrianQueueThresholdWestEast(siteRequest_, (Double)o);
		case "paramDemandScale":
			return SimulationReport.staticSearchStrParamDemandScale(siteRequest_, (BigDecimal)o);
		case "paramInitialPar":
			return SimulationReport.staticSearchStrParamInitialPar(siteRequest_, (BigDecimal)o);
		case "paramStepSize":
			return SimulationReport.staticSearchStrParamStepSize(siteRequest_, (Double)o);
		case "paramRunTime":
			return SimulationReport.staticSearchStrParamRunTime(siteRequest_, (Integer)o);
		case "paramItersPerPar":
			return SimulationReport.staticSearchStrParamItersPerPar(siteRequest_, (Integer)o);
		case "paramTotalIterNum":
			return SimulationReport.staticSearchStrParamTotalIterNum(siteRequest_, (Integer)o);
		case "updatedParameters":
			return SimulationReport.staticSearchStrUpdatedParameters(siteRequest_, (String)o);
		case "updatedParameters1":
			return SimulationReport.staticSearchStrUpdatedParameters1(siteRequest_, (String)o);
		case "updatedParameters2":
			return SimulationReport.staticSearchStrUpdatedParameters2(siteRequest_, (String)o);
		case "updatedParameters3":
			return SimulationReport.staticSearchStrUpdatedParameters3(siteRequest_, (String)o);
		case "updatedParameters4":
			return SimulationReport.staticSearchStrUpdatedParameters4(siteRequest_, (String)o);
		case "updatedParameters5":
			return SimulationReport.staticSearchStrUpdatedParameters5(siteRequest_, (String)o);
		case "updatedParameters6":
			return SimulationReport.staticSearchStrUpdatedParameters6(siteRequest_, (String)o);
		case "updatedParameters7":
			return SimulationReport.staticSearchStrUpdatedParameters7(siteRequest_, (String)o);
		case "updatedParameters8":
			return SimulationReport.staticSearchStrUpdatedParameters8(siteRequest_, (String)o);
		case "updatedParameters9":
			return SimulationReport.staticSearchStrUpdatedParameters9(siteRequest_, (String)o);
		case "updatedParameters10":
			return SimulationReport.staticSearchStrUpdatedParameters10(siteRequest_, (String)o);
		case "updatedPerformance":
			return SimulationReport.staticSearchStrUpdatedPerformance(siteRequest_, (String)o);
		case "averageQueueLength":
			return SimulationReport.staticSearchStrAverageQueueLength(siteRequest_, (String)o);
		case "updatedPerformanceWaitWestEastVehicleSec":
			return SimulationReport.staticSearchStrUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, (String)o);
		case "updatedPerformanceWaitSouthNorthVehicleSec":
			return SimulationReport.staticSearchStrUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, (String)o);
		case "updatedPerformanceWaitAllVehicleSec":
			return SimulationReport.staticSearchStrUpdatedPerformanceWaitAllVehicleSec(siteRequest_, (String)o);
		case "updatedPerformanceWaitAllPedestrianSec":
			return SimulationReport.staticSearchStrUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, (String)o);
		case "updatedPerformanceWaitAllVehiclePedestrianSec":
			return SimulationReport.staticSearchStrUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, (String)o);
		case "avgQueueLengthWestEastVehicle":
			return SimulationReport.staticSearchStrAvgQueueLengthWestEastVehicle(siteRequest_, (String)o);
		case "avgQueueLengthSouthNorthVehicle":
			return SimulationReport.staticSearchStrAvgQueueLengthSouthNorthVehicle(siteRequest_, (String)o);
		case "avgQueueLengthNorthSouthPedestrian":
			return SimulationReport.staticSearchStrAvgQueueLengthNorthSouthPedestrian(siteRequest_, (String)o);
		case "avgQueueLengthWestEastPedestrian":
			return SimulationReport.staticSearchStrAvgQueueLengthWestEastPedestrian(siteRequest_, (String)o);
		case "reportStatus":
			return SimulationReport.staticSearchStrReportStatus(siteRequest_, (String)o);
		case "reportProgress":
			return SimulationReport.staticSearchStrReportProgress(siteRequest_, (Integer)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqSimulationReport(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqSimulationReport(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportName":
			return SimulationReport.staticSearchFqReportName(siteRequest_, o);
		case "location":
			return SimulationReport.staticSearchFqLocation(siteRequest_, o);
		case "simulationKey":
			return SimulationReport.staticSearchFqSimulationKey(siteRequest_, o);
		case "areaServedColors":
			return SimulationReport.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return SimulationReport.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return SimulationReport.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return SimulationReport.staticSearchFqAreaServed(siteRequest_, o);
		case "smartTrafficLightKey":
			return SimulationReport.staticSearchFqSmartTrafficLightKey(siteRequest_, o);
		case "simulationName":
			return SimulationReport.staticSearchFqSimulationName(siteRequest_, o);
		case "smartTrafficLightId":
			return SimulationReport.staticSearchFqSmartTrafficLightId(siteRequest_, o);
		case "smartTrafficLightName":
			return SimulationReport.staticSearchFqSmartTrafficLightName(siteRequest_, o);
		case "paramAvgVehiclePerMinFromWestToEast":
			return SimulationReport.staticSearchFqParamAvgVehiclePerMinFromWestToEast(siteRequest_, o);
		case "paramAvgVehiclePerMinFromSouthToNorth":
			return SimulationReport.staticSearchFqParamAvgVehiclePerMinFromSouthToNorth(siteRequest_, o);
		case "paramVehicleDemandScalingFactor":
			return SimulationReport.staticSearchFqParamVehicleDemandScalingFactor(siteRequest_, o);
		case "paramAvgPedestrianPerMinFromWestToEast":
			return SimulationReport.staticSearchFqParamAvgPedestrianPerMinFromWestToEast(siteRequest_, o);
		case "paramAvgPedestrianPerMinFromSouthToNorth":
			return SimulationReport.staticSearchFqParamAvgPedestrianPerMinFromSouthToNorth(siteRequest_, o);
		case "paramPedestrianDemandScalingFactor":
			return SimulationReport.staticSearchFqParamPedestrianDemandScalingFactor(siteRequest_, o);
		case "paramLam":
			return SimulationReport.staticSearchFqParamLam(siteRequest_, o);
		case "paramMinGreenTimeSecWestEast":
			return SimulationReport.staticSearchFqParamMinGreenTimeSecWestEast(siteRequest_, o);
		case "paramMaxGreenTimeSecWestEast":
			return SimulationReport.staticSearchFqParamMaxGreenTimeSecWestEast(siteRequest_, o);
		case "paramMinGreenTimeSecSouthNorth":
			return SimulationReport.staticSearchFqParamMinGreenTimeSecSouthNorth(siteRequest_, o);
		case "paramMaxGreenTimeSecSouthNorth":
			return SimulationReport.staticSearchFqParamMaxGreenTimeSecSouthNorth(siteRequest_, o);
		case "paramPedestrianWaitThresholdSecNorthSouth":
			return SimulationReport.staticSearchFqParamPedestrianWaitThresholdSecNorthSouth(siteRequest_, o);
		case "paramPedestrianWaitThresholdSecWestEast":
			return SimulationReport.staticSearchFqParamPedestrianWaitThresholdSecWestEast(siteRequest_, o);
		case "paramVehicleQueueThresholdWestEast":
			return SimulationReport.staticSearchFqParamVehicleQueueThresholdWestEast(siteRequest_, o);
		case "paramVehicleQueueThresholdSouthNorth":
			return SimulationReport.staticSearchFqParamVehicleQueueThresholdSouthNorth(siteRequest_, o);
		case "paramPedestrianQueueThresholdNorthSouth":
			return SimulationReport.staticSearchFqParamPedestrianQueueThresholdNorthSouth(siteRequest_, o);
		case "paramPedestrianQueueThresholdWestEast":
			return SimulationReport.staticSearchFqParamPedestrianQueueThresholdWestEast(siteRequest_, o);
		case "paramDemandScale":
			return SimulationReport.staticSearchFqParamDemandScale(siteRequest_, o);
		case "paramInitialPar":
			return SimulationReport.staticSearchFqParamInitialPar(siteRequest_, o);
		case "paramStepSize":
			return SimulationReport.staticSearchFqParamStepSize(siteRequest_, o);
		case "paramRunTime":
			return SimulationReport.staticSearchFqParamRunTime(siteRequest_, o);
		case "paramItersPerPar":
			return SimulationReport.staticSearchFqParamItersPerPar(siteRequest_, o);
		case "paramTotalIterNum":
			return SimulationReport.staticSearchFqParamTotalIterNum(siteRequest_, o);
		case "updatedParameters":
			return SimulationReport.staticSearchFqUpdatedParameters(siteRequest_, o);
		case "updatedParameters1":
			return SimulationReport.staticSearchFqUpdatedParameters1(siteRequest_, o);
		case "updatedParameters2":
			return SimulationReport.staticSearchFqUpdatedParameters2(siteRequest_, o);
		case "updatedParameters3":
			return SimulationReport.staticSearchFqUpdatedParameters3(siteRequest_, o);
		case "updatedParameters4":
			return SimulationReport.staticSearchFqUpdatedParameters4(siteRequest_, o);
		case "updatedParameters5":
			return SimulationReport.staticSearchFqUpdatedParameters5(siteRequest_, o);
		case "updatedParameters6":
			return SimulationReport.staticSearchFqUpdatedParameters6(siteRequest_, o);
		case "updatedParameters7":
			return SimulationReport.staticSearchFqUpdatedParameters7(siteRequest_, o);
		case "updatedParameters8":
			return SimulationReport.staticSearchFqUpdatedParameters8(siteRequest_, o);
		case "updatedParameters9":
			return SimulationReport.staticSearchFqUpdatedParameters9(siteRequest_, o);
		case "updatedParameters10":
			return SimulationReport.staticSearchFqUpdatedParameters10(siteRequest_, o);
		case "updatedPerformance":
			return SimulationReport.staticSearchFqUpdatedPerformance(siteRequest_, o);
		case "averageQueueLength":
			return SimulationReport.staticSearchFqAverageQueueLength(siteRequest_, o);
		case "updatedPerformanceWaitWestEastVehicleSec":
			return SimulationReport.staticSearchFqUpdatedPerformanceWaitWestEastVehicleSec(siteRequest_, o);
		case "updatedPerformanceWaitSouthNorthVehicleSec":
			return SimulationReport.staticSearchFqUpdatedPerformanceWaitSouthNorthVehicleSec(siteRequest_, o);
		case "updatedPerformanceWaitAllVehicleSec":
			return SimulationReport.staticSearchFqUpdatedPerformanceWaitAllVehicleSec(siteRequest_, o);
		case "updatedPerformanceWaitAllPedestrianSec":
			return SimulationReport.staticSearchFqUpdatedPerformanceWaitAllPedestrianSec(siteRequest_, o);
		case "updatedPerformanceWaitAllVehiclePedestrianSec":
			return SimulationReport.staticSearchFqUpdatedPerformanceWaitAllVehiclePedestrianSec(siteRequest_, o);
		case "avgQueueLengthWestEastVehicle":
			return SimulationReport.staticSearchFqAvgQueueLengthWestEastVehicle(siteRequest_, o);
		case "avgQueueLengthSouthNorthVehicle":
			return SimulationReport.staticSearchFqAvgQueueLengthSouthNorthVehicle(siteRequest_, o);
		case "avgQueueLengthNorthSouthPedestrian":
			return SimulationReport.staticSearchFqAvgQueueLengthNorthSouthPedestrian(siteRequest_, o);
		case "avgQueueLengthWestEastPedestrian":
			return SimulationReport.staticSearchFqAvgQueueLengthWestEastPedestrian(siteRequest_, o);
		case "reportStatus":
			return SimulationReport.staticSearchFqReportStatus(siteRequest_, o);
		case "reportProgress":
			return SimulationReport.staticSearchFqReportProgress(siteRequest_, o);
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
					o = persistSimulationReport(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistSimulationReport(String var, Object val) {
		String varLower = var.toLowerCase();
			if("reportname".equals(varLower)) {
				if(val instanceof String) {
					setReportName((String)val);
				}
				saves.add("reportName");
				return val;
			} else if("location".equals(varLower)) {
				if(val instanceof String) {
					setLocation((String)val);
				} else if(val instanceof Point) {
					setLocation((Point)val);
				}
				saves.add("location");
				return val;
			} else if("simulationkey".equals(varLower)) {
				if(val instanceof Long) {
					setSimulationKey((Long)val);
				} else {
					setSimulationKey(val == null ? null : val.toString());
				}
				saves.add("simulationKey");
				return val;
			} else if("smarttrafficlightkey".equals(varLower)) {
				if(val instanceof Long) {
					setSmartTrafficLightKey((Long)val);
				} else {
					setSmartTrafficLightKey(val == null ? null : val.toString());
				}
				saves.add("smartTrafficLightKey");
				return val;
			} else if("simulationname".equals(varLower)) {
				if(val instanceof String) {
					setSimulationName((String)val);
				}
				saves.add("simulationName");
				return val;
			} else if("smarttrafficlightid".equals(varLower)) {
				if(val instanceof String) {
					setSmartTrafficLightId((String)val);
				}
				saves.add("smartTrafficLightId");
				return val;
			} else if("smarttrafficlightname".equals(varLower)) {
				if(val instanceof String) {
					setSmartTrafficLightName((String)val);
				}
				saves.add("smartTrafficLightName");
				return val;
			} else if("paramavgvehicleperminfromwesttoeast".equals(varLower)) {
				if(val instanceof String) {
					setParamAvgVehiclePerMinFromWestToEast((String)val);
				} else if(val instanceof Number) {
					setParamAvgVehiclePerMinFromWestToEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramAvgVehiclePerMinFromWestToEast");
				return val;
			} else if("paramavgvehicleperminfromsouthtonorth".equals(varLower)) {
				if(val instanceof String) {
					setParamAvgVehiclePerMinFromSouthToNorth((String)val);
				} else if(val instanceof Number) {
					setParamAvgVehiclePerMinFromSouthToNorth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramAvgVehiclePerMinFromSouthToNorth");
				return val;
			} else if("paramvehicledemandscalingfactor".equals(varLower)) {
				if(val instanceof String) {
					setParamVehicleDemandScalingFactor((String)val);
				} else if(val instanceof Number) {
					setParamVehicleDemandScalingFactor(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramVehicleDemandScalingFactor");
				return val;
			} else if("paramavgpedestrianperminfromwesttoeast".equals(varLower)) {
				if(val instanceof String) {
					setParamAvgPedestrianPerMinFromWestToEast((String)val);
				} else if(val instanceof Number) {
					setParamAvgPedestrianPerMinFromWestToEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramAvgPedestrianPerMinFromWestToEast");
				return val;
			} else if("paramavgpedestrianperminfromsouthtonorth".equals(varLower)) {
				if(val instanceof String) {
					setParamAvgPedestrianPerMinFromSouthToNorth((String)val);
				} else if(val instanceof Number) {
					setParamAvgPedestrianPerMinFromSouthToNorth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramAvgPedestrianPerMinFromSouthToNorth");
				return val;
			} else if("parampedestriandemandscalingfactor".equals(varLower)) {
				if(val instanceof String) {
					setParamPedestrianDemandScalingFactor((String)val);
				} else if(val instanceof Number) {
					setParamPedestrianDemandScalingFactor(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramPedestrianDemandScalingFactor");
				return val;
			} else if("parammingreentimesecwesteast".equals(varLower)) {
				if(val instanceof String) {
					setParamMinGreenTimeSecWestEast((String)val);
				} else if(val instanceof Number) {
					setParamMinGreenTimeSecWestEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramMinGreenTimeSecWestEast");
				return val;
			} else if("parammaxgreentimesecwesteast".equals(varLower)) {
				if(val instanceof String) {
					setParamMaxGreenTimeSecWestEast((String)val);
				} else if(val instanceof Number) {
					setParamMaxGreenTimeSecWestEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramMaxGreenTimeSecWestEast");
				return val;
			} else if("parammingreentimesecsouthnorth".equals(varLower)) {
				if(val instanceof String) {
					setParamMinGreenTimeSecSouthNorth((String)val);
				} else if(val instanceof Number) {
					setParamMinGreenTimeSecSouthNorth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramMinGreenTimeSecSouthNorth");
				return val;
			} else if("parammaxgreentimesecsouthnorth".equals(varLower)) {
				if(val instanceof String) {
					setParamMaxGreenTimeSecSouthNorth((String)val);
				} else if(val instanceof Number) {
					setParamMaxGreenTimeSecSouthNorth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramMaxGreenTimeSecSouthNorth");
				return val;
			} else if("parampedestrianwaitthresholdsecnorthsouth".equals(varLower)) {
				if(val instanceof String) {
					setParamPedestrianWaitThresholdSecNorthSouth((String)val);
				} else if(val instanceof Number) {
					setParamPedestrianWaitThresholdSecNorthSouth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramPedestrianWaitThresholdSecNorthSouth");
				return val;
			} else if("parampedestrianwaitthresholdsecwesteast".equals(varLower)) {
				if(val instanceof String) {
					setParamPedestrianWaitThresholdSecWestEast((String)val);
				} else if(val instanceof Number) {
					setParamPedestrianWaitThresholdSecWestEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramPedestrianWaitThresholdSecWestEast");
				return val;
			} else if("paramvehiclequeuethresholdwesteast".equals(varLower)) {
				if(val instanceof String) {
					setParamVehicleQueueThresholdWestEast((String)val);
				} else if(val instanceof Number) {
					setParamVehicleQueueThresholdWestEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramVehicleQueueThresholdWestEast");
				return val;
			} else if("paramvehiclequeuethresholdsouthnorth".equals(varLower)) {
				if(val instanceof String) {
					setParamVehicleQueueThresholdSouthNorth((String)val);
				} else if(val instanceof Number) {
					setParamVehicleQueueThresholdSouthNorth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramVehicleQueueThresholdSouthNorth");
				return val;
			} else if("parampedestrianqueuethresholdnorthsouth".equals(varLower)) {
				if(val instanceof String) {
					setParamPedestrianQueueThresholdNorthSouth((String)val);
				} else if(val instanceof Number) {
					setParamPedestrianQueueThresholdNorthSouth(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramPedestrianQueueThresholdNorthSouth");
				return val;
			} else if("parampedestrianqueuethresholdwesteast".equals(varLower)) {
				if(val instanceof String) {
					setParamPedestrianQueueThresholdWestEast((String)val);
				} else if(val instanceof Number) {
					setParamPedestrianQueueThresholdWestEast(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramPedestrianQueueThresholdWestEast");
				return val;
			} else if("paramdemandscale".equals(varLower)) {
				if(val instanceof List<?>) {
					((List<BigDecimal>)val).stream().forEach(v -> addParamDemandScale(v));
				} else if(val instanceof JsonArray) {
					((JsonArray)val).stream().forEach(v -> addParamDemandScale(staticSetParamDemandScale(siteRequest_, v.toString())));
				} else if(val instanceof BigDecimal[]) {
					Arrays.asList((BigDecimal[])val).stream().forEach(v -> addParamDemandScale((BigDecimal)v));
				} else if(val instanceof Number[]) {
					Arrays.asList((Number[])val).stream().forEach(v -> setParamDemandScale((Number)v));
				}
				if(!saves.contains("paramDemandScale")) {
					saves.add("paramDemandScale");
				}
				return val;
			} else if("paramstepsize".equals(varLower)) {
				if(val instanceof String) {
					setParamStepSize((String)val);
				} else if(val instanceof Number) {
					setParamStepSize(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("paramStepSize");
				return val;
			} else if("paramruntime".equals(varLower)) {
				if(val instanceof Integer) {
					setParamRunTime((Integer)val);
				} else {
					setParamRunTime(val == null ? null : val.toString());
				}
				saves.add("paramRunTime");
				return val;
			} else if("paramitersperpar".equals(varLower)) {
				if(val instanceof Integer) {
					setParamItersPerPar((Integer)val);
				} else {
					setParamItersPerPar(val == null ? null : val.toString());
				}
				saves.add("paramItersPerPar");
				return val;
			} else if("paramtotaliternum".equals(varLower)) {
				if(val instanceof Integer) {
					setParamTotalIterNum((Integer)val);
				} else {
					setParamTotalIterNum(val == null ? null : val.toString());
				}
				saves.add("paramTotalIterNum");
				return val;
			} else if("updatedparameters".equals(varLower)) {
				if(val instanceof String) {
					setUpdatedParameters((String)val);
				} else if(val instanceof JsonArray) {
					setUpdatedParameters((JsonArray)val);
				}
				saves.add("updatedParameters");
				return val;
			} else if("updatedperformance".equals(varLower)) {
				if(val instanceof String) {
					setUpdatedPerformance((String)val);
				} else if(val instanceof JsonArray) {
					setUpdatedPerformance((JsonArray)val);
				}
				saves.add("updatedPerformance");
				return val;
			} else if("averagequeuelength".equals(varLower)) {
				if(val instanceof String) {
					setAverageQueueLength((String)val);
				} else if(val instanceof JsonArray) {
					setAverageQueueLength((JsonArray)val);
				}
				saves.add("averageQueueLength");
				return val;
			} else if("reportstatus".equals(varLower)) {
				if(val instanceof String) {
					setReportStatus((String)val);
				}
				saves.add("reportStatus");
				return val;
			} else if("reportprogress".equals(varLower)) {
				if(val instanceof Integer) {
					setReportProgress((Integer)val);
				} else {
					setReportProgress(val == null ? null : val.toString());
				}
				saves.add("reportProgress");
				return val;
		} else {
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateSimulationReport(doc);
	}
	public void populateSimulationReport(SolrResponse.Doc doc) {
		SimulationReport oSimulationReport = (SimulationReport)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("reportName")) {
				String reportName = (String)doc.get("reportName_docvalues_string");
				if(reportName != null)
					oSimulationReport.setReportName(reportName);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oSimulationReport.setLocation(location);
			}

			Long simulationKey = (Long)doc.get("simulationKey_docvalues_long");
			if(simulationKey != null)
				oSimulationReport.setSimulationKey(simulationKey);

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null)
					oSimulationReport.areaServedColors.addAll(areaServedColors);
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null)
					oSimulationReport.areaServedTitles.addAll(areaServedTitles);
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null)
					oSimulationReport.areaServedLinks.addAll(areaServedLinks);
			}

			if(saves.contains("areaServed")) {
				List<Path> areaServed = (List<Path>)doc.get("areaServed_docvalues_strings");
				if(areaServed != null)
					oSimulationReport.areaServed.addAll(areaServed);
			}

			Long smartTrafficLightKey = (Long)doc.get("smartTrafficLightKey_docvalues_long");
			if(smartTrafficLightKey != null)
				oSimulationReport.setSmartTrafficLightKey(smartTrafficLightKey);

			if(saves.contains("simulationName")) {
				String simulationName = (String)doc.get("simulationName_docvalues_string");
				if(simulationName != null)
					oSimulationReport.setSimulationName(simulationName);
			}

			if(saves.contains("smartTrafficLightId")) {
				String smartTrafficLightId = (String)doc.get("smartTrafficLightId_docvalues_string");
				if(smartTrafficLightId != null)
					oSimulationReport.setSmartTrafficLightId(smartTrafficLightId);
			}

			if(saves.contains("smartTrafficLightName")) {
				String smartTrafficLightName = (String)doc.get("smartTrafficLightName_docvalues_string");
				if(smartTrafficLightName != null)
					oSimulationReport.setSmartTrafficLightName(smartTrafficLightName);
			}

			if(saves.contains("paramAvgVehiclePerMinFromWestToEast")) {
				Double paramAvgVehiclePerMinFromWestToEast = (Double)doc.get("paramAvgVehiclePerMinFromWestToEast_docvalues_double");
				if(paramAvgVehiclePerMinFromWestToEast != null)
					oSimulationReport.setParamAvgVehiclePerMinFromWestToEast(paramAvgVehiclePerMinFromWestToEast);
			}

			if(saves.contains("paramAvgVehiclePerMinFromSouthToNorth")) {
				Double paramAvgVehiclePerMinFromSouthToNorth = (Double)doc.get("paramAvgVehiclePerMinFromSouthToNorth_docvalues_double");
				if(paramAvgVehiclePerMinFromSouthToNorth != null)
					oSimulationReport.setParamAvgVehiclePerMinFromSouthToNorth(paramAvgVehiclePerMinFromSouthToNorth);
			}

			if(saves.contains("paramVehicleDemandScalingFactor")) {
				Double paramVehicleDemandScalingFactor = (Double)doc.get("paramVehicleDemandScalingFactor_docvalues_double");
				if(paramVehicleDemandScalingFactor != null)
					oSimulationReport.setParamVehicleDemandScalingFactor(paramVehicleDemandScalingFactor);
			}

			if(saves.contains("paramAvgPedestrianPerMinFromWestToEast")) {
				Double paramAvgPedestrianPerMinFromWestToEast = (Double)doc.get("paramAvgPedestrianPerMinFromWestToEast_docvalues_double");
				if(paramAvgPedestrianPerMinFromWestToEast != null)
					oSimulationReport.setParamAvgPedestrianPerMinFromWestToEast(paramAvgPedestrianPerMinFromWestToEast);
			}

			if(saves.contains("paramAvgPedestrianPerMinFromSouthToNorth")) {
				Double paramAvgPedestrianPerMinFromSouthToNorth = (Double)doc.get("paramAvgPedestrianPerMinFromSouthToNorth_docvalues_double");
				if(paramAvgPedestrianPerMinFromSouthToNorth != null)
					oSimulationReport.setParamAvgPedestrianPerMinFromSouthToNorth(paramAvgPedestrianPerMinFromSouthToNorth);
			}

			if(saves.contains("paramPedestrianDemandScalingFactor")) {
				Double paramPedestrianDemandScalingFactor = (Double)doc.get("paramPedestrianDemandScalingFactor_docvalues_double");
				if(paramPedestrianDemandScalingFactor != null)
					oSimulationReport.setParamPedestrianDemandScalingFactor(paramPedestrianDemandScalingFactor);
			}

			if(saves.contains("paramLam")) {
				List<BigDecimal> paramLam = (List<BigDecimal>)doc.get("paramLam_docvalues_doubles");
				if(paramLam != null)
					oSimulationReport.paramLam.addAll(paramLam);
			}

			if(saves.contains("paramMinGreenTimeSecWestEast")) {
				Double paramMinGreenTimeSecWestEast = (Double)doc.get("paramMinGreenTimeSecWestEast_docvalues_double");
				if(paramMinGreenTimeSecWestEast != null)
					oSimulationReport.setParamMinGreenTimeSecWestEast(paramMinGreenTimeSecWestEast);
			}

			if(saves.contains("paramMaxGreenTimeSecWestEast")) {
				Double paramMaxGreenTimeSecWestEast = (Double)doc.get("paramMaxGreenTimeSecWestEast_docvalues_double");
				if(paramMaxGreenTimeSecWestEast != null)
					oSimulationReport.setParamMaxGreenTimeSecWestEast(paramMaxGreenTimeSecWestEast);
			}

			if(saves.contains("paramMinGreenTimeSecSouthNorth")) {
				Double paramMinGreenTimeSecSouthNorth = (Double)doc.get("paramMinGreenTimeSecSouthNorth_docvalues_double");
				if(paramMinGreenTimeSecSouthNorth != null)
					oSimulationReport.setParamMinGreenTimeSecSouthNorth(paramMinGreenTimeSecSouthNorth);
			}

			if(saves.contains("paramMaxGreenTimeSecSouthNorth")) {
				Double paramMaxGreenTimeSecSouthNorth = (Double)doc.get("paramMaxGreenTimeSecSouthNorth_docvalues_double");
				if(paramMaxGreenTimeSecSouthNorth != null)
					oSimulationReport.setParamMaxGreenTimeSecSouthNorth(paramMaxGreenTimeSecSouthNorth);
			}

			if(saves.contains("paramPedestrianWaitThresholdSecNorthSouth")) {
				Double paramPedestrianWaitThresholdSecNorthSouth = (Double)doc.get("paramPedestrianWaitThresholdSecNorthSouth_docvalues_double");
				if(paramPedestrianWaitThresholdSecNorthSouth != null)
					oSimulationReport.setParamPedestrianWaitThresholdSecNorthSouth(paramPedestrianWaitThresholdSecNorthSouth);
			}

			if(saves.contains("paramPedestrianWaitThresholdSecWestEast")) {
				Double paramPedestrianWaitThresholdSecWestEast = (Double)doc.get("paramPedestrianWaitThresholdSecWestEast_docvalues_double");
				if(paramPedestrianWaitThresholdSecWestEast != null)
					oSimulationReport.setParamPedestrianWaitThresholdSecWestEast(paramPedestrianWaitThresholdSecWestEast);
			}

			if(saves.contains("paramVehicleQueueThresholdWestEast")) {
				Double paramVehicleQueueThresholdWestEast = (Double)doc.get("paramVehicleQueueThresholdWestEast_docvalues_double");
				if(paramVehicleQueueThresholdWestEast != null)
					oSimulationReport.setParamVehicleQueueThresholdWestEast(paramVehicleQueueThresholdWestEast);
			}

			if(saves.contains("paramVehicleQueueThresholdSouthNorth")) {
				Double paramVehicleQueueThresholdSouthNorth = (Double)doc.get("paramVehicleQueueThresholdSouthNorth_docvalues_double");
				if(paramVehicleQueueThresholdSouthNorth != null)
					oSimulationReport.setParamVehicleQueueThresholdSouthNorth(paramVehicleQueueThresholdSouthNorth);
			}

			if(saves.contains("paramPedestrianQueueThresholdNorthSouth")) {
				Double paramPedestrianQueueThresholdNorthSouth = (Double)doc.get("paramPedestrianQueueThresholdNorthSouth_docvalues_double");
				if(paramPedestrianQueueThresholdNorthSouth != null)
					oSimulationReport.setParamPedestrianQueueThresholdNorthSouth(paramPedestrianQueueThresholdNorthSouth);
			}

			if(saves.contains("paramPedestrianQueueThresholdWestEast")) {
				Double paramPedestrianQueueThresholdWestEast = (Double)doc.get("paramPedestrianQueueThresholdWestEast_docvalues_double");
				if(paramPedestrianQueueThresholdWestEast != null)
					oSimulationReport.setParamPedestrianQueueThresholdWestEast(paramPedestrianQueueThresholdWestEast);
			}

			if(saves.contains("paramDemandScale")) {
				List<BigDecimal> paramDemandScale = (List<BigDecimal>)doc.get("paramDemandScale_docvalues_doubles");
				if(paramDemandScale != null)
					oSimulationReport.paramDemandScale.addAll(paramDemandScale);
			}

			if(saves.contains("paramInitialPar")) {
				List<BigDecimal> paramInitialPar = (List<BigDecimal>)doc.get("paramInitialPar_docvalues_doubles");
				if(paramInitialPar != null)
					oSimulationReport.paramInitialPar.addAll(paramInitialPar);
			}

			if(saves.contains("paramStepSize")) {
				Double paramStepSize = (Double)doc.get("paramStepSize_docvalues_double");
				if(paramStepSize != null)
					oSimulationReport.setParamStepSize(paramStepSize);
			}

			if(saves.contains("paramRunTime")) {
				Integer paramRunTime = (Integer)doc.get("paramRunTime_docvalues_int");
				if(paramRunTime != null)
					oSimulationReport.setParamRunTime(paramRunTime);
			}

			if(saves.contains("paramItersPerPar")) {
				Integer paramItersPerPar = (Integer)doc.get("paramItersPerPar_docvalues_int");
				if(paramItersPerPar != null)
					oSimulationReport.setParamItersPerPar(paramItersPerPar);
			}

			if(saves.contains("paramTotalIterNum")) {
				Integer paramTotalIterNum = (Integer)doc.get("paramTotalIterNum_docvalues_int");
				if(paramTotalIterNum != null)
					oSimulationReport.setParamTotalIterNum(paramTotalIterNum);
			}

			if(saves.contains("updatedParameters")) {
				String updatedParameters = (String)doc.get("updatedParameters_docvalues_string");
				if(updatedParameters != null)
					oSimulationReport.setUpdatedParameters(updatedParameters);
			}

			if(saves.contains("updatedParameters1")) {
				String updatedParameters1 = (String)doc.get("updatedParameters1_docvalues_string");
				if(updatedParameters1 != null)
					oSimulationReport.setUpdatedParameters1(updatedParameters1);
			}

			if(saves.contains("updatedParameters2")) {
				String updatedParameters2 = (String)doc.get("updatedParameters2_docvalues_string");
				if(updatedParameters2 != null)
					oSimulationReport.setUpdatedParameters2(updatedParameters2);
			}

			if(saves.contains("updatedParameters3")) {
				String updatedParameters3 = (String)doc.get("updatedParameters3_docvalues_string");
				if(updatedParameters3 != null)
					oSimulationReport.setUpdatedParameters3(updatedParameters3);
			}

			if(saves.contains("updatedParameters4")) {
				String updatedParameters4 = (String)doc.get("updatedParameters4_docvalues_string");
				if(updatedParameters4 != null)
					oSimulationReport.setUpdatedParameters4(updatedParameters4);
			}

			if(saves.contains("updatedParameters5")) {
				String updatedParameters5 = (String)doc.get("updatedParameters5_docvalues_string");
				if(updatedParameters5 != null)
					oSimulationReport.setUpdatedParameters5(updatedParameters5);
			}

			if(saves.contains("updatedParameters6")) {
				String updatedParameters6 = (String)doc.get("updatedParameters6_docvalues_string");
				if(updatedParameters6 != null)
					oSimulationReport.setUpdatedParameters6(updatedParameters6);
			}

			if(saves.contains("updatedParameters7")) {
				String updatedParameters7 = (String)doc.get("updatedParameters7_docvalues_string");
				if(updatedParameters7 != null)
					oSimulationReport.setUpdatedParameters7(updatedParameters7);
			}

			if(saves.contains("updatedParameters8")) {
				String updatedParameters8 = (String)doc.get("updatedParameters8_docvalues_string");
				if(updatedParameters8 != null)
					oSimulationReport.setUpdatedParameters8(updatedParameters8);
			}

			if(saves.contains("updatedParameters9")) {
				String updatedParameters9 = (String)doc.get("updatedParameters9_docvalues_string");
				if(updatedParameters9 != null)
					oSimulationReport.setUpdatedParameters9(updatedParameters9);
			}

			if(saves.contains("updatedParameters10")) {
				String updatedParameters10 = (String)doc.get("updatedParameters10_docvalues_string");
				if(updatedParameters10 != null)
					oSimulationReport.setUpdatedParameters10(updatedParameters10);
			}

			if(saves.contains("updatedPerformance")) {
				String updatedPerformance = (String)doc.get("updatedPerformance_docvalues_string");
				if(updatedPerformance != null)
					oSimulationReport.setUpdatedPerformance(updatedPerformance);
			}

			if(saves.contains("averageQueueLength")) {
				String averageQueueLength = (String)doc.get("averageQueueLength_docvalues_string");
				if(averageQueueLength != null)
					oSimulationReport.setAverageQueueLength(averageQueueLength);
			}

			if(saves.contains("updatedPerformanceWaitWestEastVehicleSec")) {
				String updatedPerformanceWaitWestEastVehicleSec = (String)doc.get("updatedPerformanceWaitWestEastVehicleSec_docvalues_string");
				if(updatedPerformanceWaitWestEastVehicleSec != null)
					oSimulationReport.setUpdatedPerformanceWaitWestEastVehicleSec(updatedPerformanceWaitWestEastVehicleSec);
			}

			if(saves.contains("updatedPerformanceWaitSouthNorthVehicleSec")) {
				String updatedPerformanceWaitSouthNorthVehicleSec = (String)doc.get("updatedPerformanceWaitSouthNorthVehicleSec_docvalues_string");
				if(updatedPerformanceWaitSouthNorthVehicleSec != null)
					oSimulationReport.setUpdatedPerformanceWaitSouthNorthVehicleSec(updatedPerformanceWaitSouthNorthVehicleSec);
			}

			if(saves.contains("updatedPerformanceWaitAllVehicleSec")) {
				String updatedPerformanceWaitAllVehicleSec = (String)doc.get("updatedPerformanceWaitAllVehicleSec_docvalues_string");
				if(updatedPerformanceWaitAllVehicleSec != null)
					oSimulationReport.setUpdatedPerformanceWaitAllVehicleSec(updatedPerformanceWaitAllVehicleSec);
			}

			if(saves.contains("updatedPerformanceWaitAllPedestrianSec")) {
				String updatedPerformanceWaitAllPedestrianSec = (String)doc.get("updatedPerformanceWaitAllPedestrianSec_docvalues_string");
				if(updatedPerformanceWaitAllPedestrianSec != null)
					oSimulationReport.setUpdatedPerformanceWaitAllPedestrianSec(updatedPerformanceWaitAllPedestrianSec);
			}

			if(saves.contains("updatedPerformanceWaitAllVehiclePedestrianSec")) {
				String updatedPerformanceWaitAllVehiclePedestrianSec = (String)doc.get("updatedPerformanceWaitAllVehiclePedestrianSec_docvalues_string");
				if(updatedPerformanceWaitAllVehiclePedestrianSec != null)
					oSimulationReport.setUpdatedPerformanceWaitAllVehiclePedestrianSec(updatedPerformanceWaitAllVehiclePedestrianSec);
			}

			if(saves.contains("avgQueueLengthWestEastVehicle")) {
				String avgQueueLengthWestEastVehicle = (String)doc.get("avgQueueLengthWestEastVehicle_docvalues_string");
				if(avgQueueLengthWestEastVehicle != null)
					oSimulationReport.setAvgQueueLengthWestEastVehicle(avgQueueLengthWestEastVehicle);
			}

			if(saves.contains("avgQueueLengthSouthNorthVehicle")) {
				String avgQueueLengthSouthNorthVehicle = (String)doc.get("avgQueueLengthSouthNorthVehicle_docvalues_string");
				if(avgQueueLengthSouthNorthVehicle != null)
					oSimulationReport.setAvgQueueLengthSouthNorthVehicle(avgQueueLengthSouthNorthVehicle);
			}

			if(saves.contains("avgQueueLengthNorthSouthPedestrian")) {
				String avgQueueLengthNorthSouthPedestrian = (String)doc.get("avgQueueLengthNorthSouthPedestrian_docvalues_string");
				if(avgQueueLengthNorthSouthPedestrian != null)
					oSimulationReport.setAvgQueueLengthNorthSouthPedestrian(avgQueueLengthNorthSouthPedestrian);
			}

			if(saves.contains("avgQueueLengthWestEastPedestrian")) {
				String avgQueueLengthWestEastPedestrian = (String)doc.get("avgQueueLengthWestEastPedestrian_docvalues_string");
				if(avgQueueLengthWestEastPedestrian != null)
					oSimulationReport.setAvgQueueLengthWestEastPedestrian(avgQueueLengthWestEastPedestrian);
			}

			if(saves.contains("reportStatus")) {
				String reportStatus = (String)doc.get("reportStatus_docvalues_string");
				if(reportStatus != null)
					oSimulationReport.setReportStatus(reportStatus);
			}

			if(saves.contains("reportProgress")) {
				Integer reportProgress = (Integer)doc.get("reportProgress_docvalues_int");
				if(reportProgress != null)
					oSimulationReport.setReportProgress(reportProgress);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexSimulationReport(JsonObject doc) {
		if(reportName != null) {
			doc.put("reportName_docvalues_string", reportName);
		}
		if(location != null) {
			doc.put("location_docvalues_location", String.format("%s,%s", location.getX(), location.getY()));
		}
		if(simulationKey != null) {
			doc.put("simulationKey_docvalues_long", simulationKey);
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
			JsonArray l = new JsonArray();
			doc.put("areaServed_docvalues_strings", l);
			for(Path o : areaServed) {
				JsonArray coordinates = new JsonArray();
				o.getPoints().forEach(point -> {
					coordinates.add(new JsonArray().add(point.getX()).add(point.getY()));
				});
				JsonObject json = new JsonObject().put("type", "Path").put("coordinates", coordinates);
				l.add(json.toString());
			}
		}
		if(smartTrafficLightKey != null) {
			doc.put("smartTrafficLightKey_docvalues_long", smartTrafficLightKey);
		}
		if(simulationName != null) {
			doc.put("simulationName_docvalues_string", simulationName);
		}
		if(smartTrafficLightId != null) {
			doc.put("smartTrafficLightId_docvalues_string", smartTrafficLightId);
		}
		if(smartTrafficLightName != null) {
			doc.put("smartTrafficLightName_docvalues_string", smartTrafficLightName);
		}
		if(paramAvgVehiclePerMinFromWestToEast != null) {
			doc.put("paramAvgVehiclePerMinFromWestToEast_docvalues_double", paramAvgVehiclePerMinFromWestToEast.doubleValue());
		}
		if(paramAvgVehiclePerMinFromSouthToNorth != null) {
			doc.put("paramAvgVehiclePerMinFromSouthToNorth_docvalues_double", paramAvgVehiclePerMinFromSouthToNorth.doubleValue());
		}
		if(paramVehicleDemandScalingFactor != null) {
			doc.put("paramVehicleDemandScalingFactor_docvalues_double", paramVehicleDemandScalingFactor.doubleValue());
		}
		if(paramAvgPedestrianPerMinFromWestToEast != null) {
			doc.put("paramAvgPedestrianPerMinFromWestToEast_docvalues_double", paramAvgPedestrianPerMinFromWestToEast.doubleValue());
		}
		if(paramAvgPedestrianPerMinFromSouthToNorth != null) {
			doc.put("paramAvgPedestrianPerMinFromSouthToNorth_docvalues_double", paramAvgPedestrianPerMinFromSouthToNorth.doubleValue());
		}
		if(paramPedestrianDemandScalingFactor != null) {
			doc.put("paramPedestrianDemandScalingFactor_docvalues_double", paramPedestrianDemandScalingFactor.doubleValue());
		}
		if(paramLam != null) {
			JsonArray l = new JsonArray();
			doc.put("paramLam_docvalues_doubles", l);
			for(BigDecimal o : paramLam) {
				l.add(o);
			}
		}
		if(paramMinGreenTimeSecWestEast != null) {
			doc.put("paramMinGreenTimeSecWestEast_docvalues_double", paramMinGreenTimeSecWestEast.doubleValue());
		}
		if(paramMaxGreenTimeSecWestEast != null) {
			doc.put("paramMaxGreenTimeSecWestEast_docvalues_double", paramMaxGreenTimeSecWestEast.doubleValue());
		}
		if(paramMinGreenTimeSecSouthNorth != null) {
			doc.put("paramMinGreenTimeSecSouthNorth_docvalues_double", paramMinGreenTimeSecSouthNorth.doubleValue());
		}
		if(paramMaxGreenTimeSecSouthNorth != null) {
			doc.put("paramMaxGreenTimeSecSouthNorth_docvalues_double", paramMaxGreenTimeSecSouthNorth.doubleValue());
		}
		if(paramPedestrianWaitThresholdSecNorthSouth != null) {
			doc.put("paramPedestrianWaitThresholdSecNorthSouth_docvalues_double", paramPedestrianWaitThresholdSecNorthSouth.doubleValue());
		}
		if(paramPedestrianWaitThresholdSecWestEast != null) {
			doc.put("paramPedestrianWaitThresholdSecWestEast_docvalues_double", paramPedestrianWaitThresholdSecWestEast.doubleValue());
		}
		if(paramVehicleQueueThresholdWestEast != null) {
			doc.put("paramVehicleQueueThresholdWestEast_docvalues_double", paramVehicleQueueThresholdWestEast.doubleValue());
		}
		if(paramVehicleQueueThresholdSouthNorth != null) {
			doc.put("paramVehicleQueueThresholdSouthNorth_docvalues_double", paramVehicleQueueThresholdSouthNorth.doubleValue());
		}
		if(paramPedestrianQueueThresholdNorthSouth != null) {
			doc.put("paramPedestrianQueueThresholdNorthSouth_docvalues_double", paramPedestrianQueueThresholdNorthSouth.doubleValue());
		}
		if(paramPedestrianQueueThresholdWestEast != null) {
			doc.put("paramPedestrianQueueThresholdWestEast_docvalues_double", paramPedestrianQueueThresholdWestEast.doubleValue());
		}
		if(paramDemandScale != null) {
			JsonArray l = new JsonArray();
			doc.put("paramDemandScale_docvalues_doubles", l);
			for(BigDecimal o : paramDemandScale) {
				l.add(o);
			}
		}
		if(paramInitialPar != null) {
			JsonArray l = new JsonArray();
			doc.put("paramInitialPar_docvalues_doubles", l);
			for(BigDecimal o : paramInitialPar) {
				l.add(o);
			}
		}
		if(paramStepSize != null) {
			doc.put("paramStepSize_docvalues_double", paramStepSize.doubleValue());
		}
		if(paramRunTime != null) {
			doc.put("paramRunTime_docvalues_int", paramRunTime);
		}
		if(paramItersPerPar != null) {
			doc.put("paramItersPerPar_docvalues_int", paramItersPerPar);
		}
		if(paramTotalIterNum != null) {
			doc.put("paramTotalIterNum_docvalues_int", paramTotalIterNum);
		}
		if(updatedParameters != null) {
			doc.put("updatedParameters_docvalues_string", updatedParameters.toString());
		}
		if(updatedParameters1 != null) {
			doc.put("updatedParameters1_docvalues_string", updatedParameters1.toString());
		}
		if(updatedParameters2 != null) {
			doc.put("updatedParameters2_docvalues_string", updatedParameters2.toString());
		}
		if(updatedParameters3 != null) {
			doc.put("updatedParameters3_docvalues_string", updatedParameters3.toString());
		}
		if(updatedParameters4 != null) {
			doc.put("updatedParameters4_docvalues_string", updatedParameters4.toString());
		}
		if(updatedParameters5 != null) {
			doc.put("updatedParameters5_docvalues_string", updatedParameters5.toString());
		}
		if(updatedParameters6 != null) {
			doc.put("updatedParameters6_docvalues_string", updatedParameters6.toString());
		}
		if(updatedParameters7 != null) {
			doc.put("updatedParameters7_docvalues_string", updatedParameters7.toString());
		}
		if(updatedParameters8 != null) {
			doc.put("updatedParameters8_docvalues_string", updatedParameters8.toString());
		}
		if(updatedParameters9 != null) {
			doc.put("updatedParameters9_docvalues_string", updatedParameters9.toString());
		}
		if(updatedParameters10 != null) {
			doc.put("updatedParameters10_docvalues_string", updatedParameters10.toString());
		}
		if(updatedPerformance != null) {
			doc.put("updatedPerformance_docvalues_string", updatedPerformance.toString());
		}
		if(averageQueueLength != null) {
			doc.put("averageQueueLength_docvalues_string", averageQueueLength.toString());
		}
		if(updatedPerformanceWaitWestEastVehicleSec != null) {
			doc.put("updatedPerformanceWaitWestEastVehicleSec_docvalues_string", updatedPerformanceWaitWestEastVehicleSec.toString());
		}
		if(updatedPerformanceWaitSouthNorthVehicleSec != null) {
			doc.put("updatedPerformanceWaitSouthNorthVehicleSec_docvalues_string", updatedPerformanceWaitSouthNorthVehicleSec.toString());
		}
		if(updatedPerformanceWaitAllVehicleSec != null) {
			doc.put("updatedPerformanceWaitAllVehicleSec_docvalues_string", updatedPerformanceWaitAllVehicleSec.toString());
		}
		if(updatedPerformanceWaitAllPedestrianSec != null) {
			doc.put("updatedPerformanceWaitAllPedestrianSec_docvalues_string", updatedPerformanceWaitAllPedestrianSec.toString());
		}
		if(updatedPerformanceWaitAllVehiclePedestrianSec != null) {
			doc.put("updatedPerformanceWaitAllVehiclePedestrianSec_docvalues_string", updatedPerformanceWaitAllVehiclePedestrianSec.toString());
		}
		if(avgQueueLengthWestEastVehicle != null) {
			doc.put("avgQueueLengthWestEastVehicle_docvalues_string", avgQueueLengthWestEastVehicle.toString());
		}
		if(avgQueueLengthSouthNorthVehicle != null) {
			doc.put("avgQueueLengthSouthNorthVehicle_docvalues_string", avgQueueLengthSouthNorthVehicle.toString());
		}
		if(avgQueueLengthNorthSouthPedestrian != null) {
			doc.put("avgQueueLengthNorthSouthPedestrian_docvalues_string", avgQueueLengthNorthSouthPedestrian.toString());
		}
		if(avgQueueLengthWestEastPedestrian != null) {
			doc.put("avgQueueLengthWestEastPedestrian_docvalues_string", avgQueueLengthWestEastPedestrian.toString());
		}
		if(reportStatus != null) {
			doc.put("reportStatus_docvalues_string", reportStatus);
		}
		if(reportProgress != null) {
			doc.put("reportProgress_docvalues_int", reportProgress);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredSimulationReport(String entityVar) {
		switch(entityVar) {
			case "reportName":
				return "reportName_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "simulationKey":
				return "simulationKey_docvalues_long";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_strings";
			case "smartTrafficLightKey":
				return "smartTrafficLightKey_docvalues_long";
			case "simulationName":
				return "simulationName_docvalues_string";
			case "smartTrafficLightId":
				return "smartTrafficLightId_docvalues_string";
			case "smartTrafficLightName":
				return "smartTrafficLightName_docvalues_string";
			case "paramAvgVehiclePerMinFromWestToEast":
				return "paramAvgVehiclePerMinFromWestToEast_docvalues_double";
			case "paramAvgVehiclePerMinFromSouthToNorth":
				return "paramAvgVehiclePerMinFromSouthToNorth_docvalues_double";
			case "paramVehicleDemandScalingFactor":
				return "paramVehicleDemandScalingFactor_docvalues_double";
			case "paramAvgPedestrianPerMinFromWestToEast":
				return "paramAvgPedestrianPerMinFromWestToEast_docvalues_double";
			case "paramAvgPedestrianPerMinFromSouthToNorth":
				return "paramAvgPedestrianPerMinFromSouthToNorth_docvalues_double";
			case "paramPedestrianDemandScalingFactor":
				return "paramPedestrianDemandScalingFactor_docvalues_double";
			case "paramLam":
				return "paramLam_docvalues_doubles";
			case "paramMinGreenTimeSecWestEast":
				return "paramMinGreenTimeSecWestEast_docvalues_double";
			case "paramMaxGreenTimeSecWestEast":
				return "paramMaxGreenTimeSecWestEast_docvalues_double";
			case "paramMinGreenTimeSecSouthNorth":
				return "paramMinGreenTimeSecSouthNorth_docvalues_double";
			case "paramMaxGreenTimeSecSouthNorth":
				return "paramMaxGreenTimeSecSouthNorth_docvalues_double";
			case "paramPedestrianWaitThresholdSecNorthSouth":
				return "paramPedestrianWaitThresholdSecNorthSouth_docvalues_double";
			case "paramPedestrianWaitThresholdSecWestEast":
				return "paramPedestrianWaitThresholdSecWestEast_docvalues_double";
			case "paramVehicleQueueThresholdWestEast":
				return "paramVehicleQueueThresholdWestEast_docvalues_double";
			case "paramVehicleQueueThresholdSouthNorth":
				return "paramVehicleQueueThresholdSouthNorth_docvalues_double";
			case "paramPedestrianQueueThresholdNorthSouth":
				return "paramPedestrianQueueThresholdNorthSouth_docvalues_double";
			case "paramPedestrianQueueThresholdWestEast":
				return "paramPedestrianQueueThresholdWestEast_docvalues_double";
			case "paramDemandScale":
				return "paramDemandScale_docvalues_doubles";
			case "paramInitialPar":
				return "paramInitialPar_docvalues_doubles";
			case "paramStepSize":
				return "paramStepSize_docvalues_double";
			case "paramRunTime":
				return "paramRunTime_docvalues_int";
			case "paramItersPerPar":
				return "paramItersPerPar_docvalues_int";
			case "paramTotalIterNum":
				return "paramTotalIterNum_docvalues_int";
			case "updatedParameters":
				return "updatedParameters_docvalues_string";
			case "updatedParameters1":
				return "updatedParameters1_docvalues_string";
			case "updatedParameters2":
				return "updatedParameters2_docvalues_string";
			case "updatedParameters3":
				return "updatedParameters3_docvalues_string";
			case "updatedParameters4":
				return "updatedParameters4_docvalues_string";
			case "updatedParameters5":
				return "updatedParameters5_docvalues_string";
			case "updatedParameters6":
				return "updatedParameters6_docvalues_string";
			case "updatedParameters7":
				return "updatedParameters7_docvalues_string";
			case "updatedParameters8":
				return "updatedParameters8_docvalues_string";
			case "updatedParameters9":
				return "updatedParameters9_docvalues_string";
			case "updatedParameters10":
				return "updatedParameters10_docvalues_string";
			case "updatedPerformance":
				return "updatedPerformance_docvalues_string";
			case "averageQueueLength":
				return "averageQueueLength_docvalues_string";
			case "updatedPerformanceWaitWestEastVehicleSec":
				return "updatedPerformanceWaitWestEastVehicleSec_docvalues_string";
			case "updatedPerformanceWaitSouthNorthVehicleSec":
				return "updatedPerformanceWaitSouthNorthVehicleSec_docvalues_string";
			case "updatedPerformanceWaitAllVehicleSec":
				return "updatedPerformanceWaitAllVehicleSec_docvalues_string";
			case "updatedPerformanceWaitAllPedestrianSec":
				return "updatedPerformanceWaitAllPedestrianSec_docvalues_string";
			case "updatedPerformanceWaitAllVehiclePedestrianSec":
				return "updatedPerformanceWaitAllVehiclePedestrianSec_docvalues_string";
			case "avgQueueLengthWestEastVehicle":
				return "avgQueueLengthWestEastVehicle_docvalues_string";
			case "avgQueueLengthSouthNorthVehicle":
				return "avgQueueLengthSouthNorthVehicle_docvalues_string";
			case "avgQueueLengthNorthSouthPedestrian":
				return "avgQueueLengthNorthSouthPedestrian_docvalues_string";
			case "avgQueueLengthWestEastPedestrian":
				return "avgQueueLengthWestEastPedestrian_docvalues_string";
			case "reportStatus":
				return "reportStatus_docvalues_string";
			case "reportProgress":
				return "reportProgress_docvalues_int";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedSimulationReport(String entityVar) {
		switch(entityVar) {
			case "reportName":
				return "reportName_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "simulationKey":
				return "simulationKey_docvalues_long";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_strings";
			case "smartTrafficLightKey":
				return "smartTrafficLightKey_docvalues_long";
			case "simulationName":
				return "simulationName_docvalues_string";
			case "smartTrafficLightId":
				return "smartTrafficLightId_docvalues_string";
			case "smartTrafficLightName":
				return "smartTrafficLightName_docvalues_string";
			case "paramAvgVehiclePerMinFromWestToEast":
				return "paramAvgVehiclePerMinFromWestToEast_docvalues_double";
			case "paramAvgVehiclePerMinFromSouthToNorth":
				return "paramAvgVehiclePerMinFromSouthToNorth_docvalues_double";
			case "paramVehicleDemandScalingFactor":
				return "paramVehicleDemandScalingFactor_docvalues_double";
			case "paramAvgPedestrianPerMinFromWestToEast":
				return "paramAvgPedestrianPerMinFromWestToEast_docvalues_double";
			case "paramAvgPedestrianPerMinFromSouthToNorth":
				return "paramAvgPedestrianPerMinFromSouthToNorth_docvalues_double";
			case "paramPedestrianDemandScalingFactor":
				return "paramPedestrianDemandScalingFactor_docvalues_double";
			case "paramLam":
				return "paramLam_docvalues_doubles";
			case "paramMinGreenTimeSecWestEast":
				return "paramMinGreenTimeSecWestEast_docvalues_double";
			case "paramMaxGreenTimeSecWestEast":
				return "paramMaxGreenTimeSecWestEast_docvalues_double";
			case "paramMinGreenTimeSecSouthNorth":
				return "paramMinGreenTimeSecSouthNorth_docvalues_double";
			case "paramMaxGreenTimeSecSouthNorth":
				return "paramMaxGreenTimeSecSouthNorth_docvalues_double";
			case "paramPedestrianWaitThresholdSecNorthSouth":
				return "paramPedestrianWaitThresholdSecNorthSouth_docvalues_double";
			case "paramPedestrianWaitThresholdSecWestEast":
				return "paramPedestrianWaitThresholdSecWestEast_docvalues_double";
			case "paramVehicleQueueThresholdWestEast":
				return "paramVehicleQueueThresholdWestEast_docvalues_double";
			case "paramVehicleQueueThresholdSouthNorth":
				return "paramVehicleQueueThresholdSouthNorth_docvalues_double";
			case "paramPedestrianQueueThresholdNorthSouth":
				return "paramPedestrianQueueThresholdNorthSouth_docvalues_double";
			case "paramPedestrianQueueThresholdWestEast":
				return "paramPedestrianQueueThresholdWestEast_docvalues_double";
			case "paramDemandScale":
				return "paramDemandScale_docvalues_doubles";
			case "paramInitialPar":
				return "paramInitialPar_docvalues_doubles";
			case "paramStepSize":
				return "paramStepSize_docvalues_double";
			case "paramRunTime":
				return "paramRunTime_docvalues_int";
			case "paramItersPerPar":
				return "paramItersPerPar_docvalues_int";
			case "paramTotalIterNum":
				return "paramTotalIterNum_docvalues_int";
			case "updatedParameters":
				return "updatedParameters_docvalues_string";
			case "updatedParameters1":
				return "updatedParameters1_docvalues_string";
			case "updatedParameters2":
				return "updatedParameters2_docvalues_string";
			case "updatedParameters3":
				return "updatedParameters3_docvalues_string";
			case "updatedParameters4":
				return "updatedParameters4_docvalues_string";
			case "updatedParameters5":
				return "updatedParameters5_docvalues_string";
			case "updatedParameters6":
				return "updatedParameters6_docvalues_string";
			case "updatedParameters7":
				return "updatedParameters7_docvalues_string";
			case "updatedParameters8":
				return "updatedParameters8_docvalues_string";
			case "updatedParameters9":
				return "updatedParameters9_docvalues_string";
			case "updatedParameters10":
				return "updatedParameters10_docvalues_string";
			case "updatedPerformance":
				return "updatedPerformance_docvalues_string";
			case "averageQueueLength":
				return "averageQueueLength_docvalues_string";
			case "updatedPerformanceWaitWestEastVehicleSec":
				return "updatedPerformanceWaitWestEastVehicleSec_docvalues_string";
			case "updatedPerformanceWaitSouthNorthVehicleSec":
				return "updatedPerformanceWaitSouthNorthVehicleSec_docvalues_string";
			case "updatedPerformanceWaitAllVehicleSec":
				return "updatedPerformanceWaitAllVehicleSec_docvalues_string";
			case "updatedPerformanceWaitAllPedestrianSec":
				return "updatedPerformanceWaitAllPedestrianSec_docvalues_string";
			case "updatedPerformanceWaitAllVehiclePedestrianSec":
				return "updatedPerformanceWaitAllVehiclePedestrianSec_docvalues_string";
			case "avgQueueLengthWestEastVehicle":
				return "avgQueueLengthWestEastVehicle_docvalues_string";
			case "avgQueueLengthSouthNorthVehicle":
				return "avgQueueLengthSouthNorthVehicle_docvalues_string";
			case "avgQueueLengthNorthSouthPedestrian":
				return "avgQueueLengthNorthSouthPedestrian_docvalues_string";
			case "avgQueueLengthWestEastPedestrian":
				return "avgQueueLengthWestEastPedestrian_docvalues_string";
			case "reportStatus":
				return "reportStatus_docvalues_string";
			case "reportProgress":
				return "reportProgress_docvalues_int";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarSimulationReport(String searchVar) {
		switch(searchVar) {
			case "reportName_docvalues_string":
				return "reportName";
			case "location_docvalues_location":
				return "location";
			case "simulationKey_docvalues_long":
				return "simulationKey";
			case "areaServedColors_indexedstored_strings":
				return "areaServedColors";
			case "areaServedTitles_indexedstored_strings":
				return "areaServedTitles";
			case "areaServedLinks_indexedstored_strings":
				return "areaServedLinks";
			case "areaServed_docvalues_strings":
				return "areaServed";
			case "smartTrafficLightKey_docvalues_long":
				return "smartTrafficLightKey";
			case "simulationName_docvalues_string":
				return "simulationName";
			case "smartTrafficLightId_docvalues_string":
				return "smartTrafficLightId";
			case "smartTrafficLightName_docvalues_string":
				return "smartTrafficLightName";
			case "paramAvgVehiclePerMinFromWestToEast_docvalues_double":
				return "paramAvgVehiclePerMinFromWestToEast";
			case "paramAvgVehiclePerMinFromSouthToNorth_docvalues_double":
				return "paramAvgVehiclePerMinFromSouthToNorth";
			case "paramVehicleDemandScalingFactor_docvalues_double":
				return "paramVehicleDemandScalingFactor";
			case "paramAvgPedestrianPerMinFromWestToEast_docvalues_double":
				return "paramAvgPedestrianPerMinFromWestToEast";
			case "paramAvgPedestrianPerMinFromSouthToNorth_docvalues_double":
				return "paramAvgPedestrianPerMinFromSouthToNorth";
			case "paramPedestrianDemandScalingFactor_docvalues_double":
				return "paramPedestrianDemandScalingFactor";
			case "paramLam_docvalues_doubles":
				return "paramLam";
			case "paramMinGreenTimeSecWestEast_docvalues_double":
				return "paramMinGreenTimeSecWestEast";
			case "paramMaxGreenTimeSecWestEast_docvalues_double":
				return "paramMaxGreenTimeSecWestEast";
			case "paramMinGreenTimeSecSouthNorth_docvalues_double":
				return "paramMinGreenTimeSecSouthNorth";
			case "paramMaxGreenTimeSecSouthNorth_docvalues_double":
				return "paramMaxGreenTimeSecSouthNorth";
			case "paramPedestrianWaitThresholdSecNorthSouth_docvalues_double":
				return "paramPedestrianWaitThresholdSecNorthSouth";
			case "paramPedestrianWaitThresholdSecWestEast_docvalues_double":
				return "paramPedestrianWaitThresholdSecWestEast";
			case "paramVehicleQueueThresholdWestEast_docvalues_double":
				return "paramVehicleQueueThresholdWestEast";
			case "paramVehicleQueueThresholdSouthNorth_docvalues_double":
				return "paramVehicleQueueThresholdSouthNorth";
			case "paramPedestrianQueueThresholdNorthSouth_docvalues_double":
				return "paramPedestrianQueueThresholdNorthSouth";
			case "paramPedestrianQueueThresholdWestEast_docvalues_double":
				return "paramPedestrianQueueThresholdWestEast";
			case "paramDemandScale_docvalues_doubles":
				return "paramDemandScale";
			case "paramInitialPar_docvalues_doubles":
				return "paramInitialPar";
			case "paramStepSize_docvalues_double":
				return "paramStepSize";
			case "paramRunTime_docvalues_int":
				return "paramRunTime";
			case "paramItersPerPar_docvalues_int":
				return "paramItersPerPar";
			case "paramTotalIterNum_docvalues_int":
				return "paramTotalIterNum";
			case "updatedParameters_docvalues_string":
				return "updatedParameters";
			case "updatedParameters1_docvalues_string":
				return "updatedParameters1";
			case "updatedParameters2_docvalues_string":
				return "updatedParameters2";
			case "updatedParameters3_docvalues_string":
				return "updatedParameters3";
			case "updatedParameters4_docvalues_string":
				return "updatedParameters4";
			case "updatedParameters5_docvalues_string":
				return "updatedParameters5";
			case "updatedParameters6_docvalues_string":
				return "updatedParameters6";
			case "updatedParameters7_docvalues_string":
				return "updatedParameters7";
			case "updatedParameters8_docvalues_string":
				return "updatedParameters8";
			case "updatedParameters9_docvalues_string":
				return "updatedParameters9";
			case "updatedParameters10_docvalues_string":
				return "updatedParameters10";
			case "updatedPerformance_docvalues_string":
				return "updatedPerformance";
			case "averageQueueLength_docvalues_string":
				return "averageQueueLength";
			case "updatedPerformanceWaitWestEastVehicleSec_docvalues_string":
				return "updatedPerformanceWaitWestEastVehicleSec";
			case "updatedPerformanceWaitSouthNorthVehicleSec_docvalues_string":
				return "updatedPerformanceWaitSouthNorthVehicleSec";
			case "updatedPerformanceWaitAllVehicleSec_docvalues_string":
				return "updatedPerformanceWaitAllVehicleSec";
			case "updatedPerformanceWaitAllPedestrianSec_docvalues_string":
				return "updatedPerformanceWaitAllPedestrianSec";
			case "updatedPerformanceWaitAllVehiclePedestrianSec_docvalues_string":
				return "updatedPerformanceWaitAllVehiclePedestrianSec";
			case "avgQueueLengthWestEastVehicle_docvalues_string":
				return "avgQueueLengthWestEastVehicle";
			case "avgQueueLengthSouthNorthVehicle_docvalues_string":
				return "avgQueueLengthSouthNorthVehicle";
			case "avgQueueLengthNorthSouthPedestrian_docvalues_string":
				return "avgQueueLengthNorthSouthPedestrian";
			case "avgQueueLengthWestEastPedestrian_docvalues_string":
				return "avgQueueLengthWestEastPedestrian";
			case "reportStatus_docvalues_string":
				return "reportStatus";
			case "reportProgress_docvalues_int":
				return "reportProgress";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchSimulationReport(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedSimulationReport(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeSimulationReport(doc);
	}
	public void storeSimulationReport(SolrResponse.Doc doc) {
		SimulationReport oSimulationReport = (SimulationReport)this;
		SiteRequestEnUS siteRequest = oSimulationReport.getSiteRequest_();

		oSimulationReport.setReportName(Optional.ofNullable(doc.get("reportName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setSimulationKey(Optional.ofNullable(doc.get("simulationKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addAreaServedColors(SimulationReport.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addAreaServedTitles(SimulationReport.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addAreaServedLinks(SimulationReport.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServed_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addAreaServed(SimulationReport.staticSetAreaServed(siteRequest, v.toString()));
		});
		oSimulationReport.setSmartTrafficLightKey(Optional.ofNullable(doc.get("smartTrafficLightKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setSimulationName(Optional.ofNullable(doc.get("simulationName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setSmartTrafficLightId(Optional.ofNullable(doc.get("smartTrafficLightId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setSmartTrafficLightName(Optional.ofNullable(doc.get("smartTrafficLightName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamAvgVehiclePerMinFromWestToEast(Optional.ofNullable(doc.get("paramAvgVehiclePerMinFromWestToEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamAvgVehiclePerMinFromSouthToNorth(Optional.ofNullable(doc.get("paramAvgVehiclePerMinFromSouthToNorth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamVehicleDemandScalingFactor(Optional.ofNullable(doc.get("paramVehicleDemandScalingFactor_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamAvgPedestrianPerMinFromWestToEast(Optional.ofNullable(doc.get("paramAvgPedestrianPerMinFromWestToEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamAvgPedestrianPerMinFromSouthToNorth(Optional.ofNullable(doc.get("paramAvgPedestrianPerMinFromSouthToNorth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamPedestrianDemandScalingFactor(Optional.ofNullable(doc.get("paramPedestrianDemandScalingFactor_docvalues_double")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("paramLam_docvalues_doubles")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addParamLam(SimulationReport.staticSetParamLam(siteRequest, v.toString()));
		});
		oSimulationReport.setParamMinGreenTimeSecWestEast(Optional.ofNullable(doc.get("paramMinGreenTimeSecWestEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamMaxGreenTimeSecWestEast(Optional.ofNullable(doc.get("paramMaxGreenTimeSecWestEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamMinGreenTimeSecSouthNorth(Optional.ofNullable(doc.get("paramMinGreenTimeSecSouthNorth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamMaxGreenTimeSecSouthNorth(Optional.ofNullable(doc.get("paramMaxGreenTimeSecSouthNorth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamPedestrianWaitThresholdSecNorthSouth(Optional.ofNullable(doc.get("paramPedestrianWaitThresholdSecNorthSouth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamPedestrianWaitThresholdSecWestEast(Optional.ofNullable(doc.get("paramPedestrianWaitThresholdSecWestEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamVehicleQueueThresholdWestEast(Optional.ofNullable(doc.get("paramVehicleQueueThresholdWestEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamVehicleQueueThresholdSouthNorth(Optional.ofNullable(doc.get("paramVehicleQueueThresholdSouthNorth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamPedestrianQueueThresholdNorthSouth(Optional.ofNullable(doc.get("paramPedestrianQueueThresholdNorthSouth_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamPedestrianQueueThresholdWestEast(Optional.ofNullable(doc.get("paramPedestrianQueueThresholdWestEast_docvalues_double")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("paramDemandScale_docvalues_doubles")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addParamDemandScale(SimulationReport.staticSetParamDemandScale(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("paramInitialPar_docvalues_doubles")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSimulationReport.addParamInitialPar(SimulationReport.staticSetParamInitialPar(siteRequest, v.toString()));
		});
		oSimulationReport.setParamStepSize(Optional.ofNullable(doc.get("paramStepSize_docvalues_double")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamRunTime(Optional.ofNullable(doc.get("paramRunTime_docvalues_int")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamItersPerPar(Optional.ofNullable(doc.get("paramItersPerPar_docvalues_int")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setParamTotalIterNum(Optional.ofNullable(doc.get("paramTotalIterNum_docvalues_int")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters(Optional.ofNullable(doc.get("updatedParameters_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters1(Optional.ofNullable(doc.get("updatedParameters1_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters2(Optional.ofNullable(doc.get("updatedParameters2_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters3(Optional.ofNullable(doc.get("updatedParameters3_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters4(Optional.ofNullable(doc.get("updatedParameters4_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters5(Optional.ofNullable(doc.get("updatedParameters5_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters6(Optional.ofNullable(doc.get("updatedParameters6_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters7(Optional.ofNullable(doc.get("updatedParameters7_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters8(Optional.ofNullable(doc.get("updatedParameters8_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters9(Optional.ofNullable(doc.get("updatedParameters9_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedParameters10(Optional.ofNullable(doc.get("updatedParameters10_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedPerformance(Optional.ofNullable(doc.get("updatedPerformance_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setAverageQueueLength(Optional.ofNullable(doc.get("averageQueueLength_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedPerformanceWaitWestEastVehicleSec(Optional.ofNullable(doc.get("updatedPerformanceWaitWestEastVehicleSec_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedPerformanceWaitSouthNorthVehicleSec(Optional.ofNullable(doc.get("updatedPerformanceWaitSouthNorthVehicleSec_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedPerformanceWaitAllVehicleSec(Optional.ofNullable(doc.get("updatedPerformanceWaitAllVehicleSec_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedPerformanceWaitAllPedestrianSec(Optional.ofNullable(doc.get("updatedPerformanceWaitAllPedestrianSec_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setUpdatedPerformanceWaitAllVehiclePedestrianSec(Optional.ofNullable(doc.get("updatedPerformanceWaitAllVehiclePedestrianSec_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setAvgQueueLengthWestEastVehicle(Optional.ofNullable(doc.get("avgQueueLengthWestEastVehicle_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setAvgQueueLengthSouthNorthVehicle(Optional.ofNullable(doc.get("avgQueueLengthSouthNorthVehicle_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setAvgQueueLengthNorthSouthPedestrian(Optional.ofNullable(doc.get("avgQueueLengthNorthSouthPedestrian_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setAvgQueueLengthWestEastPedestrian(Optional.ofNullable(doc.get("avgQueueLengthWestEastPedestrian_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setReportStatus(Optional.ofNullable(doc.get("reportStatus_docvalues_string")).map(v -> v.toString()).orElse(null));
		oSimulationReport.setReportProgress(Optional.ofNullable(doc.get("reportProgress_docvalues_int")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSimulationReport() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SimulationReport) {
			SimulationReport original = (SimulationReport)o;
			if(!Objects.equals(reportName, original.getReportName()))
				apiRequest.addVars("reportName");
			if(!Objects.equals(location, original.getLocation()))
				apiRequest.addVars("location");
			if(!Objects.equals(simulationKey, original.getSimulationKey()))
				apiRequest.addVars("simulationKey");
			if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
				apiRequest.addVars("areaServedColors");
			if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
				apiRequest.addVars("areaServedTitles");
			if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
				apiRequest.addVars("areaServedLinks");
			if(!Objects.equals(areaServed, original.getAreaServed()))
				apiRequest.addVars("areaServed");
			if(!Objects.equals(smartTrafficLightKey, original.getSmartTrafficLightKey()))
				apiRequest.addVars("smartTrafficLightKey");
			if(!Objects.equals(simulationName, original.getSimulationName()))
				apiRequest.addVars("simulationName");
			if(!Objects.equals(smartTrafficLightId, original.getSmartTrafficLightId()))
				apiRequest.addVars("smartTrafficLightId");
			if(!Objects.equals(smartTrafficLightName, original.getSmartTrafficLightName()))
				apiRequest.addVars("smartTrafficLightName");
			if(!Objects.equals(paramAvgVehiclePerMinFromWestToEast, original.getParamAvgVehiclePerMinFromWestToEast()) && paramAvgVehiclePerMinFromWestToEast != null && original.getParamAvgVehiclePerMinFromWestToEast() != null && paramAvgVehiclePerMinFromWestToEast.compareTo(original.getParamAvgVehiclePerMinFromWestToEast()) != 0)
				apiRequest.addVars("paramAvgVehiclePerMinFromWestToEast");
			if(!Objects.equals(paramAvgVehiclePerMinFromSouthToNorth, original.getParamAvgVehiclePerMinFromSouthToNorth()) && paramAvgVehiclePerMinFromSouthToNorth != null && original.getParamAvgVehiclePerMinFromSouthToNorth() != null && paramAvgVehiclePerMinFromSouthToNorth.compareTo(original.getParamAvgVehiclePerMinFromSouthToNorth()) != 0)
				apiRequest.addVars("paramAvgVehiclePerMinFromSouthToNorth");
			if(!Objects.equals(paramVehicleDemandScalingFactor, original.getParamVehicleDemandScalingFactor()) && paramVehicleDemandScalingFactor != null && original.getParamVehicleDemandScalingFactor() != null && paramVehicleDemandScalingFactor.compareTo(original.getParamVehicleDemandScalingFactor()) != 0)
				apiRequest.addVars("paramVehicleDemandScalingFactor");
			if(!Objects.equals(paramAvgPedestrianPerMinFromWestToEast, original.getParamAvgPedestrianPerMinFromWestToEast()) && paramAvgPedestrianPerMinFromWestToEast != null && original.getParamAvgPedestrianPerMinFromWestToEast() != null && paramAvgPedestrianPerMinFromWestToEast.compareTo(original.getParamAvgPedestrianPerMinFromWestToEast()) != 0)
				apiRequest.addVars("paramAvgPedestrianPerMinFromWestToEast");
			if(!Objects.equals(paramAvgPedestrianPerMinFromSouthToNorth, original.getParamAvgPedestrianPerMinFromSouthToNorth()) && paramAvgPedestrianPerMinFromSouthToNorth != null && original.getParamAvgPedestrianPerMinFromSouthToNorth() != null && paramAvgPedestrianPerMinFromSouthToNorth.compareTo(original.getParamAvgPedestrianPerMinFromSouthToNorth()) != 0)
				apiRequest.addVars("paramAvgPedestrianPerMinFromSouthToNorth");
			if(!Objects.equals(paramPedestrianDemandScalingFactor, original.getParamPedestrianDemandScalingFactor()) && paramPedestrianDemandScalingFactor != null && original.getParamPedestrianDemandScalingFactor() != null && paramPedestrianDemandScalingFactor.compareTo(original.getParamPedestrianDemandScalingFactor()) != 0)
				apiRequest.addVars("paramPedestrianDemandScalingFactor");
			if(!Objects.equals(paramLam, original.getParamLam()))
				apiRequest.addVars("paramLam");
			if(!Objects.equals(paramMinGreenTimeSecWestEast, original.getParamMinGreenTimeSecWestEast()) && paramMinGreenTimeSecWestEast != null && original.getParamMinGreenTimeSecWestEast() != null && paramMinGreenTimeSecWestEast.compareTo(original.getParamMinGreenTimeSecWestEast()) != 0)
				apiRequest.addVars("paramMinGreenTimeSecWestEast");
			if(!Objects.equals(paramMaxGreenTimeSecWestEast, original.getParamMaxGreenTimeSecWestEast()) && paramMaxGreenTimeSecWestEast != null && original.getParamMaxGreenTimeSecWestEast() != null && paramMaxGreenTimeSecWestEast.compareTo(original.getParamMaxGreenTimeSecWestEast()) != 0)
				apiRequest.addVars("paramMaxGreenTimeSecWestEast");
			if(!Objects.equals(paramMinGreenTimeSecSouthNorth, original.getParamMinGreenTimeSecSouthNorth()) && paramMinGreenTimeSecSouthNorth != null && original.getParamMinGreenTimeSecSouthNorth() != null && paramMinGreenTimeSecSouthNorth.compareTo(original.getParamMinGreenTimeSecSouthNorth()) != 0)
				apiRequest.addVars("paramMinGreenTimeSecSouthNorth");
			if(!Objects.equals(paramMaxGreenTimeSecSouthNorth, original.getParamMaxGreenTimeSecSouthNorth()) && paramMaxGreenTimeSecSouthNorth != null && original.getParamMaxGreenTimeSecSouthNorth() != null && paramMaxGreenTimeSecSouthNorth.compareTo(original.getParamMaxGreenTimeSecSouthNorth()) != 0)
				apiRequest.addVars("paramMaxGreenTimeSecSouthNorth");
			if(!Objects.equals(paramPedestrianWaitThresholdSecNorthSouth, original.getParamPedestrianWaitThresholdSecNorthSouth()) && paramPedestrianWaitThresholdSecNorthSouth != null && original.getParamPedestrianWaitThresholdSecNorthSouth() != null && paramPedestrianWaitThresholdSecNorthSouth.compareTo(original.getParamPedestrianWaitThresholdSecNorthSouth()) != 0)
				apiRequest.addVars("paramPedestrianWaitThresholdSecNorthSouth");
			if(!Objects.equals(paramPedestrianWaitThresholdSecWestEast, original.getParamPedestrianWaitThresholdSecWestEast()) && paramPedestrianWaitThresholdSecWestEast != null && original.getParamPedestrianWaitThresholdSecWestEast() != null && paramPedestrianWaitThresholdSecWestEast.compareTo(original.getParamPedestrianWaitThresholdSecWestEast()) != 0)
				apiRequest.addVars("paramPedestrianWaitThresholdSecWestEast");
			if(!Objects.equals(paramVehicleQueueThresholdWestEast, original.getParamVehicleQueueThresholdWestEast()) && paramVehicleQueueThresholdWestEast != null && original.getParamVehicleQueueThresholdWestEast() != null && paramVehicleQueueThresholdWestEast.compareTo(original.getParamVehicleQueueThresholdWestEast()) != 0)
				apiRequest.addVars("paramVehicleQueueThresholdWestEast");
			if(!Objects.equals(paramVehicleQueueThresholdSouthNorth, original.getParamVehicleQueueThresholdSouthNorth()) && paramVehicleQueueThresholdSouthNorth != null && original.getParamVehicleQueueThresholdSouthNorth() != null && paramVehicleQueueThresholdSouthNorth.compareTo(original.getParamVehicleQueueThresholdSouthNorth()) != 0)
				apiRequest.addVars("paramVehicleQueueThresholdSouthNorth");
			if(!Objects.equals(paramPedestrianQueueThresholdNorthSouth, original.getParamPedestrianQueueThresholdNorthSouth()) && paramPedestrianQueueThresholdNorthSouth != null && original.getParamPedestrianQueueThresholdNorthSouth() != null && paramPedestrianQueueThresholdNorthSouth.compareTo(original.getParamPedestrianQueueThresholdNorthSouth()) != 0)
				apiRequest.addVars("paramPedestrianQueueThresholdNorthSouth");
			if(!Objects.equals(paramPedestrianQueueThresholdWestEast, original.getParamPedestrianQueueThresholdWestEast()) && paramPedestrianQueueThresholdWestEast != null && original.getParamPedestrianQueueThresholdWestEast() != null && paramPedestrianQueueThresholdWestEast.compareTo(original.getParamPedestrianQueueThresholdWestEast()) != 0)
				apiRequest.addVars("paramPedestrianQueueThresholdWestEast");
			if(!Objects.equals(paramDemandScale, original.getParamDemandScale()))
				apiRequest.addVars("paramDemandScale");
			if(!Objects.equals(paramInitialPar, original.getParamInitialPar()))
				apiRequest.addVars("paramInitialPar");
			if(!Objects.equals(paramStepSize, original.getParamStepSize()) && paramStepSize != null && original.getParamStepSize() != null && paramStepSize.compareTo(original.getParamStepSize()) != 0)
				apiRequest.addVars("paramStepSize");
			if(!Objects.equals(paramRunTime, original.getParamRunTime()))
				apiRequest.addVars("paramRunTime");
			if(!Objects.equals(paramItersPerPar, original.getParamItersPerPar()))
				apiRequest.addVars("paramItersPerPar");
			if(!Objects.equals(paramTotalIterNum, original.getParamTotalIterNum()))
				apiRequest.addVars("paramTotalIterNum");
			if(!Objects.equals(updatedParameters, original.getUpdatedParameters()))
				apiRequest.addVars("updatedParameters");
			if(!Objects.equals(updatedParameters1, original.getUpdatedParameters1()))
				apiRequest.addVars("updatedParameters1");
			if(!Objects.equals(updatedParameters2, original.getUpdatedParameters2()))
				apiRequest.addVars("updatedParameters2");
			if(!Objects.equals(updatedParameters3, original.getUpdatedParameters3()))
				apiRequest.addVars("updatedParameters3");
			if(!Objects.equals(updatedParameters4, original.getUpdatedParameters4()))
				apiRequest.addVars("updatedParameters4");
			if(!Objects.equals(updatedParameters5, original.getUpdatedParameters5()))
				apiRequest.addVars("updatedParameters5");
			if(!Objects.equals(updatedParameters6, original.getUpdatedParameters6()))
				apiRequest.addVars("updatedParameters6");
			if(!Objects.equals(updatedParameters7, original.getUpdatedParameters7()))
				apiRequest.addVars("updatedParameters7");
			if(!Objects.equals(updatedParameters8, original.getUpdatedParameters8()))
				apiRequest.addVars("updatedParameters8");
			if(!Objects.equals(updatedParameters9, original.getUpdatedParameters9()))
				apiRequest.addVars("updatedParameters9");
			if(!Objects.equals(updatedParameters10, original.getUpdatedParameters10()))
				apiRequest.addVars("updatedParameters10");
			if(!Objects.equals(updatedPerformance, original.getUpdatedPerformance()))
				apiRequest.addVars("updatedPerformance");
			if(!Objects.equals(averageQueueLength, original.getAverageQueueLength()))
				apiRequest.addVars("averageQueueLength");
			if(!Objects.equals(updatedPerformanceWaitWestEastVehicleSec, original.getUpdatedPerformanceWaitWestEastVehicleSec()))
				apiRequest.addVars("updatedPerformanceWaitWestEastVehicleSec");
			if(!Objects.equals(updatedPerformanceWaitSouthNorthVehicleSec, original.getUpdatedPerformanceWaitSouthNorthVehicleSec()))
				apiRequest.addVars("updatedPerformanceWaitSouthNorthVehicleSec");
			if(!Objects.equals(updatedPerformanceWaitAllVehicleSec, original.getUpdatedPerformanceWaitAllVehicleSec()))
				apiRequest.addVars("updatedPerformanceWaitAllVehicleSec");
			if(!Objects.equals(updatedPerformanceWaitAllPedestrianSec, original.getUpdatedPerformanceWaitAllPedestrianSec()))
				apiRequest.addVars("updatedPerformanceWaitAllPedestrianSec");
			if(!Objects.equals(updatedPerformanceWaitAllVehiclePedestrianSec, original.getUpdatedPerformanceWaitAllVehiclePedestrianSec()))
				apiRequest.addVars("updatedPerformanceWaitAllVehiclePedestrianSec");
			if(!Objects.equals(avgQueueLengthWestEastVehicle, original.getAvgQueueLengthWestEastVehicle()))
				apiRequest.addVars("avgQueueLengthWestEastVehicle");
			if(!Objects.equals(avgQueueLengthSouthNorthVehicle, original.getAvgQueueLengthSouthNorthVehicle()))
				apiRequest.addVars("avgQueueLengthSouthNorthVehicle");
			if(!Objects.equals(avgQueueLengthNorthSouthPedestrian, original.getAvgQueueLengthNorthSouthPedestrian()))
				apiRequest.addVars("avgQueueLengthNorthSouthPedestrian");
			if(!Objects.equals(avgQueueLengthWestEastPedestrian, original.getAvgQueueLengthWestEastPedestrian()))
				apiRequest.addVars("avgQueueLengthWestEastPedestrian");
			if(!Objects.equals(reportStatus, original.getReportStatus()))
				apiRequest.addVars("reportStatus");
			if(!Objects.equals(reportProgress, original.getReportProgress()))
				apiRequest.addVars("reportProgress");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(reportName).map(v -> "reportName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(simulationKey).map(v -> "simulationKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(smartTrafficLightKey).map(v -> "smartTrafficLightKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(simulationName).map(v -> "simulationName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(smartTrafficLightId).map(v -> "smartTrafficLightId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(smartTrafficLightName).map(v -> "smartTrafficLightName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(paramAvgVehiclePerMinFromWestToEast).map(v -> "paramAvgVehiclePerMinFromWestToEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramAvgVehiclePerMinFromSouthToNorth).map(v -> "paramAvgVehiclePerMinFromSouthToNorth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramVehicleDemandScalingFactor).map(v -> "paramVehicleDemandScalingFactor: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramAvgPedestrianPerMinFromWestToEast).map(v -> "paramAvgPedestrianPerMinFromWestToEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramAvgPedestrianPerMinFromSouthToNorth).map(v -> "paramAvgPedestrianPerMinFromSouthToNorth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramPedestrianDemandScalingFactor).map(v -> "paramPedestrianDemandScalingFactor: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramLam).map(v -> "paramLam: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramMinGreenTimeSecWestEast).map(v -> "paramMinGreenTimeSecWestEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramMaxGreenTimeSecWestEast).map(v -> "paramMaxGreenTimeSecWestEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramMinGreenTimeSecSouthNorth).map(v -> "paramMinGreenTimeSecSouthNorth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramMaxGreenTimeSecSouthNorth).map(v -> "paramMaxGreenTimeSecSouthNorth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramPedestrianWaitThresholdSecNorthSouth).map(v -> "paramPedestrianWaitThresholdSecNorthSouth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramPedestrianWaitThresholdSecWestEast).map(v -> "paramPedestrianWaitThresholdSecWestEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramVehicleQueueThresholdWestEast).map(v -> "paramVehicleQueueThresholdWestEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramVehicleQueueThresholdSouthNorth).map(v -> "paramVehicleQueueThresholdSouthNorth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramPedestrianQueueThresholdNorthSouth).map(v -> "paramPedestrianQueueThresholdNorthSouth: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramPedestrianQueueThresholdWestEast).map(v -> "paramPedestrianQueueThresholdWestEast: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramDemandScale).map(v -> "paramDemandScale: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramInitialPar).map(v -> "paramInitialPar: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramStepSize).map(v -> "paramStepSize: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramRunTime).map(v -> "paramRunTime: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramItersPerPar).map(v -> "paramItersPerPar: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(paramTotalIterNum).map(v -> "paramTotalIterNum: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters).map(v -> "updatedParameters: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters1).map(v -> "updatedParameters1: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters2).map(v -> "updatedParameters2: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters3).map(v -> "updatedParameters3: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters4).map(v -> "updatedParameters4: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters5).map(v -> "updatedParameters5: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters6).map(v -> "updatedParameters6: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters7).map(v -> "updatedParameters7: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters8).map(v -> "updatedParameters8: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters9).map(v -> "updatedParameters9: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedParameters10).map(v -> "updatedParameters10: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedPerformance).map(v -> "updatedPerformance: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageQueueLength).map(v -> "averageQueueLength: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedPerformanceWaitWestEastVehicleSec).map(v -> "updatedPerformanceWaitWestEastVehicleSec: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedPerformanceWaitSouthNorthVehicleSec).map(v -> "updatedPerformanceWaitSouthNorthVehicleSec: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedPerformanceWaitAllVehicleSec).map(v -> "updatedPerformanceWaitAllVehicleSec: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedPerformanceWaitAllPedestrianSec).map(v -> "updatedPerformanceWaitAllPedestrianSec: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(updatedPerformanceWaitAllVehiclePedestrianSec).map(v -> "updatedPerformanceWaitAllVehiclePedestrianSec: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(avgQueueLengthWestEastVehicle).map(v -> "avgQueueLengthWestEastVehicle: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(avgQueueLengthSouthNorthVehicle).map(v -> "avgQueueLengthSouthNorthVehicle: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(avgQueueLengthNorthSouthPedestrian).map(v -> "avgQueueLengthNorthSouthPedestrian: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(avgQueueLengthWestEastPedestrian).map(v -> "avgQueueLengthWestEastPedestrian: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(reportStatus).map(v -> "reportStatus: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(reportProgress).map(v -> "reportProgress: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String[] SimulationReportVals = new String[] { reportStatusStop1_enUS, reportStatusStopped1_enUS, reportStatusCompleted1_enUS, reportStatusRun1_enUS, reportStatusRunning1_enUS, reportStatusError1_enUS };

	public static final String CLASS_SIMPLE_NAME = "SimulationReport";
	public static final String CLASS_API_ADDRESS_SimulationReport = "smartabyar-smartvillage-enUS-SimulationReport";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_SimulationReport;
	}
	public static final String VAR_reportName = "reportName";
	public static final String VAR_location = "location";
	public static final String VAR_simulationKey = "simulationKey";
	public static final String VAR_simulationSearch = "simulationSearch";
	public static final String VAR_simulation_ = "simulation_";
	public static final String VAR_observedSearch = "observedSearch";
	public static final String VAR_areaServedColors = "areaServedColors";
	public static final String VAR_areaServedTitles = "areaServedTitles";
	public static final String VAR_areaServedLinks = "areaServedLinks";
	public static final String VAR_areaServed = "areaServed";
	public static final String VAR_smartTrafficLightKey = "smartTrafficLightKey";
	public static final String VAR_smartTrafficLightSearch = "smartTrafficLightSearch";
	public static final String VAR_smartTrafficLight_ = "smartTrafficLight_";
	public static final String VAR_simulationName = "simulationName";
	public static final String VAR_smartTrafficLightId = "smartTrafficLightId";
	public static final String VAR_smartTrafficLightName = "smartTrafficLightName";
	public static final String VAR_paramAvgVehiclePerMinFromWestToEast = "paramAvgVehiclePerMinFromWestToEast";
	public static final String VAR_paramAvgVehiclePerMinFromSouthToNorth = "paramAvgVehiclePerMinFromSouthToNorth";
	public static final String VAR_paramVehicleDemandScalingFactor = "paramVehicleDemandScalingFactor";
	public static final String VAR_paramAvgPedestrianPerMinFromWestToEast = "paramAvgPedestrianPerMinFromWestToEast";
	public static final String VAR_paramAvgPedestrianPerMinFromSouthToNorth = "paramAvgPedestrianPerMinFromSouthToNorth";
	public static final String VAR_paramPedestrianDemandScalingFactor = "paramPedestrianDemandScalingFactor";
	public static final String VAR_paramLam = "paramLam";
	public static final String VAR_paramMinGreenTimeSecWestEast = "paramMinGreenTimeSecWestEast";
	public static final String VAR_paramMaxGreenTimeSecWestEast = "paramMaxGreenTimeSecWestEast";
	public static final String VAR_paramMinGreenTimeSecSouthNorth = "paramMinGreenTimeSecSouthNorth";
	public static final String VAR_paramMaxGreenTimeSecSouthNorth = "paramMaxGreenTimeSecSouthNorth";
	public static final String VAR_paramPedestrianWaitThresholdSecNorthSouth = "paramPedestrianWaitThresholdSecNorthSouth";
	public static final String VAR_paramPedestrianWaitThresholdSecWestEast = "paramPedestrianWaitThresholdSecWestEast";
	public static final String VAR_paramVehicleQueueThresholdWestEast = "paramVehicleQueueThresholdWestEast";
	public static final String VAR_paramVehicleQueueThresholdSouthNorth = "paramVehicleQueueThresholdSouthNorth";
	public static final String VAR_paramPedestrianQueueThresholdNorthSouth = "paramPedestrianQueueThresholdNorthSouth";
	public static final String VAR_paramPedestrianQueueThresholdWestEast = "paramPedestrianQueueThresholdWestEast";
	public static final String VAR_paramDemandScale = "paramDemandScale";
	public static final String VAR_paramInitialPar = "paramInitialPar";
	public static final String VAR_paramStepSize = "paramStepSize";
	public static final String VAR_paramRunTime = "paramRunTime";
	public static final String VAR_paramItersPerPar = "paramItersPerPar";
	public static final String VAR_paramTotalIterNum = "paramTotalIterNum";
	public static final String VAR_updatedParameters = "updatedParameters";
	public static final String VAR_updatedParameters1 = "updatedParameters1";
	public static final String VAR_updatedParameters2 = "updatedParameters2";
	public static final String VAR_updatedParameters3 = "updatedParameters3";
	public static final String VAR_updatedParameters4 = "updatedParameters4";
	public static final String VAR_updatedParameters5 = "updatedParameters5";
	public static final String VAR_updatedParameters6 = "updatedParameters6";
	public static final String VAR_updatedParameters7 = "updatedParameters7";
	public static final String VAR_updatedParameters8 = "updatedParameters8";
	public static final String VAR_updatedParameters9 = "updatedParameters9";
	public static final String VAR_updatedParameters10 = "updatedParameters10";
	public static final String VAR_updatedPerformance = "updatedPerformance";
	public static final String VAR_averageQueueLength = "averageQueueLength";
	public static final String VAR_updatedPerformanceWaitWestEastVehicleSec = "updatedPerformanceWaitWestEastVehicleSec";
	public static final String VAR_updatedPerformanceWaitSouthNorthVehicleSec = "updatedPerformanceWaitSouthNorthVehicleSec";
	public static final String VAR_updatedPerformanceWaitAllVehicleSec = "updatedPerformanceWaitAllVehicleSec";
	public static final String VAR_updatedPerformanceWaitAllPedestrianSec = "updatedPerformanceWaitAllPedestrianSec";
	public static final String VAR_updatedPerformanceWaitAllVehiclePedestrianSec = "updatedPerformanceWaitAllVehiclePedestrianSec";
	public static final String VAR_avgQueueLengthWestEastVehicle = "avgQueueLengthWestEastVehicle";
	public static final String VAR_avgQueueLengthSouthNorthVehicle = "avgQueueLengthSouthNorthVehicle";
	public static final String VAR_avgQueueLengthNorthSouthPedestrian = "avgQueueLengthNorthSouthPedestrian";
	public static final String VAR_avgQueueLengthWestEastPedestrian = "avgQueueLengthWestEastPedestrian";
	public static final String VAR_reportStatus = "reportStatus";
	public static final String VAR_reportProgress = "reportProgress";

	public static List<String> varsQForClass() {
		return SimulationReport.varsQSimulationReport(new ArrayList<String>());
	}
	public static List<String> varsQSimulationReport(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return SimulationReport.varsFqSimulationReport(new ArrayList<String>());
	}
	public static List<String> varsFqSimulationReport(List<String> vars) {
		vars.add(VAR_reportName);
		vars.add(VAR_location);
		vars.add(VAR_simulationKey);
		vars.add(VAR_smartTrafficLightKey);
		vars.add(VAR_simulationName);
		vars.add(VAR_smartTrafficLightId);
		vars.add(VAR_smartTrafficLightName);
		vars.add(VAR_paramAvgVehiclePerMinFromWestToEast);
		vars.add(VAR_paramAvgVehiclePerMinFromSouthToNorth);
		vars.add(VAR_paramVehicleDemandScalingFactor);
		vars.add(VAR_paramAvgPedestrianPerMinFromWestToEast);
		vars.add(VAR_paramAvgPedestrianPerMinFromSouthToNorth);
		vars.add(VAR_paramPedestrianDemandScalingFactor);
		vars.add(VAR_paramLam);
		vars.add(VAR_paramMinGreenTimeSecWestEast);
		vars.add(VAR_paramMaxGreenTimeSecWestEast);
		vars.add(VAR_paramMinGreenTimeSecSouthNorth);
		vars.add(VAR_paramMaxGreenTimeSecSouthNorth);
		vars.add(VAR_paramPedestrianWaitThresholdSecNorthSouth);
		vars.add(VAR_paramPedestrianWaitThresholdSecWestEast);
		vars.add(VAR_paramVehicleQueueThresholdWestEast);
		vars.add(VAR_paramVehicleQueueThresholdSouthNorth);
		vars.add(VAR_paramPedestrianQueueThresholdNorthSouth);
		vars.add(VAR_paramPedestrianQueueThresholdWestEast);
		vars.add(VAR_paramDemandScale);
		vars.add(VAR_paramInitialPar);
		vars.add(VAR_paramStepSize);
		vars.add(VAR_paramRunTime);
		vars.add(VAR_paramItersPerPar);
		vars.add(VAR_paramTotalIterNum);
		vars.add(VAR_updatedParameters);
		vars.add(VAR_updatedPerformance);
		vars.add(VAR_averageQueueLength);
		vars.add(VAR_updatedPerformanceWaitWestEastVehicleSec);
		vars.add(VAR_updatedPerformanceWaitSouthNorthVehicleSec);
		vars.add(VAR_updatedPerformanceWaitAllVehicleSec);
		vars.add(VAR_updatedPerformanceWaitAllPedestrianSec);
		vars.add(VAR_updatedPerformanceWaitAllVehiclePedestrianSec);
		vars.add(VAR_avgQueueLengthWestEastVehicle);
		vars.add(VAR_avgQueueLengthSouthNorthVehicle);
		vars.add(VAR_avgQueueLengthNorthSouthPedestrian);
		vars.add(VAR_avgQueueLengthWestEastPedestrian);
		vars.add(VAR_reportStatus);
		vars.add(VAR_reportProgress);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return SimulationReport.varsRangeSimulationReport(new ArrayList<String>());
	}
	public static List<String> varsRangeSimulationReport(List<String> vars) {
		vars.add(VAR_location);
		vars.add(VAR_paramAvgVehiclePerMinFromWestToEast);
		vars.add(VAR_paramAvgVehiclePerMinFromSouthToNorth);
		vars.add(VAR_paramVehicleDemandScalingFactor);
		vars.add(VAR_paramAvgPedestrianPerMinFromWestToEast);
		vars.add(VAR_paramAvgPedestrianPerMinFromSouthToNorth);
		vars.add(VAR_paramPedestrianDemandScalingFactor);
		vars.add(VAR_paramMinGreenTimeSecWestEast);
		vars.add(VAR_paramMaxGreenTimeSecWestEast);
		vars.add(VAR_paramMinGreenTimeSecSouthNorth);
		vars.add(VAR_paramMaxGreenTimeSecSouthNorth);
		vars.add(VAR_paramPedestrianWaitThresholdSecNorthSouth);
		vars.add(VAR_paramPedestrianWaitThresholdSecWestEast);
		vars.add(VAR_paramVehicleQueueThresholdWestEast);
		vars.add(VAR_paramVehicleQueueThresholdSouthNorth);
		vars.add(VAR_paramPedestrianQueueThresholdNorthSouth);
		vars.add(VAR_paramPedestrianQueueThresholdWestEast);
		vars.add(VAR_paramStepSize);
		vars.add(VAR_paramRunTime);
		vars.add(VAR_paramItersPerPar);
		vars.add(VAR_paramTotalIterNum);
		vars.add(VAR_updatedParameters);
		vars.add(VAR_updatedPerformance);
		vars.add(VAR_averageQueueLength);
		vars.add(VAR_updatedPerformanceWaitWestEastVehicleSec);
		vars.add(VAR_updatedPerformanceWaitSouthNorthVehicleSec);
		vars.add(VAR_updatedPerformanceWaitAllVehicleSec);
		vars.add(VAR_updatedPerformanceWaitAllPedestrianSec);
		vars.add(VAR_updatedPerformanceWaitAllVehiclePedestrianSec);
		vars.add(VAR_avgQueueLengthWestEastVehicle);
		vars.add(VAR_avgQueueLengthSouthNorthVehicle);
		vars.add(VAR_avgQueueLengthNorthSouthPedestrian);
		vars.add(VAR_avgQueueLengthWestEastPedestrian);
		vars.add(VAR_reportProgress);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_reportName = "report name";
	public static final String DISPLAY_NAME_location = "map location";
	public static final String DISPLAY_NAME_simulationKey = "traffic simulation";
	public static final String DISPLAY_NAME_simulationSearch = "";
	public static final String DISPLAY_NAME_simulation_ = "";
	public static final String DISPLAY_NAME_observedSearch = "";
	public static final String DISPLAY_NAME_areaServedColors = "area served colors";
	public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
	public static final String DISPLAY_NAME_areaServedLinks = "area served links";
	public static final String DISPLAY_NAME_areaServed = "area served";
	public static final String DISPLAY_NAME_smartTrafficLightKey = "smart traffic light";
	public static final String DISPLAY_NAME_smartTrafficLightSearch = "";
	public static final String DISPLAY_NAME_smartTrafficLight_ = "";
	public static final String DISPLAY_NAME_simulationName = "simulation name";
	public static final String DISPLAY_NAME_smartTrafficLightId = "smart traffic light name";
	public static final String DISPLAY_NAME_smartTrafficLightName = "smart traffic light name";
	public static final String DISPLAY_NAME_paramAvgVehiclePerMinFromWestToEast = "Average vehicle/min from WEST to EAST";
	public static final String DISPLAY_NAME_paramAvgVehiclePerMinFromSouthToNorth = "Average vehicle/min from SOUTH to NORTH";
	public static final String DISPLAY_NAME_paramVehicleDemandScalingFactor = "Demand scaling factor (multiplies all vehicle demands)";
	public static final String DISPLAY_NAME_paramAvgPedestrianPerMinFromWestToEast = "Average pedestrian/min from WEST to EAST";
	public static final String DISPLAY_NAME_paramAvgPedestrianPerMinFromSouthToNorth = "Average pedestrian/min from WEST to EAST";
	public static final String DISPLAY_NAME_paramPedestrianDemandScalingFactor = "Demand scaling factor (multiplies all pedestrian demands)";
	public static final String DISPLAY_NAME_paramLam = "traffic demand";
	public static final String DISPLAY_NAME_paramMinGreenTimeSecWestEast = "Min GREEN time for WEST-EAST traffic (sec)";
	public static final String DISPLAY_NAME_paramMaxGreenTimeSecWestEast = "Max GREEN time for WEST-EAST traffic (sec)";
	public static final String DISPLAY_NAME_paramMinGreenTimeSecSouthNorth = "Min GREEN time for SOUTH-NORTH traffic (sec)";
	public static final String DISPLAY_NAME_paramMaxGreenTimeSecSouthNorth = "Max GREEN time for SOUTH-NORTH traffic (sec)";
	public static final String DISPLAY_NAME_paramPedestrianWaitThresholdSecNorthSouth = "Pedestrian waiting time tolerance threshold for NORTH-SOUTH (sec)";
	public static final String DISPLAY_NAME_paramPedestrianWaitThresholdSecWestEast = "Pedestrian waiting time tolerance threshold for WEST-EAST (sec)";
	public static final String DISPLAY_NAME_paramVehicleQueueThresholdWestEast = "Vehicle queue length threshold between low-high content for WEST-EAST";
	public static final String DISPLAY_NAME_paramVehicleQueueThresholdSouthNorth = "Vehicle queue length threshold between low-high content for SOUTH-NORTH";
	public static final String DISPLAY_NAME_paramPedestrianQueueThresholdNorthSouth = "Pedestrian queue length threshold between low-high content for NORTH-SOUTH";
	public static final String DISPLAY_NAME_paramPedestrianQueueThresholdWestEast = "Pedestrian queue length threshold between low-high content for WEST-EAST";
	public static final String DISPLAY_NAME_paramDemandScale = "demand scale";
	public static final String DISPLAY_NAME_paramInitialPar = "initial params";
	public static final String DISPLAY_NAME_paramStepSize = "Simulation time step (sec)";
	public static final String DISPLAY_NAME_paramRunTime = "time for each round of traffic simulation (sec)";
	public static final String DISPLAY_NAME_paramItersPerPar = "Number of simulation repetitions with same input (for statistical accuracy)";
	public static final String DISPLAY_NAME_paramTotalIterNum = "Number of parameter update iterations before output";
	public static final String DISPLAY_NAME_updatedParameters = "updated parameters";
	public static final String DISPLAY_NAME_updatedParameters1 = "Min GREEN time for WEST-EAST traffic (sec)";
	public static final String DISPLAY_NAME_updatedParameters2 = "Max GREEN time for WEST-EAST traffic (sec)";
	public static final String DISPLAY_NAME_updatedParameters3 = "Min GREEN time for SOUTH-NORTH traffic (sec)";
	public static final String DISPLAY_NAME_updatedParameters4 = "Max GREEN time for SOUTH-NORTH traffic (sec)";
	public static final String DISPLAY_NAME_updatedParameters5 = "Pedestrian waiting time tolerance threshold for NORTH-SOUTH (sec)";
	public static final String DISPLAY_NAME_updatedParameters6 = "Pedestrian waiting time tolerance threshold for WEST-EAST (sec)";
	public static final String DISPLAY_NAME_updatedParameters7 = "Vehicle queue length threshold between low-high content for WEST-EAST";
	public static final String DISPLAY_NAME_updatedParameters8 = "Vehicle queue length threshold between low-high content for SOUTH-NORTH";
	public static final String DISPLAY_NAME_updatedParameters9 = "Pedestrian queue length threshold between low-high content for NORTH-SOUTH";
	public static final String DISPLAY_NAME_updatedParameters10 = "Pedestrian queue length threshold between low-high content for WEST-EAST";
	public static final String DISPLAY_NAME_updatedPerformance = "updated performance";
	public static final String DISPLAY_NAME_averageQueueLength = "Average queue length";
	public static final String DISPLAY_NAME_updatedPerformanceWaitWestEastVehicleSec = "Average waiting time for WEST-EAST vehicles (sec)";
	public static final String DISPLAY_NAME_updatedPerformanceWaitSouthNorthVehicleSec = "Average waiting time for SOUTH-NORTH vehicles (sec)";
	public static final String DISPLAY_NAME_updatedPerformanceWaitAllVehicleSec = "Average waiting time for all vehicles (sec)";
	public static final String DISPLAY_NAME_updatedPerformanceWaitAllPedestrianSec = "Average waiting time for pedestrians (sec)";
	public static final String DISPLAY_NAME_updatedPerformanceWaitAllVehiclePedestrianSec = "Average waiting time for vehicles and pedestrians (sec)";
	public static final String DISPLAY_NAME_avgQueueLengthWestEastVehicle = "Average queue length for WEST-EAST vehicle";
	public static final String DISPLAY_NAME_avgQueueLengthSouthNorthVehicle = "Average queue length for SOUTH-NORTH vehicle";
	public static final String DISPLAY_NAME_avgQueueLengthNorthSouthPedestrian = "Average queue length for NORTH-SOUTH pedestrian";
	public static final String DISPLAY_NAME_avgQueueLengthWestEastPedestrian = "Average queue length for WEST-EAST pedestrian";
	public static final String DISPLAY_NAME_reportStatus = "report status";
	public static final String DISPLAY_NAME_reportProgress = "report progress";

	public static String displayNameForClass(String var) {
		return SimulationReport.displayNameSimulationReport(var);
	}
	public static String displayNameSimulationReport(String var) {
		switch(var) {
		case VAR_reportName:
			return DISPLAY_NAME_reportName;
		case VAR_location:
			return DISPLAY_NAME_location;
		case VAR_simulationKey:
			return DISPLAY_NAME_simulationKey;
		case VAR_simulationSearch:
			return DISPLAY_NAME_simulationSearch;
		case VAR_simulation_:
			return DISPLAY_NAME_simulation_;
		case VAR_observedSearch:
			return DISPLAY_NAME_observedSearch;
		case VAR_areaServedColors:
			return DISPLAY_NAME_areaServedColors;
		case VAR_areaServedTitles:
			return DISPLAY_NAME_areaServedTitles;
		case VAR_areaServedLinks:
			return DISPLAY_NAME_areaServedLinks;
		case VAR_areaServed:
			return DISPLAY_NAME_areaServed;
		case VAR_smartTrafficLightKey:
			return DISPLAY_NAME_smartTrafficLightKey;
		case VAR_smartTrafficLightSearch:
			return DISPLAY_NAME_smartTrafficLightSearch;
		case VAR_smartTrafficLight_:
			return DISPLAY_NAME_smartTrafficLight_;
		case VAR_simulationName:
			return DISPLAY_NAME_simulationName;
		case VAR_smartTrafficLightId:
			return DISPLAY_NAME_smartTrafficLightId;
		case VAR_smartTrafficLightName:
			return DISPLAY_NAME_smartTrafficLightName;
		case VAR_paramAvgVehiclePerMinFromWestToEast:
			return DISPLAY_NAME_paramAvgVehiclePerMinFromWestToEast;
		case VAR_paramAvgVehiclePerMinFromSouthToNorth:
			return DISPLAY_NAME_paramAvgVehiclePerMinFromSouthToNorth;
		case VAR_paramVehicleDemandScalingFactor:
			return DISPLAY_NAME_paramVehicleDemandScalingFactor;
		case VAR_paramAvgPedestrianPerMinFromWestToEast:
			return DISPLAY_NAME_paramAvgPedestrianPerMinFromWestToEast;
		case VAR_paramAvgPedestrianPerMinFromSouthToNorth:
			return DISPLAY_NAME_paramAvgPedestrianPerMinFromSouthToNorth;
		case VAR_paramPedestrianDemandScalingFactor:
			return DISPLAY_NAME_paramPedestrianDemandScalingFactor;
		case VAR_paramLam:
			return DISPLAY_NAME_paramLam;
		case VAR_paramMinGreenTimeSecWestEast:
			return DISPLAY_NAME_paramMinGreenTimeSecWestEast;
		case VAR_paramMaxGreenTimeSecWestEast:
			return DISPLAY_NAME_paramMaxGreenTimeSecWestEast;
		case VAR_paramMinGreenTimeSecSouthNorth:
			return DISPLAY_NAME_paramMinGreenTimeSecSouthNorth;
		case VAR_paramMaxGreenTimeSecSouthNorth:
			return DISPLAY_NAME_paramMaxGreenTimeSecSouthNorth;
		case VAR_paramPedestrianWaitThresholdSecNorthSouth:
			return DISPLAY_NAME_paramPedestrianWaitThresholdSecNorthSouth;
		case VAR_paramPedestrianWaitThresholdSecWestEast:
			return DISPLAY_NAME_paramPedestrianWaitThresholdSecWestEast;
		case VAR_paramVehicleQueueThresholdWestEast:
			return DISPLAY_NAME_paramVehicleQueueThresholdWestEast;
		case VAR_paramVehicleQueueThresholdSouthNorth:
			return DISPLAY_NAME_paramVehicleQueueThresholdSouthNorth;
		case VAR_paramPedestrianQueueThresholdNorthSouth:
			return DISPLAY_NAME_paramPedestrianQueueThresholdNorthSouth;
		case VAR_paramPedestrianQueueThresholdWestEast:
			return DISPLAY_NAME_paramPedestrianQueueThresholdWestEast;
		case VAR_paramDemandScale:
			return DISPLAY_NAME_paramDemandScale;
		case VAR_paramInitialPar:
			return DISPLAY_NAME_paramInitialPar;
		case VAR_paramStepSize:
			return DISPLAY_NAME_paramStepSize;
		case VAR_paramRunTime:
			return DISPLAY_NAME_paramRunTime;
		case VAR_paramItersPerPar:
			return DISPLAY_NAME_paramItersPerPar;
		case VAR_paramTotalIterNum:
			return DISPLAY_NAME_paramTotalIterNum;
		case VAR_updatedParameters:
			return DISPLAY_NAME_updatedParameters;
		case VAR_updatedParameters1:
			return DISPLAY_NAME_updatedParameters1;
		case VAR_updatedParameters2:
			return DISPLAY_NAME_updatedParameters2;
		case VAR_updatedParameters3:
			return DISPLAY_NAME_updatedParameters3;
		case VAR_updatedParameters4:
			return DISPLAY_NAME_updatedParameters4;
		case VAR_updatedParameters5:
			return DISPLAY_NAME_updatedParameters5;
		case VAR_updatedParameters6:
			return DISPLAY_NAME_updatedParameters6;
		case VAR_updatedParameters7:
			return DISPLAY_NAME_updatedParameters7;
		case VAR_updatedParameters8:
			return DISPLAY_NAME_updatedParameters8;
		case VAR_updatedParameters9:
			return DISPLAY_NAME_updatedParameters9;
		case VAR_updatedParameters10:
			return DISPLAY_NAME_updatedParameters10;
		case VAR_updatedPerformance:
			return DISPLAY_NAME_updatedPerformance;
		case VAR_averageQueueLength:
			return DISPLAY_NAME_averageQueueLength;
		case VAR_updatedPerformanceWaitWestEastVehicleSec:
			return DISPLAY_NAME_updatedPerformanceWaitWestEastVehicleSec;
		case VAR_updatedPerformanceWaitSouthNorthVehicleSec:
			return DISPLAY_NAME_updatedPerformanceWaitSouthNorthVehicleSec;
		case VAR_updatedPerformanceWaitAllVehicleSec:
			return DISPLAY_NAME_updatedPerformanceWaitAllVehicleSec;
		case VAR_updatedPerformanceWaitAllPedestrianSec:
			return DISPLAY_NAME_updatedPerformanceWaitAllPedestrianSec;
		case VAR_updatedPerformanceWaitAllVehiclePedestrianSec:
			return DISPLAY_NAME_updatedPerformanceWaitAllVehiclePedestrianSec;
		case VAR_avgQueueLengthWestEastVehicle:
			return DISPLAY_NAME_avgQueueLengthWestEastVehicle;
		case VAR_avgQueueLengthSouthNorthVehicle:
			return DISPLAY_NAME_avgQueueLengthSouthNorthVehicle;
		case VAR_avgQueueLengthNorthSouthPedestrian:
			return DISPLAY_NAME_avgQueueLengthNorthSouthPedestrian;
		case VAR_avgQueueLengthWestEastPedestrian:
			return DISPLAY_NAME_avgQueueLengthWestEastPedestrian;
		case VAR_reportStatus:
			return DISPLAY_NAME_reportStatus;
		case VAR_reportProgress:
			return DISPLAY_NAME_reportProgress;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionSimulationReport(String var) {
		switch(var) {
		case VAR_simulationKey:
			return "The traffic simulation for this report. ";
		case VAR_areaServedColors:
			return "The colors of each areaServed Paths. ";
		case VAR_areaServedTitles:
			return "The titles of each areaServed Paths. ";
		case VAR_areaServedLinks:
			return "The links of each areaServed Paths. ";
		case VAR_areaServed:
			return "The geographic area where a service or offered item is provided. Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon. ";
		case VAR_smartTrafficLightKey:
			return "The smart traffic light for this report. ";
		case VAR_paramAvgVehiclePerMinFromWestToEast:
			return "[1, 30] corresponding to 1st value in list";
		case VAR_paramAvgVehiclePerMinFromSouthToNorth:
			return "[1, 30] corresponding to 2nd value in list";
		case VAR_paramVehicleDemandScalingFactor:
			return "[1, 2] corresponding to \"demand scale\"";
		case VAR_paramAvgPedestrianPerMinFromWestToEast:
			return "[1, 30] corresponding to 3rd value in list";
		case VAR_paramAvgPedestrianPerMinFromSouthToNorth:
			return "[1, 30] corresponding to 4th value in list";
		case VAR_paramPedestrianDemandScalingFactor:
			return "[1, 2] corresponding to \"demand scale\"";
		case VAR_paramMinGreenTimeSecWestEast:
			return "[1, 50]";
		case VAR_paramMaxGreenTimeSecWestEast:
			return "[1, 100], also greater than min value";
		case VAR_paramMinGreenTimeSecSouthNorth:
			return "[1, 50]";
		case VAR_paramMaxGreenTimeSecSouthNorth:
			return "[1, 100], also greater than min value";
		case VAR_paramPedestrianWaitThresholdSecNorthSouth:
			return "[1, 60]";
		case VAR_paramPedestrianWaitThresholdSecWestEast:
			return "[1, 60]";
		case VAR_paramVehicleQueueThresholdWestEast:
			return "[1, 15]";
		case VAR_paramVehicleQueueThresholdSouthNorth:
			return "[1, 15]";
		case VAR_paramPedestrianQueueThresholdNorthSouth:
			return "[1, 15]";
		case VAR_paramPedestrianQueueThresholdWestEast:
			return "[1, 15]";
		case VAR_paramStepSize:
			return "[0.5, 2.0]";
		case VAR_paramRunTime:
			return "[500, 3600]";
		case VAR_paramItersPerPar:
			return "[1, 30]";
		case VAR_paramTotalIterNum:
			return "[1, 30]";
		case VAR_updatedParameters:
			return "the resulting updated parameters after a simulation";
		case VAR_updatedPerformance:
			return "the resulting updated performance after a simulation";
		case VAR_reportStatus:
			return "The current status of the simulation report. ";
		case VAR_reportProgress:
			return "The percent progress of the simulation report. ";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameSimulationReport(String var) {
		switch(var) {
		case VAR_reportName:
			return "String";
		case VAR_location:
			return "Point";
		case VAR_simulationKey:
			return "Long";
		case VAR_simulationSearch:
			return "SearchList";
		case VAR_simulation_:
			return "TrafficSimulation";
		case VAR_observedSearch:
			return "SearchList";
		case VAR_areaServedColors:
			return "List";
		case VAR_areaServedTitles:
			return "List";
		case VAR_areaServedLinks:
			return "List";
		case VAR_areaServed:
			return "List";
		case VAR_smartTrafficLightKey:
			return "Long";
		case VAR_smartTrafficLightSearch:
			return "SearchList";
		case VAR_smartTrafficLight_:
			return "SmartTrafficLight";
		case VAR_simulationName:
			return "String";
		case VAR_smartTrafficLightId:
			return "String";
		case VAR_smartTrafficLightName:
			return "String";
		case VAR_paramAvgVehiclePerMinFromWestToEast:
			return "BigDecimal";
		case VAR_paramAvgVehiclePerMinFromSouthToNorth:
			return "BigDecimal";
		case VAR_paramVehicleDemandScalingFactor:
			return "BigDecimal";
		case VAR_paramAvgPedestrianPerMinFromWestToEast:
			return "BigDecimal";
		case VAR_paramAvgPedestrianPerMinFromSouthToNorth:
			return "BigDecimal";
		case VAR_paramPedestrianDemandScalingFactor:
			return "BigDecimal";
		case VAR_paramLam:
			return "List";
		case VAR_paramMinGreenTimeSecWestEast:
			return "BigDecimal";
		case VAR_paramMaxGreenTimeSecWestEast:
			return "BigDecimal";
		case VAR_paramMinGreenTimeSecSouthNorth:
			return "BigDecimal";
		case VAR_paramMaxGreenTimeSecSouthNorth:
			return "BigDecimal";
		case VAR_paramPedestrianWaitThresholdSecNorthSouth:
			return "BigDecimal";
		case VAR_paramPedestrianWaitThresholdSecWestEast:
			return "BigDecimal";
		case VAR_paramVehicleQueueThresholdWestEast:
			return "BigDecimal";
		case VAR_paramVehicleQueueThresholdSouthNorth:
			return "BigDecimal";
		case VAR_paramPedestrianQueueThresholdNorthSouth:
			return "BigDecimal";
		case VAR_paramPedestrianQueueThresholdWestEast:
			return "BigDecimal";
		case VAR_paramDemandScale:
			return "List";
		case VAR_paramInitialPar:
			return "List";
		case VAR_paramStepSize:
			return "BigDecimal";
		case VAR_paramRunTime:
			return "Integer";
		case VAR_paramItersPerPar:
			return "Integer";
		case VAR_paramTotalIterNum:
			return "Integer";
		case VAR_updatedParameters:
			return "JsonArray";
		case VAR_updatedParameters1:
			return "JsonArray";
		case VAR_updatedParameters2:
			return "JsonArray";
		case VAR_updatedParameters3:
			return "JsonArray";
		case VAR_updatedParameters4:
			return "JsonArray";
		case VAR_updatedParameters5:
			return "JsonArray";
		case VAR_updatedParameters6:
			return "JsonArray";
		case VAR_updatedParameters7:
			return "JsonArray";
		case VAR_updatedParameters8:
			return "JsonArray";
		case VAR_updatedParameters9:
			return "JsonArray";
		case VAR_updatedParameters10:
			return "JsonArray";
		case VAR_updatedPerformance:
			return "JsonArray";
		case VAR_averageQueueLength:
			return "JsonArray";
		case VAR_updatedPerformanceWaitWestEastVehicleSec:
			return "JsonArray";
		case VAR_updatedPerformanceWaitSouthNorthVehicleSec:
			return "JsonArray";
		case VAR_updatedPerformanceWaitAllVehicleSec:
			return "JsonArray";
		case VAR_updatedPerformanceWaitAllPedestrianSec:
			return "JsonArray";
		case VAR_updatedPerformanceWaitAllVehiclePedestrianSec:
			return "JsonArray";
		case VAR_avgQueueLengthWestEastVehicle:
			return "JsonArray";
		case VAR_avgQueueLengthSouthNorthVehicle:
			return "JsonArray";
		case VAR_avgQueueLengthNorthSouthPedestrian:
			return "JsonArray";
		case VAR_avgQueueLengthWestEastPedestrian:
			return "JsonArray";
		case VAR_reportStatus:
			return "String";
		case VAR_reportProgress:
			return "Integer";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmColumnSimulationReport(String var) {
		switch(var) {
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowSimulationReport(String var) {
		switch(var) {
		case VAR_reportName:
			return 3;
		case VAR_location:
			return 3;
		case VAR_simulationKey:
			return 4;
		case VAR_smartTrafficLightKey:
			return 4;
		case VAR_paramAvgVehiclePerMinFromWestToEast:
			return 5;
		case VAR_paramAvgVehiclePerMinFromSouthToNorth:
			return 5;
		case VAR_paramVehicleDemandScalingFactor:
			return 5;
		case VAR_paramAvgPedestrianPerMinFromWestToEast:
			return 6;
		case VAR_paramAvgPedestrianPerMinFromSouthToNorth:
			return 6;
		case VAR_paramPedestrianDemandScalingFactor:
			return 6;
		case VAR_paramMinGreenTimeSecWestEast:
			return 7;
		case VAR_paramMaxGreenTimeSecWestEast:
			return 7;
		case VAR_paramMinGreenTimeSecSouthNorth:
			return 7;
		case VAR_paramMaxGreenTimeSecSouthNorth:
			return 7;
		case VAR_paramPedestrianWaitThresholdSecNorthSouth:
			return 7;
		case VAR_paramPedestrianWaitThresholdSecWestEast:
			return 7;
		case VAR_paramVehicleQueueThresholdWestEast:
			return 7;
		case VAR_paramVehicleQueueThresholdSouthNorth:
			return 7;
		case VAR_paramPedestrianQueueThresholdNorthSouth:
			return 7;
		case VAR_paramPedestrianQueueThresholdWestEast:
			return 7;
		case VAR_paramStepSize:
			return 12;
		case VAR_paramRunTime:
			return 12;
		case VAR_paramItersPerPar:
			return 12;
		case VAR_paramTotalIterNum:
			return 12;
		case VAR_updatedParameters1:
			return 14;
		case VAR_updatedParameters2:
			return 14;
		case VAR_updatedParameters3:
			return 14;
		case VAR_updatedParameters4:
			return 14;
		case VAR_updatedParameters5:
			return 14;
		case VAR_updatedParameters6:
			return 14;
		case VAR_updatedParameters7:
			return 14;
		case VAR_updatedParameters8:
			return 14;
		case VAR_updatedParameters9:
			return 14;
		case VAR_updatedParameters10:
			return 14;
		case VAR_updatedPerformanceWaitWestEastVehicleSec:
			return 16;
		case VAR_updatedPerformanceWaitSouthNorthVehicleSec:
			return 16;
		case VAR_updatedPerformanceWaitAllVehicleSec:
			return 16;
		case VAR_updatedPerformanceWaitAllPedestrianSec:
			return 16;
		case VAR_updatedPerformanceWaitAllVehiclePedestrianSec:
			return 16;
		case VAR_avgQueueLengthWestEastVehicle:
			return 17;
		case VAR_avgQueueLengthSouthNorthVehicle:
			return 17;
		case VAR_avgQueueLengthNorthSouthPedestrian:
			return 17;
		case VAR_avgQueueLengthWestEastPedestrian:
			return 17;
		case VAR_reportStatus:
			return 18;
		case VAR_reportProgress:
			return 18;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellSimulationReport(String var) {
		switch(var) {
		case VAR_reportName:
			return 1;
		case VAR_location:
			return 2;
		case VAR_simulationKey:
			return 1;
		case VAR_smartTrafficLightKey:
			return 2;
		case VAR_paramAvgVehiclePerMinFromWestToEast:
			return 1;
		case VAR_paramAvgVehiclePerMinFromSouthToNorth:
			return 2;
		case VAR_paramVehicleDemandScalingFactor:
			return 3;
		case VAR_paramAvgPedestrianPerMinFromWestToEast:
			return 1;
		case VAR_paramAvgPedestrianPerMinFromSouthToNorth:
			return 2;
		case VAR_paramPedestrianDemandScalingFactor:
			return 3;
		case VAR_paramMinGreenTimeSecWestEast:
			return 1;
		case VAR_paramMaxGreenTimeSecWestEast:
			return 2;
		case VAR_paramMinGreenTimeSecSouthNorth:
			return 3;
		case VAR_paramMaxGreenTimeSecSouthNorth:
			return 4;
		case VAR_paramPedestrianWaitThresholdSecNorthSouth:
			return 5;
		case VAR_paramPedestrianWaitThresholdSecWestEast:
			return 6;
		case VAR_paramVehicleQueueThresholdWestEast:
			return 7;
		case VAR_paramVehicleQueueThresholdSouthNorth:
			return 8;
		case VAR_paramPedestrianQueueThresholdNorthSouth:
			return 9;
		case VAR_paramPedestrianQueueThresholdWestEast:
			return 10;
		case VAR_paramStepSize:
			return 1;
		case VAR_paramRunTime:
			return 2;
		case VAR_paramItersPerPar:
			return 3;
		case VAR_paramTotalIterNum:
			return 4;
		case VAR_updatedParameters1:
			return 1;
		case VAR_updatedParameters2:
			return 2;
		case VAR_updatedParameters3:
			return 3;
		case VAR_updatedParameters4:
			return 4;
		case VAR_updatedParameters5:
			return 5;
		case VAR_updatedParameters6:
			return 6;
		case VAR_updatedParameters7:
			return 7;
		case VAR_updatedParameters8:
			return 8;
		case VAR_updatedParameters9:
			return 9;
		case VAR_updatedParameters10:
			return 10;
		case VAR_updatedPerformanceWaitWestEastVehicleSec:
			return 1;
		case VAR_updatedPerformanceWaitSouthNorthVehicleSec:
			return 2;
		case VAR_updatedPerformanceWaitAllVehicleSec:
			return 3;
		case VAR_updatedPerformanceWaitAllPedestrianSec:
			return 4;
		case VAR_updatedPerformanceWaitAllVehiclePedestrianSec:
			return 5;
		case VAR_avgQueueLengthWestEastVehicle:
			return 1;
		case VAR_avgQueueLengthSouthNorthVehicle:
			return 2;
		case VAR_avgQueueLengthNorthSouthPedestrian:
			return 3;
		case VAR_avgQueueLengthWestEastPedestrian:
			return 4;
		case VAR_reportStatus:
			return 1;
		case VAR_reportProgress:
			return 2;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinSimulationReport(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxSimulationReport(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxSimulationReport(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minSimulationReport(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
