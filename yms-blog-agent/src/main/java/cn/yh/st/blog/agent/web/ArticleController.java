package cn.yh.st.blog.agent.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.domain.BArticle;

/**
 * 
 * @author yuhang
 * @Date 2018年7月9日
 * @desc
 */
@Controller
@RequestMapping("article")
public class ArticleController {

	@Resource
	private BlogApiService blogApiService;

	/**
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping("articleDetailIndex/{id}")
	public String articleDetail(Model model, @PathVariable("id") long id) {
		BArticle bArticle = blogApiService.getBArticleById(id);
		if (bArticle == null) {
			return "404";
		}
		Map<String, Object> hashMap = new HashMap<String, Object>();
		model.addAttribute("bArticle", bArticle);
		model.addAttribute("bContent", blogApiService.getBContentById(bArticle.getContentId()));
		model.addAttribute("articles", blogApiService.loadBArticlePageByParams(hashMap, 1, 10)
				.getList());
		model.addAttribute("news", blogApiService.getBGoodByLast());
		hashMap.put("keyValue", bArticle.getKeyValue());
		hashMap.put("idNot", bArticle.getId());
		model.addAttribute("relationArticle", blogApiService
				.loadBArticlePageByParams(hashMap, 1, 5).getList());
		return "article";
	}

	/**
	 * 取评论
	 * 
	 * @param id
	 * @param pageNo
	 * @param pageSize
	 * @return Object
	 */
	@RequestMapping("getArticleComments")
	@ResponseBody
	public Object getArticleComments(HttpServletRequest request, long id) {
		int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);
		int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
		return blogApiService.getPageBCommentByArticleId(id, pageNo, pageSize);
	}
}
