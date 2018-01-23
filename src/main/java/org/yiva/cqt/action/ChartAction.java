package org.yiva.cqt.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yiva.cqt.core.IChartService;

@Controller
@RequestMapping(value = { "/chart" })
public class ChartAction {

	@Autowired
	@Qualifier("chartService")
	private IChartService chartService;
	
	@RequestMapping(value = { "/jounalCategory" }, method = RequestMethod.GET, headers = { "Accept=application/json;charset=UTF-8" })
	public @ResponseBody String chartJounalCategory(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		String res = "0";
		res = chartService.showJounalCategoryCounts();
		
		return res;
	}
	
	@RequestMapping(value = { "/jounalMonth" }, method = RequestMethod.GET, headers = { "Accept=application/json;charset=UTF-8" })
	public @ResponseBody String chartJounalMonth(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		String res = "0";
		res = chartService.showJouanlMonthPrice();
		return res;
	}
	
	@RequestMapping(value = { "/jounalBalance" }, method = RequestMethod.GET, headers = { "Accept=application/json;charset=UTF-8" })
	public @ResponseBody String chartJounalBalance(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		String res = "0";
		res = chartService.showJouanlBalance("CQT");
		return res;
	}
	
	@RequestMapping(value = { "/jounalCurrentMonth" }, method = RequestMethod.GET, headers = { "Accept=application/json;charset=UTF-8" })
	public @ResponseBody String chartJounalCurrentMonth(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		String res = "0";
		res = chartService.showJouanlCurrentMonthPrice();
		return res;
	}
}
