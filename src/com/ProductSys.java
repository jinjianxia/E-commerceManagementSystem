package com;

import com.model.*;
import com.service.*;
import com.service.impl.AdminServiceImpl;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.service.impl.ProviderServiceImpl;

import java.util.*;

public class ProductSys {
    private static final Scanner input = new Scanner(System.in);
    private static final ProductService productService = new ProductServiceImpl();
    private static final CategoryService categoryService = new CategoryServiceImpl();
    private static final ProviderService providerService = new ProviderServiceImpl();
    private static final AdminService adinService = new AdminServiceImpl();
    private static List<Product> products = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("欢迎访问商品管理系统");
        // todo 暂时关闭登录系统
        boolean flagLogin = false;
        while (flagLogin) {
            System.out.println("1.登录 2.注册 3.退出");
            System.out.print("请选择菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                case 1: {
                    System.out.print("请输入账号：");
                    String adminName = input.next();
                    System.out.print("请输入密码：");
                    String adminPassword = input.next();
                    boolean result = adinService.login(new Admin(adminName, adminPassword));
                    if (result) {
                        System.out.println("经过登录验证通过了…");
                        flagLogin = false;
                    } else {
                        System.out.println("登录失败，用户名或密码错误");
                    }
                    break;
                }
                case 2: {
                    System.out.print("请输入新账号：");
                    String adminName = input.next();
                    System.out.print("请输入新密码：");
                    String adminPassword = input.next();
                    boolean notDuplicateName = adinService.checkDuplicateName(new Admin(adminName));
                    if (notDuplicateName) {
                        int result = adinService.register(new Admin(adminName, adminPassword));
                        if (result != 0)
                            System.out.println("注册成功");
                    } else {
                        System.out.println("用户名已被注册");
                    }
                    break;
                }
                case 3:
                    System.out.println("系统已退出，谢谢使用！");
                    return;
//                    break;
                default:
                    System.out.println("菜单编号不存在");
                    break;
            }
        }
        boolean flag = true;
        while (flag) {
            System.out.println("1.商品管理 2.分类管理 3.供应商管理 4.退出");
            System.out.print("请选择菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    productMenu();
                    break;
                case 2:
                    categoryMenu();
                    break;
                case 3:
                    System.out.println("供应商管理");
                    break;
                case 4:
                    flag = false;
                    System.out.println("退出");
                    return;
//                    break;
                default:
                    System.out.println("菜单编号不存在");
                    break;
            }
        }
        System.out.println("谢谢使用");
    }

    private static void productMenu() {
        boolean productFlag = true;
        while (productFlag) {
            System.out.println("1.列表查询 2.新增 3.修改 4.删除 5.回到一级菜单");
            System.out.print("请选择商品管理菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                // 1.列表查询
                case 1: {
                    showProductList();
                    break;
                }
                // 2.增加
                case 2: {
                    System.out.print("请输入商品：");
                    String productName = input.next();
                    System.out.print("请输入数量：");
                    int quantity = input.nextInt();
                    System.out.print("请输入采购价：");
                    double purchasePrice = input.nextDouble();
                    System.out.print("请输入销售价：");
                    double salesPrice = input.nextDouble();
                    List<Category> categories = categoryService.list();
                    for (Category category : categories) {
                        System.out.printf("%d.%s ",
                                category.getCategoryId(),
                                category.getCategoryName());
                    }
                    System.out.print("请输入分类的编号：");
                    int categoryId = input.nextInt();
                    List<Provider> providers = providerService.list();
                    for (Provider provider : providers) {
                        System.out.printf("%d.%s ",
                                provider.getProviderId(),
                                provider.getProviderName());
                    }
                    System.out.print("请输入供应商编号：");
                    int providerId = input.nextInt();
                    int res = productService.addProduct(new Product(productName,
                            categoryId,
                            providerId,
                            purchasePrice,
                            salesPrice,
                            quantity));
                    if (res != 0)
                        System.out.println("添加商品成功。");
                    break;
                }
                // 3.修改
                case 3: {
                    products = productService.list();
                    for (Product product : products) {
                        System.out.printf("%d.%s ", product.getProductId(), product.getProductName());
                    }
                    System.out.print("请输入修改的商品的编号：");
                    int productId = input.nextInt();
                    Product oldProduct = new Product();
                    boolean flag = false;
                    for (Product product : products) {
                        if (product.getProductId() == productId) {
                            flag = true;
                            oldProduct = product;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("商品编号不存在");
                    } else {
                        System.out.printf("商品名称：%s 数量：%d 采购价：%.2f 销售价：%.2f\n",
                                oldProduct.getProductName(),
                                oldProduct.getQuantity(),
                                oldProduct.getPurchasePrice(),
                                oldProduct.getSalesPrice());
                        System.out.print("请输入商品：");
                        String productName = input.next();
                        System.out.print("请输入数量：");
                        int quantity = input.nextInt();
                        System.out.print("请输入采购价：");
                        double purchasePrice = input.nextDouble();
                        System.out.print("请输入销售价：");
                        double salesPrice = input.nextDouble();
                        List<Category> categories = categoryService.list();
                        for (Category category : categories) {
                            System.out.printf("%d.%s ",
                                    category.getCategoryId(),
                                    category.getCategoryName());
                        }
                        System.out.print("请输入分类的编号：");
                        int categoryId = input.nextInt();
                        List<Provider> providers = providerService.list();
                        for (Provider provider : providers) {
                            System.out.printf("%d.%s ",
                                    provider.getProviderId(),
                                    provider.getProviderName());
                        }
                        System.out.print("请输入供应商编号：");
                        int providerId = input.nextInt();
                        Product newProduct = new Product(productName,
                                categoryId,
                                providerId,
                                purchasePrice,
                                salesPrice,
                                quantity);
                        newProduct.setProductId(oldProduct.getProductId());
                        int result = productService.updateProduct(newProduct);
                        if (result > 0) {
                            System.out.println("商品修改完成。");
                        }
                    }
                    break;
                }
                // 4.删除
                case 4: {
                    products = productService.list();
                    for (Product product : products) {
                        System.out.printf("%d.%s ", product.getProductId(), product.getProductName());
                    }
                    System.out.print("请输入商品编号：");
                    int productId = input.nextInt();
                    boolean flag = false;
                    for (Product product : products) {
                        if (product.getProductId() == productId) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("商品编号不存在");
                    } else {
                        System.out.println("是否删除 y/n");
                        String confirm = input.next();
                        if ("y".equals(confirm) || "Y".equals(confirm)) {
                            int result = productService.delete(new Product().setProductId(productId));
                            System.out.println(result == 1 ? "已删除" : "未删除");
//                            products = productService.list();
                        }
                    }
                    break;
                }
                case 5: {
                    productFlag = false;
                    System.out.println("回到一级菜单");
                    break;
                }
                default:
                    System.out.println("菜单编号不存在");
                    break;
            }
        }
    }

    private static void categoryMenu() {
        boolean categoryFlag = true;
        while (categoryFlag) {
            System.out.println("1.列表查询 2.新增 3.修改 4.删除 5.回到一级菜单");
            System.out.print("请选择分类管理菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                // 1.列表查询
                case 1: {
                    showCategoryList();
                    break;
                }
                // 2.增加
                case 2: {
                    System.out.print("请输入分类名：");
                    String categoryName = input.next();
                    System.out.print("请输入分类描述：");
                    String categoryDesc = input.next();
                    int res = categoryService.addCategory(new Category(categoryName, categoryDesc));
                    if (res != 0)
                        System.out.println("添加分类成功。");
                    break;
                }
                // 3.修改
                case 3: {
                    categories = categoryService.list();
                    for (Category category : categories) {
                        System.out.printf("%d.%s ", category.getCategoryId(), category.getCategoryName());
                    }
                    System.out.print("请输入修改的分类的编号：");
                    int categoryId = input.nextInt();
                    Category oldCategory = new Category();
                    boolean flag = false;
                    for (Category category : categories) {
                        if (category.getCategoryId() == categoryId) {
                            flag = true;
                            oldCategory = category;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("分类编号不存在");
                    } else {
                        System.out.printf("分类名称：%s 分类描述：%s\n",
                                oldCategory.getCategoryName(),
                                oldCategory.getCategoryDesc());
                        System.out.print("请输入分类：");
                        String categoryName = input.next();
                        System.out.print("请输入分类描述：");
                        String categoryDesc = input.next();
                        Category newCategory = new Category(categoryName,
                                categoryDesc);
                        newCategory.setCategoryId(oldCategory.getCategoryId());
                        int result = categoryService.updateCategory(newCategory);
                        if (result > 0) {
                            System.out.println("分类修改完成完成。");
                        }
                    }
                    break;
                }
                // 4.删除
                case 4: {
                    categories = categoryService.list();
                    for (Category category : categories) {
                        System.out.printf("%d.%s ", category.getCategoryId(), category.getCategoryName());
                    }
                    System.out.print("请输入分类编号：");
                    int categoryId = input.nextInt();
                    boolean flag = false;
                    for (Category category : categories) {
                        if (category.getCategoryId() == categoryId) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("分类编号不存在");
                    } else {
                        System.out.println("是否删除 y/n");
                        String confirm = input.next();
                        if ("y".equals(confirm) || "Y".equals(confirm)) {
                            int result = categoryService.delete(new Category().setCategoryId(categoryId));
                            System.out.println(result == 1 ? "已删除" : "未删除");
                        }
                    }
                    break;
                }
                case 5: {
                    categoryFlag = false;
                    System.out.println("回到一级菜单");
                    break;
                }
                default:
                    System.out.println("菜单编号不存在");
                    break;
            }
        }
    }

    private static void showProductList() {
        int pageNum = 1, size = 5, rowCount = productService.getTotal();
        int pageCount = (rowCount + size - 1) / size;
        boolean flag = true;
        while (flag) {
            products = productService.list(new Page(pageNum, size));
            System.out.println("\t编号\t商品名称\t采购价\t销售价\t分类\t供应商");
            products.sort(Comparator.comparingInt(Product::getProductId));
            for (Product product : products) {
                System.out.printf("\t%d\t%s\t%.2f\t%.2f\t%s\t%s\n",
                        product.getProductId(),
                        product.getProductName(),
                        product.getPurchasePrice(),
                        product.getSalesPrice(),
                        product.getCategoryName(),
                        product.getProviderName());
            }
            System.out.println("1.首页 2.上一页 3.下一页 4.尾页 5.回到上级菜单");
            System.out.printf("总条数：%d 总页数：%d 当前页数：%d\n", rowCount, pageCount, pageNum);
            System.out.print("请选择分页菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    pageNum = 1;
                    System.out.println("1.首页");
                    break;
                case 2:
                    System.out.println("2.上一页");
                    if (pageNum > 1) {
                        pageNum--;
                    } else {
                        System.out.println("已显示首页");
                    }
                    break;
                case 3:
                    System.out.println("3.下一页");
                    if (pageNum < pageCount) {
                        pageNum++;
                    } else {
                        System.out.println("已显示尾页");
                    }
                    break;
                case 4:
                    System.out.println("4.尾页");
                    pageNum = pageCount;
                    break;
                case 5:
                    flag = false;
                    System.out.println("回到一级菜单");
                    break;
                default:
                    System.out.println("菜单编号不存在");
                    break;
            }
        }
    }

    private static void showCategoryList() {
        int pageNum = 1, size = 5, rowCount = categoryService.getTotal();
        int pageCount = (rowCount + size - 1) / size;
        boolean flag = true;
        while (flag) {
            categories = categoryService.list(new Page(pageNum, size));
            System.out.println("\t编号\t分类名称\t分类描述");
            categories.sort(Comparator.comparingInt(Category::getCategoryId));
            for (Category category : categories) {
                System.out.printf("\t%d\t%s\t%s\n",
                        category.getCategoryId(),
                        category.getCategoryName(),
                        category.getCategoryDesc()
                );
            }
            System.out.println("1.首页 2.上一页 3.下一页 4.尾页 5.回到上级菜单");
            System.out.printf("总条数：%d 总页数：%d 当前页数：%d\n", rowCount, pageCount, pageNum);
            System.out.print("请选择分页菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    pageNum = 1;
                    System.out.println("1.首页");
                    break;
                case 2:
                    System.out.println("2.上一页");
                    if (pageNum > 1) {
                        pageNum--;
                    } else {
                        System.out.println("已显示首页");
                    }
                    break;
                case 3:
                    System.out.println("3.下一页");
                    if (pageNum < pageCount) {
                        pageNum++;
                    } else {
                        System.out.println("已显示尾页");
                    }
                    break;
                case 4:
                    System.out.println("4.尾页");
                    pageNum = pageCount;
                    break;
                case 5:
                    flag = false;
                    System.out.println("回到一级菜单");
                    break;
                default:
                    System.out.println("菜单编号不存在");
                    break;
            }
        }
    }
}
