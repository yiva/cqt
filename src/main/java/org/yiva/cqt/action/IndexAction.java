package org.yiva.cqt.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.yiva.cqt.core.IExcel;

@Controller
@RequestMapping(value = { "/" })
public class IndexAction {

	@Autowired
	@Qualifier("excelService")
	private IExcel excelService;

	@RequestMapping(value = { "/", "accountImport" })
	public ModelAndView importPage() {
		ModelAndView mv = new ModelAndView("import");
		return mv;
	}

	/**
	 * 导入Excel Ajax
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = { "/imptExcelTest" }, method = RequestMethod.POST, headers = { "Accept=application/json" })
	public @ResponseBody String imptExcelAcc(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		//台账类别
		String account_category = req.getParameter("account_category");
		//获取上传文件
		InputStream in = null;
		MultipartFile file = multipartRequest.getFile("file");
		in = file.getInputStream();
		
		int res = excelService.importExcelAccount(in, file.getOriginalFilename(),
				account_category);
		return res + "";
	}

}
