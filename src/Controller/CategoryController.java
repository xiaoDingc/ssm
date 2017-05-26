package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Category;
import service.CategoryService;
import util.Page;
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page) {

		ModelAndView mav = new ModelAndView();
//		List<Category> cs=categoryService.list();
		List<Category> cs=categoryService.list(page);
		int total=categoryService.total();
		page.caculateLast(total);
		
		// ����ת������
		mav.addObject("cs", cs);
		// ����jsp·��
		mav.setViewName("listCategory");

		return mav;
	}

}