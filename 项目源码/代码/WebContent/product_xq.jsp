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
        <div class="tit">山水画简介</div>
        <div class="date">发表时间：2020-9-21  点击量：9999</div>
        <img src="images/productlogo.jpg" width="50%"/>
        <div class="con">
          <p>中国山水画（简称：山水）是以山川自然景观为主要描写对象的中国画，形成于魏晋南北朝时期。</p>
          <p>中国山水画较之西方风景画，早了1000年左右。隋唐时开始独立，五代、北宋时趋于成熟，成为中国画的重要画科。传统上按画法风格分为青绿山水、金碧山水、水墨山水、浅绛山水、小青绿山水、没骨山水等。</p>
          <p>中国山水画是中国人情思中最为厚重的沉淀。游山玩水的大陆文化意识，以山为德、水为性的内在修为意识，咫尺天涯的视错觉意识，一直成为山水画演绎的中轴主线。从山水画中，我们可以集中体味中国画的意境、格调、气韵和色调。再没有那一个画科能像山水画那样给国人以更多的情感。若说与他人谈经辩道，山水画便是民族的底蕴、古典的底气、我的图像、人的性情。</p>
          <p>山与水。《墨子·明鬼下》:“古今之为鬼，非他也，有天鬼，亦有山水鬼神者，亦有人死而为鬼者。”《三国志·魏书·贾诩传》：“吴蜀虽蕞尔小国，依阻山水……皆难卒谋也。”唐柳宗元《渔翁》诗：“烟销日出不见人，唉乃一声山水绿。”泛指有山有水的风景。《宋书·谢灵运传》：“出为永嘉太守。郡有名山水，灵运素所爱好，出守既不得志，遂肆意游遨。”清恽敬《重修松窦庵记》：“后陈茂才云渠来谈，县西山水之胜，皆远在数十里外，以暑不及游，因同游县东之松窦。”</p>
          <p>山水画的简称。 唐朝杜甫《存殁口号》之二：“ 郑公粉绘随长夜，曹霸丹青已白头，天下何曾有山水，人间不解重骅骝。” 宋朝张淏 《云谷杂记》卷四：“ 王象先于鹅溪绢上作山水，不如意，急湔去故墨。” 清朝焦循 《忆书》六：“先曾祖母卞孺人幼时，卞公无子，深爱之，延师教以诗画，遂工山水，诗画外无他好也。” 张天翼《新生》：“ 章老先生总炫耀他家藏的东西， 吴昌硕刻过一幅图章送他，他还藏了一幅倪云林的山水，上面有张延济的题跋。”</p>
          <p>中国山水画较之西方风景画，起码早了1000余年。它所呈相的图义，实际上是一部中国思想史。早在7000多年以前，先古的觉醒便以图案方式纪录下来。新石器的河姆渡文化，已用线刻表达着观念性文化的内涵，定居的农耕文明起源，不仅让人认知了工具美，亦让人于器之上认知了形上美。艺术不但是一种征服自然的想象，还是一种征服自然想象的象征。先古与自然一开始便用艺术的方式对活，逻辑的发现与艺术的鉴赏推演着人们的双眼，让一个天人合一的中国图式由混沌而至清晰。</p>
          <p>自仰韶文化起，人与自然的关系便具有了象征性。在几何装饰的手法中，对称、运动等构成概念己明显地运用于时空的表现之中。特别让人感动的是《稷神崇拜图》。在以农立国的背景上，祭祀稷神一直成风。而这幅图中的禾、田、人的关系传达了先祖对生命意义的一种素朴理解。在沉淀了人与动物、植物的自然关系认知的基础上，社会意识又成为最为关键的文明起源。沧源文化的《村落图》，用岩画形式记述了人类对农耕定居的“家”的理解。这幅画最有视觉趣味的是以村落为中心的道路关联，以及押俘、赶畜、祭天、跳神等场面围绕正面中心的梯度延深，平面中的深度己在这幅画中得到有力的体现。人与自然的关系，人与社会的关系，就这样伴随着艺术的看，不断地深化与发展。</p>
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