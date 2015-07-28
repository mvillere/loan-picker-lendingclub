package com.villtron.loanpicker.apiclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.villtron.loanpicker.beans.Portfolio;
import com.villtron.loanpicker.beans.PortfolioList;
import com.ypei.loanpicker.Cfg;

/**
 * load portfolios
 * 
 * @author mvillere
 * 
 */
public class PortfolioLoader {

	public static final HttpTransport HTTP_TRANSPORT = new ApacheHttpTransport();
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static Logger logger = Logger.getLogger(PortfolioLoader.class);

	public static List<Portfolio> loadPortfolios() {

		List<Portfolio> portfoliosLoaded = new ArrayList<Portfolio>();

		try {

			HttpRequestFactory requestFactory = HTTP_TRANSPORT
					.createRequestFactory(new HttpRequestInitializer() {
						public void initialize(HttpRequest request) {
							request.setParser(new JsonObjectParser(JSON_FACTORY));

							HttpHeaders hh = new HttpHeaders();
							// must has name!
							hh.setAuthorization(Cfg.m
									.get(Cfg.T.AUTHORIZATION_TOKEN.name()));
							hh.setContentType(Cfg.CONTENT_TYPE);
							request.setHeaders(hh);
						}
					});
			GenericUrl url = new GenericUrl(Cfg.LC_URL_ACCOUNT_PREFIX
					+ Cfg.m.get(Cfg.T.INVESTOR_ID.name()) + "/portfolios");
			logger.info("-----------------------------------------------");
			logger.info("REQEST_LC_PORTFOLIOS....");
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			
			//logger.info("Content: " + response.parseAsString());
			PortfolioList pl = response.parseAs(PortfolioList.class);
			if (pl.myPortfolios == null || pl.myPortfolios.isEmpty()) {
				System.out.println("No portfolios found for you.");
			} else {
				logger.info("-----------------------------------------------");
				logger.info("PORTFOLIOS_FOUND: " + pl.myPortfolios.size());
				for (Portfolio p : pl.myPortfolios) {
					logger.info("");
					logger.info("-----------------------------------------------");
					logger.info(p.toString());
					portfoliosLoaded.add(p);
				}
			}
		} catch (HttpResponseException e) {

			logger.error(
					"If 401 Unauthorized: check application.conf: if input the correct token.",
					e);

		} catch (Throwable e) {

			logger.error("fail", e);

		}
		return portfoliosLoaded;
	}// end func
}// end class
