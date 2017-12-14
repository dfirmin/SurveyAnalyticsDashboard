package com.sad.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sad.MikesStuff.DAOIMPL;
import com.sad.MikesStuff.Effective;
import com.sad.MikesStuff.HowConfident;
import com.sad.MikesStuff.Jobs_Applied;
import com.sad.MikesStuff.ProgramManagement;
import com.sad.MikesStuff.SummaryResult;
import com.sad.MikesStuff.WhatConf;

@Controller
public class MikeHomeController {
	
	@RequestMapping("/w")
	public String tryout() {
		
		return "index";
	}
	@RequestMapping("/v")
	public static String visualizeFeeling(Model model) {
		
		confidenceChart(model);
		jobs_applied(model);
		howConfident(model);
		instructor(model);
		moreConf(model);
		materialPace(model);
		TT(model);
		Effectiveness(model);
		//helfulness(model);
		//conduciveLearning(model);
		
		
		//OPTION 1
		
		return "visual";
	}
	
	public static void Effectiveness(Model model) {
		ArrayList<Effective> resultList = new DAOIMPL().getEE();
		String[] instructor_list = new String[]{"ANTONELLA", "MAURICE", "PETER", "KAMAL", "ADAM", "J-C"};
		int[] week_list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		String js = "[['Week','ANTONELLA', 'MAURICE', 'PETER', 'KAMAL', 'ADAM', 'J-C'],";
		for (int i=0; i<week_list.length; i++) {
			double count = 0;
			double sum = 0;
			js += "['Week " + week_list[i] +"',";
			for (int t=0; t<instructor_list.length; t++) {
				for (int r=0; r<resultList.size(); r++) {
					if (resultList.get(r).getUserresponse().contains(instructor_list[t]) && (resultList.get(r).getWeek()==week_list[i])) {
						sum += Integer.parseInt(resultList.get(r+1).getUserresponse());
						count += 1;
					}
				}
				js += sum/count;
				if (t != instructor_list.length-1) {
					js += ",";
				}
			}
			js += "]";
			if (i != week_list.length-1) {
				js += ",";
			}
		}
		js += "]";
		System.out.println(js);
		model.addAttribute("E_el", js);
	}
	public static void TT(Model model) {
		ArrayList<WhatConf> resultList = new DAOIMPL().getTT();
		
		String js = "[['Key Teaching Techniques','Count'],";
		for (int i=0; i<resultList.size(); i++) {
			js += "['" + resultList.get(i).getWatsonresponse() + "'," + resultList.get(i).getCount() + "]";
			
			if (i != resultList.size()-1) {
				js +=",";
			}
		}
		js+= "]";
		
		System.out.println(js);
		
		model.addAttribute("TT_el", js);
	}
	
	public static void materialPace(Model model) {
		
		ArrayList<HowConfident> resultList = new DAOIMPL().getAllMatPace();
		
		String js_statement = "[['Week', 'Java Avg', '.NET avg', 'Front End avg'],";
		
		for (int i=0; i<resultList.size(); i++) {
			if (resultList.get(i).getCohortid()==1) {
				js_statement += "[" + resultList.get(i).getWeek() + "," + resultList.get(i).getUserresponse() + ",";
			}
			else if (resultList.get(i).getCohortid()==2) {
				js_statement += resultList.get(i).getUserresponse() + ",";
			}
			else if (resultList.get(i).getCohortid()==3) {
				js_statement += resultList.get(i).getUserresponse() + "]";
				if (i != resultList.size() -1) {
					js_statement += ",";
				}
			}
		}
		
		js_statement += "]";
		System.out.println(js_statement);
		model.addAttribute("matPace", js_statement);
	}
	
	public static void moreConf(Model model) {
		ArrayList<WhatConf> resultList = new DAOIMPL().getHowConf();
		
		String js = "[['Students Responses','Count'],";
		for (int i=0; i<resultList.size(); i++) {
			js += "['" + resultList.get(i).getWatsonresponse() + "'," + resultList.get(i).getCount() + "]";
			
			if (i != resultList.size()-1) {
				js +=",";
			}
		}
		js+= "]";
		
		System.out.println(js);
		
		model.addAttribute("WhatConf", js);
	}
	
	public static void instructor(Model model) {
		ArrayList<ProgramManagement> resultList = new DAOIMPL().getAllPM();
		
		String[] emotion_options = new String[]{"JOY", "ANGER", "DISGUST", "SADNESS", "FEAR"};
		String[] instructor_list = new String[]{"ANTONELLA", "MAURICE", "PETER", "KAMAL", "ADAM", "J-C"};
		String js = "[['Emotion', 'Joy', 'Anger', 'Disgust', 'Sadness', 'Fear'],";
		
		for (int i=0; i<instructor_list.length; i++) {
			js += "['" + instructor_list[i] + "',";
			int getQID = 0;
			if(i==0 || i==2 || i==4) {
				getQID = 5;
			}
			else {
				getQID = 9;
			}
			for (int e=0; e<emotion_options.length;e++) {
				int count = 0;
				for (int r=0; r<resultList.size();r++) {
					if (resultList.get(r).getQuestionid()==getQID && resultList.get(r).getUserresponse().contains(instructor_list[i])) {
						if (resultList.get(r+3).getWatsonresponse().contains(emotion_options[e])) {
							count+=1;
						}
					}
				}
				js += count;
				if (e != emotion_options.length-1) {
					js += ",";
				}
			}
			js+="]";
			if (i != instructor_list.length-1) {
				js +=",";
			}
		}
		js += "]";
		
		System.out.println("Found: " + js);
		
		model.addAttribute("Instructor_el", js);
		
	}
	
	public static void howConfident(Model model) {
		
		ArrayList<HowConfident> resultList = new DAOIMPL().getAllConf();
		
		String js_statement = "[['Week', 'Java Avg', '.NET avg', 'Front End avg'],";
		
		for (int i=0; i<resultList.size(); i++) {
			if (resultList.get(i).getCohortid()==1) {
				js_statement += "[" + resultList.get(i).getWeek() + "," + resultList.get(i).getUserresponse() + ",";
			}
			else if (resultList.get(i).getCohortid()==2) {
				js_statement += resultList.get(i).getUserresponse() + ",";
			}
			else if (resultList.get(i).getCohortid()==3) {
				js_statement += resultList.get(i).getUserresponse() + "]";
				if (i != resultList.size() -1) {
					js_statement += ",";
				}
			}
		}
		
		js_statement += "]";
		
		System.out.println(js_statement);
		
		model.addAttribute("getHowConf", js_statement);
	}
	
public static void jobs_applied(Model model) {
		
		ArrayList<Jobs_Applied> resultList = new DAOIMPL().getJobsApplied();
		String js_statement = "[['Number of Jobs Applied', 'Count'],";
		
		for (int j=0; j<resultList.size(); j++) {
			js_statement += "['" + resultList.get(j).getJobs_applied_label() + "', " + resultList.get(j).getCount() + "]";
			if (j != resultList.size()-1) {
				js_statement += ",";
			}
		}
		
		js_statement += "]";
		
		System.out.println(js_statement);
		
		model.addAttribute("getJobsApp", js_statement);
	}
	
	public static void confidenceChart(Model model) {
			
			ArrayList<SummaryResult> resultList = new DAOIMPL().getSummaryResults();

			String js = "[['Week', 'Great', 'Little', 'Totally', 'Other'],";
			
			int weekfound = 0;
			int score = 0;
			for (int r = 0; r<resultList.size(); r++) {
				
				if (resultList.get(r).getWeek() != weekfound) {
					weekfound += 1;
					score = 0;
					js += "['Week " + weekfound + "',";
				}
				
				js += resultList.get(r).getCounter();
				score += 1;
				
				if (score == 4) {
					js += "]";
					score = 0;
					if (r != resultList.size()-1) {
						js += ",";
					}
				}
				else {
					js += ",";
				}
				
			}
			js += "]";
			System.out.println(js);
			
			model.addAttribute("getConf", js);
			
		}
}