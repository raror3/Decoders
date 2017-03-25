package com.decoders.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.decoders.SummaryPageRepository;
import com.decoders.bean.SummaryPageBean;
import com.decoders.bean.SummaryPageList;

@Controller
public class DataDownloadController {
	private static final Logger log = LoggerFactory.getLogger(DataDownloadController.class);

	@Autowired
	SummaryPageRepository summaryPageRepository;

	@RequestMapping(path = "/download", method = RequestMethod.GET)
	public String welcomeDecoders(@RequestParam(value = "df") String df, @RequestParam(value = "jid") String jid,
			Model model) {
		System.out.println(df);
		try {

			URL website = new URL(df);
			ReadableByteChannel rbc;
			rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("Destination.csv");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			SummaryPageList summaryPageList = new SummaryPageList();
			List<SummaryPageBean> summaryBeanList = new ArrayList<SummaryPageBean>();
			br = new BufferedReader(new FileReader("Destination.csv"));
			int i = 1;
			String journeyIdentifier = null;
			String dateTime=null;
			String dateHour=null;
			String overallDate=null;
			int dateMinute=0;
			String overAllResult="success";
			while ((line = br.readLine()) != null) {
				if (i == 1) {
					i++;
					continue;
				}

				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				SummaryPageBean bean = new SummaryPageBean();

				if (null == journeyIdentifier) {
					String s = data[1];
					String[] stringtime = s.split(":");
					int time = Integer.parseInt(stringtime[1]);
					time = time - (time % 5);
					dateHour=stringtime[0];
					dateMinute=time;
					dateTime = data[0] + "_" + stringtime[0] + ":" + time + ":" + "00";
					journeyIdentifier = jid + dateTime;
					overallDate=data[0];
				}
				bean.setJourneyIdentifier(journeyIdentifier.replaceAll("\"", ""));
				bean.setDate(data[0].replaceAll("\"", ""));
				bean.setTime(data[1].replaceAll("\"", ""));
				bean.setEventName(data[2].replaceAll("\"", ""));
				bean.setuRL(data[3].replaceAll("\"", ""));
				bean.setLoadTimeMs(Long.parseLong(data[4].replaceAll("\"", "")));
				bean.setBasePageResult(data[63]);
				int statusCode=Integer.parseInt(data[63].replaceAll("\"", ""));
				if(statusCode>=400)
				{
					overAllResult="failure";
				}
				else if(statusCode>=500)
				{
					overAllResult="Error";
				}
				bean.setPageTitle(data[75].replaceAll("\"", ""));
				System.out.println("list" + bean);
				summaryBeanList.add(bean);
				i++;
			}
			System.out.println("full json" + summaryBeanList);
			summaryPageList.setJourneyHour(dateHour.replaceAll("\"", ""));
			
			summaryPageList.setJourneyMinute(dateMinute+"");
			
			if(dateMinute==55)
			{
				summaryPageList.setJourneyEndHour((dateHour+1).replaceAll("\"", ""));
				summaryPageList.setJourneyMinute("00");
			}
			else
			{	summaryPageList.setJourneyEndMinute(dateMinute+5+"");
			    summaryPageList.setJourneyEndHour(dateHour.replaceAll("\"", ""));
			}
			summaryPageList.setResults(overAllResult.replaceAll("\"", ""));
			summaryPageList.setJourneyMinute(dateMinute+"");
			summaryPageList.setJourneyId(jid);
			summaryPageList.setJourneyDate(overallDate.replaceAll("\"", ""));
			summaryPageList.setJourneyBeanList(summaryBeanList);
			summaryPageRepository.save(summaryPageList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "welcomeDecoders";
	}

}
