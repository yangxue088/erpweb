<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

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

	</style>

	<div id="menupanel" class="panel panel-primary">
		<div class="panel-heading">
			<h2 class="panel-title"><strong>发布产品</strong></h2>
		</div>
		<div class="panel-body">
			<div id="menulist">
				<div class="row">
					<div class="col-sm-12">
						<pre><strong>点击类目进行选择</strong></pre>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<div id="first-menu" class="list-group scrollable">
							<a href="javascript:void(0)" class="list-group-item">
								<span class="badge glyphicon glyphicon-menu-right"> </span>
								电话和通讯
							</a>
							<a href="javascript:void(0)" class="list-group-item">
								<span class="badge glyphicon glyphicon-menu-right"> </span>
								旅游及度假
							</a>
						</div>
					</div>
					<div class="col-sm-3">
						<div id="second-menu" class="list-group scrollable">
						</div>
					</div>
					<div class="col-sm-3">
						<div id="third-menu" class="list-group scrollable">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div id="showdiv" class="alert alert-info" role="alert">
							您当前选择的类目：<span id="choose-text"></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<button id="publishbtn" type="button" class="btn btn-primary btn-lg btn-block" disabled="disabled">发布产品</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {

		$('#first-menu').on('click', '.list-group-item', function () {
			$('#second-menu').empty();
			$('#third-menu').empty();

			var name = $(this).text();
			$.post("publish/list", { level: 1, name: name.trim() }, function(data){
				var html = '';
				$.each(data, function(i, menu){
					if(menu.hasSon){
						html = html + ('<a href="javascript:void(0)" class="list-group-item"><span class="badge glyphicon glyphicon-menu-right"> </span>' + menu.name + '</a>');
					}else{
						html = html + ('<a href="javascript:void(0)" class="list-group-item">' + menu.name + '</a>');
					}
				});
				$('#second-menu').html(html);
			});
		});

		$('#second-menu').on('click', '.list-group-item', function () {
			$('#third-menu').empty();

			var name = $(this).text();
			$.post("publish/list", { level: 2, name: name.trim() }, function(data){
				var html = '';
				$.each(data, function(i, menu){
					if(menu.hasSon){
						html = html + ('<a href="javascript:void(0)" class="list-group-item"><span class="badge glyphicon glyphicon-menu-right"> </span>' + menu.name + '</a>');
					}else{
						html = html + ('<a href="javascript:void(0)" class="list-group-item">' + menu.name + '</a>');
					}
				});
				$('#third-menu').html(html);
			});
		});

		$('.list-group').on('click', '.list-group-item', function () {
			$(this).siblings().removeClass('active');
			$(this).addClass('active');

			var first = $('#first-menu .active').text().trim();
			var second = $('#second-menu .active').text().trim();
			var third = $('#third-menu .active').text().trim();

			var text = first;
			if(second){
				text = text + " > " + second;
			}
			if(third){
				text = text + " > " + third;
			}

			$('#choose-text').html(text);

			if(third){
				$('#publishbtn').removeAttr('disabled');
			}
			else if(second){
				if($('#second-menu .active:has(span)').length > 0){
					$('#publishbtn').attr('disabled', 'disabled');
				}else{
					$('#publishbtn').removeAttr('disabled');
				}
			}
			else{
				$('#publishbtn').attr('disabled', 'disabled');
			}
		});

		$('#publishbtn').on('click', function(){
			window.location.href="publish/edit?text=" + $('#choose-text').text().trim();
		});

	});

</script>
</body>
</html>