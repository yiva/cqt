package org.yiva.cqt.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yiva.cqt.core.IArticleService;
import org.yiva.cqt.model.Article;

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
}
