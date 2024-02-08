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
package org.computate.smartvillage.enus.model.traffic.simulation.map;

import org.computate.smartvillage.enus.request.SiteRequestEnUS;
import org.computate.smartvillage.enus.model.base.BaseModelPage;
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
import org.computate.vertx.search.list.SearchList;
import org.computate.smartvillage.enus.model.traffic.simulation.TrafficSimulation;
import java.lang.String;
import java.time.ZoneId;
import java.util.Locale;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.lang.Integer;
import io.vertx.core.json.JsonObject;
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import java.lang.Long;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these TrafficSimulationMapPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class TrafficSimulationMapPageGen into the class TrafficSimulationMapPage. 
 * </li>
 * <h3>About the TrafficSimulationMapPage class and it's generated class TrafficSimulationMapPageGen&lt;BaseModelPage&gt;: </h3>extends TrafficSimulationMapPageGen
 * <p>
 * This Java class extends a generated Java class TrafficSimulationMapPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage">Find the class TrafficSimulationMapPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends TrafficSimulationMapPageGen<BaseModelPage>
 * <p>This <code>class TrafficSimulationMapPage extends TrafficSimulationMapPageGen&lt;BaseModelPage&gt;</code>, which means it extends a newly generated TrafficSimulationMapPageGen. 
 * The generated <code>class TrafficSimulationMapPageGen extends BaseModelPage</code> which means that TrafficSimulationMapPage extends TrafficSimulationMapPageGen which extends BaseModelPage. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>IconGroup: null</h2>
 * <h2>IconName: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the TrafficSimulationMapPage class will inherit the helpful inherited class comments from the super class TrafficSimulationMapPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the TrafficSimulationMapPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class TrafficSimulationMapPage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.traffic.simulation.map in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class TrafficSimulationMapPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(TrafficSimulationMapPage.class);

	//////////////////////////////////
	// searchListTrafficSimulation_ //
	//////////////////////////////////


	/**	 The entity searchListTrafficSimulation_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<TrafficSimulation> searchListTrafficSimulation_;

	/**	<br> The entity searchListTrafficSimulation_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:searchListTrafficSimulation_">Find the entity searchListTrafficSimulation_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListTrafficSimulation_(Wrap<SearchList<TrafficSimulation>> w);

	public SearchList<TrafficSimulation> getSearchListTrafficSimulation_() {
		return searchListTrafficSimulation_;
	}

	public void setSearchListTrafficSimulation_(SearchList<TrafficSimulation> searchListTrafficSimulation_) {
		this.searchListTrafficSimulation_ = searchListTrafficSimulation_;
	}
	public static SearchList<TrafficSimulation> staticSetSearchListTrafficSimulation_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficSimulationMapPage searchListTrafficSimulation_Init() {
		Wrap<SearchList<TrafficSimulation>> searchListTrafficSimulation_Wrap = new Wrap<SearchList<TrafficSimulation>>().var("searchListTrafficSimulation_");
		if(searchListTrafficSimulation_ == null) {
			_searchListTrafficSimulation_(searchListTrafficSimulation_Wrap);
			Optional.ofNullable(searchListTrafficSimulation_Wrap.getO()).ifPresent(o -> {
				setSearchListTrafficSimulation_(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	//////////////////
	// pageResponse //
	//////////////////


	/**	 The entity pageResponse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageResponse;

	/**	<br> The entity pageResponse
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:pageResponse">Find the entity pageResponse in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageResponse(Wrap<String> w);

	public String getPageResponse() {
		return pageResponse;
	}
	public void setPageResponse(String o) {
		this.pageResponse = TrafficSimulationMapPage.staticSetPageResponse(siteRequest_, o);
	}
	public static String staticSetPageResponse(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage pageResponseInit() {
		Wrap<String> pageResponseWrap = new Wrap<String>().var("pageResponse");
		if(pageResponse == null) {
			_pageResponse(pageResponseWrap);
			Optional.ofNullable(pageResponseWrap.getO()).ifPresent(o -> {
				setPageResponse(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchPageResponse(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageResponse(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageResponse(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchPageResponse(siteRequest_, TrafficSimulationMapPage.staticSetPageResponse(siteRequest_, o)).toString();
	}

	///////////////////
	// defaultZoneId //
	///////////////////


	/**	 The entity defaultZoneId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultZoneId;

	/**	<br> The entity defaultZoneId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultZoneId">Find the entity defaultZoneId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultZoneId(Wrap<String> w);

	public String getDefaultZoneId() {
		return defaultZoneId;
	}
	public void setDefaultZoneId(String o) {
		this.defaultZoneId = TrafficSimulationMapPage.staticSetDefaultZoneId(siteRequest_, o);
	}
	public static String staticSetDefaultZoneId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage defaultZoneIdInit() {
		Wrap<String> defaultZoneIdWrap = new Wrap<String>().var("defaultZoneId");
		if(defaultZoneId == null) {
			_defaultZoneId(defaultZoneIdWrap);
			Optional.ofNullable(defaultZoneIdWrap.getO()).ifPresent(o -> {
				setDefaultZoneId(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultZoneId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultZoneId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultZoneId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultZoneId(siteRequest_, TrafficSimulationMapPage.staticSetDefaultZoneId(siteRequest_, o)).toString();
	}

	/////////////////////
	// defaultTimeZone //
	/////////////////////


	/**	 The entity defaultTimeZone
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected ZoneId defaultTimeZone;

	/**	<br> The entity defaultTimeZone
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultTimeZone">Find the entity defaultTimeZone in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultTimeZone(Wrap<ZoneId> w);

	public ZoneId getDefaultTimeZone() {
		return defaultTimeZone;
	}

	public void setDefaultTimeZone(ZoneId defaultTimeZone) {
		this.defaultTimeZone = defaultTimeZone;
	}
	public static ZoneId staticSetDefaultTimeZone(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficSimulationMapPage defaultTimeZoneInit() {
		Wrap<ZoneId> defaultTimeZoneWrap = new Wrap<ZoneId>().var("defaultTimeZone");
		if(defaultTimeZone == null) {
			_defaultTimeZone(defaultTimeZoneWrap);
			Optional.ofNullable(defaultTimeZoneWrap.getO()).ifPresent(o -> {
				setDefaultTimeZone(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	/////////////////////
	// defaultLocaleId //
	/////////////////////


	/**	 The entity defaultLocaleId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultLocaleId;

	/**	<br> The entity defaultLocaleId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultLocaleId">Find the entity defaultLocaleId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultLocaleId(Wrap<String> w);

	public String getDefaultLocaleId() {
		return defaultLocaleId;
	}
	public void setDefaultLocaleId(String o) {
		this.defaultLocaleId = TrafficSimulationMapPage.staticSetDefaultLocaleId(siteRequest_, o);
	}
	public static String staticSetDefaultLocaleId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage defaultLocaleIdInit() {
		Wrap<String> defaultLocaleIdWrap = new Wrap<String>().var("defaultLocaleId");
		if(defaultLocaleId == null) {
			_defaultLocaleId(defaultLocaleIdWrap);
			Optional.ofNullable(defaultLocaleIdWrap.getO()).ifPresent(o -> {
				setDefaultLocaleId(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultLocaleId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultLocaleId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultLocaleId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultLocaleId(siteRequest_, TrafficSimulationMapPage.staticSetDefaultLocaleId(siteRequest_, o)).toString();
	}

	///////////////////
	// defaultLocale //
	///////////////////


	/**	 The entity defaultLocale
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Locale defaultLocale;

	/**	<br> The entity defaultLocale
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultLocale">Find the entity defaultLocale in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultLocale(Wrap<Locale> w);

	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}
	public static Locale staticSetDefaultLocale(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficSimulationMapPage defaultLocaleInit() {
		Wrap<Locale> defaultLocaleWrap = new Wrap<Locale>().var("defaultLocale");
		if(defaultLocale == null) {
			_defaultLocale(defaultLocaleWrap);
			Optional.ofNullable(defaultLocaleWrap.getO()).ifPresent(o -> {
				setDefaultLocale(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	/////////////////////
	// defaultRangeGap //
	/////////////////////


	/**	 The entity defaultRangeGap
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultRangeGap;

	/**	<br> The entity defaultRangeGap
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultRangeGap">Find the entity defaultRangeGap in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeGap(Wrap<String> w);

	public String getDefaultRangeGap() {
		return defaultRangeGap;
	}
	public void setDefaultRangeGap(String o) {
		this.defaultRangeGap = TrafficSimulationMapPage.staticSetDefaultRangeGap(siteRequest_, o);
	}
	public static String staticSetDefaultRangeGap(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage defaultRangeGapInit() {
		Wrap<String> defaultRangeGapWrap = new Wrap<String>().var("defaultRangeGap");
		if(defaultRangeGap == null) {
			_defaultRangeGap(defaultRangeGapWrap);
			Optional.ofNullable(defaultRangeGapWrap.getO()).ifPresent(o -> {
				setDefaultRangeGap(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultRangeGap(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultRangeGap(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultRangeGap(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultRangeGap(siteRequest_, TrafficSimulationMapPage.staticSetDefaultRangeGap(siteRequest_, o)).toString();
	}

	/////////////////////
	// defaultRangeEnd //
	/////////////////////


	/**	 The entity defaultRangeEnd
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime defaultRangeEnd;

	/**	<br> The entity defaultRangeEnd
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultRangeEnd">Find the entity defaultRangeEnd in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeEnd(Wrap<ZonedDateTime> w);

	public ZonedDateTime getDefaultRangeEnd() {
		return defaultRangeEnd;
	}

	public void setDefaultRangeEnd(ZonedDateTime defaultRangeEnd) {
		this.defaultRangeEnd = Optional.ofNullable(defaultRangeEnd).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
	}
	@JsonIgnore
	public void setDefaultRangeEnd(Instant o) {
		this.defaultRangeEnd = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setDefaultRangeEnd(String o) {
		this.defaultRangeEnd = TrafficSimulationMapPage.staticSetDefaultRangeEnd(siteRequest_, o);
	}
	public static ZonedDateTime staticSetDefaultRangeEnd(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setDefaultRangeEnd(Date o) {
		this.defaultRangeEnd = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected TrafficSimulationMapPage defaultRangeEndInit() {
		Wrap<ZonedDateTime> defaultRangeEndWrap = new Wrap<ZonedDateTime>().var("defaultRangeEnd");
		if(defaultRangeEnd == null) {
			_defaultRangeEnd(defaultRangeEndWrap);
			Optional.ofNullable(defaultRangeEndWrap.getO()).ifPresent(o -> {
				setDefaultRangeEnd(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultRangeEnd(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
	}

	public static String staticSearchStrDefaultRangeEnd(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultRangeEnd(siteRequest_, TrafficSimulationMapPage.staticSetDefaultRangeEnd(siteRequest_, o));
	}

	public static String staticSearchFqDefaultRangeEnd(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultRangeEnd(siteRequest_, TrafficSimulationMapPage.staticSetDefaultRangeEnd(siteRequest_, o)).toString();
	}

	///////////////////////
	// defaultRangeStart //
	///////////////////////


	/**	 The entity defaultRangeStart
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime defaultRangeStart;

	/**	<br> The entity defaultRangeStart
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultRangeStart">Find the entity defaultRangeStart in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeStart(Wrap<ZonedDateTime> w);

	public ZonedDateTime getDefaultRangeStart() {
		return defaultRangeStart;
	}

	public void setDefaultRangeStart(ZonedDateTime defaultRangeStart) {
		this.defaultRangeStart = Optional.ofNullable(defaultRangeStart).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
	}
	@JsonIgnore
	public void setDefaultRangeStart(Instant o) {
		this.defaultRangeStart = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setDefaultRangeStart(String o) {
		this.defaultRangeStart = TrafficSimulationMapPage.staticSetDefaultRangeStart(siteRequest_, o);
	}
	public static ZonedDateTime staticSetDefaultRangeStart(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setDefaultRangeStart(Date o) {
		this.defaultRangeStart = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected TrafficSimulationMapPage defaultRangeStartInit() {
		Wrap<ZonedDateTime> defaultRangeStartWrap = new Wrap<ZonedDateTime>().var("defaultRangeStart");
		if(defaultRangeStart == null) {
			_defaultRangeStart(defaultRangeStartWrap);
			Optional.ofNullable(defaultRangeStartWrap.getO()).ifPresent(o -> {
				setDefaultRangeStart(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultRangeStart(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
	}

	public static String staticSearchStrDefaultRangeStart(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultRangeStart(siteRequest_, TrafficSimulationMapPage.staticSetDefaultRangeStart(siteRequest_, o));
	}

	public static String staticSearchFqDefaultRangeStart(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultRangeStart(siteRequest_, TrafficSimulationMapPage.staticSetDefaultRangeStart(siteRequest_, o)).toString();
	}

	/////////////////////
	// defaultRangeVar //
	/////////////////////


	/**	 The entity defaultRangeVar
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultRangeVar;

	/**	<br> The entity defaultRangeVar
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultRangeVar">Find the entity defaultRangeVar in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeVar(Wrap<String> w);

	public String getDefaultRangeVar() {
		return defaultRangeVar;
	}
	public void setDefaultRangeVar(String o) {
		this.defaultRangeVar = TrafficSimulationMapPage.staticSetDefaultRangeVar(siteRequest_, o);
	}
	public static String staticSetDefaultRangeVar(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage defaultRangeVarInit() {
		Wrap<String> defaultRangeVarWrap = new Wrap<String>().var("defaultRangeVar");
		if(defaultRangeVar == null) {
			_defaultRangeVar(defaultRangeVarWrap);
			Optional.ofNullable(defaultRangeVarWrap.getO()).ifPresent(o -> {
				setDefaultRangeVar(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultRangeVar(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultRangeVar(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultRangeVar(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultRangeVar(siteRequest_, TrafficSimulationMapPage.staticSetDefaultRangeVar(siteRequest_, o)).toString();
	}

	//////////////////////
	// defaultFacetSort //
	//////////////////////


	/**	 The entity defaultFacetSort
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultFacetSort;

	/**	<br> The entity defaultFacetSort
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultFacetSort">Find the entity defaultFacetSort in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultFacetSort(Wrap<String> w);

	public String getDefaultFacetSort() {
		return defaultFacetSort;
	}
	public void setDefaultFacetSort(String o) {
		this.defaultFacetSort = TrafficSimulationMapPage.staticSetDefaultFacetSort(siteRequest_, o);
	}
	public static String staticSetDefaultFacetSort(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage defaultFacetSortInit() {
		Wrap<String> defaultFacetSortWrap = new Wrap<String>().var("defaultFacetSort");
		if(defaultFacetSort == null) {
			_defaultFacetSort(defaultFacetSortWrap);
			Optional.ofNullable(defaultFacetSortWrap.getO()).ifPresent(o -> {
				setDefaultFacetSort(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDefaultFacetSort(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultFacetSort(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFacetSort(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultFacetSort(siteRequest_, TrafficSimulationMapPage.staticSetDefaultFacetSort(siteRequest_, o)).toString();
	}

	///////////////////////
	// defaultFacetLimit //
	///////////////////////


	/**	 The entity defaultFacetLimit
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer defaultFacetLimit;

	/**	<br> The entity defaultFacetLimit
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultFacetLimit">Find the entity defaultFacetLimit in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultFacetLimit(Wrap<Integer> w);

	public Integer getDefaultFacetLimit() {
		return defaultFacetLimit;
	}

	public void setDefaultFacetLimit(Integer defaultFacetLimit) {
		this.defaultFacetLimit = defaultFacetLimit;
	}
	@JsonIgnore
	public void setDefaultFacetLimit(String o) {
		this.defaultFacetLimit = TrafficSimulationMapPage.staticSetDefaultFacetLimit(siteRequest_, o);
	}
	public static Integer staticSetDefaultFacetLimit(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected TrafficSimulationMapPage defaultFacetLimitInit() {
		Wrap<Integer> defaultFacetLimitWrap = new Wrap<Integer>().var("defaultFacetLimit");
		if(defaultFacetLimit == null) {
			_defaultFacetLimit(defaultFacetLimitWrap);
			Optional.ofNullable(defaultFacetLimitWrap.getO()).ifPresent(o -> {
				setDefaultFacetLimit(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static Integer staticSearchDefaultFacetLimit(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDefaultFacetLimit(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFacetLimit(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultFacetLimit(siteRequest_, TrafficSimulationMapPage.staticSetDefaultFacetLimit(siteRequest_, o)).toString();
	}

	//////////////////////////
	// defaultFacetMinCount //
	//////////////////////////


	/**	 The entity defaultFacetMinCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer defaultFacetMinCount;

	/**	<br> The entity defaultFacetMinCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultFacetMinCount">Find the entity defaultFacetMinCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultFacetMinCount(Wrap<Integer> w);

	public Integer getDefaultFacetMinCount() {
		return defaultFacetMinCount;
	}

	public void setDefaultFacetMinCount(Integer defaultFacetMinCount) {
		this.defaultFacetMinCount = defaultFacetMinCount;
	}
	@JsonIgnore
	public void setDefaultFacetMinCount(String o) {
		this.defaultFacetMinCount = TrafficSimulationMapPage.staticSetDefaultFacetMinCount(siteRequest_, o);
	}
	public static Integer staticSetDefaultFacetMinCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected TrafficSimulationMapPage defaultFacetMinCountInit() {
		Wrap<Integer> defaultFacetMinCountWrap = new Wrap<Integer>().var("defaultFacetMinCount");
		if(defaultFacetMinCount == null) {
			_defaultFacetMinCount(defaultFacetMinCountWrap);
			Optional.ofNullable(defaultFacetMinCountWrap.getO()).ifPresent(o -> {
				setDefaultFacetMinCount(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static Integer staticSearchDefaultFacetMinCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDefaultFacetMinCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFacetMinCount(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultFacetMinCount(siteRequest_, TrafficSimulationMapPage.staticSetDefaultFacetMinCount(siteRequest_, o)).toString();
	}

	//////////////////////////
	// defaultPivotMinCount //
	//////////////////////////


	/**	 The entity defaultPivotMinCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer defaultPivotMinCount;

	/**	<br> The entity defaultPivotMinCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:defaultPivotMinCount">Find the entity defaultPivotMinCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultPivotMinCount(Wrap<Integer> w);

	public Integer getDefaultPivotMinCount() {
		return defaultPivotMinCount;
	}

	public void setDefaultPivotMinCount(Integer defaultPivotMinCount) {
		this.defaultPivotMinCount = defaultPivotMinCount;
	}
	@JsonIgnore
	public void setDefaultPivotMinCount(String o) {
		this.defaultPivotMinCount = TrafficSimulationMapPage.staticSetDefaultPivotMinCount(siteRequest_, o);
	}
	public static Integer staticSetDefaultPivotMinCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected TrafficSimulationMapPage defaultPivotMinCountInit() {
		Wrap<Integer> defaultPivotMinCountWrap = new Wrap<Integer>().var("defaultPivotMinCount");
		if(defaultPivotMinCount == null) {
			_defaultPivotMinCount(defaultPivotMinCountWrap);
			Optional.ofNullable(defaultPivotMinCountWrap.getO()).ifPresent(o -> {
				setDefaultPivotMinCount(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static Integer staticSearchDefaultPivotMinCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDefaultPivotMinCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultPivotMinCount(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDefaultPivotMinCount(siteRequest_, TrafficSimulationMapPage.staticSetDefaultPivotMinCount(siteRequest_, o)).toString();
	}

	//////////////////////////
	// DEFAULT_MAP_LOCATION //
	//////////////////////////


	/**	 The entity DEFAULT_MAP_LOCATION
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject DEFAULT_MAP_LOCATION;

	/**	<br> The entity DEFAULT_MAP_LOCATION
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:DEFAULT_MAP_LOCATION">Find the entity DEFAULT_MAP_LOCATION in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _DEFAULT_MAP_LOCATION(Wrap<JsonObject> w);

	public JsonObject getDEFAULT_MAP_LOCATION() {
		return DEFAULT_MAP_LOCATION;
	}

	public void setDEFAULT_MAP_LOCATION(JsonObject DEFAULT_MAP_LOCATION) {
		this.DEFAULT_MAP_LOCATION = DEFAULT_MAP_LOCATION;
	}
	@JsonIgnore
	public void setDEFAULT_MAP_LOCATION(String o) {
		this.DEFAULT_MAP_LOCATION = TrafficSimulationMapPage.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o);
	}
	public static JsonObject staticSetDEFAULT_MAP_LOCATION(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected TrafficSimulationMapPage DEFAULT_MAP_LOCATIONInit() {
		Wrap<JsonObject> DEFAULT_MAP_LOCATIONWrap = new Wrap<JsonObject>().var("DEFAULT_MAP_LOCATION");
		if(DEFAULT_MAP_LOCATION == null) {
			_DEFAULT_MAP_LOCATION(DEFAULT_MAP_LOCATIONWrap);
			Optional.ofNullable(DEFAULT_MAP_LOCATIONWrap.getO()).ifPresent(o -> {
				setDEFAULT_MAP_LOCATION(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchDEFAULT_MAP_LOCATION(SiteRequestEnUS siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrDEFAULT_MAP_LOCATION(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDEFAULT_MAP_LOCATION(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDEFAULT_MAP_LOCATION(siteRequest_, TrafficSimulationMapPage.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o)).toString();
	}

	//////////////////////
	// DEFAULT_MAP_ZOOM //
	//////////////////////


	/**	 The entity DEFAULT_MAP_ZOOM
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal DEFAULT_MAP_ZOOM;

	/**	<br> The entity DEFAULT_MAP_ZOOM
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:DEFAULT_MAP_ZOOM">Find the entity DEFAULT_MAP_ZOOM in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _DEFAULT_MAP_ZOOM(Wrap<BigDecimal> w);

	public BigDecimal getDEFAULT_MAP_ZOOM() {
		return DEFAULT_MAP_ZOOM;
	}

	public void setDEFAULT_MAP_ZOOM(BigDecimal DEFAULT_MAP_ZOOM) {
		this.DEFAULT_MAP_ZOOM = DEFAULT_MAP_ZOOM;
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(String o) {
		this.DEFAULT_MAP_ZOOM = TrafficSimulationMapPage.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o);
	}
	public static BigDecimal staticSetDEFAULT_MAP_ZOOM(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(Double o) {
		setDEFAULT_MAP_ZOOM(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(Integer o) {
		setDEFAULT_MAP_ZOOM(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(Number o) {
		setDEFAULT_MAP_ZOOM(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected TrafficSimulationMapPage DEFAULT_MAP_ZOOMInit() {
		Wrap<BigDecimal> DEFAULT_MAP_ZOOMWrap = new Wrap<BigDecimal>().var("DEFAULT_MAP_ZOOM");
		if(DEFAULT_MAP_ZOOM == null) {
			_DEFAULT_MAP_ZOOM(DEFAULT_MAP_ZOOMWrap);
			Optional.ofNullable(DEFAULT_MAP_ZOOMWrap.getO()).ifPresent(o -> {
				setDEFAULT_MAP_ZOOM(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static Double staticSearchDEFAULT_MAP_ZOOM(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDEFAULT_MAP_ZOOM(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDEFAULT_MAP_ZOOM(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchDEFAULT_MAP_ZOOM(siteRequest_, TrafficSimulationMapPage.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o)).toString();
	}

	///////////////////////////
	// listTrafficSimulation //
	///////////////////////////


	/**	 The entity listTrafficSimulation
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listTrafficSimulation = new JsonArray();

	/**	<br> The entity listTrafficSimulation
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:listTrafficSimulation">Find the entity listTrafficSimulation in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listTrafficSimulation(JsonArray l);

	public JsonArray getListTrafficSimulation() {
		return listTrafficSimulation;
	}

	public void setListTrafficSimulation(JsonArray listTrafficSimulation) {
		this.listTrafficSimulation = listTrafficSimulation;
	}
	@JsonIgnore
	public void setListTrafficSimulation(String o) {
		this.listTrafficSimulation = TrafficSimulationMapPage.staticSetListTrafficSimulation(siteRequest_, o);
	}
	public static JsonArray staticSetListTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected TrafficSimulationMapPage listTrafficSimulationInit() {
		_listTrafficSimulation(listTrafficSimulation);
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchListTrafficSimulation(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchListTrafficSimulation(siteRequest_, TrafficSimulationMapPage.staticSetListTrafficSimulation(siteRequest_, o)).toString();
	}

	///////////
	// stats //
	///////////


	/**	 The entity stats
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Stats stats;

	/**	<br> The entity stats
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:stats">Find the entity stats in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stats(Wrap<Stats> w);

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	public static Stats staticSetStats(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficSimulationMapPage statsInit() {
		Wrap<Stats> statsWrap = new Wrap<Stats>().var("stats");
		if(stats == null) {
			_stats(statsWrap);
			Optional.ofNullable(statsWrap.getO()).ifPresent(o -> {
				setStats(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	/////////////////
	// facetCounts //
	/////////////////


	/**	 The entity facetCounts
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected FacetCounts facetCounts;

	/**	<br> The entity facetCounts
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:facetCounts">Find the entity facetCounts in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _facetCounts(Wrap<FacetCounts> w);

	public FacetCounts getFacetCounts() {
		return facetCounts;
	}

	public void setFacetCounts(FacetCounts facetCounts) {
		this.facetCounts = facetCounts;
	}
	public static FacetCounts staticSetFacetCounts(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected TrafficSimulationMapPage facetCountsInit() {
		Wrap<FacetCounts> facetCountsWrap = new Wrap<FacetCounts>().var("facetCounts");
		if(facetCounts == null) {
			_facetCounts(facetCountsWrap);
			Optional.ofNullable(facetCountsWrap.getO()).ifPresent(o -> {
				setFacetCounts(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	////////////////////////////
	// trafficSimulationCount //
	////////////////////////////


	/**	 The entity trafficSimulationCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer trafficSimulationCount;

	/**	<br> The entity trafficSimulationCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:trafficSimulationCount">Find the entity trafficSimulationCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _trafficSimulationCount(Wrap<Integer> w);

	public Integer getTrafficSimulationCount() {
		return trafficSimulationCount;
	}

	public void setTrafficSimulationCount(Integer trafficSimulationCount) {
		this.trafficSimulationCount = trafficSimulationCount;
	}
	@JsonIgnore
	public void setTrafficSimulationCount(String o) {
		this.trafficSimulationCount = TrafficSimulationMapPage.staticSetTrafficSimulationCount(siteRequest_, o);
	}
	public static Integer staticSetTrafficSimulationCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected TrafficSimulationMapPage trafficSimulationCountInit() {
		Wrap<Integer> trafficSimulationCountWrap = new Wrap<Integer>().var("trafficSimulationCount");
		if(trafficSimulationCount == null) {
			_trafficSimulationCount(trafficSimulationCountWrap);
			Optional.ofNullable(trafficSimulationCountWrap.getO()).ifPresent(o -> {
				setTrafficSimulationCount(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static Integer staticSearchTrafficSimulationCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTrafficSimulationCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTrafficSimulationCount(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchTrafficSimulationCount(siteRequest_, TrafficSimulationMapPage.staticSetTrafficSimulationCount(siteRequest_, o)).toString();
	}

	////////////////////////
	// trafficSimulation_ //
	////////////////////////


	/**	 The entity trafficSimulation_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected TrafficSimulation trafficSimulation_;

	/**	<br> The entity trafficSimulation_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:trafficSimulation_">Find the entity trafficSimulation_ in Solr</a>
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
	protected TrafficSimulationMapPage trafficSimulation_Init() {
		Wrap<TrafficSimulation> trafficSimulation_Wrap = new Wrap<TrafficSimulation>().var("trafficSimulation_");
		if(trafficSimulation_ == null) {
			_trafficSimulation_(trafficSimulation_Wrap);
			Optional.ofNullable(trafficSimulation_Wrap.getO()).ifPresent(o -> {
				setTrafficSimulation_(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	////////
	// pk //
	////////


	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;

	/**	<br> The entity pk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pk(Wrap<Long> w);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}
	@JsonIgnore
	public void setPk(String o) {
		this.pk = TrafficSimulationMapPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected TrafficSimulationMapPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
				setPk(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchPk(siteRequest_, TrafficSimulationMapPage.staticSetPk(siteRequest_, o)).toString();
	}

	////////
	// id //
	////////


	/**	 The entity id
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String id;

	/**	<br> The entity id
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = TrafficSimulationMapPage.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchId(siteRequest_, TrafficSimulationMapPage.staticSetId(siteRequest_, o)).toString();
	}

	//////////////////////////////
	// pageUriTrafficSimulation //
	//////////////////////////////


	/**	 The entity pageUriTrafficSimulation
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriTrafficSimulation;

	/**	<br> The entity pageUriTrafficSimulation
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.simulation.map.TrafficSimulationMapPage&fq=entiteVar_enUS_indexed_string:pageUriTrafficSimulation">Find the entity pageUriTrafficSimulation in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriTrafficSimulation(Wrap<String> c);

	public String getPageUriTrafficSimulation() {
		return pageUriTrafficSimulation;
	}
	public void setPageUriTrafficSimulation(String o) {
		this.pageUriTrafficSimulation = TrafficSimulationMapPage.staticSetPageUriTrafficSimulation(siteRequest_, o);
	}
	public static String staticSetPageUriTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected TrafficSimulationMapPage pageUriTrafficSimulationInit() {
		Wrap<String> pageUriTrafficSimulationWrap = new Wrap<String>().var("pageUriTrafficSimulation");
		if(pageUriTrafficSimulation == null) {
			_pageUriTrafficSimulation(pageUriTrafficSimulationWrap);
			Optional.ofNullable(pageUriTrafficSimulationWrap.getO()).ifPresent(o -> {
				setPageUriTrafficSimulation(o);
			});
		}
		return (TrafficSimulationMapPage)this;
	}

	public static String staticSearchPageUriTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriTrafficSimulation(SiteRequestEnUS siteRequest_, String o) {
		return TrafficSimulationMapPage.staticSearchPageUriTrafficSimulation(siteRequest_, TrafficSimulationMapPage.staticSetPageUriTrafficSimulation(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepTrafficSimulationMapPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepTrafficSimulationMapPage();
	}

	public Future<Void> promiseDeepTrafficSimulationMapPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseTrafficSimulationMapPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModelPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseTrafficSimulationMapPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListTrafficSimulation_Init();
				pageResponseInit();
				defaultZoneIdInit();
				defaultTimeZoneInit();
				defaultLocaleIdInit();
				defaultLocaleInit();
				defaultRangeGapInit();
				defaultRangeEndInit();
				defaultRangeStartInit();
				defaultRangeVarInit();
				defaultFacetSortInit();
				defaultFacetLimitInit();
				defaultFacetMinCountInit();
				defaultPivotMinCountInit();
				DEFAULT_MAP_LOCATIONInit();
				DEFAULT_MAP_ZOOMInit();
				listTrafficSimulationInit();
				statsInit();
				facetCountsInit();
				trafficSimulationCountInit();
				trafficSimulation_Init();
				pkInit();
				idInit();
				pageUriTrafficSimulationInit();
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
		return promiseDeepTrafficSimulationMapPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestTrafficSimulationMapPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestTrafficSimulationMapPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTrafficSimulationMapPage(v);
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
	public Object obtainTrafficSimulationMapPage(String var) {
		TrafficSimulationMapPage oTrafficSimulationMapPage = (TrafficSimulationMapPage)this;
		switch(var) {
			case "searchListTrafficSimulation_":
				return oTrafficSimulationMapPage.searchListTrafficSimulation_;
			case "pageResponse":
				return oTrafficSimulationMapPage.pageResponse;
			case "defaultZoneId":
				return oTrafficSimulationMapPage.defaultZoneId;
			case "defaultTimeZone":
				return oTrafficSimulationMapPage.defaultTimeZone;
			case "defaultLocaleId":
				return oTrafficSimulationMapPage.defaultLocaleId;
			case "defaultLocale":
				return oTrafficSimulationMapPage.defaultLocale;
			case "defaultRangeGap":
				return oTrafficSimulationMapPage.defaultRangeGap;
			case "defaultRangeEnd":
				return oTrafficSimulationMapPage.defaultRangeEnd;
			case "defaultRangeStart":
				return oTrafficSimulationMapPage.defaultRangeStart;
			case "defaultRangeVar":
				return oTrafficSimulationMapPage.defaultRangeVar;
			case "defaultFacetSort":
				return oTrafficSimulationMapPage.defaultFacetSort;
			case "defaultFacetLimit":
				return oTrafficSimulationMapPage.defaultFacetLimit;
			case "defaultFacetMinCount":
				return oTrafficSimulationMapPage.defaultFacetMinCount;
			case "defaultPivotMinCount":
				return oTrafficSimulationMapPage.defaultPivotMinCount;
			case "DEFAULT_MAP_LOCATION":
				return oTrafficSimulationMapPage.DEFAULT_MAP_LOCATION;
			case "DEFAULT_MAP_ZOOM":
				return oTrafficSimulationMapPage.DEFAULT_MAP_ZOOM;
			case "listTrafficSimulation":
				return oTrafficSimulationMapPage.listTrafficSimulation;
			case "stats":
				return oTrafficSimulationMapPage.stats;
			case "facetCounts":
				return oTrafficSimulationMapPage.facetCounts;
			case "trafficSimulationCount":
				return oTrafficSimulationMapPage.trafficSimulationCount;
			case "trafficSimulation_":
				return oTrafficSimulationMapPage.trafficSimulation_;
			case "pk":
				return oTrafficSimulationMapPage.pk;
			case "id":
				return oTrafficSimulationMapPage.id;
			case "pageUriTrafficSimulation":
				return oTrafficSimulationMapPage.pageUriTrafficSimulation;
			default:
				return super.obtainBaseModelPage(var);
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
				o = relateTrafficSimulationMapPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateTrafficSimulationMapPage(String var, Object val) {
		TrafficSimulationMapPage oTrafficSimulationMapPage = (TrafficSimulationMapPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetTrafficSimulationMapPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetTrafficSimulationMapPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageResponse":
			return TrafficSimulationMapPage.staticSetPageResponse(siteRequest_, o);
		case "defaultZoneId":
			return TrafficSimulationMapPage.staticSetDefaultZoneId(siteRequest_, o);
		case "defaultLocaleId":
			return TrafficSimulationMapPage.staticSetDefaultLocaleId(siteRequest_, o);
		case "defaultRangeGap":
			return TrafficSimulationMapPage.staticSetDefaultRangeGap(siteRequest_, o);
		case "defaultRangeEnd":
			return TrafficSimulationMapPage.staticSetDefaultRangeEnd(siteRequest_, o);
		case "defaultRangeStart":
			return TrafficSimulationMapPage.staticSetDefaultRangeStart(siteRequest_, o);
		case "defaultRangeVar":
			return TrafficSimulationMapPage.staticSetDefaultRangeVar(siteRequest_, o);
		case "defaultFacetSort":
			return TrafficSimulationMapPage.staticSetDefaultFacetSort(siteRequest_, o);
		case "defaultFacetLimit":
			return TrafficSimulationMapPage.staticSetDefaultFacetLimit(siteRequest_, o);
		case "defaultFacetMinCount":
			return TrafficSimulationMapPage.staticSetDefaultFacetMinCount(siteRequest_, o);
		case "defaultPivotMinCount":
			return TrafficSimulationMapPage.staticSetDefaultPivotMinCount(siteRequest_, o);
		case "DEFAULT_MAP_LOCATION":
			return TrafficSimulationMapPage.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o);
		case "DEFAULT_MAP_ZOOM":
			return TrafficSimulationMapPage.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o);
		case "listTrafficSimulation":
			return TrafficSimulationMapPage.staticSetListTrafficSimulation(siteRequest_, o);
		case "trafficSimulationCount":
			return TrafficSimulationMapPage.staticSetTrafficSimulationCount(siteRequest_, o);
		case "pk":
			return TrafficSimulationMapPage.staticSetPk(siteRequest_, o);
		case "id":
			return TrafficSimulationMapPage.staticSetId(siteRequest_, o);
		case "pageUriTrafficSimulation":
			return TrafficSimulationMapPage.staticSetPageUriTrafficSimulation(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchTrafficSimulationMapPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchTrafficSimulationMapPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageResponse":
			return TrafficSimulationMapPage.staticSearchPageResponse(siteRequest_, (String)o);
		case "defaultZoneId":
			return TrafficSimulationMapPage.staticSearchDefaultZoneId(siteRequest_, (String)o);
		case "defaultLocaleId":
			return TrafficSimulationMapPage.staticSearchDefaultLocaleId(siteRequest_, (String)o);
		case "defaultRangeGap":
			return TrafficSimulationMapPage.staticSearchDefaultRangeGap(siteRequest_, (String)o);
		case "defaultRangeEnd":
			return TrafficSimulationMapPage.staticSearchDefaultRangeEnd(siteRequest_, (ZonedDateTime)o);
		case "defaultRangeStart":
			return TrafficSimulationMapPage.staticSearchDefaultRangeStart(siteRequest_, (ZonedDateTime)o);
		case "defaultRangeVar":
			return TrafficSimulationMapPage.staticSearchDefaultRangeVar(siteRequest_, (String)o);
		case "defaultFacetSort":
			return TrafficSimulationMapPage.staticSearchDefaultFacetSort(siteRequest_, (String)o);
		case "defaultFacetLimit":
			return TrafficSimulationMapPage.staticSearchDefaultFacetLimit(siteRequest_, (Integer)o);
		case "defaultFacetMinCount":
			return TrafficSimulationMapPage.staticSearchDefaultFacetMinCount(siteRequest_, (Integer)o);
		case "defaultPivotMinCount":
			return TrafficSimulationMapPage.staticSearchDefaultPivotMinCount(siteRequest_, (Integer)o);
		case "DEFAULT_MAP_LOCATION":
			return TrafficSimulationMapPage.staticSearchDEFAULT_MAP_LOCATION(siteRequest_, (JsonObject)o);
		case "DEFAULT_MAP_ZOOM":
			return TrafficSimulationMapPage.staticSearchDEFAULT_MAP_ZOOM(siteRequest_, (BigDecimal)o);
		case "listTrafficSimulation":
			return TrafficSimulationMapPage.staticSearchListTrafficSimulation(siteRequest_, (JsonArray)o);
		case "trafficSimulationCount":
			return TrafficSimulationMapPage.staticSearchTrafficSimulationCount(siteRequest_, (Integer)o);
		case "pk":
			return TrafficSimulationMapPage.staticSearchPk(siteRequest_, (Long)o);
		case "id":
			return TrafficSimulationMapPage.staticSearchId(siteRequest_, (String)o);
		case "pageUriTrafficSimulation":
			return TrafficSimulationMapPage.staticSearchPageUriTrafficSimulation(siteRequest_, (String)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrTrafficSimulationMapPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrTrafficSimulationMapPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageResponse":
			return TrafficSimulationMapPage.staticSearchStrPageResponse(siteRequest_, (String)o);
		case "defaultZoneId":
			return TrafficSimulationMapPage.staticSearchStrDefaultZoneId(siteRequest_, (String)o);
		case "defaultLocaleId":
			return TrafficSimulationMapPage.staticSearchStrDefaultLocaleId(siteRequest_, (String)o);
		case "defaultRangeGap":
			return TrafficSimulationMapPage.staticSearchStrDefaultRangeGap(siteRequest_, (String)o);
		case "defaultRangeEnd":
			return TrafficSimulationMapPage.staticSearchStrDefaultRangeEnd(siteRequest_, (String)o);
		case "defaultRangeStart":
			return TrafficSimulationMapPage.staticSearchStrDefaultRangeStart(siteRequest_, (String)o);
		case "defaultRangeVar":
			return TrafficSimulationMapPage.staticSearchStrDefaultRangeVar(siteRequest_, (String)o);
		case "defaultFacetSort":
			return TrafficSimulationMapPage.staticSearchStrDefaultFacetSort(siteRequest_, (String)o);
		case "defaultFacetLimit":
			return TrafficSimulationMapPage.staticSearchStrDefaultFacetLimit(siteRequest_, (Integer)o);
		case "defaultFacetMinCount":
			return TrafficSimulationMapPage.staticSearchStrDefaultFacetMinCount(siteRequest_, (Integer)o);
		case "defaultPivotMinCount":
			return TrafficSimulationMapPage.staticSearchStrDefaultPivotMinCount(siteRequest_, (Integer)o);
		case "DEFAULT_MAP_LOCATION":
			return TrafficSimulationMapPage.staticSearchStrDEFAULT_MAP_LOCATION(siteRequest_, (String)o);
		case "DEFAULT_MAP_ZOOM":
			return TrafficSimulationMapPage.staticSearchStrDEFAULT_MAP_ZOOM(siteRequest_, (Double)o);
		case "listTrafficSimulation":
			return TrafficSimulationMapPage.staticSearchStrListTrafficSimulation(siteRequest_, (String)o);
		case "trafficSimulationCount":
			return TrafficSimulationMapPage.staticSearchStrTrafficSimulationCount(siteRequest_, (Integer)o);
		case "pk":
			return TrafficSimulationMapPage.staticSearchStrPk(siteRequest_, (Long)o);
		case "id":
			return TrafficSimulationMapPage.staticSearchStrId(siteRequest_, (String)o);
		case "pageUriTrafficSimulation":
			return TrafficSimulationMapPage.staticSearchStrPageUriTrafficSimulation(siteRequest_, (String)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqTrafficSimulationMapPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqTrafficSimulationMapPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageResponse":
			return TrafficSimulationMapPage.staticSearchFqPageResponse(siteRequest_, o);
		case "defaultZoneId":
			return TrafficSimulationMapPage.staticSearchFqDefaultZoneId(siteRequest_, o);
		case "defaultLocaleId":
			return TrafficSimulationMapPage.staticSearchFqDefaultLocaleId(siteRequest_, o);
		case "defaultRangeGap":
			return TrafficSimulationMapPage.staticSearchFqDefaultRangeGap(siteRequest_, o);
		case "defaultRangeEnd":
			return TrafficSimulationMapPage.staticSearchFqDefaultRangeEnd(siteRequest_, o);
		case "defaultRangeStart":
			return TrafficSimulationMapPage.staticSearchFqDefaultRangeStart(siteRequest_, o);
		case "defaultRangeVar":
			return TrafficSimulationMapPage.staticSearchFqDefaultRangeVar(siteRequest_, o);
		case "defaultFacetSort":
			return TrafficSimulationMapPage.staticSearchFqDefaultFacetSort(siteRequest_, o);
		case "defaultFacetLimit":
			return TrafficSimulationMapPage.staticSearchFqDefaultFacetLimit(siteRequest_, o);
		case "defaultFacetMinCount":
			return TrafficSimulationMapPage.staticSearchFqDefaultFacetMinCount(siteRequest_, o);
		case "defaultPivotMinCount":
			return TrafficSimulationMapPage.staticSearchFqDefaultPivotMinCount(siteRequest_, o);
		case "DEFAULT_MAP_LOCATION":
			return TrafficSimulationMapPage.staticSearchFqDEFAULT_MAP_LOCATION(siteRequest_, o);
		case "DEFAULT_MAP_ZOOM":
			return TrafficSimulationMapPage.staticSearchFqDEFAULT_MAP_ZOOM(siteRequest_, o);
		case "listTrafficSimulation":
			return TrafficSimulationMapPage.staticSearchFqListTrafficSimulation(siteRequest_, o);
		case "trafficSimulationCount":
			return TrafficSimulationMapPage.staticSearchFqTrafficSimulationCount(siteRequest_, o);
		case "pk":
			return TrafficSimulationMapPage.staticSearchFqPk(siteRequest_, o);
		case "id":
			return TrafficSimulationMapPage.staticSearchFqId(siteRequest_, o);
		case "pageUriTrafficSimulation":
			return TrafficSimulationMapPage.staticSearchFqPageUriTrafficSimulation(siteRequest_, o);
			default:
				return BaseModelPage.staticSearchFqBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "TrafficSimulationMapPage";
	public static final String VAR_searchListTrafficSimulation_ = "searchListTrafficSimulation_";
	public static final String VAR_pageResponse = "pageResponse";
	public static final String VAR_defaultZoneId = "defaultZoneId";
	public static final String VAR_defaultTimeZone = "defaultTimeZone";
	public static final String VAR_defaultLocaleId = "defaultLocaleId";
	public static final String VAR_defaultLocale = "defaultLocale";
	public static final String VAR_defaultRangeGap = "defaultRangeGap";
	public static final String VAR_defaultRangeEnd = "defaultRangeEnd";
	public static final String VAR_defaultRangeStart = "defaultRangeStart";
	public static final String VAR_defaultRangeVar = "defaultRangeVar";
	public static final String VAR_defaultFacetSort = "defaultFacetSort";
	public static final String VAR_defaultFacetLimit = "defaultFacetLimit";
	public static final String VAR_defaultFacetMinCount = "defaultFacetMinCount";
	public static final String VAR_defaultPivotMinCount = "defaultPivotMinCount";
	public static final String VAR_DEFAULT_MAP_LOCATION = "DEFAULT_MAP_LOCATION";
	public static final String VAR_DEFAULT_MAP_ZOOM = "DEFAULT_MAP_ZOOM";
	public static final String VAR_listTrafficSimulation = "listTrafficSimulation";
	public static final String VAR_stats = "stats";
	public static final String VAR_facetCounts = "facetCounts";
	public static final String VAR_trafficSimulationCount = "trafficSimulationCount";
	public static final String VAR_trafficSimulation_ = "trafficSimulation_";
	public static final String VAR_pk = "pk";
	public static final String VAR_id = "id";
	public static final String VAR_pageUriTrafficSimulation = "pageUriTrafficSimulation";

	public static final String DISPLAY_NAME_searchListTrafficSimulation_ = "";
	public static final String DISPLAY_NAME_pageResponse = "";
	public static final String DISPLAY_NAME_defaultZoneId = "";
	public static final String DISPLAY_NAME_defaultTimeZone = "";
	public static final String DISPLAY_NAME_defaultLocaleId = "";
	public static final String DISPLAY_NAME_defaultLocale = "";
	public static final String DISPLAY_NAME_defaultRangeGap = "";
	public static final String DISPLAY_NAME_defaultRangeEnd = "";
	public static final String DISPLAY_NAME_defaultRangeStart = "";
	public static final String DISPLAY_NAME_defaultRangeVar = "";
	public static final String DISPLAY_NAME_defaultFacetSort = "";
	public static final String DISPLAY_NAME_defaultFacetLimit = "";
	public static final String DISPLAY_NAME_defaultFacetMinCount = "";
	public static final String DISPLAY_NAME_defaultPivotMinCount = "";
	public static final String DISPLAY_NAME_DEFAULT_MAP_LOCATION = "";
	public static final String DISPLAY_NAME_DEFAULT_MAP_ZOOM = "";
	public static final String DISPLAY_NAME_listTrafficSimulation = "";
	public static final String DISPLAY_NAME_stats = "";
	public static final String DISPLAY_NAME_facetCounts = "";
	public static final String DISPLAY_NAME_trafficSimulationCount = "";
	public static final String DISPLAY_NAME_trafficSimulation_ = "";
	public static final String DISPLAY_NAME_pk = "";
	public static final String DISPLAY_NAME_id = "";
	public static final String DISPLAY_NAME_pageUriTrafficSimulation = "";

	public static String displayNameForClass(String var) {
		return TrafficSimulationMapPage.displayNameTrafficSimulationMapPage(var);
	}
	public static String displayNameTrafficSimulationMapPage(String var) {
		switch(var) {
		case VAR_searchListTrafficSimulation_:
			return DISPLAY_NAME_searchListTrafficSimulation_;
		case VAR_pageResponse:
			return DISPLAY_NAME_pageResponse;
		case VAR_defaultZoneId:
			return DISPLAY_NAME_defaultZoneId;
		case VAR_defaultTimeZone:
			return DISPLAY_NAME_defaultTimeZone;
		case VAR_defaultLocaleId:
			return DISPLAY_NAME_defaultLocaleId;
		case VAR_defaultLocale:
			return DISPLAY_NAME_defaultLocale;
		case VAR_defaultRangeGap:
			return DISPLAY_NAME_defaultRangeGap;
		case VAR_defaultRangeEnd:
			return DISPLAY_NAME_defaultRangeEnd;
		case VAR_defaultRangeStart:
			return DISPLAY_NAME_defaultRangeStart;
		case VAR_defaultRangeVar:
			return DISPLAY_NAME_defaultRangeVar;
		case VAR_defaultFacetSort:
			return DISPLAY_NAME_defaultFacetSort;
		case VAR_defaultFacetLimit:
			return DISPLAY_NAME_defaultFacetLimit;
		case VAR_defaultFacetMinCount:
			return DISPLAY_NAME_defaultFacetMinCount;
		case VAR_defaultPivotMinCount:
			return DISPLAY_NAME_defaultPivotMinCount;
		case VAR_DEFAULT_MAP_LOCATION:
			return DISPLAY_NAME_DEFAULT_MAP_LOCATION;
		case VAR_DEFAULT_MAP_ZOOM:
			return DISPLAY_NAME_DEFAULT_MAP_ZOOM;
		case VAR_listTrafficSimulation:
			return DISPLAY_NAME_listTrafficSimulation;
		case VAR_stats:
			return DISPLAY_NAME_stats;
		case VAR_facetCounts:
			return DISPLAY_NAME_facetCounts;
		case VAR_trafficSimulationCount:
			return DISPLAY_NAME_trafficSimulationCount;
		case VAR_trafficSimulation_:
			return DISPLAY_NAME_trafficSimulation_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_pageUriTrafficSimulation:
			return DISPLAY_NAME_pageUriTrafficSimulation;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
