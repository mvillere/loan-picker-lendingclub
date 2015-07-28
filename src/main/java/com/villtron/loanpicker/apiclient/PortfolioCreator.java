package com.villtron.loanpicker.apiclient;

import org.apache.log4j.Logger;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.villtron.loanpicker.beans.Portfolio;
import com.villtron.loanpicker.beans.PortfolioCreation;
import com.ypei.loanpicker.Cfg;

/**
 * @author mvillere
 *
 */
public class PortfolioCreator {
	public static final HttpTransport HTTP_TRANSPORT = new ApacheHttpTransport();
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static Logger logger = Logger.getLogger(PortfolioCreator.class);

	public static Portfolio createPortfolio(PortfolioCreation portfolioToCreate) {
		Portfolio portfolioCreated = null;
		try {

			/**
			 * Pre validate: avoid invest into duplicate loans
			 */
			
			Integer investorId = new Integer(Cfg.m.get(Cfg.T.INVESTOR_ID.name()));
			portfolioToCreate.aid = investorId;
			
			HttpRequestFactory requestFactory = HTTP_TRANSPORT
					.createRequestFactory(new HttpRequestInitializer() {
						public void initialize(HttpRequest request) {
							request.setParser(new JsonObjectParser(JSON_FACTORY));
							
							HttpHeaders hh = new HttpHeaders();
							// must has name!
							hh.setAuthorization(Cfg.m.get(Cfg.T.AUTHORIZATION_TOKEN.name()));
							hh.setContentType(Cfg.CONTENT_TYPE);
							request.setHeaders(hh);
							
						}
					});
			GenericUrl url = new GenericUrl(Cfg.LC_URL_ACCOUNT_PREFIX
					+ investorId + "/portfolios");
			logger.info("-----------------------------------------------");
			logger.info("SUBMIT_LC_PORTFOLIO_CREATE....");
			JsonHttpContent content = new JsonHttpContent(new JacksonFactory(), portfolioToCreate);
			HttpRequest request = requestFactory.buildPostRequest(url, content);
			
			Portfolio p = request.execute().parseAs(Portfolio.class);
			if (p == null) {
				System.out.println("No portfolio created.");
			} else {
				logger.info("");
				logger.info("-----------------------------------------------");
				logger.info(p.toString());
				portfolioCreated = p;
			}
		} catch (HttpResponseException e) {
			logger.error("If 401 Unauthorized: check application.conf: if input the correct token.", e);
		} catch (Throwable e) {
			logger.error("fail", e);
		}
		
		return portfolioCreated;
	}// end func
}
