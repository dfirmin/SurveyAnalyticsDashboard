package com.sad.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sad.MikesStuff.HowConfident;
import com.sad.MikesStuff.HowConfidentDaoImpl;
import com.sad.MikesStuff.Jobs_Applied;
import com.sad.MikesStuff.Jobs_AppliedDaoImpl;
import com.sad.MikesStuff.ProgramManagement;
import com.sad.MikesStuff.ProgramManagementDaoImpl;
import com.sad.MikesStuff.SummaryResult;
import com.sad.MikesStuff.SummaryResultDaoImpl;

@Controller
public class MikeHomeController {
	
	@RequestMapping("/w")
	public String tryout() {
		
		return "index";
	}
	@RequestMapping("/v")
	public String visualizeFeeling(Model model) {
		
		confidenceChart(model);
		jobs_applied(model);
		howConfident(model);
		instructor(model);
		moreConf(model);
		//materialPace(model);
		//helfulness(model);
		//conduciveLearning(model);
		
		
		//OPTION 1
		
		return "visual";
	}
	
	public static void moreConf(Model model) {
		
	}
	
	public static void instructor(Model model) {
		ArrayList<ProgramManagement> resultList = new ProgramManagementDaoImpl().getAllPM();
		
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
		
		ArrayList<HowConfident> resultList = new HowConfidentDaoImpl().getAllConf();
		
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
		
		ArrayList<Jobs_Applied> resultList = new Jobs_AppliedDaoImpl().getJobsApplied();
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
			
			ArrayList<SummaryResult> resultList = new SummaryResultDaoImpl().getSummaryResults();

			String js_statement = "[['Confidence','Great! Excited for the rest of bootcamp.', 'A little confused, but confident I will get it soon!', 'Totally Confused', 'Other'],";
			
			//Loop through ones for Java
			int java_great = 0;
			int net_great = 0;
			int front_great = 0;
			
			int java_little = 0;
			int net_little = 0;
			int front_little = 0;
			
			int java_total = 0;
			int net_total = 0;
			int front_total = 0;
			
			int java_other = 0;
			int net_other = 0;
			int front_other = 0;
			
			for (int j=0; j<resultList.size(); j++) {
				if ((resultList.get(j).getUserResponse().contains("Great!")) && (resultList.get(j).getCohortID() == 1)) {
					java_great = resultList.get(j).getCounter();
					System.out.println(java_great);
				}
				else if ((resultList.get(j).getUserResponse().contains("little")) && (resultList.get(j).getCohortID() == 1)) {
					java_little = resultList.get(j).getCounter();
					System.out.println(java_little);
				}
				else if ((resultList.get(j).getUserResponse().contains("Totally")) && (resultList.get(j).getCohortID() == 1)) {
					java_total = resultList.get(j).getCounter();	
					System.out.println(java_total);
				}
				else if ((resultList.get(j).getUserResponse().contains("Other")) && (resultList.get(j).getCohortID() == 1)) {
					java_other = resultList.get(j).getCounter();
					System.out.println(java_other);
				}
				else if ((resultList.get(j).getUserResponse().contains("Great!")) && (resultList.get(j).getCohortID() == 2)) {
					net_great = resultList.get(j).getCounter();
					System.out.println(net_great);
				}
				else if ((resultList.get(j).getUserResponse().contains("little")) && (resultList.get(j).getCohortID() == 2)) {
					net_little = resultList.get(j).getCounter();
					System.out.println(net_little);
				}
				else if ((resultList.get(j).getUserResponse().contains("Totally")) && (resultList.get(j).getCohortID() == 2)) {
					net_total = resultList.get(j).getCounter();
					System.out.println(net_total);
				}
				else if ((resultList.get(j).getUserResponse().contains("Other")) && (resultList.get(j).getCohortID() == 2)) {
					net_other = resultList.get(j).getCounter();
					System.out.println(net_other);
				}
				else if ((resultList.get(j).getUserResponse().contains("Great!")) && (resultList.get(j).getCohortID() == 3)) {
					front_great = resultList.get(j).getCounter();
					System.out.println(front_great);
				}
				else if ((resultList.get(j).getUserResponse().contains("little")) && (resultList.get(j).getCohortID() == 3)) {
					front_little = resultList.get(j).getCounter();
					System.out.println(front_little);
				}
				else if ((resultList.get(j).getUserResponse().contains("Totally")) && (resultList.get(j).getCohortID() == 3)) {
					front_total = resultList.get(j).getCounter();
					System.out.println(front_total);
				}
				else if ((resultList.get(j).getUserResponse().contains("Other")) && (resultList.get(j).getCohortID() == 3)) {
					front_other = resultList.get(j).getCounter();
					System.out.println(front_other);
				}
			}
			
			js_statement += "[ 'Java'," + java_great + "," + java_little + ","+ java_total + "," + java_other + "],";
			js_statement += "[ '.NET'," + net_great + "," + net_little + ","+ net_total + "," + net_other +  "],";
			js_statement += "[ 'Front End'," + front_great + "," + front_little + ","+ front_total + "," + front_other +  "]]";
			
			System.out.println(js_statement);
			
			model.addAttribute("getConf", js_statement);
			
		}
}