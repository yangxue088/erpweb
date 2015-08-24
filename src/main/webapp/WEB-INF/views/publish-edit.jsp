<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<script type="text/javascript" src="<c:url value="/resources/holderjs/js/holder.js" />"></script>

	<style type="text/css">
	.scrollable {
		height: 300px;
		overflow: auto;
		margin-bottom: 10px;
	}

	#choose-text{
		color: #7A2D01;
	}

	#edit-panel{
		border: hidden;
	}

	#edit-panel .panel-body .row{
		margin-bottom: 10px;
	}

	#edit-panel .panel-body .row >div >label{
		font-weight: 300;
	}

	#edit-panel .panel-body .row .col-sm-2{
		text-align: right;
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

	.custom-attr{
		padding-left: 150px;
	}

	.picture{
		border: 1px solid #CCC;
		padding: 10px;
	}

	.picture >div >a{
		margin-left: 15px;
	}

	.picture >div .thumbnail{
		margin-bottom: 0px;
	}

	.picture >div >label{
		margin-left: 15px;
		margin-bottom: 0px;
	}

	</style>

	<div id="menupanel" class="panel panel-primary">
		<div class="panel-heading">
			<h2 class="panel-title"><strong>发布产品</strong></h2>
		</div>
		<div class="panel-body">
			<div>
				您当前选择的类目：<span id="choose-text">${choosetext}</span>
			</div>
		</div>
	</div>

	<div id="edit-panel" class="panel panel-primary hidden">
		<div class="panel-heading">
			<h2 class="panel-title"><strong>1. 产品基本信息</strong></h2>
		</div>
		<div class="panel-body">

			<div id="base-attr-div">
			</div>

			<div class="row">
				<div class="col-sm-2">
					<label>产品标题:</label>
				</div>
				<div class="col-sm-10">
					<input type="text">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>产品关键词:</label>
				</div>
				<div class="col-sm-10">
					<input type="text">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>更多关键词:</label>
				</div>
				<div class="col-sm-10">
					<span>
						<input type="text">
					</span>
					<span>
						<input type="text">
					</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>更多关键词:</label>
				</div>
				<div class="col-sm-10">
					<div class="picture">
						<div>
							<a href="#">从我的电脑选取</a>
							<a href="#">全部删除</a>
						</div>
						<hr class="dotten">
						<div>
							<label>
								<a href="#" class="thumbnail">
									<img data-src="holder.js/112x112?text=No Photo">
								</a>
							</label>
							<label>
								<a href="#" class="thumbnail">
									<img data-src="holder.js/112x112?text=No Photo">
								</a>
							</label>
							<label>
								<a href="#" class="thumbnail">
									<img data-src="holder.js/112x112?text=No Photo">
								</a>
							</label>
							<label>
								<a href="#" class="thumbnail">
									<img data-src="holder.js/112x112?text=No Photo">
								</a>
							</label>
							<label>
								<a href="#" class="thumbnail">
									<img data-src="holder.js/112x112?text=No Photo">
								</a>
							</label>
							<label>
								<a href="#" class="thumbnail">
									<img data-src="holder.js/112x112?text=No Photo">
								</a>
							</label>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>最小计量单位:</label>
				</div>
				<div class="col-sm-10">
					<select>
						<option>件/个(piece/pieces)</option>
						<option>包(pack/packs)</option>
						<option>双(pair)</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label>销售方式:</label>
				</div>
				<div class="col-sm-10">
					<label>
						<input type="radio">
						<span>按磅 (pound)出售</span>
					</label>
					<label>
						<input type="radio">
						<span>打包出售</span>
					</label>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {

	});

</script>
</body>
</html>