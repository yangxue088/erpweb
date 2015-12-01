<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<script type="text/javascript" src="<c:url value="/resources/jssor-slider/js/jssor.slider.mini.js" />"></script>

	<style type="text/css">

	.row {
		padding-bottom: 20px;
	}

	.row .col-sm-2 {
		text-align: right;
	}

	.row .col-sm-10 table tr td{
		padding-right: 30px;
		padding-bottom: 5px;
	}

	</style>

	<div class="container">

		<div>
			<h4>浏览产品</h4>
		</div>

		<hr class="soften"></hr>

		<div>
			<div class="row">
				<div class="col-sm-2">
					行业及产品类目:
				</div>
				<div class="col-sm-10" id="product-type">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					产品属性:
				</div>
				<div class="col-sm-10">
					<table id="product-attr-table">
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					产品名称:
				</div>
				<div class="col-sm-10" id="product-title">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					产品图片:
				</div>
				<div class="col-sm-10">
					<!-- Jssor Slider Begin -->
					<!-- To move inline styles to css file/block, please specify a class name for each element. --> 
					<div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 240px;
					height: 240px;">

					<!-- Loading Screen -->
					<div u="loading" style="position: absolute; top: 0px; left: 0px;">
						<div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
						background-color: #000000; top: 0px; left: 0px;width: 100%;height:100%;">
					</div>
					<div style="position: absolute; display: block; background: url(<c:url value="/resources/jssor-slider/img/loading.gif" />) no-repeat center center;
					top: 0px; left: 0px;width: 100%;height:100%;">
				</div>
			</div>

			<!-- Slides Container -->
			<div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 240px; height: 240px;
			overflow: hidden;" id="product-pictures">
					<!-- <div><img u="image" src="<c:url value="/resources/tmp/picture/1.jpg" />" /></div>
					<div><img u="image" src="<c:url value="/resources/tmp/picture/2.jpg" />" /></div>
					<div><img u="image" src="<c:url value="/resources/tmp/picture/3.jpg" />" /></div> -->
				</div>

				<style>
				.jssorb03 {
					position: absolute;
				}
				.jssorb03 div, .jssorb03 div:hover, .jssorb03 .av {
					position: absolute;
					/* size of bullet elment */
					width: 21px;
					height: 21px;
					text-align: center;
					line-height: 21px;
					color: white;
					font-size: 12px;
					background: url(<c:url value="/resources/jssor-slider/img/b03.png" />) no-repeat;
					overflow: hidden;
					cursor: pointer;
				}
				.jssorb03 div { background-position: -5px -4px; }
				.jssorb03 div:hover, .jssorb03 .av:hover { background-position: -35px -4px; }
				.jssorb03 .av { background-position: -65px -4px; }
				.jssorb03 .dn, .jssorb03 .dn:hover { background-position: -95px -4px; }
				</style>
				<!-- bullet navigator container -->
				<div u="navigator" class="jssorb03" style="bottom: 0px; right: 0px;">
					<!-- bullet navigator item prototype -->
					<div u="prototype"><div u="numbertemplate"></div></div>
				</div>
				<!--#endregion Bullet Navigator Skin End -->
				<a style="display: none" href="http://www.jssor.com">Image Slider</a>
			</div>
			<!-- Jssor Slider End -->
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			最小计量单位:
		</div>
		<div class="col-sm-10" id="product-measure-unit">
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			销售方式:
		</div>
		<div class="col-sm-10" id="product-saletype">
		</div>
	</div>
	<div class="row" id="product-inventory">
		<div class="col-sm-2">
			库存:
		</div>
		<div class="col-sm-10">
		</div>
	</div>
	<div class="row" id="product-code">
		<div class="col-sm-2">
			商品编码:
		</div>
		<div class="col-sm-10">
		</div>
	</div>
	<div class="row" id="product-stock">
		<div class="col-sm-2">
			库存和编码:
		</div>
		<div class="col-sm-8">
			<table class="table table-condensed table-bordered" id="product-stock-table">
				<thead>
					<tr>
						<td>套餐</td>
						<td>颜色</td>
						<td>库存</td>
						<td>商品编码</td>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			产品包装后的尺寸:
		</div>
		<div class="col-sm-10" id="product-packagesize">
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			产品包装毛重:
		</div>
		<div class="col-sm-10" id="product-weight">
		</div>
	</div>
</div>

<div style="position:fixed; bottom:50px; right:105px; float: right;">
	<a href="<c:url value="/publish/reedit?productid=${productId}" />" class="btn btn-primary btn-md btn-block btn-success" role="button">编辑</a>
</div>

</div>

<script type="text/javascript">

$(function() {
	var req = {};

	if("${productId}".length){
		eval(
			'req.pid = ${productId};'
			);
	}

	$.post('getProduct', {productId: req.pid}, function(data){
		var type = data.type;
		var product = JSON.parse(data.json);

		$('#product-type').text(type);

		$.each(product.attrs, function(name, value){
			if(value){
				$('#product-attr-table').append("<tr><td width='20%'>" + name + "</td><td width='80%'>" + value + "</td></tr>");
			}
		});

		$.each(product.cattrs, function(name, value){
			if(value){
				$('#product-attr-table').append("<tr><td>" + name + "</td><td>" + value + "</td></tr>");
			}
		});

		$('#product-title').text(product.title);

		$('#product-measure-unit').text(product.measureunit);

		var munit = product.measureunit.substring(0, product.measureunit.indexOf(' '));

		if(product.saletype == 'by-unit'){
			$('#product-saletype').text("单 " + munit + " 出售");
		}else{
			$('#product-saletype').text("打包出售,每包 " + product.numofpackage + " " + munit);
		}

		$('#product-packagesize').text(product.packagesize[0] + " cm X " + product.packagesize[1] + " cm X " + product.packagesize[2] + " cm, 体积: " + product.packagesize[0] * product.packagesize[1] * product.packagesize[2]+ " cm3");

		$('#product-weight').text(product.weight + " kg");

		init_picture_preview();

		init_stock_table();
	});

function init_stock_table(){
	$.post('getStocks', {productId: req.pid}, function(stocks){
		if(stocks.length == 1 && (stocks[0][0] == "" && stocks[0][1] == "")){
			$('#product-stock').addClass('hide');

			$('#product-inventory .col-sm-10').text(stocks[0][2]);
			$('#product-code .col-sm-10').text(stocks[0][3]);

		}else{
			$('#product-inventory').addClass('hide');
			$('#product-code').addClass('hide');

			$.each(stocks, function(i, stock){
				$('#product-stock-table tbody').append("<tr><td>" + stock[0] + "</td><td>"+ stock[1] +"</td><td>" + stock[2] + "</td><td>" + stock[3] + "</td></tr>");
			});

			if(stocks[0][0] == ""){
				$('#product-stock-table').find('tr td:nth-child(1)').addClass('hide');
			}

			if(stocks[0][1] == ""){
				$('#product-stock-table').find('tr td:nth-child(2)').addClass('hide');
			}
		}
	});
}

function init_picture_preview(){
	$.post('getPictures', {productId: req.pid}, function(imgsrcs){
		$.each(imgsrcs, function(i, imgsrc){
			$('#product-pictures').append('<div><img u="image" src="' + imgsrc + '" /></div>');
		});

		init_picture_slider();
	});
}

function init_picture_slider() {
	var options = {
                $DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
                    $Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $ActionMode: 1,                                 //[Optional] 0 None, 1 act by click, 2 act by mouse hover, 3 both, default value is 1
                    $AutoCenter: 0,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
                    $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
                    $SpacingX: 0,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 0,                                   //[Optional] Vertical space between each item in pixel, default value is 0
                    $Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
                }
            };

            var jssor_slider1 = new $JssorSlider$("slider1_container", options);
        }

    });

</script>
</body>
</html>