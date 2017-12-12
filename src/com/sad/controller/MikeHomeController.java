package com.sad.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sad.dao.PersonsDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.Cohort;
import com.sad.dto.Offered_Answer;
import com.sad.dto.Persons;
import com.sad.dto.SurveyQADto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/*import com.google.visualization.datasource.base.TypeMismatchException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.render.JsonRenderer;*/
import com.sad.MikesStuff.HowConfident;
import com.sad.MikesStuff.HowConfidentDaoImpl;
import com.sad.MikesStuff.Jobs_Applied;
import com.sad.MikesStuff.Jobs_AppliedDaoImpl;
import com.sad.MikesStuff.QOptions;
import com.sad.MikesStuff.QOptionsDaoImpl;
import com.sad.MikesStuff.Results;
import com.sad.MikesStuff.ResultsDao;
import com.sad.MikesStuff.ResultsDaoImpl;
import com.sad.MikesStuff.SummaryResult;
import com.sad.MikesStuff.SummaryResultDaoImpl;
import com.sad.dao.CohortDaoImpl;
import com.sad.dao.Offered_AnswerDaoImpl;
import org.json.simple.JSONArray;

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
		//OPTION 1
		
		return "visual";
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
		/*
		for (int i = 0; i<resultList.size();i++) {
			System.out.println(resultList.get(i).toString());
		}
		
		String js_statement = "[";
		
		
		for (int r=0; r<resultList.size(); r++) {
			js_statement += "[" + resultList.get(r).getWeek() +"," +
								resultList.get(r).getUserresponse() + "," + 
								resultList.get(r).getCohortid() + "]";
			
			if (r != resultList.size()-1) {
				js_statement += ",";
			}
			else {
				js_statement += "]";
			}
		}
		model.addAttribute("getHowConf", js_statement);
		*/
		
		
		
		
		/*
		var data = new google.visualization.DataTable();
        data.addColumn('number', 'Student ID');
        data.addColumn('number', 'Hours Studied');
        data.addColumn('number', 'Final');

        data.addRows([
          [0, 0, 67, 5],  [1, 1, 88, 5],   [2, 2, 77, 5],
          [3, 3, 93, 5],  [4, 4, 85, 5],   [5, 5, 91, 5],
          [6, 6, 71, 5],  [7, 7, 78, 5],   [8, 8, 93, 5],
          [9, 9, 80, 5],  [10, 10, 82, 5], [11, 0, 75, 5],
          [12, 5, 80, 5], [13, 3, 90, 5],  [14, 1, 72, 5],
          [15, 5, 75, 5], [16, 6, 68, 5],  [17, 7, 98, 5],
          [18, 3, 82, 5], [19, 9, 94, 5],  [20, 2, 79, 5],
          [21, 2, 95, 5], [22, 2, 86, 5],  [23, 3, 67, 5],
          [24, 4, 60, 5], [25, 2, 80, 5],  [26, 6, 92, 5],
          [27, 2, 81, 5], [28, 8, 79, 5],  [29, 9, 83, 5]
        ]);

        var materialOptions = {
          chart: {
            title: 'Students\' Final Grades',
            subtitle: 'based on hours studied'
          },
          width: 800,
          height: 500,
          series: {
            0: {axis: 'hours studied'},
            1: {axis: 'final grade'}
          },
          axes: {
            y: {
              'hours studied': {label: 'Hours Studied'},
              'final grade': {label: 'Final Exam Grade'}
            }
          }
        };
        */
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