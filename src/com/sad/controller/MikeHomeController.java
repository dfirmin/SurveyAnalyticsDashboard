package com.sad.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.SentenceAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

@Controller
public class MikeHomeController {
	
	@RequestMapping("/v")
	public String visualize() {
		return "visual";
	}
	
	@RequestMapping("/nl")
	public ModelAndView naturalLanguage(Model model) {
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
				  NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
				  "16e04451-f41c-4ff2-9d71-2b82a2885591",
				  "gE4g5KcU6B0h"
				);
		
		String text =
				"I know the times are difficult! Our sales have been "
					      + "disappointing for the past three quarters for our data analytics "
					      + "product suite. We have a competitive data analytics product "
					      + "suite in the industry. But we need to do our job selling it! "
					      + "We need to acknowledge and fix our sales challenges. "
					      + "We can’t blame the economy for our lack of execution! "
					      + "We are missing critical sales opportunities. "
					      + "Our product is in no way inferior to the competitor products. "
					      + "Our clients are hungry for analytical tools to improve their "
					      + "business outcomes. Economy has nothing to do with it.";

		// WORKING WITH KEYWORDS //
		KeywordsOptions keywords= new KeywordsOptions.Builder()
				  .build();
		Features features = new Features.Builder()
				  .keywords(keywords)
				  .build();
		AnalyzeOptions parameters = new AnalyzeOptions.Builder().html(text).features(features).build();
		AnalysisResults results = service.analyze(parameters).execute();
		System.out.println("KEYWORDS");
		System.out.println(results);
		
		
		
		// WORKING WITH EMOTIONS //
		
		EmotionOptions emotion= new EmotionOptions.Builder()
				  .build();
		Features features2 = new Features.Builder()
				  .emotion(emotion)
				  .build();
		AnalyzeOptions parameters2 = new AnalyzeOptions
				.Builder()
				.html(text)
				.features(features2)
				.build();
		AnalysisResults results2 = service.analyze(parameters2).execute();
		System.out.println("EMOTIONS");
		System.out.println(results2);
		
		String overall_results = results.toString() + results2.toString();
		return new ModelAndView("ToneAnalyzer", "ta_result", overall_results);
	}
	
	/*
	@RequestMapping("/ta")
	public ModelAndView toneanalyzer(Model model) {
		ToneAnalyzer service = new ToneAnalyzer("2016-05-19");
		service.setUsernameAndPassword("8106386a-69c1-44a7-96ae-41a111039f21", "kM0OpgpSsKME");
		String text =
				"I know the times are difficult! Our sales have been "
					      + "disappointing for the past three quarters for our data analytics "
					      + "product suite. We have a competitive data analytics product "
					      + "suite in the industry. But we need to do our job selling it! "
					      + "We need to acknowledge and fix our sales challenges. "
					      + "We can’t blame the economy for our lack of execution! "
					      + "We are missing critical sales opportunities. "
					      + "Our product is in no way inferior to the competitor products. "
					      + "Our clients are hungry for analytical tools to improve their "
					      + "business outcomes. Economy has nothing to do with it.";
		
		ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
		ToneAnalysis tone = service.tone(toneOptions).execute();
		System.out.println(tone);
		return new ModelAndView("ToneAnalyzer", "ta_result", tone.toString());
	}
	*/
}