package com.stream.tmall.controller;

import com.stream.tmall.pojo.Category;
import com.stream.tmall.service.CategoryService;
import com.stream.tmall.util.ImageUtil;
import com.stream.tmall.util.Page;
import com.stream.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        List<Category> cs= categoryService.list(page);
        int total =categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page",page);
        return "admin/listCategory";
    }

    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.add(c);
        File imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_delete")
    public String delete (int id,HttpSession session) {
        categoryService.delete(id);

        File imageFolder =new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return "redirect:/admin_category_list";
    }


}
