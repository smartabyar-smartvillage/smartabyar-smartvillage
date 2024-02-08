package org.computate.smartvillage.enus.model.traffic.fiware.battery;

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
import org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDevice;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these StorageBatteryDeviceGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class StorageBatteryDeviceGenPageGen into the class StorageBatteryDeviceGenPage. 
 * </li>
 * <h3>About the StorageBatteryDeviceGenPage class and it's generated class StorageBatteryDeviceGenPageGen&lt;BaseModelPage&gt;: </h3>extends StorageBatteryDeviceGenPageGen
 * <p>
 * This Java class extends a generated Java class StorageBatteryDeviceGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage">Find the class StorageBatteryDeviceGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends StorageBatteryDeviceGenPageGen<BaseModelPage>
 * <p>This <code>class StorageBatteryDeviceGenPage extends StorageBatteryDeviceGenPageGen&lt;BaseModelPage&gt;</code>, which means it extends a newly generated StorageBatteryDeviceGenPageGen. 
 * The generated <code>class StorageBatteryDeviceGenPageGen extends BaseModelPage</code> which means that StorageBatteryDeviceGenPage extends StorageBatteryDeviceGenPageGen which extends BaseModelPage. 
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
 * <p>By adding a class comment "{@inheritDoc}", the StorageBatteryDeviceGenPage class will inherit the helpful inherited class comments from the super class StorageBatteryDeviceGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the StorageBatteryDeviceGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class StorageBatteryDeviceGenPage in Solr: 
 * curl -k 'http://solr:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class StorageBatteryDeviceGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(StorageBatteryDeviceGenPage.class);

	/////////////////////////////////////
	// searchListStorageBatteryDevice_ //
	/////////////////////////////////////


	/**	 The entity searchListStorageBatteryDevice_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<StorageBatteryDevice> searchListStorageBatteryDevice_;

	/**	<br> The entity searchListStorageBatteryDevice_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:searchListStorageBatteryDevice_">Find the entity searchListStorageBatteryDevice_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListStorageBatteryDevice_(Wrap<SearchList<StorageBatteryDevice>> w);

	public SearchList<StorageBatteryDevice> getSearchListStorageBatteryDevice_() {
		return searchListStorageBatteryDevice_;
	}

	public void setSearchListStorageBatteryDevice_(SearchList<StorageBatteryDevice> searchListStorageBatteryDevice_) {
		this.searchListStorageBatteryDevice_ = searchListStorageBatteryDevice_;
	}
	public static SearchList<StorageBatteryDevice> staticSetSearchListStorageBatteryDevice_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected StorageBatteryDeviceGenPage searchListStorageBatteryDevice_Init() {
		Wrap<SearchList<StorageBatteryDevice>> searchListStorageBatteryDevice_Wrap = new Wrap<SearchList<StorageBatteryDevice>>().var("searchListStorageBatteryDevice_");
		if(searchListStorageBatteryDevice_ == null) {
			_searchListStorageBatteryDevice_(searchListStorageBatteryDevice_Wrap);
			Optional.ofNullable(searchListStorageBatteryDevice_Wrap.getO()).ifPresent(o -> {
				setSearchListStorageBatteryDevice_(o);
			});
		}
		return (StorageBatteryDeviceGenPage)this;
	}

	//////////////////////////////
	// listStorageBatteryDevice //
	//////////////////////////////


	/**	 The entity listStorageBatteryDevice
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listStorageBatteryDevice = new JsonArray();

	/**	<br> The entity listStorageBatteryDevice
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:listStorageBatteryDevice">Find the entity listStorageBatteryDevice in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listStorageBatteryDevice(JsonArray l);

	public JsonArray getListStorageBatteryDevice() {
		return listStorageBatteryDevice;
	}

	public void setListStorageBatteryDevice(JsonArray listStorageBatteryDevice) {
		this.listStorageBatteryDevice = listStorageBatteryDevice;
	}
	@JsonIgnore
	public void setListStorageBatteryDevice(String o) {
		this.listStorageBatteryDevice = StorageBatteryDeviceGenPage.staticSetListStorageBatteryDevice(siteRequest_, o);
	}
	public static JsonArray staticSetListStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected StorageBatteryDeviceGenPage listStorageBatteryDeviceInit() {
		_listStorageBatteryDevice(listStorageBatteryDevice);
		return (StorageBatteryDeviceGenPage)this;
	}

	public static String staticSearchListStorageBatteryDevice(SiteRequestEnUS siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDeviceGenPage.staticSearchListStorageBatteryDevice(siteRequest_, StorageBatteryDeviceGenPage.staticSetListStorageBatteryDevice(siteRequest_, o)).toString();
	}

	///////////////////////////////
	// storageBatteryDeviceCount //
	///////////////////////////////


	/**	 The entity storageBatteryDeviceCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer storageBatteryDeviceCount;

	/**	<br> The entity storageBatteryDeviceCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:storageBatteryDeviceCount">Find the entity storageBatteryDeviceCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _storageBatteryDeviceCount(Wrap<Integer> w);

	public Integer getStorageBatteryDeviceCount() {
		return storageBatteryDeviceCount;
	}

	public void setStorageBatteryDeviceCount(Integer storageBatteryDeviceCount) {
		this.storageBatteryDeviceCount = storageBatteryDeviceCount;
	}
	@JsonIgnore
	public void setStorageBatteryDeviceCount(String o) {
		this.storageBatteryDeviceCount = StorageBatteryDeviceGenPage.staticSetStorageBatteryDeviceCount(siteRequest_, o);
	}
	public static Integer staticSetStorageBatteryDeviceCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected StorageBatteryDeviceGenPage storageBatteryDeviceCountInit() {
		Wrap<Integer> storageBatteryDeviceCountWrap = new Wrap<Integer>().var("storageBatteryDeviceCount");
		if(storageBatteryDeviceCount == null) {
			_storageBatteryDeviceCount(storageBatteryDeviceCountWrap);
			Optional.ofNullable(storageBatteryDeviceCountWrap.getO()).ifPresent(o -> {
				setStorageBatteryDeviceCount(o);
			});
		}
		return (StorageBatteryDeviceGenPage)this;
	}

	public static Integer staticSearchStorageBatteryDeviceCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrStorageBatteryDeviceCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStorageBatteryDeviceCount(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDeviceGenPage.staticSearchStorageBatteryDeviceCount(siteRequest_, StorageBatteryDeviceGenPage.staticSetStorageBatteryDeviceCount(siteRequest_, o)).toString();
	}

	///////////////////////////
	// storageBatteryDevice_ //
	///////////////////////////


	/**	 The entity storageBatteryDevice_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected StorageBatteryDevice storageBatteryDevice_;

	/**	<br> The entity storageBatteryDevice_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:storageBatteryDevice_">Find the entity storageBatteryDevice_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _storageBatteryDevice_(Wrap<StorageBatteryDevice> w);

	public StorageBatteryDevice getStorageBatteryDevice_() {
		return storageBatteryDevice_;
	}

	public void setStorageBatteryDevice_(StorageBatteryDevice storageBatteryDevice_) {
		this.storageBatteryDevice_ = storageBatteryDevice_;
	}
	public static StorageBatteryDevice staticSetStorageBatteryDevice_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected StorageBatteryDeviceGenPage storageBatteryDevice_Init() {
		Wrap<StorageBatteryDevice> storageBatteryDevice_Wrap = new Wrap<StorageBatteryDevice>().var("storageBatteryDevice_");
		if(storageBatteryDevice_ == null) {
			_storageBatteryDevice_(storageBatteryDevice_Wrap);
			Optional.ofNullable(storageBatteryDevice_Wrap.getO()).ifPresent(o -> {
				setStorageBatteryDevice_(o);
			});
		}
		return (StorageBatteryDeviceGenPage)this;
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = StorageBatteryDeviceGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected StorageBatteryDeviceGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
				setPk(o);
			});
		}
		return (StorageBatteryDeviceGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDeviceGenPage.staticSearchPk(siteRequest_, StorageBatteryDeviceGenPage.staticSetPk(siteRequest_, o)).toString();
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
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = StorageBatteryDeviceGenPage.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDeviceGenPage idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (StorageBatteryDeviceGenPage)this;
	}

	public static String staticSearchId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDeviceGenPage.staticSearchId(siteRequest_, StorageBatteryDeviceGenPage.staticSetId(siteRequest_, o)).toString();
	}

	/////////////////////////////////
	// pageUriStorageBatteryDevice //
	/////////////////////////////////


	/**	 The entity pageUriStorageBatteryDevice
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriStorageBatteryDevice;

	/**	<br> The entity pageUriStorageBatteryDevice
	 *  is defined as null before being initialized. 
	 * <br><a href="http://solr:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartvillage.enus.model.traffic.fiware.battery.StorageBatteryDeviceGenPage&fq=entiteVar_enUS_indexed_string:pageUriStorageBatteryDevice">Find the entity pageUriStorageBatteryDevice in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriStorageBatteryDevice(Wrap<String> c);

	public String getPageUriStorageBatteryDevice() {
		return pageUriStorageBatteryDevice;
	}
	public void setPageUriStorageBatteryDevice(String o) {
		this.pageUriStorageBatteryDevice = StorageBatteryDeviceGenPage.staticSetPageUriStorageBatteryDevice(siteRequest_, o);
	}
	public static String staticSetPageUriStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected StorageBatteryDeviceGenPage pageUriStorageBatteryDeviceInit() {
		Wrap<String> pageUriStorageBatteryDeviceWrap = new Wrap<String>().var("pageUriStorageBatteryDevice");
		if(pageUriStorageBatteryDevice == null) {
			_pageUriStorageBatteryDevice(pageUriStorageBatteryDeviceWrap);
			Optional.ofNullable(pageUriStorageBatteryDeviceWrap.getO()).ifPresent(o -> {
				setPageUriStorageBatteryDevice(o);
			});
		}
		return (StorageBatteryDeviceGenPage)this;
	}

	public static String staticSearchPageUriStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriStorageBatteryDevice(SiteRequestEnUS siteRequest_, String o) {
		return StorageBatteryDeviceGenPage.staticSearchPageUriStorageBatteryDevice(siteRequest_, StorageBatteryDeviceGenPage.staticSetPageUriStorageBatteryDevice(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepStorageBatteryDeviceGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepStorageBatteryDeviceGenPage();
	}

	public Future<Void> promiseDeepStorageBatteryDeviceGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseStorageBatteryDeviceGenPage(promise2);
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

	public Future<Void> promiseStorageBatteryDeviceGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListStorageBatteryDevice_Init();
				listStorageBatteryDeviceInit();
				storageBatteryDeviceCountInit();
				storageBatteryDevice_Init();
				pkInit();
				idInit();
				pageUriStorageBatteryDeviceInit();
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
		return promiseDeepStorageBatteryDeviceGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestStorageBatteryDeviceGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestStorageBatteryDeviceGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainStorageBatteryDeviceGenPage(v);
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
	public Object obtainStorageBatteryDeviceGenPage(String var) {
		StorageBatteryDeviceGenPage oStorageBatteryDeviceGenPage = (StorageBatteryDeviceGenPage)this;
		switch(var) {
			case "searchListStorageBatteryDevice_":
				return oStorageBatteryDeviceGenPage.searchListStorageBatteryDevice_;
			case "listStorageBatteryDevice":
				return oStorageBatteryDeviceGenPage.listStorageBatteryDevice;
			case "storageBatteryDeviceCount":
				return oStorageBatteryDeviceGenPage.storageBatteryDeviceCount;
			case "storageBatteryDevice_":
				return oStorageBatteryDeviceGenPage.storageBatteryDevice_;
			case "pk":
				return oStorageBatteryDeviceGenPage.pk;
			case "id":
				return oStorageBatteryDeviceGenPage.id;
			case "pageUriStorageBatteryDevice":
				return oStorageBatteryDeviceGenPage.pageUriStorageBatteryDevice;
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
				o = relateStorageBatteryDeviceGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateStorageBatteryDeviceGenPage(String var, Object val) {
		StorageBatteryDeviceGenPage oStorageBatteryDeviceGenPage = (StorageBatteryDeviceGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetStorageBatteryDeviceGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetStorageBatteryDeviceGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "listStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSetListStorageBatteryDevice(siteRequest_, o);
		case "storageBatteryDeviceCount":
			return StorageBatteryDeviceGenPage.staticSetStorageBatteryDeviceCount(siteRequest_, o);
		case "pk":
			return StorageBatteryDeviceGenPage.staticSetPk(siteRequest_, o);
		case "id":
			return StorageBatteryDeviceGenPage.staticSetId(siteRequest_, o);
		case "pageUriStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSetPageUriStorageBatteryDevice(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStorageBatteryDeviceGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchStorageBatteryDeviceGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "listStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSearchListStorageBatteryDevice(siteRequest_, (JsonArray)o);
		case "storageBatteryDeviceCount":
			return StorageBatteryDeviceGenPage.staticSearchStorageBatteryDeviceCount(siteRequest_, (Integer)o);
		case "pk":
			return StorageBatteryDeviceGenPage.staticSearchPk(siteRequest_, (Long)o);
		case "id":
			return StorageBatteryDeviceGenPage.staticSearchId(siteRequest_, (String)o);
		case "pageUriStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSearchPageUriStorageBatteryDevice(siteRequest_, (String)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrStorageBatteryDeviceGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrStorageBatteryDeviceGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "listStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSearchStrListStorageBatteryDevice(siteRequest_, (String)o);
		case "storageBatteryDeviceCount":
			return StorageBatteryDeviceGenPage.staticSearchStrStorageBatteryDeviceCount(siteRequest_, (Integer)o);
		case "pk":
			return StorageBatteryDeviceGenPage.staticSearchStrPk(siteRequest_, (Long)o);
		case "id":
			return StorageBatteryDeviceGenPage.staticSearchStrId(siteRequest_, (String)o);
		case "pageUriStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSearchStrPageUriStorageBatteryDevice(siteRequest_, (String)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqStorageBatteryDeviceGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqStorageBatteryDeviceGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "listStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSearchFqListStorageBatteryDevice(siteRequest_, o);
		case "storageBatteryDeviceCount":
			return StorageBatteryDeviceGenPage.staticSearchFqStorageBatteryDeviceCount(siteRequest_, o);
		case "pk":
			return StorageBatteryDeviceGenPage.staticSearchFqPk(siteRequest_, o);
		case "id":
			return StorageBatteryDeviceGenPage.staticSearchFqId(siteRequest_, o);
		case "pageUriStorageBatteryDevice":
			return StorageBatteryDeviceGenPage.staticSearchFqPageUriStorageBatteryDevice(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "StorageBatteryDeviceGenPage";
	public static final String VAR_searchListStorageBatteryDevice_ = "searchListStorageBatteryDevice_";
	public static final String VAR_listStorageBatteryDevice = "listStorageBatteryDevice";
	public static final String VAR_storageBatteryDeviceCount = "storageBatteryDeviceCount";
	public static final String VAR_storageBatteryDevice_ = "storageBatteryDevice_";
	public static final String VAR_pk = "pk";
	public static final String VAR_id = "id";
	public static final String VAR_pageUriStorageBatteryDevice = "pageUriStorageBatteryDevice";

	public static final String DISPLAY_NAME_searchListStorageBatteryDevice_ = "";
	public static final String DISPLAY_NAME_listStorageBatteryDevice = "";
	public static final String DISPLAY_NAME_storageBatteryDeviceCount = "";
	public static final String DISPLAY_NAME_storageBatteryDevice_ = "";
	public static final String DISPLAY_NAME_pk = "";
	public static final String DISPLAY_NAME_id = "";
	public static final String DISPLAY_NAME_pageUriStorageBatteryDevice = "";

	public static String displayNameForClass(String var) {
		return StorageBatteryDeviceGenPage.displayNameStorageBatteryDeviceGenPage(var);
	}
	public static String displayNameStorageBatteryDeviceGenPage(String var) {
		switch(var) {
		case VAR_searchListStorageBatteryDevice_:
			return DISPLAY_NAME_searchListStorageBatteryDevice_;
		case VAR_listStorageBatteryDevice:
			return DISPLAY_NAME_listStorageBatteryDevice;
		case VAR_storageBatteryDeviceCount:
			return DISPLAY_NAME_storageBatteryDeviceCount;
		case VAR_storageBatteryDevice_:
			return DISPLAY_NAME_storageBatteryDevice_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_pageUriStorageBatteryDevice:
			return DISPLAY_NAME_pageUriStorageBatteryDevice;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
