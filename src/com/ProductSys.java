package com;

import com.model.Category;
import com.model.Page;
import com.model.Product;
import com.model.Provider;
import com.service.*;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.service.impl.ProviderServiceImpl;

import java.util.*;

public class ProductSys {
    private static final Scanner input = new Scanner(System.in);
    private static final ProductService productService = new ProductServiceImpl();
    private static final CategoryService categoryService = new CategoryServiceImpl();
    private static final ProviderService providerService = new ProviderServiceImpl();
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("欢迎进入商品管理系统");
        boolean flag = true;
        while (flag) {
            System.out.println("1.商品管理 2.分类管理 3.供应商管理 4.退出");
            System.out.println("请选择菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    productMenu();
                    break;
                case 2:
                    System.out.println("分类管理");
                    break;
                case 3:
                    System.out.println("供应商管理");
                    break;
                case 4:
                    flag = false;
                    System.out.println("退出");
                    break;
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
                    System.out.println("请输入分类的编号：");
                    int categoryId = input.nextInt();
                    List<Provider> providers = providerService.list();
                    for (Provider provider : providers) {
                        System.out.printf("%d.%s ",
                                provider.getProviderId(),
                                provider.getProviderName());
                    }
                    System.out.println("请输入供应商编号：");
                    int providerId = input.nextInt();
                    int res = productService.addProduct(new Product(productName,
                            categoryId,
                            providerId,
                            purchasePrice,
                            salesPrice,
                            quantity));
                    System.out.println("res = " + res);
                    break;
                }
                // 3.修改
                case 3: {
                    products = productService.list();
                    System.out.println("请输入修改的商品的编号：");
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
                        System.out.println("请输入分类的编号：");
                        int categoryId = input.nextInt();
                        List<Provider> providers = providerService.list();
                        for (Provider provider : providers) {
                            System.out.printf("%d.%s ",
                                    provider.getProviderId(),
                                    provider.getProviderName());
                        }
                        System.out.println("请输入供应商编号：");
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
                            System.out.println("商品新增完成。");
                        }
                    }
                    break;
                }
                // 4.删除
                case 4: {
//                    System.out.println("删除");
                    System.out.println("请输入商品编号：");
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

    private static void showProductList() {
        int pageNum = 1, size = 2, rowCount = productService.getTotal();
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
            System.out.printf("总条数：%d 总页数：%d%n", rowCount, pageCount);
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
