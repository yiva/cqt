package org.yiva.cqt.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yiva.cqt.core.IAccountService;
import org.yiva.cqt.model.Account;

@Controller
@RequestMapping(value = { "/" })
public class IndexAction {

	
	
	@Autowired
	@Qualifier("accountService")
	private IAccountService accountService;
	

	
	@RequestMapping(value = { "/", "showAccounts" })
	public ModelAndView showAllAccounts() {
		ModelAndView mv = new ModelAndView("account/all_accounts");
		ArrayList<Account> accountlist = new ArrayList<Account>();
		accountlist = accountService.findAllAccount();
		if (null == accountlist) {
			mv.addObject("accountlist", null);
		}
		mv.addObject("accountlist", accountlist);
		return mv;
	}


}
