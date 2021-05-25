<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("ul.typeul .typeone").click(function()
	{
		var arrow = $(this).find("span.arrow");
		if(arrow.hasClass("up"))
		{
			arrow.removeClass("up");
			arrow.addClass("down");
		}
		else if(arrow.hasClass("down"))
		{
			arrow.removeClass("down");
			arrow.addClass("up");
		}
		$(this).parent().find(".typetwo").slideToggle();
	});
})
</script>
</head>

<body>
<div class="header">
  <div class="main">
     <a href="index.jsp"><img src="images/logo.png" /></a>
  </div>
</div>
<div class="clear"></div>
<div class="nav">
  <ul>
    <li><a href="index.jsp">首页</a></li>
    <li><a href="about.jsp">关于我们</a></li>
    <li><a href="product.jsp">产品展示</a></li>
    <li><a href="news.jsp">行业动态</a></li>
    <li><a href="notices.jsp">我要留言</a></li>
    <li><a href="contact.jsp">联系我们</a></li>
  </ul>
</div>
<div class="clear"></div>
<div class="banner">
  <div class="b-img">
      <img src="images/banner.jpg" width="100%"/>
      <img src="images/banner.jpg" width="100%" />
  </div>
  <div class="clear"></div>
  <div class="b-list"> </div>
</div>
<div class="clear"></div>
<div class="main">
  <div class="mainL">
    <div class="titbox">产品分类</div>
    <ul class="typeul">
      <li>
        <div class="typeone"><a href="human.jsp">人物画</a><span class="arrow up"></span></div>
        <div class="typetwo">
          <a href="human_xq.jsp">人物画简介</a>
        </div>
      </li>
      <li>
        <div class="typeone"><a href="bird.jsp">花鸟画</a><span class="arrow up"></span></div>
        <div class="typetwo">
          <a href="bird_xq.jsp">花鸟画简介</a>
        </div>
      </li>
      <li>
        <div class="typeone"><a href="product.jsp">山水画</a><span class="arrow up"></span></div>
        <div class="typetwo">
          <a href="product_xq.jsp">山水画简介</a>
        </div>
      </li>
    </ul>
    
    
   <div class="titbox">最新资讯</div>
    <ul class="newsul">
      <li><a href="detail.jsp" class="ccsl">字画装裱需要注意什么细节问题?</a></li>
      <li><a href="detail2.jsp" class="ccsl">字画装裱是什么，如何修复？</a></li>
      <li><a href="https://zhuanlan.zhihu.com/p/27397993" class="ccsl">中国的人物画!</a></li>
      <li><a href="https://www.zhihu.com/question/20756819" class="ccsl">为什么中国古代人物画总是看着不那么写实？</a></li>
      <li><a href="https://www.zhihu.com/question/27218828" class="ccsl">人物画与风景画哪个更有深度，更难画？</a></li>
    </ul>
    
    <div class="titbox">行业动态</div>
    <ul class="newsul">
     <li><a href="https://mp.weixin.qq.com/s?src=3&timestamp=1600694003&ver=1&signature=BfsraBuMBDpFx6pTofR8h-xAHcdrbHP*kM8u9nvTurJGJdT4HwCb8Mnb8nPGVtUX7QhzDyuLpy2oFhF0uDlHge117XjOKeKkHJuN1y5MaRVupTtT7*2pgQ2YltjxtRzYeeegyN4ZwvGTT5p42ExLo1mXEMCxCgs5Di-3g8-Ss0Q=" class="ccsl"> > 经典山水画50幅，太养眼了</a></li>
     <li><a href="https://zhuanlan.zhihu.com/p/104687678" class="ccsl"> > 初级古风人物绘画教程，绘画入门学习</a></li>
     <li><a href="https://pic.sogou.com/d?query=%E4%BA%BA%E7%89%A9%E7%94%BB%E5%8F%A4%E9%A3%8E&ie=utf8&page=1&did=1&st=255&mode=255&phu=http%3A%2F%2Fpic138.nipic.com%2Ffile%2F20170810%2F25762159_143638859038_2.jpg&p=40230500&entityid=&rawQuery=%E4%BA%BA%E7%89%A9%E7%94%BB%E5%8F%A4%E9%A3%8E" class="ccsl"> > 古风人物</a></li>
     <li><a href="https://mp.weixin.qq.com/s?src=11&timestamp=1600694094&ver=2598&signature=wjkU8M7*1seM9XUyLanVxNV3dqUIYrlKcP8BTRGkfJNhQ1SgTr9f8*xEe6-2OpxL4RLyGEyWG5RoQmSVw21Sa9OvLPqrE0k17G18WT9Xeqh60J3upMx26JuEnPUa9SzG&new=1" class="ccsl"> > 新古风人物画</a></li>
     <li><a href="https://wenku.baidu.com/view/8558bfd649649b6648d747e6.html" class="ccsl"> > 中国山水画</a></li>
    </ul>
    
    
    <div class="titbox">联系我们</div>
    <div class="lxwm">
      <div class="con">
        手 机：12345678910<br />
        电 话：77000000<br />
        邮箱：123***@qq.com<br />
        地 址：河北省石家庄市裕华**街道**楼  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
      </div>
    </div>
  </div>
  <div class="mainR">
    <div class="brandnavbox">
      <h2>产品展示</h2>
      <div class="con">当前位置：首页》产品展示</div>
    </div>
    <div class="detailbox">
      <div class="xq">
        <div class="tit">花鸟画简介</div>
        <div class="date">发表时间：2020-9-21  点击量：9999</div>
        <img src="images/birdlogo.jpg" width="50%"/>
        <div class="con">
          <p>花鸟画，是中国画的一种，以花、鸟、虫等为描绘对象的画。在中国画中，凡以花卉、花鸟、鱼虫等为描绘对象的画，称之为花鸟画。花鸟画中的画法中有“工笔”、“写意”、“兼工带写”三种。</p>
          <p>工笔花鸟画即用浓、淡墨勾勒对象，再深浅分层次着色；写意花鸟画即用简练概括的手法绘写对象；介于工笔和写意之间的就称为兼工带写，形态逼真。</p>
          <p>指用中国的笔墨和宣纸等传统工具，以“花、鸟、虫、鱼、禽兽”等动植物形象为描绘对象的一种绘画。中国花鸟画，是中国传统的三大画科之一。花鸟画描绘的对象，实际上不仅仅是花与鸟，而是泛指各种动植物，包括花卉、蔬果、翎毛、草虫、禽兽等类。</p>
          <p>花鸟画是以动植物为主要描绘对象的中国画传统画科。又可细分为花卉、翎毛、蔬果、草虫、畜兽、鳞介等支科。中国花鸟画集中体现了中国人与作为审美客体的自然生物的审美关系，具有较强的抒情性。它往往通过抒写作者的思想感情,体现时代精神,间接反映社会生活，在世界各民族同类题材的绘画中表现出十分鲜明的特点。其技法多样，曾以描写手法的精工或奔放，分为工笔花鸟画和写意花鸟画（又可分为大写意花鸟画和小写意花鸟画）;又以使用水墨色彩上的差异,分为水墨花鸟画、泼墨花鸟画、设色花鸟画、白描花鸟画与没骨花鸟画。</p>
          <p>它是中国画的一种。北宋《宣和画谱·花鸟叙论》云：“诗人六义，多识于鸟兽草本之名，而律历四时，亦记其荣枯语默之候，所以绘事之妙，多寓兴于此，与诗人相表里焉。”在中国画中，凡以花卉、花鸟、鱼虫等为描绘对象的画，称之为花鸟画。花鸟画中的画法中有“工笔”、“写意”、“兼工带写”三种。工笔花鸟画，即用浓、淡墨勾勒动象，再深浅分层次着色；写意花鸟画即用简练概括的手法绘写对象；介于工笔和写意之间的就称为兼工带写。</p>
          <p>早在工艺、雕刻与绘画尚无明确分工的原始社会,中国花鸟画已萌芽，天水放马滩出土的战国末期木板画《老虎被缚图》，是已知最早的独幅花鸟画，美国纳尔逊·艾京斯艺术博物馆所藏东汉陶仓楼上的壁画《双鸦栖树图》，也是较早的独幅花鸟画。花鸟画发展到两汉六朝则粗具规模。南齐谢赫《画品》记载的东晋画家刘胤祖，是已知第一位花鸟画家。经唐、五代北宋，花鸟画完全发展成熟。</p>
          <p>在中国绘画中，花鸟画是一个宽泛的概念，除了本意花卉和禽鸟之外，还包括了畜兽、虫鱼等动物，以及树木、蔬果等植物。在原始彩陶和商用青铜器上，“花鸟”充满神秘色彩，遗留着图腾的气息。最早的“花鸟”或许与早期人类的生殖崇拜有一定关系。</p>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<div class="clear"></div>
<div class="footerBox">
  <div class="main">
    <div class="footL">
      <div class="tit">联系我们</div>
      <ul>
        <li class="f1">手 机：12345678910</li>
        <li class="f2">电 话：77000000</li>
        <li class="f3">邮箱：123***@qq.com</li>
        <li class="f4">地 址：河北省石家庄市裕华**街道**楼  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></li>
      </ul>
    </div>
    <div class="footR">
      <div class="telbox">
        <div class="tel">
          <span>12345678910</span>
          <b><p>欢迎来电咨询</p></b>
        </div>
      </div>
      <div class="footer">
        <div>***有限公司<br />联系方式：12345678910<br />地 址：河北省石家庄市裕华**街道**楼  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></div>
      </div>
    </div>
  </div>
</div>
<div class="clear"></div>
<div class="fnav">
  <div class="main">
    <a href="index.jsp">首页</a>
    <a href="about.jsp">关于我们</a>
    <a href="product.jsp">产品展示</a>
    <a href="news.jsp">行业动态</a>
    <a href="notices.jsp">我要留言</a>
    <a href="contact.jsp">联系我们</a>
  </div>
</div>
</body>
</html>