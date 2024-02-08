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
import org.computate.smartvillage.enus.model.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.computate.smartvillage.enus.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.pgclient.PgPool;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.computate.search.response.solr.SolrResponse.StatsField;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import java.nio.charset.Charset;
import io.vertx.ext.auth.authorization.RoleBasedAuthorization;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map.Entry;
import java.util.Iterator;
import org.computate.search.tool.SearchTool;
import org.computate.search.response.solr.SolrResponse;
import java.util.Base64;
import java.time.ZonedDateTime;
import org.apache.commons.lang3.BooleanUtils;
import org.computate.vertx.search.list.SearchList;
import org.computate.smartvillage.enus.model.traffic.fiware.trafficflowobserved.TrafficFlowObservedPage;


/**
 * Translate: false
 * Generated: true
 **/
public class TrafficFlowObservedEnUSGenApiServiceImpl extends BaseApiServiceImpl implements TrafficFlowObservedEnUSGenApiService {

	protected static final Logger LOG = LoggerFactory.getLogger(TrafficFlowObservedEnUSGenApiServiceImpl.class);

	public TrafficFlowObservedEnUSGenApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, KafkaProducer<String, String> kafkaProducer, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, kafkaProducer, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	// Search //

	@Override
	public void searchTrafficFlowObserved(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {

			authorizationProvider.getAuthorizations(siteRequest.getUser()).onFailure(ex -> {
				String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", msg)
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
					)
				));
			}).onSuccess(b -> {
				if(
						!Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						&& !Optional.ofNullable(Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_READ_REQUIRED + "_TrafficFlowObserved")).orElse(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"))).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						) {
					String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED",
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", msg)
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						searchTrafficFlowObservedList(siteRequest, false, true, false).onSuccess(listTrafficFlowObserved -> {
							response200SearchTrafficFlowObserved(listTrafficFlowObserved).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("searchTrafficFlowObserved succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
						error(null, eventHandler, ex);
					}
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200SearchTrafficFlowObserved(SearchList<TrafficFlowObserved> listTrafficFlowObserved) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listTrafficFlowObserved.getSiteRequest_(SiteRequestEnUS.class);
			List<String> fls = listTrafficFlowObserved.getRequest().getFields();
			JsonObject json = new JsonObject();
			JsonArray l = new JsonArray();
			listTrafficFlowObserved.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					for(String fieldName : json2.fieldNames()) {
						String v = TrafficFlowObserved.varIndexedTrafficFlowObserved(fieldName);
						if(v != null)
							fieldNames.add(TrafficFlowObserved.varIndexedTrafficFlowObserved(fieldName));
					}
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk_docvalues_long");
						fieldNames.remove("created_docvalues_date");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			response200Search(listTrafficFlowObserved.getRequest(), listTrafficFlowObserved.getResponse(), json);
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchTrafficFlowObserved(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
		if(pivots != null) {
			for(SolrResponse.Pivot pivotField : pivots) {
				String entityIndexed = pivotField.getField();
				String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
				JsonObject pivotJson = new JsonObject();
				pivotArray.add(pivotJson);
				pivotJson.put("field", entityVar);
				pivotJson.put("value", pivotField.getValue());
				pivotJson.put("count", pivotField.getCount());
				Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
				List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
				if(pivotRanges != null) {
					JsonObject rangeJson = new JsonObject();
					pivotJson.put("ranges", rangeJson);
					for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
						JsonObject rangeFacetJson = new JsonObject();
						String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
						rangeJson.put(rangeFacetVar, rangeFacetJson);
						JsonObject rangeFacetCountsObject = new JsonObject();
						rangeFacetJson.put("counts", rangeFacetCountsObject);
						rangeFacet.getCounts().forEach((value, count) -> {
							rangeFacetCountsObject.put(value, count);
						});
					}
				}
				if(pivotFields2 != null) {
					JsonArray pivotArray2 = new JsonArray();
					pivotJson.put("pivot", pivotArray2);
					responsePivotSearchTrafficFlowObserved(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// GET //

	@Override
	public void getTrafficFlowObserved(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {

			authorizationProvider.getAuthorizations(siteRequest.getUser()).onFailure(ex -> {
				String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", msg)
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
					)
				));
			}).onSuccess(b -> {
				if(
						!Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						&& !Optional.ofNullable(Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_READ_REQUIRED + "_TrafficFlowObserved")).orElse(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"))).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						) {
					String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED",
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", msg)
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						searchTrafficFlowObservedList(siteRequest, false, true, false).onSuccess(listTrafficFlowObserved -> {
							response200GETTrafficFlowObserved(listTrafficFlowObserved).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("getTrafficFlowObserved succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("getTrafficFlowObserved failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("getTrafficFlowObserved failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("getTrafficFlowObserved failed. "), ex);
						error(null, eventHandler, ex);
					}
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("getTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("getTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200GETTrafficFlowObserved(SearchList<TrafficFlowObserved> listTrafficFlowObserved) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listTrafficFlowObserved.getSiteRequest_(SiteRequestEnUS.class);
			JsonObject json = JsonObject.mapFrom(listTrafficFlowObserved.getList().stream().findFirst().orElse(null));
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200GETTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PATCH //

	@Override
	public void patchTrafficFlowObserved(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("patchTrafficFlowObserved started. "));
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {

			authorizationProvider.getAuthorizations(siteRequest.getUser()).onFailure(ex -> {
				String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", msg)
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
					)
				));
			}).onSuccess(b -> {
				if(
						!Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						|| !Optional.ofNullable(Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_READ_REQUIRED + "_TrafficFlowObserved")).orElse(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"))).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						) {
					String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED",
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", msg)
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						searchTrafficFlowObservedList(siteRequest, false, true, true).onSuccess(listTrafficFlowObserved -> {
							try {
								if(listTrafficFlowObserved.getResponse().getResponse().getNumFound() > 1
										&& !Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
										) {
									String message = String.format("roles required: " + config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"));
									LOG.error(message);
									error(siteRequest, eventHandler, new RuntimeException(message));
								} else {

									ApiRequest apiRequest = new ApiRequest();
									apiRequest.setRows(listTrafficFlowObserved.getRequest().getRows());
									apiRequest.setNumFound(listTrafficFlowObserved.getResponse().getResponse().getNumFound());
									apiRequest.setNumPATCH(0L);
									apiRequest.initDeepApiRequest(siteRequest);
									siteRequest.setApiRequest_(apiRequest);
									if(apiRequest.getNumFound() == 1L)
										apiRequest.setOriginal(listTrafficFlowObserved.first());
									apiRequest.setPk(Optional.ofNullable(listTrafficFlowObserved.first()).map(o2 -> o2.getPk()).orElse(null));
									eventBus.publish("websocketTrafficFlowObserved", JsonObject.mapFrom(apiRequest).toString());

									listPATCHTrafficFlowObserved(apiRequest, listTrafficFlowObserved).onSuccess(e -> {
										response200PATCHTrafficFlowObserved(siteRequest).onSuccess(response -> {
											LOG.debug(String.format("patchTrafficFlowObserved succeeded. "));
											eventHandler.handle(Future.succeededFuture(response));
										}).onFailure(ex -> {
											LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
											error(siteRequest, eventHandler, ex);
										});
									}).onFailure(ex -> {
										LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}
							} catch(Exception ex) {
								LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
						error(null, eventHandler, ex);
					}
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("patchTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPATCHTrafficFlowObserved(ApiRequest apiRequest, SearchList<TrafficFlowObserved> listTrafficFlowObserved) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listTrafficFlowObserved.getSiteRequest_(SiteRequestEnUS.class);
		listTrafficFlowObserved.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequestEnUS.class);
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			futures.add(Future.future(promise1 -> {
				patchTrafficFlowObservedFuture(o, false).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listPATCHTrafficFlowObserved failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listTrafficFlowObserved.next().onSuccess(next -> {
				if(next) {
					listPATCHTrafficFlowObserved(apiRequest, listTrafficFlowObserved).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPATCHTrafficFlowObserved failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPATCHTrafficFlowObserved failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPATCHTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void patchTrafficFlowObservedFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				searchTrafficFlowObservedList(siteRequest, false, true, true).onSuccess(listTrafficFlowObserved -> {
					try {
						TrafficFlowObserved o = listTrafficFlowObserved.first();
						if(o != null && listTrafficFlowObserved.getResponse().getResponse().getNumFound() == 1) {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(1L);
							apiRequest.setNumFound(1L);
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
								siteRequest.getRequestVars().put( "refresh", "false" );
							}
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setPk(Optional.ofNullable(listTrafficFlowObserved.first()).map(o2 -> o2.getPk()).orElse(null));
							patchTrafficFlowObservedFuture(o, false).onSuccess(o2 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("patchTrafficFlowObserved failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<TrafficFlowObserved> patchTrafficFlowObservedFuture(TrafficFlowObserved o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		Promise<TrafficFlowObserved> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<TrafficFlowObserved> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsTrafficFlowObserved(siteRequest).onSuccess(a -> {
					sqlPATCHTrafficFlowObserved(o, inheritPk).onSuccess(trafficFlowObserved -> {
						persistTrafficFlowObserved(trafficFlowObserved).onSuccess(c -> {
							relateTrafficFlowObserved(trafficFlowObserved).onSuccess(d -> {
								indexTrafficFlowObserved(trafficFlowObserved).onSuccess(o2 -> {
									if(apiRequest != null) {
										apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
										if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
											o2.apiRequestTrafficFlowObserved();
											if(apiRequest.getVars().size() > 0)
												eventBus.publish("websocketTrafficFlowObserved", JsonObject.mapFrom(apiRequest).toString());
										}
									}
									promise1.complete(trafficFlowObserved);
								}).onFailure(ex -> {
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(trafficFlowObserved -> {
				Promise<TrafficFlowObserved> promise2 = Promise.promise();
				refreshTrafficFlowObserved(trafficFlowObserved).onSuccess(a -> {
					promise2.complete(trafficFlowObserved);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(trafficFlowObserved -> {
				promise.complete(trafficFlowObserved);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("patchTrafficFlowObservedFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<TrafficFlowObserved> sqlPATCHTrafficFlowObserved(TrafficFlowObserved o, Boolean inheritPk) {
		Promise<TrafficFlowObserved> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE TrafficFlowObserved SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			TrafficFlowObserved o2 = new TrafficFlowObserved();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			for(String entityVar : methodNames) {
				switch(entityVar) {
					case "setInheritPk":
							o2.setInheritPk(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_inheritPk + "=$" + num);
							num++;
							bParams.add(o2.sqlInheritPk());
						break;
					case "setCreated":
							o2.setCreated(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_created + "=$" + num);
							num++;
							bParams.add(o2.sqlCreated());
						break;
					case "setArchived":
							o2.setArchived(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_archived + "=$" + num);
							num++;
							bParams.add(o2.sqlArchived());
						break;
					case "setDeleted":
							o2.setDeleted(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_deleted + "=$" + num);
							num++;
							bParams.add(o2.sqlDeleted());
						break;
					case "setSessionId":
							o2.setSessionId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_sessionId + "=$" + num);
							num++;
							bParams.add(o2.sqlSessionId());
						break;
					case "setUserKey":
							o2.setUserKey(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_userKey + "=$" + num);
							num++;
							bParams.add(o2.sqlUserKey());
						break;
					case "setColor":
							o2.setColor(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_color + "=$" + num);
							num++;
							bParams.add(o2.sqlColor());
						break;
					case "setEntityId":
							o2.setEntityId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_entityId + "=$" + num);
							num++;
							bParams.add(o2.sqlEntityId());
						break;
					case "setTrafficSimulationId":
							o2.setTrafficSimulationId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_trafficSimulationId + "=$" + num);
							num++;
							bParams.add(o2.sqlTrafficSimulationId());
						break;
					case "setLaneAreaDetectorId":
							o2.setLaneAreaDetectorId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_laneAreaDetectorId + "=$" + num);
							num++;
							bParams.add(o2.sqlLaneAreaDetectorId());
						break;
					case "setLocation":
							o2.setLocation(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_location + "=$" + num);
							num++;
							bParams.add(o2.sqlLocation());
						break;
					case "setSumocfgPath":
							o2.setSumocfgPath(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_sumocfgPath + "=$" + num);
							num++;
							bParams.add(o2.sqlSumocfgPath());
						break;
					case "setCustomTrafficLightId":
							o2.setCustomTrafficLightId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customTrafficLightId + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomTrafficLightId());
						break;
					case "setAddress":
							o2.setAddress(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_address + "=$" + num);
							num++;
							bParams.add(o2.sqlAddress());
						break;
					case "setAlternateName":
							o2.setAlternateName(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_alternateName + "=$" + num);
							num++;
							bParams.add(o2.sqlAlternateName());
						break;
					case "setAreaServed":
							o2.setAreaServed(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_areaServed + "=$" + num);
							num++;
							bParams.add(o2.sqlAreaServed());
						break;
					case "setAverageGapDistance":
							o2.setAverageGapDistance(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_averageGapDistance + "=$" + num);
							num++;
							bParams.add(o2.sqlAverageGapDistance());
						break;
					case "setAverageHeadwayTime":
							o2.setAverageHeadwayTime(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_averageHeadwayTime + "=$" + num);
							num++;
							bParams.add(o2.sqlAverageHeadwayTime());
						break;
					case "setAverageVehicleLength":
							o2.setAverageVehicleLength(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_averageVehicleLength + "=$" + num);
							num++;
							bParams.add(o2.sqlAverageVehicleLength());
						break;
					case "setAverageVehicleSpeed":
							o2.setAverageVehicleSpeed(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_averageVehicleSpeed + "=$" + num);
							num++;
							bParams.add(o2.sqlAverageVehicleSpeed());
						break;
					case "setCongested":
							o2.setCongested(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_congested + "=$" + num);
							num++;
							bParams.add(o2.sqlCongested());
						break;
					case "setDataProvider":
							o2.setDataProvider(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_dataProvider + "=$" + num);
							num++;
							bParams.add(o2.sqlDataProvider());
						break;
					case "setDateCreated":
							o2.setDateCreated(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_dateCreated + "=$" + num);
							num++;
							bParams.add(o2.sqlDateCreated());
						break;
					case "setDateModified":
							o2.setDateModified(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_dateModified + "=$" + num);
							num++;
							bParams.add(o2.sqlDateModified());
						break;
					case "setDateObserved":
							o2.setDateObserved(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_dateObserved + "=$" + num);
							num++;
							bParams.add(o2.sqlDateObserved());
						break;
					case "setDateObservedFrom":
							o2.setDateObservedFrom(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_dateObservedFrom + "=$" + num);
							num++;
							bParams.add(o2.sqlDateObservedFrom());
						break;
					case "setDateObservedTo":
							o2.setDateObservedTo(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_dateObservedTo + "=$" + num);
							num++;
							bParams.add(o2.sqlDateObservedTo());
						break;
					case "setDescription":
							o2.setDescription(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_description + "=$" + num);
							num++;
							bParams.add(o2.sqlDescription());
						break;
					case "setIntensity":
							o2.setIntensity(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_intensity + "=$" + num);
							num++;
							bParams.add(o2.sqlIntensity());
						break;
					case "setLaneDirection":
							o2.setLaneDirection(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_laneDirection + "=$" + num);
							num++;
							bParams.add(o2.sqlLaneDirection());
						break;
					case "setLaneId":
							o2.setLaneId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_laneId + "=$" + num);
							num++;
							bParams.add(o2.sqlLaneId());
						break;
					case "setName":
							o2.setName(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_name + "=$" + num);
							num++;
							bParams.add(o2.sqlName());
						break;
					case "setOccupancy":
							o2.setOccupancy(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_occupancy + "=$" + num);
							num++;
							bParams.add(o2.sqlOccupancy());
						break;
					case "setOwner":
							o2.setOwner(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_owner + "=$" + num);
							num++;
							bParams.add(o2.sqlOwner());
						break;
					case "setRefRoadSegment":
							o2.setRefRoadSegment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_refRoadSegment + "=$" + num);
							num++;
							bParams.add(o2.sqlRefRoadSegment());
						break;
					case "setReversedLane":
							o2.setReversedLane(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_reversedLane + "=$" + num);
							num++;
							bParams.add(o2.sqlReversedLane());
						break;
					case "setSeeAlso":
							o2.setSeeAlso(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_seeAlso + "=$" + num);
							num++;
							bParams.add(o2.sqlSeeAlso());
						break;
					case "setSource":
							o2.setSource(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_source + "=$" + num);
							num++;
							bParams.add(o2.sqlSource());
						break;
					case "setVehicleSubType":
							o2.setVehicleSubType(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_vehicleSubType + "=$" + num);
							num++;
							bParams.add(o2.sqlVehicleSubType());
						break;
					case "setVehicleType":
							o2.setVehicleType(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_vehicleType + "=$" + num);
							num++;
							bParams.add(o2.sqlVehicleType());
						break;
					case "setCustomSigma":
							o2.setCustomSigma(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customSigma + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomSigma());
						break;
					case "setCustomAcceleration":
							o2.setCustomAcceleration(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customAcceleration + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomAcceleration());
						break;
					case "setCustomDeceleration":
							o2.setCustomDeceleration(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customDeceleration + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomDeceleration());
						break;
					case "setCustomMinGreenTime":
							o2.setCustomMinGreenTime(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customMinGreenTime + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomMinGreenTime());
						break;
					case "setCustomMaxGreenTime":
							o2.setCustomMaxGreenTime(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customMaxGreenTime + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomMaxGreenTime());
						break;
					case "setCustomAverageVehiclesPerMinute":
							o2.setCustomAverageVehiclesPerMinute(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customAverageVehiclesPerMinute + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomAverageVehiclesPerMinute());
						break;
					case "setCustomDemandScalingFactor":
							o2.setCustomDemandScalingFactor(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customDemandScalingFactor + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomDemandScalingFactor());
						break;
					case "setCustomQueueLengthThreshold":
							o2.setCustomQueueLengthThreshold(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(TrafficFlowObserved.VAR_customQueueLengthThreshold + "=$" + num);
							num++;
							bParams.add(o2.sqlCustomQueueLengthThreshold());
						break;
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
				bParams.add(pk);
				num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value TrafficFlowObserved failed", ex);
						LOG.error(String.format("relateTrafficFlowObserved failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					TrafficFlowObserved o3 = new TrafficFlowObserved();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					promise.complete(o3);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPATCHTrafficFlowObserved failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPATCHTrafficFlowObserved failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPATCHTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200PATCHTrafficFlowObserved(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PATCHTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// POST //

	@Override
	public void postTrafficFlowObserved(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("postTrafficFlowObserved started. "));
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {

			authorizationProvider.getAuthorizations(siteRequest.getUser()).onFailure(ex -> {
				String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", msg)
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
					)
				));
			}).onSuccess(b -> {
				if(
						!Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						|| !Optional.ofNullable(Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_READ_REQUIRED + "_TrafficFlowObserved")).orElse(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"))).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						) {
					String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED",
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", msg)
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						ApiRequest apiRequest = new ApiRequest();
						apiRequest.setRows(1L);
						apiRequest.setNumFound(1L);
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketTrafficFlowObserved", JsonObject.mapFrom(apiRequest).toString());
						JsonObject params = new JsonObject();
						params.put("body", siteRequest.getJsonObject());
						params.put("path", new JsonObject());
						params.put("cookie", new JsonObject());
						params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
						params.put("form", new JsonObject());
						JsonObject query = new JsonObject();
						Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
						Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
						if(softCommit == null && commitWithin == null)
							softCommit = true;
						if(softCommit != null)
							query.put("softCommit", softCommit);
						if(commitWithin != null)
							query.put("commitWithin", commitWithin);
						params.put("query", query);
						JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
						JsonObject json = new JsonObject().put("context", context);
						eventBus.request(TrafficFlowObserved.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postTrafficFlowObservedFuture")).onSuccess(a -> {
							JsonObject responseMessage = (JsonObject)a.body();
							JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
							apiRequest.setPk(Long.parseLong(responseBody.getString("pk")));
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
							LOG.debug(String.format("postTrafficFlowObserved succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("postTrafficFlowObserved failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("postTrafficFlowObserved failed. "), ex);
						error(null, eventHandler, ex);
					}
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("postTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	@Override
	public void postTrafficFlowObservedFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			ApiRequest apiRequest = new ApiRequest();
			apiRequest.setRows(1L);
			apiRequest.setNumFound(1L);
			apiRequest.setNumPATCH(0L);
			apiRequest.initDeepApiRequest(siteRequest);
			siteRequest.setApiRequest_(apiRequest);
			if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
				siteRequest.getRequestVars().put( "refresh", "false" );
			}
			postTrafficFlowObservedFuture(siteRequest, false).onSuccess(o -> {
				eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
			}).onFailure(ex -> {
				eventHandler.handle(Future.failedFuture(ex));
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("postTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<TrafficFlowObserved> postTrafficFlowObservedFuture(SiteRequestEnUS siteRequest, Boolean inheritPk) {
		Promise<TrafficFlowObserved> promise = Promise.promise();

		try {
			pgPool.withTransaction(sqlConnection -> {
				Promise<TrafficFlowObserved> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				varsTrafficFlowObserved(siteRequest).onSuccess(a -> {
					createTrafficFlowObserved(siteRequest).onSuccess(trafficFlowObserved -> {
						sqlPOSTTrafficFlowObserved(trafficFlowObserved, inheritPk).onSuccess(b -> {
							persistTrafficFlowObserved(trafficFlowObserved).onSuccess(c -> {
								relateTrafficFlowObserved(trafficFlowObserved).onSuccess(d -> {
									indexTrafficFlowObserved(trafficFlowObserved).onSuccess(o2 -> {
										promise1.complete(trafficFlowObserved);
									}).onFailure(ex -> {
										promise1.fail(ex);
									});
								}).onFailure(ex -> {
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(trafficFlowObserved -> {
				Promise<TrafficFlowObserved> promise2 = Promise.promise();
				refreshTrafficFlowObserved(trafficFlowObserved).onSuccess(a -> {
					try {
						ApiRequest apiRequest = siteRequest.getApiRequest_();
						if(apiRequest != null) {
							apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
							trafficFlowObserved.apiRequestTrafficFlowObserved();
							eventBus.publish("websocketTrafficFlowObserved", JsonObject.mapFrom(apiRequest).toString());
						}
						promise2.complete(trafficFlowObserved);
					} catch(Exception ex) {
						LOG.error(String.format("postTrafficFlowObservedFuture failed. "), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(trafficFlowObserved -> {
				promise.complete(trafficFlowObserved);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("postTrafficFlowObservedFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlPOSTTrafficFlowObserved(TrafficFlowObserved o, Boolean inheritPk) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE TrafficFlowObserved SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			TrafficFlowObserved o2 = new TrafficFlowObserved();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("sessionId=$" + num);
				num++;
				bParams.add(siteRequest.getSessionId());
			}
			if(siteRequest.getUserKey() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("userKey=$" + num);
				num++;
				bParams.add(siteRequest.getUserKey());
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case TrafficFlowObserved.VAR_inheritPk:
						o2.setInheritPk(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_inheritPk + "=$" + num);
						num++;
						bParams.add(o2.sqlInheritPk());
						break;
					case TrafficFlowObserved.VAR_created:
						o2.setCreated(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_created + "=$" + num);
						num++;
						bParams.add(o2.sqlCreated());
						break;
					case TrafficFlowObserved.VAR_archived:
						o2.setArchived(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case TrafficFlowObserved.VAR_deleted:
						o2.setDeleted(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_deleted + "=$" + num);
						num++;
						bParams.add(o2.sqlDeleted());
						break;
					case TrafficFlowObserved.VAR_sessionId:
						o2.setSessionId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_sessionId + "=$" + num);
						num++;
						bParams.add(o2.sqlSessionId());
						break;
					case TrafficFlowObserved.VAR_userKey:
						o2.setUserKey(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_userKey + "=$" + num);
						num++;
						bParams.add(o2.sqlUserKey());
						break;
					case TrafficFlowObserved.VAR_color:
						o2.setColor(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_color + "=$" + num);
						num++;
						bParams.add(o2.sqlColor());
						break;
					case TrafficFlowObserved.VAR_entityId:
						o2.setEntityId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_entityId + "=$" + num);
						num++;
						bParams.add(o2.sqlEntityId());
						break;
					case TrafficFlowObserved.VAR_trafficSimulationId:
						o2.setTrafficSimulationId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_trafficSimulationId + "=$" + num);
						num++;
						bParams.add(o2.sqlTrafficSimulationId());
						break;
					case TrafficFlowObserved.VAR_laneAreaDetectorId:
						o2.setLaneAreaDetectorId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_laneAreaDetectorId + "=$" + num);
						num++;
						bParams.add(o2.sqlLaneAreaDetectorId());
						break;
					case TrafficFlowObserved.VAR_location:
						o2.setLocation(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_location + "=$" + num);
						num++;
						bParams.add(o2.sqlLocation());
						break;
					case TrafficFlowObserved.VAR_sumocfgPath:
						o2.setSumocfgPath(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_sumocfgPath + "=$" + num);
						num++;
						bParams.add(o2.sqlSumocfgPath());
						break;
					case TrafficFlowObserved.VAR_customTrafficLightId:
						o2.setCustomTrafficLightId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customTrafficLightId + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomTrafficLightId());
						break;
					case TrafficFlowObserved.VAR_address:
						o2.setAddress(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_address + "=$" + num);
						num++;
						bParams.add(o2.sqlAddress());
						break;
					case TrafficFlowObserved.VAR_alternateName:
						o2.setAlternateName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_alternateName + "=$" + num);
						num++;
						bParams.add(o2.sqlAlternateName());
						break;
					case TrafficFlowObserved.VAR_areaServed:
						o2.setAreaServed(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_areaServed + "=$" + num);
						num++;
						bParams.add(o2.sqlAreaServed());
						break;
					case TrafficFlowObserved.VAR_averageGapDistance:
						o2.setAverageGapDistance(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_averageGapDistance + "=$" + num);
						num++;
						bParams.add(o2.sqlAverageGapDistance());
						break;
					case TrafficFlowObserved.VAR_averageHeadwayTime:
						o2.setAverageHeadwayTime(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_averageHeadwayTime + "=$" + num);
						num++;
						bParams.add(o2.sqlAverageHeadwayTime());
						break;
					case TrafficFlowObserved.VAR_averageVehicleLength:
						o2.setAverageVehicleLength(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_averageVehicleLength + "=$" + num);
						num++;
						bParams.add(o2.sqlAverageVehicleLength());
						break;
					case TrafficFlowObserved.VAR_averageVehicleSpeed:
						o2.setAverageVehicleSpeed(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_averageVehicleSpeed + "=$" + num);
						num++;
						bParams.add(o2.sqlAverageVehicleSpeed());
						break;
					case TrafficFlowObserved.VAR_congested:
						o2.setCongested(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_congested + "=$" + num);
						num++;
						bParams.add(o2.sqlCongested());
						break;
					case TrafficFlowObserved.VAR_dataProvider:
						o2.setDataProvider(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_dataProvider + "=$" + num);
						num++;
						bParams.add(o2.sqlDataProvider());
						break;
					case TrafficFlowObserved.VAR_dateCreated:
						o2.setDateCreated(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_dateCreated + "=$" + num);
						num++;
						bParams.add(o2.sqlDateCreated());
						break;
					case TrafficFlowObserved.VAR_dateModified:
						o2.setDateModified(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_dateModified + "=$" + num);
						num++;
						bParams.add(o2.sqlDateModified());
						break;
					case TrafficFlowObserved.VAR_dateObserved:
						o2.setDateObserved(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_dateObserved + "=$" + num);
						num++;
						bParams.add(o2.sqlDateObserved());
						break;
					case TrafficFlowObserved.VAR_dateObservedFrom:
						o2.setDateObservedFrom(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_dateObservedFrom + "=$" + num);
						num++;
						bParams.add(o2.sqlDateObservedFrom());
						break;
					case TrafficFlowObserved.VAR_dateObservedTo:
						o2.setDateObservedTo(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_dateObservedTo + "=$" + num);
						num++;
						bParams.add(o2.sqlDateObservedTo());
						break;
					case TrafficFlowObserved.VAR_description:
						o2.setDescription(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_description + "=$" + num);
						num++;
						bParams.add(o2.sqlDescription());
						break;
					case TrafficFlowObserved.VAR_intensity:
						o2.setIntensity(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_intensity + "=$" + num);
						num++;
						bParams.add(o2.sqlIntensity());
						break;
					case TrafficFlowObserved.VAR_laneDirection:
						o2.setLaneDirection(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_laneDirection + "=$" + num);
						num++;
						bParams.add(o2.sqlLaneDirection());
						break;
					case TrafficFlowObserved.VAR_laneId:
						o2.setLaneId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_laneId + "=$" + num);
						num++;
						bParams.add(o2.sqlLaneId());
						break;
					case TrafficFlowObserved.VAR_name:
						o2.setName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_name + "=$" + num);
						num++;
						bParams.add(o2.sqlName());
						break;
					case TrafficFlowObserved.VAR_occupancy:
						o2.setOccupancy(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_occupancy + "=$" + num);
						num++;
						bParams.add(o2.sqlOccupancy());
						break;
					case TrafficFlowObserved.VAR_owner:
						o2.setOwner(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_owner + "=$" + num);
						num++;
						bParams.add(o2.sqlOwner());
						break;
					case TrafficFlowObserved.VAR_refRoadSegment:
						o2.setRefRoadSegment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_refRoadSegment + "=$" + num);
						num++;
						bParams.add(o2.sqlRefRoadSegment());
						break;
					case TrafficFlowObserved.VAR_reversedLane:
						o2.setReversedLane(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_reversedLane + "=$" + num);
						num++;
						bParams.add(o2.sqlReversedLane());
						break;
					case TrafficFlowObserved.VAR_seeAlso:
						o2.setSeeAlso(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_seeAlso + "=$" + num);
						num++;
						bParams.add(o2.sqlSeeAlso());
						break;
					case TrafficFlowObserved.VAR_source:
						o2.setSource(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_source + "=$" + num);
						num++;
						bParams.add(o2.sqlSource());
						break;
					case TrafficFlowObserved.VAR_vehicleSubType:
						o2.setVehicleSubType(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_vehicleSubType + "=$" + num);
						num++;
						bParams.add(o2.sqlVehicleSubType());
						break;
					case TrafficFlowObserved.VAR_vehicleType:
						o2.setVehicleType(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_vehicleType + "=$" + num);
						num++;
						bParams.add(o2.sqlVehicleType());
						break;
					case TrafficFlowObserved.VAR_customSigma:
						o2.setCustomSigma(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customSigma + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomSigma());
						break;
					case TrafficFlowObserved.VAR_customAcceleration:
						o2.setCustomAcceleration(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customAcceleration + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomAcceleration());
						break;
					case TrafficFlowObserved.VAR_customDeceleration:
						o2.setCustomDeceleration(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customDeceleration + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomDeceleration());
						break;
					case TrafficFlowObserved.VAR_customMinGreenTime:
						o2.setCustomMinGreenTime(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customMinGreenTime + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomMinGreenTime());
						break;
					case TrafficFlowObserved.VAR_customMaxGreenTime:
						o2.setCustomMaxGreenTime(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customMaxGreenTime + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomMaxGreenTime());
						break;
					case TrafficFlowObserved.VAR_customAverageVehiclesPerMinute:
						o2.setCustomAverageVehiclesPerMinute(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customAverageVehiclesPerMinute + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomAverageVehiclesPerMinute());
						break;
					case TrafficFlowObserved.VAR_customDemandScalingFactor:
						o2.setCustomDemandScalingFactor(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customDemandScalingFactor + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomDemandScalingFactor());
						break;
					case TrafficFlowObserved.VAR_customQueueLengthThreshold:
						o2.setCustomQueueLengthThreshold(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(TrafficFlowObserved.VAR_customQueueLengthThreshold + "=$" + num);
						num++;
						bParams.add(o2.sqlCustomQueueLengthThreshold());
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
			bParams.add(pk);
			num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value TrafficFlowObserved failed", ex);
						LOG.error(String.format("relateTrafficFlowObserved failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPOSTTrafficFlowObserved failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPOSTTrafficFlowObserved failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPOSTTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200POSTTrafficFlowObserved(TrafficFlowObserved o) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200POSTTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PUTImport //

	@Override
	public void putimportTrafficFlowObserved(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putimportTrafficFlowObserved started. "));
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {

			authorizationProvider.getAuthorizations(siteRequest.getUser()).onFailure(ex -> {
				String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", msg)
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
					)
				));
			}).onSuccess(b -> {
				if(
						!Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						|| !Optional.ofNullable(Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_READ_REQUIRED + "_TrafficFlowObserved")).orElse(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"))).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						) {
					String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED",
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", msg)
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						ApiRequest apiRequest = new ApiRequest();
						JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
						apiRequest.setRows(Long.valueOf(jsonArray.size()));
						apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketTrafficFlowObserved", JsonObject.mapFrom(apiRequest).toString());
						varsTrafficFlowObserved(siteRequest).onSuccess(d -> {
							listPUTImportTrafficFlowObserved(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTImportTrafficFlowObserved(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putimportTrafficFlowObserved succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putimportTrafficFlowObserved failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putimportTrafficFlowObserved failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putimportTrafficFlowObserved failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("putimportTrafficFlowObserved failed. "), ex);
						error(null, eventHandler, ex);
					}
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("putimportTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPUTImportTrafficFlowObserved(ApiRequest apiRequest, SiteRequestEnUS siteRequest) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				futures.add(Future.future(promise1 -> {
					JsonObject params = new JsonObject();
					params.put("body", obj);
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
					params.put("form", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit != null)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request(TrafficFlowObserved.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportTrafficFlowObservedFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportTrafficFlowObserved failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTImportTrafficFlowObserved failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTImportTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putimportTrafficFlowObservedFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				String inheritPk = Optional.ofNullable(body.getString(TrafficFlowObserved.VAR_pk)).orElse(body.getString(TrafficFlowObserved.VAR_id));
				body.put("inheritPk", inheritPk);
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}

				SearchList<TrafficFlowObserved> searchList = new SearchList<TrafficFlowObserved>();
				searchList.setStore(true);
				searchList.q("*:*");
				searchList.setC(TrafficFlowObserved.class);
				searchList.fq("deleted_docvalues_boolean:false");
				searchList.fq("archived_docvalues_boolean:false");
				searchList.fq("inheritPk_docvalues_string:" + SearchTool.escapeQueryChars(inheritPk));
				searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						if(searchList.size() >= 1) {
							TrafficFlowObserved o = searchList.getList().stream().findFirst().orElse(null);
							TrafficFlowObserved o2 = new TrafficFlowObserved();
							o2.setSiteRequest_(siteRequest);
							JsonObject body2 = new JsonObject();
							for(String f : body.fieldNames()) {
								Object bodyVal = body.getValue(f);
								if(bodyVal instanceof JsonArray) {
									JsonArray bodyVals = (JsonArray)bodyVal;
									Object valsObj = o.obtainForClass(f);
									Collection<?> vals = valsObj instanceof JsonArray ? ((JsonArray)valsObj).getList() : (Collection<?>)valsObj;
									if(bodyVals.size() == vals.size()) {
										Boolean match = true;
										for(Object val : vals) {
											if(val != null) {
												if(!bodyVals.contains(val.toString())) {
													match = false;
													break;
												}
											} else {
												match = false;
												break;
											}
										}
										vals.clear();
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									} else {
										vals.clear();
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									}
								} else {
									o2.persistForClass(f, bodyVal);
									o2.relateForClass(f, bodyVal);
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
								}
							}
							for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
								if(!body.fieldNames().contains(f)) {
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.putNull("set" + StringUtils.capitalize(f));
								}
							}
							if(body2.size() > 0) {
								if(searchList.size() == 1) {
									apiRequest.setOriginal(o);
									apiRequest.setPk(o.getPk());
								}
								siteRequest.setJsonObject(body2);
								patchTrafficFlowObservedFuture(o, true).onSuccess(b -> {
									LOG.debug("Import TrafficFlowObserved {} succeeded, modified TrafficFlowObserved. ", body.getValue(TrafficFlowObserved.VAR_pk));
									eventHandler.handle(Future.succeededFuture());
								}).onFailure(ex -> {
									LOG.error(String.format("putimportTrafficFlowObservedFuture failed. "), ex);
									eventHandler.handle(Future.failedFuture(ex));
								});
							} else {
								eventHandler.handle(Future.succeededFuture());
							}
						} else {
							postTrafficFlowObservedFuture(siteRequest, true).onSuccess(b -> {
								LOG.debug("Import TrafficFlowObserved {} succeeded, created new TrafficFlowObserved. ", body.getValue(TrafficFlowObserved.VAR_pk));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putimportTrafficFlowObservedFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						}
					} catch(Exception ex) {
						LOG.error(String.format("putimportTrafficFlowObservedFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					}
				}).onFailure(ex -> {
					LOG.error(String.format("putimportTrafficFlowObservedFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putimportTrafficFlowObservedFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("putimportTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200PUTImportTrafficFlowObserved(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTImportTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// SearchPage //

	@Override
	public void searchpageTrafficFlowObservedId(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		searchpageTrafficFlowObserved(serviceRequest, eventHandler);
	}

	@Override
	public void searchpageTrafficFlowObserved(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {

			authorizationProvider.getAuthorizations(siteRequest.getUser()).onFailure(ex -> {
				String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", msg)
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
					)
				));
			}).onSuccess(b -> {
				if(
						!Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved")).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						&& !Optional.ofNullable(Optional.ofNullable(config.getString(ConfigKeys.AUTH_ROLE_READ_REQUIRED + "_TrafficFlowObserved")).orElse(config.getString(ConfigKeys.AUTH_ROLE_REQUIRED + "_TrafficFlowObserved"))).map(v -> RoleBasedAuthorization.create(v).match(siteRequest.getUser())).orElse(false)
						) {
					String msg = String.format("401 UNAUTHORIZED user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED",
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", msg)
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						searchTrafficFlowObservedList(siteRequest, false, true, false).onSuccess(listTrafficFlowObserved -> {
							response200SearchPageTrafficFlowObserved(listTrafficFlowObserved).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("searchpageTrafficFlowObserved succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("searchpageTrafficFlowObserved failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("searchpageTrafficFlowObserved failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("searchpageTrafficFlowObserved failed. "), ex);
						error(null, eventHandler, ex);
					}
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchpageTrafficFlowObserved failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("searchpageTrafficFlowObserved failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public void searchpageTrafficFlowObservedPageInit(TrafficFlowObservedPage page, SearchList<TrafficFlowObserved> listTrafficFlowObserved) {
	}

	public String templateSearchPageTrafficFlowObserved() {
		return Optional.ofNullable(config.getString(ConfigKeys.TEMPLATE_PATH)).orElse("templates") + "/enUS/TrafficFlowObservedPage";
	}
	public Future<ServiceResponse> response200SearchPageTrafficFlowObserved(SearchList<TrafficFlowObserved> listTrafficFlowObserved) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listTrafficFlowObserved.getSiteRequest_(SiteRequestEnUS.class);
			TrafficFlowObservedPage page = new TrafficFlowObservedPage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listTrafficFlowObserved.size() == 1)
				siteRequest.setRequestPk(listTrafficFlowObserved.get(0).getPk());
			page.setSearchListTrafficFlowObserved_(listTrafficFlowObserved);
			page.setSiteRequest_(siteRequest);
			page.promiseDeepTrafficFlowObservedPage(siteRequest).onSuccess(a -> {
				JsonObject json = JsonObject.mapFrom(page);
				json.put(ConfigKeys.STATIC_BASE_URL, config.getString(ConfigKeys.STATIC_BASE_URL));
				json.put(ConfigKeys.GITHUB_ORG, config.getString(ConfigKeys.GITHUB_ORG));
				json.put(ConfigKeys.SITE_NAME, config.getString(ConfigKeys.SITE_NAME));
				json.put(ConfigKeys.SITE_DISPLAY_NAME, config.getString(ConfigKeys.SITE_DISPLAY_NAME));
				json.put(ConfigKeys.SITE_POWERED_BY_URL, config.getString(ConfigKeys.SITE_POWERED_BY_URL));
				json.put(ConfigKeys.SITE_POWERED_BY_NAME, config.getString(ConfigKeys.SITE_POWERED_BY_NAME));
				json.put(ConfigKeys.SITE_POWERED_BY_IMAGE_URI, config.getString(ConfigKeys.SITE_POWERED_BY_IMAGE_URI));
				templateEngine.render(json, templateSearchPageTrafficFlowObserved()).onSuccess(buffer -> {
					promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchPageTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// General //

	public Future<TrafficFlowObserved> createTrafficFlowObserved(SiteRequestEnUS siteRequest) {
		Promise<TrafficFlowObserved> promise = Promise.promise();
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long userKey = siteRequest.getUserKey();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

			sqlConnection.preparedQuery("INSERT INTO TrafficFlowObserved(created, userKey) VALUES($1, $2) RETURNING pk")
					.collecting(Collectors.toList())
					.execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
				Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				TrafficFlowObserved o = new TrafficFlowObserved();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				promise.complete(o);
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error("createTrafficFlowObserved failed. ", ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("createTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public void searchTrafficFlowObservedQ(SearchList<TrafficFlowObserved> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public String searchTrafficFlowObservedFq(SearchList<TrafficFlowObserved> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : TrafficFlowObserved.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : TrafficFlowObserved.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), fqs[1]);
			 return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
		} else {
			return varIndexed + ":" + SearchTool.escapeQueryChars(TrafficFlowObserved.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), valueIndexed)).replace("\\", "\\\\");
		}
	}

	public void searchTrafficFlowObservedSort(SearchList<TrafficFlowObserved> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.sort(varIndexed, valueIndexed);
	}

	public void searchTrafficFlowObservedRows(SearchList<TrafficFlowObserved> searchList, Long valueRows) {
			searchList.rows(valueRows != null ? valueRows : 10L);
	}

	public void searchTrafficFlowObservedStart(SearchList<TrafficFlowObserved> searchList, Long valueStart) {
		searchList.start(valueStart);
	}

	public void searchTrafficFlowObservedVar(SearchList<TrafficFlowObserved> searchList, String var, String value) {
		searchList.getSiteRequest_(SiteRequestEnUS.class).getRequestVars().put(var, value);
	}

	public void searchTrafficFlowObservedUri(SearchList<TrafficFlowObserved> searchList) {
	}

	public Future<ServiceResponse> varsTrafficFlowObserved(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();

			serviceRequest.getParams().getJsonObject("query").stream().filter(paramRequest -> "var".equals(paramRequest.getKey()) && paramRequest.getValue() != null).findFirst().ifPresent(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						siteRequest.getRequestVars().put(entityVar, valueIndexed);
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
					promise.fail(ex);
				}
			});
			promise.complete();
		} catch(Exception ex) {
			LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<SearchList<TrafficFlowObserved>> searchTrafficFlowObservedList(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify) {
		Promise<SearchList<TrafficFlowObserved>> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();
			String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<TrafficFlowObserved> searchList = new SearchList<TrafficFlowObserved>();
			String facetRange = null;
			Date facetRangeStart = null;
			Date facetRangeEnd = null;
			String facetRangeGap = null;
			String statsField = null;
			String statsFieldIndexed = null;
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.q("*:*");
			searchList.setC(TrafficFlowObserved.class);
			searchList.setSiteRequest_(siteRequest);
			if(entityList != null) {
				for(String v : entityList) {
					searchList.fl(TrafficFlowObserved.varIndexedTrafficFlowObserved(v));
				}
			}

			String id = serviceRequest.getParams().getJsonObject("path").getString("id");
			if(id != null && NumberUtils.isCreatable(id)) {
				searchList.fq("(pk_docvalues_long:" + SearchTool.escapeQueryChars(id) + " OR objectId_docvalues_string:" + SearchTool.escapeQueryChars(id) + ")");
			} else if(id != null) {
				searchList.fq("objectId_docvalues_string:" + SearchTool.escapeQueryChars(id));
			}

			for(String paramName : serviceRequest.getParams().getJsonObject("query").fieldNames()) {
				Object paramValuesObject = serviceRequest.getParams().getJsonObject("query").getValue(paramName);
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Long valueStart = null;
				Long valueRows = null;
				String valueCursorMark = null;
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
						Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
						boolean foundFacetPivot = mFacetPivot.find();
						if(foundFacetPivot) {
							String solrLocalParams = mFacetPivot.group(1);
							String[] entityVars = mFacetPivot.group(2).trim().split(",");
							String[] varsIndexed = new String[entityVars.length];
							for(Integer i = 0; i < entityVars.length; i++) {
								entityVar = entityVars[i];
								varsIndexed[i] = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
							}
							searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
						}
					} else if(paramValuesObject != null) {
						for(Object paramObject : paramObjects) {
							if(paramName.equals("q")) {
								Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
								boolean foundQ = mQ.find();
								if(foundQ) {
									StringBuffer sb = new StringBuffer();
									while(foundQ) {
										entityVar = mQ.group(1).trim();
										valueIndexed = mQ.group(2).trim();
										varIndexed = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
										String entityQ = searchTrafficFlowObservedFq(searchList, entityVar, valueIndexed, varIndexed);
										mQ.appendReplacement(sb, entityQ);
										foundQ = mQ.find();
									}
									mQ.appendTail(sb);
									searchList.q(sb.toString());
								}
							} else if(paramName.equals("fq")) {
								Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
								boolean foundFq = mFq.find();
								if(foundFq) {
									StringBuffer sb = new StringBuffer();
									while(foundFq) {
										entityVar = mFq.group(1).trim();
										valueIndexed = mFq.group(2).trim();
										varIndexed = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
										String entityFq = searchTrafficFlowObservedFq(searchList, entityVar, valueIndexed, varIndexed);
										mFq.appendReplacement(sb, entityFq);
										foundFq = mFq.find();
									}
									mFq.appendTail(sb);
									searchList.fq(sb.toString());
								}
							} else if(paramName.equals("sort")) {
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
								valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
								varIndexed = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
								searchTrafficFlowObservedSort(searchList, entityVar, valueIndexed, varIndexed);
							} else if(paramName.equals("start")) {
								valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
								searchTrafficFlowObservedStart(searchList, valueStart);
							} else if(paramName.equals("rows")) {
								valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
								searchTrafficFlowObservedRows(searchList, valueRows);
							} else if(paramName.equals("stats")) {
								searchList.stats((Boolean)paramObject);
							} else if(paramName.equals("stats.field")) {
								Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
								boolean foundStats = mStats.find();
								if(foundStats) {
									String solrLocalParams = mStats.group(1);
									entityVar = mStats.group(2).trim();
									varIndexed = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
									searchList.statsField((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									statsField = entityVar;
									statsFieldIndexed = varIndexed;
								}
							} else if(paramName.equals("facet")) {
								searchList.facet((Boolean)paramObject);
							} else if(paramName.equals("facet.range.start")) {
								String startMathStr = (String)paramObject;
								Date start = SearchTool.parseMath(startMathStr);
								searchList.facetRangeStart(start.toInstant().toString());
								facetRangeStart = start;
							} else if(paramName.equals("facet.range.end")) {
								String endMathStr = (String)paramObject;
								Date end = SearchTool.parseMath(endMathStr);
								searchList.facetRangeEnd(end.toInstant().toString());
								facetRangeEnd = end;
							} else if(paramName.equals("facet.range.gap")) {
								String gap = (String)paramObject;
								searchList.facetRangeGap(gap);
								facetRangeGap = gap;
							} else if(paramName.equals("facet.range")) {
								Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
								boolean foundFacetRange = mFacetRange.find();
								if(foundFacetRange) {
									String solrLocalParams = mFacetRange.group(1);
									entityVar = mFacetRange.group(2).trim();
									varIndexed = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
									searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									facetRange = entityVar;
								}
							} else if(paramName.equals("facet.field")) {
								entityVar = (String)paramObject;
								varIndexed = TrafficFlowObserved.varIndexedTrafficFlowObserved(entityVar);
								if(varIndexed != null)
									searchList.facetField(varIndexed);
							} else if(paramName.equals("var")) {
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								searchTrafficFlowObservedVar(searchList, entityVar, valueIndexed);
							} else if(paramName.equals("cursorMark")) {
								valueCursorMark = (String)paramObject;
								searchList.cursorMark((String)paramObject);
							}
						}
						searchTrafficFlowObservedUri(searchList);
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			}
			if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.sort("created_docvalues_date", "desc");
			}
			String facetRange2 = facetRange;
			Date facetRangeStart2 = facetRangeStart;
			Date facetRangeEnd2 = facetRangeEnd;
			String facetRangeGap2 = facetRangeGap;
			String statsField2 = statsField;
			String statsFieldIndexed2 = statsFieldIndexed;
			searchTrafficFlowObserved2(siteRequest, populate, store, modify, searchList);
			searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
				if(facetRange2 != null && statsField2 != null && facetRange2.equals(statsField2)) {
					StatsField stats = searchList.getResponse().getStats().getStatsFields().get(statsFieldIndexed2);
					Instant min = Optional.ofNullable(stats.getMin()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
					Instant max = Optional.ofNullable(stats.getMax()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
					if(min.equals(max)) {
						min = min.minus(1, ChronoUnit.DAYS);
						max = max.plus(2, ChronoUnit.DAYS);
					}
					Duration duration = Duration.between(min, max);
					String gap = "DAY";
					if(duration.toDays() >= 365)
						gap = "YEAR";
					else if(duration.toDays() >= 28)
						gap = "MONTH";
					else if(duration.toDays() >= 1)
						gap = "DAY";
					else if(duration.toHours() >= 1)
						gap = "HOUR";
					else if(duration.toMinutes() >= 1)
						gap = "MINUTE";
					else if(duration.toMillis() >= 1000)
						gap = "SECOND";
					else if(duration.toMillis() >= 1)
						gap = "MILLI";

					if(facetRangeStart2 == null)
						searchList.facetRangeStart(min.toString());
					if(facetRangeEnd2 == null)
						searchList.facetRangeEnd(max.toString());
					if(facetRangeGap2 == null)
						searchList.facetRangeGap(String.format("+1%s", gap));
					searchList.query().onSuccess(b -> {
						promise.complete(searchList);
					}).onFailure(ex -> {
						LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete(searchList);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("searchTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void searchTrafficFlowObserved2(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<TrafficFlowObserved> searchList) {
	}

	public Future<Void> persistTrafficFlowObserved(TrafficFlowObserved o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT * FROM TrafficFlowObserved WHERE pk=$1")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk)
					).onSuccess(result -> {
				try {
					for(Row definition : result.value()) {
						for(Integer i = 0; i < definition.size(); i++) {
							String columnName = definition.getColumnName(i);
							Object columnValue = definition.getValue(i);
							if(!"pk".equals(columnName)) {
								try {
									o.persistForClass(columnName, columnValue);
								} catch(Exception e) {
									LOG.error(String.format("persistTrafficFlowObserved failed. "), e);
								}
							}
						}
					}
					promise.complete();
				} catch(Exception ex) {
					LOG.error(String.format("persistTrafficFlowObserved failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error(String.format("persistTrafficFlowObserved failed. "), ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("persistTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> relateTrafficFlowObserved(TrafficFlowObserved o) {
		Promise<Void> promise = Promise.promise();
			promise.complete();
		return promise.future();
	}

	public Future<TrafficFlowObserved> indexTrafficFlowObserved(TrafficFlowObserved o) {
		Promise<TrafficFlowObserved> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			o.promiseDeepForClass(siteRequest).onSuccess(a -> {
				JsonObject json = new JsonObject();
				JsonObject add = new JsonObject();
				json.put("add", add);
				JsonObject doc = new JsonObject();
				add.put("doc", doc);
				o.indexTrafficFlowObserved(doc);
				String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest.getConfig().getInteger(ConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				Boolean solrSsl = siteRequest.getConfig().getBoolean(ConfigKeys.SOLR_SSL);
				Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
				Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					else if(softCommit == null)
						softCommit = false;
				String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
				webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).putHeader("Content-Type", "application/json").expect(ResponsePredicate.SC_OK).sendBuffer(json.toBuffer()).onSuccess(b -> {
					promise.complete(o);
				}).onFailure(ex -> {
					LOG.error(String.format("indexTrafficFlowObserved failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("indexTrafficFlowObserved failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("indexTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public String searchVar(String varIndexed) {
		return TrafficFlowObserved.searchVarTrafficFlowObserved(varIndexed);
	}

	@Override
	public String getClassApiAddress() {
		return TrafficFlowObserved.CLASS_API_ADDRESS_TrafficFlowObserved;
	}

	public Future<Void> refreshTrafficFlowObserved(TrafficFlowObserved o) {
		Promise<Void> promise = Promise.promise();
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);
				}

				CompositeFuture.all(futures).onSuccess(b -> {
					JsonObject params = new JsonObject();
					params.put("body", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
					params.put("form", new JsonObject());
					params.put("path", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit != null)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk())).put("var", new JsonArray().add("refresh:false"));
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request(TrafficFlowObserved.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchTrafficFlowObservedFuture")).onSuccess(c -> {
						JsonObject responseMessage = (JsonObject)c.body();
						Integer statusCode = responseMessage.getInteger("statusCode");
						if(statusCode.equals(200))
							promise.complete();
						else
							promise.fail(new RuntimeException(responseMessage.getString("statusMessage")));
					}).onFailure(ex -> {
						LOG.error("Refresh relations failed. ", ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error("Refresh relations failed. ", ex);
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(String.format("refreshTrafficFlowObserved failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
