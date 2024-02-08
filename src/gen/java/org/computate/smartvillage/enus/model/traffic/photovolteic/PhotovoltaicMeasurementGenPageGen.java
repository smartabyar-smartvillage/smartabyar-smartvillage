package org.computate.smartvillage.enus.model.traffic.photovolteic;

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
import org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurement;
import io.vertx.core.json.JsonArray;
import java.lang.Integer;
import java.lang.String;
import java.lang.Long;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these PhotovoltaicMeasurementGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class PhotovoltaicMeasurementGenPageGen into the class PhotovoltaicMeasurementGenPage. 
 * </li>
 * <h3>About the PhotovoltaicMeasurementGenPage class and it's generated class PhotovoltaicMeasurementGenPageGen&lt;BaseModelPage&gt;: </h3>extends PhotovoltaicMeasurementGenPageGen
 * <p>
 * This Java class extends a generated Java class PhotovoltaicMeasurementGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage">Find the class PhotovoltaicMeasurementGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends PhotovoltaicMeasurementGenPageGen<BaseModelPage>
 * <p>This <code>class PhotovoltaicMeasurementGenPage extends PhotovoltaicMeasurementGenPageGen&lt;BaseModelPage&gt;</code>, which means it extends a newly generated PhotovoltaicMeasurementGenPageGen. 
 * The generated <code>class PhotovoltaicMeasurementGenPageGen extends BaseModelPage</code> which means that PhotovoltaicMeasurementGenPage extends PhotovoltaicMeasurementGenPageGen which extends BaseModelPage. 
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
 * <p>By adding a class comment "{@inheritDoc}", the PhotovoltaicMeasurementGenPage class will inherit the helpful inherited class comments from the super class PhotovoltaicMeasurementGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the PhotovoltaicMeasurementGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class PhotovoltaicMeasurementGenPage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartvillage.enus.model.traffic.photovolteic in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smartabyar-smartvillage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smartabyar\-smartvillage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class PhotovoltaicMeasurementGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(PhotovoltaicMeasurementGenPage.class);

	////////////////////////////////////////
	// searchListPhotovoltaicMeasurement_ //
	////////////////////////////////////////


	/**	 The entity searchListPhotovoltaicMeasurement_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<PhotovoltaicMeasurement> searchListPhotovoltaicMeasurement_;

	/**	<br> The entity searchListPhotovoltaicMeasurement_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:searchListPhotovoltaicMeasurement_">Find the entity searchListPhotovoltaicMeasurement_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListPhotovoltaicMeasurement_(Wrap<SearchList<PhotovoltaicMeasurement>> w);

	public SearchList<PhotovoltaicMeasurement> getSearchListPhotovoltaicMeasurement_() {
		return searchListPhotovoltaicMeasurement_;
	}

	public void setSearchListPhotovoltaicMeasurement_(SearchList<PhotovoltaicMeasurement> searchListPhotovoltaicMeasurement_) {
		this.searchListPhotovoltaicMeasurement_ = searchListPhotovoltaicMeasurement_;
	}
	public static SearchList<PhotovoltaicMeasurement> staticSetSearchListPhotovoltaicMeasurement_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PhotovoltaicMeasurementGenPage searchListPhotovoltaicMeasurement_Init() {
		Wrap<SearchList<PhotovoltaicMeasurement>> searchListPhotovoltaicMeasurement_Wrap = new Wrap<SearchList<PhotovoltaicMeasurement>>().var("searchListPhotovoltaicMeasurement_");
		if(searchListPhotovoltaicMeasurement_ == null) {
			_searchListPhotovoltaicMeasurement_(searchListPhotovoltaicMeasurement_Wrap);
			Optional.ofNullable(searchListPhotovoltaicMeasurement_Wrap.getO()).ifPresent(o -> {
				setSearchListPhotovoltaicMeasurement_(o);
			});
		}
		return (PhotovoltaicMeasurementGenPage)this;
	}

	/////////////////////////////////
	// listPhotovoltaicMeasurement //
	/////////////////////////////////


	/**	 The entity listPhotovoltaicMeasurement
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listPhotovoltaicMeasurement = new JsonArray();

	/**	<br> The entity listPhotovoltaicMeasurement
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:listPhotovoltaicMeasurement">Find the entity listPhotovoltaicMeasurement in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listPhotovoltaicMeasurement(JsonArray l);

	public JsonArray getListPhotovoltaicMeasurement() {
		return listPhotovoltaicMeasurement;
	}

	public void setListPhotovoltaicMeasurement(JsonArray listPhotovoltaicMeasurement) {
		this.listPhotovoltaicMeasurement = listPhotovoltaicMeasurement;
	}
	@JsonIgnore
	public void setListPhotovoltaicMeasurement(String o) {
		this.listPhotovoltaicMeasurement = PhotovoltaicMeasurementGenPage.staticSetListPhotovoltaicMeasurement(siteRequest_, o);
	}
	public static JsonArray staticSetListPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected PhotovoltaicMeasurementGenPage listPhotovoltaicMeasurementInit() {
		_listPhotovoltaicMeasurement(listPhotovoltaicMeasurement);
		return (PhotovoltaicMeasurementGenPage)this;
	}

	public static String staticSearchListPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurementGenPage.staticSearchListPhotovoltaicMeasurement(siteRequest_, PhotovoltaicMeasurementGenPage.staticSetListPhotovoltaicMeasurement(siteRequest_, o)).toString();
	}

	//////////////////////////////////
	// photovoltaicMeasurementCount //
	//////////////////////////////////


	/**	 The entity photovoltaicMeasurementCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer photovoltaicMeasurementCount;

	/**	<br> The entity photovoltaicMeasurementCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:photovoltaicMeasurementCount">Find the entity photovoltaicMeasurementCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _photovoltaicMeasurementCount(Wrap<Integer> w);

	public Integer getPhotovoltaicMeasurementCount() {
		return photovoltaicMeasurementCount;
	}

	public void setPhotovoltaicMeasurementCount(Integer photovoltaicMeasurementCount) {
		this.photovoltaicMeasurementCount = photovoltaicMeasurementCount;
	}
	@JsonIgnore
	public void setPhotovoltaicMeasurementCount(String o) {
		this.photovoltaicMeasurementCount = PhotovoltaicMeasurementGenPage.staticSetPhotovoltaicMeasurementCount(siteRequest_, o);
	}
	public static Integer staticSetPhotovoltaicMeasurementCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected PhotovoltaicMeasurementGenPage photovoltaicMeasurementCountInit() {
		Wrap<Integer> photovoltaicMeasurementCountWrap = new Wrap<Integer>().var("photovoltaicMeasurementCount");
		if(photovoltaicMeasurementCount == null) {
			_photovoltaicMeasurementCount(photovoltaicMeasurementCountWrap);
			Optional.ofNullable(photovoltaicMeasurementCountWrap.getO()).ifPresent(o -> {
				setPhotovoltaicMeasurementCount(o);
			});
		}
		return (PhotovoltaicMeasurementGenPage)this;
	}

	public static Integer staticSearchPhotovoltaicMeasurementCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrPhotovoltaicMeasurementCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPhotovoltaicMeasurementCount(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurementGenPage.staticSearchPhotovoltaicMeasurementCount(siteRequest_, PhotovoltaicMeasurementGenPage.staticSetPhotovoltaicMeasurementCount(siteRequest_, o)).toString();
	}

	//////////////////////////////
	// photovoltaicMeasurement_ //
	//////////////////////////////


	/**	 The entity photovoltaicMeasurement_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected PhotovoltaicMeasurement photovoltaicMeasurement_;

	/**	<br> The entity photovoltaicMeasurement_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:photovoltaicMeasurement_">Find the entity photovoltaicMeasurement_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _photovoltaicMeasurement_(Wrap<PhotovoltaicMeasurement> w);

	public PhotovoltaicMeasurement getPhotovoltaicMeasurement_() {
		return photovoltaicMeasurement_;
	}

	public void setPhotovoltaicMeasurement_(PhotovoltaicMeasurement photovoltaicMeasurement_) {
		this.photovoltaicMeasurement_ = photovoltaicMeasurement_;
	}
	public static PhotovoltaicMeasurement staticSetPhotovoltaicMeasurement_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected PhotovoltaicMeasurementGenPage photovoltaicMeasurement_Init() {
		Wrap<PhotovoltaicMeasurement> photovoltaicMeasurement_Wrap = new Wrap<PhotovoltaicMeasurement>().var("photovoltaicMeasurement_");
		if(photovoltaicMeasurement_ == null) {
			_photovoltaicMeasurement_(photovoltaicMeasurement_Wrap);
			Optional.ofNullable(photovoltaicMeasurement_Wrap.getO()).ifPresent(o -> {
				setPhotovoltaicMeasurement_(o);
			});
		}
		return (PhotovoltaicMeasurementGenPage)this;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = PhotovoltaicMeasurementGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected PhotovoltaicMeasurementGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
				setPk(o);
			});
		}
		return (PhotovoltaicMeasurementGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurementGenPage.staticSearchPk(siteRequest_, PhotovoltaicMeasurementGenPage.staticSetPk(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = PhotovoltaicMeasurementGenPage.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurementGenPage idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (PhotovoltaicMeasurementGenPage)this;
	}

	public static String staticSearchId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurementGenPage.staticSearchId(siteRequest_, PhotovoltaicMeasurementGenPage.staticSetId(siteRequest_, o)).toString();
	}

	////////////////////////////////////
	// pageUriPhotovoltaicMeasurement //
	////////////////////////////////////


	/**	 The entity pageUriPhotovoltaicMeasurement
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriPhotovoltaicMeasurement;

	/**	<br> The entity pageUriPhotovoltaicMeasurement
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.photovolteic.PhotovoltaicMeasurementGenPage&fq=entiteVar_enUS_indexed_string:pageUriPhotovoltaicMeasurement">Find the entity pageUriPhotovoltaicMeasurement in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriPhotovoltaicMeasurement(Wrap<String> c);

	public String getPageUriPhotovoltaicMeasurement() {
		return pageUriPhotovoltaicMeasurement;
	}
	public void setPageUriPhotovoltaicMeasurement(String o) {
		this.pageUriPhotovoltaicMeasurement = PhotovoltaicMeasurementGenPage.staticSetPageUriPhotovoltaicMeasurement(siteRequest_, o);
	}
	public static String staticSetPageUriPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected PhotovoltaicMeasurementGenPage pageUriPhotovoltaicMeasurementInit() {
		Wrap<String> pageUriPhotovoltaicMeasurementWrap = new Wrap<String>().var("pageUriPhotovoltaicMeasurement");
		if(pageUriPhotovoltaicMeasurement == null) {
			_pageUriPhotovoltaicMeasurement(pageUriPhotovoltaicMeasurementWrap);
			Optional.ofNullable(pageUriPhotovoltaicMeasurementWrap.getO()).ifPresent(o -> {
				setPageUriPhotovoltaicMeasurement(o);
			});
		}
		return (PhotovoltaicMeasurementGenPage)this;
	}

	public static String staticSearchPageUriPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriPhotovoltaicMeasurement(SiteRequestEnUS siteRequest_, String o) {
		return PhotovoltaicMeasurementGenPage.staticSearchPageUriPhotovoltaicMeasurement(siteRequest_, PhotovoltaicMeasurementGenPage.staticSetPageUriPhotovoltaicMeasurement(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepPhotovoltaicMeasurementGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepPhotovoltaicMeasurementGenPage();
	}

	public Future<Void> promiseDeepPhotovoltaicMeasurementGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promisePhotovoltaicMeasurementGenPage(promise2);
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

	public Future<Void> promisePhotovoltaicMeasurementGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListPhotovoltaicMeasurement_Init();
				listPhotovoltaicMeasurementInit();
				photovoltaicMeasurementCountInit();
				photovoltaicMeasurement_Init();
				pkInit();
				idInit();
				pageUriPhotovoltaicMeasurementInit();
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
		return promiseDeepPhotovoltaicMeasurementGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestPhotovoltaicMeasurementGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestPhotovoltaicMeasurementGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainPhotovoltaicMeasurementGenPage(v);
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
	public Object obtainPhotovoltaicMeasurementGenPage(String var) {
		PhotovoltaicMeasurementGenPage oPhotovoltaicMeasurementGenPage = (PhotovoltaicMeasurementGenPage)this;
		switch(var) {
			case "searchListPhotovoltaicMeasurement_":
				return oPhotovoltaicMeasurementGenPage.searchListPhotovoltaicMeasurement_;
			case "listPhotovoltaicMeasurement":
				return oPhotovoltaicMeasurementGenPage.listPhotovoltaicMeasurement;
			case "photovoltaicMeasurementCount":
				return oPhotovoltaicMeasurementGenPage.photovoltaicMeasurementCount;
			case "photovoltaicMeasurement_":
				return oPhotovoltaicMeasurementGenPage.photovoltaicMeasurement_;
			case "pk":
				return oPhotovoltaicMeasurementGenPage.pk;
			case "id":
				return oPhotovoltaicMeasurementGenPage.id;
			case "pageUriPhotovoltaicMeasurement":
				return oPhotovoltaicMeasurementGenPage.pageUriPhotovoltaicMeasurement;
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
				o = relatePhotovoltaicMeasurementGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relatePhotovoltaicMeasurementGenPage(String var, Object val) {
		PhotovoltaicMeasurementGenPage oPhotovoltaicMeasurementGenPage = (PhotovoltaicMeasurementGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetPhotovoltaicMeasurementGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetPhotovoltaicMeasurementGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "listPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSetListPhotovoltaicMeasurement(siteRequest_, o);
		case "photovoltaicMeasurementCount":
			return PhotovoltaicMeasurementGenPage.staticSetPhotovoltaicMeasurementCount(siteRequest_, o);
		case "pk":
			return PhotovoltaicMeasurementGenPage.staticSetPk(siteRequest_, o);
		case "id":
			return PhotovoltaicMeasurementGenPage.staticSetId(siteRequest_, o);
		case "pageUriPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSetPageUriPhotovoltaicMeasurement(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchPhotovoltaicMeasurementGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchPhotovoltaicMeasurementGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "listPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSearchListPhotovoltaicMeasurement(siteRequest_, (JsonArray)o);
		case "photovoltaicMeasurementCount":
			return PhotovoltaicMeasurementGenPage.staticSearchPhotovoltaicMeasurementCount(siteRequest_, (Integer)o);
		case "pk":
			return PhotovoltaicMeasurementGenPage.staticSearchPk(siteRequest_, (Long)o);
		case "id":
			return PhotovoltaicMeasurementGenPage.staticSearchId(siteRequest_, (String)o);
		case "pageUriPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSearchPageUriPhotovoltaicMeasurement(siteRequest_, (String)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrPhotovoltaicMeasurementGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrPhotovoltaicMeasurementGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "listPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSearchStrListPhotovoltaicMeasurement(siteRequest_, (String)o);
		case "photovoltaicMeasurementCount":
			return PhotovoltaicMeasurementGenPage.staticSearchStrPhotovoltaicMeasurementCount(siteRequest_, (Integer)o);
		case "pk":
			return PhotovoltaicMeasurementGenPage.staticSearchStrPk(siteRequest_, (Long)o);
		case "id":
			return PhotovoltaicMeasurementGenPage.staticSearchStrId(siteRequest_, (String)o);
		case "pageUriPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSearchStrPageUriPhotovoltaicMeasurement(siteRequest_, (String)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqPhotovoltaicMeasurementGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqPhotovoltaicMeasurementGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "listPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSearchFqListPhotovoltaicMeasurement(siteRequest_, o);
		case "photovoltaicMeasurementCount":
			return PhotovoltaicMeasurementGenPage.staticSearchFqPhotovoltaicMeasurementCount(siteRequest_, o);
		case "pk":
			return PhotovoltaicMeasurementGenPage.staticSearchFqPk(siteRequest_, o);
		case "id":
			return PhotovoltaicMeasurementGenPage.staticSearchFqId(siteRequest_, o);
		case "pageUriPhotovoltaicMeasurement":
			return PhotovoltaicMeasurementGenPage.staticSearchFqPageUriPhotovoltaicMeasurement(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "PhotovoltaicMeasurementGenPage";
	public static final String VAR_searchListPhotovoltaicMeasurement_ = "searchListPhotovoltaicMeasurement_";
	public static final String VAR_listPhotovoltaicMeasurement = "listPhotovoltaicMeasurement";
	public static final String VAR_photovoltaicMeasurementCount = "photovoltaicMeasurementCount";
	public static final String VAR_photovoltaicMeasurement_ = "photovoltaicMeasurement_";
	public static final String VAR_pk = "pk";
	public static final String VAR_id = "id";
	public static final String VAR_pageUriPhotovoltaicMeasurement = "pageUriPhotovoltaicMeasurement";

	public static final String DISPLAY_NAME_searchListPhotovoltaicMeasurement_ = "";
	public static final String DISPLAY_NAME_listPhotovoltaicMeasurement = "";
	public static final String DISPLAY_NAME_photovoltaicMeasurementCount = "";
	public static final String DISPLAY_NAME_photovoltaicMeasurement_ = "";
	public static final String DISPLAY_NAME_pk = "";
	public static final String DISPLAY_NAME_id = "";
	public static final String DISPLAY_NAME_pageUriPhotovoltaicMeasurement = "";

	public static String displayNameForClass(String var) {
		return PhotovoltaicMeasurementGenPage.displayNamePhotovoltaicMeasurementGenPage(var);
	}
	public static String displayNamePhotovoltaicMeasurementGenPage(String var) {
		switch(var) {
		case VAR_searchListPhotovoltaicMeasurement_:
			return DISPLAY_NAME_searchListPhotovoltaicMeasurement_;
		case VAR_listPhotovoltaicMeasurement:
			return DISPLAY_NAME_listPhotovoltaicMeasurement;
		case VAR_photovoltaicMeasurementCount:
			return DISPLAY_NAME_photovoltaicMeasurementCount;
		case VAR_photovoltaicMeasurement_:
			return DISPLAY_NAME_photovoltaicMeasurement_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_pageUriPhotovoltaicMeasurement:
			return DISPLAY_NAME_pageUriPhotovoltaicMeasurement;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
