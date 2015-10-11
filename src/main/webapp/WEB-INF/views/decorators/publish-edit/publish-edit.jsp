<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"  %>

<page:applyDecorator name="main-layout">
<html>
<body>

	<script type="text/javascript" src="<c:url value="/resources/holderjs/js/holder.js" />"></script>
	
	<link href="<c:url value="/resources/bootstrap-select/css/bootstrap-select.min.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-select/js/bootstrap-select.min.js" />"></script>

	<link href="<c:url value="/resources/bootstrap-fileinput/css/fileinput.min.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-fileinput/js/fileinput.min.js" />"></script>

	<link href="<c:url value="/resources/webix/webix.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/webix/webix.js" />"></script>

	<style type="text/css">
	.webix_message_area{
		padding-top: 50px;
	}

	.scrollable {
		height: 300px;
		overflow: auto;
		margin-bottom: 10px;
	}

	#choose-div{
		margin-bottom: 10px;
	}	

	#choose-text{
		color: #7A2D01;
	}

	.panel{
		opacity: 0.9;
	}

	.panel .panel-body .row{
		margin-bottom: 10px;
	}

	.panel .panel-body .row >div >label{
		font-weight: 300;
	}

	.panel .panel-body .row .col-sm-2{
		text-align: right;
	}

	.panel .panel-body .row .col-sm-10 >label{
		margin-right: 30px;
	}

	.panel .panel-body .row .col-sm-10 >label >input{
		margin-right: 5px;
	}

	.panel .panel-body .row .col-sm-10.col-sm-offset-2{
		margin-top: 10px;
	}

	.base-attr{
		border-style: 1px solid #CCC;
		background-color: #F6F6F6;
	}

	.base-attr .attr-name{
		width: 150px;
		padding: 5px 15px 0px 0px;
		border-style: hidden;
		text-align: right;
	}

	.base-attr .attr-value{
		padding: 5px 15px 0px 0px;
		border-style: hidden;
	}

	.base-attr .attr-value >label{
		font-weight: 300;
		padding-right: 15px;
	}

	.custom-attr-div{
		padding-left: 150px;
	}

	.custom-attr-div .custom-attr-row{
		margin-bottom: 10px;
	}

	.custom-attr-div .custom-attr-row > *{
		margin-right: 20px;
	}

	.picture {
		padding-left: 10px;
		padding-top: 10px;
	}

	.picture >a{
		margin-right: 15px;
	}

	.origin{
		padding: 7px;
	}

	.file-drop-zone{
		text-align: left;
	}

	[data-required]::before{
		content: "*";
		color: red;
	}

	input[type="text"]{
		padding-left: 5px;
	}

	</style>

	<div id="choose-div" class="alert alert-info" role="alert">
		您当前选择的类目：<span id="choose-text">${choosetext}</span>
	</div>

	<div id="product-info-panel" class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title"><strong>1. 产品基本信息</strong></h2>
		</div>
		<div class="panel-body">

			<div id="base-attr-div">
				<decorator:body />
			</div>

			<div class="row">
				<div class="col-sm-2">
					<label data-required>产品标题:</label>
				</div>
				<div class="col-sm-10">
					<input id="product-title-input" name="product-title" type="text" maxlength="128" size="70" data-alert="产品标题不能为空">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>产品关键词:</label>
				</div>
				<div class="col-sm-10">
					<input id="product-keyword-input" name="product-keyword" type="text">
					<label><a href="#more-key-words" data-toggle="collapse" role="button">添加更多关键字</a></label>
				</div>
			</div>
			<div id="more-key-words" class="row collapse">
				<div class="col-sm-2">
					<label>更多关键词:</label>
				</div>
				<div class="col-sm-10">
					<span>
						<input id="product-more-keyword-input-1" name="product-more-keyword-1" type="text">
					</span>
					<span>
						<input id="product-more-keyword-input-2" name="product-more-keyword-2" type="text">
					</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>产品图片:</label>
				</div>
				<div class="col-sm-10">
					<div>
						<input id="product-image-uploader" name="images" type="file" multiple class="file-loading" accept="image/*">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-2">
					<label data-required>最小计量单位:</label>
				</div>
				<div class="col-sm-10">
					<select id="product-measure-unit-select" name="product-measure-unit">
						<option>袋 (bag/bags)</option>
						<option>桶 (barrel/barrels)</option>
						<option>蒲式耳 (bushel/bushels)</option>
						<option>箱 (carton)</option>
						<option>厘米 (centimeter)</option>
						<option>组合 (combo)</option>
						<option>立方米 (cubic meter)</option>
						<option>打 (dozen)</option>
						<option>英尺 (feet)</option>
						<option>加仑 (gallon)</option>
						<option>克 (gram)</option>
						<option>英寸 (inch)</option>
						<option>千克 (kilogram)</option>
						<option>千升 (kiloliter)</option>
						<option>千米 (kilometer)</option>
						<option>升 (liter/liters)</option>
						<option>英吨 (long ton)</option>
						<option>米 (meter)</option>
						<option>公吨 (metric ton)</option>
						<option>毫克 (milligram)</option>
						<option>毫升 (milliliter)</option>
						<option>毫米 (millimeter)</option>
						<option>盎司 (ounce)</option>
						<option>包 (pack/packs)</option>
						<option>双 (pair)</option>
						<option selected="selected">件/个 (piece/pieces)</option>
						<option>磅 (pound)</option>
						<option>夸脱 (quart)</option>
						<option>套 (set/sets)</option>
						<option>美吨 (short ton)</option>
						<option>平方英尺 (square feet)</option>
						<option>平方英寸 (square inch)</option>
						<option>平方米 (square meter)</option>
						<option>平方码 (square yard)</option>
						<option>吨 (ton)</option>
						<option>码 (yard/yards)</option>
					</select>
					<span class="hidden" name="product-measure-unit">件/个</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>销售方式:</label>
				</div>
				<div class="col-sm-10">
					<label>
						<input type="radio" name="sale-type" id="product-sale-type-per-unit" checked>
						<span>按<span name="product-measure-unit">件/个</span>出售</span>
					</label>
					<label>
						<input type="radio" name="sale-type" id="product-sale-type-package">
						<span>打包出售</span>
					</label>
					<label id="num-per-package" class="hidden">
						<span>每包</span>
						<input type="text" size="10" id="product-sale-type-num-per-package" data-alert="产品每包数不能为空">
						<span name="product-measure-unit">件/个</span>
					</label>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>套餐:</label>
				</div>
				<div class="col-sm-10" id="sale-style-div">
				</div>
			</div>
			<div class="row hidden">
				<div class="col-sm-4 col-sm-offset-2">
					<table id="sale-style-table" class="table table-condensed table-bordered">
						<thead>
							<tr>
								<td>套餐</td>
								<td>自定义名称</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>颜色:</label>
				</div>
				<div class="col-sm-10" id="color-div">
				</div>
			</div>
			<div class="row hidden">
				<div class="col-sm-4 col-sm-offset-2">
					<table id="color-table" class="table table-condensed table-bordered">
						<thead>
							<tr>
								<td>颜色</td>
								<td>自定义名称</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row hidden">
				<div class="col-sm-8 col-sm-offset-2">
					<table id="inventory-table" class="table table-condensed table-bordered">
						<thead>
							<tr>
								<td class="hidden">套餐</td>
								<td class="hidden">颜色</td>
								<td class="hidden">库存</td>
								<td>商品编码</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row hidden" id="inventory-unit-div">
				<div class="col-sm-2">
					<label>库存:</label>
				</div>
				<div class="col-sm-10">
					<label>
						<input id="product-inventory-input" name="product-inventory" type="text" size="5">
						<span name="inventory-unit">件/个</span>
					</label>
				</div>
			</div>
			<div class="row" id="code-div">
				<div class="col-sm-2">
					<label>商品编码:</label>
				</div>
				<div class="col-sm-10">
					<label>
						<input id="product-code-input" name="product-code" type="text" size="20">
					</label>
				</div>
			</div>
		</div>
	</div>

	<div id="package-info-panel" class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title"><strong>2. 包装信息</strong></h2>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-2">
					<label data-required>产品包装后的重量:</label>
				</div>
				<div class="col-sm-10">
					<label>
						<input id="product-weight-input" name="product-weight" type="text" size="5" data-alert='产品重量不能为空'>
						<span>公斤/<span name="inventory-unit">件/个</span></span>
					</label>
				</div>
				<div class="col-sm-10 col-sm-offset-2">
					<label>
						<input id="custom-weight-check" type='checkbox' data-target="#custom-weight-div" data-toggle="collapse">
						<span>自定义计重</span>
					</label>
				</div>
				<div class="col-sm-10 col-sm-offset-2">
					<div id="custom-weight-div" class="well collapse">
						<span>买家购买</span>
						<input id="product-custom-weight-input-1" name="product-custom-weight-1" type='text' size="5" data-alert='自定义计重不能为空'>
						<span name="inventory-unit">件/个</span>
						<span>以内，按单件产品重量计算运费。</span><br/>
						<span>在此基础上，买家每多买</span>
						<input id="product-custom-weight-input-2" name="product-custom-weight-2" type='text' size="5" data-alert='自定义计重不能为空'>
						<span name="inventory-unit">件/个</span>
						<span>，重量增加</span>
						<input id="product-custom-weight-input-3" name="product-custom-weight-3" type='text' size="5" data-alert='自定义计重不能为空'>
						<span>kg。</span>
					</div>
				</div>
				<div class="col-sm-2">
					<label data-required>产品包装后的尺寸:</label>
				</div>
				<div class="col-sm-10">
					<label id="product-volume-div">
						<input id="product-package-length-input" name="product-package-length" type="text" size="5" placeholder="长" data-alert='产品尺寸不能为空'>
						<span>  x  </span>
						<input id="product-package-width-input" name="product-package-width" type="text" size="5" placeholder="宽" data-alert='产品尺寸不能为空'>
						<span>  x  </span>
						<input id="product-package-height-input" name="product-package-height" type="text" size="5" placeholder="高" data-alert='产品尺寸不能为空'>
						<span>(单位：厘米,每<span name="inventory-unit">件/个</span> <span id="product-volume">0</span> cm3)</span>
					</label>
				</div>
			</div>
		</div>
	</div>

	<div id="other-info-panel" class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title"><strong>3. 其他信息</strong></h2>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-2">
					<label data-required>产品分组:</label>
				</div>
				<div class="col-sm-10">
					<select id="product-group-selecter" name="product-group" class="selectpicker" data-live-search="true" data-alert='产品分组不能为空'>
					</select>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<label class="col-sm-2 col-sm-offset-3">
			<button id="product-preview" type="button" class="btn btn-primary btn-md btn-block btn-warning">取消发布</button>
		</label>
		<label class="col-sm-2 col-sm-offset-1">
			<button id="product-submit" type="button" class="btn btn-primary btn-md btn-block btn-success">发布产品</button>
		</label>
	</div>

	<script type="text/javascript">

	$(function() {

		var req = {};

		if("${productId}".length){
			eval(
				'req.pid = ${productId};' + 
				'req.product = ${product};' + 
				'req.imgids = ${imgids};' + 
				'req.imgsrcs = ${imgsrcs};' +
				'req.stocks = ${stocks};'
				);
		}

		init_single_div_table("sale-style", ["套餐1", "套餐2", "套餐3", "套餐4", "套餐5"]);

		init_single_div_table("color", ["白色", "黑色", "绿色", "红色", "灰色", "蓝色", "黄色", "粉色", "紫色", "银色", "金色", "多色", "褐色", "橙色", "卡其色", "透明"]);

		init_table_event();

		init_group_select();

		var initialPreview = [];
		var initialPreviewConfig = [];

		if(req.pid){
			if(req.imgids){
				$.each(req.imgids, function(i, imgid){
					initialPreview.push("<img src='"+ req.imgsrcs[i] +"' class='file-preview-image'>");

					initialPreviewConfig.push({
						url : 'image/delete',
						key : imgid
					});
				});
			}

			if(req.product){
				fill_product_info(req.product);
			}
		}

		init_image_fileinput(initialPreview, initialPreviewConfig);

		function fill_product_info(product){

			var attrs = product.attrs;

			$.each($('td.attr-name'), function(i, namesel){
				var name;
				if($(namesel).children().length){
					name = $(namesel).children().val().trim();
				}
				else{
					name = $(namesel).text().trim();
				}

				var value = attrs[name];

				var valsel = $(this).next('.attr-value');
				
				var type = valsel.attr('data-type');

				if(type == 'select'){
					valsel.find('select').val(value);
				}
				else if(type == 'check'){
					$.each(value, function(i, val){
						valsel.find("span:contains(" + val + ")").prev("input[type='checkbox']").prop("checked", true);
					});
				}
				else if(type == 'input'){
					valsel.find('input[type="text"]').val(value);
				}

			});

			var cattrs = product.cattrs;

			$.each(cattrs, function(name, value){
				insert_custom_attr(name, value);
			});

			$('#product-title-input').val(product.title);
			$('#product-keyword-input').val(product.keyword);

			if(product.morekeyword1 || product.morekeyword2){
				$('#product-more-keyword-input-1').parents("div.collapse").toggleClass("collapse");
				$('#product-more-keyword-input-1').val(product.morekeyword1);
				$('#product-more-keyword-input-2').val(product.morekeyword2);
			}

			$('#product-measure-unit-select').val(product.measureunit);

			if(product.saletype == "by-unit"){
				$('#product-sale-type-per-unit').prop("checked", true);
			}
			else{
				$('#product-sale-type-package').prop("checked", true);
				$('#num-per-package').removeClass("hidden");
				$('#product-sale-type-num-per-package').val(product.numofpackage);
			}

			var salestyles = product.salestyles;

			$.each(salestyles, function(name, value){
				var checkbox = $('#sale-style-div').find("span:contains(" + name + ")").prev("input:checkbox");
				checkbox.trigger('click');
				
				$(checkbox.attr('data-target')).find('input').val(value);
			});

			var colors = product.colors;

			$.each(colors, function(name, value){
				var checkbox = $('#color-div').find("span:contains(" + name + ")").prev("input:checkbox");
				checkbox.trigger('click');
				
				$(checkbox.attr('data-target')).find('input').val(value);
			});

			if(req.stocks.length == 1 && (req.stocks[0][0] == "" && req.stocks[0][1] == "")){
				$('#product-inventory-input').val(req.stocks[0][2]);
				$('#product-code-input').val(req.stocks[0][3]);
			}
			else{
				var stocks = req.stocks;
				$.each(stocks, function(i, stock){
					$('#inventory-table >tbody >tr:nth-child('+ (i+1) +')').find('td:nth-child(3) >input').val(stock[2]);
					$('#inventory-table >tbody >tr:nth-child('+ (i+1) +')').find('td:nth-child(4) >input').val(stock[3]);
				})
			}

			$('#product-weight-input').val(product.weight);

			if(product.customweight[0] || product.customweight[1] || product.customweight[2]){
				$('#custom-weight-check').trigger('click');
			}

			$('#product-custom-weight-input-1').val(product.customweight[0]);
			$('#product-custom-weight-input-2').val(product.customweight[1]);
			$('#product-custom-weight-input-3').val(product.customweight[2]);

			$('#product-package-length-input').val(product.packagesize[0]);
			$('#product-package-width-input').val(product.packagesize[1]);
			$('#product-package-height-input').val(product.packagesize[2]);

			$('#product-group-selecter').selectpicker('val', product.groupid);

		}

		function init_single_div_table(id, names){
			var divid = id + '-div';
			var tblid = id + '-table';

			$.each(names, function(i, name){
				$('#' + divid).append("<label><input type='checkbox' name='"+ id +"' data-target='#" + tblid +" >tbody >tr:nth-child("+ (i+1) +")' data-toggle='collapse'><span>"+ name +"</span></label>");
				$('#' + tblid).find('tbody').append("<tr class='collapse'><td>"+ name +"</td><td><input type='text' size='15'></td></tr>");
			});
		};

		$('#product-measure-unit-select').on('change', function(){
			var opt = $(this).val();

			$('span[name=product-measure-unit]').text(opt.substring(0, opt.indexOf(' ')));

			$('input:radio[name="sale-type"]').trigger("change");
		});

		$('input:radio[name="sale-type"]').on('change', function(){
			var inventory_unit = "";
			if($('#product-sale-type-package').is(':checked')){
				$('#num-per-package').removeClass("hidden");
				
				inventory_unit = "包";
			}
			else{
				$('#num-per-package').addClass("hidden");

				inventory_unit = $('span[name=product-measure-unit]:first').text();
			}

			$('span[name=inventory-unit]').text(inventory_unit);
		});

		function init_table_event(){

			$('input:checkbox[name="sale-style"]').on('change', function(){

				if($('input:checkbox[name="sale-style"]:checked').length > 0){
					$('#sale-style-table').parent().parent().removeClass("hidden");
					$('#inventory-table').parent().parent().removeClass("hidden");
					$('#inventory-table >thead >tr >td:nth-child(1)').removeClass("hidden");
					$('#inventory-table >tbody >tr >td:nth-child(1)').removeClass("hidden");

					init_inventory_table();

					$('#code-div').addClass("hidden");
				}
				else{
					$('#sale-style-table').parent().parent().addClass("hidden");
					$('#inventory-table >thead >tr >td:nth-child(1)').addClass("hidden");
					$('#inventory-table >tbody >tr >td:nth-child(1)').addClass("hidden");
					if($('input:checkbox[name="color"]:checked').length == 0){
						$('#inventory-table').parent().parent().addClass("hidden");

						$('#code-div').removeClass("hidden");
					}
				}
			});

			$('input:checkbox[name="color"]').on('change', function(){

				if($('input:checkbox[name="color"]:checked').length > 0){
					$('#color-table').parent().parent().removeClass("hidden");
					$('#inventory-table').parent().parent().removeClass("hidden");
					$('#inventory-table >thead >tr >td:nth-child(2)').removeClass("hidden");
					$('#inventory-table >tbody >tr >td:nth-child(2)').removeClass("hidden");

					init_inventory_table();

					$('#code-div').addClass("hidden");
				}
				else{
					$('#color-table').parent().parent().addClass("hidden");
					$('#inventory-table >thead >tr >td:nth-child(2)').addClass("hidden");
					$('#inventory-table >tbody >tr >td:nth-child(2)').addClass("hidden");
					if($('input:checkbox[name="sale-style"]:checked').length == 0){
						$('#inventory-table').parent().parent().addClass("hidden");

						$('#code-div').removeClass("hidden");
					}
				}
			});

		}

		function init_inventory_table(){

			var table_body = "";

			if($('input:checkbox[name="sale-style"]:checked').length > 0 && $('input:checkbox[name="color"]:checked').length > 0){
				$('input:checkbox[name="sale-style"]:checked').each(function(){
					var sale_style = $(this).next().text();
					$('input:checkbox[name="color"]:checked').each(function(){
						var color = $(this).next().text();
						table_body = table_body + "<tr><td>"+ sale_style +"</td><td>"+ color +"</td><td class='hidden'><input type='text' size='5' data-alert='产品库存不能为空'><span name='inventory-unit'>"+ $('span[name=inventory-unit]:last').text() +"</span></td><td><input type='text' size='20'></td></tr>";
					});
				});
			}
			else if($('input:checkbox[name="sale-style"]:checked').length > 0){
				$('input:checkbox[name="sale-style"]:checked').each(function(){
					var sale_style = $(this).next().text();
					table_body = table_body + "<tr><td>"+ sale_style +"</td><td class='hidden'></td><td class='hidden'><input type='text' size='5' data-alert='产品库存不能为空'><span name='inventory-unit'>"+ $('span[name=inventory-unit]:last').text() +"</span></td><td><input type='text' size='20'></td></tr>";
				});
			}
			else if($('input:checkbox[name="color"]:checked').length > 0){
				$('input:checkbox[name="color"]:checked').each(function(){
					var color = $(this).next().text();
					table_body = table_body + "<tr><td class='hidden'></td><td>"+ color +"</td><td class='hidden'><input type='text' size='5' data-alert='产品库存不能为空'><span name='inventory-unit'>"+ $('span[name=inventory-unit]:last').text() +"</span></td><td><input type='text' size='20'></td></tr>";
				});
			}

			$("#inventory-table >tbody").html(table_body);

			var trs = $("#inventory-table").find("tbody tr");

			if(!(req.stocks.length == 1 && (req.stocks[0][0] == "" && req.stocks[0][1] == ""))){
				$.each(req.stocks, function(i, stock){
					$.each(trs, function(j, tr){
						if(stock[0] == $($(tr).find("td")[0]).text() && stock[1] == $($(tr).find("td")[1]).text()){
							$($(tr).find("input")[0]).val(stock[2]);
							$($(tr).find("input")[1]).val(stock[3]);
						}
					});
				});
			}
};

$("#product-volume-div input").on("focusout", function(){
	var length = $("#product-volume-div input:nth-child(1)").val();
	var width = $("#product-volume-div input:nth-child(3)").val();
	var hight = $("#product-volume-div input:nth-child(5)").val();
	if(!length){
		length = 0;
	}
	if(!width){
		width = 0;
	}
	if(!hight){
		hight = 0;
	}
	$("#product-volume").text(length * width * hight);
});

function init_group_select(){
	$.ajax({
		type: 'POST',
		url: "select",
		success: function(nodes){
			var html = "<option value=''>---请选择---</option>";
			$.each(nodes, function(i, firstnode){
				html += "<optgroup label='" + firstnode.group + "'>";
				$.each(firstnode.data, function(j, secondnode){
					html += "<option value='"+ secondnode.groupid +"'>" + secondnode.group + "</option>";
				});
				html += "</optgroup>";
			});

			$("#product-group-selecter").html(html);

			$('#product-group-selecter').selectpicker('refresh');
		},
		async:false
	});
}

function init_image_fileinput(initialPreview, initialPreviewConfig){
	$("#product-image-uploader").fileinput({
		uploadUrl: "image/upload",
		uploadAsync: false,
		maxFileCount: 6,
		overwriteInitial: false,
		initialPreviewCount: 6,
		validateInitialCount: true,
		showPreview: true,
		previewFileType: "image",
		allowedFileTypes: ['image'],
		allowedFileExtensions: ['jpeg', 'jpg', 'jpe'],
		defaultPreviewContent: "<label class='origin'><img data-src='holder.js/160x160?text=No Photo'></label><label class='origin'><img data-src='holder.js/160x160?text=No Photo'></label><label class='origin'><img data-src='holder.js/160x160?text=No Photo'></label><label class='origin'><img data-src='holder.js/160x160?text=No Photo'></label><label class='origin'><img data-src='holder.js/160x160?text=No Photo'></label><label class='origin'><img data-src='holder.js/160x160?text=No Photo'></label>",
		initialPreview:initialPreview,
		initialPreviewConfig: initialPreviewConfig,
		layoutTemplates: {
			main1: 
			'{preview}\n' +
			'<div class="input-group {class} hide">\n' +
			'   {caption}\n' +
			'   <div class="input-group-btn hide">\n' +
			'       {remove}\n' +
			'       {cancel}\n' +
			'       {upload}\n' +
			'       {browse}\n' +
			'   </div>\n' +
			'</div>\n',
			preview: 	
			'<div class="file-preview {class}">\n' +
			'	<div class="picture">\n' + 
			'		<a href="javascript:void(0)" name="browse">从我的电脑选取</a>\n'+
			'		<a href="javascript:void(0)" name="delete">全部删除</a>\n'+
			'	</div>\n'+
			'   <div class="{dropClass}">\n' +
			'   <div class="file-preview-thumbnails">\n' +
			'   </div>\n' +
			'   <div class="clearfix"></div>' +
			'   <div class="file-preview-status text-center text-success"></div>\n' +
			'   <div class="kv-fileinput-error"></div>\n' +
			'   </div>\n' +
			'</div>\n',
			footer: 
			'<div class="file-thumbnail-footer">\n' +
			'    {actions}\n' +
			'</div>\n',
			actions: 
			'<div class="file-actions">\n' +
			'    <div class="file-footer-buttons">\n' +
			'        {delete}' +
			'    </div>\n' +
			'    <div class="clearfix"></div>\n' +
			'</div>\n',
		}
	});
}

$(".picture >a[name='browse']").click(function(){
	$('#product-image-uploader').trigger('click');
});

$(".picture >a[name='delete']").click(function(){
	$('#product-image-uploader').fileinput('clear');
});

$('#product-image-uploader').on('filebatchuploadsuccess', function(event, data) {
	var pics = data.response;

	product_data(pics);
});

$("#product-submit").click(function(){

	if(validate()){
		return;
	}

	$('#product-image-uploader').fileinput('upload');

	if($('#product-image-uploader').prop('files').length == 0){
		product_data();
	}
});

function showbootbox(sel, msg){
	sel.focus();
	webix.message({
		type:"default", 
		text:msg,
		expire:3000
	});
}

function validate(){
	var checknull = false;

	$.each($("[data-alert]:visible"), function(i, sel){
		if(!$(sel).val()){
			checknull = true;
			showbootbox($(sel), $(sel).attr("data-alert"));
		}
	});

	return checknull;
}

function validate_stock(ostks, stks){
	var los = [];
	$.each(ostks, function(i, ostk){
		los.push(ostk[0] + ostk[1]);
	});

	if(los.length==1 && los[0]==""){
		return true;
	}

	var ls = [];
	$.each(stks, function(i, stk){
		ls.push(stk[0] + stk[1]);
	});

	var check = true;
	$.each(los, function(i, os){
		if(check && $.inArray(os, ls) == -1){
			check = false;
		}	
	});

	if(!check){
		return confirm("检测到有产品条目被删除了，如果被删除的条目上还有库存，则库存数目会一起删除，是否继续？");
	}
	else{
		return true;
	}
}

function product_data(){

	var pics = arguments[0];

	var title = $('#product-title-input').val();

	var keyword = $('#product-keyword-input').val();

	var more_keyword_1 = $('#product-more-keyword-input-1').val();

	var more_keyword_2 = $('#product-more-keyword-input-2').val();

	var measure_unit = $('#product-measure-unit-select').val();

	var sale_type;

	var num_per_package = "";
	if($('#product-sale-type-per-unit').is(':checked')){
		sale_type = "by-unit";
	}
	else{
		sale_type = "by-package";
		num_per_package = $('#product-sale-type-num-per-package').val();
	}	

	var pic_files = [];
	if(pics){
		pic_files = pics;
	}

	var sale_styles = {};
	$.each($('#sale-style-table:visible tbody tr.collapse.in'), function(i, tr){
		var name = $(tr).find('td:nth-child(1)').text();
		var value = $(tr).find('td:nth-child(2) >input').val();

		sale_styles[name] = value;
	});

	var colors = {};
	$.each($('#color-table:visible tbody tr.collapse.in'), function(i, tr){
		var name = $(tr).find('td:nth-child(1)').text();
		var value = $(tr).find('td:nth-child(2) >input').val();

		colors[name] = value;
	});

	var inventories = [];

	$.each($('#inventory-table:visible >tbody >tr'), function(i, tr){
		var inventory = [];

		var first = $(tr).find('td:nth-child(1)');
		if(first.is(":visible")){
			inventory.push(first.text());
		}
		else{
			inventory.push('');
		}

		var second = $(tr).find('td:nth-child(2)');
		if(second.is(":visible")){
			inventory.push(second.text());
		}
		else{
			inventory.push('');
		}

		var fr = $(tr).find('td:nth-child(3) >input').val();
		if(fr == ""){
			fr = 0;
		}

		inventory.push(fr);
		inventory.push($(tr).find('td:nth-child(4) >input').val());

		inventories[i] = inventory;
	});

	var inventory = 0;
	if($('#product-inventory-input:visible').length){
		inventory = $('#product-inventory-input').val();
	}
	
	var code = "";
	if($('#product-code-input:visible')){
		code = $('#product-code-input').val();
	}

	var weight = parseInt($('#product-weight-input').val());

	var custom_weight = [];

	if($('#custom-weight-check').is(':checked')){

		custom_weight[0] = parseInt($('#product-custom-weight-input-1').val());

		custom_weight[1] = parseInt($('#product-custom-weight-input-2').val());

		custom_weight[2] = parseInt($('#product-custom-weight-input-3').val());

	}
	var package_size = [];

	package_size[0] = parseInt($('#product-package-length-input').val());

	package_size[1] = parseInt($('#product-package-width-input').val());

	package_size[2] = parseInt($('#product-package-height-input').val());

	var group_id = $('#product-group-selecter').val();

	var attrs = {};
	$.each($('td.attr-name'), function(i, namesel){
		var name;
		if($(namesel).children().length){
			name = $(namesel).children().val().trim();
		}
		else{
			name = $(namesel).text().trim();
		}

		var valsel = $(this).next('.attr-value');
		
		var type = valsel.attr('data-type');

		var value;

		if(type == 'text'){
			value = valsel.text().trim();
		}
		else if(type == 'select'){
			value = valsel.find('select').val().trim();
		}
		else if(type == 'check'){
			value = [];
			$.each(valsel.find('input[type="checkbox"]:checked'), function(i, checkbox){
				value.push($(checkbox).next().text().trim());
			});
		}
		else if(type == 'input'){
			value = valsel.find('input[type="text"]').val().trim();
		}

		attrs[name] = value;
	});

	var cattrs = {};
	$.each($('span.attr-name'), function(i, namesel){
		var name;
		if($(namesel).children().length){
			name = $(namesel).children().val().trim();
		}
		else{
			name = $(namesel).text().trim();
		}

		var valsel = $(this).next('.attr-value');
		
		var value = valsel.find('input[type="text"]').val().trim();

		cattrs[name] = value;
	});

	var type = $('#choose-text').text().trim();

	var pjson = {};

	pjson['attrs'] = attrs;
	pjson['cattrs'] = cattrs;

	pjson['title'] = title;
	pjson['keyword'] = keyword;
	pjson['morekeyword1'] = more_keyword_1;
	pjson['morekeyword2'] = more_keyword_2;
	pjson['measureunit'] = measure_unit;
	pjson['saletype'] = sale_type;
	pjson['numofpackage'] = num_per_package;

	pjson['salestyles'] = sale_styles;
	pjson['colors'] = colors;
	
	pjson['weight'] = weight;
	pjson['customweight'] = custom_weight;
	pjson['packagesize'] = package_size;
	pjson['groupid'] = group_id;

	var stocks = [];

	if(!$.isEmptyObject(sale_styles) || !$.isEmptyObject(colors)){
		stocks = inventories;
	}else{
		stocks.push(['', '', inventory, code]);		
	}

	/*if(!validate_stock(req.stocks, stocks)){
		return false;
	}*/

	var product = {};

	product['type'] = type;
	product['title'] = title;
	product['gid'] = group_id;
	product['pictures'] = pic_files;
	product['json'] = JSON.stringify(pjson);
	product['stocks'] = stocks;

	var json = JSON.stringify(product);

	var data = {product: json};
	if(req.pid){
		data.productId = req.pid;
	}

	$.post("submit", data, function(result){
		if(result == "success"){
			window.location.href="../product";
		}
	});
}

});

</script>
</body>
</html>
</page:applyDecorator>
