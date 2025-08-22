package com.panda.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panda.mall.commons.PageUtils;
import com.panda.mall.commons.R;
import com.panda.mall.product.entity.CategoryEntity;
import com.panda.mall.product.service.CategoryService;

/**
 * 商品三级分类
 *
 * @author panda
 * @email thenextlei@gmail.com
 * @date 2025-08-17 21:03:42
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
//    @RequiresPermissions("product:category:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = categoryService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 树状列表
	 */
	@RequestMapping("/treelist")
//    @RequiresPermissions("product:category:list")
	public R treeList() {
		List<CategoryEntity> list = categoryService.queryPageTree();
		return R.ok().put("list", list);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{catId}")
//    @RequiresPermissions("product:category:info")
	public R info(@PathVariable("catId") Long catId) {
		CategoryEntity category = categoryService.getById(catId);

		return R.ok().put("category", category);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
//    @RequiresPermissions("product:category:save")
	public R save(@RequestBody CategoryEntity category) {
		categoryService.save(category);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
//    @RequiresPermissions("product:category:update")
	public R update(@RequestBody CategoryEntity category) {
		categoryService.updateById(category);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//    @RequiresPermissions("product:category:delete")
	public R delete(@RequestBody Long[] catIds) {
//		categoryService.removeByIds(Arrays.asList(catIds));
		categoryService.removeCateogryByIds(Arrays.asList(catIds));
		return R.ok();
	}

}
