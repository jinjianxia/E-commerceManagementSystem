package com;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ProductSys {
    private static final Scanner input = new Scanner(System.in);
    private static ProductService productService = new ProductServiceImpl();

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
//                    System.out.println("商品管理");
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
        boolean flag = true;
        while (flag) {
            System.out.println("1.列表查询 2.新增 3.修改 4.刷除 5.回到一级菜单");
            System.out.println("请选择商品管理菜单编号：");
            int menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    List<Product> products = productService.list();
                    System.out.println("\t编号\t商品名称\t采购价\t销售价");
                    for (Product product : products) {
                        System.out.printf("\t%d\t%s\t%.2f\t%.2f\n",
                                product.getProductId(),
                                product.getProductName(),
                                product.getPurchasePrice(),
                                product.getSalesPrice());
                    }
                    break;
                case 2:
                    System.out.println("新增");
                    break;
                case 3:
                    System.out.println("修改");
                    break;
                case 4:
                    System.out.println("删除");
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
