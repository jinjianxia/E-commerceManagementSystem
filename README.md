# E-commerceManagementSystem

## 商品管理系统

### 1.菜单跳转

#### 登录后查看的菜单有：

#### 一级菜单

1. 商品管理
2. 分类管理
3. 供应商管理
4. 退出

#### 二级菜单

1. 列表查询
2. 新增
3. 修改
4. 删除
5. 返回上一级菜单

### 2.显示商品列表

## 分层思想

|       层次       |   功能   |
|:--------------:|:------:|
|   dao(数据访问层)   | 接口和实现类 |
| service(业务服务层) ||
|   model(实体类)   |  收集信息  |

## 数据库

数据库配置文件在 db.properties，数据库名为productdb。下列左边为key，右边为values类型，varchar的长度可以自拟。

### admin

- admin_id = int (主键、自增、非负)
- admin_name = varchar
- admin_password = varchar
- date = datetime

### categories

- category_id = int (主键、自增、非负)
- category_name = varchar
- category_desc = varchar

### products

- product_id = int (主键、自增、非负)
- category_id = int
- provider_id = int
- product_name = varchar
- purchase_price = double
- sales_price = double
- quantity = int
- created_time = datetime

#### 外键：

1. category_id -> categories.category_id
2. provider_id -> providers.provider_id

### providers

- provider_id = int (主键、自增、非负)
- provider_name = varchar
- provider_address = varchar
- provider_tel = varchar
- account = varchar
- email = varchar