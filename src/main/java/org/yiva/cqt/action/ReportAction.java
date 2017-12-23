package org.yiva.cqt.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.yiva.cqt.core.IArticleService;
import org.yiva.cqt.core.IJounalService;
import org.yiva.cqt.model.Article;
import org.yiva.cqt.model.Jounal;

/**
 * 报表查询
 * @author yeahwang
 *
 */
@Controller
@RequestMapping(value = { "/report" })
public class ReportAction {
	
	@Autowired
	@Qualifier("articleService")
	private IArticleService articleService;
	
	@Autowired
	@Qualifier("jounalService")
	private IJounalService jounalService;
	
	

	/**
	 * 查询学习用品转发情况
	 * @return
	 */
	@RequestMapping(value = { "showArticles" })
	public ModelAndView showAllAccounts() {
		ModelAndView mv = new ModelAndView("report/articles");
		ArrayList<Article> articlelist = new ArrayList<Article>();
		articlelist = articleService.findAllArticles();
		if (null == articlelist) {
			mv.addObject("articlelist", null);
		}
		mv.addObject("articlelist", articlelist);
		return mv;
	}
	
	/**
	 * 查询流水账
	 * @return
	 */
	@RequestMapping(value = { "showJounals" })
	public ModelAndView showAllJounals() {
		ModelAndView mv = new ModelAndView("report/jounals");
		ArrayList<Jounal> list = new ArrayList<Jounal>();
		list = jounalService.findAllJounals();
		if (null == list) {
			mv.addObject("jounalist", null);
		}
		mv.addObject("jounalist", list);
		return mv;
	}
	
	/**
	 * 查询流水账
	 * @return
	 */
	@RequestMapping(value = { "showJounalsTmp" })
	public ModelAndView showJounalsTmp() {
		ModelAndView mv = new ModelAndView("report/jounals_tmp");
		ArrayList<Jounal> list = new ArrayList<Jounal>();
		list = jounalService.findAllJounalsTmp();
		if (null == list) {
			mv.addObject("jounalist", null);
		}
		mv.addObject("jounalist", list);
		return mv;
	}
	
	@RequestMapping(value = { "submitJounalStatus" }, method = RequestMethod.POST, headers = { "Accept=application/json" })
	public @ResponseBody String submitJounalStatus(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
		int res = 0;
			res = jounalService.setTmpIntoJounal();
		return res + "";
	}
}
