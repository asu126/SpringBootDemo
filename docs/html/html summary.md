### html 总结
1. HTML 标题 -- h1~h6

2. HTML 段落 -- p

3. HTML 链接 -- a
```
<a href="http://www.runoob.com">这是一个链接</a>
```

4. 图像
<img src="/images/logo.png" width="258" height="39" />

5. <link> 标签定义了文档与外部资源之间的关系。  -- 外部样式表
```
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
```

5. <style> 标签定义了HTML文档的样式文件引用地址. 在<style> 元素中你也可以直接添加样式来渲染 HTML 文档: -- 内部样式表
```
<head>
<style type="text/css">
body {background-color:yellow}
p {color:blue}
</style>
</head>
```

6. 内联样式
```
<p style="color:blue;margin-left:20px;">This is a paragraph.</p>
```

7. <script>标签用于加载脚本文件

8. 表格由 <table> 标签来定义。每个表格均有若干行（由 <tr> 标签定义），每行被分割为若干单元格（由 <td> 标签定义）

9. 无序列表使用 <ul> 标签, 有序列表始于 <ol> 标签

10. HTML 可以通过 <div> 和 <span>将元素组合起来

11.  表单 - 输入元素
```
<input type="text" name="firstname">
<input type="password" name="pwd">
<input type="radio" name="sex" value="male">Male<br>
<input type="checkbox" name="vehicle" value="Bike">I have a bike<br>
<input type="submit" value="Submit">
```

12. 通过使用框架iframe，你可以在同一个浏览器窗口中显示不止一个页面


### HTML5 的改进

新元素
新属性
完全支持 CSS3
Video 和 Audio
2D/3D 制图
本地存储
本地 SQL 数据
Web 应用


### css
1. CSS 属性定义背景效果:
background-color
background-image
background-repeat
background-attachment
background-position

2. CSS 文本格式
3. CSS 字体
4. CSS 链接
5. CSS 列表
6. CSS 表格
7. CSS 盒子模型
  - CSS 边框
  - CSS 轮廓（outline)
  - CSS margin(外边距)
  - padding（填充）

### 盒相关
##### 盒的基本类型 - display
block: 元素宽度占满整个浏览器宽度，一行仅允许一个block 类型元素，具有width, heigth 属性
inline: 宽度只等于所在内容宽度，一行可以并列多个inline 元素
inline-block: block 盒类型的一种，但是在显示时具有inline 盒类型的一种，具有width, heigth 属性
inline-table:
list-item: 列表
none: 不显示，不占用布局空间

##### 盒中容纳不下元素的显示 -- overflow: 指定如何显示盒中容纳不下的内容
hidden: 隐藏超出内容
scroll: 水平滚动条与垂直滚动条
auto: 自动
visible： 与不使用overflow 属性一样(初始值)

overflow-x:
overflow-y:


### 对盒使用阴影(阴影效果)
box-shadow：length(横) length（纵） length（半经） color


### Float（浮动），往往是用于图像，但它在布局时一样非常有用
left：	元素向左浮动。
right：	元素向右浮动。
none：	默认值。元素不浮动，并会显示在其在文本中出现的位置。
inherit:  规定应该从父元素继承 float 属性的值。

### possion定位
absolute：	生成绝对定位的元素，相对于 static 定位以外的第一个父元素进行定位。
元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。

fixed:	生成固定定位的元素，相对于浏览器窗口进行定位。
元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。

relative:	生成相对定位的元素，相对于其正常位置进行定位。
因此，"left:20" 会向元素的 LEFT 位置添加 20 像素。

static	默认值。没有定位，元素出现在正常的流中（忽略 top, bottom, left, right 或者 z-index 声明）。

sticky:	粘性定位，该定位基于用户滚动的位置。
它的行为就像 position:relative; 而当页面滚动超出目标区域时，它的表现就像 position:fixed;，它会固定在目标位置。
注意: Internet Explorer, Edge 15 及更早 IE 版本不支持 sticky 定位。 Safari 需要使用 -webkit- prefix (查看以下实例)。

inherit:	规定应该从父元素继承 position 属性的值。
initial:	设置该属性为默认值，详情查看 CSS initial 关键字。

### vue

- [vue](https://www.ctolib.com/docs-vue-js-c-index.html)
