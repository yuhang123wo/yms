package cn.yh.st.blog.agent.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("bComment", blogApiService.getBCommentByArticleId(bArticle.getId()));
		model.addAttribute("articles", blogApiService.loadBArticlePageByParams(hashMap, 1, 10)
				.getList());
		model.addAttribute("news", blogApiService.getBGoodByLast());
		hashMap.put("keyValue", bArticle.getKeyValue());
		hashMap.put("idNot", bArticle.getId());
		model.addAttribute("relationArticle", blogApiService
				.loadBArticlePageByParams(hashMap, 1, 5).getList());
		return "article";
	}
}
