package com.sad.MikesStuff;

import java.util.ArrayList;

public interface DAO {
	ArrayList<HowConfident> getAllConf();
	ArrayList<HowConfident> getAllMatPace();
	ArrayList<Jobs_Applied> getJobsApplied();
	ArrayList<ProgramManagement> getAllPM();
	ArrayList<QOptions> getAllOptions();
	ArrayList<Results> getAllResults();
	ArrayList<SummaryResult> getSummaryResults();
	ArrayList<WhatConf> getHowConf();
	ArrayList<WhatConf> getTT();
	ArrayList<Effective> getEE();
}
